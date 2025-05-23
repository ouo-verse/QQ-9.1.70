package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public enum BoundType {
    OPEN(false),
    CLOSED(true);

    final boolean inclusive;

    BoundType(boolean z16) {
        this.inclusive = z16;
    }

    static BoundType forBoolean(boolean z16) {
        if (z16) {
            return CLOSED;
        }
        return OPEN;
    }

    BoundType flip() {
        return forBoolean(!this.inclusive);
    }
}
