package com.tencent.biz.qqcircle.publish.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.ScrollView;
import com.tencent.component.media.annotation.Public;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ExtendScrollView extends ScrollView {

    /* renamed from: d, reason: collision with root package name */
    private HashSet<View> f91766d;

    /* renamed from: e, reason: collision with root package name */
    private HashSet<View> f91767e;

    /* renamed from: f, reason: collision with root package name */
    private int f91768f;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
    }

    @Public
    public ExtendScrollView(Context context) {
        super(context);
        this.f91768f = -1;
    }

    @TargetApi(14)
    private boolean a(View view, MotionEvent motionEvent) {
        boolean z16 = false;
        if (view != null && motionEvent != null) {
            if (this.f91768f == -1) {
                return false;
            }
            if (motionEvent.getRawY() - this.f91768f > 0.0f) {
                return view.canScrollVertically(-1);
            }
            z16 = true;
            if (motionEvent.getRawY() - this.f91768f < 0.0f) {
                return view.canScrollVertically(1);
            }
        }
        return z16;
    }

    private boolean b(View view, MotionEvent motionEvent) {
        if (view != null && motionEvent != null) {
            try {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                int i3 = iArr[0];
                int width = view.getWidth() + i3;
                int i16 = iArr[1];
                int height = view.getHeight() + i16;
                if (i3 >= rawX || rawX >= width || i16 >= rawY || rawY >= height) {
                    return false;
                }
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    private boolean c(MotionEvent motionEvent) {
        HashSet<View> hashSet = this.f91766d;
        boolean z16 = false;
        if (hashSet != null) {
            Iterator<View> it = hashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                View next = it.next();
                if (b(next, motionEvent)) {
                    HashSet<View> hashSet2 = this.f91767e;
                    if (hashSet2 == null || !hashSet2.contains(next) || a(next, motionEvent)) {
                        z16 = true;
                    }
                    int actionMasked = motionEvent.getActionMasked();
                    if (actionMasked != 1 && actionMasked != 3) {
                        this.f91768f = (int) motionEvent.getRawY();
                    } else {
                        this.f91768f = -1;
                    }
                }
            }
        }
        return z16;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        TouchDelegate touchDelegate = getTouchDelegate();
        if (touchDelegate != null) {
            touchDelegate.onTouchEvent(motionEvent);
        }
        motionEvent.getAction();
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception unused) {
            return true;
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (c(motionEvent)) {
                return false;
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    @Public
    public ExtendScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f91768f = -1;
    }

    @Public
    public ExtendScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f91768f = -1;
    }

    public void setOnDownListener(a aVar) {
    }
}
