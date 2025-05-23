package com.tencent.mm.ui.widget.pulldown;

import android.view.View;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface IOverScrollCallback {
    public static final int DIRECTION_DOWN = 2;
    public static final int DIRECTION_LEFT = 4;
    public static final int DIRECTION_RIGHT = 8;
    public static final int DIRECTION_UP = 1;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public @interface ScrollDirection {
    }

    boolean canScroll(IOverScroll iOverScroll, View view, @ScrollDirection int i3);

    float getDampingFactor(IOverScroll iOverScroll, View view, @ScrollDirection int i3);

    int getMaxFlingOffset(IOverScroll iOverScroll, View view, @ScrollDirection int i3);

    int getMinFlingVelocity(IOverScroll iOverScroll, View view, @ScrollDirection int i3);

    void onOffsetChanged(IOverScroll iOverScroll, View view, int i3);

    boolean onSpringBack(IOverScroll iOverScroll, View view);

    void onStopSpringingBack(IOverScroll iOverScroll, View view);
}
