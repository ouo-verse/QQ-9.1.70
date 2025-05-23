package com.tencent.mm.ui.widget.pulldown;

import android.view.View;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface IOverScroll {
    int getMaxOffset(View view);

    int getMinOffset(View view);

    int getOffset(View view);

    void setOffset(View view, int i3);

    void springBack(View view);

    void stopSpringBack(View view);
}
