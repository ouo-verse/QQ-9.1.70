package com.huawei.agconnect.config.impl;

import android.util.Log;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
class h implements d {

    /* renamed from: a, reason: collision with root package name */
    private final JSONObject f36497a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(InputStream inputStream, String str) {
        this.f36497a = a(inputStream);
        a(str);
    }

    private JSONObject b(String str) throws JSONException {
        JSONArray jSONArray = this.f36497a.getJSONArray("appInfos");
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            if (jSONObject.getString("package_name").equals(str)) {
                return jSONObject;
            }
        }
        return null;
    }

    @Override // com.huawei.agconnect.config.impl.d
    public String a(String str, String str2) {
        if (str.endsWith("/")) {
            return str2;
        }
        String[] split = str.split("/");
        try {
            JSONObject jSONObject = this.f36497a;
            for (int i3 = 1; i3 < split.length; i3++) {
                if (i3 == split.length - 1) {
                    str = jSONObject.get(split[i3]).toString();
                    return str;
                }
                jSONObject = jSONObject.getJSONObject(split[i3]);
            }
        } catch (JSONException unused) {
            Log.w("InputStreamReader", "JSONException when reading 'path': " + str);
        }
        return str2;
    }

    public String toString() {
        return "InputStreamReader{config=" + this.f36497a.toString().hashCode() + '}';
    }

    private JSONObject a(InputStream inputStream) {
        String str;
        if (inputStream != null) {
            try {
                return new JSONObject(Utils.toString(inputStream, "UTF-8"));
            } catch (IOException unused) {
                str = "IOException when reading the 'Config' from InputStream.";
                Log.e("InputStreamReader", str);
                return new JSONObject();
            } catch (JSONException unused2) {
                str = "JSONException when reading the 'Config' from InputStream.";
                Log.e("InputStreamReader", str);
                return new JSONObject();
            }
        }
        return new JSONObject();
    }

    private void a(String str) {
        try {
            JSONObject b16 = b(str);
            if (b16 == null) {
                return;
            }
            String a16 = a("/configuration_version", "");
            BigDecimal bigDecimal = new BigDecimal("0.0");
            try {
                bigDecimal = BigDecimal.valueOf(Double.parseDouble(a16));
            } catch (NumberFormatException unused) {
                Log.d("InputStreamReader", "configuration_version to double error");
            }
            if (bigDecimal.compareTo(new BigDecimal(SemanticAttributes.HttpFlavorValues.HTTP_2_0)) == 0) {
                this.f36497a.getJSONObject("client").put("app_id", b16.getString("app_id"));
                return;
            }
            if (bigDecimal.compareTo(new BigDecimal("3.0")) >= 0) {
                Iterator keys = b16.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    if (!"package_name".equals(str2)) {
                        a(str2, b16.get(str2), this.f36497a);
                    }
                }
            }
        } catch (JSONException unused2) {
            Log.d("InputStreamReader", "JSONException when reading the 'appInfos' from InputStream.");
        }
    }

    private void a(String str, Object obj, JSONObject jSONObject) throws JSONException {
        if (str == null || obj == null || jSONObject == null) {
            return;
        }
        if (!(obj instanceof JSONObject)) {
            jSONObject.put(str, obj);
            return;
        }
        JSONObject jSONObject2 = (JSONObject) obj;
        Iterator keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            a(str2, jSONObject2.get(str2), jSONObject.getJSONObject(str));
        }
    }
}
