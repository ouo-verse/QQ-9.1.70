package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.views.FooterRefreshState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECRefreshFooterEvent extends l {
    public Function0<Unit> onRefreshingHandlerFn;
    public Function1<? super FooterRefreshState, Unit> refreshStateDidChangeHandlerFn;
}
