package com.tencent.mobileqq.zootopia.ueloading;

import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.zootopia.ZootopiaLoadingErrMod;
import com.tencent.mobileqq.zootopia.ZootopiaUEActivity;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.ueloading.report.ZPlanUETechReportParams;
import com.tencent.mobileqq.zootopia.view.ZPlanBaseSceneLoadingView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ud3.c;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\u001a\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0013"}, d2 = {"com/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderController$enterSceneWithBaseModCheck$1", "Lti3/a;", "", "downloadText", "launchText", "", "c", "modConfigJson", "", FavEmoConstant.ROAMING_TYPE_PANEL, "b", "progressTitle", "", "progress", "onProgress", "", "errorCode", "errorMessage", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanUELoaderController$enterSceneWithBaseModCheck$1 implements ti3.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ZPlanUELoaderController f329385a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f329386b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ZootopiaEnterParams f329387c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZPlanUELoaderController$enterSceneWithBaseModCheck$1(ZPlanUELoaderController zPlanUELoaderController, long j3, ZootopiaEnterParams zootopiaEnterParams) {
        this.f329385a = zPlanUELoaderController;
        this.f329386b = j3;
        this.f329387c = zootopiaEnterParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ZPlanUELoaderController this$0, String progressTitle, float f16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(progressTitle, "$progressTitle");
        ZPlanBaseSceneLoadingView loadingView = this$0.getLoadingController().getLoadingView();
        if (loadingView != null) {
            loadingView.d(progressTitle, Float.valueOf(f16));
        }
    }

    @Override // ti3.a
    public void a(int errorCode, String errorMessage) {
        QLog.e("ZPlanUELoaderController-ZootopiaUEActivity", 1, "enterSceneWithBaseModCheck :: errorCode == " + errorCode);
        kd3.a.f412063b.d(errorCode, errorMessage == null ? "" : errorMessage, this.f329387c);
        ud3.a modLoadListener = this.f329385a.getModLoadListener();
        if (modLoadListener != null) {
            modLoadListener.A1(errorCode, errorMessage);
        }
        ZPlanUELoaderController zPlanUELoaderController = this.f329385a;
        c.a.d(zPlanUELoaderController, errorCode, errorMessage == null ? "" : errorMessage, ZootopiaLoadingErrMod.NATIVE, zPlanUELoaderController.getProgressRecord(), false, this.f329387c.getSource(), 16, null);
        final ZootopiaUEActivity zootopiaUEActivity = this.f329385a.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String();
        if (zootopiaUEActivity != null) {
            ZPlanUELoaderController zPlanUELoaderController2 = this.f329385a;
            long j3 = this.f329386b;
            ((si3.b) vb3.a.f441346a.a(si3.b.class)).A0(zootopiaUEActivity, errorCode, new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoaderController$enterSceneWithBaseModCheck$1$onCheckFailed$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ZootopiaUEActivity.this.finish();
                }
            });
            com.tencent.mobileqq.zootopia.ueloading.report.b bVar = com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a;
            ZPlanUETechReportParams C = ZPlanUELoaderController.C(zPlanUELoaderController2, false, System.currentTimeMillis() - j3, 1, null);
            if (errorMessage == null) {
                errorMessage = "";
            }
            bVar.p(C, errorCode, errorMessage);
        }
    }

    @Override // ti3.a
    public void b(String modConfigJson, boolean needDownload) {
        ZPlanUETechReportParams B;
        Intrinsics.checkNotNullParameter(modConfigJson, "modConfigJson");
        long currentTimeMillis = System.currentTimeMillis() - this.f329386b;
        QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "enterSceneWithBaseModCheck :: onCheckComplete == " + modConfigJson + ", stepCost: " + currentTimeMillis);
        ud3.a modLoadListener = this.f329385a.getModLoadListener();
        if (modLoadListener != null) {
            modLoadListener.p(modConfigJson);
        }
        com.tencent.mobileqq.zootopia.ueloading.report.b bVar = com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a;
        B = this.f329385a.B(needDownload, currentTimeMillis);
        com.tencent.mobileqq.zootopia.ueloading.report.b.q(bVar, B, 1, null, 4, null);
        this.f329385a.K(this.f329387c, modConfigJson);
    }

    @Override // ti3.a
    public void c(String downloadText, String launchText) {
        Intrinsics.checkNotNullParameter(downloadText, "downloadText");
        Intrinsics.checkNotNullParameter(launchText, "launchText");
        this.f329385a.downloadText = downloadText;
        this.f329385a.launchText = launchText;
    }

    @Override // ti3.a
    public void onProgress(final String progressTitle, final float progress) {
        ZPlanBaseSceneLoadingView loadingView;
        Intrinsics.checkNotNullParameter(progressTitle, "progressTitle");
        QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "enterSceneWithBaseModCheck :: progressTitle == " + progressTitle + ", progress == " + progress);
        ZPlanUELoadingController loadingController = this.f329385a.getLoadingController();
        if (loadingController == null || (loadingView = loadingController.getLoadingView()) == null) {
            return;
        }
        final ZPlanUELoaderController zPlanUELoaderController = this.f329385a;
        loadingView.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.ueloading.i
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanUELoaderController$enterSceneWithBaseModCheck$1.e(ZPlanUELoaderController.this, progressTitle, progress);
            }
        });
    }
}
