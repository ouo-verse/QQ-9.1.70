package com.tencent.mobileqq.transfile.quic.report;

/* compiled from: P */
/* loaded from: classes19.dex */
public interface DownloadListener {
    boolean isCanceled();

    void onDownloadFailed(String str, QuicNetReport quicNetReport);

    void onDownloadProgress(String str, long j3, long j16);

    void onDownloadSucceed(String str, QuicNetReport quicNetReport);

    void setCancel(boolean z16);
}
