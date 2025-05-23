package com.tencent.state.square.data;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/state/square/data/AvatarLabelType;", "", "priority", "", "(Ljava/lang/String;II)V", "getPriority", "()I", "LABEL_NONE", "LABEL_NEW_INTERACT", "LABEL_NEW_DRESS", "LABEL_IN_LIBRARY", "LABEL_STRANGER", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public enum AvatarLabelType {
    LABEL_NONE(0),
    LABEL_NEW_INTERACT(1),
    LABEL_NEW_DRESS(2),
    LABEL_IN_LIBRARY(3),
    LABEL_STRANGER(4);

    private final int priority;

    AvatarLabelType(int i3) {
        this.priority = i3;
    }

    public final int getPriority() {
        return this.priority;
    }
}
