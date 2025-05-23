package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProBottomTabSourceInfo implements Serializable {
    public String bid;
    public int bussiSource;
    public int sceneId;
    long serialVersionUID;

    public GProBottomTabSourceInfo() {
        this.serialVersionUID = 1L;
        this.bid = "";
    }

    public String getBid() {
        return this.bid;
    }

    public int getBussiSource() {
        return this.bussiSource;
    }

    public int getSceneId() {
        return this.sceneId;
    }

    public void setBid(String str) {
        this.bid = str;
    }

    public void setBussiSource(int i3) {
        this.bussiSource = i3;
    }

    public void setSceneId(int i3) {
        this.sceneId = i3;
    }

    public String toString() {
        return "GProBottomTabSourceInfo{sceneId=" + this.sceneId + ",bid=" + this.bid + ",bussiSource=" + this.bussiSource + ",}";
    }

    public GProBottomTabSourceInfo(int i3, String str, int i16) {
        this.serialVersionUID = 1L;
        this.sceneId = i3;
        this.bid = str;
        this.bussiSource = i16;
    }
}
