package com.tencent.ntcompose.foundation.lazy;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ntcompose/foundation/lazy/a;", "Lcom/tencent/ntcompose/foundation/lazy/d;", "", "initialFirstVisibleItemIndex", "", "initialFirstVisibleItemScrollOffset", "<init>", "(IF)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a extends d {
    public a() {
        this(0, 0.0f, 3, null);
    }

    public /* synthetic */ a(int i3, float f16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? 0.0f : f16);
    }

    public a(int i3, float f16) {
        super(i3, f16);
    }
}
