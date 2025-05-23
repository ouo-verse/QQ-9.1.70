package com.tencent.qqmini.sdk.monitor.common;

import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes23.dex */
public class StringUtils {
    static volatile boolean reflactCharArrayResult = true;
    static volatile boolean reflactDataResult = true;
    static Field sCountField;
    static Field sValueField;

    public static char[] getStringValue(StringBuilder sb5) {
        try {
            if (sValueField == null) {
                Field declaredField = StringBuilder.class.getSuperclass().getDeclaredField("value");
                sValueField = declaredField;
                declaredField.setAccessible(true);
            }
            return (char[]) sValueField.get(sb5);
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
            return null;
        } catch (IllegalArgumentException e17) {
            e17.printStackTrace();
            return null;
        } catch (NoSuchFieldException e18) {
            e18.printStackTrace();
            return null;
        }
    }

    public static String newStringWithData(char[] cArr) {
        try {
            String str = new String();
            if (reflactDataResult) {
                if (sValueField == null) {
                    Field declaredField = String.class.getDeclaredField("value");
                    sValueField = declaredField;
                    declaredField.setAccessible(true);
                }
                if (sCountField == null) {
                    Field declaredField2 = String.class.getDeclaredField("count");
                    sCountField = declaredField2;
                    declaredField2.setAccessible(true);
                }
                sValueField.set(str, cArr);
                sCountField.set(str, Integer.valueOf(cArr.length));
                return str;
            }
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
        } catch (IllegalArgumentException e17) {
            e17.printStackTrace();
        } catch (NoSuchFieldException e18) {
            e18.printStackTrace();
        }
        reflactDataResult = false;
        return new String(cArr);
    }

    public static char[] reflactCharArray(String str) {
        try {
            if (reflactCharArrayResult) {
                if (sValueField == null) {
                    Field declaredField = String.class.getDeclaredField("value");
                    sValueField = declaredField;
                    declaredField.setAccessible(true);
                }
                return (char[]) sValueField.get(str);
            }
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
        } catch (IllegalArgumentException e17) {
            e17.printStackTrace();
        } catch (NoSuchFieldException e18) {
            e18.printStackTrace();
        }
        reflactCharArrayResult = false;
        return null;
    }
}
