package com.tencent.mobileqq.qwallet.ad;

import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
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
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ3\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022#\u0010\n\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qwallet/ad/q;", "", "", "posId", "Lkotlin/Function1;", "Lcom/tencent/gdtad/aditem/GdtAd;", "Lkotlin/ParameterName;", "name", "gdtAd", "", "callback", "a", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final q f277085a = new q();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qwallet/ad/q$a", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasAdCallback;", "", "retCode", "Ltencent/gdt/access$AdGetRsp;", "adRsp", "", "msg", "", "onRsp", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a implements VasAdCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<GdtAd, Unit> f277086a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super GdtAd, Unit> function1) {
            this.f277086a = function1;
        }

        @Override // com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback
        public void onRsp(int retCode, @Nullable access.AdGetRsp adRsp, @NotNull String msg2) {
            qq_ad_get.QQAdGetRsp.AdInfo adInfo;
            access.RetMsg retMsg;
            PBStringField pBStringField;
            qq_ad_get.QQAdGetRsp qQAdGetRsp;
            PBRepeatMessageField<qq_ad_get.QQAdGetRsp.PosAdInfo> pBRepeatMessageField;
            List<qq_ad_get.QQAdGetRsp.PosAdInfo> list;
            Object firstOrNull;
            PBRepeatMessageField<qq_ad_get.QQAdGetRsp.AdInfo> pBRepeatMessageField2;
            List<qq_ad_get.QQAdGetRsp.AdInfo> list2;
            Object firstOrNull2;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            String str = null;
            if (adRsp != null && (qQAdGetRsp = adRsp.qq_ad_get_rsp) != null && (pBRepeatMessageField = qQAdGetRsp.pos_ads_info) != null && (list = pBRepeatMessageField.get()) != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                qq_ad_get.QQAdGetRsp.PosAdInfo posAdInfo = (qq_ad_get.QQAdGetRsp.PosAdInfo) firstOrNull;
                if (posAdInfo != null && (pBRepeatMessageField2 = posAdInfo.ads_info) != null && (list2 = pBRepeatMessageField2.get()) != null) {
                    firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
                    adInfo = (qq_ad_get.QQAdGetRsp.AdInfo) firstOrNull2;
                    if (adRsp != null && (retMsg = adRsp.ret_msg) != null && (pBStringField = retMsg.err_msg) != null) {
                        str = pBStringField.get();
                    }
                    QLog.d("QWalletGdtAdManager", 1, "onRsp: code " + retCode + ", msg " + str + " adInfo " + adInfo);
                    GdtAd gdtAd = new GdtAd(adInfo);
                    this.f277086a.invoke(gdtAd);
                    ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).preLoadAfterAdLoaded(MobileQQ.sMobileQQ, gdtAd);
                }
            }
            adInfo = null;
            if (adRsp != null) {
                str = pBStringField.get();
            }
            QLog.d("QWalletGdtAdManager", 1, "onRsp: code " + retCode + ", msg " + str + " adInfo " + adInfo);
            GdtAd gdtAd2 = new GdtAd(adInfo);
            this.f277086a.invoke(gdtAd2);
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).preLoadAfterAdLoaded(MobileQQ.sMobileQQ, gdtAd2);
        }
    }

    q() {
    }

    public final void a(@NotNull String posId, @NotNull Function1<? super GdtAd, Unit> callback) {
        Intrinsics.checkNotNullParameter(posId, "posId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.d("QWalletGdtAdManager", 1, "requestAdByVasAdv: posId " + posId);
        VasNewAdParams build = new VasNewAdParams.Builder().build();
        build.getAdvPos().add(posId);
        build.setBusiType(17);
        ((IVasAdvApi) QRoute.api(IVasAdvApi.class)).requestAd(build, new a(callback));
    }
}
