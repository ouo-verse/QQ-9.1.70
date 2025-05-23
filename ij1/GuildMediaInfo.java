package ij1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR$\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lij1/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "mediaPath", "Lij1/l;", "b", "Lij1/l;", "()Lij1/l;", "c", "(Lij1/l;)V", "uploadResult", "<init>", "(Ljava/lang/String;Lij1/l;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ij1.k, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildMediaInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String mediaPath;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private l uploadResult;

    public GuildMediaInfo(@NotNull String mediaPath, @Nullable l lVar) {
        Intrinsics.checkNotNullParameter(mediaPath, "mediaPath");
        this.mediaPath = mediaPath;
        this.uploadResult = lVar;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getMediaPath() {
        return this.mediaPath;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final l getUploadResult() {
        return this.uploadResult;
    }

    public final void c(@Nullable l lVar) {
        this.uploadResult = lVar;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildMediaInfo)) {
            return false;
        }
        GuildMediaInfo guildMediaInfo = (GuildMediaInfo) other;
        if (Intrinsics.areEqual(this.mediaPath, guildMediaInfo.mediaPath) && Intrinsics.areEqual(this.uploadResult, guildMediaInfo.uploadResult)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.mediaPath.hashCode() * 31;
        l lVar = this.uploadResult;
        if (lVar == null) {
            hashCode = 0;
        } else {
            hashCode = lVar.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "GuildMediaInfo(mediaPath=" + this.mediaPath + ", uploadResult=" + this.uploadResult + ")";
    }
}
