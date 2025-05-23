package com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.xsad.rewarded.RewardedAd;
import com.tencent.ams.xsad.rewarded.RewardedAdListener;
import com.tencent.ams.xsad.rewarded.f;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fR$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b\n\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/data/d;", "", "Lcom/tencent/ams/xsad/rewarded/RewardedAd;", "a", "Lcom/tencent/ams/xsad/rewarded/RewardedAd;", "()Lcom/tencent/ams/xsad/rewarded/RewardedAd;", "e", "(Lcom/tencent/ams/xsad/rewarded/RewardedAd;)V", "ad", "Lcom/tencent/ams/xsad/rewarded/f;", "b", "Lcom/tencent/ams/xsad/rewarded/f;", "c", "()Lcom/tencent/ams/xsad/rewarded/f;", "g", "(Lcom/tencent/ams/xsad/rewarded/f;)V", "loadListener", "Lcom/tencent/ams/xsad/rewarded/RewardedAdListener;", "Lcom/tencent/ams/xsad/rewarded/RewardedAdListener;", "()Lcom/tencent/ams/xsad/rewarded/RewardedAdListener;", "f", "(Lcom/tencent/ams/xsad/rewarded/RewardedAdListener;)V", "listener", "", "d", UserInfo.SEX_FEMALE, "()F", h.F, "(F)V", "maxUnlockTime", "<init>", "()V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RewardedAd ad;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private f loadListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RewardedAdListener listener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float maxUnlockTime;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final RewardedAd getAd() {
        return this.ad;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final RewardedAdListener getListener() {
        return this.listener;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final f getLoadListener() {
        return this.loadListener;
    }

    /* renamed from: d, reason: from getter */
    public final float getMaxUnlockTime() {
        return this.maxUnlockTime;
    }

    public final void e(@Nullable RewardedAd rewardedAd) {
        this.ad = rewardedAd;
    }

    public final void f(@Nullable RewardedAdListener rewardedAdListener) {
        this.listener = rewardedAdListener;
    }

    public final void g(@Nullable f fVar) {
        this.loadListener = fVar;
    }

    public final void h(float f16) {
        this.maxUnlockTime = f16;
    }
}
