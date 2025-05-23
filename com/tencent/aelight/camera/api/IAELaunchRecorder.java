package com.tencent.aelight.camera.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAELaunchRecorder extends QRouteApi {
    public static final String MILESTONE_CLICK = "userClick";
    public static final String MILESTONE_FILTER_MGR_DRAW_BEGIN = "filterMgrDraw-begin";
    public static final String MILESTONE_FILTER_MGR_DRAW_END = "filterMgrDraw-end";
    public static final String MILESTONE_LAUNCHER_BEGIN = "AECameraLauncher---launchAECameraUnit-begin";
    public static final String MILESTONE_LAUNCHER_END = "AECameraLauncher---launchAECameraUnit-end";
    public static final String MILESTONE_START_ACTIVITY = "startActivityForResult";

    void beginSession();

    void endSession();

    void milestone(String str);

    void oldAioDrawFirstFrameDone();

    void print(boolean z16);
}
