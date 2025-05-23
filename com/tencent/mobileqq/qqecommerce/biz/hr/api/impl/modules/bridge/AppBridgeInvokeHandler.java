package com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge;

import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/bridge/AppBridgeInvokeHandler;", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/bridge/a;", "", "g", "", "f", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/a;", "module", "<init>", "(Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/a;)V", "c", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class AppBridgeInvokeHandler extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppBridgeInvokeHandler(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a module) {
        super(module);
        Intrinsics.checkNotNullParameter(module, "module");
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.a
    public String f() {
        return "app";
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.a
    public void g() {
        h("isAppInstalled", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.AppBridgeInvokeHandler$register$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                AppBridgeInvokeHandler.this.getBridgeModule().R(jSONObject != null ? jSONObject.optString(IECDtReport.ACTION_IDENTIFIER) : null, str, true);
            }
        });
        h("getDownloadApkState", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.AppBridgeInvokeHandler$register$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                AppBridgeInvokeHandler.this.getBridgeModule().E(jSONObject, str);
            }
        });
        h("downloadApkAction", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.AppBridgeInvokeHandler$register$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                AppBridgeInvokeHandler.this.getBridgeModule().n(jSONObject);
            }
        });
        h("downloadApkPause", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.AppBridgeInvokeHandler$register$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                AppBridgeInvokeHandler.this.getBridgeModule().p(jSONObject);
            }
        });
        h("downloadApkCancel", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.AppBridgeInvokeHandler$register$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                AppBridgeInvokeHandler.this.getBridgeModule().o(jSONObject);
            }
        });
        h("downloadApkResume", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.AppBridgeInvokeHandler$register$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                AppBridgeInvokeHandler.this.getBridgeModule().q(jSONObject);
            }
        });
        h("launchAppWithTokens", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.AppBridgeInvokeHandler$register$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                AppBridgeInvokeHandler.this.getBridgeModule().c0(jSONObject);
            }
        });
        h(WadlProxyConsts.REMOTE_CMD_APP_DOWNLOAD_ACTION, new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.AppBridgeInvokeHandler$register$8
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                AppBridgeInvokeHandler.this.getBridgeModule().m(jSONObject);
            }
        });
        h("requestFloatingPermission", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.AppBridgeInvokeHandler$register$9
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                AppBridgeInvokeHandler.this.getBridgeModule().n0(jSONObject);
            }
        });
        h("queryAllDownloadTask", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.AppBridgeInvokeHandler$register$10
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                AppBridgeInvokeHandler.this.getBridgeModule().k0();
            }
        });
        h("registerWadlListener", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.AppBridgeInvokeHandler$register$11
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                AppBridgeInvokeHandler.this.getBridgeModule().l0();
            }
        });
        h("unregisterWadlListener", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.AppBridgeInvokeHandler$register$12
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                AppBridgeInvokeHandler.this.getBridgeModule().I0();
            }
        });
    }
}
