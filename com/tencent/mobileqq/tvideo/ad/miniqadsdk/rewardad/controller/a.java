package com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.controller;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.xsad.rewarded.RewardedAd;
import com.tencent.ams.xsad.rewarded.RewardedAdData;
import com.tencent.ams.xsad.rewarded.RewardedAdError;
import com.tencent.ams.xsad.rewarded.RewardedAdListener;
import com.tencent.ams.xsad.rewarded.f;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.QAdRewardFragment;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardFunnelReport;
import com.tencent.tvideo.protocol.pb.RewardAdInfo;
import ev2.g;
import gx2.b;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pw2.n;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00042\u00020\u00012\u00020\u0002:\u0001$B\u0007\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0001H\u0002J1\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0011\u001a\u00020\u0010JX\u0010 \u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00182&\u0010\u001c\u001a\"\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001aj\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u0014J\u001c\u0010#\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010$\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010%\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010&\u001a\u00020\u0003H\u0016R\u0018\u0010)\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00101\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u00100\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/controller/a;", "Lcom/tencent/ams/xsad/rewarded/f;", "Lgx2/b$b;", "", "i", "Lcom/tencent/ams/xsad/rewarded/RewardedAd;", "ad", "listener", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/data/d;", h.F, "Landroid/app/Activity;", "context", "", "mHashKey", "Landroid/content/Intent;", "intent", "", "isFirstIndex", "k", "(Landroid/app/Activity;Ljava/lang/Integer;Landroid/content/Intent;Z)V", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "g", "Lcom/tencent/ams/xsad/rewarded/RewardedAdListener;", "", "maxUnlockTime", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "Lcom/tencent/tvideo/protocol/pb/RewardAdInfo;", "mRewardAdInfo", "eid", "j", "Lcom/tencent/ams/xsad/rewarded/RewardedAdError;", "error", "b", "a", "c", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/data/d;", "mSession", "e", "Ljava/lang/Integer;", "Lgx2/b;", "f", "Lgx2/b;", "mRewardEventHandler", "Lcom/tencent/ams/xsad/rewarded/RewardedAd;", "rewardAd", "<init>", "()V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public final class a implements f, b.InterfaceC10401b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private volatile com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d mSession;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Integer mHashKey;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private gx2.b mRewardEventHandler;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final RewardedAd rewardAd = new RewardedAd();

    private final com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d h(RewardedAd ad5, f listener) {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar = new com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d();
        dVar.g(listener);
        dVar.e(ad5);
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        RewardedAd rewardedAd;
        Field field = RewardedAd.class.getDeclaredField("a");
        Intrinsics.checkNotNullExpressionValue(field, "field");
        field.setAccessible(true);
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar = this.mSession;
        if (dVar != null) {
            rewardedAd = dVar.getAd();
        } else {
            rewardedAd = null;
        }
        field.set(rewardedAd, this);
        field.setAccessible(false);
    }

    private final void k(Activity context, Integer mHashKey, Intent intent, boolean isFirstIndex) {
        if (isFirstIndex) {
            g.b(context, intent, QAdRewardFragment.class);
            return;
        }
        Activity a16 = ev2.a.a();
        if (a16 instanceof FragmentActivity) {
            Fragment findFragmentByTag = ((FragmentActivity) a16).getSupportFragmentManager().findFragmentByTag("[RewardAd]QAdRewardFragment");
            if (findFragmentByTag instanceof QAdRewardFragment) {
                ((QAdRewardFragment) findFragmentByTag).sh(mHashKey);
            }
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.f
    public void a(@Nullable RewardedAd ad5) {
        RewardedAd rewardedAd;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar;
        f loadListener;
        n.a("[RewardAd]QAdRewardLoadManager", "onAdStartLoad");
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar2 = this.mSession;
        if (dVar2 != null) {
            rewardedAd = dVar2.getAd();
        } else {
            rewardedAd = null;
        }
        if (Intrinsics.areEqual(rewardedAd, ad5) && (dVar = this.mSession) != null && (loadListener = dVar.getLoadListener()) != null) {
            loadListener.a(ad5);
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.f
    public void b(@Nullable RewardedAd ad5, @Nullable RewardedAdError error) {
        RewardedAd rewardedAd;
        f loadListener;
        n.e("[RewardAd]QAdRewardLoadManager", "onAdFailedToLoad");
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar = this.mSession;
        if (dVar != null) {
            rewardedAd = dVar.getAd();
        } else {
            rewardedAd = null;
        }
        if (Intrinsics.areEqual(rewardedAd, ad5)) {
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar2 = this.mSession;
            if (dVar2 != null && (loadListener = dVar2.getLoadListener()) != null) {
                loadListener.b(ad5, error);
            }
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar3 = this.mSession;
            if (dVar3 != null) {
                dVar3.g(null);
            }
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.f
    public void c(@Nullable RewardedAd ad5) {
        RewardedAd rewardedAd;
        Integer num;
        f loadListener;
        RewardedAdData g16;
        Object obj;
        n.e("[RewardAd]QAdRewardLoadManager", "onAdLoaded");
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar = this.mSession;
        if (dVar != null) {
            rewardedAd = dVar.getAd();
        } else {
            rewardedAd = null;
        }
        if (Intrinsics.areEqual(rewardedAd, ad5)) {
            gx2.d dVar2 = gx2.d.f403713b;
            dVar2.c(this.mHashKey, this.mRewardEventHandler);
            if (ad5 != null && (g16 = ad5.g()) != null && (obj = g16.f71687a) != null) {
                num = Integer.valueOf(obj.hashCode());
            } else {
                num = null;
            }
            this.mHashKey = num;
            n.e("[RewardAd]QAdRewardLoadManager", "onAdLoaded, session hashcode = " + this.mSession);
            gx2.b bVar = new gx2.b(this.mSession, this);
            this.mRewardEventHandler = bVar;
            dVar2.b(this.mHashKey, bVar);
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar3 = this.mSession;
            if (dVar3 != null && (loadListener = dVar3.getLoadListener()) != null) {
                loadListener.c(ad5);
            }
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar4 = this.mSession;
            if (dVar4 != null) {
                dVar4.g(null);
            }
        }
    }

    public final void g(@NotNull f listener, @Nullable String requestId, boolean isFirstIndex) {
        Map<String, Object> mapOf;
        RewardedAd ad5;
        Intrinsics.checkNotNullParameter(listener, "listener");
        n.e("[RewardAd]QAdRewardLoadManager", "loadAd");
        RewardedAd.a aVar = new RewardedAd.a();
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, requestId), TuplesKt.to("isFirstIndex", Boolean.valueOf(isFirstIndex)));
        aVar.f71682d = mapOf;
        this.mSession = h(this.rewardAd, listener);
        QAdRewardFunnelReport.f304329b.a(7);
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar = this.mSession;
        if (dVar != null && (ad5 = dVar.getAd()) != null) {
            ad5.n(aVar, this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ad, code lost:
    
        if (r10.f71689c == 2) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00be, code lost:
    
        if (r10.f71688b == false) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j(@NotNull Activity context, @NotNull RewardedAdListener listener, float maxUnlockTime, @Nullable HashMap<String, String> params, @Nullable RewardAdInfo mRewardAdInfo, @NotNull String eid) {
        RewardedAd rewardedAd;
        RewardedAdData rewardedAdData;
        RewardedAd ad5;
        Object obj;
        RewardedAd.a i3;
        Map<String, Object> map;
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(eid, "eid");
        n.e("[RewardAd]QAdRewardLoadManager", "showAd");
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar = this.mSession;
        String str = null;
        if (dVar != null) {
            rewardedAd = dVar.getAd();
        } else {
            rewardedAd = null;
        }
        if (rewardedAd == null) {
            RewardedAdError rewardedAdError = new RewardedAdError(203, "\u9700\u8981\u5148\u8c03\u7528loadAd\u52a0\u8f7d\u5e7f\u544a");
            listener.L7(rewardedAdError);
            com.tencent.ams.xsad.rewarded.utils.c.e("[RewardAd]QAdRewardLoadManager", "showAd failed: " + rewardedAdError);
            return;
        }
        RewardedAd ad6 = dVar.getAd();
        Intrinsics.checkNotNull(ad6);
        if (!ad6.l()) {
            RewardedAdError rewardedAdError2 = new RewardedAdError(203, "\u5e7f\u544a\u8fd8\u672a\u52a0\u8f7d\u5b8c\u6210");
            listener.L7(rewardedAdError2);
            com.tencent.ams.xsad.rewarded.utils.c.e("[RewardAd]QAdRewardLoadManager", "showAd failed: " + rewardedAdError2);
        }
        dVar.f(listener);
        dVar.h(maxUnlockTime);
        RewardedAd ad7 = dVar.getAd();
        if (ad7 != null) {
            rewardedAdData = ad7.g();
        } else {
            rewardedAdData = null;
        }
        Intent intent = new Intent();
        boolean z17 = true;
        if (hx2.b.f406570a.a()) {
            if (rewardedAdData != null) {
                str = rewardedAdData.f71703q;
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                if (rewardedAdData != null) {
                }
                z17 = false;
                intent.putExtra("param_ad_reward_landscape_tag", z17);
                intent.putExtra("param_ad_reward_param", this.mHashKey);
                intent.putExtra("param_reward_ad_info", mRewardAdInfo);
                intent.putExtra("eid", eid);
                if (params != null) {
                    intent.putExtra("ref_pg", params);
                }
                ad5 = dVar.getAd();
                if (ad5 != null || (i3 = ad5.i()) == null || (map = i3.f71682d) == null || (obj = map.get("isFirstIndex")) == null) {
                    obj = Boolean.TRUE;
                }
                if (obj == null) {
                    k(context, this.mHashKey, intent, ((Boolean) obj).booleanValue());
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
        }
        RewardedAd ad8 = dVar.getAd();
        if (ad8 != null) {
            RewardedAdData g16 = ad8.g();
            if (g16 != null) {
            }
        }
        z17 = false;
        intent.putExtra("param_ad_reward_landscape_tag", z17);
        intent.putExtra("param_ad_reward_param", this.mHashKey);
        intent.putExtra("param_reward_ad_info", mRewardAdInfo);
        intent.putExtra("eid", eid);
        if (params != null) {
        }
        ad5 = dVar.getAd();
        if (ad5 != null) {
        }
        obj = Boolean.TRUE;
        if (obj == null) {
        }
    }

    @Override // gx2.b.InterfaceC10401b
    public void onDestroy() {
        RewardedAd ad5;
        n.e("[RewardAd]QAdRewardLoadManager", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        gx2.d.f403713b.c(this.mHashKey, this.mRewardEventHandler);
        this.mRewardEventHandler = null;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar = this.mSession;
        if (dVar != null) {
            dVar.g(null);
        }
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar2 = this.mSession;
        if (dVar2 != null) {
            dVar2.f(null);
        }
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar3 = this.mSession;
        if (dVar3 != null && (ad5 = dVar3.getAd()) != null) {
            ad5.e();
        }
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar4 = this.mSession;
        if (dVar4 != null) {
            dVar4.e(null);
        }
        this.mSession = null;
    }
}
