package com.huawei.hms.framework.common.hianalytics;

import java.util.LinkedHashMap;

/* loaded from: classes2.dex */
public class LinkedHashMapPack {
    private LinkedHashMap<String, String> map = new LinkedHashMap<>();

    public LinkedHashMap<String, String> getAll() {
        return this.map;
    }

    public LinkedHashMapPack put(String str, String str2) {
        if (str != null && str2 != null) {
            this.map.put(str, str2);
        }
        return this;
    }

    public LinkedHashMapPack putIfNotDefault(String str, long j3, long j16) {
        if (j3 == j16) {
            return this;
        }
        return put(str, j3);
    }

    public LinkedHashMapPack put(String str, boolean z16) {
        if (str != null) {
            if (z16) {
                this.map.put(str, "1");
            } else {
                this.map.put(str, "0");
            }
        }
        return this;
    }

    public LinkedHashMapPack put(String str, long j3) {
        if (str != null) {
            this.map.put(str, "" + j3);
        }
        return this;
    }
}
