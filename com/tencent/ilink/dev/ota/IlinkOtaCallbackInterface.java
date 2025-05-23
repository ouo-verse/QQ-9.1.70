package com.tencent.ilink.dev.ota;

/* compiled from: P */
/* loaded from: classes7.dex */
public class IlinkOtaCallbackInterface {
    public static IlinkOtaCallback callback;

    public static void OnCheckupdateComplete(byte[] bArr) {
        IlinkOtaCallback ilinkOtaCallback = callback;
        if (ilinkOtaCallback != null) {
            ilinkOtaCallback.OnCheckupdateComplete(bArr);
        }
    }

    public static void OnDownloadComplete(String str, String str2) {
        IlinkOtaCallback ilinkOtaCallback = callback;
        if (ilinkOtaCallback != null) {
            ilinkOtaCallback.OnDownloadComplete(str, str2);
        }
    }

    public static void OnDownloadError(String str, int i3) {
        IlinkOtaCallback ilinkOtaCallback = callback;
        if (ilinkOtaCallback != null) {
            ilinkOtaCallback.OnDownloadError(str, i3);
        }
    }

    public static void OnDownloadProgress(String str, double d16, double d17) {
        IlinkOtaCallback ilinkOtaCallback = callback;
        if (ilinkOtaCallback != null) {
            ilinkOtaCallback.OnDownloadProgress(str, d16, d17);
        }
    }
}
