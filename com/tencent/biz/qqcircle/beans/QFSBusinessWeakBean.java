package com.tencent.biz.qqcircle.beans;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSBusinessWeakBean implements Serializable {
    private double mPicSpeed = 0.0d;
    private long mPlayerWidth = 0;
    private double mCmdCost = 0.0d;

    public double getCmdCost() {
        return this.mCmdCost;
    }

    public double getPicSpeed() {
        return this.mPicSpeed;
    }

    public long getPlayerWidth() {
        return this.mPlayerWidth;
    }

    public void setCmdCost(double d16) {
        this.mCmdCost = d16;
    }

    public void setPicSpeed(double d16) {
        this.mPicSpeed = d16;
    }

    public void setPlayerWidth(long j3) {
        this.mPlayerWidth = j3;
    }
}
