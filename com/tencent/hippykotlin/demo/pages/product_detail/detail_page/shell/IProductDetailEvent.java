package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell;

import java.util.Set;

/* loaded from: classes31.dex */
public interface IProductDetailEvent {
    Set<String> canHandleEventName();

    void onEvent(String str, Object obj);
}
