package com.tencent.mobileqq.guild.main.announcement.detail;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 52\u00020\u0001:\u0001\u0012BA\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\u0006\u0010 \u001a\u00020\u0018\u0012\u0006\u0010&\u001a\u00020!\u0012\b\u0010,\u001a\u0004\u0018\u00010'\u0012\u0006\u00102\u001a\u00020-\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0014\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010 \u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\u0017\u0010&\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010,\u001a\u0004\u0018\u00010'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0017\u00102\u001a\u00020-8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\u00a8\u00066"}, d2 = {"com/tencent/mobileqq/guild/main/announcement/detail/AnnouncementDetailFragment$Param", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "dest", WadlProxyConsts.FLAGS, "", "writeToParcel", "", "toString", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "guildId", "e", "a", "channelId", "", "f", "J", "c", "()J", "messageSeq", h.F, "getMessageTime", "messageTime", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "i", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "getFacadeType", "()Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "facadeType", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "getJoinInfoParam", "()Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "joinInfoParam", "Landroid/os/Bundle;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/os/Bundle;", "getExtra", "()Landroid/os/Bundle;", "extra", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJLcom/tencent/mobileqq/guild/constant/GuildFacadeType;Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;Landroid/os/Bundle;)V", "D", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.main.announcement.detail.AnnouncementDetailFragment$Param, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class Param implements Parcelable {

    /* renamed from: C, reason: from kotlin metadata and from toString */
    @NotNull
    private final Bundle extra;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String channelId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final long messageSeq;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final long messageTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final GuildFacadeType facadeType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final JumpGuildParam.JoinInfoParam joinInfoParam;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<Param> CREATOR = new a();

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/main/announcement/detail/AnnouncementDetailFragment$Param$a", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/guild/main/announcement/detail/AnnouncementDetailFragment$Param;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/guild/main/announcement/detail/AnnouncementDetailFragment$Param;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.main.announcement.detail.AnnouncementDetailFragment$Param$a */
    /* loaded from: classes14.dex */
    public static final class a implements Parcelable.Creator<Param> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Param createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            Intrinsics.checkNotNull(readString);
            String readString2 = parcel.readString();
            Intrinsics.checkNotNull(readString2);
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            Serializable readSerializable = parcel.readSerializable();
            Intrinsics.checkNotNull(readSerializable, "null cannot be cast to non-null type com.tencent.mobileqq.guild.constant.GuildFacadeType");
            GuildFacadeType guildFacadeType = (GuildFacadeType) readSerializable;
            JumpGuildParam.JoinInfoParam joinInfoParam = (JumpGuildParam.JoinInfoParam) parcel.readParcelable(JumpGuildParam.JoinInfoParam.class.getClassLoader());
            Bundle readBundle = parcel.readBundle(Param.class.getClassLoader());
            Intrinsics.checkNotNull(readBundle);
            return new Param(readString, readString2, readLong, readLong2, guildFacadeType, joinInfoParam, readBundle);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Param[] newArray(int size) {
            return new Param[size];
        }
    }

    public Param(@NotNull String guildId, @NotNull String channelId, long j3, long j16, @NotNull GuildFacadeType facadeType, @Nullable JumpGuildParam.JoinInfoParam joinInfoParam, @NotNull Bundle extra) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(facadeType, "facadeType");
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.guildId = guildId;
        this.channelId = channelId;
        this.messageSeq = j3;
        this.messageTime = j16;
        this.facadeType = facadeType;
        this.joinInfoParam = joinInfoParam;
        this.extra = extra;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    /* renamed from: c, reason: from getter */
    public final long getMessageSeq() {
        return this.messageSeq;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Param)) {
            return false;
        }
        Param param = (Param) other;
        if (Intrinsics.areEqual(this.guildId, param.guildId) && Intrinsics.areEqual(this.channelId, param.channelId) && this.messageSeq == param.messageSeq && this.messageTime == param.messageTime && this.facadeType == param.facadeType && Intrinsics.areEqual(this.joinInfoParam, param.joinInfoParam) && Intrinsics.areEqual(this.extra, param.extra)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((((this.guildId.hashCode() * 31) + this.channelId.hashCode()) * 31) + androidx.fragment.app.a.a(this.messageSeq)) * 31) + androidx.fragment.app.a.a(this.messageTime)) * 31) + this.facadeType.hashCode()) * 31;
        JumpGuildParam.JoinInfoParam joinInfoParam = this.joinInfoParam;
        if (joinInfoParam == null) {
            hashCode = 0;
        } else {
            hashCode = joinInfoParam.hashCode();
        }
        return ((hashCode2 + hashCode) * 31) + this.extra.hashCode();
    }

    @NotNull
    public String toString() {
        return "Param(guildId=" + this.guildId + ", channelId=" + this.channelId + ", messageSeq=" + this.messageSeq + ", messageTime=" + this.messageTime + ", facadeType=" + this.facadeType + ", joinInfoParam=" + this.joinInfoParam + ", extra=" + this.extra + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.guildId);
        dest.writeString(this.channelId);
        dest.writeLong(this.messageSeq);
        dest.writeLong(this.messageTime);
        dest.writeSerializable(this.facadeType);
        dest.writeParcelable(this.joinInfoParam, 0);
        dest.writeBundle(this.extra);
    }
}
