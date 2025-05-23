package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ArkAppRootLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private boolean f179278d;

    /* renamed from: e, reason: collision with root package name */
    private GestureDetector f179279e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            ArkAppRootLayout.a(ArkAppRootLayout.this);
            return super.onSingleTapUp(motionEvent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface b {
    }

    public ArkAppRootLayout(Context context) {
        super(context);
        this.f179278d = false;
        b(context);
    }

    static /* bridge */ /* synthetic */ b a(ArkAppRootLayout arkAppRootLayout) {
        arkAppRootLayout.getClass();
        return null;
    }

    private void b(Context context) {
        this.f179279e = new GestureDetector(context, new a());
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector = this.f179279e;
        if (gestureDetector != null) {
            gestureDetector.onTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f179278d) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else if (actionMasked == 1 || actionMasked == 3) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setDisableParentReturn(boolean z16) {
        this.f179278d = z16;
    }

    public ArkAppRootLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f179278d = false;
        b(context);
    }

    public ArkAppRootLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f179278d = false;
        b(context);
    }

    public void setCallback(b bVar) {
    }
}
