package com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report;

import android.view.View;
import com.tencent.ams.xsad.rewarded.RewardedAd;
import com.tencent.ams.xsad.rewarded.RewardedAdData;
import com.tencent.ams.xsad.rewarded.view.RewardedAdController;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.tvideo.protocol.pb.AdOrderItem;
import com.tencent.tvideo.protocol.pb.RewardAdInfo;
import cooperation.qqcircle.report.QFS5507ReportHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pw2.n;
import pw2.w;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u001aB%\u0012\b\u0010\"\u001a\u0004\u0018\u00010 \u0012\b\u0010%\u001a\u0004\u0018\u00010#\u0012\b\u0010(\u001a\u0004\u0018\u00010&\u00a2\u0006\u0004\b)\u0010*JV\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012*\u0010\u000b\u001a&\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\bj\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001`\nH\u0002J$\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001`\nH\u0002J\u0006\u0010\u000f\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0004J\u0016\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0002J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0004J\u0010\u0010\u0019\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017R2\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001`\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001eR\u0016\u0010\"\u001a\u0004\u0018\u00010 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010!R\u0016\u0010%\u001a\u0004\u0018\u00010#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010$R\u0016\u0010(\u001a\u0004\u0018\u00010&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/d;", "", "", "eventId", "", "currentPlayPosition", "failReason", WadlProxyConsts.EXTRA_DATA, "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "extraVrParam", "", "e", "b", "j", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, h.F, "i", "errorCode", "f", "g", "d", "Lcom/tencent/tvideo/protocol/pb/AdOrderItem;", "adOrderItem", "c", "a", "Ljava/util/HashMap;", "mExtraVRParams", "", "Z", "hasAdd", "Lcom/tencent/tvideo/protocol/pb/RewardAdInfo;", "Lcom/tencent/tvideo/protocol/pb/RewardAdInfo;", "mRewardAdInfo", "Lfx2/a;", "Lfx2/a;", "pointItem", "Lcom/tencent/ams/xsad/rewarded/RewardedAd;", "Lcom/tencent/ams/xsad/rewarded/RewardedAd;", "rewardAd", "<init>", "(Lcom/tencent/tvideo/protocol/pb/RewardAdInfo;Lfx2/a;Lcom/tencent/ams/xsad/rewarded/RewardedAd;)V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public final class d {

    /* renamed from: f, reason: collision with root package name */
    private static boolean f304306f;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private HashMap<String, Object> mExtraVRParams = b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean hasAdd;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final RewardAdInfo mRewardAdInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final fx2.a pointItem;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final RewardedAd rewardAd;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/d$a;", "", "", "AUTO_MUTE", "Z", "getAUTO_MUTE", "()Z", "a", "(Z)V", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.d$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        Companion() {
        }

        public final void a(boolean z16) {
            d.f304306f = z16;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public d(@Nullable RewardAdInfo rewardAdInfo, @Nullable fx2.a aVar, @Nullable RewardedAd rewardedAd) {
        this.mRewardAdInfo = rewardAdInfo;
        this.pointItem = aVar;
        this.rewardAd = rewardedAd;
    }

    private final HashMap<String, Object> b() {
        String str;
        long j3;
        List listOf;
        int i3;
        HashMap<String, Object> hashMap = new HashMap<>();
        RewardedAd rewardedAd = this.rewardAd;
        if (rewardedAd != null) {
            RewardedAdData g16 = rewardedAd.g();
            if (g16 != null) {
                i3 = g16.f71690d;
            } else {
                i3 = 0;
            }
            hashMap.put("ad_duration", String.valueOf(i3));
        }
        Pair[] pairArr = new Pair[7];
        pairArr[0] = TuplesKt.to("biz_type", "ad");
        pairArr[1] = TuplesKt.to("auto_mute", Integer.valueOf(f304306f ? 1 : 0));
        pairArr[2] = TuplesKt.to(QAdVrReportParams.ParamKey.IS_FULLSCREEN, "1");
        pairArr[3] = TuplesKt.to("content_type_ad", 1);
        pairArr[4] = TuplesKt.to("ad_play_source", 1);
        fx2.a aVar = this.pointItem;
        if (aVar == null || (str = aVar.b()) == null) {
            str = "0";
        }
        pairArr[5] = TuplesKt.to("ad_post_idx", str);
        fx2.a aVar2 = this.pointItem;
        if (aVar2 != null) {
            j3 = aVar2.a();
        } else {
            j3 = 0;
        }
        pairArr[6] = TuplesKt.to("ad_in_position", Long.valueOf(j3));
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) pairArr);
        MapsKt__MapsKt.putAll(hashMap, listOf);
        return hashMap;
    }

    private final void e(int eventId, long currentPlayPosition, int failReason, Object extraData, HashMap<String, Object> extraVrParam) {
        RewardedAd rewardedAd;
        RewardedAdController h16;
        n.e("[RewardAd]QAdRewardPlayerReport", "RewardEventId = " + eventId);
        if (!this.hasAdd && (rewardedAd = this.rewardAd) != null && (h16 = rewardedAd.h()) != null) {
            View view = h16.getView();
            if (view != null) {
                Map<String, Object> g16 = w.g(view);
                if (g16 != null) {
                    if (extraVrParam != null) {
                        extraVrParam.putAll(g16);
                    }
                    this.mExtraVRParams.putAll(g16);
                }
                this.hasAdd = true;
            }
            if (extraVrParam != null) {
                extraVrParam.put("ad_display_type", Integer.valueOf(h16.getDisplayType()));
            }
            this.mExtraVRParams.put("ad_display_type", Integer.valueOf(h16.getDisplayType()));
        }
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.f fVar = new com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.f();
        fVar.f304100a = eventId;
        fVar.f304101b = currentPlayPosition;
        fVar.f304102c = failReason;
        fVar.f304104e = extraData;
        fVar.f304105f = extraVrParam;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.h.a().b(this.mRewardAdInfo, fVar);
    }

    public final void c(@Nullable AdOrderItem adOrderItem) {
        e(7, 0L, 0, adOrderItem, null);
    }

    public final void d(long currentTime) {
        HashMap<String, Object> hashMap = new HashMap<>(this.mExtraVRParams);
        hashMap.put(QFS5507ReportHelper.JsonKey.END_TYPE, 2);
        hashMap.put("ad_playtime", String.valueOf(currentTime));
        hashMap.put(TPReportKeys.LiveExKeys.LIVE_EX_PLAY_TIME, "0");
        hashMap.put("ad_exit_position", String.valueOf(currentTime));
        Unit unit = Unit.INSTANCE;
        e(4, currentTime, 0, null, hashMap);
    }

    public final void f(long currentTime, int errorCode) {
        HashMap<String, Object> hashMap = new HashMap<>(this.mExtraVRParams);
        hashMap.put(QFS5507ReportHelper.JsonKey.END_TYPE, 1);
        hashMap.put("error_code", Integer.valueOf(errorCode));
        hashMap.put("ad_playtime", String.valueOf(currentTime));
        hashMap.put(TPReportKeys.LiveExKeys.LIVE_EX_PLAY_TIME, "0");
        hashMap.put("ad_exit_position", String.valueOf(currentTime));
        Unit unit = Unit.INSTANCE;
        e(5, currentTime, errorCode, null, hashMap);
    }

    public final void g(long currentTime) {
        HashMap<String, Object> hashMap = new HashMap<>(this.mExtraVRParams);
        hashMap.put(QFS5507ReportHelper.JsonKey.END_TYPE, 3);
        hashMap.put("ad_playtime", String.valueOf(currentTime));
        hashMap.put(TPReportKeys.LiveExKeys.LIVE_EX_PLAY_TIME, "0");
        hashMap.put("ad_exit_position", String.valueOf(currentTime));
        Unit unit = Unit.INSTANCE;
        e(9, currentTime, 0, null, hashMap);
    }

    public final void h(long currentTime) {
        HashMap<String, Object> hashMap = new HashMap<>(this.mExtraVRParams);
        hashMap.put("ad_playtime", String.valueOf(currentTime));
        hashMap.put(TPReportKeys.LiveExKeys.LIVE_EX_PLAY_TIME, "0");
        hashMap.put("ad_exit_position", String.valueOf(currentTime));
        Unit unit = Unit.INSTANCE;
        e(2, currentTime, 0, null, hashMap);
    }

    public final void i(long currentTime) {
        HashMap<String, Object> hashMap = new HashMap<>(this.mExtraVRParams);
        hashMap.put("start_type", 1);
        Unit unit = Unit.INSTANCE;
        e(3, currentTime, 0, null, hashMap);
    }

    public final void j() {
        HashMap<String, Object> hashMap = new HashMap<>(this.mExtraVRParams);
        hashMap.put("start_type", 0);
        Unit unit = Unit.INSTANCE;
        e(1, 0L, 0, null, hashMap);
    }
}
