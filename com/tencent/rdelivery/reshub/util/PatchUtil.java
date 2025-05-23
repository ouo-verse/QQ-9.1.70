package com.tencent.rdelivery.reshub.util;

/* loaded from: classes34.dex */
public class PatchUtil {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f364581a;

    static {
        try {
            System.loadLibrary("bsdiff");
            f364581a = true;
        } catch (Throwable th5) {
            d.a("ReshubPurePatchUtil", "bsdiff loadLibrary failed", th5);
            f364581a = false;
            com.tencent.rdelivery.reshub.processor.k.f364556a.a();
        }
    }

    public static boolean a(String str, String str2, String str3) {
        if (!f364581a) {
            d.a("ReshubPurePatchUtil", "tryPatch bsdiff\u5e93\u52a0\u8f7d\u5931\u8d25\uff0c\u65e0\u6cd5\u5408\u5e76", null);
            return false;
        }
        try {
            return doPatch(str, str2, str3);
        } catch (Exception e16) {
            d.a("ReshubPurePatchUtil", "tryPatch bsdiff\u5408\u5e76\u5931\u8d25", e16);
            return false;
        }
    }

    private static native boolean doPatch(String str, String str2, String str3);
}
