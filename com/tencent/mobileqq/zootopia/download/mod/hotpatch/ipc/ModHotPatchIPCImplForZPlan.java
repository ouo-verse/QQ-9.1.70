package com.tencent.mobileqq.zootopia.download.mod.hotpatch.ipc;

import android.os.Looper;
import ck3.ZPlanModReqInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.zootopia.download.mod.hotpatch.ZPlanModHotPatchConfig;
import com.tencent.mobileqq.zootopia.download.mod.hotpatch.ZPlanModHotPatchManager;
import com.tencent.mobileqq.zplan.resource.api.data.mod.ZPlanResHubResultInfo;
import com.tencent.zplan.resource.api.ZPlanSceneResourceErrType;
import k74.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006*\u0001\u0011\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\u0006H\u0016R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/mod/hotpatch/ipc/ModHotPatchIPCImplForZPlan;", "Lcom/tencent/mobileqq/zootopia/download/mod/hotpatch/ipc/b;", "Lkotlin/Function0;", "", "runner", "runOnSubThread", "", "downloadSrc", "modId", "", "fromEnterMod", "needMobileDownloadTips", "downloadModHotPatchResource", "Lck3/b;", "modInfo", "Lcom/tencent/mobileqq/zootopia/download/mod/hotpatch/ZPlanModHotPatchConfig;", "getModHotPatchConfig", "com/tencent/mobileqq/zootopia/download/mod/hotpatch/ipc/ModHotPatchIPCImplForZPlan$callbackProxy$1", "callbackProxy", "Lcom/tencent/mobileqq/zootopia/download/mod/hotpatch/ipc/ModHotPatchIPCImplForZPlan$callbackProxy$1;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ModHotPatchIPCImplForZPlan implements b {
    private final ModHotPatchIPCImplForZPlan$callbackProxy$1 callbackProxy = new com.tencent.mobileqq.zootopia.download.mod.hotpatch.a() { // from class: com.tencent.mobileqq.zootopia.download.mod.hotpatch.ipc.ModHotPatchIPCImplForZPlan$callbackProxy$1
        @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
        public void checkWhenMobileDownload(final String modId, final long needDownloadSize, final vj3.c resultCallback) {
            Intrinsics.checkNotNullParameter(modId, "modId");
            Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
            ModHotPatchIPCImplForZPlan.this.runOnSubThread(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.mod.hotpatch.ipc.ModHotPatchIPCImplForZPlan$callbackProxy$1$checkWhenMobileDownload$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    ((a) i.INSTANCE.a(a.class)).checkWhenMobileDownload(modId, needDownloadSize, resultCallback);
                }
            });
        }

        @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
        public void onCheckResult(final String modId, final long checkCostTime, final boolean needDownloadHotPatch) {
            Intrinsics.checkNotNullParameter(modId, "modId");
            ModHotPatchIPCImplForZPlan.this.runOnSubThread(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.mod.hotpatch.ipc.ModHotPatchIPCImplForZPlan$callbackProxy$1$onCheckResult$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    ((a) i.INSTANCE.a(a.class)).onCheckResult(modId, checkCostTime, needDownloadHotPatch);
                }
            });
        }

        @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
        public void onDownloadError(final String modId, final ZPlanSceneResourceErrType errType, final int errorCode, final String errorMessage, final int totalTaskCount, final int failedTaskCount) {
            Intrinsics.checkNotNullParameter(modId, "modId");
            Intrinsics.checkNotNullParameter(errType, "errType");
            ModHotPatchIPCImplForZPlan.this.runOnSubThread(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.mod.hotpatch.ipc.ModHotPatchIPCImplForZPlan$callbackProxy$1$onDownloadError$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    ((a) i.INSTANCE.a(a.class)).onDownloadError(modId, errType, errorCode, errorMessage, totalTaskCount, failedTaskCount);
                }
            });
        }

        @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
        public void onDownloadProgress(final String modId, final float progress, final int totalTaskCount, final int completedTaskCount) {
            Intrinsics.checkNotNullParameter(modId, "modId");
            ModHotPatchIPCImplForZPlan.this.runOnSubThread(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.mod.hotpatch.ipc.ModHotPatchIPCImplForZPlan$callbackProxy$1$onDownloadProgress$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    ((a) i.INSTANCE.a(a.class)).onDownloadProgress(modId, progress, totalTaskCount, completedTaskCount);
                }
            });
        }

        @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
        public void onDownloadSuccess(final String modId, final ZPlanResHubResultInfo hotPatchInfo, final boolean hasRealChecked, final boolean hasRealDownloaded) {
            Intrinsics.checkNotNullParameter(modId, "modId");
            ModHotPatchIPCImplForZPlan.this.runOnSubThread(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.mod.hotpatch.ipc.ModHotPatchIPCImplForZPlan$callbackProxy$1$onDownloadSuccess$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    ((a) i.INSTANCE.a(a.class)).onDownloadSuccess(modId, hotPatchInfo, hasRealChecked, hasRealDownloaded);
                }
            });
        }

        @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
        public void onRealCheckStart(final String modId) {
            Intrinsics.checkNotNullParameter(modId, "modId");
            ModHotPatchIPCImplForZPlan.this.runOnSubThread(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.mod.hotpatch.ipc.ModHotPatchIPCImplForZPlan$callbackProxy$1$onRealCheckStart$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    ((a) i.INSTANCE.a(a.class)).onRealCheckStart(modId);
                }
            });
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public final void runOnSubThread(final Function0<Unit> runner) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.download.mod.hotpatch.ipc.c
                @Override // java.lang.Runnable
                public final void run() {
                    ModHotPatchIPCImplForZPlan.runOnSubThread$lambda$0(Function0.this);
                }
            }, 16, null, false);
        } else {
            runner.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runOnSubThread$lambda$0(Function0 runner) {
        Intrinsics.checkNotNullParameter(runner, "$runner");
        runner.invoke();
    }

    @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.ipc.b
    public void downloadModHotPatchResource(String downloadSrc, String modId, boolean fromEnterMod, boolean needMobileDownloadTips) {
        Intrinsics.checkNotNullParameter(downloadSrc, "downloadSrc");
        Intrinsics.checkNotNullParameter(modId, "modId");
        ZPlanModHotPatchManager.f328077a.t(downloadSrc, modId, this.callbackProxy, fromEnterMod, needMobileDownloadTips);
    }

    @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.ipc.b
    public ZPlanModHotPatchConfig getModHotPatchConfig(String modId) {
        Intrinsics.checkNotNullParameter(modId, "modId");
        return ZPlanModHotPatchManager.f328077a.z(modId);
    }

    public void downloadModHotPatchResource(String downloadSrc, ZPlanModReqInfo modInfo, boolean fromEnterMod, boolean needMobileDownloadTips) {
        Intrinsics.checkNotNullParameter(downloadSrc, "downloadSrc");
        Intrinsics.checkNotNullParameter(modInfo, "modInfo");
        ZPlanModHotPatchManager.f328077a.s(downloadSrc, modInfo, this.callbackProxy, fromEnterMod, needMobileDownloadTips);
    }
}
