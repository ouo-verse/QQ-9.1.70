package com.gyailib.library;

import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SDKModelConfig {
    public Map<String, String> modelPaths;
    public int modelType;
    public int preferPoints;

    public String getModelPaths() {
        StringBuilder sb5 = new StringBuilder();
        for (Map.Entry<String, String> entry : this.modelPaths.entrySet()) {
            sb5.append(entry.getKey());
            sb5.append(" ");
            sb5.append(entry.getValue());
            sb5.append(" ");
        }
        return sb5.toString().trim();
    }

    public int getModel_type() {
        return this.modelType;
    }

    public int getPrefer_points() {
        return this.preferPoints;
    }
}
