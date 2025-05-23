package ap2;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    private List<Integer> f26683d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private HashMap<String, String> f26684e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private boolean f26685f;

    public static HashMap<String, String> c(JSONObject jSONObject) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            hashMap.put(str, jSONObject.optString(str, ""));
        }
        return hashMap;
    }

    public static d d(String str) {
        d dVar = new d();
        if (TextUtils.isEmpty(str)) {
            return dVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            dVar.f26683d = e(jSONObject.optJSONArray("disableKeyTypeList"));
            dVar.f26684e = c(jSONObject.optJSONObject("modelDisplayNameByType"));
            dVar.f26685f = jSONObject.optBoolean("isEnterKeyboardOpenNetSearch");
        } catch (JSONException e16) {
            QLog.e("SearchEntryConfig", 1, e16, new Object[0]);
        }
        return dVar;
    }

    public static List<Integer> e(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            String optString = jSONArray.optString(i3);
            if (!TextUtils.isEmpty(optString)) {
                arrayList.add(Integer.valueOf(Integer.parseInt(optString)));
            }
        }
        return arrayList;
    }

    public List<Integer> a() {
        return this.f26683d;
    }

    public HashMap<String, String> b() {
        return this.f26684e;
    }
}
