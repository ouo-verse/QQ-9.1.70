package com.tencent.mobileqq.mini.entry.search.viewmodel;

import com.tencent.mobileqq.mini.appbrand.utils.f;
import com.tencent.mobileqq.search.searchdetail.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\t\u001a\u00020\u0004H\u00c6\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u00c6\u0003J\t\u0010\r\u001a\u00020\u0004H\u00c6\u0003JM\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00042\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\b\u0002\u0010\u0013\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\u0016\u001a\u00020\u0015H\u00d6\u0001J\u0013\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0010\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u0011\u0010\u001bR\u001f\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0019\u001a\u0004\b\u0013\u0010\u001b\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/search/viewmodel/MiniAppSearchResult;", "", "", "toString", "", "component1", "component2", "", "component3", "component4", "", "Lcom/tencent/mobileqq/search/searchdetail/a;", "component5", "component6", "success", "keyword", "timestamp", "isNoResult", "resultData", "isEnd", "copy", "", "hashCode", "other", "equals", "Z", "getSuccess", "()Z", "Ljava/lang/String;", "getKeyword", "()Ljava/lang/String;", "J", "getTimestamp", "()J", "Ljava/util/List;", "getResultData", "()Ljava/util/List;", "<init>", "(ZLjava/lang/String;JZLjava/util/List;Z)V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final /* data */ class MiniAppSearchResult {
    private final boolean isEnd;
    private final boolean isNoResult;
    private final String keyword;
    private final List<a> resultData;
    private final boolean success;
    private final long timestamp;

    /* JADX WARN: Multi-variable type inference failed */
    public MiniAppSearchResult(boolean z16, String keyword, long j3, boolean z17, List<? extends a> list, boolean z18) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        this.success = z16;
        this.keyword = keyword;
        this.timestamp = j3;
        this.isNoResult = z17;
        this.resultData = list;
        this.isEnd = z18;
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component2, reason: from getter */
    public final String getKeyword() {
        return this.keyword;
    }

    /* renamed from: component3, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsNoResult() {
        return this.isNoResult;
    }

    public final List<a> component5() {
        return this.resultData;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsEnd() {
        return this.isEnd;
    }

    public final MiniAppSearchResult copy(boolean success, String keyword, long timestamp, boolean isNoResult, List<? extends a> resultData, boolean isEnd) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        return new MiniAppSearchResult(success, keyword, timestamp, isNoResult, resultData, isEnd);
    }

    public final String getKeyword() {
        return this.keyword;
    }

    public final List<a> getResultData() {
        return this.resultData;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    public int hashCode() {
        boolean z16 = this.success;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int hashCode = ((((r06 * 31) + this.keyword.hashCode()) * 31) + f.a(this.timestamp)) * 31;
        ?? r26 = this.isNoResult;
        int i3 = r26;
        if (r26 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode + i3) * 31;
        List<a> list = this.resultData;
        int hashCode2 = (i16 + (list == null ? 0 : list.hashCode())) * 31;
        boolean z17 = this.isEnd;
        return hashCode2 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public final boolean isEnd() {
        return this.isEnd;
    }

    public final boolean isNoResult() {
        return this.isNoResult;
    }

    public String toString() {
        boolean z16 = this.success;
        String str = this.keyword;
        long j3 = this.timestamp;
        boolean z17 = this.isNoResult;
        boolean z18 = this.isEnd;
        List<a> list = this.resultData;
        return "MiniAppSearchResult(success=" + z16 + ", keyword=" + str + ", timestamp=" + j3 + ", isNoResult=" + z17 + ", isEnd=" + z18 + ", resultData count=" + (list != null ? Integer.valueOf(list.size()) : null) + ")";
    }

    public static /* synthetic */ MiniAppSearchResult copy$default(MiniAppSearchResult miniAppSearchResult, boolean z16, String str, long j3, boolean z17, List list, boolean z18, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = miniAppSearchResult.success;
        }
        if ((i3 & 2) != 0) {
            str = miniAppSearchResult.keyword;
        }
        String str2 = str;
        if ((i3 & 4) != 0) {
            j3 = miniAppSearchResult.timestamp;
        }
        long j16 = j3;
        if ((i3 & 8) != 0) {
            z17 = miniAppSearchResult.isNoResult;
        }
        boolean z19 = z17;
        if ((i3 & 16) != 0) {
            list = miniAppSearchResult.resultData;
        }
        List list2 = list;
        if ((i3 & 32) != 0) {
            z18 = miniAppSearchResult.isEnd;
        }
        return miniAppSearchResult.copy(z16, str2, j16, z19, list2, z18);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MiniAppSearchResult)) {
            return false;
        }
        MiniAppSearchResult miniAppSearchResult = (MiniAppSearchResult) other;
        return this.success == miniAppSearchResult.success && Intrinsics.areEqual(this.keyword, miniAppSearchResult.keyword) && this.timestamp == miniAppSearchResult.timestamp && this.isNoResult == miniAppSearchResult.isNoResult && Intrinsics.areEqual(this.resultData, miniAppSearchResult.resultData) && this.isEnd == miniAppSearchResult.isEnd;
    }

    public /* synthetic */ MiniAppSearchResult(boolean z16, String str, long j3, boolean z17, List list, boolean z18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, str, j3, (i3 & 8) != 0 ? true : z17, (i3 & 16) != 0 ? null : list, (i3 & 32) != 0 ? false : z18);
    }
}
