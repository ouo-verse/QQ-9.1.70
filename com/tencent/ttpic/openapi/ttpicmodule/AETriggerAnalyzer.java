package com.tencent.ttpic.openapi.ttpicmodule;

import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.IAIDataClassifier;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AETriggerAnalyzer {
    private static final AETriggerAnalyzer ourInstance = new AETriggerAnalyzer();
    private HashMap<String, IAIDataClassifier> classifierMap = new HashMap<>();

    AETriggerAnalyzer() {
    }

    public static AETriggerAnalyzer getInstance() {
        return ourInstance;
    }

    public void addClassifier(IAIDataClassifier iAIDataClassifier) {
        this.classifierMap.put(iAIDataClassifier.getClass().getName(), iAIDataClassifier);
        AEDependencyManager.getInstance().loadDependency(iAIDataClassifier.getModuleName());
    }

    public IAIDataClassifier getClassifier(String str) {
        if (str != null && !str.isEmpty()) {
            return this.classifierMap.get(str);
        }
        return null;
    }

    public boolean isTriggered(String str, AIAttr aIAttr) {
        String[] split = str.split("-");
        if (split.length != 2) {
            return false;
        }
        String str2 = split[0];
        try {
            int parseInt = Integer.parseInt(split[1]);
            IAIDataClassifier classifier = getInstance().getClassifier(str2);
            if (classifier == null) {
                return false;
            }
            int classifyData2Type = classifier.classifyData2Type(aIAttr);
            if (!classifier.getClassifierTypeMap().containsValue(Integer.valueOf(classifyData2Type)) || parseInt != classifyData2Type) {
                return false;
            }
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public void removeClassifier(IAIDataClassifier iAIDataClassifier) {
        this.classifierMap.remove(iAIDataClassifier);
        AEDependencyManager.getInstance().unloadDependency(iAIDataClassifier.getModuleName());
    }
}
