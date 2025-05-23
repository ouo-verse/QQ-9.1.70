package com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/bridge/DeviceBridgeInvokeHandler;", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/bridge/a;", "", "g", "", "f", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/a;", "module", "<init>", "(Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/a;)V", "c", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class DeviceBridgeInvokeHandler extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceBridgeInvokeHandler(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a module) {
        super(module);
        Intrinsics.checkNotNullParameter(module, "module");
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.a
    public String f() {
        return "device";
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.a
    public void g() {
        h("getDeviceInfo", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.DeviceBridgeInvokeHandler$register$1
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
                DeviceBridgeInvokeHandler.this.getBridgeModule().D(str, true);
            }
        });
        h("getNetworkInfo", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.DeviceBridgeInvokeHandler$register$2
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
                DeviceBridgeInvokeHandler.this.getBridgeModule().M(str, true);
            }
        });
        h("getNetType", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.DeviceBridgeInvokeHandler$register$3
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
                DeviceBridgeInvokeHandler.this.getBridgeModule().L(str, true);
            }
        });
        h("getClientInfo", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.DeviceBridgeInvokeHandler$register$4
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
                DeviceBridgeInvokeHandler.this.getBridgeModule().A(str);
            }
        });
        h("getCUKingStatus", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.DeviceBridgeInvokeHandler$register$5
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
                DeviceBridgeInvokeHandler.this.getBridgeModule().z(str);
            }
        });
        h("getGdtInfo", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.DeviceBridgeInvokeHandler$register$6
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
                DeviceBridgeInvokeHandler.this.getBridgeModule().J(str);
            }
        });
        h("isMobileQQ", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.DeviceBridgeInvokeHandler$register$7
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
                DeviceBridgeInvokeHandler.this.getBridgeModule().X(str);
            }
        });
        h("getNetworkType", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.DeviceBridgeInvokeHandler$register$8
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
                DeviceBridgeInvokeHandler.this.getBridgeModule().L(str, true);
            }
        });
    }
}
