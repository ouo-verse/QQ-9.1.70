package d91;

import com.tencent.freesia.IConfigData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.util.QQCustomArkDialogUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class f implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    private List<e91.e> f393223d;

    public f(List<e91.e> list) {
        this.f393223d = list;
    }

    public static f b(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("favArk");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                String optString = jSONObject.optString("app");
                String optString2 = jSONObject.optString("arkView");
                String optString3 = jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC);
                int optInt = jSONObject.optInt("type");
                String optString4 = jSONObject.optString("title");
                String optString5 = jSONObject.optString("tag");
                String optString6 = jSONObject.optString(WadlProxyConsts.KEY_JUMP_URL);
                String optString7 = jSONObject.optString("desc");
                String optString8 = jSONObject.optString("preview");
                String optString9 = jSONObject.optString("url");
                boolean optBoolean = jSONObject.optBoolean("httpEnable");
                e91.e eVar = new e91.e();
                eVar.l(optString);
                eVar.m(optString2);
                eVar.n(optString3);
                eVar.u(optInt);
                eVar.t(optString4);
                eVar.s(optString5);
                eVar.q(optString6);
                eVar.o(optString7);
                eVar.r(optString8);
                eVar.v(optString9);
                eVar.p(optBoolean);
                arrayList.add(eVar);
            }
        } catch (Exception unused) {
        }
        return new f(arrayList);
    }

    public List<e91.e> a() {
        return this.f393223d;
    }

    public f() {
    }
}
