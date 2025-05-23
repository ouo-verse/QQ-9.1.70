package com.tencent.mobileqq.guild.jump.model.extras;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\b\u0087\b\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001,BC\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\u0004\b)\u0010*J\t\u0010\u0004\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\n\u001a\u00020\tH\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003JE\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\u0003H\u00c6\u0001J\t\u0010\u0013\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010\u0017\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0003H\u00d6\u0001R\u0017\u0010\f\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\r\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\r\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u000e\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010!\u001a\u0004\b$\u0010#R\u0017\u0010\u000f\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b%\u0010#R\u0017\u0010\u0010\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010&\u001a\u0004\b\u0010\u0010'R\u0017\u0010\u0011\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b(\u0010 \u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/jump/model/extras/JumpGuildNoticeMsg;", "Lcom/tencent/mobileqq/guild/jump/model/extras/AbsJumpExtra;", "Landroid/os/Parcelable;", "", "component1", "", "component2", "component3", "component4", "", "component5", "component6", "jumpType", "guildId", "channelId", "feedId", "isFromGuildHeaderBarBubble", "unreadCount", "copy", "toString", "hashCode", "", "other", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "I", "getJumpType", "()I", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "getChannelId", "getFeedId", "Z", "()Z", "getUnreadCount", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V", "Companion", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class JumpGuildNoticeMsg extends AbsJumpExtra implements Parcelable {
    public static final int JUMP_DEFAULT = 0;
    public static final int JUMP_FEED_LIST = 1;
    public static final int JUMP_GUILD_NOTICE = 2;

    @NotNull
    private final String channelId;

    @NotNull
    private final String feedId;

    @NotNull
    private final String guildId;
    private final boolean isFromGuildHeaderBarBubble;
    private final int jumpType;
    private final int unreadCount;

    @NotNull
    public static final Parcelable.Creator<JumpGuildNoticeMsg> CREATOR = new b();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class b implements Parcelable.Creator<JumpGuildNoticeMsg> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final JumpGuildNoticeMsg createFromParcel(@NotNull Parcel parcel) {
            boolean z16;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (parcel.readInt() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            return new JumpGuildNoticeMsg(readInt, readString, readString2, readString3, z16, parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final JumpGuildNoticeMsg[] newArray(int i3) {
            return new JumpGuildNoticeMsg[i3];
        }
    }

    public JumpGuildNoticeMsg() {
        this(0, null, null, null, false, 0, 63, null);
    }

    public static /* synthetic */ JumpGuildNoticeMsg copy$default(JumpGuildNoticeMsg jumpGuildNoticeMsg, int i3, String str, String str2, String str3, boolean z16, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = jumpGuildNoticeMsg.jumpType;
        }
        if ((i17 & 2) != 0) {
            str = jumpGuildNoticeMsg.guildId;
        }
        String str4 = str;
        if ((i17 & 4) != 0) {
            str2 = jumpGuildNoticeMsg.channelId;
        }
        String str5 = str2;
        if ((i17 & 8) != 0) {
            str3 = jumpGuildNoticeMsg.feedId;
        }
        String str6 = str3;
        if ((i17 & 16) != 0) {
            z16 = jumpGuildNoticeMsg.isFromGuildHeaderBarBubble;
        }
        boolean z17 = z16;
        if ((i17 & 32) != 0) {
            i16 = jumpGuildNoticeMsg.unreadCount;
        }
        return jumpGuildNoticeMsg.copy(i3, str4, str5, str6, z17, i16);
    }

    /* renamed from: component1, reason: from getter */
    public final int getJumpType() {
        return this.jumpType;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsFromGuildHeaderBarBubble() {
        return this.isFromGuildHeaderBarBubble;
    }

    /* renamed from: component6, reason: from getter */
    public final int getUnreadCount() {
        return this.unreadCount;
    }

    @NotNull
    public final JumpGuildNoticeMsg copy(int jumpType, @NotNull String guildId, @NotNull String channelId, @NotNull String feedId, boolean isFromGuildHeaderBarBubble, int unreadCount) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        return new JumpGuildNoticeMsg(jumpType, guildId, channelId, feedId, isFromGuildHeaderBarBubble, unreadCount);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JumpGuildNoticeMsg)) {
            return false;
        }
        JumpGuildNoticeMsg jumpGuildNoticeMsg = (JumpGuildNoticeMsg) other;
        if (this.jumpType == jumpGuildNoticeMsg.jumpType && Intrinsics.areEqual(this.guildId, jumpGuildNoticeMsg.guildId) && Intrinsics.areEqual(this.channelId, jumpGuildNoticeMsg.channelId) && Intrinsics.areEqual(this.feedId, jumpGuildNoticeMsg.feedId) && this.isFromGuildHeaderBarBubble == jumpGuildNoticeMsg.isFromGuildHeaderBarBubble && this.unreadCount == jumpGuildNoticeMsg.unreadCount) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    public final String getFeedId() {
        return this.feedId;
    }

    @NotNull
    public final String getGuildId() {
        return this.guildId;
    }

    public final int getJumpType() {
        return this.jumpType;
    }

    public final int getUnreadCount() {
        return this.unreadCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.jumpType * 31) + this.guildId.hashCode()) * 31) + this.channelId.hashCode()) * 31) + this.feedId.hashCode()) * 31;
        boolean z16 = this.isFromGuildHeaderBarBubble;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((hashCode + i3) * 31) + this.unreadCount;
    }

    public final boolean isFromGuildHeaderBarBubble() {
        return this.isFromGuildHeaderBarBubble;
    }

    @NotNull
    public String toString() {
        return "JumpGuildNoticeMsg(jumpType=" + this.jumpType + ", guildId=" + this.guildId + ", channelId=" + this.channelId + ", feedId=" + this.feedId + ", isFromGuildHeaderBarBubble=" + this.isFromGuildHeaderBarBubble + ", unreadCount=" + this.unreadCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.jumpType);
        parcel.writeString(this.guildId);
        parcel.writeString(this.channelId);
        parcel.writeString(this.feedId);
        parcel.writeInt(this.isFromGuildHeaderBarBubble ? 1 : 0);
        parcel.writeInt(this.unreadCount);
    }

    public /* synthetic */ JumpGuildNoticeMsg(int i3, String str, String str2, String str3, boolean z16, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? "" : str, (i17 & 4) != 0 ? "" : str2, (i17 & 8) == 0 ? str3 : "", (i17 & 16) != 0 ? false : z16, (i17 & 32) != 0 ? 0 : i16);
    }

    public JumpGuildNoticeMsg(int i3, @NotNull String guildId, @NotNull String channelId, @NotNull String feedId, boolean z16, int i16) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        this.jumpType = i3;
        this.guildId = guildId;
        this.channelId = channelId;
        this.feedId = feedId;
        this.isFromGuildHeaderBarBubble = z16;
        this.unreadCount = i16;
    }
}
