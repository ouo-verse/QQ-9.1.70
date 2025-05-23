package ij1;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0016\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0011\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lij1/r;", "Lij1/l;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "videoId", "Lij1/j;", "b", "Lij1/j;", "getCoverResult", "()Lij1/j;", "(Lij1/j;)V", "coverResult", "<init>", "(Ljava/lang/String;Lij1/j;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ij1.r, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildVideoResult extends l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String videoId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private GuildImageResult coverResult;

    public GuildVideoResult() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getVideoId() {
        return this.videoId;
    }

    public final void b(@Nullable GuildImageResult guildImageResult) {
        this.coverResult = guildImageResult;
    }

    public final void c(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.videoId = str;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildVideoResult)) {
            return false;
        }
        GuildVideoResult guildVideoResult = (GuildVideoResult) other;
        if (Intrinsics.areEqual(this.videoId, guildVideoResult.videoId) && Intrinsics.areEqual(this.coverResult, guildVideoResult.coverResult)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.videoId.hashCode() * 31;
        GuildImageResult guildImageResult = this.coverResult;
        if (guildImageResult == null) {
            hashCode = 0;
        } else {
            hashCode = guildImageResult.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "GuildVideoResult(videoId=" + this.videoId + ", coverResult=" + this.coverResult + ")";
    }

    public /* synthetic */ GuildVideoResult(String str, GuildImageResult guildImageResult, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? null : guildImageResult);
    }

    public GuildVideoResult(@NotNull String videoId, @Nullable GuildImageResult guildImageResult) {
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        this.videoId = videoId;
        this.coverResult = guildImageResult;
    }
}
