package com.tencent.qqlive.tvkplayer.tools.config;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes23.dex */
class TVKConfigPriorityFilter {
    private final HashMap<String, ConfigValueProperty> mPriorityToConfigContentUnionOfSet = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public enum ConfigPriority {
        CONFIG_PRIORITY_LOWEST,
        CONFIG_PRIORITY_WUJI,
        CONFIG_PRIORITY_APP,
        CONFIG_PRIORITY_TAB
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class ConfigValueProperty {

        @NonNull
        ConfigPriority mPriority;

        @NonNull
        String mValue;

        public ConfigValueProperty(@NonNull String str, @NonNull ConfigPriority configPriority) {
            this.mValue = str;
            this.mPriority = configPriority;
        }
    }

    private boolean isNeedUpdateConfig(@Nullable ConfigValueProperty configValueProperty, @NonNull ConfigPriority configPriority, @NonNull String str) {
        if (configValueProperty == null) {
            return true;
        }
        if (configPriority.compareTo(configValueProperty.mPriority) >= 0 && !str.equals(configValueProperty.mValue)) {
            return true;
        }
        return false;
    }

    private boolean isNeedUpdateUnionOfSet(@Nullable ConfigValueProperty configValueProperty, @NonNull ConfigPriority configPriority, @NonNull String str) {
        if (configValueProperty == null || configPriority.compareTo(configValueProperty.mPriority) > 0) {
            return true;
        }
        if (configPriority.compareTo(configValueProperty.mPriority) == 0 && !str.equals(configValueProperty.mValue)) {
            return true;
        }
        return false;
    }

    @NonNull
    public synchronized HashMap<String, String> filter(@NonNull ConfigPriority configPriority, @NonNull HashMap<String, String> hashMap) {
        HashMap<String, String> hashMap2;
        hashMap2 = new HashMap<>();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            ConfigValueProperty configValueProperty = this.mPriorityToConfigContentUnionOfSet.get(entry.getKey());
            if (isNeedUpdateConfig(configValueProperty, configPriority, entry.getValue())) {
                hashMap2.put(entry.getKey(), entry.getValue());
            }
            if (isNeedUpdateUnionOfSet(configValueProperty, configPriority, entry.getValue())) {
                this.mPriorityToConfigContentUnionOfSet.put(entry.getKey(), new ConfigValueProperty(entry.getValue(), configPriority));
            }
        }
        return hashMap2;
    }
}
