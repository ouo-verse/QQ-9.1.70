package com.tencent.mobileqq.ptt.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IPttInfoCollector extends QRouteApi {
    public static final int CHANGE_VOICE = 4;
    public static final int PTT_DISCUSSION = 2;
    public static final int PTT_DOWNLOAD_TYPE_CHATHISTORY = 5;
    public static final int PTT_DOWNLOAD_TYPE_LOCK_WINDOW = 7;
    public static final int PTT_DOWNLOAD_TYPE_NORMAL = 1;
    public static final int PTT_DOWNLOAD_TYPE_OPENAPI_NORMAL = 3;
    public static final int PTT_DOWNLOAD_TYPE_OPENAPI_REDOWN = 4;
    public static final int PTT_DOWNLOAD_TYPE_PRE_DOWNLOADER = 6;
    public static final int PTT_DOWNLOAD_TYPE_REDOWN = 2;
    public static final int PTT_FRIENDS = 1;
    public static final int PTT_GROUP = 3;
    public static final int PTT_OTHER = 4;
    public static final int PTT_PV_DOWNLOAD = 2;
    public static final int PTT_PV_PLAY = 1;
    public static final int PTT_PV_PRODUCT_D0 = 3;
    public static final int PTT_PV_PRODUCT_F2 = 4;
    public static final int RECORD_CHANGE_VOICE = 3;
    public static final int RECORD_OFFLINE = 2;
    public static final int RECORD_STREAM = 1;
    public static final long sCostUntilPrepare = 0;

    long getsCostUntilPrepare();

    void noteOneFrameProcessed();

    void reportGcAndMemoryUse(int i3, int i16);

    void reportPTTPV(AppRuntime appRuntime, int i3, boolean z16, int i16);

    void reportPttUploadType(boolean z16, long j3, long j16, long j17);

    void reportSoundProcessCost(long j3, int i3, long j16, int i16);

    void setsCostUntilPrepare(long j3);
}
