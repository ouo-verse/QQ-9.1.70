package el0;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Lel0/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "eTag", "b", "c", "url", "fassetCachePath", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: el0.a, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class ETagInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String eTag;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String url;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String fassetCachePath;

    public ETagInfo(@NotNull String eTag, @NotNull String url, @NotNull String fassetCachePath) {
        Intrinsics.checkNotNullParameter(eTag, "eTag");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(fassetCachePath, "fassetCachePath");
        this.eTag = eTag;
        this.url = url;
        this.fassetCachePath = fassetCachePath;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getETag() {
        return this.eTag;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getFassetCachePath() {
        return this.fassetCachePath;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ETagInfo) {
                ETagInfo eTagInfo = (ETagInfo) other;
                if (!Intrinsics.areEqual(this.eTag, eTagInfo.eTag) || !Intrinsics.areEqual(this.url, eTagInfo.url) || !Intrinsics.areEqual(this.fassetCachePath, eTagInfo.fassetCachePath)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        int i16;
        String str = this.eTag;
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = i3 * 31;
        String str2 = this.url;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        String str3 = this.fassetCachePath;
        if (str3 != null) {
            i17 = str3.hashCode();
        }
        return i19 + i17;
    }

    @NotNull
    public String toString() {
        return "ETagInfo(eTag=" + this.eTag + ", url=" + this.url + ", fassetCachePath=" + this.fassetCachePath + ")";
    }
}
