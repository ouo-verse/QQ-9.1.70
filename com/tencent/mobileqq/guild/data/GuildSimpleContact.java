package com.tencent.mobileqq.guild.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.gcore.abase.utils.PatternUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0087\b\u0018\u0000  2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001!B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0004H\u00c6\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u000bH\u00d6\u0001J\u0019\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000bH\u00d6\u0001R\"\u0010\u0007\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\b\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/data/GuildSimpleContact;", "Lcom/tencent/mobileqq/guild/data/r;", "Lcom/tencent/mobileqq/guild/data/IGuildParcelizeSimpleContact;", "Ljava/io/Serializable;", "", "component1", "component2", "guildId", "channelId", "copy", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "setGuildId", "(Ljava/lang/String;)V", "getChannelId", "setChannelId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class GuildSimpleContact implements r, IGuildParcelizeSimpleContact, Serializable {

    @NotNull
    private String channelId;

    @NotNull
    private String guildId;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<GuildSimpleContact> CREATOR = new b();

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final GuildSimpleContact f216403d = new GuildSimpleContact("", "");

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/data/GuildSimpleContact$a;", "", "Lcom/tencent/mobileqq/guild/data/GuildSimpleContact;", PatternUtils.NO_MATCH, "Lcom/tencent/mobileqq/guild/data/GuildSimpleContact;", "a", "()Lcom/tencent/mobileqq/guild/data/GuildSimpleContact;", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.data.GuildSimpleContact$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GuildSimpleContact a() {
            return GuildSimpleContact.f216403d;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class b implements Parcelable.Creator<GuildSimpleContact> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final GuildSimpleContact createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GuildSimpleContact(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final GuildSimpleContact[] newArray(int i3) {
            return new GuildSimpleContact[i3];
        }
    }

    public GuildSimpleContact(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.guildId = guildId;
        this.channelId = channelId;
    }

    public static /* synthetic */ GuildSimpleContact copy$default(GuildSimpleContact guildSimpleContact, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = guildSimpleContact.getGuildId();
        }
        if ((i3 & 2) != 0) {
            str2 = guildSimpleContact.getChannelId();
        }
        return guildSimpleContact.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return getGuildId();
    }

    @NotNull
    public final String component2() {
        return getChannelId();
    }

    @NotNull
    public final GuildSimpleContact copy(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        return new GuildSimpleContact(guildId, channelId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildSimpleContact)) {
            return false;
        }
        GuildSimpleContact guildSimpleContact = (GuildSimpleContact) other;
        if (Intrinsics.areEqual(getGuildId(), guildSimpleContact.getGuildId()) && Intrinsics.areEqual(getChannelId(), guildSimpleContact.getChannelId())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.data.r
    @NotNull
    public String getChannelId() {
        return this.channelId;
    }

    @Override // com.tencent.mobileqq.guild.data.r
    @NotNull
    public String getGuildId() {
        return this.guildId;
    }

    public int hashCode() {
        return (getGuildId().hashCode() * 31) + getChannelId().hashCode();
    }

    @Override // com.tencent.mobileqq.guild.data.r
    public void setChannelId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.channelId = str;
    }

    @Override // com.tencent.mobileqq.guild.data.r
    public void setGuildId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.guildId = str;
    }

    @NotNull
    public String toString() {
        return "GuildSimpleContact(guildId=" + getGuildId() + ", channelId=" + getChannelId() + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.guildId);
        parcel.writeString(this.channelId);
    }
}
