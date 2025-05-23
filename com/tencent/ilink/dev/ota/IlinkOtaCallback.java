package com.tencent.ilink.dev.ota;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface IlinkOtaCallback {
    void OnCheckupdateComplete(byte[] bArr);

    void OnDownloadComplete(String str, String str2);

    void OnDownloadError(String str, int i3);

    void OnDownloadProgress(String str, double d16, double d17);
}
