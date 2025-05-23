package com.tencent.mobileqq.ad.troopad.api;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.lang.ref.WeakReference;
import t71.a;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface ITroopAd extends QRouteApi {
    void requestTroopBannerAd(Long l3, boolean z16, String str, qq_ad_get.QQAdGet qQAdGet, ByteStringMicro byteStringMicro, WeakReference<a> weakReference);
}
