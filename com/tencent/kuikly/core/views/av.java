package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.Attr;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0005\u00a8\u0006\f"}, d2 = {"Lcom/tencent/kuikly/core/views/av;", "Lcom/tencent/kuikly/core/base/Attr;", "", "src", "", "", "loop", tl.h.F, "play", "autoPlay", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class av extends Attr {
    public final void autoPlay(boolean play) {
        with("autoPlay", Integer.valueOf(com.tencent.kuikly.core.base.d.b(play)));
    }

    public final void h(boolean loop) {
        with("loopAnimation", Integer.valueOf(com.tencent.kuikly.core.base.d.b(loop)));
    }

    public final void src(String src) {
        Intrinsics.checkNotNullParameter(src, "src");
        with("src", src);
    }
}
