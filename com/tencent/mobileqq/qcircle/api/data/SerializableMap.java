package com.tencent.mobileqq.qcircle.api.data;

import java.io.Serializable;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes16.dex */
public class SerializableMap implements Serializable {
    private static final long serialVersionUID = 1;
    private Map mHashMap;

    public Map getMap() {
        return this.mHashMap;
    }

    public void setMap(Map map) {
        this.mHashMap = map;
    }
}
