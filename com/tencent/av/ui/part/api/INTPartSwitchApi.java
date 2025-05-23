package com.tencent.av.ui.part.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface INTPartSwitchApi extends QRouteApi {
    boolean isGInviteUseNT();
}
