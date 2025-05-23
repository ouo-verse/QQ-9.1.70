package com.tencent.smtt.export.external.interfaces;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface DownloadListener {
    void onDownloadStart(String str, String str2, String str3, String str4, long j3);

    void onDownloadStart(String str, String str2, byte[] bArr, String str3, String str4, String str5, long j3, String str6, String str7);

    void onDownloadVideo(String str, long j3, int i3);
}
