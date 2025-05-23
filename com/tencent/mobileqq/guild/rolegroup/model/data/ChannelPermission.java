package com.tencent.mobileqq.guild.rolegroup.model.data;

import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\n\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\nB'\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/data/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/util/List;", "()Ljava/util/List;", "approveSpeakChannels", "b", "approveVisibleChannels", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.rolegroup.model.data.a, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class ChannelPermission {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<String> approveSpeakChannels;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<String> approveVisibleChannels;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/data/a$a;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildRoleInfo;", "roleInfo", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/a;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.rolegroup.model.data.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ChannelPermission a(@NotNull IGProGuildRoleInfo roleInfo) {
            Intrinsics.checkNotNullParameter(roleInfo, "roleInfo");
            List approveSpeakChannels = roleInfo.getApproveSpeakChannels();
            if (approveSpeakChannels == null) {
                approveSpeakChannels = CollectionsKt__CollectionsKt.emptyList();
            }
            List approveVisibleChannels = roleInfo.getApproveVisibleChannels();
            if (approveVisibleChannels == null) {
                approveVisibleChannels = CollectionsKt__CollectionsKt.emptyList();
            }
            return new ChannelPermission(approveSpeakChannels, approveVisibleChannels);
        }

        Companion() {
        }
    }

    public ChannelPermission() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @NotNull
    public final List<String> a() {
        return this.approveSpeakChannels;
    }

    @NotNull
    public final List<String> b() {
        return this.approveVisibleChannels;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelPermission)) {
            return false;
        }
        ChannelPermission channelPermission = (ChannelPermission) other;
        if (Intrinsics.areEqual(this.approveSpeakChannels, channelPermission.approveSpeakChannels) && Intrinsics.areEqual(this.approveVisibleChannels, channelPermission.approveVisibleChannels)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.approveSpeakChannels.hashCode() * 31) + this.approveVisibleChannels.hashCode();
    }

    @NotNull
    public String toString() {
        return "ChannelPermission(approveSpeakChannels=" + this.approveSpeakChannels + ", approveVisibleChannels=" + this.approveVisibleChannels + ")";
    }

    public ChannelPermission(@NotNull List<String> approveSpeakChannels, @NotNull List<String> approveVisibleChannels) {
        Intrinsics.checkNotNullParameter(approveSpeakChannels, "approveSpeakChannels");
        Intrinsics.checkNotNullParameter(approveVisibleChannels, "approveVisibleChannels");
        this.approveSpeakChannels = approveSpeakChannels;
        this.approveVisibleChannels = approveVisibleChannels;
    }

    public /* synthetic */ ChannelPermission(List list, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2);
    }
}
