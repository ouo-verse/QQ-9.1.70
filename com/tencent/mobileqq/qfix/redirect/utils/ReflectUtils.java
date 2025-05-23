package com.tencent.mobileqq.qfix.redirect.utils;

import androidx.annotation.Keep;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ReflectUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Character, Class> f261899a;

    static {
        HashMap hashMap = new HashMap();
        f261899a = hashMap;
        hashMap.put('I', Integer.TYPE);
        hashMap.put('S', Short.TYPE);
        hashMap.put('B', Byte.TYPE);
        hashMap.put('C', Character.TYPE);
        hashMap.put('D', Double.TYPE);
        hashMap.put('F', Float.TYPE);
        hashMap.put('Z', Boolean.TYPE);
        hashMap.put('J', Long.TYPE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
    
        if (r7.charAt(r8) == 'L') goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
    
        if (r7.charAt(r8) == ';') goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
    
        r7 = r7.substring(r0 - 1, r8 + 1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int a(String str, int i3, List<Class> list) {
        int i16;
        String substring;
        int i17 = i3 + 1;
        char charAt = str.charAt(i3);
        Map<Character, Class> map = f261899a;
        if (map.containsKey(Character.valueOf(charAt))) {
            list.add(map.get(Character.valueOf(charAt)));
            return i17;
        }
        if (charAt == 'L') {
            i16 = i17;
            while (i16 < str.length() && str.charAt(i16) != ';') {
                i16++;
            }
            substring = str.substring(i17, i16);
        } else {
            if (charAt != '[') {
                return i17;
            }
            i16 = i17;
            while (str.charAt(i16) == '[') {
                i16++;
            }
        }
        list.add(Class.forName(substring.replace('/', '.')));
        return i16;
    }

    @Keep
    public static Object getField(Object obj, String str) {
        String[] split = str.split("#");
        return getField(obj, split[0], split[1]);
    }

    @Keep
    public static Object getStaticField(String str) {
        String[] split = str.split("#");
        return getStaticField(split[0], split[1]);
    }

    @Keep
    public static Object invokeStatic(String str, String str2, String str3, Object... objArr) {
        try {
            Class<?> cls = Class.forName(str);
            Class<?>[] a16 = a(str3);
            Method declaredMethod = cls.getDeclaredMethod(str2, a16);
            declaredMethod.setAccessible(true);
            if (a16.length == 1 && str3.charAt(1) == '[') {
                return declaredMethod.invoke(null, objArr[0]);
            }
            return declaredMethod.invoke(null, objArr);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Keep
    public static Object invokeVirtual(Object obj, String str, String str2, String str3, Object... objArr) {
        try {
            Class<?> cls = Class.forName(str);
            Class<?>[] a16 = a(str3);
            Method declaredMethod = cls.getDeclaredMethod(str2, a16);
            declaredMethod.setAccessible(true);
            if (a16.length == 1 && str3.charAt(1) == '[') {
                return declaredMethod.invoke(obj, objArr[0]);
            }
            return declaredMethod.invoke(obj, objArr);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Keep
    public static void setField(Object obj, Object obj2, String str, String str2) {
        try {
            Field declaredField = Class.forName(str).getDeclaredField(str2);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
        } catch (IllegalAccessException e17) {
            e17.printStackTrace();
        } catch (NoSuchFieldException e18) {
            e18.printStackTrace();
        }
    }

    @Keep
    public static void setStaticField(Object obj, Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(null, obj);
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
        } catch (NoSuchFieldException e17) {
            e17.printStackTrace();
        }
    }

    private static Class[] a(String str) {
        ArrayList arrayList = new ArrayList();
        char[] charArray = str.toCharArray();
        int i3 = 0;
        while (i3 < charArray.length && str.charAt(i3) != ')') {
            i3 = a(str, i3, arrayList);
        }
        return (Class[]) arrayList.toArray(new Class[0]);
    }

    @Keep
    public static Object getField(Object obj, String str, String str2) {
        try {
            Field declaredField = Class.forName(str).getDeclaredField(str2);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Keep
    public static Object getStaticField(String str, String str2) {
        return getField(null, str, str2);
    }

    @Keep
    public static void setStaticField(Object obj, String str, String str2) {
        setField(null, obj, str, str2);
    }
}
