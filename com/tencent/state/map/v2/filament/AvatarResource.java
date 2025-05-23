package com.tencent.state.map.v2.filament;

import com.tencent.mobileqq.vas.banner.c;
import com.tencent.state.map.v2.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\bH\u00c6\u0003J8\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001\u00a2\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0006H\u00d6\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/state/map/v2/filament/AvatarResource;", "", "hostUin", "", "guestUin", "url", "", "size", "Lcom/tencent/state/map/v2/Size;", "(JLjava/lang/Long;Ljava/lang/String;Lcom/tencent/state/map/v2/Size;)V", "getGuestUin", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getHostUin", "()J", "getSize", "()Lcom/tencent/state/map/v2/Size;", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(JLjava/lang/Long;Ljava/lang/String;Lcom/tencent/state/map/v2/Size;)Lcom/tencent/state/map/v2/filament/AvatarResource;", "equals", "", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final /* data */ class AvatarResource {
    private final Long guestUin;
    private final long hostUin;
    private final Size size;
    private final String url;

    public AvatarResource(long j3, Long l3, String url, Size size) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(size, "size");
        this.hostUin = j3;
        this.guestUin = l3;
        this.url = url;
        this.size = size;
    }

    /* renamed from: component1, reason: from getter */
    public final long getHostUin() {
        return this.hostUin;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getGuestUin() {
        return this.guestUin;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component4, reason: from getter */
    public final Size getSize() {
        return this.size;
    }

    public final AvatarResource copy(long hostUin, Long guestUin, String url, Size size) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(size, "size");
        return new AvatarResource(hostUin, guestUin, url, size);
    }

    public final Long getGuestUin() {
        return this.guestUin;
    }

    public final long getHostUin() {
        return this.hostUin;
    }

    public final Size getSize() {
        return this.size;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int a16 = c.a(this.hostUin) * 31;
        Long l3 = this.guestUin;
        int hashCode = (a16 + (l3 != null ? l3.hashCode() : 0)) * 31;
        String str = this.url;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Size size = this.size;
        return hashCode2 + (size != null ? size.hashCode() : 0);
    }

    public String toString() {
        return "AvatarResource(hostUin=" + this.hostUin + ", guestUin=" + this.guestUin + ", url=" + this.url + ", size=" + this.size + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AvatarResource)) {
            return false;
        }
        AvatarResource avatarResource = (AvatarResource) other;
        return this.hostUin == avatarResource.hostUin && Intrinsics.areEqual(this.guestUin, avatarResource.guestUin) && Intrinsics.areEqual(this.url, avatarResource.url) && Intrinsics.areEqual(this.size, avatarResource.size);
    }

    public static /* synthetic */ AvatarResource copy$default(AvatarResource avatarResource, long j3, Long l3, String str, Size size, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = avatarResource.hostUin;
        }
        long j16 = j3;
        if ((i3 & 2) != 0) {
            l3 = avatarResource.guestUin;
        }
        Long l16 = l3;
        if ((i3 & 4) != 0) {
            str = avatarResource.url;
        }
        String str2 = str;
        if ((i3 & 8) != 0) {
            size = avatarResource.size;
        }
        return avatarResource.copy(j16, l16, str2, size);
    }
}
