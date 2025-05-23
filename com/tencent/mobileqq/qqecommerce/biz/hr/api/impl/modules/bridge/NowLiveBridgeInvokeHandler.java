package com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.out.nativePlugins.NowLiveNativePlugin;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/bridge/NowLiveBridgeInvokeHandler;", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/bridge/a;", "Lorg/json/JSONObject;", "param", "", "callback", "", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "f", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/a;", "module", "<init>", "(Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/a;)V", "c", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class NowLiveBridgeInvokeHandler extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NowLiveBridgeInvokeHandler(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a module) {
        super(module);
        Intrinsics.checkNotNullParameter(module, "module");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(JSONObject param, String callback) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.d
            @Override // java.lang.Runnable
            public final void run() {
                NowLiveBridgeInvokeHandler.n();
            }
        }, 8, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n() {
        boolean z16 = BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.a
    public String f() {
        return NowLiveNativePlugin.PLUGIN_NAME;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.a
    public void g() {
        h("openRoom", new NowLiveBridgeInvokeHandler$register$1(this));
        h("preload", new NowLiveBridgeInvokeHandler$register$2(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(JSONObject param, String callback) {
        if (param != null) {
            String optString = param.optString("params");
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"params\")");
            Bundle bundle = new Bundle();
            bundle.putInt("jumpType", 1);
            bundle.putString("roomid", optString);
            bundle.putString("fromid", "violaCall");
            if (QLog.isColorLevel()) {
                QLog.e("BridgeModule", 2, "nowlive openRoom  roomid = " + optString);
            }
        }
    }
}
