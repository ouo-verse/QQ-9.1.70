package com.tencent.aelight.camera.qqstory.api;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import qs.b;

@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IPtvTemplateManager extends QRouteApi {
    void handleGetDoodleConfig(String str, BaseQQAppInterface baseQQAppInterface);

    boolean hasDownloadFailed();

    void initLocalDoodleInfo(AppInterface appInterface, b bVar);

    boolean isDoodleConfigFileExist();
}
