package com.qzone.component;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.qzone.util.ar;

/* loaded from: classes39.dex */
public class PolymorphicLikeCellLayout extends LinearLayout implements OnTouchEventDelegateListener, Handler.Callback {
    private static final int G = ar.e(10.0f);
    private boolean C;
    private float D;
    private float E;
    private final Handler F;

    /* renamed from: d, reason: collision with root package name */
    private boolean f46224d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f46225e;

    /* renamed from: f, reason: collision with root package name */
    private a f46226f;

    /* renamed from: h, reason: collision with root package name */
    private int f46227h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f46228i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f46229m;

    /* loaded from: classes39.dex */
    public interface a {
        void a();

        void b();

        void c(View view, int i3, boolean z16);

        void d();

        void e();

        void f(int i3);
    }

    public PolymorphicLikeCellLayout(Context context) {
        this(context, null);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        if (this.f46224d) {
            int intValue = ((Integer) message.obj).intValue();
            if (this.f46225e) {
                this.f46225e = false;
                a aVar = this.f46226f;
                if (aVar != null) {
                    aVar.a();
                }
            }
            a aVar2 = this.f46226f;
            if (aVar2 != null) {
                aVar2.c(this, intValue, false);
            }
            this.F.sendMessageDelayed(this.F.obtainMessage(1, Integer.valueOf(intValue)), 80L);
        }
        return true;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        Log.i("PolymorphicLikeCellLayo", "onTouchEvent: " + motionEvent.getAction());
        int i3 = -1;
        if (!a(motionEvent.getX(), motionEvent.getY())) {
            this.f46224d = false;
            if (!this.f46228i && (aVar = this.f46226f) != null) {
                aVar.e();
                if (!this.f46225e) {
                    this.f46226f.d();
                }
            }
            this.f46228i = true;
            this.f46227h = -1;
            return false;
        }
        this.f46228i = false;
        int childCount = getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (motionEvent.getX() > childAt.getLeft() && motionEvent.getX() < childAt.getRight()) {
                i3 = i16;
            }
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f46224d = true;
            this.f46225e = true;
            a aVar2 = this.f46226f;
            if (aVar2 != null) {
                aVar2.f(i3);
            }
            this.F.sendMessageDelayed(this.F.obtainMessage(1, Integer.valueOf(i3)), 300L);
        } else if (actionMasked == 1 || actionMasked == 3 || actionMasked == 4) {
            this.f46224d = false;
            this.F.removeMessages(1);
            a aVar3 = this.f46226f;
            if (aVar3 != null) {
                aVar3.e();
                if (this.f46225e) {
                    this.f46226f.c(this, i3, true);
                } else {
                    this.f46226f.d();
                }
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0099, code lost:
    
        if (r13 != 3) goto L62;
     */
    @Override // com.qzone.component.OnTouchEventDelegateListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onTouchEventListener(MotionEvent motionEvent) {
        int i3;
        a aVar;
        a aVar2;
        a aVar3;
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (!this.C) {
            this.D = rawX;
            this.E = rawY;
            this.C = true;
        }
        float abs = Math.abs(rawX - this.D);
        int i16 = G;
        if (abs > i16 || this.E - rawY > i16) {
            this.f46229m = true;
        }
        int actionMasked = motionEvent.getActionMasked();
        boolean z16 = actionMasked == 1 || actionMasked == 3;
        if (!b(rawX, rawY)) {
            a aVar4 = this.f46226f;
            if (aVar4 != null && !this.f46228i && this.f46227h != -1) {
                aVar4.e();
            }
            this.f46228i = true;
            this.f46227h = -1;
            if (!z16 || (aVar3 = this.f46226f) == null) {
                return;
            }
            aVar3.b();
            return;
        }
        if (!this.f46229m) {
            if (!z16 || (aVar2 = this.f46226f) == null) {
                return;
            }
            aVar2.b();
            return;
        }
        this.f46228i = false;
        int childCount = getChildCount();
        int i17 = -1;
        for (int i18 = 0; i18 < childCount; i18++) {
            int[] iArr = new int[2];
            getChildAt(i18).getLocationOnScreen(iArr);
            if (rawX > iArr[0] && rawX < r9 + r10.getWidth()) {
                i17 = i18;
            }
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                a aVar5 = this.f46226f;
                if (aVar5 != null && i17 != -1 && i17 != this.f46227h) {
                    this.f46227h = i17;
                    aVar5.f(i17);
                }
            }
            if (z16 || (aVar = this.f46226f) == null) {
            }
            aVar.b();
            return;
        }
        a aVar6 = this.f46226f;
        if (aVar6 != null && (i3 = this.f46227h) != -1) {
            aVar6.c(this, i3, true);
            this.f46226f.e();
        }
        if (z16) {
        }
    }

    public void setItemClickListener(a aVar) {
        this.f46226f = aVar;
    }

    public PolymorphicLikeCellLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean b(float f16, float f17) {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        if (f16 <= iArr[0] || f16 >= r2 + getWidth()) {
            return false;
        }
        int i3 = iArr[1];
        return f17 > ((float) i3) && f17 < ((float) (i3 + getHeight()));
    }

    public PolymorphicLikeCellLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f46227h = -1;
        this.f46229m = false;
        this.C = false;
        this.D = 0.0f;
        this.E = 0.0f;
        this.F = new Handler(Looper.getMainLooper(), this);
    }

    private boolean a(float f16, float f17) {
        return f16 > 0.0f && f16 < ((float) getWidth()) && f17 > 0.0f && f17 < ((float) getHeight());
    }
}
