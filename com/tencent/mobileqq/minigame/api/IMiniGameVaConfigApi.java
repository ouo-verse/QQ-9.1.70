package com.tencent.mobileqq.minigame.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMiniGameVaConfigApi extends QRouteApi {
    String getVASwitchInfo();

    boolean isDiffPatchEnable();

    void setDiffPatchEnable(boolean z16);
}
