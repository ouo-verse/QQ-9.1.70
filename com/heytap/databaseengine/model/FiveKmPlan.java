package com.heytap.databaseengine.model;

import androidx.annotation.Keep;

@Keep
/* loaded from: classes2.dex */
public class FiveKmPlan {
    private int avgPace;
    private int distance;
    private int maxPace;
    private int minPace;
    private int pace;
    private int type;

    public int getAvgPace() {
        return this.avgPace;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getMaxPace() {
        return this.maxPace;
    }

    public int getMinPace() {
        return this.minPace;
    }

    public int getPace() {
        return this.pace;
    }

    public int getType() {
        return this.type;
    }

    public void setAvgPace(int i3) {
        this.avgPace = i3;
    }

    public void setDistance(int i3) {
        this.distance = i3;
    }

    public void setMaxPace(int i3) {
        this.maxPace = i3;
    }

    public void setMinPace(int i3) {
        this.minPace = i3;
    }

    public void setPace(int i3) {
        this.pace = i3;
    }

    public void setType(int i3) {
        this.type = i3;
    }
}
