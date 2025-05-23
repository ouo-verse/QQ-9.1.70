package com.tencent.thumbplayer.report.reportv1;

import android.text.TextUtils;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.report.ITPReportProperties;
import java.util.Map;
import java.util.Properties;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes26.dex */
public class TPProperties implements ITPReportProperties {
    private static final String TAG = "TPProperties";
    protected final Properties properties;

    public TPProperties() {
        this((Properties) null);
    }

    public Properties getProperties() {
        return this.properties;
    }

    public boolean has(String str) {
        if (str == null || this.properties.get(str) == null) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.thumbplayer.report.ITPReportProperties
    public void propertiesToMap(Map<String, String> map) {
        if (map != null) {
            for (Map.Entry entry : this.properties.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (value == null) {
                    map.put(key.toString(), "");
                } else {
                    map.put(key.toString(), value.toString());
                }
            }
            return;
        }
        throw new IllegalArgumentException("map must not be null!");
    }

    @Override // com.tencent.thumbplayer.report.ITPReportProperties
    public void put(String str, String str2) {
        if (str != null) {
            if (!TextUtils.isEmpty(str2)) {
                this.properties.put(str, str2);
            } else {
                this.properties.put(str, "");
            }
        }
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject(this.properties);
        if (jSONObject.has("data")) {
            try {
                String string = jSONObject.getString("data");
                jSONObject.remove("data");
                jSONObject.put("data", new JSONObject(string));
            } catch (JSONException e16) {
                TPLogUtil.e(TAG, e16);
            }
        }
        return jSONObject.toString();
    }

    public TPProperties(Properties properties) {
        this.properties = new Properties();
        if (properties != null) {
            for (Map.Entry entry : properties.entrySet()) {
                put((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    @Override // com.tencent.thumbplayer.report.ITPReportProperties
    public void put(String str, int i3) {
        if (str != null) {
            this.properties.put(str, String.valueOf(i3));
        }
    }

    @Override // com.tencent.thumbplayer.report.ITPReportProperties
    public void put(String str, long j3) {
        if (str != null) {
            this.properties.put(str, String.valueOf(j3));
        }
    }

    public TPProperties(Map<String, String> map) {
        this.properties = new Properties();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override // com.tencent.thumbplayer.report.ITPReportProperties
    public void put(String str, float f16) {
        if (str != null) {
            this.properties.put(str, String.valueOf(f16));
        }
    }

    public void put(String str, Properties properties) {
        if (str != null) {
            this.properties.put(str, properties);
        }
    }

    public void put(String str, JSONObject jSONObject) {
        if (str != null) {
            this.properties.put(str, jSONObject);
        }
    }

    public TPProperties(String str, String str2) {
        this(new Properties(str, str2) { // from class: com.tencent.thumbplayer.report.reportv1.TPProperties.1
            final /* synthetic */ String val$key;
            final /* synthetic */ String val$value;

            {
                this.val$key = str;
                this.val$value = str2;
                put(str, str2);
            }
        });
    }

    public TPProperties(Object... objArr) {
        this.properties = new Properties();
        int length = objArr.length;
        if (length % 2 != 0) {
            throw new IllegalArgumentException("Supplied arguments must be even");
        }
        for (int i3 = 0; i3 < length; i3 += 2) {
            put(String.valueOf(objArr[i3]), String.valueOf(objArr[i3 + 1]));
        }
    }
}
