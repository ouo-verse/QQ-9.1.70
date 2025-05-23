package com.tencent.luggage.wxa.ll;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f133598a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedList f133599b = new LinkedList();

    /* renamed from: c, reason: collision with root package name */
    public b f133600c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final long f133601a;

        /* renamed from: b, reason: collision with root package name */
        public final long f133602b;

        public b(long j3, long j16) {
            this.f133601a = j3;
            this.f133602b = j16;
        }
    }

    public e(ViewGroup viewGroup) {
        this.f133598a = viewGroup;
    }

    public final void a() {
        this.f133599b.clear();
    }

    public boolean b(MotionEvent motionEvent) {
        Iterator it;
        b bVar;
        int i3;
        if (!this.f133598a.onFilterTouchEventForSecurity(motionEvent)) {
            return false;
        }
        if (motionEvent.getActionMasked() == 0) {
            it = new com.tencent.luggage.wxa.ll.b(this.f133598a);
        } else {
            it = this.f133599b.iterator();
        }
        if (motionEvent.getActionMasked() == 0) {
            bVar = new b(motionEvent.getDownTime(), motionEvent.getEventTime());
        } else {
            bVar = null;
        }
        this.f133600c = bVar;
        boolean z16 = false;
        while (it.hasNext()) {
            View view = (View) it.next();
            int actionIndex = motionEvent.getActionIndex();
            if (this.f133598a.isMotionEventSplittingEnabled()) {
                i3 = 1 << motionEvent.getPointerId(actionIndex);
            } else {
                i3 = -1;
            }
            float x16 = motionEvent.getX(actionIndex);
            float y16 = motionEvent.getY(actionIndex);
            if (motionEvent.getActionMasked() == 0) {
                if (AppBrandViewMotionCompat.a(view) && AppBrandViewMotionCompat.a(this.f133598a, x16, y16, view, null) && AppBrandViewMotionCompat.d(view) && AppBrandViewMotionCompat.dispatchTransformedTouchEvent(this.f133598a, motionEvent, false, view, i3)) {
                    this.f133599b.addLast(view);
                    z16 |= true;
                }
            } else {
                z16 |= AppBrandViewMotionCompat.dispatchTransformedTouchEvent(this.f133598a, motionEvent, false, view, i3);
            }
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            a();
        }
        return z16;
    }

    public boolean a(MotionEvent motionEvent) {
        return motionEvent != null && motionEvent.getActionMasked() == 0 && this.f133600c != null && motionEvent.getDownTime() == this.f133600c.f133601a && motionEvent.getEventTime() == this.f133600c.f133602b;
    }
}
