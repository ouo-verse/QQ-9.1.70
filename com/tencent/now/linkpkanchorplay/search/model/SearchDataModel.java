package com.tencent.now.linkpkanchorplay.search.model;

import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.now.linkpkanchorplay.search.model.SearchDataModel;
import com.tencent.now.linkpkanchorplay.sso.request.SearchAnchorRequest;
import com.tencent.qqlive.common.api.AegisLogger;
import g55.az;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0003\t\u000f\bB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0007R\u0018\u0010\f\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000bR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/search/model/SearchDataModel;", "", "", "keywords", "Lcom/tencent/now/linkpkanchorplay/search/model/SearchDataModel$b;", "callback", "extra", "", "c", "a", "Lg55/az;", "Lg55/az;", "cacheSearchAnchorRsp", "", "Le55/a;", "b", "Ljava/util/List;", "()Ljava/util/List;", "mergeAnchorList", "<init>", "()V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class SearchDataModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private az cacheSearchAnchorRsp;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<e55.a> mergeAnchorList = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/search/model/SearchDataModel$b;", "", "Lcom/tencent/now/linkpkanchorplay/search/model/SearchDataModel$c;", "searchResult", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public interface b {
        void a(@Nullable SearchResult searchResult);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\t\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0019\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/search/model/SearchDataModel$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getSearchWord", "()Ljava/lang/String;", "searchWord", "", "Le55/a;", "b", "Ljava/util/List;", "()Ljava/util/List;", "anchorList", "c", "extra", "d", "Z", "()Z", "isFirstPage", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Z)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.now.linkpkanchorplay.search.model.SearchDataModel$c, reason: from toString */
    /* loaded from: classes22.dex */
    public static final /* data */ class SearchResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String searchWord;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final List<e55.a> anchorList;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String extra;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isFirstPage;

        public SearchResult(@NotNull String searchWord, @Nullable List<e55.a> list, @NotNull String extra, boolean z16) {
            Intrinsics.checkNotNullParameter(searchWord, "searchWord");
            Intrinsics.checkNotNullParameter(extra, "extra");
            this.searchWord = searchWord;
            this.anchorList = list;
            this.extra = extra;
            this.isFirstPage = z16;
        }

        @Nullable
        public final List<e55.a> a() {
            return this.anchorList;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getExtra() {
            return this.extra;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsFirstPage() {
            return this.isFirstPage;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SearchResult)) {
                return false;
            }
            SearchResult searchResult = (SearchResult) other;
            if (Intrinsics.areEqual(this.searchWord, searchResult.searchWord) && Intrinsics.areEqual(this.anchorList, searchResult.anchorList) && Intrinsics.areEqual(this.extra, searchResult.extra) && this.isFirstPage == searchResult.isFirstPage) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int hashCode2 = this.searchWord.hashCode() * 31;
            List<e55.a> list = this.anchorList;
            if (list == null) {
                hashCode = 0;
            } else {
                hashCode = list.hashCode();
            }
            int hashCode3 = (((hashCode2 + hashCode) * 31) + this.extra.hashCode()) * 31;
            boolean z16 = this.isFirstPage;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode3 + i3;
        }

        @NotNull
        public String toString() {
            return "SearchResult(searchWord=" + this.searchWord + ", anchorList=" + this.anchorList + ", extra=" + this.extra + ", isFirstPage=" + this.isFirstPage + ')';
        }
    }

    public final void a() {
        this.mergeAnchorList.clear();
        this.cacheSearchAnchorRsp = null;
    }

    @NotNull
    public final List<e55.a> b() {
        return this.mergeAnchorList;
    }

    public final void c(@NotNull final String keywords, @Nullable final b callback, @NotNull String extra) {
        final boolean z16;
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        Intrinsics.checkNotNullParameter(extra, "extra");
        AegisLogger.INSTANCE.i("PK_Biz|SearchDataModel", "searchAnchor", "keywords:" + keywords);
        if (extra.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new SearchAnchorRequest(keywords, extra), new Function1<QQLiveResponse<az>, Unit>() { // from class: com.tencent.now.linkpkanchorplay.search.model.SearchDataModel$searchAnchor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<az> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<az> response) {
                List list;
                Unit unit;
                List list2;
                Intrinsics.checkNotNullParameter(response, "response");
                az rsp = response.getRsp();
                if (!response.isFailed() && rsp != null) {
                    e55.a[] aVarArr = rsp.f401348a;
                    if (aVarArr != null) {
                        SearchDataModel searchDataModel = this;
                        SearchDataModel.b bVar = SearchDataModel.b.this;
                        String str = keywords;
                        boolean z17 = z16;
                        List<e55.a> b16 = searchDataModel.b();
                        list = ArraysKt___ArraysKt.toList(aVarArr);
                        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<trpc.qqlive.common.anchor.nano.AnchorInfo>");
                        b16.addAll(list);
                        if (bVar != null) {
                            e55.a[] aVarArr2 = rsp.f401348a;
                            Intrinsics.checkNotNullExpressionValue(aVarArr2, "rsp.searchAnchors");
                            list2 = ArraysKt___ArraysKt.toList(aVarArr2);
                            String str2 = rsp.f401350c;
                            Intrinsics.checkNotNullExpressionValue(str2, "rsp.extra");
                            bVar.a(new SearchDataModel.SearchResult(str, list2, str2, z17));
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit != null) {
                            return;
                        }
                    }
                    SearchDataModel.b bVar2 = SearchDataModel.b.this;
                    String str3 = keywords;
                    boolean z18 = z16;
                    if (bVar2 != null) {
                        bVar2.a(new SearchDataModel.SearchResult(str3, null, "", z18));
                        Unit unit2 = Unit.INSTANCE;
                        return;
                    }
                    return;
                }
                AegisLogger.INSTANCE.e("PK_Biz|SearchDataModel", "searchAnchor", "onFailure code:" + response.getRetCode() + ", msg:" + response.getErrMsg());
                SearchDataModel.b bVar3 = SearchDataModel.b.this;
                if (bVar3 != null) {
                    bVar3.a(new SearchDataModel.SearchResult(keywords, null, "", z16));
                }
            }
        });
    }
}
