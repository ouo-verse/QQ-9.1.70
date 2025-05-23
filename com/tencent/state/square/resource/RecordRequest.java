package com.tencent.state.square.resource;

import com.tencent.state.square.data.Resource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0006H\u00c6\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/square/resource/RecordRequest;", "", "resource", "Lcom/tencent/state/square/data/Resource;", "extra", "appId", "", "(Lcom/tencent/state/square/data/Resource;Ljava/lang/Object;I)V", "getAppId", "()I", "getExtra", "()Ljava/lang/Object;", "getResource", "()Lcom/tencent/state/square/data/Resource;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class RecordRequest {
    private final int appId;
    private final Object extra;
    private final Resource resource;

    public RecordRequest(Resource resource, Object obj, int i3) {
        this.resource = resource;
        this.extra = obj;
        this.appId = i3;
    }

    /* renamed from: component1, reason: from getter */
    public final Resource getResource() {
        return this.resource;
    }

    /* renamed from: component2, reason: from getter */
    public final Object getExtra() {
        return this.extra;
    }

    /* renamed from: component3, reason: from getter */
    public final int getAppId() {
        return this.appId;
    }

    public final RecordRequest copy(Resource resource, Object extra, int appId) {
        return new RecordRequest(resource, extra, appId);
    }

    public final int getAppId() {
        return this.appId;
    }

    public final Object getExtra() {
        return this.extra;
    }

    public final Resource getResource() {
        return this.resource;
    }

    public int hashCode() {
        Resource resource = this.resource;
        int hashCode = (resource != null ? resource.hashCode() : 0) * 31;
        Object obj = this.extra;
        return ((hashCode + (obj != null ? obj.hashCode() : 0)) * 31) + this.appId;
    }

    public String toString() {
        return "RecordRequest(resource=" + this.resource + ", extra=" + this.extra + ", appId=" + this.appId + ")";
    }

    public /* synthetic */ RecordRequest(Resource resource, Object obj, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(resource, (i16 & 2) != 0 ? null : obj, (i16 & 4) != 0 ? 0 : i3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecordRequest)) {
            return false;
        }
        RecordRequest recordRequest = (RecordRequest) other;
        return Intrinsics.areEqual(this.resource, recordRequest.resource) && Intrinsics.areEqual(this.extra, recordRequest.extra) && this.appId == recordRequest.appId;
    }

    public static /* synthetic */ RecordRequest copy$default(RecordRequest recordRequest, Resource resource, Object obj, int i3, int i16, Object obj2) {
        if ((i16 & 1) != 0) {
            resource = recordRequest.resource;
        }
        if ((i16 & 2) != 0) {
            obj = recordRequest.extra;
        }
        if ((i16 & 4) != 0) {
            i3 = recordRequest.appId;
        }
        return recordRequest.copy(resource, obj, i3);
    }
}
