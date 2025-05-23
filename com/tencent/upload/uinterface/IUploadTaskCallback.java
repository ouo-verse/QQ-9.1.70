package com.tencent.upload.uinterface;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IUploadTaskCallback {
    public static final int STATE_CANCEL = 5;
    public static final int STATE_CONNECTING = 4;
    public static final int STATE_FINISH = 3;
    public static final int STATE_PAUSE = 2;
    public static final int STATE_RUNNING = 1;
    public static final int STATE_UNKNOWN = -1000;
    public static final int STATE_WAITTING = 0;

    void onUploadError(AbstractUploadTask abstractUploadTask, int i3, String str);

    void onUploadProgress(AbstractUploadTask abstractUploadTask, long j3, long j16);

    void onUploadStateChange(AbstractUploadTask abstractUploadTask, int i3);

    void onUploadSucceed(AbstractUploadTask abstractUploadTask, Object obj);
}
