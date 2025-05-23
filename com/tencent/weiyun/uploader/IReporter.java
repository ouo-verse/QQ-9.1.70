package com.tencent.weiyun.uploader;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IReporter {
    void handleReport(UploadResponse uploadResponse);

    boolean onlyReportLast();
}
