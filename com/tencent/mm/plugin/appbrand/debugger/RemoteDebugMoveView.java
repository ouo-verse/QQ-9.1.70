package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.tn.z;

/* compiled from: P */
/* loaded from: classes9.dex */
public class RemoteDebugMoveView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public int f151916a;

    /* renamed from: b, reason: collision with root package name */
    public int f151917b;

    /* renamed from: c, reason: collision with root package name */
    public float f151918c;

    /* renamed from: d, reason: collision with root package name */
    public float f151919d;

    /* renamed from: e, reason: collision with root package name */
    public float f151920e;

    /* renamed from: f, reason: collision with root package name */
    public float f151921f;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RemoteDebugMoveView.this.setX(r0.f151916a - RemoteDebugMoveView.this.b());
            RemoteDebugMoveView.this.setY((int) (com.tencent.luggage.wxa.kn.a.a(z.c()) * 120.0f));
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        public int f151923a = 0;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (RemoteDebugMoveView.this.getParent() instanceof View) {
                    View view = (View) RemoteDebugMoveView.this.getParent();
                    RemoteDebugMoveView.this.f151916a = view.getMeasuredWidth();
                    RemoteDebugMoveView.this.f151917b = view.getMeasuredHeight();
                    float max = Math.max(0.0f, Math.min(RemoteDebugMoveView.this.f151916a - RemoteDebugMoveView.this.getWidth(), RemoteDebugMoveView.this.getX()));
                    float max2 = Math.max(0.0f, Math.min(RemoteDebugMoveView.this.f151917b - RemoteDebugMoveView.this.getHeight(), RemoteDebugMoveView.this.getY()));
                    RemoteDebugMoveView.this.setX(max);
                    RemoteDebugMoveView.this.setY(max2);
                    RemoteDebugMoveView.this.requestLayout();
                }
            }
        }

        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i3 = this.f151923a + 1;
            this.f151923a = i3;
            if (i3 < 2) {
                return;
            }
            RemoteDebugMoveView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            RemoteDebugMoveView.this.post(new a());
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RemoteDebugMoveView.this.getY() + RemoteDebugMoveView.this.getHeight() > RemoteDebugMoveView.this.f151917b) {
                RemoteDebugMoveView.this.setY(r0.f151917b - RemoteDebugMoveView.this.getHeight());
            }
        }
    }

    public RemoteDebugMoveView(@NonNull Context context) {
        super(context);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getViewTreeObserver().addOnGlobalLayoutListener(new b());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                this.f151920e = motionEvent.getRawX();
                this.f151921f = motionEvent.getRawY();
                float x16 = getX() + (this.f151920e - this.f151918c);
                if (0.0f < x16 && x16 < this.f151916a - getWidth()) {
                    setX(x16);
                }
                float f16 = this.f151921f - this.f151919d;
                float height = this.f151917b - getHeight();
                float y16 = getY() + f16;
                if (0.0f < y16 && y16 < height) {
                    setY(y16);
                } else if ((y16 <= 0.0f && f16 > 0.0f) || (y16 >= height && f16 < 0.0f)) {
                    setY(y16);
                }
                this.f151918c = this.f151920e;
                this.f151919d = this.f151921f;
                return true;
            }
            return true;
        }
        this.f151918c = motionEvent.getRawX();
        this.f151919d = motionEvent.getRawY();
        return true;
    }

    public RemoteDebugMoveView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RemoteDebugMoveView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    public void a(int i3, int i16) {
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f151916a = i3;
        this.f151917b = i16;
        post(new a());
    }

    public final int b() {
        int width = getWidth();
        return width > 0 ? width : com.tencent.luggage.wxa.kn.a.a(getContext(), 200);
    }

    public void a() {
        postDelayed(new c(), 50L);
    }
}
