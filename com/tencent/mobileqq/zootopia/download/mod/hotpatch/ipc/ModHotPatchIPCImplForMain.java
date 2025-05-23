package com.tencent.mobileqq.zootopia.download.mod.hotpatch.ipc;

import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.mobileqq.zplan.resource.api.data.mod.ZPlanResHubResultInfo;
import com.tencent.zplan.resource.api.ZPlanSceneResourceErrType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J*\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u0015\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\rH\u0016J \u0010\u0019\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J:\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/mod/hotpatch/ipc/ModHotPatchIPCImplForMain;", "Lcom/tencent/mobileqq/zootopia/download/mod/hotpatch/ipc/a;", "", "modId", "", "progress", "", "totalTaskCount", "completedTaskCount", "", "onDownloadProgress", "Lcom/tencent/mobileqq/zplan/resource/api/data/mod/ZPlanResHubResultInfo;", "hotPatchInfo", "", "hasRealChecked", "hasRealDownloaded", "onDownloadSuccess", "onRealCheckStart", "", "checkCostTime", "needDownloadHotPatch", "onCheckResult", "needDownloadSize", "Lvj3/c;", "resultCallback", "checkWhenMobileDownload", "Lcom/tencent/zplan/resource/api/ZPlanSceneResourceErrType;", ImageTaskConst.ERROR_TYPE, "errorCode", "errorMessage", "failedTaskCount", "onDownloadError", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ModHotPatchIPCImplForMain implements a {
    @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
    public void checkWhenMobileDownload(String modId, long needDownloadSize, vj3.c resultCallback) {
        Intrinsics.checkNotNullParameter(modId, "modId");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        ZPlanModHotPatchForModProcess.f328100a.g().checkWhenMobileDownload(modId, needDownloadSize, resultCallback);
    }

    @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
    public void onCheckResult(String modId, long checkCostTime, boolean needDownloadHotPatch) {
        Intrinsics.checkNotNullParameter(modId, "modId");
        ZPlanModHotPatchForModProcess.f328100a.g().onCheckResult(modId, checkCostTime, needDownloadHotPatch);
    }

    @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
    public void onDownloadError(String modId, ZPlanSceneResourceErrType errType, int errorCode, String errorMessage, int totalTaskCount, int failedTaskCount) {
        Intrinsics.checkNotNullParameter(modId, "modId");
        Intrinsics.checkNotNullParameter(errType, "errType");
        ZPlanModHotPatchForModProcess.f328100a.g().onDownloadError(modId, errType, errorCode, errorMessage, totalTaskCount, failedTaskCount);
    }

    @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
    public void onDownloadProgress(String modId, float progress, int totalTaskCount, int completedTaskCount) {
        Intrinsics.checkNotNullParameter(modId, "modId");
        ZPlanModHotPatchForModProcess.f328100a.g().onDownloadProgress(modId, progress, totalTaskCount, completedTaskCount);
    }

    @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
    public void onDownloadSuccess(String modId, ZPlanResHubResultInfo hotPatchInfo, boolean hasRealChecked, boolean hasRealDownloaded) {
        Intrinsics.checkNotNullParameter(modId, "modId");
        ZPlanModHotPatchForModProcess.f328100a.g().onDownloadSuccess(modId, hotPatchInfo, hasRealChecked, hasRealDownloaded);
    }

    @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
    public void onRealCheckStart(String modId) {
        Intrinsics.checkNotNullParameter(modId, "modId");
        ZPlanModHotPatchForModProcess.f328100a.g().onRealCheckStart(modId);
    }
}
