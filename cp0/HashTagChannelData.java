package cp0;

import com.tencent.mobileqq.guild.util.HashTagViewType;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u0012\u0006\u0010\u001e\u001a\u00020\u0006\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010(\u001a\u00020%\u0012\b\b\u0002\u0010.\u001a\u00020\u000b\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u00d6\u0003R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u0017\u0010\u001e\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001dR\u0017\u0010\"\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!R\u0017\u0010$\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010 \u001a\u0004\b#\u0010!R\u0017\u0010(\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010&\u001a\u0004\b\u0018\u0010'R\"\u0010.\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lcp0/d;", "Lcp0/a;", "", "i", "", "getItemId", "", "toString", "hashCode", "", "other", "", "equals", "Lcp0/g;", "b", "Lcp0/g;", tl.h.F, "()Lcp0/g;", "hashTagGroupType", "c", "J", "getGuildId", "()J", "guildId", "d", "g", "channelUin", "e", "Ljava/lang/String;", "()Ljava/lang/String;", "channelName", "f", "I", "()I", "channelType", "j", "subtypeId", "Lcom/tencent/mobileqq/guild/util/HashTagViewType;", "Lcom/tencent/mobileqq/guild/util/HashTagViewType;", "()Lcom/tencent/mobileqq/guild/util/HashTagViewType;", "aioHashViewType", "Z", "k", "()Z", "l", "(Z)V", "isSelect", "<init>", "(Lcp0/g;JJLjava/lang/String;IILcom/tencent/mobileqq/guild/util/HashTagViewType;Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: cp0.d, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class HashTagChannelData extends a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final HashTagGroupType hashTagGroupType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long guildId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long channelUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String channelName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int channelType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final int subtypeId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final HashTagViewType aioHashViewType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isSelect;

    public /* synthetic */ HashTagChannelData(HashTagGroupType hashTagGroupType, long j3, long j16, String str, int i3, int i16, HashTagViewType hashTagViewType, boolean z16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(hashTagGroupType, j3, j16, str, i3, i16, hashTagViewType, (i17 & 128) != 0 ? false : z16);
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final HashTagViewType getAioHashViewType() {
        return this.aioHashViewType;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HashTagChannelData)) {
            return false;
        }
        HashTagChannelData hashTagChannelData = (HashTagChannelData) other;
        if (Intrinsics.areEqual(this.hashTagGroupType, hashTagChannelData.hashTagGroupType) && this.guildId == hashTagChannelData.guildId && this.channelUin == hashTagChannelData.channelUin && Intrinsics.areEqual(this.channelName, hashTagChannelData.channelName) && this.channelType == hashTagChannelData.channelType && this.subtypeId == hashTagChannelData.subtypeId && this.aioHashViewType == hashTagChannelData.aioHashViewType && this.isSelect == hashTagChannelData.isSelect) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getChannelType() {
        return this.channelType;
    }

    /* renamed from: g, reason: from getter */
    public final long getChannelUin() {
        return this.channelUin;
    }

    @Override // cp0.k
    public long getItemId() {
        return Objects.hash(Integer.valueOf(i()), Long.valueOf(this.channelUin));
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final HashTagGroupType getHashTagGroupType() {
        return this.hashTagGroupType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((this.hashTagGroupType.hashCode() * 31) + androidx.fragment.app.a.a(this.guildId)) * 31) + androidx.fragment.app.a.a(this.channelUin)) * 31) + this.channelName.hashCode()) * 31) + this.channelType) * 31) + this.subtypeId) * 31) + this.aioHashViewType.hashCode()) * 31;
        boolean z16 = this.isSelect;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public int i() {
        return 6;
    }

    /* renamed from: j, reason: from getter */
    public final int getSubtypeId() {
        return this.subtypeId;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    public final void l(boolean z16) {
        this.isSelect = z16;
    }

    @NotNull
    public String toString() {
        return "HashTagChannelData(hashTagGroupType=" + this.hashTagGroupType + ", guildId=" + this.guildId + ", channelUin=" + this.channelUin + ", channelName=" + this.channelName + ", channelType=" + this.channelType + ", subtypeId=" + this.subtypeId + ", aioHashViewType=" + this.aioHashViewType + ", isSelect=" + this.isSelect + ")";
    }

    public HashTagChannelData(@NotNull HashTagGroupType hashTagGroupType, long j3, long j16, @NotNull String channelName, int i3, int i16, @NotNull HashTagViewType aioHashViewType, boolean z16) {
        Intrinsics.checkNotNullParameter(hashTagGroupType, "hashTagGroupType");
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(aioHashViewType, "aioHashViewType");
        this.hashTagGroupType = hashTagGroupType;
        this.guildId = j3;
        this.channelUin = j16;
        this.channelName = channelName;
        this.channelType = i3;
        this.subtypeId = i16;
        this.aioHashViewType = aioHashViewType;
        this.isSelect = z16;
    }
}
