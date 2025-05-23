package com.tencent.hippy.qq.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.vip.pb.TianShuAccess;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes7.dex */
public interface IHippyMessageTabAd extends QRouteApi {
    void handleMessageTabAd(TianShuAccess.AdItem adItem);
}
