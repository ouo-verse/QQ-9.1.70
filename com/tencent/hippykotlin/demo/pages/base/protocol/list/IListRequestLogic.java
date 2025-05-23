package com.tencent.hippykotlin.demo.pages.base.protocol.list;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes31.dex */
public interface IListRequestLogic<REQ, RSP> {
    boolean isEnd();

    void reqNextPage(Function1<? super RSP, Unit> function1, Function2<? super Integer, ? super String, Unit> function2);
}
