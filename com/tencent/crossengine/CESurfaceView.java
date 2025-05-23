package com.tencent.crossengine;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import tf0.d;

/* compiled from: P */
/* loaded from: classes32.dex */
public class CESurfaceView extends SurfaceView implements SurfaceHolder.Callback2 {

    /* renamed from: d, reason: collision with root package name */
    private RenderContext f100457d;

    /* renamed from: e, reason: collision with root package name */
    private d f100458e;

    /* renamed from: f, reason: collision with root package name */
    private GestureDetector f100459f;

    public CESurfaceView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector = this.f100459f;
        if (gestureDetector != null) {
            return gestureDetector.onTouchEvent(motionEvent);
        }
        return this.f100458e.a(motionEvent);
    }

    public void setGestureDetector(GestureDetector gestureDetector) {
        this.f100459f = gestureDetector;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        this.f100457d.i(surfaceHolder.getSurface(), i16, i17);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f100457d.f(surfaceHolder.getSurface(), getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f100457d.b();
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        surfaceRedrawNeeded(surfaceHolder);
        runnable.run();
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
    }
}
