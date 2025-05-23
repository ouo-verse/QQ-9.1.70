package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.Attr;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/kuikly/core/views/f;", "Lcom/tencent/kuikly/core/base/Attr;", "", "isGrayStyle", "", tl.h.F, "<init>", "()V", "a", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class f extends Attr {
    public final void h(boolean isGrayStyle) {
        String str;
        if (isGrayStyle) {
            str = "gray";
        } else {
            str = "white";
        }
        with("style", str);
    }
}
