package com.tencent.hippykotlin.demo.pages.vas_base.pay;

import com.tencent.hippykotlin.demo.pages.foundation.lib.UriKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.TraceHelper;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.d;
import com.tencent.kuikly.core.nvi.serialization.json.JSONException;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qqlive.module.videoreport.dtreport.api.DefaultTVKDataProvider;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* loaded from: classes33.dex */
public final class VasPayHelper {
    public static final VasPayHelper INSTANCE = new VasPayHelper();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.String] */
    public static void openKuiklyPay$default(final VasPayData vasPayData) {
        String joinToString$default;
        String o16;
        VasPayLog vasPayLog = VasPayLog.INSTANCE;
        vasPayLog.logInfo("openKuiklyPayParams: data=" + vasPayData);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = "";
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        objectRef3.element = "";
        e eVar = vasPayData.traceInfo;
        if (eVar != null) {
            T p16 = eVar.p("traceIndex");
            if (p16.length() == 0) {
                p16 = eVar.p("trace_index");
            }
            objectRef.element = p16;
            T p17 = eVar.p("traceDetail");
            if (p17.length() == 0) {
                p17 = eVar.p("trace_detail");
            }
            objectRef2.element = p17;
            objectRef3.element = eVar.p("enteranceId");
        }
        e eVar2 = new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.pay.VasPayHelper$openKuiklyPay$pageData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Removed duplicated region for block: B:8:0x0067  */
            @Override // kotlin.jvm.functions.Function1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Unit invoke(e eVar3) {
                e eVar4;
                e eVar5 = eVar3;
                eVar5.z("version", "1");
                eVar5.z(ISchemeApi.KEY_IOS_SRC_TYPE, "web");
                eVar5.z("page_name", "vas_qqvip_pay");
                eVar5.z("bundle_name", "vas_qqvip_pay");
                eVar5.z(KuiklyLaunchParams.PARAM_QQMC_CONFIG, "vas_kuikly_config");
                eVar5.z(KuiklyLaunchParams.PARAM_TURBO_DISPLAY, VasPayData.this.type);
                eVar5.z(DefaultTVKDataProvider.KEY_PAY_TYPE, VasPayData.this.type);
                eVar5.z("aid", VasPayData.this.aid);
                TraceHelper traceHelper = TraceHelper.INSTANCE;
                String str = objectRef2.element;
                if (!(str.length() == 0)) {
                    try {
                        eVar4 = new e(str);
                    } catch (JSONException unused) {
                        eVar4 = null;
                    }
                    if (eVar4 == null) {
                        eVar4 = new e();
                    }
                    eVar5.z("trace_detail", UriKt.encodeURIComponent("base64-" + ((d) c.f117352a.g().acquireModule("KRCodecModule")).b(String.valueOf(eVar4))));
                    eVar5.z("trace_index", objectRef.element);
                    eVar5.z(com.tencent.luggage.wxa.c8.c.f123370d0, VasPayData.this.referrer);
                    eVar5.z(KuiklyLaunchParams.PARAM_IS_ANIMATED, Boolean.valueOf(VasPayData.this.isAnimated));
                    eVar5.z("enteranceId", objectRef3.element);
                    eVar5.z("disable_activity", Integer.valueOf(VasPayData.this.disableActivity ? 1 : 0));
                    eVar5.z("disable_pay_result", Integer.valueOf(VasPayData.this.disablePayResult ? 1 : 0));
                    return Unit.INSTANCE;
                }
                eVar4 = null;
                if (eVar4 == null) {
                }
                eVar5.z("trace_detail", UriKt.encodeURIComponent("base64-" + ((d) c.f117352a.g().acquireModule("KRCodecModule")).b(String.valueOf(eVar4))));
                eVar5.z("trace_index", objectRef.element);
                eVar5.z(com.tencent.luggage.wxa.c8.c.f123370d0, VasPayData.this.referrer);
                eVar5.z(KuiklyLaunchParams.PARAM_IS_ANIMATED, Boolean.valueOf(VasPayData.this.isAnimated));
                eVar5.z("enteranceId", objectRef3.element);
                eVar5.z("disable_activity", Integer.valueOf(VasPayData.this.disableActivity ? 1 : 0));
                eVar5.z("disable_pay_result", Integer.valueOf(VasPayData.this.disablePayResult ? 1 : 0));
                return Unit.INSTANCE;
            }
        });
        if (vasPayData.provideUin.length() > 0) {
            eVar2.v("provide_uin", vasPayData.provideUin);
        }
        String str = vasPayData.month;
        if (str != null) {
            eVar2.v("month", str);
        }
        if (vasPayData.isHalfPay) {
            eVar2.v("half_pay", "1");
            eVar2.v(KuiklyLaunchParams.PARAM_MODAL_MODE, "1");
            eVar2.v("from_scheme", "1");
        }
        b bVar = vasPayData.policyId;
        if (bVar != null && (o16 = bVar.o(0)) != null) {
            eVar2.v("policy_id", o16);
        }
        List<String> list = vasPayData.businessType;
        if (list != null) {
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, ",", null, null, 0, null, null, 62, null);
            eVar2.v("business_type", joinToString$default);
        }
        Mqq.INSTANCE.getUi().openKuikly("vas_qqvip_pay", eVar2);
        vasPayLog.logInfo("openKuiklyPay no callback");
    }
}
