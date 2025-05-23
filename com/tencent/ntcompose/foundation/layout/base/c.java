package com.tencent.ntcompose.foundation.layout.base;

import com.tencent.kuikly.core.layout.FlexDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b\n\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ntcompose/foundation/layout/base/c;", "", "Lcom/tencent/ntcompose/foundation/layout/base/Alignment;", "a", "Lcom/tencent/ntcompose/foundation/layout/base/Alignment;", "()Lcom/tencent/ntcompose/foundation/layout/base/Alignment;", "d", "(Lcom/tencent/ntcompose/foundation/layout/base/Alignment;)V", "alignment", "", "b", "Z", "c", "()Z", "f", "(Z)V", "isMatchParentSize", "Lcom/tencent/kuikly/core/layout/FlexDirection;", "Lcom/tencent/kuikly/core/layout/FlexDirection;", "()Lcom/tencent/kuikly/core/layout/FlexDirection;", "e", "(Lcom/tencent/kuikly/core/layout/FlexDirection;)V", "mainAxis", "<init>", "(Lcom/tencent/ntcompose/foundation/layout/base/Alignment;ZLcom/tencent/kuikly/core/layout/FlexDirection;)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Alignment alignment;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isMatchParentSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private FlexDirection mainAxis;

    public c() {
        this(null, false, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final Alignment getAlignment() {
        return this.alignment;
    }

    /* renamed from: b, reason: from getter */
    public final FlexDirection getMainAxis() {
        return this.mainAxis;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsMatchParentSize() {
        return this.isMatchParentSize;
    }

    public final void d(Alignment alignment) {
        Intrinsics.checkNotNullParameter(alignment, "<set-?>");
        this.alignment = alignment;
    }

    public final void e(FlexDirection flexDirection) {
        this.mainAxis = flexDirection;
    }

    public final void f(boolean z16) {
        this.isMatchParentSize = z16;
    }

    public c(Alignment alignment, boolean z16, FlexDirection flexDirection) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        this.alignment = alignment;
        this.isMatchParentSize = z16;
        this.mainAxis = flexDirection;
    }

    public /* synthetic */ c(Alignment alignment, boolean z16, FlexDirection flexDirection, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Alignment.Center : alignment, (i3 & 2) != 0 ? false : z16, (i3 & 4) != 0 ? null : flexDirection);
    }
}
