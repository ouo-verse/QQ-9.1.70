package com.tencent.qqlive.tvkplayer.api;

import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.dex.sdkupdate.TVKUpdateUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import java.util.Map;
import java.util.Properties;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class TVKProperties {
    protected final Properties properties;

    public TVKProperties() {
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

    public void put(String str, String str2) {
        if (str != null) {
            if (!TextUtils.isEmpty(str2)) {
                this.properties.put(str, str2);
            } else {
                this.properties.put(str, "");
            }
        }
    }

    public void putAll(TVKProperties tVKProperties) {
        if (tVKProperties != null) {
            for (Map.Entry entry : tVKProperties.getProperties().entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (value == null) {
                    put(key.toString(), "");
                } else if (value instanceof Integer) {
                    put((String) key, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    put((String) key, ((Long) value).longValue());
                } else if (value instanceof String) {
                    put((String) key, (String) value);
                } else if (value instanceof Properties) {
                    put((String) key, (Properties) value);
                } else if (value instanceof JSONObject) {
                    put((String) key, (JSONObject) value);
                }
            }
        }
    }

    public Object remove(String str) {
        if (str == null) {
            return null;
        }
        return this.properties.remove(str);
    }

    public String toString() {
        return new JSONObject(this.properties).toString();
    }

    public TVKProperties(Properties properties) {
        this.properties = new Properties();
        if (properties != null) {
            for (Map.Entry entry : properties.entrySet()) {
                if (!(entry.getKey() instanceof String)) {
                    TVKUpdateUtils.w(TVKLogUtil.TAG, "TVKProperties constructor properties's key is " + entry.getValue().getClass().getSimpleName() + ",  not String type, ignore");
                    return;
                }
                if (entry.getValue() instanceof Integer) {
                    put((String) entry.getKey(), ((Integer) entry.getValue()).intValue());
                } else if (entry.getValue() instanceof Long) {
                    put((String) entry.getKey(), ((Long) entry.getValue()).longValue());
                } else if (entry.getValue() instanceof String) {
                    put((String) entry.getKey(), (String) entry.getValue());
                } else if (entry.getValue() instanceof Properties) {
                    put((String) entry.getKey(), (Properties) entry.getValue());
                } else if (entry.getValue() instanceof JSONObject) {
                    put((String) entry.getKey(), (JSONObject) entry.getValue());
                } else {
                    TVKUpdateUtils.w(TVKLogUtil.TAG, "TVKProperties constructor properties's value is " + entry.getValue().getClass().getSimpleName() + ", is not support. ignore it.");
                }
            }
        }
    }

    public void put(String str, int i3) {
        if (str != null) {
            this.properties.put(str, String.valueOf(i3));
        }
    }

    public void put(String str, long j3) {
        if (str != null) {
            this.properties.put(str, String.valueOf(j3));
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

    public TVKProperties(Map<String, String> map) {
        this.properties = new Properties();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    public TVKProperties(String str, String str2) {
        this(new Properties(str, str2) { // from class: com.tencent.qqlive.tvkplayer.api.TVKProperties.1
            final /* synthetic */ String val$key;
            final /* synthetic */ String val$value;

            {
                this.val$key = str;
                this.val$value = str2;
                put(str, str2);
            }
        });
    }

    public TVKProperties(Object... objArr) {
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
