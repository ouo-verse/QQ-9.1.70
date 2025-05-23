package com.tencent.biz.qqcircle.immersive.utils.ad;

import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback;
import com.tencent.mobileqq.vas.adv.common.data.VasNewAdParams;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ=\u0010\f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/utils/ad/t;", "", "", "feedId", "creatorId", "Lkotlin/Function1;", "Lcom/tencent/gdtad/aditem/GdtAd;", "Lkotlin/ParameterName;", "name", "gdtAd", "", "callback", "b", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final t f90109a = new t();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/biz/qqcircle/immersive/utils/ad/t$a", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasAdCallback;", "", "retCode", "Ltencent/gdt/access$AdGetRsp;", "adRsp", "", "msg", "", "onRsp", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a implements VasAdCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<GdtAd, Unit> f90110a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super GdtAd, Unit> function1) {
            this.f90110a = function1;
        }

        @Override // com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback
        public void onRsp(int retCode, @Nullable access.AdGetRsp adRsp, @NotNull String msg2) {
            qq_ad_get.QQAdGetRsp.AdInfo adInfo;
            qq_ad_get.QQAdGetRsp qQAdGetRsp;
            qq_ad_get.QQAdGetRsp qQAdGetRsp2;
            PBRepeatMessageField<qq_ad_get.QQAdGetRsp.PosAdInfo> pBRepeatMessageField;
            List<qq_ad_get.QQAdGetRsp.PosAdInfo> list;
            Object firstOrNull;
            PBRepeatMessageField<qq_ad_get.QQAdGetRsp.AdInfo> pBRepeatMessageField2;
            List<qq_ad_get.QQAdGetRsp.AdInfo> list2;
            Object firstOrNull2;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (adRsp != null && (qQAdGetRsp = adRsp.qq_ad_get_rsp) != null && (qQAdGetRsp2 = qQAdGetRsp.get()) != null && (pBRepeatMessageField = qQAdGetRsp2.pos_ads_info) != null && (list = pBRepeatMessageField.get()) != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                qq_ad_get.QQAdGetRsp.PosAdInfo posAdInfo = (qq_ad_get.QQAdGetRsp.PosAdInfo) firstOrNull;
                if (posAdInfo != null && (pBRepeatMessageField2 = posAdInfo.ads_info) != null && (list2 = pBRepeatMessageField2.get()) != null) {
                    firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
                    adInfo = (qq_ad_get.QQAdGetRsp.AdInfo) firstOrNull2;
                    QLog.d("QFSPauseAdService", 1, "onRsp: code " + retCode + ", msg " + msg2 + " adInfo " + adInfo);
                    GdtAd gdtAd = new GdtAd(adInfo);
                    this.f90110a.invoke(gdtAd);
                    ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).preLoadAfterAdLoaded(MobileQQ.sMobileQQ, gdtAd);
                }
            }
            adInfo = null;
            QLog.d("QFSPauseAdService", 1, "onRsp: code " + retCode + ", msg " + msg2 + " adInfo " + adInfo);
            GdtAd gdtAd2 = new GdtAd(adInfo);
            this.f90110a.invoke(gdtAd2);
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).preLoadAfterAdLoaded(MobileQQ.sMobileQQ, gdtAd2);
        }
    }

    t() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(String str, String str2, Function1 callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QLog.d("QFSPauseAdService", 1, "requestAdByVasAdv: feedId=" + str + " creatorId=" + str2);
        IVasAdvApi iVasAdvApi = (IVasAdvApi) QRoute.api(IVasAdvApi.class);
        VasNewAdParams build = new VasNewAdParams.Builder().build();
        build.setBusiType(49);
        com.tencent.biz.qqcircle.immersive.utils.ad.a aVar = com.tencent.biz.qqcircle.immersive.utils.ad.a.f90082a;
        build.setClientMod(aVar.f());
        build.getAdvPos().add("9075847413561640");
        build.setDeviceInfo(aVar.d());
        access.VideoFeedInfo videoFeedInfo = new access.VideoFeedInfo();
        PBStringField pBStringField = videoFeedInfo.feed_id;
        if (str == null) {
            str = "";
        }
        pBStringField.set(str);
        PBStringField pBStringField2 = videoFeedInfo.creator_id;
        if (str2 == null) {
            str2 = "";
        }
        pBStringField2.set(str2);
        build.setVideoFeedInfo(videoFeedInfo);
        iVasAdvApi.requestAd(build, new a(callback));
    }

    public final void b(@Nullable final String feedId, @Nullable final String creatorId, @NotNull final Function1<? super GdtAd, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.utils.ad.s
            @Override // java.lang.Runnable
            public final void run() {
                t.c(feedId, creatorId, callback);
            }
        }, 128, null, true);
    }
}
