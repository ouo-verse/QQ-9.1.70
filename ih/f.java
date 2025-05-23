package ih;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.params.GdtSsoReportParam;
import com.tencent.mobileqq.ad.report.api.IAdAttaReporterApi;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.adv.common.pb.adv_report;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get;
import com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi;
import com.tencent.mobileqq.vas.adv.qzone.data.VasAdMetaReportParam;
import com.tencent.mobileqq.vas.adv.reward.api.IVasRewardAdApi;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import uz2.VasRewardAdReportParams;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004J \u0010\u000e\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0002J\u0016\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0004J\u0016\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0004J\u0016\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0002J\u001e\u0010\"\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0004\u00a8\u0006%"}, d2 = {"Lih/f;", "", "", "rewardAdTraceId", "", "actionType", "", tl.h.F, "Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdTianshuFeedData;", "tianshuAd", "i", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "adPosType", "a", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "data", "g", "traceId", "f", "e", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$QzoneActivity;", "qzoneActivity", "videoDuration", "c", "rewardItem", "elapsedTime", "d", "module", "action", "j", "feedData", "clickParam", "feedIndex", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f407629a = new f();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"ih/f$a", "Ltz2/b;", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "code", "", "retCode", "", "errMsg", "", "busiBuffer", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements tz2.b {
        a() {
        }

        @Override // tz2.b
        public void a(VasAdvServiceCode code, int retCode, String errMsg, byte[] busiBuffer) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        }
    }

    f() {
    }

    private final void h(String rewardAdTraceId, int actionType) {
        GdtSsoReportParam build = new GdtSsoReportParam.Builder().build();
        build.setBusiType(60);
        build.setActionType(actionType);
        build.setActionTime(System.currentTimeMillis() / 1000);
        build.setTraceId(rewardAdTraceId);
        ((IGdtAPI) QRoute.api(IGdtAPI.class)).reportAdEvent(build);
    }

    public final void b(BusinessFeedData feedData, String clickParam, int feedIndex) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        Intrinsics.checkNotNullParameter(clickParam, "clickParam");
        com.tencent.gdtad.util.j.f109555a.f(0, QZoneAdFeedDataExtKt.getAid(feedData), QZoneAdFeedDataExtKt.getTraceId(feedData), clickParam, QZoneAdFeedDataExtKt.getPostype(feedData), feedIndex);
    }

    public final void c(vac_adv_get.QzoneActivity qzoneActivity, int videoDuration) {
        PBEnumField pBEnumField;
        Intrinsics.checkNotNullParameter(qzoneActivity, "qzoneActivity");
        vac_adv_get.RewardRspInfo rewardRspInfo = qzoneActivity.adv.reward_rsp_info.get();
        vac_adv_get.Activity y16 = QZoneAdFeedUtils.f55717a.y(qzoneActivity);
        int i3 = (y16 == null || (pBEnumField = y16.reward_type) == null) ? 0 : pBEnumField.get();
        VasAdMetaReportParam.Builder builder = new VasAdMetaReportParam.Builder();
        builder.setAdvPos(7);
        builder.setActionType(4);
        builder.setActionValue(Integer.valueOf(videoDuration));
        builder.setFeedIndex(0);
        builder.setUin(Long.valueOf(MobileQQ.sMobileQQ.peekAppRuntime().getLongAccountUin()));
        builder.setRecommendCookie("");
        adv_report.RewardReportInfo rewardReportInfo = builder.getRewardReportInfo();
        adv_report.RewardReportInfo rewardReportInfo2 = new adv_report.RewardReportInfo();
        rewardReportInfo2.reward_type.set(26);
        rewardReportInfo2.reward_item.set(ByteStringMicro.copyFromUtf8(String.valueOf(i3)));
        rewardReportInfo2.time.set(rewardRspInfo.time.get());
        rewardReportInfo2.nonce.set(rewardRspInfo.nonce.get());
        rewardReportInfo2.signature.set(rewardRspInfo.signature.get());
        rewardReportInfo.set(rewardReportInfo2);
        ((IVasQZoneApi) QRoute.api(IVasQZoneApi.class)).reportAdvAsync(builder.build());
    }

    public final void d(String rewardItem, int elapsedTime) {
        Intrinsics.checkNotNullParameter(rewardItem, "rewardItem");
        VasRewardAdReportParams.C11382a c11382a = new VasRewardAdReportParams.C11382a();
        e eVar = e.f407623a;
        c11382a.d(eVar.c());
        c11382a.h(26);
        c11382a.f(rewardItem);
        c11382a.b(elapsedTime);
        ((IVasRewardAdApi) QRoute.api(IVasRewardAdApi.class)).reportRewardAd(c11382a.a(), new a());
        eVar.m(0L);
    }

    public final void e(String traceId) {
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        h(traceId, 6);
        j("third_fulicard", "effective_expose");
    }

    public final void f(String traceId) {
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        h(traceId, 0);
        j("third_fulicard", "expose");
    }

    public final void g(BusinessFeedData data) {
        PBStringField pBStringField;
        Intrinsics.checkNotNullParameter(data, "data");
        vac_adv_get.QzoneActivity c06 = QZoneAdFeedUtils.f55717a.c0(data);
        String str = (c06 == null || (pBStringField = c06.trace_id) == null) ? null : pBStringField.get();
        if (str == null) {
            str = "";
        }
        h(str, 4);
        j("third_fulicard_dropdown", "click");
        QLog.i("QZoneAdReportUtils", 1, "reward ad feed hide, traceId: " + str);
    }

    public final void j(String module, String action) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(action, "action");
        ((IAdAttaReporterApi) QRoute.api(IAdAttaReporterApi.class)).report("qzone", module, action);
    }

    public final void a(GdtAd gdtAd, int actionType, int adPosType) {
        if (gdtAd == null) {
            return;
        }
        GdtSsoReportParam build = new GdtSsoReportParam.Builder().build();
        build.setBusiType(0);
        build.setAid(String.valueOf(gdtAd.getAId()));
        build.setAdPosType(adPosType);
        build.setActionType(actionType);
        build.setActionTime(System.currentTimeMillis() / 1000);
        String traceId = gdtAd.getTraceId();
        if (traceId == null) {
            traceId = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(traceId, "gdtAd.traceId ?: \"\"");
        }
        build.setTraceId(traceId);
        ((IGdtAPI) QRoute.api(IGdtAPI.class)).reportAdEvent(build);
    }

    public final void i(QZoneAdTianshuFeedData tianshuAd, int actionType) {
        if (tianshuAd == null) {
            return;
        }
        GdtSsoReportParam build = new GdtSsoReportParam.Builder().build();
        build.setBusiType(62);
        build.setAid(tianshuAd.getAid());
        build.setAdPosType(tianshuAd.getAdPosType());
        build.setActionType(actionType);
        build.setActionTime(System.currentTimeMillis() / 1000);
        build.setAttachment(tianshuAd.getReportAttachment());
        build.setTraceId(tianshuAd.getTraceId());
        QLog.e("QZoneAdReportUtils", 4, "[reportTianShuAd], aid:" + tianshuAd.getAid() + ", traceId:" + tianshuAd.getTraceId() + ", action:" + actionType);
        ((IGdtAPI) QRoute.api(IGdtAPI.class)).reportAdEvent(build);
    }
}
