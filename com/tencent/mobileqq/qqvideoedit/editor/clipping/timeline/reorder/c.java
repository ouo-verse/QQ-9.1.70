package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.reorder;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;

/* compiled from: P */
/* loaded from: classes17.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final a f275381a;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    interface a {
        boolean onTouchEvent(MotionEvent motionEvent);
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    static class b implements a {

        /* renamed from: a, reason: collision with root package name */
        private final GestureDetector f275382a;

        public b(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.f275382a = new GestureDetector(context, onGestureListener, handler);
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.reorder.c.a
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return this.f275382a.onTouchEvent(motionEvent);
        }
    }

    public c(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public boolean a(MotionEvent motionEvent) {
        return this.f275381a.onTouchEvent(motionEvent);
    }

    public c(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        this.f275381a = new b(context, onGestureListener, handler);
    }
}
