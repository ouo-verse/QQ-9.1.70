package com.tencent.mobileqq.wink.magicAvatar.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0011\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/model/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "freeCount", "b", "vipCount", "c", "vipLevel", "d", "vipTotalCount", "<init>", "(IIII)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.magicAvatar.model.a, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class AvatarCountInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int freeCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int vipCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int vipLevel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int vipTotalCount;

    public AvatarCountInfo(int i3, int i16, int i17, int i18) {
        this.freeCount = i3;
        this.vipCount = i16;
        this.vipLevel = i17;
        this.vipTotalCount = i18;
    }

    /* renamed from: a, reason: from getter */
    public final int getFreeCount() {
        return this.freeCount;
    }

    /* renamed from: b, reason: from getter */
    public final int getVipCount() {
        return this.vipCount;
    }

    /* renamed from: c, reason: from getter */
    public final int getVipLevel() {
        return this.vipLevel;
    }

    /* renamed from: d, reason: from getter */
    public final int getVipTotalCount() {
        return this.vipTotalCount;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AvatarCountInfo)) {
            return false;
        }
        AvatarCountInfo avatarCountInfo = (AvatarCountInfo) other;
        if (this.freeCount == avatarCountInfo.freeCount && this.vipCount == avatarCountInfo.vipCount && this.vipLevel == avatarCountInfo.vipLevel && this.vipTotalCount == avatarCountInfo.vipTotalCount) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.freeCount * 31) + this.vipCount) * 31) + this.vipLevel) * 31) + this.vipTotalCount;
    }

    @NotNull
    public String toString() {
        return "AvatarCountInfo(freeCount=" + this.freeCount + ", vipCount=" + this.vipCount + ", vipLevel=" + this.vipLevel + ", vipTotalCount=" + this.vipTotalCount + ")";
    }
}
