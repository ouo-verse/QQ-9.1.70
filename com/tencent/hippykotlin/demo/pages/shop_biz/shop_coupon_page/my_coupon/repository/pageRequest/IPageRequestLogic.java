package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.repository.pageRequest;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes33.dex */
public interface IPageRequestLogic<REQ, RSP> {
    boolean isEnd();

    void reqNextPage(Function1<? super RSP, Unit> function1, Function2<? super Integer, ? super String, Unit> function2);
}
