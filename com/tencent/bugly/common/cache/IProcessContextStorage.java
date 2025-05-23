package com.tencent.bugly.common.cache;

import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public interface IProcessContextStorage {
    void clearData(String str);

    void clearData(List<String> list);

    void clearExpiredData();

    Map<String, String> load(String str);

    void update(String str, String str2, String str3);

    void update(String str, Map<String, String> map);
}
