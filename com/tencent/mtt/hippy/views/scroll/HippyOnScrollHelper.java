package com.tencent.mtt.hippy.views.scroll;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyOnScrollHelper {
    private int mPrevX = Integer.MIN_VALUE;
    private int mPrevY = Integer.MIN_VALUE;

    public boolean onScrollChanged(int i3, int i16) {
        boolean z16;
        if (this.mPrevX == i3 && this.mPrevY == i16) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.mPrevX = i3;
        this.mPrevY = i16;
        return z16;
    }
}
