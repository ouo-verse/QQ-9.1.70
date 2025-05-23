package com.tencent.qcircle.weseevideo.model.data;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MusicData implements Serializable {
    private int startTime = 0;
    private int totalTime = 0;
    private int segDuration = 0;
    private String path = "";

    public String getPath() {
        return this.path;
    }

    public int getSegDuration() {
        return this.segDuration;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public int getTotalTime() {
        return this.totalTime;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setSegDuration(int i3) {
        this.segDuration = i3;
    }

    public void setStartTime(int i3) {
        this.startTime = i3;
    }

    public void setTotalTime(int i3) {
        this.totalTime = i3;
    }
}
