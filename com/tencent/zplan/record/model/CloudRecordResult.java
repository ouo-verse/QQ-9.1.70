package com.tencent.zplan.record.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010%\u001a\u00020\"\u00a2\u0006\u0004\b&\u0010'J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u0015\u0010\u001cR\u0019\u0010!\u001a\u0004\u0018\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u0011\u0010 R\u0017\u0010%\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b\u001e\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/zplan/record/model/a;", "", "", "g", "", "toString", "", "hashCode", "other", "equals", "a", "I", "e", "()I", "resourceId", "b", "errorCode", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "errorMessage", "d", "Z", "getHitCloudCache", "()Z", "hitCloudCache", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "()Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "resource", "f", "Ljava/lang/Object;", "()Ljava/lang/Object;", "rawData", "", "J", "()J", "timeCost", "<init>", "(IILjava/lang/String;ZLcom/tencent/zplan/record/model/ZPlanRecordResource;Ljava/lang/Object;J)V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.tencent.zplan.record.model.a, reason: from toString */
/* loaded from: classes27.dex */
public final /* data */ class CloudRecordResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int resourceId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int errorCode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String errorMessage;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean hitCloudCache;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final ZPlanRecordResource resource;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Object rawData;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final long timeCost;

    public CloudRecordResult(int i3, int i16, @Nullable String str, boolean z16, @Nullable ZPlanRecordResource zPlanRecordResource, @Nullable Object obj, long j3) {
        this.resourceId = i3;
        this.errorCode = i16;
        this.errorMessage = str;
        this.hitCloudCache = z16;
        this.resource = zPlanRecordResource;
        this.rawData = obj;
        this.timeCost = j3;
    }

    /* renamed from: a, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Object getRawData() {
        return this.rawData;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final ZPlanRecordResource getResource() {
        return this.resource;
    }

    /* renamed from: e, reason: from getter */
    public final int getResourceId() {
        return this.resourceId;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof CloudRecordResult) {
                CloudRecordResult cloudRecordResult = (CloudRecordResult) other;
                if (this.resourceId != cloudRecordResult.resourceId || this.errorCode != cloudRecordResult.errorCode || !Intrinsics.areEqual(this.errorMessage, cloudRecordResult.errorMessage) || this.hitCloudCache != cloudRecordResult.hitCloudCache || !Intrinsics.areEqual(this.resource, cloudRecordResult.resource) || !Intrinsics.areEqual(this.rawData, cloudRecordResult.rawData) || this.timeCost != cloudRecordResult.timeCost) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    /* renamed from: f, reason: from getter */
    public final long getTimeCost() {
        return this.timeCost;
    }

    public final boolean g() {
        if (this.errorCode == 0 && this.resource != null) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        int i16;
        int i17 = ((this.resourceId * 31) + this.errorCode) * 31;
        String str = this.errorMessage;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = (i17 + i3) * 31;
        boolean z16 = this.hitCloudCache;
        int i26 = z16;
        if (z16 != 0) {
            i26 = 1;
        }
        int i27 = (i19 + i26) * 31;
        ZPlanRecordResource zPlanRecordResource = this.resource;
        if (zPlanRecordResource != null) {
            i16 = zPlanRecordResource.hashCode();
        } else {
            i16 = 0;
        }
        int i28 = (i27 + i16) * 31;
        Object obj = this.rawData;
        if (obj != null) {
            i18 = obj.hashCode();
        }
        return ((i28 + i18) * 31) + androidx.fragment.app.a.a(this.timeCost);
    }

    @NotNull
    public String toString() {
        return "CloudRecordResult(resourceId=" + this.resourceId + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", hitCloudCache=" + this.hitCloudCache + ", resource=" + this.resource + ", rawData=" + this.rawData + ", timeCost=" + this.timeCost + ")";
    }

    public /* synthetic */ CloudRecordResult(int i3, int i16, String str, boolean z16, ZPlanRecordResource zPlanRecordResource, Object obj, long j3, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i16, (i17 & 4) != 0 ? null : str, (i17 & 8) != 0 ? false : z16, (i17 & 16) != 0 ? null : zPlanRecordResource, (i17 & 32) != 0 ? null : obj, (i17 & 64) != 0 ? 0L : j3);
    }
}
