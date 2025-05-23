package pa0;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lpa0/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "b", "getIconUrl", "iconUrl", "c", "getTag", "tag", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: pa0.b, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class PlusMenuNewerPendentGuideData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String iconUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tag;

    public PlusMenuNewerPendentGuideData(@NotNull String title, @NotNull String iconUrl, @NotNull String tag) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.title = title;
        this.iconUrl = iconUrl;
        this.tag = tag;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlusMenuNewerPendentGuideData)) {
            return false;
        }
        PlusMenuNewerPendentGuideData plusMenuNewerPendentGuideData = (PlusMenuNewerPendentGuideData) other;
        if (Intrinsics.areEqual(this.title, plusMenuNewerPendentGuideData.title) && Intrinsics.areEqual(this.iconUrl, plusMenuNewerPendentGuideData.iconUrl) && Intrinsics.areEqual(this.tag, plusMenuNewerPendentGuideData.tag)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.iconUrl.hashCode()) * 31) + this.tag.hashCode();
    }

    @NotNull
    public String toString() {
        return "PlusMenuNewerPendentGuideData(title=" + this.title + ", iconUrl=" + this.iconUrl + ", tag=" + this.tag + ")";
    }
}
