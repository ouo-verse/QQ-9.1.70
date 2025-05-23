package com.tencent.mobileqq.activity.aio.audiopanel;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IAudioPanelPresenterCreater extends QRouteApi {
    h createCircleProcessViewPresenter(com.tencent.mvp.c cVar);

    i createCommonRecordSoundPanelPresenter(j jVar);

    k createThemeViewPresenter(com.tencent.mvp.c cVar);
}
