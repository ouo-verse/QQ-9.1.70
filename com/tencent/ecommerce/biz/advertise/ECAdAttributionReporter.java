package com.tencent.ecommerce.biz.advertise;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/ecommerce/biz/advertise/ECAdAttributionReporter;", "", "", "clickId", "actionType", "externalActionId", "Lorg/json/JSONObject;", "c", "reportData", "Lcom/tencent/ecommerce/biz/advertise/a;", "result", "", "i", "j", "k", "g", "d", h.F, "Lkotlinx/coroutines/GlobalScope;", "a", "Lkotlin/Lazy;", "f", "()Lkotlinx/coroutines/GlobalScope;", "viewModelScope", "Lcom/tencent/ecommerce/biz/advertise/ECAdAttributionRepo;", "b", "e", "()Lcom/tencent/ecommerce/biz/advertise/ECAdAttributionRepo;", "repo", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECAdAttributionReporter {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Lazy viewModelScope;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy repo;

    /* renamed from: c, reason: collision with root package name */
    public static final ECAdAttributionReporter f101288c = new ECAdAttributionReporter();

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GlobalScope>() { // from class: com.tencent.ecommerce.biz.advertise.ECAdAttributionReporter$viewModelScope$2
            @Override // kotlin.jvm.functions.Function0
            public final GlobalScope invoke() {
                return GlobalScope.INSTANCE;
            }
        });
        viewModelScope = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ECAdAttributionRepo>() { // from class: com.tencent.ecommerce.biz.advertise.ECAdAttributionReporter$repo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECAdAttributionRepo invoke() {
                return ECAdAttributionRepo.f101285b;
            }
        });
        repo = lazy2;
    }

    ECAdAttributionReporter() {
    }

    public static final /* synthetic */ ECAdAttributionRepo a(ECAdAttributionReporter eCAdAttributionReporter) {
        return eCAdAttributionReporter.e();
    }

    private final JSONObject c(String clickId, String actionType, String externalActionId) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("click_id", clickId);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("action_time", System.currentTimeMillis() / 1000);
        jSONObject2.put("action_type", actionType);
        jSONObject2.put("trace", jSONObject);
        jSONObject2.put(WadlProxyConsts.CHANNEL, "CHANNEL_TENCENT");
        JSONArray jSONArray = new JSONArray();
        jSONArray.mo162put(jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(ReportDataBuilder.KEY_ACCOUNT_ID, 30133431);
        jSONObject3.put("user_action_set_id", 1201029499);
        jSONObject3.put("actions", jSONArray);
        return jSONObject3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECAdAttributionRepo e() {
        return (ECAdAttributionRepo) repo.getValue();
    }

    private final GlobalScope f() {
        return (GlobalScope) viewModelScope.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(String actionType, JSONObject reportData, ECAdAttributionAddResult result) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action_type", actionType);
        linkedHashMap.put("body", reportData.toString());
        linkedHashMap.put("code", Integer.valueOf(result.code));
        linkedHashMap.put("msg", result.msg);
        linkedHashMap.put("msg_cn", result.msgCN);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "advertising_attribution_report", linkedHashMap, false, 4, null);
    }

    public final void d(String clickId) {
        if (clickId != null) {
            if (clickId.length() == 0) {
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(f(), null, null, new ECAdAttributionReporter$completeOrder$1(c(clickId, "COMPLETE_ORDER", "\u63d0\u4ea4\u8ba2\u5355\u6210\u529f"), null), 3, null);
        }
    }

    public final void g(String clickId) {
        if (clickId != null) {
            if (clickId.length() == 0) {
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(f(), null, null, new ECAdAttributionReporter$orderInitiateCheckout$1(c(clickId, "INITIATE_CHECKOUT", "\u8ba2\u5355\u63d0\u4ea4\u9875\u66dd\u5149"), null), 3, null);
        }
    }

    public final void h(String clickId) {
        if (clickId != null) {
            if (clickId.length() == 0) {
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(f(), null, null, new ECAdAttributionReporter$purchaseSuccess$1(c(clickId, "PURCHASE", "\u652f\u4ed8\u6210\u529f"), null), 3, null);
        }
    }

    public final void j(String clickId) {
        if (clickId != null) {
            if (clickId.length() == 0) {
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(f(), null, null, new ECAdAttributionReporter$shopHomeSearchReport$1(c(clickId, DTConstants.KeyBoardAction.ACTION_SEARCH, "\u5e97\u94fa\u4e3b\u9875\u641c\u7d22"), null), 3, null);
        }
    }

    public final void k(String clickId) {
        if (clickId != null) {
            if (clickId.length() == 0) {
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(f(), null, null, new ECAdAttributionReporter$shopProductExpReport$1(c(clickId, "PRODUCT_VIEW", "\u5546\u54c1\u8be6\u60c5\u9875\u9762\u66dd\u5149"), null), 3, null);
        }
    }
}
