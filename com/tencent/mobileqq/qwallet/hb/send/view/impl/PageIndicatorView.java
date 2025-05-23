package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import java.util.List;

/* loaded from: classes16.dex */
public class PageIndicatorView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private Context f277791d;

    /* renamed from: e, reason: collision with root package name */
    private int f277792e;

    /* renamed from: f, reason: collision with root package name */
    private int f277793f;

    /* renamed from: h, reason: collision with root package name */
    private List<View> f277794h;

    public PageIndicatorView(Context context) {
        this(context, null);
    }

    private int a(float f16) {
        return (int) ((f16 * this.f277791d.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void b(Context context) {
        this.f277791d = context;
        setGravity(17);
        setOrientation(0);
        this.f277792e = a(this.f277792e);
        this.f277793f = a(this.f277793f);
    }

    public void setSelectedPage(int i3) {
        if (this.f277794h == null) {
            return;
        }
        for (int i16 = 0; i16 < this.f277794h.size(); i16++) {
            if (i16 == i3) {
                this.f277794h.get(i16).setBackgroundResource(R.drawable.l_k);
            } else {
                this.f277794h.get(i16).setBackgroundResource(R.drawable.l_j);
            }
        }
    }

    public PageIndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PageIndicatorView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f277791d = null;
        this.f277792e = 8;
        this.f277793f = 4;
        this.f277794h = null;
        b(context);
    }
}
