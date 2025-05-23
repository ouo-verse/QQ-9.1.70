package com.tencent.mobileqq.zootopia.ueloading.prepare.preparer;

import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zootopia.ZootopiaUEActivity;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.download.mod.hotpatch.ZPlanModHotPatchConfig;
import com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoaderControllerV2;
import com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoadingController;
import com.tencent.mobileqq.zootopia.ueloading.report.ZPlanUEReportHelper;
import com.tencent.mobileqq.zootopia.view.ZPlanBaseSceneLoadingView;
import com.tencent.mobileqq.zplan.resource.api.data.mod.ZPlanResHubResultInfo;
import com.tencent.zplan.resource.api.ZPlanSceneResourceErrType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vd3.PrepareErr;
import vd3.PrepareResult;

@Metadata(d1 = {"\u0000I\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016J*\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0016J(\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J:\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0016H\u0016\u00a8\u0006 "}, d2 = {"com/tencent/mobileqq/zootopia/ueloading/prepare/preparer/HotPatchPreparer$prepare$1", "Lcom/tencent/mobileqq/zootopia/download/mod/hotpatch/a;", "", "modId", "", "onRealCheckStart", "", "checkCostTime", "", "needDownloadHotPatch", "onCheckResult", "needDownloadSize", "Lvj3/c;", "resultCallback", "checkWhenMobileDownload", "Lcom/tencent/mobileqq/zplan/resource/api/data/mod/ZPlanResHubResultInfo;", "hotPatchInfo", "hasRealChecked", "hasRealDownloaded", "onDownloadSuccess", "", "progress", "", "totalTaskCount", "completedTaskCount", "onDownloadProgress", "Lcom/tencent/zplan/resource/api/ZPlanSceneResourceErrType;", ImageTaskConst.ERROR_TYPE, "errorCode", "errorMessage", "failedTaskCount", "onDownloadError", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class HotPatchPreparer$prepare$1 implements com.tencent.mobileqq.zootopia.download.mod.hotpatch.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HotPatchPreparer f329482a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ZootopiaEnterParams f329483b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ZPlanModHotPatchConfig f329484c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ JSONObject f329485d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ vd3.c f329486e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HotPatchPreparer$prepare$1(HotPatchPreparer hotPatchPreparer, ZootopiaEnterParams zootopiaEnterParams, ZPlanModHotPatchConfig zPlanModHotPatchConfig, JSONObject jSONObject, vd3.c cVar) {
        this.f329482a = hotPatchPreparer;
        this.f329483b = zootopiaEnterParams;
        this.f329484c = zPlanModHotPatchConfig;
        this.f329485d = jSONObject;
        this.f329486e = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(HotPatchPreparer this$0, float f16) {
        ZPlanUELoaderControllerV2 zPlanUELoaderControllerV2;
        ZPlanUELoaderControllerV2 zPlanUELoaderControllerV22;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        zPlanUELoaderControllerV2 = this$0.ueLoader;
        ZPlanBaseSceneLoadingView loadingView = zPlanUELoaderControllerV2.getLoadingController().getLoadingView();
        if (loadingView != null) {
            zPlanUELoaderControllerV22 = this$0.ueLoader;
            ZootopiaUEActivity zootopiaUEActivity = zPlanUELoaderControllerV22.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String();
            loadingView.d(zootopiaUEActivity != null ? zootopiaUEActivity.getString(R.string.xw_) : null, Float.valueOf(Math.max(1.0f, f16 * 100)));
        }
    }

    @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
    public void checkWhenMobileDownload(String modId, long needDownloadSize, final vj3.c resultCallback) {
        ZPlanUELoaderControllerV2 zPlanUELoaderControllerV2;
        ZPlanUELoaderControllerV2 zPlanUELoaderControllerV22;
        Intrinsics.checkNotNullParameter(modId, "modId");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        this.f329482a.h("modId=" + modId + " needDownloadSize=" + needDownloadSize);
        zPlanUELoaderControllerV2 = this.f329482a.ueLoader;
        if (zPlanUELoaderControllerV2.getHasDestroyed()) {
            return;
        }
        onDownloadProgress(modId, 0.01f, 1, 0);
        HotPatchPreparer hotPatchPreparer = this.f329482a;
        zPlanUELoaderControllerV22 = hotPatchPreparer.ueLoader;
        hotPatchPreparer.n(zPlanUELoaderControllerV22.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), Integer.valueOf(this.f329483b.getMapId()), needDownloadSize, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zootopia.ueloading.prepare.preparer.HotPatchPreparer$prepare$1$checkWhenMobileDownload$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                vj3.c.this.a(z16);
            }
        });
    }

    @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
    public void onCheckResult(String modId, long checkCostTime, boolean needDownloadHotPatch) {
        ZPlanUELoaderControllerV2 zPlanUELoaderControllerV2;
        ZPlanUELoaderControllerV2 zPlanUELoaderControllerV22;
        ZPlanUELoaderControllerV2 zPlanUELoaderControllerV23;
        ZPlanUELoaderControllerV2 zPlanUELoaderControllerV24;
        Intrinsics.checkNotNullParameter(modId, "modId");
        this.f329482a.h("onCheckResult modId=" + modId + " checkCostTime=" + checkCostTime + " needDownloadHotPatch=" + needDownloadHotPatch);
        zPlanUELoaderControllerV2 = this.f329482a.ueLoader;
        if (!zPlanUELoaderControllerV2.getHasDestroyed()) {
            zPlanUELoaderControllerV23 = this.f329482a.ueLoader;
            ZPlanUEReportHelper M = zPlanUELoaderControllerV23.M();
            zPlanUELoaderControllerV24 = this.f329482a.ueLoader;
            M.k(zPlanUELoaderControllerV24.getProgressRecord(), checkCostTime, needDownloadHotPatch);
        }
        zPlanUELoaderControllerV22 = this.f329482a.ueLoader;
        zPlanUELoaderControllerV22.getProgressRecord().n(needDownloadHotPatch ? 1 : 0);
    }

    @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
    public void onDownloadProgress(String modId, final float progress, int totalTaskCount, int completedTaskCount) {
        ZPlanUELoaderControllerV2 zPlanUELoaderControllerV2;
        ZPlanBaseSceneLoadingView loadingView;
        Intrinsics.checkNotNullParameter(modId, "modId");
        this.f329482a.h("onDownloadProgress - " + progress);
        zPlanUELoaderControllerV2 = this.f329482a.ueLoader;
        ZPlanUELoadingController loadingController = zPlanUELoaderControllerV2.getLoadingController();
        if (loadingController == null || (loadingView = loadingController.getLoadingView()) == null) {
            return;
        }
        final HotPatchPreparer hotPatchPreparer = this.f329482a;
        loadingView.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.ueloading.prepare.preparer.f
            @Override // java.lang.Runnable
            public final void run() {
                HotPatchPreparer$prepare$1.b(HotPatchPreparer.this, progress);
            }
        });
    }

    @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
    public void onRealCheckStart(String modId) {
        ZPlanUELoaderControllerV2 zPlanUELoaderControllerV2;
        ZPlanUELoaderControllerV2 zPlanUELoaderControllerV22;
        ZPlanUELoaderControllerV2 zPlanUELoaderControllerV23;
        Intrinsics.checkNotNullParameter(modId, "modId");
        this.f329482a.h("onRealCheckStart modId=" + modId);
        zPlanUELoaderControllerV2 = this.f329482a.ueLoader;
        if (zPlanUELoaderControllerV2.getHasDestroyed()) {
            return;
        }
        zPlanUELoaderControllerV22 = this.f329482a.ueLoader;
        ZPlanUEReportHelper M = zPlanUELoaderControllerV22.M();
        zPlanUELoaderControllerV23 = this.f329482a.ueLoader;
        M.j(zPlanUELoaderControllerV23.getProgressRecord());
    }

    @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
    public void onDownloadSuccess(String modId, ZPlanResHubResultInfo hotPatchInfo, boolean hasRealChecked, boolean hasRealDownloaded) {
        ZPlanUELoaderControllerV2 zPlanUELoaderControllerV2;
        ZPlanUELoaderControllerV2 zPlanUELoaderControllerV22;
        ZPlanResHubResultInfo zPlanResHubResultInfo = hotPatchInfo;
        Intrinsics.checkNotNullParameter(modId, "modId");
        long currentTimeMillis = System.currentTimeMillis() - this.f329482a.getStepStartTime();
        this.f329482a.h("onDownloadSuccess, stepCost: " + currentTimeMillis + ", hotPatchInfo:" + zPlanResHubResultInfo + " hasRealChecked:" + hasRealChecked + " hasRealDownloaded:" + hasRealDownloaded);
        com.tencent.mobileqq.zootopia.ueloading.report.b.t(com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a, this.f329484c, vd3.a.c(this.f329482a, false, currentTimeMillis, 1, null), 0, null, 8, null);
        if (hasRealChecked) {
            zPlanUELoaderControllerV2 = this.f329482a.ueLoader;
            ZPlanUEReportHelper M = zPlanUELoaderControllerV2.M();
            zPlanUELoaderControllerV22 = this.f329482a.ueLoader;
            M.l((r19 & 1) != 0 ? null : zPlanUELoaderControllerV22.getProgressRecord(), true, currentTimeMillis, true, hasRealDownloaded, (r19 & 32) != 0 ? 0 : 0, (r19 & 64) != 0 ? "" : null);
        }
        if (zPlanResHubResultInfo == null) {
            zPlanResHubResultInfo = new ZPlanResHubResultInfo("", "", "", null, null, null, null, null, 248, null);
        }
        Map<String, String> convertToModEnterParams = zPlanResHubResultInfo.convertToModEnterParams();
        JSONObject jSONObject = this.f329485d;
        for (Map.Entry<String, String> entry : convertToModEnterParams.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        this.f329482a.f(this.f329483b, this.f329485d, this.f329486e);
    }

    @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
    public void onDownloadError(String modId, ZPlanSceneResourceErrType errType, int errorCode, String errorMessage, int totalTaskCount, int failedTaskCount) {
        ZPlanUELoaderControllerV2 zPlanUELoaderControllerV2;
        int i3;
        ZPlanUELoaderControllerV2 zPlanUELoaderControllerV22;
        ZPlanUELoaderControllerV2 zPlanUELoaderControllerV23;
        ZPlanUELoaderControllerV2 zPlanUELoaderControllerV24;
        String str = errorMessage;
        Intrinsics.checkNotNullParameter(modId, "modId");
        Intrinsics.checkNotNullParameter(errType, "errType");
        long currentTimeMillis = System.currentTimeMillis() - this.f329482a.getStepStartTime();
        this.f329482a.g("onDownloadError - errType= " + errType + ", errorCode= " + errorCode + ", " + str + ", stepCost= " + currentTimeMillis);
        if (errorCode != -99001) {
            kd3.a.f412063b.e(errorCode, str == null ? "" : str, this.f329483b);
        }
        com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.s(this.f329484c, vd3.a.c(this.f329482a, false, currentTimeMillis, 1, null), errorCode, str == null ? "" : str);
        zPlanUELoaderControllerV2 = this.f329482a.ueLoader;
        if (zPlanUELoaderControllerV2.getHasDestroyed()) {
            i3 = -99001;
        } else {
            zPlanUELoaderControllerV23 = this.f329482a.ueLoader;
            ZPlanUEReportHelper M = zPlanUELoaderControllerV23.M();
            zPlanUELoaderControllerV24 = this.f329482a.ueLoader;
            i3 = -99001;
            M.l(zPlanUELoaderControllerV24.getProgressRecord(), false, currentTimeMillis, true, true, errorCode, str == null ? "" : str);
        }
        zPlanUELoaderControllerV22 = this.f329482a.ueLoader;
        ZootopiaUEActivity zootopiaUEActivity = zPlanUELoaderControllerV22.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String();
        if (zootopiaUEActivity != null) {
            HotPatchPreparer hotPatchPreparer = this.f329482a;
            ZootopiaEnterParams zootopiaEnterParams = this.f329483b;
            JSONObject jSONObject = this.f329485d;
            vd3.c cVar = this.f329486e;
            if (errorCode != i3) {
                hotPatchPreparer.m(zootopiaUEActivity, zootopiaEnterParams, jSONObject, cVar, errorCode, errorMessage);
            } else {
                zootopiaUEActivity.finish();
            }
        }
        vd3.c cVar2 = this.f329486e;
        ZootopiaEnterParams zootopiaEnterParams2 = this.f329483b;
        JSONObject jSONObject2 = this.f329485d;
        if (str == null) {
            str = "hotpatch failed";
        }
        cVar2.a(new PrepareResult(zootopiaEnterParams2, jSONObject2, null, new PrepareErr(4, errorCode, str), 4, null));
    }
}
