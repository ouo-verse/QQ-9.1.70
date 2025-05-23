package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.views.ScrollParams;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECRefreshListViewEvent extends l {
    public Function1<? super ScrollParams, Unit> dragBeginHandler;
    public Function0<Unit> loadMoreHandler;
    public Function0<Unit> refreshHandler;
    public Function0<Unit> retryHandler;
    public Function1<? super ScrollParams, Unit> scrollEndHandler;
}
