package com.tencent.mobileqq.guild.widget.qqui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.widget.LinearLayout;

/* compiled from: P */
/* loaded from: classes14.dex */
public class InputMethodLinearLayout extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    protected a f236459d;

    /* renamed from: e, reason: collision with root package name */
    private int f236460e;

    /* renamed from: f, reason: collision with root package name */
    private int f236461f;

    /* renamed from: h, reason: collision with root package name */
    private int f236462h;

    /* renamed from: i, reason: collision with root package name */
    private int f236463i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f236464m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
        void onSizeChange(boolean z16);
    }

    public InputMethodLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f236464m = false;
        Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
        this.f236462h = defaultDisplay.getWidth();
        this.f236463i = defaultDisplay.getHeight();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        this.f236460e = i3;
        this.f236461f = i16;
        super.onMeasure(i3, i16);
    }

    @Override // android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        if (this.f236459d != null && i3 == i17 && i17 != 0 && i18 != 0) {
            if (i16 < i18 && Math.abs(i16 - i18) > (this.f236463i * 1) / 4) {
                this.f236464m = true;
            } else if (i16 > i18 && Math.abs(i16 - i18) > (this.f236463i * 1) / 4) {
                this.f236464m = false;
            } else {
                return;
            }
            this.f236459d.onSizeChange(this.f236464m);
            measure((this.f236460e - i3) + getWidth(), (this.f236461f - i16) + getHeight());
        }
    }

    public void setOnSizeChangedListenner(a aVar) {
        this.f236459d = aVar;
    }

    public InputMethodLinearLayout(Context context) {
        super(context);
        this.f236464m = false;
        Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
        this.f236462h = defaultDisplay.getWidth();
        this.f236463i = defaultDisplay.getHeight();
    }
}
