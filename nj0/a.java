package nj0;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.ecommerce.base.ktx.e;
import com.tencent.ecommerce.base.router.api.IECLogicCallback;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.webview.IECWebViewPluginModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00152\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J,\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\"\u0010\u0010\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lnj0/a;", "Lcom/tencent/ecommerce/biz/webview/IECWebViewPluginModel;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "", "reqData", "Lcom/tencent/ecommerce/base/router/api/IECLogicCallback;", "callBack", "", "action", "Landroid/content/Intent;", "intent", "", "requestCode", QzoneIPCModule.RESULT_CODE, "onActivityResult", "a", "Lcom/tencent/ecommerce/base/router/api/IECLogicCallback;", "<init>", "()V", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class a implements IECWebViewPluginModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private IECLogicCallback callBack;

    @Override // com.tencent.ecommerce.biz.webview.IECWebViewPluginModel
    public void onActivityResult(Intent intent, int requestCode, int resultCode) {
        HashMap<String, Object> hashMapOf;
        HashMap<String, Object> hashMapOf2;
        IECWebViewPluginModel.a.a(this, intent, requestCode, resultCode);
        if (resultCode == -1) {
            JSONObject b16 = e.b(new JSONObject(), intent != null ? intent.getStringExtra("selectedAddress") : null);
            if (b16.has("id")) {
                b16.put("id", String.valueOf(b16.optLong("id")));
            }
            IECLogicCallback iECLogicCallback = this.callBack;
            if (iECLogicCallback != null) {
                hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("resultJson", b16));
                iECLogicCallback.onResult(hashMapOf2);
                return;
            }
            return;
        }
        IECLogicCallback iECLogicCallback2 = this.callBack;
        if (iECLogicCallback2 != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("errCode", 1);
            Unit unit = Unit.INSTANCE;
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("resultJson", jSONObject));
            iECLogicCallback2.onResult(hashMapOf);
        }
    }

    @Override // com.tencent.ecommerce.biz.webview.IECWebViewPluginModel
    public void action(Activity activity, Map<String, ?> reqData, IECLogicCallback callBack) {
        JSONObject jSONObject;
        Map mutableMapOf;
        if (activity == null) {
            cg0.a.a("ECGetAddressProcessor", "action", "activity is null, can not open address manager page");
            return;
        }
        ECAddress.Companion companion = ECAddress.INSTANCE;
        Object obj = reqData.get("requestJson");
        if (!(obj instanceof String)) {
            obj = null;
        }
        String str = (String) obj;
        if (str == null || (jSONObject = e.b(new JSONObject(), str)) == null) {
            jSONObject = new JSONObject();
        }
        ECAddress b16 = companion.b(jSONObject);
        this.callBack = callBack;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("addressId", String.valueOf(b16 != null ? b16.id : -1L));
        pairArr[1] = TuplesKt.to("is_trans_activity", "1");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        Object obj2 = reqData.get("requestCode");
        Integer num = (Integer) (obj2 instanceof Integer ? obj2 : null);
        yi0.a.u(activity, num != null ? num.intValue() : -1, Uri.parse(String.valueOf(28)), mutableMapOf);
        activity.overridePendingTransition(0, 0);
    }
}
