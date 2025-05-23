package com.tencent.mtt.hippy.utils;

import android.graphics.Rect;

/* compiled from: P */
/* loaded from: classes20.dex */
public class StrictFocusFinder extends FocusFinder {
    private static final ThreadLocal<FocusFinder> tlFocusFinder = new ThreadLocal<FocusFinder>() { // from class: com.tencent.mtt.hippy.utils.StrictFocusFinder.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public FocusFinder initialValue() {
            return new StrictFocusFinder();
        }
    };

    public static FocusFinder getInstance() {
        return tlFocusFinder.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mtt.hippy.utils.FocusFinder
    public boolean isBetterCandidate(float f16, int i3, Rect rect, Rect rect2, Rect rect3) {
        if (isNonOverlapped(rect, rect2, i3)) {
            return false;
        }
        return super.isBetterCandidate(f16, i3, rect, rect2, rect3);
    }

    boolean isNonOverlapped(Rect rect, Rect rect2, int i3) {
        if (i3 != 17) {
            if (i3 != 33) {
                if (i3 != 66) {
                    if (i3 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return false;
        }
        if (rect.top <= rect2.bottom && rect.bottom >= rect2.top) {
            return false;
        }
        return true;
    }
}
