package com.tencent.mobileqq.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.widget.LinearLayout;

/* compiled from: P */
/* loaded from: classes20.dex */
public class InputMethodLinearLayout extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    protected a f315746d;

    /* renamed from: e, reason: collision with root package name */
    private int f315747e;

    /* renamed from: f, reason: collision with root package name */
    private int f315748f;

    /* renamed from: h, reason: collision with root package name */
    private int f315749h;

    /* renamed from: i, reason: collision with root package name */
    private int f315750i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f315751m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void onSizeChange(boolean z16);
    }

    public InputMethodLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315751m = false;
        Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
        this.f315749h = defaultDisplay.getWidth();
        this.f315750i = defaultDisplay.getHeight();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        this.f315747e = i3;
        this.f315748f = i16;
        super.onMeasure(i3, i16);
    }

    @Override // android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        if (this.f315746d != null && i3 == i17 && i17 != 0 && i18 != 0) {
            if (i16 < i18 && Math.abs(i16 - i18) > (this.f315750i * 1) / 4) {
                this.f315751m = true;
            } else if (i16 > i18 && Math.abs(i16 - i18) > (this.f315750i * 1) / 4) {
                this.f315751m = false;
            } else {
                return;
            }
            this.f315746d.onSizeChange(this.f315751m);
            measure((this.f315747e - i3) + getWidth(), (this.f315748f - i16) + getHeight());
        }
    }

    public void setOnSizeChangedListenner(a aVar) {
        this.f315746d = aVar;
    }

    public InputMethodLinearLayout(Context context) {
        super(context);
        this.f315751m = false;
        Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
        this.f315749h = defaultDisplay.getWidth();
        this.f315750i = defaultDisplay.getHeight();
    }
}
