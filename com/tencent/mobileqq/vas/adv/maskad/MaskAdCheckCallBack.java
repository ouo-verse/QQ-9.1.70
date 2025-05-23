package com.tencent.mobileqq.vas.adv.maskad;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/maskad/MaskAdCheckCallBack;", "", "realTimeCheckCallBack", "", "adInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public interface MaskAdCheckCallBack {
    void realTimeCheckCallBack(@Nullable qq_ad_get.QQAdGetRsp.AdInfo adInfo);
}
