package com.tencent.mobileqq.nearbypro.avatar;

import com.tencent.state.square.data.Resource;
import com.tencent.ttpic.openapi.filter.LightConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0017\u0010\u0017\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/avatar/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "tid", "b", "Z", "()Z", LightConstants.MALE, "Lcom/tencent/state/square/data/Resource;", "c", "Lcom/tencent/state/square/data/Resource;", "()Lcom/tencent/state/square/data/Resource;", "resource", "autoPlay", "<init>", "(Ljava/lang/String;ZLcom/tencent/state/square/data/Resource;Z)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.nearbypro.avatar.b, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class AvatarData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean male;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Resource resource;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean autoPlay;

    public AvatarData(@NotNull String tid, boolean z16, @NotNull Resource resource, boolean z17) {
        Intrinsics.checkNotNullParameter(tid, "tid");
        Intrinsics.checkNotNullParameter(resource, "resource");
        this.tid = tid;
        this.male = z16;
        this.resource = resource;
        this.autoPlay = z17;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getAutoPlay() {
        return this.autoPlay;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getMale() {
        return this.male;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final Resource getResource() {
        return this.resource;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getTid() {
        return this.tid;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AvatarData)) {
            return false;
        }
        AvatarData avatarData = (AvatarData) other;
        if (Intrinsics.areEqual(this.tid, avatarData.tid) && this.male == avatarData.male && Intrinsics.areEqual(this.resource, avatarData.resource) && this.autoPlay == avatarData.autoPlay) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.tid.hashCode() * 31;
        boolean z16 = this.male;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int hashCode2 = (((hashCode + i16) * 31) + this.resource.hashCode()) * 31;
        boolean z17 = this.autoPlay;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return hashCode2 + i3;
    }

    @NotNull
    public String toString() {
        return "AvatarData(tid=" + this.tid + ", male=" + this.male + ", resource=" + this.resource + ", autoPlay=" + this.autoPlay + ")";
    }

    public /* synthetic */ AvatarData(String str, boolean z16, Resource resource, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z16, resource, (i3 & 8) != 0 ? true : z17);
    }
}
