package com.tencent.mobileqq.shortvideo.gesture;

import android.graphics.PointF;
import android.graphics.RectF;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GestureKeyInfo {
    public String type;
    public boolean vaild = false;
    public PointF[] hotPoints = null;
    public RectF hotArea = null;
    public long timeStamp = 0;
    int dataWidth = 0;
    int dataHeight = 0;
    int originWidth = 0;
    int originHeight = 0;

    public void copyTo(GestureKeyInfo gestureKeyInfo) {
        gestureKeyInfo.vaild = this.vaild;
        gestureKeyInfo.type = this.type;
        gestureKeyInfo.timeStamp = this.timeStamp;
        gestureKeyInfo.hotPoints = this.hotPoints;
        gestureKeyInfo.hotArea = this.hotArea;
        gestureKeyInfo.dataWidth = this.dataWidth;
        gestureKeyInfo.dataHeight = this.dataHeight;
        gestureKeyInfo.originWidth = this.originWidth;
        gestureKeyInfo.originHeight = this.originHeight;
    }

    public void reset() {
        this.type = null;
        this.vaild = false;
        this.timeStamp = 0L;
    }
}
