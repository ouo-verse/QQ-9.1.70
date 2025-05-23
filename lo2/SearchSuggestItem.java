package lo2;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\tB\u001f\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0011\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Llo2/ao;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "title", "b", "I", "()I", "type", "c", "url", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "d", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: lo2.ao, reason: from toString */
/* loaded from: classes18.dex */
public final /* data */ class SearchSuggestItem {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String url;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Llo2/ao$a;", "", "Lorg/json/JSONObject;", "jsonObj", "Llo2/ao;", "a", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: lo2.ao$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final SearchSuggestItem a(@NotNull JSONObject jsonObj) {
            Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
            String title = jsonObj.optString("title");
            int optInt = jsonObj.optInt("type");
            String url = jsonObj.optString("url");
            Intrinsics.checkNotNullExpressionValue(title, "title");
            Intrinsics.checkNotNullExpressionValue(url, "url");
            return new SearchSuggestItem(title, optInt, url);
        }

        Companion() {
        }
    }

    public SearchSuggestItem(@NotNull String title, int i3, @NotNull String url) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(url, "url");
        this.title = title;
        this.type = i3;
        this.url = url;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: b, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchSuggestItem)) {
            return false;
        }
        SearchSuggestItem searchSuggestItem = (SearchSuggestItem) other;
        if (Intrinsics.areEqual(this.title, searchSuggestItem.title) && this.type == searchSuggestItem.type && Intrinsics.areEqual(this.url, searchSuggestItem.url)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.type) * 31) + this.url.hashCode();
    }

    @NotNull
    public String toString() {
        return "SearchSuggestItem(title=" + this.title + ", type=" + this.type + ", url=" + this.url + ")";
    }
}
