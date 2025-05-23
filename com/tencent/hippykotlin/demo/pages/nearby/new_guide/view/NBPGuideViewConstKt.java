package com.tencent.hippykotlin.demo.pages.nearby.new_guide.view;

import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.l;

/* loaded from: classes31.dex */
public final class NBPGuideViewConstKt {
    public static final <A extends k, E extends l> float pageViewFitWidth(ComposeView<A, E> composeView) {
        return Math.min(composeView.getPagerData().m(), 420.0f);
    }
}
