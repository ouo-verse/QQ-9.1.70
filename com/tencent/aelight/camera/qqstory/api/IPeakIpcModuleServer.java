package com.tencent.aelight.camera.qqstory.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IPeakIpcModuleServer extends QRouteApi {
    public static final String NAME = "PeakIpcModuleServer";

    String ACTION_UPLOAD_ARK_VIDEO();

    String KEY_UPLOAD_ARK_RES_POSTFIX();

    String KEY_UPLOAD_ARK_VIDEO_PATH();

    String actionQcirclePickerReport();

    QIPCModule getPeakIpcModuleServerModule();
}
