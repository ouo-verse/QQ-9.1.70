package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProDesignatedStreamInfo {
    public Integer isSwitch;
    public Integer sugLevel;
    public ArrayList<GProLiveStream> streams = new ArrayList<>();
    public ArrayList<Integer> LevelList = new ArrayList<>();
    public ArrayList<GProLiveGearInfo> GearLIst = new ArrayList<>();

    public ArrayList<GProLiveGearInfo> getGearLIst() {
        return this.GearLIst;
    }

    public Integer getIsSwitch() {
        return this.isSwitch;
    }

    public ArrayList<Integer> getLevelList() {
        return this.LevelList;
    }

    public ArrayList<GProLiveStream> getStreams() {
        return this.streams;
    }

    public Integer getSugLevel() {
        return this.sugLevel;
    }

    public String toString() {
        return "GProDesignatedStreamInfo{streams=" + this.streams + ",isSwitch=" + this.isSwitch + ",LevelList=" + this.LevelList + ",sugLevel=" + this.sugLevel + ",GearLIst=" + this.GearLIst + ",}";
    }
}
