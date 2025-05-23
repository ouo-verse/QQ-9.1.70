package d24;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Ld24/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ld24/i;", "extra", "Ld24/i;", "a", "()Ld24/i;", "imageUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "Ld24/d;", "mediaExtra", "Ld24/d;", "c", "()Ld24/d;", "e", "(Ld24/d;)V", "<init>", "(Ld24/i;Ljava/lang/String;Ld24/d;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: d24.b, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class AdelieAvatarInfo {

    @SerializedName("style")
    @NotNull
    private final GenerateRequestExtra extra;

    @SerializedName("imageUrl")
    @NotNull
    private String imageUrl;

    @SerializedName("mediaExtra")
    @NotNull
    private AdelieAvatarMediaExtra mediaExtra;

    public AdelieAvatarInfo() {
        this(null, null, null, 7, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final GenerateRequestExtra getExtra() {
        return this.extra;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final AdelieAvatarMediaExtra getMediaExtra() {
        return this.mediaExtra;
    }

    public final void d(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imageUrl = str;
    }

    public final void e(@NotNull AdelieAvatarMediaExtra adelieAvatarMediaExtra) {
        Intrinsics.checkNotNullParameter(adelieAvatarMediaExtra, "<set-?>");
        this.mediaExtra = adelieAvatarMediaExtra;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdelieAvatarInfo)) {
            return false;
        }
        AdelieAvatarInfo adelieAvatarInfo = (AdelieAvatarInfo) other;
        if (Intrinsics.areEqual(this.extra, adelieAvatarInfo.extra) && Intrinsics.areEqual(this.imageUrl, adelieAvatarInfo.imageUrl) && Intrinsics.areEqual(this.mediaExtra, adelieAvatarInfo.mediaExtra)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.extra.hashCode() * 31) + this.imageUrl.hashCode()) * 31) + this.mediaExtra.hashCode();
    }

    @NotNull
    public String toString() {
        return "AdelieAvatarInfo(extra=" + this.extra + ", imageUrl=" + this.imageUrl + ", mediaExtra=" + this.mediaExtra + ")";
    }

    public AdelieAvatarInfo(@NotNull GenerateRequestExtra extra, @NotNull String imageUrl, @NotNull AdelieAvatarMediaExtra mediaExtra) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(mediaExtra, "mediaExtra");
        this.extra = extra;
        this.imageUrl = imageUrl;
        this.mediaExtra = mediaExtra;
    }

    public /* synthetic */ AdelieAvatarInfo(GenerateRequestExtra generateRequestExtra, String str, AdelieAvatarMediaExtra adelieAvatarMediaExtra, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new GenerateRequestExtra(0, null, null, false, false, false, 63, null) : generateRequestExtra, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? new AdelieAvatarMediaExtra(null, 1, null) : adelieAvatarMediaExtra);
    }
}
