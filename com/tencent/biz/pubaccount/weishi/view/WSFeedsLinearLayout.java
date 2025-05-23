package com.tencent.biz.pubaccount.weishi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.weishi.util.x;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSFeedsLinearLayout extends LinearLayout {
    private int C;

    /* renamed from: d, reason: collision with root package name */
    private b f82417d;

    /* renamed from: e, reason: collision with root package name */
    private GestureDetector f82418e;

    /* renamed from: f, reason: collision with root package name */
    private float f82419f;

    /* renamed from: h, reason: collision with root package name */
    private float f82420h;

    /* renamed from: i, reason: collision with root package name */
    private float f82421i;

    /* renamed from: m, reason: collision with root package name */
    private float f82422m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            WSFeedsLinearLayout.this.e(f16, f17);
            return super.onScroll(motionEvent, motionEvent2, f16, f17);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface b {
        void a(int i3, int i16);

        void b(int i3);

        void c(int i3);
    }

    public WSFeedsLinearLayout(Context context) {
        super(context);
        this.f82419f = 0.0f;
        this.f82420h = 0.0f;
        this.f82421i = 0.0f;
        this.f82422m = 0.0f;
        this.C = 0;
        h();
    }

    private int b() {
        float f16;
        int i3 = this.C;
        if (i3 == 1) {
            f16 = this.f82419f;
        } else {
            if (i3 != 2) {
                return 0;
            }
            f16 = this.f82420h;
        }
        return (int) f16;
    }

    private void c() {
        x.b("WSFeedsLinearLayoutLog", "[WSFeedsLinearLayout.java][handleActionDown] ACTION_DOWN!!");
        i();
    }

    private void d() {
        b bVar = this.f82417d;
        if (bVar != null) {
            bVar.a(this.C, b());
        }
        i();
        x.b("WSFeedsLinearLayoutLog", "[WSFeedsLinearLayout.java][handleActionUp] ACTION_UP!! mMoveState:" + this.C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(float f16, float f17) {
        if (Math.abs(f16) < Math.abs(f17)) {
            if (f17 > 0.0f) {
                g(f17);
            } else {
                f(f17);
            }
        }
    }

    private void h() {
        this.f82418e = new GestureDetector(new a());
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            c();
        } else if (action == 1) {
            d();
        }
        this.f82418e.onTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnActionListener(b bVar) {
        this.f82417d = bVar;
    }

    private void f(float f16) {
        this.f82422m = 0.0f;
        this.f82421i += f16;
        x.j("WSFeedsLinearLayoutLog", "[WSFeedsLinearLayout.java][handleGestureOnScrollDown] SCROLL_DOWN!! distanceY:" + f16 + ", mDistanceDown:" + this.f82420h + ", mDistanceDownSlop:" + this.f82421i);
        if (Math.abs(this.f82421i) > 8.0f) {
            this.f82419f = 0.0f;
            float f17 = this.f82420h + f16;
            this.f82420h = f17;
            this.C = 2;
            b bVar = this.f82417d;
            if (bVar != null) {
                bVar.b((int) f17);
            }
        }
    }

    private void g(float f16) {
        this.f82421i = 0.0f;
        this.f82422m += f16;
        x.j("WSFeedsLinearLayoutLog", "[WSFeedsLinearLayout.java][handleGestureOnScrollUp] SCROLL_UP!! distanceY:" + f16 + ", mDistanceUp:" + this.f82419f + ", mDistanceUpSlop:" + this.f82422m);
        if (Math.abs(this.f82422m) > 8.0f) {
            this.f82420h = 0.0f;
            float f17 = this.f82419f + f16;
            this.f82419f = f17;
            this.C = 1;
            b bVar = this.f82417d;
            if (bVar != null) {
                bVar.c((int) f17);
            }
        }
    }

    private void i() {
        this.f82419f = 0.0f;
        this.f82420h = 0.0f;
        this.f82422m = 0.0f;
        this.f82421i = 0.0f;
        this.C = 0;
    }

    public WSFeedsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f82419f = 0.0f;
        this.f82420h = 0.0f;
        this.f82421i = 0.0f;
        this.f82422m = 0.0f;
        this.C = 0;
        h();
    }

    public WSFeedsLinearLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f82419f = 0.0f;
        this.f82420h = 0.0f;
        this.f82421i = 0.0f;
        this.f82422m = 0.0f;
        this.C = 0;
        h();
    }
}
