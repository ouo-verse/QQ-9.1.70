package e40;

import feedcloud.FeedCloudRead$Advice;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Le40/r;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lfeedcloud/FeedCloudRead$Advice;", "a", "Ljava/util/List;", "()Ljava/util/List;", "adviceList", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "moreDataUrl", "c", "moreDataWord", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: e40.r, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class QFSWorkSuggestionsData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<FeedCloudRead$Advice> adviceList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String moreDataUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String moreDataWord;

    public QFSWorkSuggestionsData(@NotNull List<FeedCloudRead$Advice> adviceList, @NotNull String moreDataUrl, @NotNull String moreDataWord) {
        Intrinsics.checkNotNullParameter(adviceList, "adviceList");
        Intrinsics.checkNotNullParameter(moreDataUrl, "moreDataUrl");
        Intrinsics.checkNotNullParameter(moreDataWord, "moreDataWord");
        this.adviceList = adviceList;
        this.moreDataUrl = moreDataUrl;
        this.moreDataWord = moreDataWord;
    }

    @NotNull
    public final List<FeedCloudRead$Advice> a() {
        return this.adviceList;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getMoreDataUrl() {
        return this.moreDataUrl;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getMoreDataWord() {
        return this.moreDataWord;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QFSWorkSuggestionsData)) {
            return false;
        }
        QFSWorkSuggestionsData qFSWorkSuggestionsData = (QFSWorkSuggestionsData) other;
        if (Intrinsics.areEqual(this.adviceList, qFSWorkSuggestionsData.adviceList) && Intrinsics.areEqual(this.moreDataUrl, qFSWorkSuggestionsData.moreDataUrl) && Intrinsics.areEqual(this.moreDataWord, qFSWorkSuggestionsData.moreDataWord)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.adviceList.hashCode() * 31) + this.moreDataUrl.hashCode()) * 31) + this.moreDataWord.hashCode();
    }

    @NotNull
    public String toString() {
        return "QFSWorkSuggestionsData(adviceList=" + this.adviceList + ", moreDataUrl=" + this.moreDataUrl + ", moreDataWord=" + this.moreDataWord + ")";
    }
}
