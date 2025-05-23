package com.tencent.state.square.layout;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/square/layout/MoveRequest;", "", "src", "Lcom/tencent/state/square/layout/MoveSource;", "dstIndex", "", "(Lcom/tencent/state/square/layout/MoveSource;I)V", "getDstIndex", "()I", "getSrc", "()Lcom/tencent/state/square/layout/MoveSource;", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MoveRequest {
    private final int dstIndex;
    private final MoveSource src;

    public MoveRequest(MoveSource src, int i3) {
        Intrinsics.checkNotNullParameter(src, "src");
        this.src = src;
        this.dstIndex = i3;
    }

    public final int getDstIndex() {
        return this.dstIndex;
    }

    public final MoveSource getSrc() {
        return this.src;
    }

    public String toString() {
        return '{' + this.src + ", " + this.dstIndex + '}';
    }
}
