package com.tencent.mobileqq.minigame.api;

import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMiniGameHippyApi extends QRouteApi {
    boolean isMiniGameHandled(QBaseFragment qBaseFragment, String str, String str2);
}
