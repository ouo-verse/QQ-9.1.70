package com.tencent.ntcompose.animation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ntcompose/animation/j;", "T", "Lcom/tencent/ntcompose/animation/a;", "", "other", "", "equals", "Lcom/tencent/ntcompose/animation/g;", "a", "Lcom/tencent/ntcompose/animation/g;", "()Lcom/tencent/ntcompose/animation/g;", "animation", "Lcom/tencent/ntcompose/animation/RepeatMode;", "b", "Lcom/tencent/ntcompose/animation/RepeatMode;", "()Lcom/tencent/ntcompose/animation/RepeatMode;", "repeatMode", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class j<T> implements a<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final g<T> animation;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final RepeatMode repeatMode;

    public final g<T> a() {
        return this.animation;
    }

    /* renamed from: b, reason: from getter */
    public final RepeatMode getRepeatMode() {
        return this.repeatMode;
    }

    public boolean equals(Object other) {
        if (!(other instanceof j)) {
            return false;
        }
        j jVar = (j) other;
        return Intrinsics.areEqual(jVar.animation, this.animation) && jVar.repeatMode == this.repeatMode;
    }
}
