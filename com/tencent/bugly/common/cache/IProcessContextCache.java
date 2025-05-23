package com.tencent.bugly.common.cache;

import java.util.List;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public interface IProcessContextCache {
    void apply();

    void commit();

    void put(String str, double d16);

    void put(String str, long j3);

    void put(String str, String str2);

    void put(String str, List<String> list);

    void put(String str, JSONObject jSONObject);

    void put(String str, boolean z16);
}
