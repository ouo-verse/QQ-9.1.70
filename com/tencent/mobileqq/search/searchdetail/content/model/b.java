package com.tencent.mobileqq.search.searchdetail.content.model;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.CommonInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\n\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0017\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/model/b;", "Lcom/tencent/mobileqq/search/searchdetail/a;", "", "getItemType", "Lcom/tencent/mobileqq/search/searchdetail/c;", "newItem", "", "a", "p", "(Lcom/tencent/mobileqq/search/searchdetail/c;)Ljava/lang/Boolean;", "", tl.h.F, "Ljava/lang/String;", "r", "()Ljava/lang/String;", "keyword", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "correctionQuery", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b extends com.tencent.mobileqq.search.searchdetail.a {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String keyword;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String correctionQuery;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull String keyword, @NotNull String correctionQuery) {
        super(new CommonInfo("", "all", "", 0, "", "", new byte[0], 1, null, false, false, 1792, null));
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(correctionQuery, "correctionQuery");
        this.keyword = keyword;
        this.correctionQuery = correctionQuery;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.a, com.tencent.mobileqq.search.searchdetail.c
    public boolean a(@NotNull com.tencent.mobileqq.search.searchdetail.c newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (newItem instanceof b) {
            b bVar = (b) newItem;
            if (Intrinsics.areEqual(this.keyword, bVar.keyword) && Intrinsics.areEqual(this.correctionQuery, bVar.correctionQuery)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.a, com.tencent.mobileqq.search.searchdetail.c
    public int getItemType() {
        return 1000;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.c
    @NotNull
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public Boolean e(@NotNull com.tencent.mobileqq.search.searchdetail.c newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Boolean.FALSE;
    }

    @NotNull
    /* renamed from: q, reason: from getter */
    public final String getCorrectionQuery() {
        return this.correctionQuery;
    }

    @NotNull
    /* renamed from: r, reason: from getter */
    public final String getKeyword() {
        return this.keyword;
    }
}
