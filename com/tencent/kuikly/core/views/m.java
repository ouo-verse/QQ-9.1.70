package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.Attr;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/kuikly/core/views/m;", "Lcom/tencent/kuikly/core/base/Attr;", "", "radius", "", "i", "", "once", tl.h.F, "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class m extends Attr {
    public final void h(boolean once) {
        with("blurOnce", Integer.valueOf(com.tencent.kuikly.core.base.d.b(once)));
    }

    public final void i(float radius) {
        with("blurRadius", Float.valueOf(Math.min(radius, 12.5f)));
    }
}
