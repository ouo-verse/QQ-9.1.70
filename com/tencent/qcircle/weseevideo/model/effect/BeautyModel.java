package com.tencent.qcircle.weseevideo.model.effect;

import com.tencent.qcircle.weseevideo.composition.effectnode.VideoEffectType;
import com.tencent.ttpic.openapi.config.BeautyRealConfig;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class BeautyModel extends BaseEffectModel implements Serializable {
    public static final int IS_NOT_FILTER = -1;
    public static final String ORGIN_FILTER = "edit_orgin_filter";
    private String filterDescJson;
    private String filterFlagID;
    private int effectType = VideoEffectType.TYPE_BEAUTY.value;
    private HashMap<BeautyRealConfig.TYPE, Integer> beautyLevels = new HashMap<>();
    private int filterID = -1;
    private int filterIndex = -1;
    private float filterAjustValue = -1.0f;
    private int darkCornerLevel = -1;
    private boolean enableComparison = false;

    public void clearFilter() {
        this.filterID = -1;
        this.filterFlagID = ORGIN_FILTER;
        this.filterAjustValue = -1.0f;
    }

    public HashMap getBeautyLevel() {
        return this.beautyLevels;
    }

    public int getDarkCornerLevel() {
        return this.darkCornerLevel;
    }

    public int getEffectType() {
        return this.effectType;
    }

    public String getFilterDescJson() {
        return this.filterDescJson;
    }

    public String getFilterFlagID() {
        return this.filterFlagID;
    }

    public int getFilterID() {
        return this.filterID;
    }

    public int getFilterIndex() {
        return this.filterIndex;
    }

    public float getFilterValue() {
        return this.filterAjustValue;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean isEnableComparison() {
        return this.enableComparison;
    }

    public boolean isNoFilter() {
        if (this.filterID == -1) {
            return true;
        }
        return false;
    }

    public void setBeautyLevel(BeautyRealConfig.TYPE type, Integer num) {
        if (this.beautyLevels == null) {
            this.beautyLevels = new HashMap<>();
        }
        this.beautyLevels.put(type, num);
    }

    public void setDarkCornerLevel(int i3) {
        this.darkCornerLevel = i3;
    }

    public void setEffectType(int i3) {
        this.effectType = i3;
    }

    public void setEnableComparison(boolean z16) {
        this.enableComparison = z16;
    }

    public void setFilter(int i3, String str, int i16) {
        this.filterID = i3;
        this.filterFlagID = str;
        this.filterIndex = i16;
    }

    public void setFilterDescJson(String str) {
        this.filterDescJson = str;
    }

    public void setFilterValue(float f16) {
        this.filterAjustValue = f16;
    }

    public void setBeautyLevel(HashMap<BeautyRealConfig.TYPE, Integer> hashMap) {
        if (hashMap != null && hashMap.size() != 0) {
            this.beautyLevels = hashMap;
        } else {
            this.beautyLevels = new HashMap<>();
        }
    }
}
