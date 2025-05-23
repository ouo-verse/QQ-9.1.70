package com.tencent.mobileqq.vas.theme;

import com.tencent.mobileqq.vas.theme.api.QUIUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ThemeConfigItem {
    private static final String TAG = "ThemeConfigItem";
    private int mDefaultColor;
    private String mDesc;
    private List<LinkedConfig> mLinkedConfigs;
    private String mThemeId;
    private Map<String, String> mTintColorMap;
    private Map<String, String> mTintDrawableMap;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class LinkedConfig {
        private String mLinkedName;
        private int mLinkedType;

        public String getLinkedName() {
            return this.mLinkedName;
        }

        public int getLinkedType() {
            return this.mLinkedType;
        }

        public void setLinkedName(String str) {
            this.mLinkedName = str;
        }

        public void setLinkedType(int i3) {
            this.mLinkedType = i3;
        }
    }

    private void mergeLinkedMap(Map<String, String> map, Map<String, String> map2) {
        mergeMap(map, map2, true);
    }

    private void mergeMap(Map<String, String> map, Map<String, String> map2, boolean z16) {
        if (map != null && map2 != null) {
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (map.containsKey(key)) {
                    String str = map.get(key);
                    if (str != null) {
                        str.equals(value);
                    }
                } else {
                    map.put(key, value);
                }
            }
        }
    }

    private void mergeSameItemMap(Map<String, String> map, Map<String, String> map2) {
        mergeMap(map, map2, false);
    }

    public void addQUIExtraMap(Map<String, String> map) {
        if (this.mTintColorMap != null && map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (this.mTintColorMap.containsKey(value)) {
                    this.mTintColorMap.put(key, this.mTintColorMap.get(value));
                }
            }
        }
    }

    public int getDefaultColor() {
        return this.mDefaultColor;
    }

    public String getDesc() {
        return this.mDesc;
    }

    public List<LinkedConfig> getLinkedConfigs() {
        return this.mLinkedConfigs;
    }

    public String getThemeId() {
        return this.mThemeId;
    }

    public Map<String, String> getTintColorMap() {
        return this.mTintColorMap;
    }

    public Map<String, String> getTintDrawableMap() {
        return this.mTintDrawableMap;
    }

    public void mergeLinkedItem(ThemeConfigItem themeConfigItem) {
        if (themeConfigItem == null) {
            return;
        }
        mergeLinkedMap(this.mTintColorMap, themeConfigItem.mTintColorMap);
        mergeLinkedMap(this.mTintDrawableMap, themeConfigItem.mTintDrawableMap);
    }

    public void mergeSameItem(ThemeConfigItem themeConfigItem) {
        if (themeConfigItem == null) {
            return;
        }
        String str = this.mThemeId;
        if (str != null && str.equals(themeConfigItem.mThemeId)) {
            if (this.mDefaultColor != themeConfigItem.mDefaultColor) {
                return;
            }
            mergeSameItemMap(this.mTintColorMap, themeConfigItem.mTintColorMap);
            mergeSameItemMap(this.mTintDrawableMap, themeConfigItem.mTintDrawableMap);
            return;
        }
        QLog.d(TAG, 1, "mergeSameItem, themeId not same, themeId : ", this.mThemeId, " item themeId : ", themeConfigItem.mThemeId);
    }

    public void setDefaultColor(int i3) {
        this.mDefaultColor = i3;
    }

    public void setDesc(String str) {
        this.mDesc = str;
    }

    public void setLinkedConfigs(List<LinkedConfig> list) {
        this.mLinkedConfigs = list;
    }

    public void setThemeId(String str) {
        this.mThemeId = str;
    }

    public void setTintColorMap(Map<String, String> map) {
        this.mTintColorMap = map;
    }

    public void setTintDrawableMap(Map<String, String> map) {
        this.mTintDrawableMap = map;
    }

    public String toString() {
        Object valueOf;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ThemeConfigItem{mThemeId='");
        sb5.append(this.mThemeId);
        sb5.append('\'');
        sb5.append(", mDefaultColor=");
        sb5.append(this.mDefaultColor);
        sb5.append(", mDesc='");
        sb5.append(this.mDesc);
        sb5.append('\'');
        sb5.append(", mTintColorMap=");
        Map<String, String> map = this.mTintColorMap;
        Object obj = "null";
        if (map == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(map.size());
        }
        sb5.append(valueOf);
        sb5.append(", quiTintColorMap=");
        sb5.append(QUIUtil.filterQUIPrefix(this.mTintColorMap));
        sb5.append(", mTintDrawableMap=");
        Map<String, String> map2 = this.mTintDrawableMap;
        if (map2 != null) {
            obj = Integer.valueOf(map2.size());
        }
        sb5.append(obj);
        sb5.append('}');
        return sb5.toString();
    }
}
