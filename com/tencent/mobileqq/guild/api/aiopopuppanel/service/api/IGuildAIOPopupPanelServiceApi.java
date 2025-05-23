package com.tencent.mobileqq.guild.api.aiopopuppanel.service.api;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import ze1.a;

@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildAIOPopupPanelServiceApi extends QRouteApi {
    int currentPopupPanelType(int i3, int i16);

    boolean markScenePopupPanelType(int i3, int i16);

    void releasePopupPanel(a<?> aVar);

    void toggleSoftKeyBoard(QBaseActivity qBaseActivity);

    boolean unMarkScenePopupPanelType(int i3, int i16);
}
