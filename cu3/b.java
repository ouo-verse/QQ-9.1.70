package cu3;

import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public int f391864a = 100;

    /* renamed from: b, reason: collision with root package name */
    public int f391865b = 2;

    /* renamed from: c, reason: collision with root package name */
    public boolean f391866c = true;

    /* renamed from: d, reason: collision with root package name */
    private Set<String> f391867d = new HashSet();

    public static void a(b bVar, JSONObject jSONObject) {
        if (bVar == null || jSONObject == null) {
            return;
        }
        QLog.i("QMiniAppConfig", 1, "received miniApp config" + jSONObject);
        if (jSONObject.has("clipboardInterval")) {
            bVar.f391865b = jSONObject.optInt("clipboardInterval");
        }
        if (jSONObject.has("disableContainerVersions")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("disableContainerVersions");
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                bVar.f391867d.add(optJSONArray.optString(i3));
            }
            bVar.f391866c = !bVar.f391867d.contains(AppSetting.f99551k);
        }
        if (jSONObject.has("containerStorageMaxSize")) {
            bVar.f391864a = jSONObject.optInt("containerStorageMaxSize");
        }
    }
}
