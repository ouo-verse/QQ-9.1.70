package nj0;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.tencent.ecommerce.base.ktx.e;
import com.tencent.ecommerce.base.router.api.IECLogicCallback;
import com.tencent.ecommerce.biz.pay.ECEmptyPayFragment;
import com.tencent.ecommerce.biz.webview.IECWebViewPluginModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u00162\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J,\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\"\u0010\u0010\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lnj0/b;", "Lcom/tencent/ecommerce/biz/webview/IECWebViewPluginModel;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "", "reqData", "Lcom/tencent/ecommerce/base/router/api/IECLogicCallback;", "callBack", "", "action", "Landroid/content/Intent;", "intent", "", "requestCode", QzoneIPCModule.RESULT_CODE, "onActivityResult", "a", "Lcom/tencent/ecommerce/base/router/api/IECLogicCallback;", "callback", "<init>", "()V", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class b implements IECWebViewPluginModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private IECLogicCallback callback;

    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006b  */
    @Override // com.tencent.ecommerce.biz.webview.IECWebViewPluginModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void action(Activity activity, Map<String, ?> reqData, IECLogicCallback callBack) {
        boolean z16;
        HashMap<String, Object> hashMapOf;
        boolean isBlank;
        Object obj = reqData.get("requestJson");
        if (!(obj instanceof String)) {
            obj = null;
        }
        String str = (String) obj;
        JSONObject b16 = str != null ? e.b(new JSONObject(), str) : null;
        String optString = b16 != null ? b16.optString("url_params") : null;
        if (optString != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(optString);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    cg0.a.a("ECPayWebViewPluginModel", "action", "pay url params is null or empty");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("errCode", 2);
                    jSONObject.put("errMsg", "url params is null or empty");
                    hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("resultJson", jSONObject));
                    callBack.onResult(hashMapOf);
                    return;
                }
                if (activity != null) {
                    this.callback = callBack;
                    Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("url_params", optString), TuplesKt.to("is_trans_activity", "1"));
                    Object obj2 = reqData.get("requestCode");
                    Integer num = (Integer) (obj2 instanceof Integer ? obj2 : null);
                    yi0.a.q(activity, ECEmptyPayFragment.class, bundleOf, num != null ? num.intValue() : -1, null, 16, null);
                    activity.overridePendingTransition(0, 0);
                    return;
                }
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    @Override // com.tencent.ecommerce.biz.webview.IECWebViewPluginModel
    public void onActivityResult(Intent intent, int requestCode, int resultCode) {
        HashMap<String, Object> hashMapOf;
        IECWebViewPluginModel.a.a(this, intent, requestCode, resultCode);
        if (resultCode == -1) {
            String stringExtra = intent != null ? intent.getStringExtra("payResult") : null;
            IECLogicCallback iECLogicCallback = this.callback;
            if (iECLogicCallback != null) {
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("resultJson", e.b(new JSONObject(), stringExtra)));
                iECLogicCallback.onResult(hashMapOf);
            }
        }
    }
}
