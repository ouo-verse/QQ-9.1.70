package com.tencent.troopguild.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.GroupGuildNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GuildGroupOptType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0011J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/troopguild/api/ITroopGuildMsgApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getTroopGuildPushMsgIntent", "Landroid/content/Intent;", "ctx", "Landroid/content/Context;", "msg", "Lcom/tencent/imcore/message/Message;", "isTroopGuildPushMsg", "", "saveTroopGuildPushMsgInfo", "", "notifyInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupGuildNotifyInfo;", "setPushPlace", "pushType", "", "MsgPushInfo", "troop-guild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes7.dex */
public interface ITroopGuildMsgApi extends QRouteApi {
    @NotNull
    Intent getTroopGuildPushMsgIntent(@NotNull Context ctx, @NotNull Message msg2);

    boolean isTroopGuildPushMsg(@NotNull Message msg2);

    void saveTroopGuildPushMsgInfo(@NotNull Message msg2, @NotNull GroupGuildNotifyInfo notifyInfo);

    void setPushPlace(@NotNull Message msg2, int pushType);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0007H\u00c6\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u00d6\u0003J\t\u0010\"\u001a\u00020\u0007H\u00d6\u0001J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015\u00a8\u0006$"}, d2 = {"Lcom/tencent/troopguild/api/ITroopGuildMsgApi$MsgPushInfo;", "Ljava/io/Serializable;", "groupId", "", "guildId", "channelId", "pushType", "", "pushPlace", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getChannelId", "()Ljava/lang/String;", "setChannelId", "(Ljava/lang/String;)V", "getGroupId", "setGroupId", "getGuildId", "setGuildId", "getPushPlace", "()I", "setPushPlace", "(I)V", "getPushType", "setPushType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "troop-guild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final /* data */ class MsgPushInfo implements Serializable {

        @NotNull
        private String channelId;

        @NotNull
        private String groupId;

        @NotNull
        private String guildId;
        private int pushPlace;
        private int pushType;

        public MsgPushInfo(@NotNull String groupId, @NotNull String guildId, @NotNull String channelId, int i3, int i16) {
            Intrinsics.checkNotNullParameter(groupId, "groupId");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            this.groupId = groupId;
            this.guildId = guildId;
            this.channelId = channelId;
            this.pushType = i3;
            this.pushPlace = i16;
        }

        public static /* synthetic */ MsgPushInfo copy$default(MsgPushInfo msgPushInfo, String str, String str2, String str3, int i3, int i16, int i17, Object obj) {
            if ((i17 & 1) != 0) {
                str = msgPushInfo.groupId;
            }
            if ((i17 & 2) != 0) {
                str2 = msgPushInfo.guildId;
            }
            String str4 = str2;
            if ((i17 & 4) != 0) {
                str3 = msgPushInfo.channelId;
            }
            String str5 = str3;
            if ((i17 & 8) != 0) {
                i3 = msgPushInfo.pushType;
            }
            int i18 = i3;
            if ((i17 & 16) != 0) {
                i16 = msgPushInfo.pushPlace;
            }
            return msgPushInfo.copy(str, str4, str5, i18, i16);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getGroupId() {
            return this.groupId;
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

        /* renamed from: component4, reason: from getter */
        public final int getPushType() {
            return this.pushType;
        }

        /* renamed from: component5, reason: from getter */
        public final int getPushPlace() {
            return this.pushPlace;
        }

        @NotNull
        public final MsgPushInfo copy(@NotNull String groupId, @NotNull String guildId, @NotNull String channelId, int pushType, int pushPlace) {
            Intrinsics.checkNotNullParameter(groupId, "groupId");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            return new MsgPushInfo(groupId, guildId, channelId, pushType, pushPlace);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MsgPushInfo)) {
                return false;
            }
            MsgPushInfo msgPushInfo = (MsgPushInfo) other;
            if (Intrinsics.areEqual(this.groupId, msgPushInfo.groupId) && Intrinsics.areEqual(this.guildId, msgPushInfo.guildId) && Intrinsics.areEqual(this.channelId, msgPushInfo.channelId) && this.pushType == msgPushInfo.pushType && this.pushPlace == msgPushInfo.pushPlace) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        public final String getGroupId() {
            return this.groupId;
        }

        @NotNull
        public final String getGuildId() {
            return this.guildId;
        }

        public final int getPushPlace() {
            return this.pushPlace;
        }

        public final int getPushType() {
            return this.pushType;
        }

        public int hashCode() {
            return (((((((this.groupId.hashCode() * 31) + this.guildId.hashCode()) * 31) + this.channelId.hashCode()) * 31) + this.pushType) * 31) + this.pushPlace;
        }

        public final void setChannelId(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.channelId = str;
        }

        public final void setGroupId(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.groupId = str;
        }

        public final void setGuildId(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.guildId = str;
        }

        public final void setPushPlace(int i3) {
            this.pushPlace = i3;
        }

        public final void setPushType(int i3) {
            this.pushType = i3;
        }

        @NotNull
        public String toString() {
            return "MsgPushInfo(groupId=" + this.groupId + ", guildId=" + this.guildId + ", channelId=" + this.channelId + ", pushType=" + this.pushType + ", pushPlace=" + this.pushPlace + ")";
        }

        public /* synthetic */ MsgPushInfo(String str, String str2, String str3, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, (i17 & 8) != 0 ? GuildGroupOptType.KUNKNOWN.ordinal() : i3, (i17 & 16) != 0 ? 0 : i16);
        }
    }
}
