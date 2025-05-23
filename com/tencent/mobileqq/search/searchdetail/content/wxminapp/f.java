package com.tencent.mobileqq.search.searchdetail.content.wxminapp;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\"\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\t\u001a\u0004\b\u000b\u0010\n\"\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/f;", "", "Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/d;", "searchInfo", "Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/d;", "a", "()Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/d;", "", "isSearch", "I", "()I", "isAd", "b", "(I)V", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class f {

    @SerializedName("is_ad")
    private int isAd;

    @SerializedName("search_info")
    @NotNull
    private final d searchInfo = new d();

    @SerializedName("is_search")
    private final int isSearch = 1;

    @NotNull
    /* renamed from: a, reason: from getter */
    public final d getSearchInfo() {
        return this.searchInfo;
    }

    public final void b(int i3) {
        this.isAd = i3;
    }
}
