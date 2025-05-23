package com.gyailib.librarytest;

import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class CrossTesterConfig {
    public Map<String, String> configMap;

    public String getConfig() {
        StringBuilder sb5 = new StringBuilder();
        for (Map.Entry<String, String> entry : this.configMap.entrySet()) {
            sb5.append(entry.getKey());
            sb5.append(" ");
            sb5.append(entry.getValue());
            sb5.append(" ");
        }
        return sb5.toString().trim();
    }
}
