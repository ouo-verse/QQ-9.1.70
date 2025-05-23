package org.aspectj.internal.lang.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.StringTokenizer;
import org.aspectj.lang.reflect.AjTypeSystem;

/* compiled from: P */
/* loaded from: classes29.dex */
public class StringToType {
    public static Type[] commaSeparatedListToTypeArray(String str, Class cls) throws ClassNotFoundException {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        Type[] typeArr = new Type[stringTokenizer.countTokens()];
        int i3 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            typeArr[i3] = stringToType(stringTokenizer.nextToken().trim(), cls);
            i3++;
        }
        return typeArr;
    }

    private static Type makeParameterizedType(String str, Class cls) throws ClassNotFoundException {
        int indexOf = str.indexOf(60);
        final Class<?> cls2 = Class.forName(str.substring(0, indexOf), false, cls.getClassLoader());
        final Type[] commaSeparatedListToTypeArray = commaSeparatedListToTypeArray(str.substring(indexOf + 1, str.lastIndexOf(62)), cls);
        return new ParameterizedType() { // from class: org.aspectj.internal.lang.reflect.StringToType.1
            @Override // java.lang.reflect.ParameterizedType
            public Type[] getActualTypeArguments() {
                return commaSeparatedListToTypeArray;
            }

            @Override // java.lang.reflect.ParameterizedType
            public Type getOwnerType() {
                return cls2.getEnclosingClass();
            }

            @Override // java.lang.reflect.ParameterizedType
            public Type getRawType() {
                return cls2;
            }
        };
    }

    public static Type stringToType(String str, Class cls) throws ClassNotFoundException {
        try {
            if (str.indexOf("<") == -1) {
                return AjTypeSystem.getAjType(Class.forName(str, false, cls.getClassLoader()));
            }
            return makeParameterizedType(str, cls);
        } catch (ClassNotFoundException unused) {
            TypeVariable[] typeParameters = cls.getTypeParameters();
            for (int i3 = 0; i3 < typeParameters.length; i3++) {
                if (typeParameters[i3].getName().equals(str)) {
                    return typeParameters[i3];
                }
            }
            throw new ClassNotFoundException(str);
        }
    }
}
