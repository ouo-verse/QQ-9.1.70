package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.mobileqq.wxapi.IWXAuthApi;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J5\u0010\n\u001a\u00020\u00072+\u0010\t\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\u0004\u0018\u0001`\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J[\u0010\u0013\u001a\u00020\u00072+\u0010\t\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\u0004\u0018\u0001`\b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0002JI\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2+\u0010\t\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\u0004\u0018\u0001`\bH\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/t;", "Li01/e;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "c", "", "i", "", "errorCode", "", "errorMsg", "authCode", "wxAppId", "g", "method", "params", "call", "<init>", "()V", "d", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class t extends i01.e {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(t this$0, Function1 function1, int i3, String str, String str2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QQKuiklyWXModule", 1, "reqWXAuthCode errCode: " + i3 + " errorMsg: " + str);
        this$0.g(function1, i3, str, str2, ((IWXAuthApi) QRoute.api(IWXAuthApi.class)).getWXAppId());
    }

    private final void g(Function1<Object, Unit> callback, int errorCode, String errorMsg, String authCode, String wxAppId) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ResultCode", errorCode);
            jSONObject.put("ResultMsg", errorMsg);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("AuthCode", authCode);
            jSONObject2.put("WxAppId", wxAppId);
            Unit unit = Unit.INSTANCE;
            jSONObject.put("ResultData", jSONObject2);
            if (callback != null) {
                callback.invoke(jSONObject.toString());
            }
        } catch (JSONException e16) {
            QLog.e("QQKuiklyWXModule", 1, "callBackResult e:", e16);
        }
    }

    private final boolean i() {
        Iterable until;
        JSONArray optJSONArray = ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfigJsonObj(IGameCenterUnitedConfigApi.KUIKLY_WEIXIN_AUTH_CODE_CONFIG).optJSONArray("PageList");
        if (optJSONArray == null) {
            return false;
        }
        until = RangesKt___RangesKt.until(0, optJSONArray.length());
        if ((until instanceof Collection) && ((Collection) until).isEmpty()) {
            return false;
        }
        Iterator it = until.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(com.tencent.mobileqq.qqecommerce.biz.kuikly.export.g.b(this), optJSONArray.optString(((IntIterator) it).nextInt()))) {
                return true;
            }
        }
        return false;
    }

    @Override // i01.e, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, "acquireAuthCode")) {
            c(callback);
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }

    private final void c(final Function1<Object, Unit> callback) {
        if (callback == null) {
            QLog.e("QQKuiklyWXModule", 1, "acquireAuthCode callback is null");
            return;
        }
        if (!i()) {
            QLog.e("QQKuiklyWXModule", 1, "acquireAuthCode no permission");
            g(callback, -100, "acquireAuthCode no permission", null, null);
        } else if (!WXShareHelper.b0().e0()) {
            QLog.e("QQKuiklyWXModule", 1, "WeiXin isn't installed");
            g(callback, -101, "WeiXin isn't installed", null, null);
        } else {
            ((IWXAuthApi) QRoute.api(IWXAuthApi.class)).reqWXAuthCode(new IWXAuthApi.a() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.s
                @Override // com.tencent.mobileqq.wxapi.IWXAuthApi.a
                public final void a(int i3, String str, String str2) {
                    t.d(t.this, callback, i3, str, str2);
                }
            });
        }
    }
}
