package d91;

import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class e implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    private List<e91.d> f393222d;

    public e() {
    }

    public static e b(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("ArkExtendInfo");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                String optString = jSONObject.optString("app");
                String optString2 = jSONObject.optString("view");
                String optString3 = jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC);
                int optInt = jSONObject.optInt("width");
                int optInt2 = jSONObject.optInt("height");
                e91.d dVar = new e91.d();
                dVar.c(optString);
                dVar.f(optString2);
                dVar.d(optString3);
                dVar.e(optInt2);
                dVar.g(optInt);
                arrayList.add(dVar);
            }
        } catch (Exception e16) {
            QLog.e("ArkApp.ArkExtendConfBean", 1, "ArkExtendConfBean onParse " + e16);
        }
        return new e(arrayList);
    }

    public List<e91.d> a() {
        return this.f393222d;
    }

    public e(List<e91.d> list) {
        this.f393222d = list;
    }
}
