package org.light.lightAssetKit;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.light.LightAsset;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightAssetUtils {
    private static Field[] getAllFields(Class<?> cls) {
        List<Field> allFieldsList = getAllFieldsList(cls);
        return (Field[]) allFieldsList.toArray(new Field[allFieldsList.size()]);
    }

    private static List<Field> getAllFieldsList(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        while (cls != null) {
            for (Field field : cls.getDeclaredFields()) {
                arrayList.add(field);
            }
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    public static String getAssetJsonString(LightAsset lightAsset) {
        if (lightAsset == null) {
            return null;
        }
        return lightAsset.getJsonString();
    }

    public static Object objDeepCopy(Object obj) throws InstantiationException, IllegalAccessException {
        Class<?> cls = obj.getClass();
        Object newInstance = cls.newInstance();
        for (Field field : getAllFields(cls)) {
            field.setAccessible(true);
            int modifiers = field.getModifiers();
            if (!Modifier.isStatic(modifiers) && !Modifier.isFinal(modifiers)) {
                field.setAccessible(true);
                Class<?> type = field.getType();
                if (type.isPrimitive()) {
                    field.set(newInstance, field.get(obj));
                } else if (type.isArray()) {
                    Object obj2 = field.get(obj);
                    Class<?> componentType = type.getComponentType();
                    int length = Array.getLength(obj2);
                    Object newInstance2 = Array.newInstance(componentType, length);
                    for (int i3 = 0; i3 < length; i3++) {
                        if (componentType.isPrimitive()) {
                            Array.set(newInstance2, i3, Array.get(obj2, i3));
                        } else {
                            Array.set(newInstance2, i3, objDeepCopy(Array.get(obj2, i3)));
                        }
                    }
                    field.set(newInstance, newInstance2);
                } else if (Collection.class.isAssignableFrom(type)) {
                    Collection collection = (Collection) type.newInstance();
                    for (Object obj3 : ((Collection) field.get(obj)).toArray()) {
                        collection.add(objDeepCopy(obj3));
                    }
                    field.set(newInstance, collection);
                } else {
                    field.set(newInstance, objDeepCopy(field.get(obj)));
                }
            }
        }
        return newInstance;
    }
}
