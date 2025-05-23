package com.tencent.aelight.camera.ae.camera.ui.bubble;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.flashshow.util.v;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import cq.a;

/* compiled from: P */
/* loaded from: classes32.dex */
public class BubbleTextView extends TextView {
    public int C;
    public boolean D;
    public int E;

    /* renamed from: d, reason: collision with root package name */
    private a f62576d;

    /* renamed from: e, reason: collision with root package name */
    public float f62577e;

    /* renamed from: f, reason: collision with root package name */
    public float f62578f;

    /* renamed from: h, reason: collision with root package name */
    public float f62579h;

    /* renamed from: i, reason: collision with root package name */
    public float f62580i;

    /* renamed from: m, reason: collision with root package name */
    public int f62581m;

    public BubbleTextView(Context context) {
        super(context);
        this.f62577e = v.a(BaseApplication.getContext(), 11.0f);
        this.f62578f = v.a(BaseApplication.getContext(), 3.0f);
        this.f62579h = v.a(BaseApplication.getContext(), 5.0f);
        this.f62580i = 50.0f;
        this.f62581m = getResources().getColor(R.color.f9018i);
        this.C = 3;
        this.D = true;
        this.E = 0;
    }

    private void b() {
        c(getWidth(), getHeight());
    }

    private void d(int i3, int i16, int i17, int i18) {
        a aVar = new a();
        this.f62576d = aVar;
        aVar.f391620a = new RectF(i3, i17, i16, i18);
        a aVar2 = this.f62576d;
        aVar2.f391630k = this.C;
        aVar2.f391631l = this.E;
        aVar2.f391625f = this.f62578f;
        aVar2.f391626g = this.f62579h;
        aVar2.f391624e = this.f62577e;
        aVar2.f391628i = this.f62581m;
        aVar2.f391627h = this.f62580i;
        aVar2.f391632m = this.D;
    }

    private void e() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i3 = this.C;
        if (i3 == 0) {
            paddingLeft = (int) (paddingLeft + this.f62577e);
        } else if (i3 == 1) {
            paddingRight = (int) (paddingRight + this.f62577e);
        } else if (i3 == 2) {
            paddingTop = (int) (paddingTop + this.f62579h);
        } else if (i3 == 3) {
            paddingBottom = (int) (paddingBottom + this.f62579h);
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public void a() {
        f();
        e();
    }

    @Override // android.view.View
    public void layout(int i3, int i16, int i17, int i18) {
        super.layout(i3, i16, i17, i18);
        b();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        a aVar = this.f62576d;
        if (aVar != null) {
            aVar.draw(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        if (i3 <= 0 || i16 <= 0) {
            return;
        }
        c(i3, i16);
    }

    private void c(int i3, int i16) {
        d(0, i3, 0, i16);
    }

    public BubbleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f62577e = v.a(BaseApplication.getContext(), 11.0f);
        this.f62578f = v.a(BaseApplication.getContext(), 3.0f);
        this.f62579h = v.a(BaseApplication.getContext(), 5.0f);
        this.f62580i = 50.0f;
        this.f62581m = getResources().getColor(R.color.f9018i);
        this.C = 3;
        this.D = true;
        this.E = 0;
        a();
    }

    public BubbleTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f62577e = v.a(BaseApplication.getContext(), 11.0f);
        this.f62578f = v.a(BaseApplication.getContext(), 3.0f);
        this.f62579h = v.a(BaseApplication.getContext(), 5.0f);
        this.f62580i = 50.0f;
        this.f62581m = getResources().getColor(R.color.f9018i);
        this.C = 3;
        this.D = true;
        this.E = 0;
        a();
    }

    protected void f() {
    }
}
