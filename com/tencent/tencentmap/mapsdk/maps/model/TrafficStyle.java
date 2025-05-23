package com.tencent.tencentmap.mapsdk.maps.model;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TrafficStyle {
    private int mWidth = 3;
    private int mStrokeWidth = 0;
    private int mSmoothColor = -16722688;
    private int mSlowColor = -16128;
    private int mCongestedColor = -46250;
    private int mSeriousCongestedColor = -7300827;
    private int mSmoothStrokeColor = -16722688;
    private int mSlowStrokeColor = -16128;
    private int mCongestedStrokeColor = -46250;
    private int mSeriousCongestedStrokeColor = -7300827;

    public TrafficStyle setCongestedColor(int i3) {
        this.mCongestedColor = i3;
        return this;
    }

    public TrafficStyle setCongestedStrokeColor(int i3) {
        this.mCongestedStrokeColor = i3;
        return this;
    }

    public TrafficStyle setSeriousCongestedColor(int i3) {
        this.mSeriousCongestedColor = i3;
        return this;
    }

    public TrafficStyle setSeriousCongestedStrokeColor(int i3) {
        this.mSeriousCongestedStrokeColor = i3;
        return this;
    }

    public TrafficStyle setSlowColor(int i3) {
        this.mSlowColor = i3;
        return this;
    }

    public TrafficStyle setSlowStrokeColor(int i3) {
        this.mSlowStrokeColor = i3;
        return this;
    }

    public TrafficStyle setSmoothColor(int i3) {
        this.mSmoothColor = i3;
        return this;
    }

    public TrafficStyle setSmoothStrokeColor(int i3) {
        this.mSmoothStrokeColor = i3;
        return this;
    }

    public TrafficStyle setStrokeWidth(int i3) {
        this.mStrokeWidth = i3;
        return this;
    }

    public TrafficStyle setWidth(int i3) {
        this.mWidth = i3;
        return this;
    }

    public String toString() {
        return "TrafficStyle{mWidth=" + this.mWidth + ", mStrokeWidth=" + this.mStrokeWidth + ", mSmoothColor=" + this.mSmoothColor + ", mSlowColor=" + this.mSlowColor + ", mCongestedColor=" + this.mCongestedColor + ", mSeriousCongestedColor=" + this.mSeriousCongestedColor + ", mSmoothStrokeColor=" + this.mSmoothStrokeColor + ", mSlowStrokeColor=" + this.mSlowStrokeColor + ", mCongestedStrokeColor=" + this.mCongestedStrokeColor + ", mSeriousCongestedStrokeColor=" + this.mSeriousCongestedStrokeColor + '}';
    }
}
