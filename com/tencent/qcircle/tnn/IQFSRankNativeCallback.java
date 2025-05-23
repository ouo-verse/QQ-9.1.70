package com.tencent.qcircle.tnn;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IQFSRankNativeCallback {
    public static final int CODE_FATAL_ERROR = 16384;
    public static final int CODE_SUCCESS = 0;

    int attaUpload(String str);

    void errorCallback(int i3, String str);

    int getAppStatus();

    String getFilePath(String str);

    void rerankLog(String str);

    int trainSwitch();
}
