package com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report;

import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pw2.w;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ,\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001`\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J6\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001`\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u001a\u0010\u0015\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fJI\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001`\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0016\u0010\u0019\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0018\"\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/e;", "", "", "isCurrAdReachUnlockCondition", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "b", "Lfx2/b;", "mRewardAdLoadInfo", "", "originProcessNum", "a", "Lcom/tencent/ams/xsad/rewarded/view/a;", "dialog", "Landroid/view/View;", "adView", "", "d", "reportView", "parentView", "e", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/QAdExtraParamsType;", "type", "", "params", "c", "(Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/QAdExtraParamsType;[Ljava/lang/Object;)Ljava/util/HashMap;", "<init>", "()V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f304313a = new e();

    e() {
    }

    private final HashMap<String, Object> a(fx2.b mRewardAdLoadInfo, int originProcessNum) {
        ex2.a aVar;
        String str;
        int i3;
        int i16;
        ex2.a mSwitchAdInnerInfo;
        ex2.a mSwitchAdInnerInfo2;
        ex2.a mSwitchAdInnerInfo3;
        String vid;
        ex2.a mSwitchAdInnerInfo4;
        String str2 = null;
        if (mRewardAdLoadInfo != null) {
            aVar = mRewardAdLoadInfo.getMSwitchAdInnerInfo();
        } else {
            aVar = null;
        }
        if (aVar == null) {
            return new HashMap<>();
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        if (mRewardAdLoadInfo == null || (mSwitchAdInnerInfo4 = mRewardAdLoadInfo.getMSwitchAdInnerInfo()) == null || (str = mSwitchAdInnerInfo4.getCid()) == null) {
            str = null;
        }
        if (mRewardAdLoadInfo != null && (mSwitchAdInnerInfo3 = mRewardAdLoadInfo.getMSwitchAdInnerInfo()) != null && (vid = mSwitchAdInnerInfo3.getVid()) != null) {
            str2 = vid;
        }
        if (mRewardAdLoadInfo != null && (mSwitchAdInnerInfo2 = mRewardAdLoadInfo.getMSwitchAdInnerInfo()) != null) {
            i3 = mSwitchAdInnerInfo2.getTotal();
        } else {
            i3 = 1;
        }
        if (mRewardAdLoadInfo != null && (mSwitchAdInnerInfo = mRewardAdLoadInfo.getMSwitchAdInnerInfo()) != null) {
            i16 = mSwitchAdInnerInfo.getProcess();
        } else {
            i16 = 1;
        }
        if (str != null) {
            hashMap.put(QAdVrReportParams.ParamKey.AD_UNLOCK_CID, str);
        }
        if (str2 != null) {
            hashMap.put(QAdVrReportParams.ParamKey.AD_UNLOCK_VID, str2);
        }
        hashMap.put(QAdVrReportParams.ParamKey.AD_NUM_ALL, Integer.valueOf(i3));
        int i17 = i16 + 1;
        hashMap.put(QAdVrReportParams.ParamKey.AD_NUM_CUMULATIVE, Integer.valueOf(i17 - originProcessNum));
        hashMap.put(QAdVrReportParams.ParamKey.AD_NUM_CURRENT, Integer.valueOf(i17));
        return hashMap;
    }

    private final HashMap<String, Object> b(boolean isCurrAdReachUnlockCondition) {
        HashMap<String, Object> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(QAdVrReportParams.ParamKey.AD_POP_LOCK_TIME, Integer.valueOf(isCurrAdReachUnlockCondition ? 1 : 0)));
        return hashMapOf;
    }

    @NotNull
    public final HashMap<String, Object> c(@NotNull QAdExtraParamsType type, @NotNull Object... params) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(params, "params");
        if (type == QAdExtraParamsType.MULTI_AD && params.length == 2) {
            Object obj = params[0];
            if (obj instanceof fx2.b) {
                Object obj2 = params[1];
                if (obj2 instanceof Integer) {
                    if (obj != null) {
                        fx2.b bVar = (fx2.b) obj;
                        if (obj2 != null) {
                            return a(bVar, ((Integer) obj2).intValue());
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.video.RewardAdLoadInfo");
                }
            }
        }
        if (type == QAdExtraParamsType.POP_UP && params.length == 1) {
            Object obj3 = params[0];
            if (obj3 instanceof Boolean) {
                if (obj3 != null) {
                    return b(((Boolean) obj3).booleanValue());
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
        }
        return new HashMap<>();
    }

    public final void d(@Nullable com.tencent.ams.xsad.rewarded.view.a dialog, @Nullable View adView) {
        Window window;
        if (dialog != null && adView != null && (window = dialog.getWindow()) != null) {
            w.m(window.getDecorView(), adView);
        }
    }

    public final void e(@Nullable View reportView, @Nullable View parentView) {
        if (reportView != null && parentView != null) {
            w.m(reportView, parentView);
        }
    }
}
