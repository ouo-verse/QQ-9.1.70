package com.tencent.biz.qqstorysave.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.biz.qqstory.utils.h;
import hd0.c;

/* loaded from: classes5.dex */
public class PollContainerLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private final h.a f94531d;

    /* renamed from: e, reason: collision with root package name */
    boolean f94532e;

    public PollContainerLayout(@NonNull Context context) {
        this(context, null);
    }

    public boolean b(boolean z16) {
        boolean z17 = this.f94532e;
        this.f94532e = z16;
        return z17;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        int i19 = i17 - i3;
        int i26 = i18 - i16;
        a(i19, i26);
        c.c("PollContainerLayout", "onLayout wh(%d, %d)", Integer.valueOf(i19), Integer.valueOf(i26));
    }

    public PollContainerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f94532e = false;
        h.a b16 = h.b(getContext(), 1, 1, null);
        this.f94531d = b16;
        b16.a(false);
        addView(b16.getView(), new FrameLayout.LayoutParams(-2, -2));
        setVisibility(4);
        setClipChildren(false);
        setClickable(false);
    }

    private void a(int i3, int i16) {
    }
}
