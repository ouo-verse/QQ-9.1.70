package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes20.dex */
public class WebViewProgressBar extends View {

    /* renamed from: d, reason: collision with root package name */
    private Drawable f316579d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f316580e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f316581f;

    /* renamed from: h, reason: collision with root package name */
    private bx f316582h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f316583i;

    public WebViewProgressBar(Context context) {
        super(context);
        this.f316581f = true;
        this.f316583i = null;
    }

    public void a() {
        this.f316580e = null;
        this.f316579d = null;
        this.f316583i = null;
        this.f316581f = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i3;
        int i16;
        int i17;
        int i18;
        super.onDraw(canvas);
        bx bxVar = this.f316582h;
        if (bxVar != null && bxVar.e() != 6) {
            if (this.f316583i != null && this.f316579d != null) {
                int d16 = (int) this.f316582h.d();
                if (d16 < this.f316579d.getIntrinsicWidth()) {
                    i18 = d16 - this.f316579d.getIntrinsicWidth();
                    i17 = this.f316579d.getIntrinsicWidth();
                } else {
                    i17 = d16;
                    i18 = 0;
                }
                int i19 = i17 + i18;
                if (i19 > 0) {
                    this.f316583i.setBounds(0, 0, getWidth(), getHeight());
                    this.f316583i.draw(canvas);
                    Drawable drawable = this.f316580e;
                    if (drawable != null) {
                        drawable.setBounds(0, 0, getWidth(), getHeight());
                        this.f316580e.draw(canvas);
                    }
                }
                this.f316579d.setBounds(i18, 0, i19, getHeight());
                this.f316579d.draw(canvas);
                return;
            }
            if (this.f316580e == null) {
                this.f316580e = getContext().getResources().getDrawable(R.drawable.skin_custom_progress_bg);
            }
            this.f316580e.setBounds(0, 0, getWidth(), getHeight());
            this.f316580e.draw(canvas);
            if (this.f316579d == null) {
                this.f316579d = getContext().getResources().getDrawable(R.drawable.f162458gv4);
            }
            int d17 = (int) this.f316582h.d();
            if (this.f316581f) {
                this.f316579d.setAlpha(this.f316582h.b());
            }
            if (d17 < this.f316579d.getIntrinsicWidth()) {
                i16 = d17 - this.f316579d.getIntrinsicWidth();
                i3 = this.f316579d.getIntrinsicWidth();
            } else {
                i3 = d17;
                i16 = 0;
            }
            this.f316579d.setBounds(i16, 0, i3 + i16, getHeight());
            this.f316579d.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        bx bxVar = this.f316582h;
        if (bxVar != null) {
            bxVar.m(getWidth());
        }
    }

    public void setController(bx bxVar) {
        bx bxVar2 = this.f316582h;
        if (bxVar2 == bxVar) {
            return;
        }
        if (bxVar2 != null) {
            bxVar2.k(null);
        }
        this.f316582h = bxVar;
        if (bxVar != null) {
            bxVar.k(this);
            this.f316582h.m(getWidth());
        }
        invalidate();
    }

    public void setCustomColor(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("WebViewProgressBar", 2, "setCustomColor color=" + Integer.toHexString(i3));
        }
        this.f316583i = new ColorDrawable(-1);
        int i16 = i3 & Integer.MAX_VALUE;
        this.f316580e = new ColorDrawable(i16);
        this.f316579d = new ColorDrawable(i16);
        this.f316581f = false;
    }

    public WebViewProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f316581f = true;
        this.f316583i = null;
    }

    public WebViewProgressBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316581f = true;
        this.f316583i = null;
    }
}
