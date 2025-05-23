package com.tencent.state.square.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/state/square/data/AvatarAction;", "", "lookFront", "Lcom/tencent/state/square/data/Resource;", "unread", "feedsNew", "battery", "(Lcom/tencent/state/square/data/Resource;Lcom/tencent/state/square/data/Resource;Lcom/tencent/state/square/data/Resource;Lcom/tencent/state/square/data/Resource;)V", "getBattery", "()Lcom/tencent/state/square/data/Resource;", "setBattery", "(Lcom/tencent/state/square/data/Resource;)V", "getFeedsNew", "setFeedsNew", "getLookFront", "setLookFront", "getUnread", "setUnread", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final /* data */ class AvatarAction {

    @NotNull
    private Resource battery;

    @NotNull
    private Resource feedsNew;

    @NotNull
    private Resource lookFront;

    @NotNull
    private Resource unread;

    public AvatarAction(@NotNull Resource lookFront, @NotNull Resource unread, @NotNull Resource feedsNew, @NotNull Resource battery) {
        Intrinsics.checkNotNullParameter(lookFront, "lookFront");
        Intrinsics.checkNotNullParameter(unread, "unread");
        Intrinsics.checkNotNullParameter(feedsNew, "feedsNew");
        Intrinsics.checkNotNullParameter(battery, "battery");
        this.lookFront = lookFront;
        this.unread = unread;
        this.feedsNew = feedsNew;
        this.battery = battery;
        lookFront.setAction(this);
        Resource resource = this.lookFront;
        resource.setRelated(resource);
    }

    public static /* synthetic */ AvatarAction copy$default(AvatarAction avatarAction, Resource resource, Resource resource2, Resource resource3, Resource resource4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            resource = avatarAction.lookFront;
        }
        if ((i3 & 2) != 0) {
            resource2 = avatarAction.unread;
        }
        if ((i3 & 4) != 0) {
            resource3 = avatarAction.feedsNew;
        }
        if ((i3 & 8) != 0) {
            resource4 = avatarAction.battery;
        }
        return avatarAction.copy(resource, resource2, resource3, resource4);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final Resource getLookFront() {
        return this.lookFront;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final Resource getUnread() {
        return this.unread;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final Resource getFeedsNew() {
        return this.feedsNew;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final Resource getBattery() {
        return this.battery;
    }

    @NotNull
    public final AvatarAction copy(@NotNull Resource lookFront, @NotNull Resource unread, @NotNull Resource feedsNew, @NotNull Resource battery) {
        Intrinsics.checkNotNullParameter(lookFront, "lookFront");
        Intrinsics.checkNotNullParameter(unread, "unread");
        Intrinsics.checkNotNullParameter(feedsNew, "feedsNew");
        Intrinsics.checkNotNullParameter(battery, "battery");
        return new AvatarAction(lookFront, unread, feedsNew, battery);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof AvatarAction) {
                AvatarAction avatarAction = (AvatarAction) other;
                if (!Intrinsics.areEqual(this.lookFront, avatarAction.lookFront) || !Intrinsics.areEqual(this.unread, avatarAction.unread) || !Intrinsics.areEqual(this.feedsNew, avatarAction.feedsNew) || !Intrinsics.areEqual(this.battery, avatarAction.battery)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final Resource getBattery() {
        return this.battery;
    }

    @NotNull
    public final Resource getFeedsNew() {
        return this.feedsNew;
    }

    @NotNull
    public final Resource getLookFront() {
        return this.lookFront;
    }

    @NotNull
    public final Resource getUnread() {
        return this.unread;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        Resource resource = this.lookFront;
        int i18 = 0;
        if (resource != null) {
            i3 = resource.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        Resource resource2 = this.unread;
        if (resource2 != null) {
            i16 = resource2.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        Resource resource3 = this.feedsNew;
        if (resource3 != null) {
            i17 = resource3.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        Resource resource4 = this.battery;
        if (resource4 != null) {
            i18 = resource4.hashCode();
        }
        return i27 + i18;
    }

    public final void setBattery(@NotNull Resource resource) {
        Intrinsics.checkNotNullParameter(resource, "<set-?>");
        this.battery = resource;
    }

    public final void setFeedsNew(@NotNull Resource resource) {
        Intrinsics.checkNotNullParameter(resource, "<set-?>");
        this.feedsNew = resource;
    }

    public final void setLookFront(@NotNull Resource resource) {
        Intrinsics.checkNotNullParameter(resource, "<set-?>");
        this.lookFront = resource;
    }

    public final void setUnread(@NotNull Resource resource) {
        Intrinsics.checkNotNullParameter(resource, "<set-?>");
        this.unread = resource;
    }

    @NotNull
    public String toString() {
        return "AvatarAction(lookFront=" + this.lookFront + ", unread=" + this.unread + ", feedsNew=" + this.feedsNew + ", battery=" + this.battery + ")";
    }

    public /* synthetic */ AvatarAction(Resource resource, Resource resource2, Resource resource3, Resource resource4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(resource, (i3 & 2) != 0 ? resource : resource2, (i3 & 4) != 0 ? resource : resource3, (i3 & 8) != 0 ? resource : resource4);
    }
}
