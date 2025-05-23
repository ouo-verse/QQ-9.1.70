package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0010B\u001b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/aelight/camera/ae/MaterialDownloadState;", "", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "a", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "b", "()Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", WadlProxyConsts.KEY_MATERIAL, "Lcom/tencent/aelight/camera/ae/MaterialDownloadState$DownLoadState;", "Lcom/tencent/aelight/camera/ae/MaterialDownloadState$DownLoadState;", "()Lcom/tencent/aelight/camera/ae/MaterialDownloadState$DownLoadState;", "c", "(Lcom/tencent/aelight/camera/ae/MaterialDownloadState$DownLoadState;)V", "downloadState", "<init>", "(Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;Lcom/tencent/aelight/camera/ae/MaterialDownloadState$DownLoadState;)V", "DownLoadState", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class MaterialDownloadState {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final AEMaterialMetaData material;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private DownLoadState downloadState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/aelight/camera/ae/MaterialDownloadState$DownLoadState;", "", "(Ljava/lang/String;I)V", "DOWN_LOADING", "ERROR_BREAK", com.tencent.tmdownloader.a.CONNTECTSTATE_FINISH, "aelight_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes32.dex */
    public enum DownLoadState {
        DOWN_LOADING,
        ERROR_BREAK,
        FINISH
    }

    public MaterialDownloadState(AEMaterialMetaData aEMaterialMetaData, DownLoadState downloadState) {
        Intrinsics.checkNotNullParameter(downloadState, "downloadState");
        this.material = aEMaterialMetaData;
        this.downloadState = downloadState;
    }

    /* renamed from: a, reason: from getter */
    public final DownLoadState getDownloadState() {
        return this.downloadState;
    }

    /* renamed from: b, reason: from getter */
    public final AEMaterialMetaData getMaterial() {
        return this.material;
    }

    public final void c(DownLoadState downLoadState) {
        Intrinsics.checkNotNullParameter(downLoadState, "<set-?>");
        this.downloadState = downLoadState;
    }

    public /* synthetic */ MaterialDownloadState(AEMaterialMetaData aEMaterialMetaData, DownLoadState downLoadState, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(aEMaterialMetaData, (i3 & 2) != 0 ? DownLoadState.DOWN_LOADING : downLoadState);
    }
}
