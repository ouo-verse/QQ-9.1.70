package com.tencent.hippy.qq.utils;

import java.io.Serializable;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes7.dex */
public class SerializableMap implements Serializable {
    private static final long serialVersionUID = 1;
    private HashMap<String, String> mHashMap;

    public HashMap<String, String> getMap() {
        return this.mHashMap;
    }

    public void wrapMap(HashMap<String, String> hashMap) {
        this.mHashMap = hashMap;
    }
}
