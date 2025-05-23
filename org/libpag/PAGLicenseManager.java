package org.libpag;

import android.content.Context;

/* loaded from: classes29.dex */
public class PAGLicenseManager {
    public static final int LicenseResultInvalidParameter = 1;
    public static final int LicenseResultLicenseExpired = 2;
    public static final int LicenseResultSuccess = 0;

    static {
        org.extra.tools.a.b("pag");
        nativeInit();
    }

    public static int AddFileLicense(Context context, String str) {
        if (context != null) {
            context = context.getApplicationContext();
        }
        if (context == null) {
            context = org.extra.tools.a.a();
        }
        return NativeAddFileLicense(context, str);
    }

    public static native String GetSDKExpiredDate();

    public static int LoadSDKLicense(Context context, String str, String str2, String str3) {
        if (context != null) {
            context = context.getApplicationContext();
        }
        if (context == null) {
            context = org.extra.tools.a.a();
        }
        return NativeLoadSDKLicense(context, str, str2, str3);
    }

    private static native int NativeAddFileLicense(Context context, String str);

    private static native int NativeAddFileLicense(Context context, byte[] bArr);

    private static native int NativeLoadSDKLicense(Context context);

    private static native int NativeLoadSDKLicense(Context context, String str, String str2, String str3);

    private static native int NativeLoadSDKLicense(Context context, byte[] bArr, String str, String str2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Context context) {
        if (context != null) {
            context = context.getApplicationContext();
        }
        if (context == null) {
            context = org.extra.tools.a.a();
        }
        return NativeLoadSDKLicense(context);
    }

    private static native void nativeInit();

    public static int AddFileLicense(Context context, byte[] bArr) {
        if (context != null) {
            context = context.getApplicationContext();
        }
        if (context == null) {
            context = org.extra.tools.a.a();
        }
        return NativeAddFileLicense(context, bArr);
    }

    public static int LoadSDKLicense(Context context, byte[] bArr, String str, String str2) {
        if (context != null) {
            context = context.getApplicationContext();
        }
        if (context == null) {
            context = org.extra.tools.a.a();
        }
        return NativeLoadSDKLicense(context, bArr, str, str2);
    }
}
