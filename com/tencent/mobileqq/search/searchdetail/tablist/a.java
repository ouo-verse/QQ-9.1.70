package com.tencent.mobileqq.search.searchdetail.tablist;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H&J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\r\u001a\u00020\u0002H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/tablist/a;", "", "", "getKeyword", "getSugTraceId", "b", "", "d", "keyword", "", "a", "Lcom/tencent/mobileqq/search/tux/b;", "c", "getMiniAppSessionId", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface a {
    void a(@NotNull String keyword);

    @NotNull
    String b();

    @Nullable
    com.tencent.mobileqq.search.tux.b c();

    boolean d();

    @NotNull
    String getKeyword();

    @NotNull
    String getMiniAppSessionId();

    @NotNull
    String getSugTraceId();
}
