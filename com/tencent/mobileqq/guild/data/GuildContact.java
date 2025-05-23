package com.tencent.mobileqq.guild.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.ArrayMap;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0087\b\u0018\u0000 .2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001/BA\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b,\u0010-J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0004H\u00c6\u0003J\u0015\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003JG\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0001J\t\u0010\u0012\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\nH\u00d6\u0001J\u0019\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\nH\u00d6\u0001R\"\u0010\f\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010\r\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u001e\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\"\u0010\u000e\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\"\u0010\u000f\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R&\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\t8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010)\u001a\u0004\b*\u0010+\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/guild/data/GuildContact;", "Lcom/tencent/mobileqq/guild/data/q;", "Lcom/tencent/mobileqq/guild/data/IGuildParcelableContact;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "component4", "", "", "component5", "guildId", "channelId", "guildName", "channelName", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "copy", "toString", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "setGuildId", "(Ljava/lang/String;)V", "getChannelId", "setChannelId", "getGuildName", "setGuildName", "getChannelName", "setChannelName", "Ljava/util/Map;", "getTags", "()Ljava/util/Map;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "Companion", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class GuildContact implements q, IGuildParcelableContact, Serializable {

    @NotNull
    private String channelId;

    @NotNull
    private String channelName;

    @NotNull
    private String guildId;

    @NotNull
    private String guildName;

    @NotNull
    private final Map<String, Integer> tags;

    @NotNull
    public static final Parcelable.Creator<GuildContact> CREATOR = new b();

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final GuildContact f216393d = new GuildContact("", "", null, null, null, 28, null);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class b implements Parcelable.Creator<GuildContact> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final GuildContact createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            for (int i3 = 0; i3 != readInt; i3++) {
                linkedHashMap.put(parcel.readString(), Integer.valueOf(parcel.readInt()));
            }
            return new GuildContact(readString, readString2, readString3, readString4, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final GuildContact[] newArray(int i3) {
            return new GuildContact[i3];
        }
    }

    public GuildContact(@NotNull String guildId, @NotNull String channelId, @NotNull String guildName, @NotNull String channelName, @NotNull Map<String, Integer> tags) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(guildName, "guildName");
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.guildId = guildId;
        this.channelId = channelId;
        this.guildName = guildName;
        this.channelName = channelName;
        this.tags = tags;
    }

    public static /* synthetic */ GuildContact copy$default(GuildContact guildContact, String str, String str2, String str3, String str4, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = guildContact.getGuildId();
        }
        if ((i3 & 2) != 0) {
            str2 = guildContact.getChannelId();
        }
        String str5 = str2;
        if ((i3 & 4) != 0) {
            str3 = guildContact.getGuildName();
        }
        String str6 = str3;
        if ((i3 & 8) != 0) {
            str4 = guildContact.getChannelName();
        }
        String str7 = str4;
        if ((i3 & 16) != 0) {
            map = guildContact.getTags();
        }
        return guildContact.copy(str, str5, str6, str7, map);
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
    public final String component3() {
        return getGuildName();
    }

    @NotNull
    public final String component4() {
        return getChannelName();
    }

    @NotNull
    public final Map<String, Integer> component5() {
        return getTags();
    }

    @NotNull
    public final GuildContact copy(@NotNull String guildId, @NotNull String channelId, @NotNull String guildName, @NotNull String channelName, @NotNull Map<String, Integer> tags) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(guildName, "guildName");
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(tags, "tags");
        return new GuildContact(guildId, channelId, guildName, channelName, tags);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildContact)) {
            return false;
        }
        GuildContact guildContact = (GuildContact) other;
        if (Intrinsics.areEqual(getGuildId(), guildContact.getGuildId()) && Intrinsics.areEqual(getChannelId(), guildContact.getChannelId()) && Intrinsics.areEqual(getGuildName(), guildContact.getGuildName()) && Intrinsics.areEqual(getChannelName(), guildContact.getChannelName()) && Intrinsics.areEqual(getTags(), guildContact.getTags())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.data.s, com.tencent.mobileqq.guild.data.r
    @NotNull
    public String getChannelId() {
        return this.channelId;
    }

    @NotNull
    public String getChannelName() {
        return this.channelName;
    }

    @Override // com.tencent.mobileqq.guild.data.s, com.tencent.mobileqq.guild.data.r
    @NotNull
    public String getGuildId() {
        return this.guildId;
    }

    @NotNull
    public String getGuildName() {
        return this.guildName;
    }

    @Override // com.tencent.mobileqq.guild.data.q
    @NotNull
    public Map<String, Integer> getTags() {
        return this.tags;
    }

    public int hashCode() {
        return (((((((getGuildId().hashCode() * 31) + getChannelId().hashCode()) * 31) + getGuildName().hashCode()) * 31) + getChannelName().hashCode()) * 31) + getTags().hashCode();
    }

    @Override // com.tencent.mobileqq.guild.data.r
    public void setChannelId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.channelId = str;
    }

    @Override // com.tencent.mobileqq.guild.data.q
    public void setChannelName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.channelName = str;
    }

    @Override // com.tencent.mobileqq.guild.data.r
    public void setGuildId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.guildId = str;
    }

    public void setGuildName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.guildName = str;
    }

    @NotNull
    public String toString() {
        return "GuildContact(guildId=" + getGuildId() + ", channelId=" + getChannelId() + ", guildName=" + getGuildName() + ", channelName=" + getChannelName() + ", tags=" + getTags() + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.guildId);
        parcel.writeString(this.channelId);
        parcel.writeString(this.guildName);
        parcel.writeString(this.channelName);
        Map<String, Integer> map = this.tags;
        parcel.writeInt(map.size());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeInt(entry.getValue().intValue());
        }
    }

    public /* synthetic */ GuildContact(String str, String str2, String str3, String str4, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? new ArrayMap() : map);
    }
}
