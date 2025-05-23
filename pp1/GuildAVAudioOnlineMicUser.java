package pp1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lpp1/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "tinyId", "avatarMeta", "c", "Z", "()Z", "isMicOpening", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: pp1.f, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildAVAudioOnlineMicUser {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tinyId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String avatarMeta;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isMicOpening;

    public GuildAVAudioOnlineMicUser(@NotNull String tinyId, @NotNull String avatarMeta, boolean z16) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(avatarMeta, "avatarMeta");
        this.tinyId = tinyId;
        this.avatarMeta = avatarMeta;
        this.isMicOpening = z16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAvatarMeta() {
        return this.avatarMeta;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getTinyId() {
        return this.tinyId;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsMicOpening() {
        return this.isMicOpening;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildAVAudioOnlineMicUser)) {
            return false;
        }
        GuildAVAudioOnlineMicUser guildAVAudioOnlineMicUser = (GuildAVAudioOnlineMicUser) other;
        if (Intrinsics.areEqual(this.tinyId, guildAVAudioOnlineMicUser.tinyId) && Intrinsics.areEqual(this.avatarMeta, guildAVAudioOnlineMicUser.avatarMeta) && this.isMicOpening == guildAVAudioOnlineMicUser.isMicOpening) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.tinyId.hashCode() * 31) + this.avatarMeta.hashCode()) * 31;
        boolean z16 = this.isMicOpening;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "GuildAVAudioOnlineMicUser(tinyId=" + this.tinyId + ", avatarMeta=" + this.avatarMeta + ", isMicOpening=" + this.isMicOpening + ")";
    }
}
