package android.os;

/* loaded from: classes.dex */
public class SystemProperties {
    public static final int PROP_NAME_MAX = 31;
    public static final int PROP_VALUE_MAX = 255;

    public static String get(String str) {
        if (str.length() <= 31) {
            return native_get(str);
        }
        throw new IllegalArgumentException("key.length > 31");
    }

    public static boolean getBoolean(String str, boolean z16) {
        if (str.length() <= 31) {
            return native_get_boolean(str, z16);
        }
        throw new IllegalArgumentException("key.length > 31");
    }

    public static int getInt(String str, int i3) {
        if (str.length() <= 31) {
            return native_get_int(str, i3);
        }
        throw new IllegalArgumentException("key.length > 31");
    }

    public static long getLong(String str, long j3) {
        if (str.length() <= 31) {
            return native_get_long(str, j3);
        }
        throw new IllegalArgumentException("key.length > 31");
    }

    public static native String native_get(String str);

    public static native String native_get(String str, String str2);

    public static native boolean native_get_boolean(String str, boolean z16);

    public static native int native_get_int(String str, int i3);

    public static native long native_get_long(String str, long j3);

    public static native void native_set(String str, String str2);

    public static void set(String str, String str2) {
        if (str.length() <= 31) {
            if (str2 != null && str2.length() > 255) {
                throw new IllegalArgumentException("val.length > 255");
            }
            native_set(str, str2);
            return;
        }
        throw new IllegalArgumentException("key.length > 31");
    }

    public static String get(String str, String str2) {
        if (str.length() <= 31) {
            return native_get(str, str2);
        }
        throw new IllegalArgumentException("key.length > 31");
    }
}
