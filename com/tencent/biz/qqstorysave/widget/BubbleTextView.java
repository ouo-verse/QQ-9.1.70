package com.tencent.biz.qqstorysave.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import qd0.a;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BubbleTextView extends TextView {
    public int C;
    public boolean D;
    public int E;

    /* renamed from: d, reason: collision with root package name */
    private a f94525d;

    /* renamed from: e, reason: collision with root package name */
    public float f94526e;

    /* renamed from: f, reason: collision with root package name */
    public float f94527f;

    /* renamed from: h, reason: collision with root package name */
    public float f94528h;

    /* renamed from: i, reason: collision with root package name */
    public float f94529i;

    /* renamed from: m, reason: collision with root package name */
    public int f94530m;

    public BubbleTextView(Context context) {
        super(context);
        this.f94526e = UIUtils.b(BaseApplication.getContext(), 11.0f);
        this.f94527f = UIUtils.b(BaseApplication.getContext(), 3.0f);
        this.f94528h = UIUtils.b(BaseApplication.getContext(), 5.0f);
        this.f94529i = 50.0f;
        this.f94530m = getResources().getColor(R.color.a2t);
        this.C = 3;
        this.D = true;
        this.E = 0;
    }

    private void b() {
        c(getWidth(), getHeight());
    }

    private void c(int i3, int i16) {
        d(0, i3, 0, i16);
    }

    private void d(int i3, int i16, int i17, int i18) {
        a aVar = new a();
        this.f94525d = aVar;
        aVar.f428857a = new RectF(i3, i17, i16, i18);
        a aVar2 = this.f94525d;
        aVar2.f428867k = this.C;
        aVar2.f428868l = this.E;
        aVar2.f428862f = this.f94527f;
        aVar2.f428863g = this.f94528h;
        aVar2.f428861e = this.f94526e;
        aVar2.f428865i = this.f94530m;
        aVar2.f428864h = this.f94529i;
        aVar2.f428869m = this.D;
    }

    private void e() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i3 = this.C;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        paddingBottom = (int) (paddingBottom + this.f94528h);
                    }
                } else {
                    paddingTop = (int) (paddingTop + this.f94528h);
                }
            } else {
                paddingRight = (int) (paddingRight + this.f94526e);
            }
        } else {
            paddingLeft = (int) (paddingLeft + this.f94526e);
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
        a aVar = this.f94525d;
        if (aVar != null) {
            aVar.draw(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        if (i3 > 0 && i16 > 0) {
            c(i3, i16);
        }
    }

    public BubbleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f94526e = UIUtils.b(BaseApplication.getContext(), 11.0f);
        this.f94527f = UIUtils.b(BaseApplication.getContext(), 3.0f);
        this.f94528h = UIUtils.b(BaseApplication.getContext(), 5.0f);
        this.f94529i = 50.0f;
        this.f94530m = getResources().getColor(R.color.a2t);
        this.C = 3;
        this.D = true;
        this.E = 0;
        a();
    }

    public BubbleTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f94526e = UIUtils.b(BaseApplication.getContext(), 11.0f);
        this.f94527f = UIUtils.b(BaseApplication.getContext(), 3.0f);
        this.f94528h = UIUtils.b(BaseApplication.getContext(), 5.0f);
        this.f94529i = 50.0f;
        this.f94530m = getResources().getColor(R.color.a2t);
        this.C = 3;
        this.D = true;
        this.E = 0;
        a();
    }

    protected void f() {
    }
}
