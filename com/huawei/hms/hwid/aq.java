package com.huawei.hms.hwid;

import android.os.SystemProperties;
import android.text.TextUtils;
import com.huawei.hms.framework.common.EmuiUtil;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes2.dex */
public class aq {

    /* renamed from: a, reason: collision with root package name */
    private static int f37314a = -1;

    /* renamed from: b, reason: collision with root package name */
    private static int f37315b;

    static {
        b();
    }

    public static boolean a() {
        if (f37315b >= 21) {
            return true;
        }
        return false;
    }

    private static void b() {
        int d16 = d();
        f37315b = d16;
        if (d16 >= 17) {
            f37314a = 90;
        }
        if (d16 >= 11) {
            f37314a = 50;
        } else if (d16 >= 10) {
            f37314a = 41;
        } else if (d16 >= 9) {
            f37314a = 40;
        } else if (d16 >= 8) {
            f37314a = 31;
        } else if (d16 >= 7) {
            f37314a = 30;
        }
        if (f37314a == -1) {
            c();
        }
    }

    private static void c() {
        try {
            String str = (String) SystemProperties.class.getDeclaredMethod("get", String.class).invoke(SystemProperties.class, "ro.build.version.emui");
            if (str != null) {
                if (str.contains("EmotionUI_3.0")) {
                    f37314a = 30;
                } else if (str.contains("EmotionUI_3.1")) {
                    f37314a = 31;
                } else if (str.contains("EmotionUI_4.0")) {
                    f37314a = 40;
                } else if (str.contains("EmotionUI_4.1")) {
                    f37314a = 41;
                } else if (str.contains("EmotionUI_5.0")) {
                    f37314a = 50;
                }
            }
        } catch (RuntimeException unused) {
            as.d("EmuiUtil", "RuntimeException getEmuiType.", true);
        } catch (Exception unused2) {
            as.d("EmuiUtil", "getEmuiType Exception.", true);
        }
    }

    private static int d() {
        Object a16 = a.a(EmuiUtil.BUILDEX_VERSION, EmuiUtil.EMUI_SDK_INT);
        if (a16 != null) {
            try {
                f37315b = ((Integer) a16).intValue();
            } catch (ClassCastException unused) {
                as.d("EmuiUtil", "getEMUIVersionCode is not a number", true);
            }
        }
        return f37315b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a {
        public static Class<?> a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!EmuiUtil.BUILDEX_VERSION.equals(str) && !EmuiUtil.IMMERSION_STYLE.equals(str)) {
                return null;
            }
            try {
                return Class.forName(str);
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }

        public static Object a(String str, String str2) {
            Class<?> a16 = a(str);
            if (a16 == null || TextUtils.isEmpty(str2) || !EmuiUtil.BUILDEX_VERSION.equals(str) || !EmuiUtil.EMUI_SDK_INT.equals(str2)) {
                return null;
            }
            try {
                Field declaredField = a16.getDeclaredField(str2);
                AccessibleObject.setAccessible(new Field[]{declaredField}, true);
                return declaredField.get(a16);
            } catch (IllegalAccessException unused) {
                as.c("ReflectionUtils", "Exception in getFieldObj :: IllegalAccessException", true);
                return null;
            } catch (IllegalArgumentException unused2) {
                as.c("ReflectionUtils", "Exception in getFieldObj :: IllegalArgumentException", true);
                return null;
            } catch (NoSuchFieldException unused3) {
                as.c("ReflectionUtils", "Exception in getFieldObj :: NoSuchFieldException", true);
                return null;
            } catch (SecurityException unused4) {
                as.b("ReflectionUtils", "not security int method getStaticFieldObj", true);
                return null;
            }
        }
    }
}
