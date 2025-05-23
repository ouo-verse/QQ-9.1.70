package com.tencent.mobileqq.emoticonview.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IPanelPopupApi extends QRouteApi {
    IPanelDependListener createPanelDependListener();
}
