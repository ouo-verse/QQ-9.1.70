package com.tencent.ecommerce.richtext.ui.dom.style;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

/* compiled from: P */
@TargetApi(21)
/* loaded from: classes5.dex */
public class e extends ViewOutlineProvider {

    /* renamed from: a, reason: collision with root package name */
    private float f105376a;

    /* renamed from: b, reason: collision with root package name */
    private int f105377b;

    /* renamed from: c, reason: collision with root package name */
    private int f105378c;

    public e(float f16, int i3, int i16) {
        this.f105376a = f16;
        this.f105377b = i3;
        this.f105378c = i16;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        int i3;
        int i16;
        if (this.f105378c == 2) {
            i3 = -25;
        } else {
            i3 = 0;
        }
        int width = view.getWidth();
        if (this.f105378c == 0) {
            i16 = view.getHeight();
        } else {
            int height = view.getHeight();
            int i17 = this.f105377b;
            if (height > i17) {
                i16 = view.getHeight() + 25;
            } else {
                i16 = i17 + 25;
            }
        }
        outline.setRoundRect(new Rect(0, i3, width, i16), this.f105376a);
    }
}
