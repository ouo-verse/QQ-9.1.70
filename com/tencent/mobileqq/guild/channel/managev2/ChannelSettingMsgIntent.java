package com.tencent.mobileqq.guild.channel.managev2;

import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "ChannelInfoChange", "PermissionChange", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public class ChannelSettingMsgIntent implements MsgIntent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingMsgIntent$ChannelInfoChange;", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "d", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "getChannelInfo", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final /* data */ class ChannelInfoChange extends ChannelSettingMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final IGProChannelInfo channelInfo;

        public ChannelInfoChange(@NotNull IGProChannelInfo channelInfo) {
            Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
            this.channelInfo = channelInfo;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof ChannelInfoChange) && Intrinsics.areEqual(this.channelInfo, ((ChannelInfoChange) other).channelInfo)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.channelInfo.hashCode();
        }

        @NotNull
        public String toString() {
            return "ChannelInfoChange(channelInfo=" + this.channelInfo + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingMsgIntent$PermissionChange;", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/qqguildsdk/data/dx;", "d", "Lcom/tencent/mobileqq/qqguildsdk/data/dx;", "a", "()Lcom/tencent/mobileqq/qqguildsdk/data/dx;", "permissionInfo", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/dx;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final /* data */ class PermissionChange extends ChannelSettingMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final dx permissionInfo;

        public PermissionChange(@NotNull dx permissionInfo) {
            Intrinsics.checkNotNullParameter(permissionInfo, "permissionInfo");
            this.permissionInfo = permissionInfo;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final dx getPermissionInfo() {
            return this.permissionInfo;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof PermissionChange) && Intrinsics.areEqual(this.permissionInfo, ((PermissionChange) other).permissionInfo)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.permissionInfo.hashCode();
        }

        @NotNull
        public String toString() {
            return "PermissionChange(permissionInfo=" + this.permissionInfo + ")";
        }
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }
}
