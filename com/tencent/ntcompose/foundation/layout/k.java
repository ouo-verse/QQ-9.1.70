package com.tencent.ntcompose.foundation.layout;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007\u001a.\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u0000\u00a8\u0006\t"}, d2 = {"", "all", "Lcom/tencent/ntcompose/foundation/layout/l;", "a", "left", "top", "right", "bottom", "b", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class k {
    public static final l a(float f16) {
        return new PaddingValues(f16, f16, f16, f16);
    }

    public static final l b(float f16, float f17, float f18, float f19) {
        return new PaddingValues(f16, f17, f18, f19);
    }

    public static /* synthetic */ l c(float f16, float f17, float f18, float f19, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = 0;
        }
        if ((i3 & 2) != 0) {
            f17 = 0;
        }
        if ((i3 & 4) != 0) {
            f18 = 0;
        }
        if ((i3 & 8) != 0) {
            f19 = 0;
        }
        return b(f16, f17, f18, f19);
    }
}
