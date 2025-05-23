package com.tencent.aelight.camera.entry.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAECameraLaunchServer extends QRouteApi {
    public static final String ACTION_MINI_LAUNCH_CAMERA_FOR_MINIAPP = "ACTION_MINI_LAUNCH_CAMERA_FOR_MINIAPP";
    public static final String ACTION_MINI_LAUNCH_CAMERA_FOR_PLAY = "ACTION_MINI_LAUNCH_CAMERA_FOR_PLAY";
    public static final String ACTION_MINI_LAUNCH_CAMERA_FOR_SIGN_IN = "ACTION_MINI_LAUNCH_CAMERA_FOR_SIGN_IN";
    public static final String NAME = "AECameraLaunchServer";

    QIPCModule getAECameraLaunchServerQIPCModule();
}
