package he1;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.api.ISpringHbTempApi;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public d f404798a = new d(0, 0);

    /* renamed from: b, reason: collision with root package name */
    public Map<String, a> f404799b = new HashMap();

    private a a(String str) {
        Map<String, a> map = this.f404799b;
        if (map == null) {
            return null;
        }
        for (a aVar : map.values()) {
            if (aVar != null && f(aVar.f404793g) && aVar.f404795i == 0 && str.equals(aVar.f404789c)) {
                return aVar;
            }
        }
        return null;
    }

    private a b(String str) {
        Map<String, a> map = this.f404799b;
        a aVar = null;
        if (map == null) {
            return null;
        }
        for (a aVar2 : map.values()) {
            if (aVar2 != null && f(aVar2.f404793g) && aVar2.f404795i == 1 && str.contains(aVar2.f404789c) && (aVar == null || aVar.f404794h < aVar2.f404794h)) {
                aVar = aVar2;
            }
        }
        return aVar;
    }

    public static boolean d(d dVar, long j3) {
        if (dVar == null) {
            QLog.w("SearchPopConfig", 1, "isInTime --> timeInfo is null");
            return false;
        }
        if (!e(dVar)) {
            return false;
        }
        if (dVar.f404802a <= j3 && j3 <= dVar.f404803b) {
            return true;
        }
        return false;
    }

    public static boolean e(d dVar) {
        long j3 = dVar.f404802a;
        if (j3 > 0 && dVar.f404803b > j3) {
            return true;
        }
        return false;
    }

    private boolean f(d dVar) {
        if (dVar != null && dVar.f404802a != 0 && dVar.f404803b != 0) {
            return c(dVar);
        }
        return true;
    }

    private void h(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("PopAnim");
        if (optJSONArray == null) {
            return;
        }
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            if (optJSONObject != null) {
                a aVar = new a();
                aVar.a(optJSONObject);
                if (!TextUtils.isEmpty(aVar.f404789c)) {
                    this.f404799b.put(aVar.f404789c, aVar);
                }
            }
        }
    }

    public boolean c(d dVar) {
        return d(dVar, NetConnInfoCenter.getServerTimeMillis());
    }

    public a g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!c(this.f404798a)) {
            QLog.w("SearchPopConfig", 1, "matchSearchPopAnim not in activity time");
        }
        a a16 = a(str);
        if (a16 != null) {
            return a16;
        }
        return b(str);
    }

    public void i(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("SearchConfig")) == null) {
            return;
        }
        this.f404798a.f404802a = ((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).parseTime(optJSONObject.optString("BeginTime")).longValue();
        this.f404798a.f404803b = ((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).parseTime(optJSONObject.optString("EndTime")).longValue();
        h(optJSONObject);
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("{");
        Iterator<a> it = this.f404799b.values().iterator();
        while (it.hasNext()) {
            sb5.append(it.next().toString());
            sb5.append(", ");
        }
        sb5.append("}");
        return "DragonCardConfigData{, beginTime=" + this.f404798a.f404802a + ", endTime=" + this.f404798a.f404803b + ", Items='" + ((Object) sb5) + "}";
    }
}
