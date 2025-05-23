package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final a f319304a;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    interface a {
        boolean onTouchEvent(MotionEvent motionEvent);
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    static class b implements a {

        /* renamed from: a, reason: collision with root package name */
        private final GestureDetector f319305a;

        public b(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.f319305a = new GestureDetector(context, onGestureListener, handler);
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.d.a
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return this.f319305a.onTouchEvent(motionEvent);
        }
    }

    public d(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public boolean a(MotionEvent motionEvent) {
        return this.f319304a.onTouchEvent(motionEvent);
    }

    public d(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        this.f319304a = new b(context, onGestureListener, handler);
    }
}
