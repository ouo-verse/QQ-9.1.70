package com.tencent.state.square.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\bH\u00c6\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/state/square/data/RecordResourceInfo;", "", "resource", "Lcom/tencent/state/square/data/Resource;", "width", "", "height", "hasDynamicRecord", "", "(Lcom/tencent/state/square/data/Resource;IIZ)V", "getHasDynamicRecord", "()Z", "setHasDynamicRecord", "(Z)V", "getHeight", "()I", "getResource", "()Lcom/tencent/state/square/data/Resource;", "setResource", "(Lcom/tencent/state/square/data/Resource;)V", "getWidth", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class RecordResourceInfo {
    private boolean hasDynamicRecord;
    private final int height;
    private Resource resource;
    private final int width;

    public RecordResourceInfo(Resource resource, int i3, int i16, boolean z16) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        this.resource = resource;
        this.width = i3;
        this.height = i16;
        this.hasDynamicRecord = z16;
    }

    /* renamed from: component1, reason: from getter */
    public final Resource getResource() {
        return this.resource;
    }

    /* renamed from: component2, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component3, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getHasDynamicRecord() {
        return this.hasDynamicRecord;
    }

    public final RecordResourceInfo copy(Resource resource, int width, int height, boolean hasDynamicRecord) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        return new RecordResourceInfo(resource, width, height, hasDynamicRecord);
    }

    public final boolean getHasDynamicRecord() {
        return this.hasDynamicRecord;
    }

    public final int getHeight() {
        return this.height;
    }

    public final Resource getResource() {
        return this.resource;
    }

    public final int getWidth() {
        return this.width;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Resource resource = this.resource;
        int hashCode = (((((resource != null ? resource.hashCode() : 0) * 31) + this.width) * 31) + this.height) * 31;
        boolean z16 = this.hasDynamicRecord;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public final void setHasDynamicRecord(boolean z16) {
        this.hasDynamicRecord = z16;
    }

    public final void setResource(Resource resource) {
        Intrinsics.checkNotNullParameter(resource, "<set-?>");
        this.resource = resource;
    }

    public String toString() {
        return "RecordResourceInfo(resource=" + this.resource + ", width=" + this.width + ", height=" + this.height + ", hasDynamicRecord=" + this.hasDynamicRecord + ")";
    }

    public /* synthetic */ RecordResourceInfo(Resource resource, int i3, int i16, boolean z16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(resource, i3, i16, (i17 & 8) != 0 ? false : z16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecordResourceInfo)) {
            return false;
        }
        RecordResourceInfo recordResourceInfo = (RecordResourceInfo) other;
        return Intrinsics.areEqual(this.resource, recordResourceInfo.resource) && this.width == recordResourceInfo.width && this.height == recordResourceInfo.height && this.hasDynamicRecord == recordResourceInfo.hasDynamicRecord;
    }

    public static /* synthetic */ RecordResourceInfo copy$default(RecordResourceInfo recordResourceInfo, Resource resource, int i3, int i16, boolean z16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            resource = recordResourceInfo.resource;
        }
        if ((i17 & 2) != 0) {
            i3 = recordResourceInfo.width;
        }
        if ((i17 & 4) != 0) {
            i16 = recordResourceInfo.height;
        }
        if ((i17 & 8) != 0) {
            z16 = recordResourceInfo.hasDynamicRecord;
        }
        return recordResourceInfo.copy(resource, i3, i16, z16);
    }
}
