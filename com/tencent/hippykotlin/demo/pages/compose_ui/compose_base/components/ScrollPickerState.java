package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import com.tencent.ntcompose.foundation.lazy.d;

/* loaded from: classes31.dex */
public final class ScrollPickerState {
    public int centerItemIndex;
    public String centerValue;
    public boolean isScrolling;
    public d state;

    public ScrollPickerState() {
        this(null, 0 == true ? 1 : 0, 15);
    }

    public ScrollPickerState(String str, int i3, d dVar, boolean z16) {
        this.centerValue = str;
        this.centerItemIndex = i3;
        this.state = dVar;
        this.isScrolling = z16;
    }

    public /* synthetic */ ScrollPickerState(String str, d dVar, int i3) {
        this((i3 & 1) != 0 ? "" : str, 0, (i3 & 4) != 0 ? new d(0, 0.0f, 3, null) : dVar, false);
    }
}
