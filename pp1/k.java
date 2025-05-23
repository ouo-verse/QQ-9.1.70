package pp1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\r\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\f\u0010\nR\u0017\u0010\u000f\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\b\u001a\u0004\b\u000e\u0010\nR\u0017\u0010\u0011\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u0010\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lpp1/k;", "Lpp1/g;", "other", "", "d", "c", "", "b", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "a", "channelId", "f", "title", "e", "roomId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class k extends g {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String channelId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String title;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String roomId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@NotNull String guildId, @NotNull String channelId, @NotNull String title, @NotNull String roomId) {
        super(channelId);
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        this.guildId = guildId;
        this.channelId = channelId;
        this.title = title;
        this.roomId = roomId;
    }

    @Override // pp1.g
    @NotNull
    /* renamed from: a, reason: from getter */
    public String getChannelId() {
        return this.channelId;
    }

    @Override // pp1.g
    @NotNull
    public String b() {
        return "VInactive " + getChannelId() + " " + this.title;
    }

    @Override // pp1.g
    public boolean c(@NotNull g other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if ((other instanceof k) && Intrinsics.areEqual(other, this)) {
            return true;
        }
        return false;
    }

    @Override // pp1.g
    public boolean d(@NotNull g other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if ((other instanceof k) && Intrinsics.areEqual(other.getChannelId(), getChannelId())) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getTitle() {
        return this.title;
    }
}
