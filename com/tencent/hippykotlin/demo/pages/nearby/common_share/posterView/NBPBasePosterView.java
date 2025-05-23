package com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView;

import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class NBPBasePosterView {
    public final Object data;
    public final Function1<ViewContainer<?, ?>, Unit> posterViewBuilder;

    public NBPBasePosterView(Function1 function1, Object obj) {
        this.posterViewBuilder = function1;
        this.data = obj;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NBPBasePosterView() {
        this(null, null);
        new w(300.0f, 300.0f);
    }
}
