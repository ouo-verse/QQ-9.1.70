package com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/bridge/PublicAccountNewBridgeInvokeHandler;", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/bridge/a;", "Lorg/json/JSONObject;", "param", "", "callbackId", "", "l", "k", "g", "f", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/a;", "module", "<init>", "(Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/a;)V", "c", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class PublicAccountNewBridgeInvokeHandler extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublicAccountNewBridgeInvokeHandler(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a module) {
        super(module);
        Intrinsics.checkNotNullParameter(module, "module");
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.a
    public String f() {
        return IPublicAccountH5AbilityPlugin.PACKAGE_NAME;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.a
    public void g() {
        h("showReadInJoyNativeCommentView", new PublicAccountNewBridgeInvokeHandler$register$1(this));
        h("getRIJAppType", new PublicAccountNewBridgeInvokeHandler$register$2(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(JSONObject param, String callbackId) {
        if (param != null) {
            QLog.d("PublicAccountNewBridgeInvokeHandler", 1, "call getRIJAppType");
            if (!TextUtils.isEmpty(param.optString("callback"))) {
                callbackId = param.optString("callback");
            }
            try {
                String jSONObject = new JSONObject().toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject().toString()");
                QLog.d("PublicAccountNewBridgeInvokeHandler", 1, "callback: " + callbackId + "result: " + jSONObject);
                b(callbackId, jSONObject);
            } catch (JSONException e16) {
                QLog.e("PublicAccountNewBridgeInvokeHandler", 1, e16.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(JSONObject param, String callbackId) {
    }
}
