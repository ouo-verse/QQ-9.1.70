package com.tencent.aekit.plugin.core;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IAIDataClassifier {
    int classifyData2Type(AIAttr aIAttr);

    HashMap<String, Integer> getClassifierTypeMap();

    String getModuleName();
}
