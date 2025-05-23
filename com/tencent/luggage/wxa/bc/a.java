package com.tencent.luggage.wxa.bc;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.mm.picker.base.view.WheelView;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a, reason: collision with root package name */
    public final WheelView f122391a;

    public a(WheelView wheelView) {
        this.f122391a = wheelView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        this.f122391a.c(f17);
        return true;
    }
}
