package com.tencent.mobileqq.guild.quicksearch.resultview.dssearch;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u001e\u0010\u001fJ=\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u00c6\u0001J\t\u0010\u000b\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/s;", "", "", "uuid", "content", "reasonContent", "", "firstDataTimestamp", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/r;", "finishReason", "a", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getUuid", "()Ljava/lang/String;", "b", "c", "d", "J", "getFirstDataTimestamp", "()J", "e", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/r;", "getFinishReason", "()Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/r;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/r;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.s, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class SearchResponse {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String uuid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String content;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String reasonContent;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long firstDataTimestamp;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final r finishReason;

    public SearchResponse() {
        this(null, null, null, 0L, null, 31, null);
    }

    public static /* synthetic */ SearchResponse b(SearchResponse searchResponse, String str, String str2, String str3, long j3, r rVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = searchResponse.uuid;
        }
        if ((i3 & 2) != 0) {
            str2 = searchResponse.content;
        }
        String str4 = str2;
        if ((i3 & 4) != 0) {
            str3 = searchResponse.reasonContent;
        }
        String str5 = str3;
        if ((i3 & 8) != 0) {
            j3 = searchResponse.firstDataTimestamp;
        }
        long j16 = j3;
        if ((i3 & 16) != 0) {
            rVar = searchResponse.finishReason;
        }
        return searchResponse.a(str, str4, str5, j16, rVar);
    }

    @NotNull
    public final SearchResponse a(@NotNull String uuid, @NotNull String content, @NotNull String reasonContent, long firstDataTimestamp, @Nullable r finishReason) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(reasonContent, "reasonContent");
        return new SearchResponse(uuid, content, reasonContent, firstDataTimestamp, finishReason);
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getReasonContent() {
        return this.reasonContent;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchResponse)) {
            return false;
        }
        SearchResponse searchResponse = (SearchResponse) other;
        if (Intrinsics.areEqual(this.uuid, searchResponse.uuid) && Intrinsics.areEqual(this.content, searchResponse.content) && Intrinsics.areEqual(this.reasonContent, searchResponse.reasonContent) && this.firstDataTimestamp == searchResponse.firstDataTimestamp && Intrinsics.areEqual(this.finishReason, searchResponse.finishReason)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((this.uuid.hashCode() * 31) + this.content.hashCode()) * 31) + this.reasonContent.hashCode()) * 31) + androidx.fragment.app.a.a(this.firstDataTimestamp)) * 31;
        r rVar = this.finishReason;
        if (rVar == null) {
            hashCode = 0;
        } else {
            hashCode = rVar.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "SearchResponse(uuid=" + this.uuid + ", content=" + this.content + ", reasonContent=" + this.reasonContent + ", firstDataTimestamp=" + this.firstDataTimestamp + ", finishReason=" + this.finishReason + ")";
    }

    public SearchResponse(@NotNull String uuid, @NotNull String content, @NotNull String reasonContent, long j3, @Nullable r rVar) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(reasonContent, "reasonContent");
        this.uuid = uuid;
        this.content = content;
        this.reasonContent = reasonContent;
        this.firstDataTimestamp = j3;
        this.finishReason = rVar;
    }

    public /* synthetic */ SearchResponse(String str, String str2, String str3, long j3, r rVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) == 0 ? str3 : "", (i3 & 8) != 0 ? 0L : j3, (i3 & 16) != 0 ? null : rVar);
    }
}
