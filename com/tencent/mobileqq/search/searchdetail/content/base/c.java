package com.tencent.mobileqq.search.searchdetail.content.base;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH&J(\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0004H&J \u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H&\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/base/c;", "Lcom/tencent/mobileqq/search/searchdetail/d;", "", "c", "", "originKeyword", "", "g", "correctionQuery", "d", "query", "b", "Lorg/json/JSONObject;", "f", "Lcom/tencent/mobileqq/search/searchdetail/c;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "a", "", "guildId", "docId", "", "likeStatus", "currentTraceId", tl.h.F, "e", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface c extends com.tencent.mobileqq.search.searchdetail.d {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public static final class a {
        public static void a(@NotNull c cVar, @NotNull String query) {
            Intrinsics.checkNotNullParameter(query, "query");
        }

        public static void b(@NotNull c cVar, @NotNull String originKeyword) {
            Intrinsics.checkNotNullParameter(originKeyword, "originKeyword");
        }
    }

    void a(@NotNull com.tencent.mobileqq.search.searchdetail.c item);

    void b(@NotNull String query);

    boolean c();

    void d(@NotNull String correctionQuery);

    void e(long guildId, @NotNull String docId, @NotNull String currentTraceId);

    @NotNull
    JSONObject f();

    void g(@NotNull String originKeyword);

    void h(long guildId, @NotNull String docId, int likeStatus, @NotNull String currentTraceId);
}
