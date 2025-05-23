package ir2;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f408426a;

    /* renamed from: b, reason: collision with root package name */
    public String f408427b;

    /* renamed from: c, reason: collision with root package name */
    public int f408428c;

    /* renamed from: d, reason: collision with root package name */
    public String f408429d;

    /* renamed from: e, reason: collision with root package name */
    public String f408430e;

    /* renamed from: f, reason: collision with root package name */
    public int f408431f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f408432g;

    public static a a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has("retcode") && jSONObject.getInt("retcode") == 0 && jSONObject.has("data")) {
                    a aVar = new a();
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    if (jSONObject2 != null) {
                        aVar.f408426a = jSONObject2.optString("url");
                        aVar.f408427b = jSONObject2.optString("title");
                        aVar.f408428c = jSONObject2.optInt("localPadId");
                        aVar.f408429d = jSONObject2.optString("localPadId");
                        aVar.f408430e = jSONObject2.optString("doc_id");
                        aVar.f408431f = jSONObject2.optInt("doc_type");
                        aVar.f408432g = jSONObject2.optBoolean(QAdRewardDefine$VideoParams.ISCACHE);
                    }
                    return aVar;
                }
                return null;
            } catch (JSONException e16) {
                QLog.e("ImportFormData", 1, e16.getLocalizedMessage(), e16);
                return null;
            }
        }
        return null;
    }
}
