package com.tencent.state.service;

import com.tencent.state.square.data.Resource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\bH\u00c6\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\bH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/state/service/SquareAvatarMotionInfo;", "", "actionId", "", "staticResource", "Lcom/tencent/state/square/data/Resource;", "dynamicResource", "dressKey", "", "(ILcom/tencent/state/square/data/Resource;Lcom/tencent/state/square/data/Resource;Ljava/lang/String;)V", "getActionId", "()I", "getDressKey", "()Ljava/lang/String;", "getDynamicResource", "()Lcom/tencent/state/square/data/Resource;", "getStaticResource", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SquareAvatarMotionInfo {
    private final int actionId;
    private final String dressKey;
    private final Resource dynamicResource;
    private final Resource staticResource;

    public SquareAvatarMotionInfo(int i3, Resource staticResource, Resource dynamicResource, String dressKey) {
        Intrinsics.checkNotNullParameter(staticResource, "staticResource");
        Intrinsics.checkNotNullParameter(dynamicResource, "dynamicResource");
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        this.actionId = i3;
        this.staticResource = staticResource;
        this.dynamicResource = dynamicResource;
        this.dressKey = dressKey;
    }

    /* renamed from: component1, reason: from getter */
    public final int getActionId() {
        return this.actionId;
    }

    /* renamed from: component2, reason: from getter */
    public final Resource getStaticResource() {
        return this.staticResource;
    }

    /* renamed from: component3, reason: from getter */
    public final Resource getDynamicResource() {
        return this.dynamicResource;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDressKey() {
        return this.dressKey;
    }

    public final SquareAvatarMotionInfo copy(int actionId, Resource staticResource, Resource dynamicResource, String dressKey) {
        Intrinsics.checkNotNullParameter(staticResource, "staticResource");
        Intrinsics.checkNotNullParameter(dynamicResource, "dynamicResource");
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        return new SquareAvatarMotionInfo(actionId, staticResource, dynamicResource, dressKey);
    }

    public final int getActionId() {
        return this.actionId;
    }

    public final String getDressKey() {
        return this.dressKey;
    }

    public final Resource getDynamicResource() {
        return this.dynamicResource;
    }

    public final Resource getStaticResource() {
        return this.staticResource;
    }

    public int hashCode() {
        int i3 = this.actionId * 31;
        Resource resource = this.staticResource;
        int hashCode = (i3 + (resource != null ? resource.hashCode() : 0)) * 31;
        Resource resource2 = this.dynamicResource;
        int hashCode2 = (hashCode + (resource2 != null ? resource2.hashCode() : 0)) * 31;
        String str = this.dressKey;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "SquareAvatarMotionInfo(actionId=" + this.actionId + ", staticResource=" + this.staticResource + ", dynamicResource=" + this.dynamicResource + ", dressKey=" + this.dressKey + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SquareAvatarMotionInfo)) {
            return false;
        }
        SquareAvatarMotionInfo squareAvatarMotionInfo = (SquareAvatarMotionInfo) other;
        return this.actionId == squareAvatarMotionInfo.actionId && Intrinsics.areEqual(this.staticResource, squareAvatarMotionInfo.staticResource) && Intrinsics.areEqual(this.dynamicResource, squareAvatarMotionInfo.dynamicResource) && Intrinsics.areEqual(this.dressKey, squareAvatarMotionInfo.dressKey);
    }

    public static /* synthetic */ SquareAvatarMotionInfo copy$default(SquareAvatarMotionInfo squareAvatarMotionInfo, int i3, Resource resource, Resource resource2, String str, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = squareAvatarMotionInfo.actionId;
        }
        if ((i16 & 2) != 0) {
            resource = squareAvatarMotionInfo.staticResource;
        }
        if ((i16 & 4) != 0) {
            resource2 = squareAvatarMotionInfo.dynamicResource;
        }
        if ((i16 & 8) != 0) {
            str = squareAvatarMotionInfo.dressKey;
        }
        return squareAvatarMotionInfo.copy(i3, resource, resource2, str);
    }
}
