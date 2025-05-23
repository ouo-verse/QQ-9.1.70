package dx2;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ams.xsad.rewarded.RewardedAdData;
import com.tencent.ams.xsad.rewarded.RewardedAdListener;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdConfigDefine$CHID;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.VideoReportInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adclick.QAdStandardClickReportInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adclick.b;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$SecurityData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.qqlive.ona.protocol.jce.AdActionItem;
import com.tencent.qqlive.ona.protocol.jce.AdH5UrlItem;
import com.tencent.tvideo.protocol.pb.AdAction;
import com.tencent.tvideo.protocol.pb.AdActionButton;
import com.tencent.tvideo.protocol.pb.AdActionField;
import com.tencent.tvideo.protocol.pb.AdActionTitle;
import com.tencent.tvideo.protocol.pb.AdInsideVideoInfo;
import com.tencent.tvideo.protocol.pb.AdOrderItem;
import com.tencent.tvideo.protocol.pb.AdPlayFinishMaskInfo;
import com.tencent.tvideo.protocol.pb.DynamicInfo;
import com.tencent.tvideo.protocol.pb.RewardAdInfo;
import com.tencent.tvideo.protocol.pb.RewardAdItem;
import com.tencent.tvideo.protocol.pb.RewardAdNewUpdateResponse;
import com.tencent.tvideo.protocol.pb.RewardAdPoster;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J(\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0002J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\n*\u0004\u0018\u00010\u000fH\u0002J@\u0010\u001e\u001a\u00020\u001d2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001c\u001a\u00020\u0002J^\u0010\"\u001a\u00020\u001d2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001c\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\n2\b\u0010 \u001a\u0004\u0018\u00010\n2\b\u0010!\u001a\u0004\u0018\u00010\nJ!\u0010'\u001a\u0004\u0018\u00010&2\b\u0010#\u001a\u0004\u0018\u00010\u00112\u0006\u0010%\u001a\u00020$\u00a2\u0006\u0004\b'\u0010(J\u0016\u0010*\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0002\u00a8\u0006-"}, d2 = {"Ldx2/g;", "", "", "a", "Lcom/tencent/ams/xsad/rewarded/RewardedAdListener$ClickInfo;", "clickInfo", "Lcom/tencent/tvideo/protocol/pb/AdOrderItem;", "adOrderItem", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/QAdCore/qadreport/adaction/baseaction/VideoReportInfo;", "b", "", "cacheFileName", "vid", "defn", "g", "Lcom/tencent/tvideo/protocol/pb/RewardAdInfo;", "rewardAdInfo", "", "actionField", "Lcom/tencent/tvideo/protocol/pb/AdAction;", "f", h.F, "Landroid/content/Context;", "context", "rewardInfo", "Lew2/a;", "adClickActionInfo", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "fullScreenClickDownload", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/QAdCore/qadreport/adclick/b;", "c", "jsApiName", "vrPageId", "rewardTaskId", "d", "orientation", "Lcom/tencent/tvideo/protocol/pb/RewardAdNewUpdateResponse;", "response", "Lcom/tencent/ams/xsad/rewarded/RewardedAdData;", "e", "(Ljava/lang/Integer;Lcom/tencent/tvideo/protocol/pb/RewardAdNewUpdateResponse;)Lcom/tencent/ams/xsad/rewarded/RewardedAdData;", "clickArea", "i", "<init>", "()V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f395163a = new g();

    g() {
    }

    private final boolean a() {
        ov2.a b16 = ov2.a.b();
        Intrinsics.checkNotNullExpressionValue(b16, "QAdAppConfigManager.getInstance()");
        return Intrinsics.areEqual(b16.a(), QAdConfigDefine$CHID.SUBMARINE);
    }

    private final VideoReportInfo b(RewardedAdListener.ClickInfo clickInfo, AdOrderItem adOrderItem) {
        View view;
        QAdVrReportParams i3 = new QAdVrReportParams().i().h(hw2.f.a(adOrderItem).a(6)).i();
        Intrinsics.checkNotNullExpressionValue(i3, "QAdVrReportParams().newB\u2026WNLOAD)\n        ).build()");
        if (clickInfo != null) {
            view = clickInfo.f71721f;
        } else {
            view = null;
        }
        return vv2.a.a(view, i3);
    }

    private final AdAction f(RewardAdInfo rewardAdInfo, int actionField) {
        Map<Integer, AdAction> map;
        if (rewardAdInfo != null && (map = rewardAdInfo.action_dict) != null) {
            return map.get(Integer.valueOf(actionField));
        }
        return null;
    }

    private final String g(String cacheFileName, String vid, String defn) {
        if (TextUtils.isEmpty(cacheFileName)) {
            return rv2.c.d(vid, defn, 1);
        }
        return cacheFileName;
    }

    private final String h(RewardAdInfo rewardAdInfo) {
        RewardAdItem rewardAdItem;
        RewardAdPoster rewardAdPoster;
        AdPlayFinishMaskInfo adPlayFinishMaskInfo;
        AdActionButton adActionButton;
        AdActionTitle adActionTitle;
        if (rewardAdInfo != null && (rewardAdItem = rewardAdInfo.ad_reward_item) != null && (rewardAdPoster = rewardAdItem.reward_poster) != null && (adPlayFinishMaskInfo = rewardAdPoster.finish_mask_info) != null && (adActionButton = adPlayFinishMaskInfo.action_button) != null && (adActionTitle = adActionButton.action_title) != null) {
            return adActionTitle.first_title;
        }
        return null;
    }

    @NotNull
    public final com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adclick.b c(@Nullable Context context, @Nullable RewardAdInfo rewardInfo, @Nullable RewardedAdListener.ClickInfo clickInfo, @Nullable ew2.a adClickActionInfo, @Nullable String requestId, boolean fullScreenClickDownload) {
        return d(context, rewardInfo, clickInfo, adClickActionInfo, requestId, fullScreenClickDownload, null, null, null);
    }

    @NotNull
    public final com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adclick.b d(@Nullable Context context, @Nullable RewardAdInfo rewardInfo, @Nullable RewardedAdListener.ClickInfo clickInfo, @Nullable ew2.a adClickActionInfo, @Nullable String requestId, boolean fullScreenClickDownload, @Nullable String jsApiName, @Nullable String vrPageId, @Nullable String rewardTaskId) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        AdActionField adActionField;
        AdOrderItem adOrderItem;
        QAdStandardClickReportInfo.ClickExtraInfo clickExtraInfo = new QAdStandardClickReportInfo.ClickExtraInfo();
        int i28 = 0;
        if (clickInfo != null) {
            i3 = (int) clickInfo.f71717b;
        } else {
            i3 = 0;
        }
        clickExtraInfo.downX = i3;
        if (clickInfo != null) {
            i16 = (int) clickInfo.f71717b;
        } else {
            i16 = 0;
        }
        clickExtraInfo.upX = i16;
        if (clickInfo != null) {
            i17 = (int) clickInfo.f71718c;
        } else {
            i17 = 0;
        }
        clickExtraInfo.downY = i17;
        if (clickInfo != null) {
            i18 = (int) clickInfo.f71718c;
        } else {
            i18 = 0;
        }
        clickExtraInfo.upY = i18;
        if (clickInfo != null) {
            i19 = (int) clickInfo.f71719d;
        } else {
            i19 = 0;
        }
        clickExtraInfo.width = i19;
        if (clickInfo != null) {
            i26 = (int) clickInfo.f71720e;
        } else {
            i26 = 0;
        }
        clickExtraInfo.height = i26;
        if (clickInfo != null) {
            i27 = clickInfo.f71716a;
        } else {
            i27 = 0;
        }
        boolean i29 = i(i27, fullScreenClickDownload);
        if (i29) {
            adActionField = AdActionField.AD_ACTION_FIELD_ACTION_BTN;
        } else {
            adActionField = AdActionField.AD_ACTION_FIELD_POSTER;
        }
        if (adClickActionInfo != null) {
            i28 = adClickActionInfo.f397277b;
        }
        boolean a16 = a();
        b.C8854b c8854b = new b.C8854b();
        g gVar = f395163a;
        c8854b.b(gVar.f(rewardInfo, adActionField.getValue()));
        c8854b.c(hx2.c.f406571a.a(rewardInfo));
        c8854b.d(105);
        c8854b.h(clickExtraInfo);
        c8854b.l(i28);
        c8854b.m(true);
        c8854b.n(requestId);
        if (rewardInfo != null) {
            adOrderItem = rewardInfo.order_item;
        } else {
            adOrderItem = null;
        }
        c8854b.q(gVar.b(clickInfo, adOrderItem));
        c8854b.j(i29);
        c8854b.f(i29);
        c8854b.e(a16);
        c8854b.p(a16);
        c8854b.i(jsApiName);
        c8854b.r(vrPageId);
        c8854b.o(rewardTaskId);
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adclick.b a17 = c8854b.a(context);
        Intrinsics.checkNotNullExpressionValue(a17, "QAdClickInfo.Builder().a\u2026\n        }.build(context)");
        return a17;
    }

    @Nullable
    public final RewardedAdData e(@Nullable Integer orientation, @NotNull RewardAdNewUpdateResponse response) {
        Object orNull;
        RewardAdItem rewardAdItem;
        int i3;
        boolean z16;
        int i16;
        String str;
        String str2;
        String str3;
        String str4;
        int i17;
        int i18;
        String str5;
        Map hashMap;
        String str6;
        long j3;
        String str7;
        String str8;
        AdActionItem adActionItem;
        AdH5UrlItem adH5UrlItem;
        String str9;
        AdPlayFinishMaskInfo adPlayFinishMaskInfo;
        String str10;
        String str11;
        Intrinsics.checkNotNullParameter(response, "response");
        List<RewardAdInfo> list = response.reward_info_list;
        Intrinsics.checkNotNullExpressionValue(list, "response.reward_info_list");
        orNull = CollectionsKt___CollectionsKt.getOrNull(list, 0);
        RewardAdInfo rewardAdInfo = (RewardAdInfo) orNull;
        String str12 = null;
        if (rewardAdInfo == null || (rewardAdItem = rewardAdInfo.ad_reward_item) == null) {
            return null;
        }
        RewardedAdData rewardedAdData = new RewardedAdData();
        AdInsideVideoInfo adInsideVideoInfo = rewardAdItem.video_info;
        if (adInsideVideoInfo != null) {
            i3 = (int) adInsideVideoInfo.play_duration;
        } else {
            i3 = 0;
        }
        rewardedAdData.f71690d = i3;
        RewardAdPoster rewardAdPoster = rewardAdItem.reward_poster;
        if (rewardAdPoster != null) {
            z16 = rewardAdPoster.is_portrait;
        } else {
            z16 = false;
        }
        rewardedAdData.f71688b = z16;
        if (orientation != null) {
            i16 = orientation.intValue();
        } else {
            i16 = 0;
        }
        rewardedAdData.f71689c = i16;
        RewardAdPoster rewardAdPoster2 = rewardAdItem.reward_poster;
        if (rewardAdPoster2 != null) {
            str = rewardAdPoster2.close_ad_tips;
        } else {
            str = null;
        }
        rewardedAdData.f71692f = str;
        rewardedAdData.f71693g = (int) rewardAdItem.unlock_duration;
        if (rewardAdPoster2 != null) {
            str2 = rewardAdPoster2.countdown_tips;
        } else {
            str2 = null;
        }
        rewardedAdData.f71694h = str2;
        if (rewardAdPoster2 != null) {
            str3 = rewardAdPoster2.unlock_tips;
        } else {
            str3 = null;
        }
        rewardedAdData.f71695i = str3;
        if (rewardAdPoster2 != null) {
            str4 = rewardAdPoster2.posterUrl;
        } else {
            str4 = null;
        }
        rewardedAdData.f71705s = str4;
        AdInsideVideoInfo adInsideVideoInfo2 = rewardAdItem.video_info;
        if (adInsideVideoInfo2 != null) {
            i17 = (int) adInsideVideoInfo2.f383625vh;
        } else {
            i17 = 0;
        }
        rewardedAdData.f71707u = i17;
        if (adInsideVideoInfo2 != null) {
            i18 = (int) adInsideVideoInfo2.f383626vw;
        } else {
            i18 = 0;
        }
        rewardedAdData.f71706t = i18;
        DynamicInfo dynamicInfo = rewardAdItem.dynamicInfo;
        if (dynamicInfo != null) {
            str5 = dynamicInfo.moduleId;
        } else {
            str5 = null;
        }
        rewardedAdData.f71703q = str5;
        DynamicInfo dynamicInfo2 = rewardAdItem.dynamicInfo;
        if (dynamicInfo2 == null || (hashMap = dynamicInfo2.extra) == null) {
            hashMap = new HashMap();
        }
        HashMap extra = new HashMap(hashMap);
        rewardedAdData.f71704r = extra;
        Intrinsics.checkNotNullExpressionValue(extra, "extra");
        extra.put(QAdRewardDefine$SecurityData.REWARD_UNIQUE_KEY, response.penetrate_info);
        rewardedAdData.f71712z = 0;
        rewardedAdData.A = 0;
        RewardAdPoster rewardAdPoster3 = rewardAdItem.reward_poster;
        if (rewardAdPoster3 != null && (adPlayFinishMaskInfo = rewardAdPoster3.finish_mask_info) != null) {
            rewardedAdData.f71696j = adPlayFinishMaskInfo.image_url;
            rewardedAdData.f71697k = adPlayFinishMaskInfo.title;
            rewardedAdData.f71698l = adPlayFinishMaskInfo.sub_title;
            rewardedAdData.f71699m = f395163a.h(rewardAdInfo);
            AdActionButton adActionButton = adPlayFinishMaskInfo.action_button;
            if (adActionButton != null) {
                str10 = adActionButton.bg_color;
            } else {
                str10 = null;
            }
            rewardedAdData.f71700n = str10;
            if (adActionButton != null) {
                str11 = adActionButton.text_color;
            } else {
                str11 = null;
            }
            rewardedAdData.f71701o = str11;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        rewardedAdData.f71687a = response;
        AdInsideVideoInfo adInsideVideoInfo3 = rewardAdItem.video_info;
        String str13 = "";
        if (adInsideVideoInfo3 == null || (str6 = adInsideVideoInfo3.video_url) == null) {
            str6 = "";
        }
        rewardedAdData.f71691e = str6;
        if (adInsideVideoInfo3 != null && (str9 = adInsideVideoInfo3.vid) != null) {
            str13 = str9;
        }
        linkedHashMap.put("vid", str13);
        linkedHashMap.put("definition", "hd");
        AdInsideVideoInfo adInsideVideoInfo4 = rewardAdItem.video_info;
        long j16 = 0;
        if (adInsideVideoInfo4 != null) {
            j3 = adInsideVideoInfo4.play_duration;
        } else {
            j3 = 0;
        }
        linkedHashMap.put("duration", Long.valueOf(j3));
        AdInsideVideoInfo adInsideVideoInfo5 = rewardAdItem.video_info;
        if (adInsideVideoInfo5 != null) {
            j16 = adInsideVideoInfo5.file_size;
        }
        linkedHashMap.put("fileSize", Long.valueOf(j16));
        AdInsideVideoInfo adInsideVideoInfo6 = rewardAdItem.video_info;
        if (adInsideVideoInfo6 != null) {
            str7 = adInsideVideoInfo6.vid;
        } else {
            str7 = null;
        }
        String b16 = rv2.c.b(str7, "hd", 1);
        g gVar = f395163a;
        AdInsideVideoInfo adInsideVideoInfo7 = rewardAdItem.video_info;
        if (adInsideVideoInfo7 != null) {
            str8 = adInsideVideoInfo7.vid;
        } else {
            str8 = null;
        }
        linkedHashMap.put(QAdRewardDefine$VideoParams.CACHE_PATH, gVar.g(b16, str8, "hd"));
        linkedHashMap.put(QAdRewardDefine$VideoParams.ISCACHE, Boolean.valueOf(!TextUtils.isEmpty(b16)));
        linkedHashMap.put(QAdRewardDefine$VideoParams.ISCACHE, Boolean.valueOf(!TextUtils.isEmpty(b16)));
        linkedHashMap.put(QAdRewardDefine$SecurityData.DATA_KEY, response.data_key);
        linkedHashMap.put(QAdRewardDefine$SecurityData.PENETRATE_INFO, response.penetrate_info);
        Unit unit = Unit.INSTANCE;
        rewardedAdData.f71702p = linkedHashMap;
        com.tencent.qqlive.ona.protocol.jce.AdAction adAction = (com.tencent.qqlive.ona.protocol.jce.AdAction) kw2.a.b().a(gVar.f(rewardAdInfo, AdActionField.AD_ACTION_FIELD_ACTION_BTN.getValue()));
        if (adAction != null && (adActionItem = adAction.actionItem) != null && (adH5UrlItem = adActionItem.adH5UrlItem) != null) {
            str12 = adH5UrlItem.adxSplashH5Url;
        }
        rewardedAdData.B = str12;
        return rewardedAdData;
    }

    public final boolean i(int clickArea, boolean fullScreenClickDownload) {
        if (clickArea != 4 && clickArea != 9 && (!fullScreenClickDownload || clickArea == 12)) {
            return false;
        }
        return true;
    }
}
