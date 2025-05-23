package com.tencent.mobileqq.vas.aio;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/vas/aio/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/mobileqq/vas/aio/f;", "a", "Ljava/util/List;", "()Ljava/util/List;", "setAvatarIconList", "(Ljava/util/List;)V", "avatarIconList", "b", "Z", "()Z", "isOnline", "<init>", "(Ljava/util/List;Z)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.vas.aio.g, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class VasZplanAvatarInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private List<VasZplanAvatarIcon> avatarIconList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isOnline;

    public VasZplanAvatarInfo() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    @NotNull
    public final List<VasZplanAvatarIcon> a() {
        return this.avatarIconList;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsOnline() {
        return this.isOnline;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VasZplanAvatarInfo)) {
            return false;
        }
        VasZplanAvatarInfo vasZplanAvatarInfo = (VasZplanAvatarInfo) other;
        if (Intrinsics.areEqual(this.avatarIconList, vasZplanAvatarInfo.avatarIconList) && this.isOnline == vasZplanAvatarInfo.isOnline) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.avatarIconList.hashCode() * 31;
        boolean z16 = this.isOnline;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "VasZplanAvatarInfo(avatarIconList=" + this.avatarIconList + ", isOnline=" + this.isOnline + ')';
    }

    public VasZplanAvatarInfo(@NotNull List<VasZplanAvatarIcon> avatarIconList, boolean z16) {
        Intrinsics.checkNotNullParameter(avatarIconList, "avatarIconList");
        this.avatarIconList = avatarIconList;
        this.isOnline = z16;
    }

    public /* synthetic */ VasZplanAvatarInfo(List list, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : list, (i3 & 2) != 0 ? false : z16);
    }
}
