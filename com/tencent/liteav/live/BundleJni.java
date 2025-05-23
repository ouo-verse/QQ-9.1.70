package com.tencent.liteav.live;

import android.os.Bundle;

/* compiled from: P */
/* loaded from: classes7.dex */
public class BundleJni {
    public static Bundle appendBoolean(Bundle bundle, String str, boolean z16) {
        bundle.putBoolean(str, z16);
        return bundle;
    }

    public static Bundle appendBundle(Bundle bundle, String str, Bundle bundle2) {
        bundle.putBundle(str, bundle2);
        return bundle;
    }

    public static Bundle appendByteArray(Bundle bundle, String str, byte[] bArr) {
        bundle.putByteArray(str, bArr);
        return bundle;
    }

    public static Bundle appendDouble(Bundle bundle, String str, double d16) {
        bundle.putDouble(str, d16);
        return bundle;
    }

    public static Bundle appendFloat(Bundle bundle, String str, float f16) {
        bundle.putFloat(str, f16);
        return bundle;
    }

    public static Bundle appendInt(Bundle bundle, String str, int i3) {
        bundle.putInt(str, i3);
        return bundle;
    }

    public static Bundle appendLong(Bundle bundle, String str, long j3) {
        bundle.putLong(str, j3);
        return bundle;
    }

    public static Bundle appendString(Bundle bundle, String str, String str2) {
        bundle.putString(str, str2);
        return bundle;
    }

    public static Bundle getBundle() {
        return new Bundle();
    }
}
