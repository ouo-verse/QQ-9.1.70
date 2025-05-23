package com.tencent.bugly.common.cache;

import android.text.TextUtils;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes5.dex */
class ProcessContextLoaderImpl implements IProcessContextLoader {
    private ConcurrentHashMap<String, String> cache;

    public ProcessContextLoaderImpl(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            this.cache = new ConcurrentHashMap<>();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.cache.put(entry.getKey(), entry.getValue());
            }
        }
    }

    private String getValue(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.cache) == null) {
            return null;
        }
        return concurrentHashMap.get(str);
    }

    @Override // com.tencent.bugly.common.cache.IProcessContextLoader
    public Set<String> getAllKeys() {
        ConcurrentHashMap<String, String> concurrentHashMap = this.cache;
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.keySet();
    }

    @Override // com.tencent.bugly.common.cache.IProcessContextLoader
    public boolean getBoolean(String str, boolean z16) {
        String value = getValue(str);
        if (!TextUtils.isEmpty(value)) {
            try {
            } catch (Throwable unused) {
                return z16;
            }
        }
        return Boolean.parseBoolean(value);
    }

    @Override // com.tencent.bugly.common.cache.IProcessContextLoader
    public double getDouble(String str, double d16) {
        String value = getValue(str);
        if (!TextUtils.isEmpty(value)) {
            try {
            } catch (Throwable unused) {
                return d16;
            }
        }
        return Double.parseDouble(value);
    }

    @Override // com.tencent.bugly.common.cache.IProcessContextLoader
    public JSONObject getJSONObject(String str, JSONObject jSONObject) {
        String value = getValue(str);
        if (value != null) {
            try {
                return new JSONObject(value);
            } catch (Throwable unused) {
                return new JSONObject();
            }
        }
        return jSONObject;
    }

    @Override // com.tencent.bugly.common.cache.IProcessContextLoader
    public List<String> getList(String str, List<String> list) {
        String value = getValue(str);
        if (value != null) {
            return ProcessContextUtil.stringToList(value);
        }
        return list;
    }

    @Override // com.tencent.bugly.common.cache.IProcessContextLoader
    public long getLong(String str, long j3) {
        String value = getValue(str);
        if (!TextUtils.isEmpty(value)) {
            try {
            } catch (Throwable unused) {
                return j3;
            }
        }
        return Long.parseLong(value);
    }

    @Override // com.tencent.bugly.common.cache.IProcessContextLoader
    public String getString(String str, String str2) {
        String value = getValue(str);
        if (value != null) {
            return value;
        }
        return str2;
    }
}
