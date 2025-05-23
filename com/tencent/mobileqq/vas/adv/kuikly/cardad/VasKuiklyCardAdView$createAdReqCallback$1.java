package com.tencent.mobileqq.vas.adv.kuikly.cardad;

import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/vas/adv/kuikly/cardad/VasKuiklyCardAdView$createAdReqCallback$1", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasAdCallback;", "onRsp", "", "retCode", "", "adRsp", "Ltencent/gdt/access$AdGetRsp;", "msg", "", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasKuiklyCardAdView$createAdReqCallback$1 implements VasAdCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VasKuiklyCardAdView f308054a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f308055b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ e f308056c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VasKuiklyCardAdView$createAdReqCallback$1(VasKuiklyCardAdView vasKuiklyCardAdView, long j3, e eVar) {
        this.f308054a = vasKuiklyCardAdView;
        this.f308055b = j3;
        this.f308056c = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(e rspCallback, int i3, ArrayList adList, access.UserActionReportInfo userActionReportInfo) {
        Intrinsics.checkNotNullParameter(rspCallback, "$rspCallback");
        Intrinsics.checkNotNullParameter(adList, "$adList");
        rspCallback.a(i3, adList, userActionReportInfo);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006d A[Catch: all -> 0x0066, TryCatch #0 {all -> 0x0066, blocks: (B:48:0x0059, B:50:0x005d, B:52:0x0061, B:18:0x006d, B:19:0x0076, B:21:0x007d, B:23:0x0089, B:31:0x0096, B:27:0x00ab, B:35:0x00c7, B:37:0x00cd, B:39:0x00e4, B:42:0x00e8, B:44:0x00f4, B:45:0x00fd), top: B:47:0x0059 }] */
    @Override // com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onRsp(final int retCode, @Nullable access.AdGetRsp adRsp, @NotNull String msg2) {
        int i3;
        Function1 function1;
        PBRepeatMessageField<qq_ad_get.QQAdGetRsp.PosAdInfo> pBRepeatMessageField;
        List<qq_ad_get.QQAdGetRsp.PosAdInfo> list;
        Function1 function12;
        int i16;
        Function1 function13;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (retCode != 0) {
            JSONObject put = new JSONObject().put("isSuccess", false);
            function13 = this.f308054a.mLoadCompletionCallback;
            if (function13 != null) {
                function13.invoke(put);
                return;
            }
            return;
        }
        final access.UserActionReportInfo userActionReportInfo = null;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new VasKuiklyCardAdView$createAdReqCallback$1$onRsp$1$1(this.f308054a, System.currentTimeMillis() - this.f308055b, null), 3, null);
        i3 = this.f308054a.mAdIndex;
        if (i3 >= 0 && adRsp != null) {
            VasKuiklyCardAdManager vasKuiklyCardAdManager = VasKuiklyCardAdManager.f308031a;
            i16 = this.f308054a.mAdIndex;
            vasKuiklyCardAdManager.t(i16, adRsp);
        }
        if (adRsp != null) {
            try {
                qq_ad_get.QQAdGetRsp qQAdGetRsp = adRsp.qq_ad_get_rsp;
                if (qQAdGetRsp != null && (pBRepeatMessageField = qQAdGetRsp.pos_ads_info) != null) {
                    list = pBRepeatMessageField.get();
                    if (list != null) {
                        return;
                    }
                    final ArrayList arrayList = new ArrayList();
                    for (qq_ad_get.QQAdGetRsp.PosAdInfo posAdInfo : list) {
                        if (posAdInfo.has() && !posAdInfo.ads_info.get().isEmpty()) {
                            arrayList.add(new GdtAd(posAdInfo.ads_info.get().get(0)));
                        }
                        QLog.d("VasKuiklyCardAdView", 2, "adInfo inValid\uff0cpos_id is" + posAdInfo.pos_id.get());
                    }
                    if (arrayList.isEmpty()) {
                        QLog.d("VasKuiklyCardAdView", 2, "cancel show ad, list is empty");
                        JSONObject put2 = new JSONObject().put("isSuccess", false);
                        function12 = this.f308054a.mLoadCompletionCallback;
                        if (function12 != null) {
                            function12.invoke(put2);
                            return;
                        }
                        return;
                    }
                    if (adRsp.action_report_infos.get().size() > 0) {
                        userActionReportInfo = adRsp.action_report_infos.get(0);
                    }
                    VasKuiklyCardAdView vasKuiklyCardAdView = this.f308054a;
                    final e eVar = this.f308056c;
                    vasKuiklyCardAdView.post(new Runnable() { // from class: com.tencent.mobileqq.vas.adv.kuikly.cardad.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            VasKuiklyCardAdView$createAdReqCallback$1.b(e.this, retCode, arrayList, userActionReportInfo);
                        }
                    });
                    return;
                }
            } catch (Throwable th5) {
                JSONObject put3 = new JSONObject().put("isSuccess", false);
                function1 = this.f308054a.mLoadCompletionCallback;
                if (function1 != null) {
                    function1.invoke(put3);
                }
                QLog.e("VasKuiklyCardAdView", 1, "onAdRsp parse ad error:", th5);
                return;
            }
        }
        list = null;
        if (list != null) {
        }
    }
}
