package com.tencent.filament.zplan.view.event;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/filament/zplan/view/event/TouchEventState;", "", "", "toTouchEventIntState", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "Began", "Changed", "Ended", "Failed", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public enum TouchEventState {
    Began,
    Changed,
    Ended,
    Failed;

    public final int toTouchEventIntState() {
        int i3 = b.f106349a[ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return 1;
            }
            if (i3 == 3) {
                return 2;
            }
            if (i3 == 4) {
                return 3;
            }
            throw new NoWhenBranchMatchedException();
        }
        return 0;
    }
}
