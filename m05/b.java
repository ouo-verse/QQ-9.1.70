package m05;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    private long f415957d;

    /* renamed from: f, reason: collision with root package name */
    private long f415959f;

    /* renamed from: a, reason: collision with root package name */
    private boolean f415954a = false;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<String> f415955b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<Integer> f415956c = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private boolean f415958e = true;

    /* renamed from: g, reason: collision with root package name */
    private boolean f415960g = true;

    /* renamed from: h, reason: collision with root package name */
    private boolean f415961h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f415962i = false;

    private static boolean a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return false;
        }
        int perfLevel = DeviceInfoUtils.getPerfLevel();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                if (perfLevel == jSONArray.getInt(i3)) {
                    return true;
                }
            } catch (Throwable th5) {
                QLog.e("IliveManagerCfgBean", 1, "error parse bean " + th5);
            }
        }
        return false;
    }

    public static b b(String str) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (TextUtils.isEmpty(str)) {
            return new b();
        }
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (Integer.parseInt(jSONObject.getString("isLite")) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            bVar.f415954a = z16;
            if (jSONObject.has("heartTimeLong")) {
                bVar.f415957d = Long.parseLong(jSONObject.optString("heartTimeLong"));
            }
            if (jSONObject.has("heartSwitch")) {
                if (Integer.parseInt(jSONObject.optString("heartSwitch")) == 1) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                bVar.f415958e = z18;
            }
            if (jSONObject.has("floatWindowSwitch")) {
                if (Integer.parseInt(jSONObject.optString("floatWindowSwitch")) == 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                bVar.f415960g = z17;
            }
            if (jSONObject.has("floatWindowShowInterval")) {
                bVar.f415959f = Long.parseLong(jSONObject.optString("floatWindowShowInterval"));
            }
            if (jSONObject.has("isEnableSingleWebview")) {
                bVar.f415961h = a(jSONObject.optJSONArray("isEnableSingleWebview"));
            }
            if (jSONObject.has("isEnablePreload")) {
                bVar.f415962i = a(jSONObject.optJSONArray("isEnablePreload"));
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("blackList");
            if (optJSONArray != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    arrayList.add((String) optJSONArray.get(i3));
                }
                bVar.f415955b = arrayList;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("blackVersionList");
            if (optJSONArray2 != null) {
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                    arrayList2.add((Integer) optJSONArray2.get(i16));
                }
                bVar.f415956c = arrayList2;
            }
        } catch (Throwable th5) {
            QLog.e("IliveManagerCfgBean", 1, "error parse bean " + th5);
        }
        return bVar;
    }
}
