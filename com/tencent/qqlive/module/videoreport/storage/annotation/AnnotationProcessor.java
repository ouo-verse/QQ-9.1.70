package com.tencent.qqlive.module.videoreport.storage.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes22.dex */
public class AnnotationProcessor {
    private static volatile AnnotationProcessor sInstance;
    private final ConcurrentHashMap<Class<?>, String> mClassIdMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Class<?>, Member> mObjectIdMap = new ConcurrentHashMap<>();

    AnnotationProcessor() {
    }

    public static AnnotationProcessor getInstance() {
        if (sInstance == null) {
            synchronized (AnnotationProcessor.class) {
                if (sInstance == null) {
                    sInstance = new AnnotationProcessor();
                }
            }
        }
        return sInstance;
    }

    private Member getObjectIdMember(Class<?> cls) {
        for (Field field : cls.getDeclaredFields()) {
            if (field.isAnnotationPresent(ObjectId.class) && field.getType() == String.class) {
                return new FieldMember(field);
            }
        }
        for (Method method : cls.getMethods()) {
            if (method.isAnnotationPresent(ObjectId.class) && method.getParameterTypes().length == 0 && method.getReturnType() == String.class) {
                return new MethodMember(method);
            }
        }
        return null;
    }

    public String getClassId(Class<?> cls) {
        String value;
        if (cls != null) {
            String str = this.mClassIdMap.get(cls);
            if (str != null) {
                return str;
            }
            ClassId classId = null;
            for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                classId = (ClassId) cls2.getAnnotation(ClassId.class);
                if (classId != null) {
                    break;
                }
            }
            if (classId == null) {
                value = cls.getName();
            } else {
                value = classId.value();
            }
            this.mClassIdMap.put(cls, value);
            return value;
        }
        throw new IllegalArgumentException("Class cannot be null.");
    }

    public String getObjectId(Object obj) {
        Class<?> cls = obj.getClass();
        Member member = this.mObjectIdMap.get(cls);
        if (member != null) {
            return (String) member.getValue(obj);
        }
        Member objectIdMember = getObjectIdMember(cls);
        if (objectIdMember != null) {
            this.mObjectIdMap.put(cls, objectIdMember);
            return (String) objectIdMember.getValue(obj);
        }
        throw new IllegalArgumentException("Object does not have an object id. Please specify an object id when invoking method. Otherwise you can add @ObjectId on the field or the non-arg method which provides the object id.");
    }
}
