package com.tencent.commonsdk.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public class StringUtils {
    static IPatchRedirector $redirector_;
    static volatile boolean reflactCharArrayResult;
    static volatile boolean reflactDataResult;
    static Field sCountField;
    static Field sValueField;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13187);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        sValueField = null;
        sCountField = null;
        reflactDataResult = true;
        reflactCharArrayResult = true;
    }

    public StringUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

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
