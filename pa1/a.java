package pa1;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a implements rb1.a<String> {

    /* renamed from: d, reason: collision with root package name */
    public boolean f425844d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f425845e = false;

    /* renamed from: f, reason: collision with root package name */
    public String f425846f = "";

    @Override // rb1.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onParse(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QDatalineHttpsConfigBean", 1, "receiveAllConfigs|type: 637configContent is empty");
            return;
        }
        this.f425846f = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("UseNewHttpClient");
            if (jSONObject2 != null) {
                try {
                    this.f425844d = jSONObject2.getBoolean("AQQ");
                    if (QLog.isColorLevel()) {
                        QLog.d("QDatalineHttpsConfigBean", 2, "UseNewHttpClient = " + this.f425844d);
                    }
                } catch (JSONException e16) {
                    QLog.e("QDatalineHttpsConfigBean", 1, e16, new Object[0]);
                }
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject("UseHttps");
            if (jSONObject3 != null) {
                try {
                    this.f425845e = jSONObject3.getBoolean("AQQ");
                    if (QLog.isColorLevel()) {
                        QLog.d("QDatalineHttpsConfigBean", 2, "UseHttpsConnect = " + this.f425845e);
                    }
                } catch (JSONException e17) {
                    QLog.e("QDatalineHttpsConfigBean", 1, e17, new Object[0]);
                }
            }
        } catch (JSONException e18) {
            QLog.e("QDatalineHttpsConfigBean", 1, e18, new Object[0]);
        }
    }
}
