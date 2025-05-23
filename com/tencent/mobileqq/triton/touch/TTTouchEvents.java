package com.tencent.mobileqq.triton.touch;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TTTouchEvents {
    public int action;
    public double timeStamp;
    public ArrayList<Touch> touches = new ArrayList<>();
    public ArrayList<Touch> changedTouches = new ArrayList<>();

    public TTTouchEvents copy() {
        TTTouchEvents tTTouchEvents = new TTTouchEvents();
        tTTouchEvents.action = this.action;
        tTTouchEvents.timeStamp = this.timeStamp;
        tTTouchEvents.touches.addAll(this.touches);
        tTTouchEvents.changedTouches.addAll(this.changedTouches);
        return tTTouchEvents;
    }
}
