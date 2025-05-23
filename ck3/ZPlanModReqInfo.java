package ck3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lck3/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "modId", "b", "modLocalVersion", "c", "I", "()I", "modPackType", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ck3.b, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class ZPlanModReqInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String modId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String modLocalVersion;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int modPackType;

    public ZPlanModReqInfo(String modId, String modLocalVersion, int i3) {
        Intrinsics.checkNotNullParameter(modId, "modId");
        Intrinsics.checkNotNullParameter(modLocalVersion, "modLocalVersion");
        this.modId = modId;
        this.modLocalVersion = modLocalVersion;
        this.modPackType = i3;
    }

    /* renamed from: a, reason: from getter */
    public final String getModId() {
        return this.modId;
    }

    /* renamed from: b, reason: from getter */
    public final String getModLocalVersion() {
        return this.modLocalVersion;
    }

    /* renamed from: c, reason: from getter */
    public final int getModPackType() {
        return this.modPackType;
    }

    public int hashCode() {
        return (((this.modId.hashCode() * 31) + this.modLocalVersion.hashCode()) * 31) + this.modPackType;
    }

    public String toString() {
        return "ZPlanModReqInfo(modId=" + this.modId + ", modLocalVersion=" + this.modLocalVersion + ", modPackType=" + this.modPackType + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanModReqInfo)) {
            return false;
        }
        ZPlanModReqInfo zPlanModReqInfo = (ZPlanModReqInfo) other;
        return Intrinsics.areEqual(this.modId, zPlanModReqInfo.modId) && Intrinsics.areEqual(this.modLocalVersion, zPlanModReqInfo.modLocalVersion) && this.modPackType == zPlanModReqInfo.modPackType;
    }
}
