package pf2;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.hippy.qq.utils.screenshot.ShareImageUtils;
import com.tencent.kuikly.core.render.android.c;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.QQUIModule;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.ShareJsPlugin;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002JO\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042+\u0010\u0012\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\fj\u0004\u0018\u0001`\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u00a8\u0006\u001a"}, d2 = {"Lpf2/r;", "", "", "code", "", "msg", "Lorg/json/JSONObject;", "d", "c", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/QQUIModule;", "module", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "e", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class r {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\t"}, d2 = {"pf2/r$b", "Lcom/tencent/kuikly/core/render/android/c;", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "onActivityResult", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements com.tencent.kuikly.core.render.android.c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f426109d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ r f426110e;

        b(Function1<Object, Unit> function1, r rVar) {
            this.f426109d = function1;
            this.f426110e = rVar;
        }

        @Override // com.tencent.kuikly.core.render.android.c
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            c.a.a(this, requestCode, resultCode, data);
            QLog.i("ShareImageImpl", 1, "requestCode:" + requestCode + " resultCode: " + resultCode);
            if (21 == requestCode) {
                int i3 = resultCode == -1 ? 0 : 1;
                Function1<Object, Unit> function1 = this.f426109d;
                if (function1 != null) {
                    function1.invoke(this.f426110e.c(i3));
                }
            }
        }
    }

    private final JSONObject d(int code, String msg2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", code);
        jSONObject.put("msg", msg2);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function1 function1, r this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ShareImageImpl", 1, "resultCode: " + i3);
        if (function1 != null) {
            function1.invoke(this$0.c(i3));
        }
    }

    public final boolean e(QQUIModule module, String params, final Function1<Object, Unit> callback, Activity activity) {
        Intrinsics.checkNotNullParameter(module, "module");
        if (activity == null) {
            QLog.i("ShareImageImpl", 1, "activity is null");
            if (callback != null) {
                callback.invoke(d(-10, "\u7cfb\u7edf\u9519\u8bef"));
            }
            return false;
        }
        if (params == null) {
            QLog.i("ShareImageImpl", 1, "params is null");
            if (callback != null) {
                callback.invoke(d(-10, MiniSDKConst.AdConst.ERROR_MSG_PARAM_ERROR));
            }
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(params);
            String optString = jSONObject.optString("imgPath", "");
            int optInt = jSONObject.optInt("type", -1);
            if (TextUtils.isEmpty(optString)) {
                QLog.i("ShareImageImpl", 1, "imgPath is empty, " + optString);
                if (callback != null) {
                    callback.invoke(d(-11, "\u56fe\u7247\u4e3a\u7a7a"));
                }
                return false;
            }
            if (optInt == -1) {
                QLog.i("ShareImageImpl", 1, "type is null, " + optInt);
                if (callback != null) {
                    callback.invoke(d(-11, "\u7c7b\u578b\u9519\u8bef"));
                }
                return false;
            }
            module.addKuiklyRenderLifecycleCallback(new b(callback, this));
            ShareImageUtils.shareImage(optString, optInt, activity, new ShareImageUtils.ShareResultCallBack() { // from class: pf2.q
                @Override // com.tencent.hippy.qq.utils.screenshot.ShareImageUtils.ShareResultCallBack
                public final void callBack(int i3) {
                    r.f(Function1.this, this, i3);
                }
            });
            return true;
        } catch (JSONException e16) {
            QLog.i("ShareImageImpl", 1, "shareImage exception happended: " + e16);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject c(int code) {
        String str;
        if (code == 0) {
            str = "\u5206\u4eab\u6210\u529f";
        } else {
            str = ShareJsPlugin.ERRMSG_INVITE_REQUIRE;
        }
        return d(code, str);
    }
}
