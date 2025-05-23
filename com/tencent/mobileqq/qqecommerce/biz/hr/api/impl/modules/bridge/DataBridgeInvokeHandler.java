package com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge;

import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/bridge/DataBridgeInvokeHandler;", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/bridge/a;", "Lorg/json/JSONObject;", "params", "", "callback", "", DomainData.DOMAIN_NAME, "", "isFollow", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "g", "f", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/a;", "module", "<init>", "(Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/a;)V", "c", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class DataBridgeInvokeHandler extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataBridgeInvokeHandler(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a module) {
        super(module);
        Intrinsics.checkNotNullParameter(module, "module");
    }

    private final void m(boolean isFollow, String callback) {
        b(callback, new JSONObject().put("response", new JSONObject().put("follow", isFollow)).put("ret", 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(DataBridgeInvokeHandler this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.m(false, str);
        } catch (Exception e16) {
            QLog.e("DataBridgeInvokeHandler", 1, "[isFollowUin]: " + e16.getMessage());
            this$0.c(str, "error in isFollowUin");
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.a
    public String f() {
        return "data";
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.a
    public void g() {
        h("ssoRequest", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.DataBridgeInvokeHandler$register$1
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
                DataBridgeInvokeHandler.this.getBridgeModule().sendRequest(jSONObject, str);
            }
        });
        h("getUserInfo", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.DataBridgeInvokeHandler$register$2
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
                DataBridgeInvokeHandler.this.getBridgeModule().O(str, true);
            }
        });
        h("getUserLoginInfo", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.DataBridgeInvokeHandler$register$3
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
                DataBridgeInvokeHandler.this.getBridgeModule().P(str);
            }
        });
        h("getPerformance", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.DataBridgeInvokeHandler$register$4
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
                DataBridgeInvokeHandler.this.getBridgeModule().N(str);
            }
        });
        h("isFollowUin", new DataBridgeInvokeHandler$register$5(this));
        h("followUin", new DataBridgeInvokeHandler$register$6(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(JSONObject params, String callback) {
        if (params == null || params.optString("uin") == null) {
            return;
        }
        params.optInt("isUgc");
        params.optString(PhotoCategorySummaryInfo.AVATAR_URL);
        params.optBoolean("blackScene");
        b(callback, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(JSONObject params, final String callback) {
        if (params == null || params.optString("uin") == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.c
            @Override // java.lang.Runnable
            public final void run() {
                DataBridgeInvokeHandler.o(DataBridgeInvokeHandler.this, callback);
            }
        }, 16, null, true);
    }
}
