package com.tencent.thumbplayer.api.capability;

import java.util.HashSet;
import java.util.Set;

/* loaded from: classes26.dex */
public class TPHdrCapAttribute {
    private int mHdrType;
    private Set<Integer> mSupportedMappingTypes = new HashSet();

    public void addSupportedMappingType(int i3) {
        this.mSupportedMappingTypes.add(Integer.valueOf(i3));
    }

    public int getHdrType() {
        return this.mHdrType;
    }

    public Set<Integer> getSupportedMappingTypes() {
        return this.mSupportedMappingTypes;
    }

    public void setHdrType(int i3) {
        this.mHdrType = i3;
    }

    public void setSupportedMappingTypes(Set<Integer> set) {
        this.mSupportedMappingTypes = set;
    }
}
