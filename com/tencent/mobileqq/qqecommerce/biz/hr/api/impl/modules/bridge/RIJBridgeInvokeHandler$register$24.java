package com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
/* synthetic */ class RIJBridgeInvokeHandler$register$24 extends FunctionReferenceImpl implements Function2<JSONObject, String, Unit> {
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
        invoke2(jSONObject, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RIJBridgeInvokeHandler$register$24(Object obj) {
        super(2, obj, RIJBridgeInvokeHandler.class, "getChannelInsertCardInfo", "getChannelInsertCardInfo(Lorg/json/JSONObject;Ljava/lang/String;)V", 0);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(JSONObject jSONObject, String str) {
        ((RIJBridgeInvokeHandler) this.receiver).t(jSONObject, str);
    }
}
