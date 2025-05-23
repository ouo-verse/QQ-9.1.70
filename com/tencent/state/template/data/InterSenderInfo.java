package com.tencent.state.template.data;

import com.tencent.mobileqq.vas.banner.c;
import com.tencent.state.data.UserCommon;
import com.tencent.state.square.data.Resource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/state/template/data/InterSenderInfo;", "", "interactionResource", "Lcom/tencent/state/square/data/Resource;", "profile", "Lcom/tencent/state/data/UserCommon;", "uin", "", "(Lcom/tencent/state/square/data/Resource;Lcom/tencent/state/data/UserCommon;J)V", "getInteractionResource", "()Lcom/tencent/state/square/data/Resource;", "getProfile", "()Lcom/tencent/state/data/UserCommon;", "getUin", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class InterSenderInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Resource interactionResource;
    private final UserCommon profile;
    private final long uin;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/state/template/data/InterSenderInfo$Companion;", "", "()V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public InterSenderInfo(Resource interactionResource, UserCommon profile, long j3) {
        Intrinsics.checkNotNullParameter(interactionResource, "interactionResource");
        Intrinsics.checkNotNullParameter(profile, "profile");
        this.interactionResource = interactionResource;
        this.profile = profile;
        this.uin = j3;
    }

    /* renamed from: component1, reason: from getter */
    public final Resource getInteractionResource() {
        return this.interactionResource;
    }

    /* renamed from: component2, reason: from getter */
    public final UserCommon getProfile() {
        return this.profile;
    }

    /* renamed from: component3, reason: from getter */
    public final long getUin() {
        return this.uin;
    }

    public final InterSenderInfo copy(Resource interactionResource, UserCommon profile, long uin) {
        Intrinsics.checkNotNullParameter(interactionResource, "interactionResource");
        Intrinsics.checkNotNullParameter(profile, "profile");
        return new InterSenderInfo(interactionResource, profile, uin);
    }

    public final Resource getInteractionResource() {
        return this.interactionResource;
    }

    public final UserCommon getProfile() {
        return this.profile;
    }

    public final long getUin() {
        return this.uin;
    }

    public int hashCode() {
        Resource resource = this.interactionResource;
        int hashCode = (resource != null ? resource.hashCode() : 0) * 31;
        UserCommon userCommon = this.profile;
        return ((hashCode + (userCommon != null ? userCommon.hashCode() : 0)) * 31) + c.a(this.uin);
    }

    public String toString() {
        return "InterSenderInfo(interactionResource=" + this.interactionResource + ", profile=" + this.profile + ", uin=" + this.uin + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InterSenderInfo)) {
            return false;
        }
        InterSenderInfo interSenderInfo = (InterSenderInfo) other;
        return Intrinsics.areEqual(this.interactionResource, interSenderInfo.interactionResource) && Intrinsics.areEqual(this.profile, interSenderInfo.profile) && this.uin == interSenderInfo.uin;
    }

    public static /* synthetic */ InterSenderInfo copy$default(InterSenderInfo interSenderInfo, Resource resource, UserCommon userCommon, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            resource = interSenderInfo.interactionResource;
        }
        if ((i3 & 2) != 0) {
            userCommon = interSenderInfo.profile;
        }
        if ((i3 & 4) != 0) {
            j3 = interSenderInfo.uin;
        }
        return interSenderInfo.copy(resource, userCommon, j3);
    }
}
