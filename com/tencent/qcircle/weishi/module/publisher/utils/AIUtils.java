package com.tencent.qcircle.weishi.module.publisher.utils;

import com.tencent.qcircle.weishi.module.publisher.data.AbilityPresetData;
import com.tencent.qcircle.weishi.module.publisher.data.AiModelInfo;
import com.tencent.qcircle.weishi.module.publisher.model.AIModelConfig;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AIUtils {
    public static List<AiModelInfo> getAiModelPath(AbilityPresetData abilityPresetData, Map<String, String> map, boolean z16) {
        Map<String, Boolean> supportAbility;
        if (z16) {
            supportAbility = abilityPresetData.getAiParams();
        } else {
            supportAbility = getSupportAbility(abilityPresetData);
        }
        ArrayList arrayList = new ArrayList();
        Map<String, String> aiModelAgentMap = AIModelConfig.getAiModelAgentMap();
        if (!CollectionUtil.isEmptyMap(supportAbility) && !CollectionUtil.isEmptyMap(aiModelAgentMap)) {
            Iterator<Map.Entry<String, Boolean>> it = supportAbility.entrySet().iterator();
            HashMap hashMap = new HashMap();
            while (it.hasNext()) {
                String key = it.next().getKey();
                if (aiModelAgentMap.containsKey(key) && aiModelAgentMap.get(key) != null) {
                    String str = aiModelAgentMap.get(key);
                    Objects.requireNonNull(str);
                    hashMap.put(key, str);
                }
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                String str2 = (String) entry.getKey();
                String str3 = (String) entry.getValue();
                if (map != null && map.containsKey(str2)) {
                    arrayList.add(new AiModelInfo(map.get(str2), str3));
                }
            }
        }
        return arrayList;
    }

    public static Map<String, Boolean> getSupportAbility(AbilityPresetData abilityPresetData) {
        HashMap hashMap = new HashMap();
        if (abilityPresetData == null) {
            return hashMap;
        }
        for (Map.Entry<String, Boolean> entry : abilityPresetData.getAiParams().entrySet()) {
            String key = entry.getKey();
            boolean booleanValue = entry.getValue().booleanValue();
            if (booleanValue) {
                hashMap.put(key, Boolean.valueOf(booleanValue));
            }
        }
        return hashMap;
    }

    public static void updateLightAIModelPath() {
    }
}
