package com.tencent.bugly.common.cache;

import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public interface IProcessContextLoader {
    Set<String> getAllKeys();

    boolean getBoolean(String str, boolean z16);

    double getDouble(String str, double d16);

    JSONObject getJSONObject(String str, JSONObject jSONObject);

    List<String> getList(String str, List<String> list);

    long getLong(String str, long j3);

    String getString(String str, String str2);
}
