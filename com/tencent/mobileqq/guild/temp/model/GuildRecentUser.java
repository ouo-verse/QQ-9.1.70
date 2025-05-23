package com.tencent.mobileqq.guild.temp.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.a;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u0000 *2\u00020\u0001:\u0001\u001dB;\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001e\u001a\u00020\t\u0012\b\b\u0002\u0010!\u001a\u00020\u0004\u0012\u0006\u0010&\u001a\u00020\"\u00a2\u0006\u0004\b'\u0010(B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b'\u0010)J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0014\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u0013R\u0017\u0010!\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0018\u001a\u0004\b \u0010\u001aR\u0017\u0010&\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b\u0015\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/model/GuildRecentUser;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "uin", "e", "c", "name", "I", "getType", "()I", "type", h.F, "a", "guildId", "i", "b", "headType", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "()J", "time", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IJ)V", "(Landroid/os/Parcel;)V", "CREATOR", "qqguild-df-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final /* data */ class GuildRecentUser implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String uin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String name;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final int headType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private final long time;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/model/GuildRecentUser$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/guild/temp/model/GuildRecentUser;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/guild/temp/model/GuildRecentUser;", "<init>", "()V", "qqguild-df-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.temp.model.GuildRecentUser$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion implements Parcelable.Creator<GuildRecentUser> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GuildRecentUser createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GuildRecentUser(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuildRecentUser[] newArray(int size) {
            return new GuildRecentUser[size];
        }

        Companion() {
        }
    }

    public GuildRecentUser(@NotNull String uin, @NotNull String name, int i3, @NotNull String guildId, int i16, long j3) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.uin = uin;
        this.name = name;
        this.type = i3;
        this.guildId = guildId;
        this.headType = i16;
        this.time = j3;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    /* renamed from: b, reason: from getter */
    public final int getHeadType() {
        return this.headType;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRecentUser)) {
            return false;
        }
        GuildRecentUser guildRecentUser = (GuildRecentUser) other;
        if (Intrinsics.areEqual(this.uin, guildRecentUser.uin) && Intrinsics.areEqual(this.name, guildRecentUser.name) && this.type == guildRecentUser.type && Intrinsics.areEqual(this.guildId, guildRecentUser.guildId) && this.headType == guildRecentUser.headType && this.time == guildRecentUser.time) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((((this.uin.hashCode() * 31) + this.name.hashCode()) * 31) + this.type) * 31) + this.guildId.hashCode()) * 31) + this.headType) * 31) + a.a(this.time);
    }

    @NotNull
    public String toString() {
        return "GuildRecentUser(uin=" + this.uin + ", name=" + this.name + ", type=" + this.type + ", guildId=" + this.guildId + ", headType=" + this.headType + ", time=" + this.time + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.uin);
        parcel.writeString(this.name);
        parcel.writeInt(this.type);
        parcel.writeString(this.guildId);
        parcel.writeInt(this.headType);
        parcel.writeLong(this.time);
    }

    public /* synthetic */ GuildRecentUser(String str, String str2, int i3, String str3, int i16, long j3, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i3, (i17 & 8) != 0 ? "" : str3, (i17 & 16) != 0 ? -1 : i16, j3);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GuildRecentUser(@NotNull Parcel parcel) {
        this(r2, r3, r4, r5, parcel.readInt(), parcel.readLong());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        Intrinsics.checkNotNull(readString);
        String readString2 = parcel.readString();
        Intrinsics.checkNotNull(readString2);
        int readInt = parcel.readInt();
        String readString3 = parcel.readString();
        Intrinsics.checkNotNull(readString3);
    }
}
