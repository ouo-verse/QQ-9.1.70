package ol0;

import android.text.TextUtils;
import com.tencent.mobileqq.config.ai;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f423083a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f423084b = 0;

    /* renamed from: c, reason: collision with root package name */
    public List<String> f423085c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<String> f423086d = new ArrayList<>();

    public static a a(ai[] aiVarArr) {
        JSONArray optJSONArray;
        a aVar = new a();
        for (ai aiVar : aiVarArr) {
            try {
                JSONObject jSONObject = new JSONObject(aiVar.f202268b);
                if (jSONObject.has("isNeedfloatingPermission")) {
                    aVar.f423083a = jSONObject.optInt("isNeedfloatingPermission");
                    if (QLog.isColorLevel()) {
                        QLog.d("Wadl_FloatingPermissionConfBean", 1, "onParsed isNeedfloatingPermission=" + aVar.f423083a);
                    }
                }
                if (jSONObject.has("isNeedInstallPermission")) {
                    aVar.f423084b = jSONObject.optInt("isNeedInstallPermission");
                    if (QLog.isColorLevel()) {
                        QLog.d("Wadl_FloatingPermissionConfBean", 1, "onParsed isNeedInstallPermission=" + aVar.f423084b);
                    }
                }
                if (jSONObject.has("needPermissionAppids") && (optJSONArray = jSONObject.optJSONArray("needPermissionAppids")) != null) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        String string = optJSONArray.getString(i3);
                        if (!TextUtils.isEmpty(string)) {
                            aVar.f423085c.add(string);
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("urlMatchPatterns");
                if (optJSONArray2 != null) {
                    for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                        aVar.f423086d.add(optJSONArray2.optString(i16));
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("Wadl_FloatingPermissionConfBean", 2, "onParsed urlMatchPatterns=" + optJSONArray2);
                    }
                }
            } catch (Throwable th5) {
                QLog.e("Wadl_FloatingPermissionConfBean", 1, "FloatingPermissionConfBean parse error e=" + th5.toString());
            }
        }
        return aVar;
    }

    public String toString() {
        return "FloatingPermissionConfBean{isNeedfloatingPermission=" + this.f423083a + ", isNeedInstallPermission=" + this.f423084b + ", needPermissionAddids=" + this.f423085c + '}';
    }
}
