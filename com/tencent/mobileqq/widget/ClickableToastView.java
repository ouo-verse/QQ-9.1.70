package com.tencent.mobileqq.widget;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ClickableToastView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private int f315535d;

    /* renamed from: e, reason: collision with root package name */
    private Resources f315536e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f315537f;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {
    }

    public void setToastIcon(int i3) {
        setToastIcon(this.f315536e.getDrawable(i3));
    }

    public void setType(int i3) {
        this.f315535d = i3;
    }

    public void setToastIcon(Drawable drawable) {
        if (this.f315535d != -1) {
            this.f315537f = drawable;
        }
    }

    public void setRightActionParams(a aVar) {
    }
}
