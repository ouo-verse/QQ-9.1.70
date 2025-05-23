package pp1;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0010\u001f\u001a\u00020\t\u0012\u0006\u0010\"\u001a\u00020\t\u0012\u0006\u0010#\u001a\u00020\t\u0012\u0006\u0010%\u001a\u00020\u0006\u0012\u0006\u0010&\u001a\u00020\t\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\b\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u000bH\u00d6\u0003R\u001a\u0010\u0010\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001f\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\"\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u001eR\u0017\u0010#\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b \u0010\u001eR\u0017\u0010%\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b$\u0010\u000fR\u0017\u0010&\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001c\u001a\u0004\b\u0017\u0010\u001e\u00a8\u0006)"}, d2 = {"Lpp1/c;", "Lpp1/g;", "other", "", "d", "c", "", "b", "toString", "", "hashCode", "", "equals", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "channelId", "f", "guildId", "l", "title", "", "Lpp1/f;", "e", "Ljava/util/List;", "i", "()Ljava/util/List;", "micUserList", "I", "j", "()I", "noMemberMaxLimit", "g", tl.h.F, "memberMax", "memberCount", "k", "sessionId", "cardType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;IIILjava/lang/String;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: pp1.c, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildAVAudioActiveNormalUIData extends g {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<GuildAVAudioOnlineMicUser> micUserList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int noMemberMaxLimit;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final int memberMax;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final int memberCount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String sessionId;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final int cardType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildAVAudioActiveNormalUIData(@NotNull String channelId, @NotNull String guildId, @NotNull String title, @NotNull List<GuildAVAudioOnlineMicUser> micUserList, int i3, int i16, int i17, @NotNull String sessionId, int i18) {
        super(channelId);
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(micUserList, "micUserList");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.channelId = channelId;
        this.guildId = guildId;
        this.title = title;
        this.micUserList = micUserList;
        this.noMemberMaxLimit = i3;
        this.memberMax = i16;
        this.memberCount = i17;
        this.sessionId = sessionId;
        this.cardType = i18;
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
        return "ANormal " + getChannelId() + " " + this.title;
    }

    @Override // pp1.g
    public boolean c(@NotNull g other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if ((other instanceof GuildAVAudioActiveNormalUIData) && Intrinsics.areEqual(other, this)) {
            return true;
        }
        return false;
    }

    @Override // pp1.g
    public boolean d(@NotNull g other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if ((other instanceof GuildAVAudioActiveNormalUIData) && Intrinsics.areEqual(other.getChannelId(), getChannelId())) {
            return true;
        }
        return false;
    }

    /* renamed from: e, reason: from getter */
    public final int getCardType() {
        return this.cardType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildAVAudioActiveNormalUIData)) {
            return false;
        }
        GuildAVAudioActiveNormalUIData guildAVAudioActiveNormalUIData = (GuildAVAudioActiveNormalUIData) other;
        if (Intrinsics.areEqual(getChannelId(), guildAVAudioActiveNormalUIData.getChannelId()) && Intrinsics.areEqual(this.guildId, guildAVAudioActiveNormalUIData.guildId) && Intrinsics.areEqual(this.title, guildAVAudioActiveNormalUIData.title) && Intrinsics.areEqual(this.micUserList, guildAVAudioActiveNormalUIData.micUserList) && this.noMemberMaxLimit == guildAVAudioActiveNormalUIData.noMemberMaxLimit && this.memberMax == guildAVAudioActiveNormalUIData.memberMax && this.memberCount == guildAVAudioActiveNormalUIData.memberCount && Intrinsics.areEqual(this.sessionId, guildAVAudioActiveNormalUIData.sessionId) && this.cardType == guildAVAudioActiveNormalUIData.cardType) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    /* renamed from: g, reason: from getter */
    public final int getMemberCount() {
        return this.memberCount;
    }

    /* renamed from: h, reason: from getter */
    public final int getMemberMax() {
        return this.memberMax;
    }

    public int hashCode() {
        return (((((((((((((((getChannelId().hashCode() * 31) + this.guildId.hashCode()) * 31) + this.title.hashCode()) * 31) + this.micUserList.hashCode()) * 31) + this.noMemberMaxLimit) * 31) + this.memberMax) * 31) + this.memberCount) * 31) + this.sessionId.hashCode()) * 31) + this.cardType;
    }

    @NotNull
    public final List<GuildAVAudioOnlineMicUser> i() {
        return this.micUserList;
    }

    /* renamed from: j, reason: from getter */
    public final int getNoMemberMaxLimit() {
        return this.noMemberMaxLimit;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public String toString() {
        return "GuildAVAudioActiveNormalUIData(channelId=" + getChannelId() + ", guildId=" + this.guildId + ", title=" + this.title + ", micUserList=" + this.micUserList + ", noMemberMaxLimit=" + this.noMemberMaxLimit + ", memberMax=" + this.memberMax + ", memberCount=" + this.memberCount + ", sessionId=" + this.sessionId + ", cardType=" + this.cardType + ")";
    }
}
