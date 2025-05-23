package com.tencent.mobileqq.doodle;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IDoodleXPanelContainer extends QRouteApi {
    int getExternalPanelheight();

    int getXPanelContainerNONE();

    void setExternalPanelheight(int i3);
}
