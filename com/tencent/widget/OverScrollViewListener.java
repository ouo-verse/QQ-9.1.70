package com.tencent.widget;

import android.view.View;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface OverScrollViewListener {
    public static final int OVERSCROLL_POSITION_BOTTOM = 1;
    public static final int OVERSCROLL_POSITION_TOP = 0;

    void onNotCompleteVisable(int i3, View view, ListView listView);

    void onViewCompleteVisable(int i3, View view, ListView listView);

    boolean onViewCompleteVisableAndReleased(int i3, View view, ListView listView);

    void onViewNotCompleteVisableAndReleased(int i3, View view, ListView listView);
}
