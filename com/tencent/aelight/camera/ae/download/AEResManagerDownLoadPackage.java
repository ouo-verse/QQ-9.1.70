package com.tencent.aelight.camera.ae.download;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0019\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/aelight/camera/ae/download/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/aelight/camera/ae/download/AEResBeanWrapper;", "a", "Lcom/tencent/aelight/camera/ae/download/AEResBeanWrapper;", "()Lcom/tencent/aelight/camera/ae/download/AEResBeanWrapper;", "mAEResBeanWrapper", "Lcom/tencent/aelight/camera/download/api/a;", "b", "Lcom/tencent/aelight/camera/download/api/a;", "()Lcom/tencent/aelight/camera/download/api/a;", "mAeDownloadCallBack", "c", "Z", "()Z", "needWiFi", "d", "isAppStartUpRequest", "e", "isHighPriority", "<init>", "(Lcom/tencent/aelight/camera/ae/download/AEResBeanWrapper;Lcom/tencent/aelight/camera/download/api/a;ZZZ)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.aelight.camera.ae.download.g, reason: from toString */
/* loaded from: classes32.dex */
public final /* data */ class AEResManagerDownLoadPackage {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final AEResBeanWrapper mAEResBeanWrapper;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final com.tencent.aelight.camera.download.api.a mAeDownloadCallBack;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean needWiFi;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isAppStartUpRequest;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isHighPriority;

    public AEResManagerDownLoadPackage() {
        this(null, null, false, false, false, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final AEResBeanWrapper getMAEResBeanWrapper() {
        return this.mAEResBeanWrapper;
    }

    /* renamed from: b, reason: from getter */
    public final com.tencent.aelight.camera.download.api.a getMAeDownloadCallBack() {
        return this.mAeDownloadCallBack;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getNeedWiFi() {
        return this.needWiFi;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsAppStartUpRequest() {
        return this.isAppStartUpRequest;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsHighPriority() {
        return this.isHighPriority;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        AEResBeanWrapper aEResBeanWrapper = this.mAEResBeanWrapper;
        int hashCode = (aEResBeanWrapper == null ? 0 : aEResBeanWrapper.hashCode()) * 31;
        com.tencent.aelight.camera.download.api.a aVar = this.mAeDownloadCallBack;
        int hashCode2 = (hashCode + (aVar != null ? aVar.hashCode() : 0)) * 31;
        boolean z16 = this.needWiFi;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode2 + i3) * 31;
        boolean z17 = this.isAppStartUpRequest;
        int i17 = z17;
        if (z17 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        boolean z18 = this.isHighPriority;
        return i18 + (z18 ? 1 : z18 ? 1 : 0);
    }

    public String toString() {
        return "AEResManagerDownLoadPackage(mAEResBeanWrapper=" + this.mAEResBeanWrapper + ", mAeDownloadCallBack=" + this.mAeDownloadCallBack + ", needWiFi=" + this.needWiFi + ", isAppStartUpRequest=" + this.isAppStartUpRequest + ", isHighPriority=" + this.isHighPriority + ")";
    }

    public AEResManagerDownLoadPackage(AEResBeanWrapper aEResBeanWrapper, com.tencent.aelight.camera.download.api.a aVar, boolean z16, boolean z17, boolean z18) {
        this.mAEResBeanWrapper = aEResBeanWrapper;
        this.mAeDownloadCallBack = aVar;
        this.needWiFi = z16;
        this.isAppStartUpRequest = z17;
        this.isHighPriority = z18;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AEResManagerDownLoadPackage)) {
            return false;
        }
        AEResManagerDownLoadPackage aEResManagerDownLoadPackage = (AEResManagerDownLoadPackage) other;
        return Intrinsics.areEqual(this.mAEResBeanWrapper, aEResManagerDownLoadPackage.mAEResBeanWrapper) && Intrinsics.areEqual(this.mAeDownloadCallBack, aEResManagerDownLoadPackage.mAeDownloadCallBack) && this.needWiFi == aEResManagerDownLoadPackage.needWiFi && this.isAppStartUpRequest == aEResManagerDownLoadPackage.isAppStartUpRequest && this.isHighPriority == aEResManagerDownLoadPackage.isHighPriority;
    }

    public /* synthetic */ AEResManagerDownLoadPackage(AEResBeanWrapper aEResBeanWrapper, com.tencent.aelight.camera.download.api.a aVar, boolean z16, boolean z17, boolean z18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : aEResBeanWrapper, (i3 & 2) == 0 ? aVar : null, (i3 & 4) != 0 ? false : z16, (i3 & 8) != 0 ? false : z17, (i3 & 16) != 0 ? false : z18);
    }
}
