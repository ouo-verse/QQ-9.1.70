package com.tencent.mobileqq.vashealth;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* loaded from: classes20.dex */
public class TracePathData extends Entity {
    public static final String TABLE_NAME = "TracePathData";
    public double distance;
    public long endTime;
    public int isStop;

    @unique
    public long startTime;
    public int stepsGoal;
    public int totalSteps;
    public long totalTime;
    public int type;

    public String toString() {
        return "startTime: " + this.startTime + "endTime: " + this.endTime + ",distance: " + this.distance + ", totalTime: " + this.totalTime + ", isStop: " + this.isStop + ",totalSteps:" + this.totalSteps;
    }
}
