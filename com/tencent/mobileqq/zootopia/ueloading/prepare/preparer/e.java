package com.tencent.mobileqq.zootopia.ueloading.prepare.preparer;

import com.epicgames.ue4.GameActivityThunk;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zootopia.ZootopiaUEActivity;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.download.hotpatch.ipc.ZPlanUEHotPatchForModProcess;
import com.tencent.mobileqq.zootopia.ue.UEActivityPluginManager;
import com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoaderControllerV2;
import com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoadingController;
import com.tencent.mobileqq.zootopia.ueloading.prepare.preparer.e;
import com.tencent.mobileqq.zootopia.view.ZPlanBaseSceneLoadingView;
import com.tencent.zplan.luabridge.plugins.data.CommonLoadingData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vd3.PrepareErr;
import vd3.PrepareResult;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ueloading/prepare/preparer/e;", "Lvd3/a;", "", "e", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "enterParams", "Lorg/json/JSONObject;", "enterJson", "Lvd3/c;", "callback", "", "a", "Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderControllerV2;", "d", "Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderControllerV2;", "loaderController", "Lcom/epicgames/ue4/GameActivityThunk$CMShowEngineInitFinishListener;", "Lcom/epicgames/ue4/GameActivityThunk$CMShowEngineInitFinishListener;", "initListener", "Ltx4/a;", "f", "Ltx4/a;", "engineLoadingListener", "<init>", "(Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderControllerV2;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class e extends vd3.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ZPlanUELoaderControllerV2 loaderController;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private GameActivityThunk.CMShowEngineInitFinishListener initListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private tx4.a engineLoadingListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zootopia/ueloading/prepare/preparer/e$a", "Ltx4/a;", "Lcom/tencent/zplan/luabridge/plugins/data/CommonLoadingData;", "loadingData", "", "Q0", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements tx4.a {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(e this$0, CommonLoadingData loadingData) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(loadingData, "$loadingData");
            ZPlanBaseSceneLoadingView loadingView = this$0.loaderController.getLoadingController().getLoadingView();
            if (loadingView != null) {
                ZootopiaUEActivity zootopiaUEActivity = this$0.loaderController.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String();
                loadingView.d(zootopiaUEActivity != null ? zootopiaUEActivity.getString(R.string.xw_) : null, Float.valueOf(Math.max(1.0f, loadingData.getProgress())));
            }
        }

        @Override // tx4.a
        public void Q0(final CommonLoadingData loadingData) {
            ZPlanBaseSceneLoadingView loadingView;
            Intrinsics.checkNotNullParameter(loadingData, "loadingData");
            e.this.h(" onProgressChange:" + loadingData.getSceneId() + ", progress= " + loadingData.getProgress() + ", " + loadingData.getTotalMode() + ", " + loadingData.getCurrentMode() + ", currentType= " + loadingData.getCurrentType());
            ZPlanUELoadingController loadingController = e.this.loaderController.getLoadingController();
            if (loadingController == null || (loadingView = loadingController.getLoadingView()) == null) {
                return;
            }
            final e eVar = e.this;
            loadingView.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.ueloading.prepare.preparer.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.a.b(e.this, loadingData);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(ZPlanUELoaderControllerV2 loaderController) {
        super(loaderController);
        Intrinsics.checkNotNullParameter(loaderController, "loaderController");
        this.loaderController = loaderController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(e this$0, ZootopiaEnterParams enterParams, JSONObject enterJson, vd3.c callback, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(enterParams, "$enterParams");
        Intrinsics.checkNotNullParameter(enterJson, "$enterJson");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.h("prepareEngine finish success=" + z16);
        if (z16) {
            UEActivityPluginManager pluginManager = this$0.loaderController.getPluginManager();
            if (pluginManager != null) {
                pluginManager.v();
            }
            this$0.f(enterParams, enterJson, callback);
        } else {
            callback.a(new PrepareResult(enterParams, enterJson, null, new PrepareErr(1, 0, "engine init failed", 2, null), 4, null));
        }
        GameActivityThunk.CMShowEngineInitFinishListener cMShowEngineInitFinishListener = this$0.initListener;
        if (cMShowEngineInitFinishListener != null) {
            com.tencent.zplan.engine.service.c.INSTANCE.b(cMShowEngineInitFinishListener);
        }
        tx4.a aVar = this$0.engineLoadingListener;
        if (aVar != null) {
            ZPlanUEHotPatchForModProcess.f328061a.d(aVar);
        }
    }

    @Override // vd3.a, vd3.b
    public void a(final ZootopiaEnterParams enterParams, final JSONObject enterJson, final vd3.c callback) {
        Intrinsics.checkNotNullParameter(enterParams, "enterParams");
        Intrinsics.checkNotNullParameter(enterJson, "enterJson");
        Intrinsics.checkNotNullParameter(callback, "callback");
        super.a(enterParams, enterJson, callback);
        a aVar = new a();
        ZPlanUEHotPatchForModProcess.f328061a.c(aVar);
        this.engineLoadingListener = aVar;
        GameActivityThunk.CMShowEngineInitFinishListener cMShowEngineInitFinishListener = new GameActivityThunk.CMShowEngineInitFinishListener() { // from class: com.tencent.mobileqq.zootopia.ueloading.prepare.preparer.c
            @Override // com.epicgames.ue4.GameActivityThunk.CMShowEngineInitFinishListener
            public final void onEngineInitFinish(boolean z16) {
                e.l(e.this, enterParams, enterJson, callback, z16);
            }
        };
        this.initListener = cMShowEngineInitFinishListener;
        com.tencent.zplan.engine.service.c.INSTANCE.a(cMShowEngineInitFinishListener);
    }

    @Override // vd3.a
    public String e() {
        return "EnginePreparer";
    }
}
