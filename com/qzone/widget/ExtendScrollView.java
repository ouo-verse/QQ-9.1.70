package com.qzone.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.ScrollView;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ExtendScrollView extends ScrollView {

    /* renamed from: d, reason: collision with root package name */
    private HashSet<View> f60371d;

    /* renamed from: e, reason: collision with root package name */
    private HashSet<View> f60372e;

    /* renamed from: f, reason: collision with root package name */
    private int f60373f;

    /* renamed from: h, reason: collision with root package name */
    private a f60374h;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface a {
        boolean onDown(MotionEvent motionEvent);

        boolean onTouch(MotionEvent motionEvent);
    }

    public ExtendScrollView(Context context) {
        super(context);
        this.f60373f = -1;
    }

    private boolean f(MotionEvent motionEvent) {
        HashSet<View> hashSet = this.f60371d;
        if (hashSet != null) {
            Iterator<View> it = hashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                View next = it.next();
                if (d(next, motionEvent)) {
                    HashSet<View> hashSet2 = this.f60372e;
                    r1 = hashSet2 == null || !hashSet2.contains(next) || c(next, motionEvent);
                    int actionMasked = motionEvent.getActionMasked();
                    if (actionMasked != 1 && actionMasked != 3) {
                        this.f60373f = (int) motionEvent.getRawY();
                    } else {
                        this.f60373f = -1;
                    }
                }
            }
        }
        return r1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        TouchDelegate touchDelegate = getTouchDelegate();
        if (touchDelegate != null) {
            touchDelegate.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0) {
            a aVar = this.f60374h;
            if (aVar != null && aVar.onDown(motionEvent)) {
                return true;
            }
        } else {
            a aVar2 = this.f60374h;
            if (aVar2 != null && aVar2.onTouch(motionEvent)) {
                return true;
            }
        }
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception unused) {
            return true;
        }
    }

    public void e(int i3) {
        if (this.f60372e == null || findViewById(i3) == null) {
            return;
        }
        this.f60372e.remove(Integer.valueOf(i3));
    }

    public void setOnDownListener(a aVar) {
        this.f60374h = aVar;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (f(motionEvent)) {
                return false;
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public ExtendScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60373f = -1;
    }

    public void a(int i3) {
        if (i3 == 0) {
            return;
        }
        if (this.f60372e == null) {
            this.f60372e = new HashSet<>();
        }
        View findViewById = findViewById(i3);
        if (findViewById != null) {
            this.f60372e.add(findViewById);
        }
    }

    public void b(int i3) {
        if (i3 == 0) {
            return;
        }
        if (this.f60371d == null) {
            this.f60371d = new HashSet<>();
        }
        View findViewById = findViewById(i3);
        if (findViewById != null) {
            this.f60371d.add(findViewById);
        }
    }

    public ExtendScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f60373f = -1;
    }

    private boolean c(View view, MotionEvent motionEvent) {
        boolean z16 = false;
        if (view != null && motionEvent != null) {
            if (this.f60373f == -1) {
                return false;
            }
            if (motionEvent.getRawY() - this.f60373f > 0.0f) {
                return view.canScrollVertically(-1);
            }
            z16 = true;
            if (motionEvent.getRawY() - this.f60373f < 0.0f) {
                return view.canScrollVertically(1);
            }
        }
        return z16;
    }

    private boolean d(View view, MotionEvent motionEvent) {
        if (view != null && motionEvent != null) {
            try {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                int i3 = iArr[0];
                int width = view.getWidth() + i3;
                int i16 = iArr[1];
                return ((float) i3) < rawX && rawX < ((float) width) && ((float) i16) < rawY && rawY < ((float) (view.getHeight() + i16));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }
}
