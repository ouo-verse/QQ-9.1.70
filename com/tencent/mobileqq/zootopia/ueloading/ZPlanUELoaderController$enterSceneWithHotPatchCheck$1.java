package com.tencent.mobileqq.zootopia.ueloading;

import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zootopia.ZootopiaLoadingErrMod;
import com.tencent.mobileqq.zootopia.ZootopiaUEActivity;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.download.mod.hotpatch.ZPlanModHotPatchConfig;
import com.tencent.mobileqq.zootopia.view.ZPlanBaseSceneLoadingView;
import com.tencent.mobileqq.zplan.resource.api.data.mod.ZPlanResHubResultInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.resource.api.ZPlanSceneResourceErrType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ud3.c;

@Metadata(d1 = {"\u0000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J*\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J(\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\fH\u0016J:\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0012H\u0016\u00a8\u0006 "}, d2 = {"com/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderController$enterSceneWithHotPatchCheck$1", "Lcom/tencent/mobileqq/zootopia/download/mod/hotpatch/a;", "", "modId", "", "needDownloadSize", "Lvj3/c;", "resultCallback", "", "checkWhenMobileDownload", "Lcom/tencent/mobileqq/zplan/resource/api/data/mod/ZPlanResHubResultInfo;", "hotPatchInfo", "", "hasRealChecked", "hasRealDownloaded", "onDownloadSuccess", "", "progress", "", "totalTaskCount", "completedTaskCount", "onDownloadProgress", "onRealCheckStart", "checkCostTime", "needDownloadHotPatch", "onCheckResult", "Lcom/tencent/zplan/resource/api/ZPlanSceneResourceErrType;", ImageTaskConst.ERROR_TYPE, "errorCode", "errorMessage", "failedTaskCount", "onDownloadError", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanUELoaderController$enterSceneWithHotPatchCheck$1 implements com.tencent.mobileqq.zootopia.download.mod.hotpatch.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ZPlanUELoaderController f329388a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ZootopiaEnterParams f329389b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f329390c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ZPlanModHotPatchConfig f329391d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f329392e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZPlanUELoaderController$enterSceneWithHotPatchCheck$1(ZPlanUELoaderController zPlanUELoaderController, ZootopiaEnterParams zootopiaEnterParams, long j3, ZPlanModHotPatchConfig zPlanModHotPatchConfig, String str) {
        this.f329388a = zPlanUELoaderController;
        this.f329389b = zootopiaEnterParams;
        this.f329390c = j3;
        this.f329391d = zPlanModHotPatchConfig;
        this.f329392e = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ZPlanUELoaderController this$0, float f16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZPlanBaseSceneLoadingView loadingView = this$0.getLoadingController().getLoadingView();
        if (loadingView != null) {
            ZootopiaUEActivity zootopiaUEActivity = this$0.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String();
            loadingView.d(zootopiaUEActivity != null ? zootopiaUEActivity.getString(R.string.xw_) : null, Float.valueOf(Math.max(1.0f, f16 * 100)));
        }
    }

    @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
    public void checkWhenMobileDownload(String modId, long needDownloadSize, final vj3.c resultCallback) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(modId, "modId");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        z16 = this.f329388a.hasDestroyed;
        QLog.e("ZPlanUELoaderController-ZootopiaUEActivity", 1, "enterSceneWithHotPatchCheck - checkWhenMobileDownload, " + needDownloadSize + ", hasDestroyed= " + z16);
        z17 = this.f329388a.hasDestroyed;
        if (z17) {
            return;
        }
        onDownloadProgress(modId, 0.01f, 1, 0);
        ZPlanUELoaderController zPlanUELoaderController = this.f329388a;
        zPlanUELoaderController.m0(zPlanUELoaderController.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), Integer.valueOf(this.f329389b.getMapId()), needDownloadSize, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoaderController$enterSceneWithHotPatchCheck$1$checkWhenMobileDownload$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z18) {
                vj3.c.this.a(z18);
            }
        });
    }

    @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
    public void onCheckResult(String modId, long checkCostTime, boolean needDownloadHotPatch) {
        boolean z16;
        Intrinsics.checkNotNullParameter(modId, "modId");
        z16 = this.f329388a.hasDestroyed;
        if (z16) {
            return;
        }
        this.f329388a.T().k(this.f329388a.getProgressRecord(), checkCostTime, needDownloadHotPatch);
    }

    @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
    public void onDownloadProgress(String modId, final float progress, int totalTaskCount, int completedTaskCount) {
        ZPlanBaseSceneLoadingView loadingView;
        Intrinsics.checkNotNullParameter(modId, "modId");
        QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "enterSceneWithHotPatchCheck#onDownloadProgress - " + progress);
        ZPlanUELoadingController loadingController = this.f329388a.getLoadingController();
        if (loadingController == null || (loadingView = loadingController.getLoadingView()) == null) {
            return;
        }
        final ZPlanUELoaderController zPlanUELoaderController = this.f329388a;
        loadingView.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.ueloading.j
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanUELoaderController$enterSceneWithHotPatchCheck$1.b(ZPlanUELoaderController.this, progress);
            }
        });
    }

    @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
    public void onRealCheckStart(String modId) {
        boolean z16;
        Intrinsics.checkNotNullParameter(modId, "modId");
        z16 = this.f329388a.hasDestroyed;
        if (z16) {
            return;
        }
        this.f329388a.T().j(this.f329388a.getProgressRecord());
    }

    @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
    public void onDownloadSuccess(String modId, ZPlanResHubResultInfo hotPatchInfo, boolean hasRealChecked, boolean hasRealDownloaded) {
        Intrinsics.checkNotNullParameter(modId, "modId");
        long currentTimeMillis = System.currentTimeMillis() - this.f329390c;
        QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "enterSceneWithHotPatchCheck SUCCESS, stepCost: " + currentTimeMillis + ", " + hotPatchInfo);
        com.tencent.mobileqq.zootopia.ueloading.report.b.t(com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a, this.f329391d, ZPlanUELoaderController.C(this.f329388a, false, currentTimeMillis, 1, null), 0, null, 8, null);
        if (hasRealChecked) {
            this.f329388a.T().l((r19 & 1) != 0 ? null : this.f329388a.getProgressRecord(), true, currentTimeMillis, true, hasRealDownloaded, (r19 & 32) != 0 ? 0 : 0, (r19 & 64) != 0 ? "" : null);
        }
        this.f329388a.I(this.f329392e, hotPatchInfo, false);
    }

    @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
    public void onDownloadError(String modId, ZPlanSceneResourceErrType errType, int errorCode, String errorMessage, int totalTaskCount, int failedTaskCount) {
        boolean z16;
        int i3;
        Intrinsics.checkNotNullParameter(modId, "modId");
        Intrinsics.checkNotNullParameter(errType, "errType");
        long currentTimeMillis = System.currentTimeMillis() - this.f329390c;
        QLog.e("ZPlanUELoaderController-ZootopiaUEActivity", 1, "enterSceneWithHotPatchCheck#onDownloadError - errType= " + errType + ", errorCode= " + errorCode + ", " + errorMessage + ", stepCost= " + currentTimeMillis);
        if (errorCode != -99001) {
            kd3.a.f412063b.e(errorCode, errorMessage == null ? "" : errorMessage, this.f329389b);
        }
        com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.s(this.f329391d, ZPlanUELoaderController.C(this.f329388a, false, currentTimeMillis, 1, null), errorCode, errorMessage == null ? "" : errorMessage);
        z16 = this.f329388a.hasDestroyed;
        if (z16) {
            i3 = -99001;
        } else {
            i3 = -99001;
            this.f329388a.T().l(this.f329388a.getProgressRecord(), false, currentTimeMillis, true, true, errorCode, errorMessage == null ? "" : errorMessage);
        }
        ZPlanUELoaderController zPlanUELoaderController = this.f329388a;
        c.a.d(zPlanUELoaderController, errorCode, errorMessage == null ? "" : errorMessage, ZootopiaLoadingErrMod.NATIVE, zPlanUELoaderController.getProgressRecord(), false, this.f329389b.getSource(), 16, null);
        ZootopiaUEActivity zootopiaUEActivity = this.f329388a.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String();
        if (zootopiaUEActivity != null) {
            ZPlanUELoaderController zPlanUELoaderController2 = this.f329388a;
            ZootopiaEnterParams zootopiaEnterParams = this.f329389b;
            String str = this.f329392e;
            if (errorCode != i3) {
                zPlanUELoaderController2.Y(zootopiaUEActivity, zootopiaEnterParams, str, errorCode, errorMessage);
            } else {
                zootopiaUEActivity.finish();
            }
        }
    }
}
