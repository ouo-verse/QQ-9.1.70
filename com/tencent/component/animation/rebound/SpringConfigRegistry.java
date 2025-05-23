package com.tencent.component.animation.rebound;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SpringConfigRegistry {
    private static final SpringConfigRegistry INSTANCE = new SpringConfigRegistry(true);
    private final Map<SpringConfig, String> mSpringConfigMap = new HashMap();

    SpringConfigRegistry(boolean z16) {
        if (z16) {
            addSpringConfig(SpringConfig.defaultConfig, "default config");
        }
    }

    public static SpringConfigRegistry getInstance() {
        return INSTANCE;
    }

    public boolean addSpringConfig(SpringConfig springConfig, String str) {
        if (springConfig != null) {
            if (str != null) {
                if (this.mSpringConfigMap.containsKey(springConfig)) {
                    return false;
                }
                this.mSpringConfigMap.put(springConfig, str);
                return true;
            }
            throw new IllegalArgumentException("configName is required");
        }
        throw new IllegalArgumentException("springConfig is required");
    }

    public Map<SpringConfig, String> getAllSpringConfig() {
        return Collections.unmodifiableMap(this.mSpringConfigMap);
    }

    public void removeAllSpringConfig() {
        this.mSpringConfigMap.clear();
    }

    public boolean removeSpringConfig(SpringConfig springConfig) {
        if (springConfig != null) {
            if (this.mSpringConfigMap.remove(springConfig) != null) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("springConfig is required");
    }
}
