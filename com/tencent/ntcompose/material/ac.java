package com.tencent.ntcompose.material;

import com.tencent.kuikly.core.views.bs;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ*\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ntcompose/material/ac;", "Lcom/tencent/ntcompose/foundation/lazy/d;", "", "index", "", "scrollOffset", "", "animated", "Lcom/tencent/kuikly/core/views/bs;", "springAnimation", "w", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ac extends com.tencent.ntcompose.foundation.lazy.d {
    public ac() {
        super(0, 0.0f);
    }

    @Override // com.tencent.ntcompose.foundation.lazy.d
    public boolean w(int index, float scrollOffset, boolean animated, bs springAnimation) {
        return super.w(index + 1, scrollOffset, animated, springAnimation);
    }
}
