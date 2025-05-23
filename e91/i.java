package e91;

import android.text.TextUtils;
import com.tencent.mobileqq.config.n;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class i extends f implements n<String> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f395987a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f395988b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f395989c = false;

    /* renamed from: d, reason: collision with root package name */
    public String f395990d = "";

    /* renamed from: e, reason: collision with root package name */
    public boolean f395991e = false;

    /* renamed from: f, reason: collision with root package name */
    public String f395992f = "";

    /* renamed from: g, reason: collision with root package name */
    public HashMap<String, ArrayList<String>> f395993g = new HashMap<>();

    @Override // com.tencent.mobileqq.config.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onParse(String str) {
        boolean z16;
        if (TextUtils.isEmpty(str)) {
            QLog.i("DialogConfig", 1, "onParse,fileOrRes is null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f395987a = f.a(jSONObject, "ark_map_transfer_struct");
            this.f395992f = f.b(jSONObject, "business_percent");
            if (jSONObject.optInt("ark_use_android_http", 0) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f395988b = z16;
            this.f395989c = f.a(jSONObject, "ark_engine_multi_thread");
            this.f395990d = f.b(jSONObject, "ark_engine_hardware_rendering_device_matcher");
            this.f395991e = f.a(jSONObject, "ark_engine_disable_hardware_rendering");
            QLog.i("DialogConfig", 1, "mArkMapTransferStruct=" + this.f395987a + ", mBusinessPercent=" + this.f395992f + ", mArkUseAndroidHttp=" + this.f395988b + ", mArkEngineMultiThread" + this.f395989c + ", mArkEngineHardwareRenderingDeviceMatcher=" + this.f395990d + ", mArkEngineDisableHardwareRendering=" + this.f395991e);
            JSONObject optJSONObject = jSONObject.optJSONObject("msgai_intent_app_map");
            if (optJSONObject != null) {
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    QLog.i("DialogConfig", 1, "msgai_intent_app_map, intent = " + str2);
                    JSONArray optJSONArray = optJSONObject.optJSONArray(str2);
                    if (optJSONArray != null) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                            String optString = optJSONArray.optString(i3);
                            QLog.i("DialogConfig", 1, "msgai_intent_app_map, appID = " + optString);
                            if (!TextUtils.isEmpty(optString)) {
                                arrayList.add(optString);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            this.f395993g.put(str2, arrayList);
                        }
                    }
                }
            }
        } catch (JSONException e16) {
            QLog.e("DialogConfig", 1, String.format("updateDialogConfig, parse json fail, json=%s, err=%s", str, e16.getMessage()));
        }
    }

    public boolean d(String str) {
        if ("com.tencent.xsj.collection".equals(str) || TextUtils.isEmpty(str) || str.startsWith("com.tencent.wezone")) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "DialogConfig{mArkMapTransferStruct=" + this.f395987a + ", mArkUseAndroidHttp=" + this.f395988b + ", mArkEngineMultiThread=" + this.f395989c + ", mArkEngineHardwareRenderingDeviceMatcher='" + this.f395990d + "', mArkEngineDisableHardwareRendering=" + this.f395991e + ", mBusinessPercent='" + this.f395992f + "', mIntentAppMap=" + this.f395993g + '}';
    }
}
