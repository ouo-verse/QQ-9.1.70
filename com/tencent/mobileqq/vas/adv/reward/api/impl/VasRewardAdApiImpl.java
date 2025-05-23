package com.tencent.mobileqq.vas.adv.reward.api.impl;

import android.app.Activity;
import com.tencent.ark.ark;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.adv.common.pb.adv_report;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get;
import com.tencent.mobileqq.vas.adv.reward.api.IVasRewardAdApi;
import com.tencent.mobileqq.vas.adv.reward.callback.VasRewardAdCallback;
import com.tencent.mobileqq.vas.adv.reward.data.VasRewardAdParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sz2.g;
import sz2.h;
import tencent.gdt.qq_ad_get;
import uz2.VasRewardAdReportParams;
import uz2.VasRewardAdReqParams;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J4\u0010\u0015\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0014H\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u0018H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u0018H\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/vas/adv/reward/api/impl/VasRewardAdApiImpl;", "Lcom/tencent/mobileqq/vas/adv/reward/api/IVasRewardAdApi;", "", "initDeviceInfo", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/vas/adv/reward/data/VasRewardAdParams;", "requestAdParams", "Lcom/tencent/mobileqq/vas/adv/reward/callback/VasRewardAdCallback;", "rewardCallback", "requestAd", "ensureDeviceInfoValid", "Luz2/b;", "Ltz2/c;", "callback", "", "adSequence", "", "rewardText", ark.APP_SPECIFIC_BIZSRC, "Ltz2/d;", "showRewardAd", "Luz2/a;", "param", "Ltz2/b;", "reportRewardAd", "reportH5RewardAdNew", "Ltz2/a;", "mVasProfitableTimeCallback", "Ltz2/a;", "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasRewardAdApiImpl implements IVasRewardAdApi {

    @Nullable
    private tz2.a mVasProfitableTimeCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/vas/adv/reward/api/impl/VasRewardAdApiImpl$a", "Lbz2/a;", "Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$MobileAdvReportRsp;", "rsp", "", "c", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "code", "", "errMsg", "", "e", "b", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements bz2.a<adv_report.MobileAdvReportRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ tz2.b f308315a;

        a(tz2.b bVar) {
            this.f308315a = bVar;
        }

        @Override // bz2.a
        public void b(@NotNull VasAdvServiceCode code, @NotNull String errMsg, @Nullable Throwable e16) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f308315a.a(code, -1, errMsg, null);
        }

        @Override // bz2.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull adv_report.MobileAdvReportRsp rsp) {
            VasAdvServiceCode vasAdvServiceCode;
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            int i3 = rsp.ret_code.get();
            String errMsg = rsp.error_msg.get();
            byte[] byteArray = rsp.busi_buffer.get().toByteArray();
            if (i3 == 0) {
                vasAdvServiceCode = VasAdvServiceCode.SUCCEED;
            } else {
                vasAdvServiceCode = VasAdvServiceCode.REPORT_RSP_FAIL;
            }
            tz2.b bVar = this.f308315a;
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            bVar.a(vasAdvServiceCode, i3, errMsg, byteArray);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/vas/adv/reward/api/impl/VasRewardAdApiImpl$b", "Lbz2/a;", "Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$MobileAdvReportRsp;", "rsp", "", "c", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "code", "", "errMsg", "", "e", "b", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements bz2.a<adv_report.MobileAdvReportRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ tz2.b f308316a;

        b(tz2.b bVar) {
            this.f308316a = bVar;
        }

        @Override // bz2.a
        public void b(@NotNull VasAdvServiceCode code, @NotNull String errMsg, @Nullable Throwable e16) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f308316a.a(code, -1, errMsg, null);
        }

        @Override // bz2.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull adv_report.MobileAdvReportRsp rsp) {
            VasAdvServiceCode vasAdvServiceCode;
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            int i3 = rsp.ret_code.get();
            String errMsg = rsp.error_msg.get();
            byte[] byteArray = rsp.busi_buffer.get().toByteArray();
            if (i3 == 0) {
                vasAdvServiceCode = VasAdvServiceCode.SUCCEED;
            } else {
                vasAdvServiceCode = VasAdvServiceCode.REPORT_RSP_FAIL;
            }
            tz2.b bVar = this.f308316a;
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            bVar.a(vasAdvServiceCode, i3, errMsg, byteArray);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/vas/adv/reward/api/impl/VasRewardAdApiImpl$c", "Lbz2/a;", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvRsp;", "rsp", "", "c", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "code", "", "errMsg", "", "e", "b", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements bz2.a<vac_adv_get.VacAdvRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ tz2.c f308317a;

        c(tz2.c cVar) {
            this.f308317a = cVar;
        }

        @Override // bz2.a
        public void b(@NotNull VasAdvServiceCode code, @NotNull String errMsg, @Nullable Throwable e16) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f308317a.b(code, errMsg);
        }

        @Override // bz2.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull vac_adv_get.VacAdvRsp rsp) {
            boolean z16;
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            List<vac_adv_get.VacAdvMetaMsg> list = rsp.vac_adv_msgs.get();
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                this.f308317a.b(VasAdvServiceCode.REQUEST_RSP_PARSE_ERR, "ad is null");
                return;
            }
            g gVar = g.f435047a;
            long c16 = gVar.c();
            gVar.r(c16, rsp);
            this.f308317a.a(c16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/vas/adv/reward/api/impl/VasRewardAdApiImpl$d", "Ltz2/a;", "", "profitable", "", "elapsedTime", "totalTime", "", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class d implements tz2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ tz2.d f308318a;

        d(tz2.d dVar) {
            this.f308318a = dVar;
        }

        @Override // tz2.a
        public void a(boolean profitable, int elapsedTime, int totalTime) {
            this.f308318a.a(0, profitable, elapsedTime, totalTime);
        }
    }

    @Override // com.tencent.mobileqq.vas.adv.reward.api.IVasRewardAdApi
    public void ensureDeviceInfoValid() {
        g.f435047a.f();
    }

    @Override // com.tencent.mobileqq.vas.adv.reward.api.IVasRewardAdApi
    public void initDeviceInfo() {
        VasAdvSupport.INSTANCE.a().m();
    }

    @Override // com.tencent.mobileqq.vas.adv.reward.api.IVasRewardAdApi
    public void reportH5RewardAdNew(@NotNull VasRewardAdReportParams param, @NotNull tz2.b callback) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(callback, "callback");
        g.f435047a.n(param, new a(callback));
    }

    @Override // com.tencent.mobileqq.vas.adv.reward.api.IVasRewardAdApi
    public void reportRewardAd(@NotNull VasRewardAdReportParams param, @NotNull tz2.b callback) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(callback, "callback");
        long adSequence = param.getAdSequence();
        if (adSequence == 0) {
            callback.a(VasAdvServiceCode.CREATE_REPORT_ERR, -1, "adSequence error", null);
            return;
        }
        g gVar = g.f435047a;
        vac_adv_get.VacAdvRsp h16 = gVar.h(adSequence);
        if (h16 == null) {
            callback.a(VasAdvServiceCode.CREATE_REPORT_ERR, -1, "adRsp is null", null);
            return;
        }
        param.g(h16);
        gVar.n(param, new b(callback));
        gVar.m(adSequence);
    }

    @Override // com.tencent.mobileqq.vas.adv.reward.api.IVasRewardAdApi
    public void requestAd(@NotNull Activity activity, @NotNull VasRewardAdParams requestAdParams, @NotNull VasRewardAdCallback rewardCallback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(requestAdParams, "requestAdParams");
        Intrinsics.checkNotNullParameter(rewardCallback, "rewardCallback");
        new h(activity, requestAdParams, rewardCallback).v();
    }

    @Override // com.tencent.mobileqq.vas.adv.reward.api.IVasRewardAdApi
    public void showRewardAd(@Nullable Activity activity, long adSequence, @Nullable String rewardText, @NotNull String bizSrc, @NotNull tz2.d callback) {
        boolean z16;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo2;
        Intrinsics.checkNotNullParameter(bizSrc, "bizSrc");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (adSequence <= 0) {
            callback.a(10, false, 0, 0);
            return;
        }
        if (activity == null) {
            callback.a(12, false, 0, 0);
            return;
        }
        g gVar = g.f435047a;
        vac_adv_get.VacAdvRsp h16 = gVar.h(adSequence);
        if (h16 == null) {
            callback.a(11, false, 0, 0);
            return;
        }
        List<vac_adv_get.VacAdvMetaMsg> list = h16.vac_adv_msgs.get();
        List<vac_adv_get.VacAdvMetaMsg> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            callback.a(11, false, 0, 0);
            return;
        }
        vac_adv_get.VacAdvMetaMsg vacAdvMetaMsg = list.get(0);
        if (vacAdvMetaMsg != null && (adInfo2 = vacAdvMetaMsg.adv_rsp) != null) {
            adInfo = adInfo2.get();
        } else {
            adInfo = null;
        }
        qq_ad_get.QQAdGetRsp.AdInfo adInfo3 = adInfo;
        if (adInfo3 == null) {
            callback.a(11, false, 0, 0);
        } else {
            this.mVasProfitableTimeCallback = new d(callback);
            gVar.q(activity, adInfo3, new WeakReference<>(this.mVasProfitableTimeCallback), rewardText, bizSrc);
        }
    }

    @Override // com.tencent.mobileqq.vas.adv.reward.api.IVasRewardAdApi
    public void requestAd(@NotNull VasRewardAdReqParams requestAdParams, @NotNull tz2.c callback) {
        Intrinsics.checkNotNullParameter(requestAdParams, "requestAdParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        g.f435047a.p(requestAdParams, new c(callback));
    }
}
