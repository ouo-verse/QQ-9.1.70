package com.tencent.could.aicamare.util;

import android.view.MotionEvent;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    public static float a(MotionEvent motionEvent) {
        float x16 = motionEvent.getX(0) - motionEvent.getX(1);
        float y16 = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x16 * x16) + (y16 * y16));
    }
}
