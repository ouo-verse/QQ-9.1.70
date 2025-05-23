package pn1;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001f\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lpn1/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/util/Collection;", "()Ljava/util/Collection;", "highlightKeywords", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "traceId", "<init>", "(Ljava/util/Collection;Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: pn1.b, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class SearchDataExt {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Collection<String> highlightKeywords;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String traceId;

    public SearchDataExt(@Nullable Collection<String> collection, @NotNull String traceId) {
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        this.highlightKeywords = collection;
        this.traceId = traceId;
    }

    @Nullable
    public final Collection<String> a() {
        return this.highlightKeywords;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchDataExt)) {
            return false;
        }
        SearchDataExt searchDataExt = (SearchDataExt) other;
        if (Intrinsics.areEqual(this.highlightKeywords, searchDataExt.highlightKeywords) && Intrinsics.areEqual(this.traceId, searchDataExt.traceId)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        Collection<String> collection = this.highlightKeywords;
        if (collection == null) {
            hashCode = 0;
        } else {
            hashCode = collection.hashCode();
        }
        return (hashCode * 31) + this.traceId.hashCode();
    }

    @NotNull
    public String toString() {
        return "SearchDataExt(highlightKeywords=" + this.highlightKeywords + ", traceId=" + this.traceId + ")";
    }
}
