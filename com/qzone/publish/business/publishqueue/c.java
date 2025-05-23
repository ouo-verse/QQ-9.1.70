package com.qzone.publish.business.publishqueue;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface c {
    int getState();

    void onStateChanged(int i3);

    void onUpdateDataSize(long j3, long j16);

    void onUploadError(Object obj, int i3, String str);

    void onUploadSucceed(Object obj);

    void resetTime();

    void setTime(long j3);
}
