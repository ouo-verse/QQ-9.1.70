package com.tencent.aelight.camera.api;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import hs.b;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IWinkVideoExporter extends QRouteApi {
    public static final int FPS_24 = 24;
    public static final int FPS_25 = 25;
    public static final int FPS_30 = 30;
    public static final int FPS_50 = 50;
    public static final int FPS_60 = 60;
    public static final int LEVEL_1080P = 300;
    public static final int LEVEL_2K = 400;
    public static final int LEVEL_480P = 100;
    public static final int LEVEL_4K = 500;
    public static final int LEVEL_540P = 150;
    public static final int LEVEL_720P = 200;
    public static final int RET_CODE_LOAD_SO_FAIL = -1000;
    public static final int RET_CODE_SDK_UNKNOW_FAIL = -1001;
    public static final int VIDEO_BITRATE_12M = 12582912;
    public static final int VIDEO_BITRATE_16M = 16777216;
    public static final int VIDEO_BITRATE_1M = 1048576;
    public static final int VIDEO_BITRATE_2M = 2097152;
    public static final int VIDEO_BITRATE_3M = 3145728;
    public static final int VIDEO_BITRATE_4M = 4194304;
    public static final int VIDEO_BITRATE_5M = 5242880;
    public static final int VIDEO_BITRATE_8M = 8388608;

    @Deprecated
    void addListener(String str, b bVar);

    void cancelComposeMission(String str);

    void cancelCompressMission(String str);

    void close();

    LocalMediaInfo getExportVideoInfo(String str);

    void init();

    @Deprecated
    void removeListener(b bVar);

    void removeListener(String str);

    void startComposeMission(String str, b bVar, int i3, int i16, int i17, String str2, boolean z16);

    void startComposeMission(String str, b bVar, boolean z16);

    String startCompressMission(LocalMediaInfo localMediaInfo, b bVar, int i3, int i16, int i17, String str);
}
