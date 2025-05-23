package com.tencent.mobileqq.nearby.redtouch;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IUtil extends QRouteApi {
    boolean checkLikeRankListRedPointConfig(Object obj);

    boolean checkMedalRedPointConfig(Object obj);

    void onLikeRankListConfigChanged(Object obj, boolean z16);

    void onMedalConfigChanged(Object obj, boolean z16);
}
