package com.tencent.mobileqq.search.searchdetail;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/SearchPageType;", "", "page", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getPage", "()Ljava/lang/String;", "PAGE_DEFAULT", "PAGE_NET_SEARCH_DETAIL", "PAGE_NET_SEARCH_MINI_APP_MORE", "PAGE_NET_SEARCH_MINI_GAME_MORE", "PAGE_LOCAL_SEARCH", "PAGE_LOCAL_SEARCH_MINIAPP_MORE", "qqsearch-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public enum SearchPageType {
    PAGE_DEFAULT(""),
    PAGE_NET_SEARCH_DETAIL("net_search_detail"),
    PAGE_NET_SEARCH_MINI_APP_MORE("net_search_mini_app_more"),
    PAGE_NET_SEARCH_MINI_GAME_MORE("net_search_mini_game_more"),
    PAGE_LOCAL_SEARCH("local_search"),
    PAGE_LOCAL_SEARCH_MINIAPP_MORE("local_search_miniapp_more");


    @NotNull
    private final String page;

    SearchPageType(String str) {
        this.page = str;
    }

    @NotNull
    public final String getPage() {
        return this.page;
    }
}
