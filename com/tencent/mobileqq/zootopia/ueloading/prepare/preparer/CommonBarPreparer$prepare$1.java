package com.tencent.mobileqq.zootopia.ueloading.prepare.preparer;

import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.zootopia.ZootopiaUEActivity;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoaderControllerV2;
import com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoadingController;
import com.tencent.mobileqq.zootopia.view.ZPlanBaseSceneLoadingView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vd3.PrepareErr;
import vd3.PrepareResult;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\u001a\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0013"}, d2 = {"com/tencent/mobileqq/zootopia/ueloading/prepare/preparer/CommonBarPreparer$prepare$1", "Lti3/a;", "", "downloadText", "launchText", "", "c", "modConfigJson", "", FavEmoConstant.ROAMING_TYPE_PANEL, "b", "progressTitle", "", "progress", "onProgress", "", "errorCode", "errorMessage", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class CommonBarPreparer$prepare$1 implements ti3.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CommonBarPreparer f329469a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ JSONObject f329470b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ZootopiaEnterParams f329471c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ vd3.c f329472d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CommonBarPreparer$prepare$1(CommonBarPreparer commonBarPreparer, JSONObject jSONObject, ZootopiaEnterParams zootopiaEnterParams, vd3.c cVar) {
        this.f329469a = commonBarPreparer;
        this.f329470b = jSONObject;
        this.f329471c = zootopiaEnterParams;
        this.f329472d = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(CommonBarPreparer this$0, String progressTitle, float f16) {
        ZPlanUELoaderControllerV2 zPlanUELoaderControllerV2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(progressTitle, "$progressTitle");
        zPlanUELoaderControllerV2 = this$0.ueLoader;
        ZPlanBaseSceneLoadingView loadingView = zPlanUELoaderControllerV2.getLoadingController().getLoadingView();
        if (loadingView != null) {
            loadingView.d(progressTitle, Float.valueOf(f16));
        }
    }

    @Override // ti3.a
    public void a(int errorCode, String errorMessage) {
        ZPlanUELoaderControllerV2 zPlanUELoaderControllerV2;
        ZPlanUELoaderControllerV2 zPlanUELoaderControllerV22;
        this.f329469a.g("onCheckFailed errorCode=" + errorCode + " errorMessage=" + errorMessage);
        kd3.a.f412063b.d(errorCode, errorMessage == null ? "" : errorMessage, this.f329471c);
        zPlanUELoaderControllerV2 = this.f329469a.ueLoader;
        ud3.a modLoadListener = zPlanUELoaderControllerV2.getModLoadListener();
        if (modLoadListener != null) {
            modLoadListener.A1(errorCode, errorMessage);
        }
        zPlanUELoaderControllerV22 = this.f329469a.ueLoader;
        final ZootopiaUEActivity zootopiaUEActivity = zPlanUELoaderControllerV22.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String();
        if (zootopiaUEActivity != null) {
            CommonBarPreparer commonBarPreparer = this.f329469a;
            ((si3.b) vb3.a.f441346a.a(si3.b.class)).A0(zootopiaUEActivity, errorCode, new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.ueloading.prepare.preparer.CommonBarPreparer$prepare$1$onCheckFailed$1$1
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
            com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.p(vd3.a.c(commonBarPreparer, false, System.currentTimeMillis() - commonBarPreparer.getStepStartTime(), 1, null), errorCode, errorMessage != null ? errorMessage : "");
        }
        vd3.c cVar = this.f329472d;
        ZootopiaEnterParams zootopiaEnterParams = this.f329471c;
        JSONObject jSONObject = this.f329470b;
        if (errorMessage == null) {
            errorMessage = "common bar failed";
        }
        cVar.a(new PrepareResult(zootopiaEnterParams, jSONObject, null, new PrepareErr(3, errorCode, errorMessage), 4, null));
    }

    @Override // ti3.a
    public void b(String modConfigJson, boolean needDownload) {
        ZPlanUELoaderControllerV2 zPlanUELoaderControllerV2;
        Intrinsics.checkNotNullParameter(modConfigJson, "modConfigJson");
        this.f329469a.h("onCheckComplete modConfigJson=" + modConfigJson + " needDownload=" + needDownload);
        zPlanUELoaderControllerV2 = this.f329469a.ueLoader;
        ud3.a modLoadListener = zPlanUELoaderControllerV2.getModLoadListener();
        if (modLoadListener != null) {
            modLoadListener.p(modConfigJson);
        }
        if (modConfigJson.length() > 0) {
            this.f329470b.put("ComModuleCfgStr", modConfigJson);
        }
        this.f329469a.f(this.f329471c, this.f329470b, this.f329472d);
        com.tencent.mobileqq.zootopia.ueloading.report.b.q(com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a, this.f329469a.b(needDownload, System.currentTimeMillis() - this.f329469a.getStepStartTime()), 1, null, 4, null);
    }

    @Override // ti3.a
    public void c(String downloadText, String launchText) {
        ZPlanUELoaderControllerV2 zPlanUELoaderControllerV2;
        ZPlanUELoaderControllerV2 zPlanUELoaderControllerV22;
        Intrinsics.checkNotNullParameter(downloadText, "downloadText");
        Intrinsics.checkNotNullParameter(launchText, "launchText");
        this.f329469a.h("onProgressConfig");
        zPlanUELoaderControllerV2 = this.f329469a.ueLoader;
        zPlanUELoaderControllerV2.g0(downloadText);
        zPlanUELoaderControllerV22 = this.f329469a.ueLoader;
        zPlanUELoaderControllerV22.h0(launchText);
    }

    @Override // ti3.a
    public void onProgress(final String progressTitle, final float progress) {
        ZPlanUELoaderControllerV2 zPlanUELoaderControllerV2;
        ZPlanBaseSceneLoadingView loadingView;
        Intrinsics.checkNotNullParameter(progressTitle, "progressTitle");
        this.f329469a.h("onProgress progressTitle" + progressTitle + " progress" + progress);
        zPlanUELoaderControllerV2 = this.f329469a.ueLoader;
        ZPlanUELoadingController loadingController = zPlanUELoaderControllerV2.getLoadingController();
        if (loadingController == null || (loadingView = loadingController.getLoadingView()) == null) {
            return;
        }
        final CommonBarPreparer commonBarPreparer = this.f329469a;
        loadingView.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.ueloading.prepare.preparer.b
            @Override // java.lang.Runnable
            public final void run() {
                CommonBarPreparer$prepare$1.e(CommonBarPreparer.this, progressTitle, progress);
            }
        });
    }
}
