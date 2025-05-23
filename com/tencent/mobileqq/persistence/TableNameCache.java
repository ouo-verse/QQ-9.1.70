package com.tencent.mobileqq.persistence;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class TableNameCache {
    public boolean isInit = false;
    private ConcurrentHashMap<String, Boolean> tbnCache = new ConcurrentHashMap<>();

    public void addToTableNameCache(String str) {
        this.tbnCache.put(str, Boolean.TRUE);
    }

    public void deleteFromTableCache(String str) {
        this.tbnCache.remove(str);
    }

    public String[] getAllTableNames() {
        Set<String> keySet = this.tbnCache.keySet();
        String[] strArr = new String[keySet.size()];
        keySet.toArray(strArr);
        return strArr;
    }

    public void initTableCache(String[] strArr) {
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            this.tbnCache.put(str, Boolean.TRUE);
        }
        this.isInit = true;
    }

    public boolean isContainsTableInCache(String str) {
        return this.tbnCache.containsKey(str);
    }
}
