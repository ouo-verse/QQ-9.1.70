package com.tencent.ecommerce.biz.mainpage;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/mainpage/ECMainPageFragmentType;", "", "title", "", "(Ljava/lang/String;ILjava/lang/String;)V", "MAIN_PAGE_TYPE_PRE_SALE", "MAIN_PAGE_TYPE_AFTER_SALE", "MAIN_PAGE_TYPE_OTHER", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public enum ECMainPageFragmentType {
    MAIN_PAGE_TYPE_PRE_SALE("\u552e\u524d"),
    MAIN_PAGE_TYPE_AFTER_SALE("\u552e\u540e"),
    MAIN_PAGE_TYPE_OTHER("\u5176\u4ed6");

    public final String title;

    ECMainPageFragmentType(String str) {
        this.title = str;
    }
}
