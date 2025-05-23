package com.tencent.midas.comm;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* loaded from: classes9.dex */
public class APBeanUtil {
    public static void copyProperties(Object obj, Object obj2) {
        try {
            copyPropertiesExclude(obj, obj2, null, true);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void copyPropertiesExclude(Object obj, Object obj2, String[] strArr, boolean z16) throws Exception {
        List list;
        Method[] declaredMethods;
        Method[] declaredMethods2;
        Object invoke;
        if (strArr != null && strArr.length > 0) {
            list = Arrays.asList(strArr);
        } else {
            list = null;
        }
        if (z16) {
            declaredMethods = obj.getClass().getMethods();
            declaredMethods2 = obj2.getClass().getMethods();
        } else {
            declaredMethods = obj.getClass().getDeclaredMethods();
            declaredMethods2 = obj2.getClass().getDeclaredMethods();
        }
        for (Method method : declaredMethods) {
            String name = method.getName();
            if (name.contains("get") && (list == null || !list.contains(name.substring(3).toLowerCase()))) {
                Method findMethodByName = findMethodByName(declaredMethods2, "set" + name.substring(3));
                if (findMethodByName != null && (invoke = method.invoke(obj, new Object[0])) != null && (!(invoke instanceof Collection) || ((Collection) invoke).size() > 0)) {
                    findMethodByName.invoke(obj2, invoke);
                }
            }
        }
    }

    public static void copyPropertiesInclude(Object obj, Object obj2, String[] strArr, boolean z16) throws Exception {
        Method[] declaredMethods;
        Method[] declaredMethods2;
        Object invoke;
        if (strArr != null && strArr.length > 0) {
            List asList = Arrays.asList(strArr);
            if (z16) {
                declaredMethods = obj.getClass().getMethods();
                declaredMethods2 = obj2.getClass().getMethods();
            } else {
                declaredMethods = obj.getClass().getDeclaredMethods();
                declaredMethods2 = obj2.getClass().getDeclaredMethods();
            }
            for (Method method : declaredMethods) {
                String name = method.getName();
                if (name.contains("get")) {
                    String substring = name.substring(3);
                    if (asList.contains(substring.substring(0, 1).toLowerCase() + substring.substring(1))) {
                        Method findMethodByName = findMethodByName(declaredMethods2, "set" + name.substring(3));
                        if (findMethodByName != null && (invoke = method.invoke(obj, new Object[0])) != null && (!(invoke instanceof Collection) || ((Collection) invoke).size() > 0)) {
                            findMethodByName.invoke(obj2, invoke);
                        }
                    }
                }
            }
        }
    }

    public static Method findMethodByName(Method[] methodArr, String str) {
        for (int i3 = 0; i3 < methodArr.length; i3++) {
            if (methodArr[i3].getName().equals(str)) {
                return methodArr[i3];
            }
        }
        return null;
    }
}
