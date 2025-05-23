package com.tencent.sqshow.zootopia.recommend.characterV2.event;

import com.tencent.ams.xsad.rewarded.dynamic.method.RewardAdMethodHandler;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nw4.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/characterV2/event/FaceAdDataEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lnw4/h;", "adInfo", "Lnw4/h;", RewardAdMethodHandler.RewardAdEvent.GET_AD_INFO, "()Lnw4/h;", "<init>", "(Lnw4/h;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class FaceAdDataEvent extends SimpleBaseEvent {
    private final h adInfo;

    public FaceAdDataEvent(h adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.adInfo = adInfo;
    }

    public final h getAdInfo() {
        return this.adInfo;
    }
}
