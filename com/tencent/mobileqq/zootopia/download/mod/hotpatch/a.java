package com.tencent.mobileqq.zootopia.download.mod.hotpatch;

import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.mobileqq.zplan.resource.api.data.mod.ZPlanResHubResultInfo;
import com.tencent.zplan.resource.api.ZPlanSceneResourceErrType;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH&J*\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH&J:\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0016H&J(\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0016H\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/mod/hotpatch/a;", "", "", "modId", "", "onRealCheckStart", "", "checkCostTime", "", "needDownloadHotPatch", "onCheckResult", "needDownloadSize", "Lvj3/c;", "resultCallback", "checkWhenMobileDownload", "Lcom/tencent/mobileqq/zplan/resource/api/data/mod/ZPlanResHubResultInfo;", "hotPatchInfo", "hasRealChecked", "hasRealDownloaded", "onDownloadSuccess", "Lcom/tencent/zplan/resource/api/ZPlanSceneResourceErrType;", ImageTaskConst.ERROR_TYPE, "", "errorCode", "errorMessage", "totalTaskCount", "failedTaskCount", "onDownloadError", "", "progress", "completedTaskCount", "onDownloadProgress", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public interface a {
    void checkWhenMobileDownload(String modId, long needDownloadSize, vj3.c resultCallback);

    void onCheckResult(String modId, long checkCostTime, boolean needDownloadHotPatch);

    void onDownloadError(String modId, ZPlanSceneResourceErrType errType, int errorCode, String errorMessage, int totalTaskCount, int failedTaskCount);

    void onDownloadProgress(String modId, float progress, int totalTaskCount, int completedTaskCount);

    void onDownloadSuccess(String modId, ZPlanResHubResultInfo hotPatchInfo, boolean hasRealChecked, boolean hasRealDownloaded);

    void onRealCheckStart(String modId);
}
