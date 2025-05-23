package com.tencent.now.linkpkanchorplay.search.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/search/model/SearchHistoryData;", "Ljava/io/Serializable;", "searchWord", "", "time", "", "spanSize", "", "(Ljava/lang/String;JI)V", "getSearchWord", "()Ljava/lang/String;", "getSpanSize", "()I", "getTime", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes22.dex */
public final /* data */ class SearchHistoryData implements Serializable {

    @NotNull
    private final String searchWord;
    private final int spanSize;
    private final long time;

    public SearchHistoryData(@NotNull String searchWord, long j3, int i3) {
        Intrinsics.checkNotNullParameter(searchWord, "searchWord");
        this.searchWord = searchWord;
        this.time = j3;
        this.spanSize = i3;
    }

    public static /* synthetic */ SearchHistoryData copy$default(SearchHistoryData searchHistoryData, String str, long j3, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = searchHistoryData.searchWord;
        }
        if ((i16 & 2) != 0) {
            j3 = searchHistoryData.time;
        }
        if ((i16 & 4) != 0) {
            i3 = searchHistoryData.spanSize;
        }
        return searchHistoryData.copy(str, j3, i3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getSearchWord() {
        return this.searchWord;
    }

    /* renamed from: component2, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    /* renamed from: component3, reason: from getter */
    public final int getSpanSize() {
        return this.spanSize;
    }

    @NotNull
    public final SearchHistoryData copy(@NotNull String searchWord, long time, int spanSize) {
        Intrinsics.checkNotNullParameter(searchWord, "searchWord");
        return new SearchHistoryData(searchWord, time, spanSize);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchHistoryData)) {
            return false;
        }
        SearchHistoryData searchHistoryData = (SearchHistoryData) other;
        if (Intrinsics.areEqual(this.searchWord, searchHistoryData.searchWord) && this.time == searchHistoryData.time && this.spanSize == searchHistoryData.spanSize) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getSearchWord() {
        return this.searchWord;
    }

    public final int getSpanSize() {
        return this.spanSize;
    }

    public final long getTime() {
        return this.time;
    }

    public int hashCode() {
        return (((this.searchWord.hashCode() * 31) + androidx.fragment.app.a.a(this.time)) * 31) + this.spanSize;
    }

    @NotNull
    public String toString() {
        return "SearchHistoryData(searchWord=" + this.searchWord + ", time=" + this.time + ", spanSize=" + this.spanSize + ')';
    }
}
