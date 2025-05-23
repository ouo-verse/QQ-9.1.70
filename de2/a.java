package de2;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    public boolean f393656d = false;

    /* renamed from: e, reason: collision with root package name */
    public int f393657e = 200;

    /* renamed from: f, reason: collision with root package name */
    public boolean f393658f = false;

    /* renamed from: h, reason: collision with root package name */
    public List<String> f393659h = new ArrayList();

    public static a a(String str) {
        a aVar = new a();
        if (TextUtils.isEmpty(str)) {
            return aVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("is_open_dex_monitor")) {
                aVar.f393656d = jSONObject.getBoolean("is_open_dex_monitor");
            }
            if (jSONObject.has("report_sample")) {
                aVar.f393657e = jSONObject.getInt("report_sample");
            }
            if (jSONObject.has("is_need_transform")) {
                aVar.f393658f = jSONObject.getBoolean("is_need_transform");
            }
            if (jSONObject.has("transform_list")) {
                JSONArray jSONArray = jSONObject.getJSONArray("transform_list");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    aVar.f393659h.add(jSONArray.getString(i3));
                }
            }
        } catch (JSONException e16) {
            QLog.e("DexMonitorConfigBean", 1, e16, new Object[0]);
        }
        return aVar;
    }

    public String toString() {
        return "DexMonitorConfigBean{isOpenDexMonitor=" + this.f393656d + ", reportSample=" + this.f393657e + ", isNeedTransform=" + this.f393658f + ", TransformList=" + this.f393659h + '}';
    }
}
