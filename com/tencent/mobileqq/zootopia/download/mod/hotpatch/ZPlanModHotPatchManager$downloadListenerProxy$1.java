package com.tencent.mobileqq.zootopia.download.mod.hotpatch;

import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.mobileqq.zplan.resource.api.data.mod.ZPlanResHubResultInfo;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.zplan.resource.api.ZPlanSceneResourceErrType;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000O\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J.\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J*\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J \u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J:\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001aH\u0016J(\u0010#\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u001aH\u0016\u00a8\u0006$"}, d2 = {"com/tencent/mobileqq/zootopia/download/mod/hotpatch/ZPlanModHotPatchManager$downloadListenerProxy$1", "Lcom/tencent/mobileqq/zootopia/download/mod/hotpatch/a;", "", "modId", "", "needRemove", "Lkotlin/Function1;", "", "action", "a", "Lcom/tencent/mobileqq/zplan/resource/api/data/mod/ZPlanResHubResultInfo;", "hotPatchInfo", "hasRealChecked", "hasRealDownloaded", "onDownloadSuccess", "onRealCheckStart", "", "checkCostTime", "needDownloadHotPatch", "onCheckResult", "needDownloadSize", "Lvj3/c;", "resultCallback", "checkWhenMobileDownload", "Lcom/tencent/zplan/resource/api/ZPlanSceneResourceErrType;", ImageTaskConst.ERROR_TYPE, "", "errorCode", "errorMessage", "totalTaskCount", "failedTaskCount", "onDownloadError", "", "progress", "completedTaskCount", "onDownloadProgress", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanModHotPatchManager$downloadListenerProxy$1 implements a {
    private final void a(final String modId, final boolean needRemove, final Function1<? super a, Unit> action) {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.mod.hotpatch.ZPlanModHotPatchManager$downloadListenerProxy$1$notifyAllListeners$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = (ArrayList) ZPlanModHotPatchManager.c().get(modId);
                if (arrayList2 != null) {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        arrayList.add((a) it.next());
                    }
                }
                if (needRemove) {
                    ZPlanModHotPatchManager.i(ZPlanModHotPatchManager.f328077a, "proxy# " + modId + " removeListener");
                    ZPlanModHotPatchManager.c().remove(modId);
                }
                Function1<a, Unit> function1 = action;
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    function1.invoke((a) it5.next());
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
    public void checkWhenMobileDownload(final String modId, final long needDownloadSize, final vj3.c resultCallback) {
        Intrinsics.checkNotNullParameter(modId, "modId");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        b(this, modId, false, new Function1<a, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.mod.hotpatch.ZPlanModHotPatchManager$downloadListenerProxy$1$checkWhenMobileDownload$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(a it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.checkWhenMobileDownload(modId, needDownloadSize, resultCallback);
            }
        }, 2, null);
    }

    @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
    public void onCheckResult(final String modId, final long checkCostTime, final boolean needDownloadHotPatch) {
        Intrinsics.checkNotNullParameter(modId, "modId");
        b(this, modId, false, new Function1<a, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.mod.hotpatch.ZPlanModHotPatchManager$downloadListenerProxy$1$onCheckResult$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(a it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onCheckResult(modId, checkCostTime, needDownloadHotPatch);
            }
        }, 2, null);
    }

    @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
    public void onDownloadError(final String modId, final ZPlanSceneResourceErrType errType, final int errorCode, final String errorMessage, final int totalTaskCount, final int failedTaskCount) {
        Intrinsics.checkNotNullParameter(modId, "modId");
        Intrinsics.checkNotNullParameter(errType, "errType");
        a(modId, true, new Function1<a, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.mod.hotpatch.ZPlanModHotPatchManager$downloadListenerProxy$1$onDownloadError$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(a it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onDownloadError(modId, errType, errorCode, errorMessage, totalTaskCount, failedTaskCount);
            }
        });
    }

    @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
    public void onDownloadProgress(final String modId, final float progress, final int totalTaskCount, final int completedTaskCount) {
        Intrinsics.checkNotNullParameter(modId, "modId");
        b(this, modId, false, new Function1<a, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.mod.hotpatch.ZPlanModHotPatchManager$downloadListenerProxy$1$onDownloadProgress$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(a it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onDownloadProgress(modId, progress, totalTaskCount, completedTaskCount);
            }
        }, 2, null);
    }

    @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
    public void onDownloadSuccess(final String modId, final ZPlanResHubResultInfo hotPatchInfo, final boolean hasRealChecked, final boolean hasRealDownloaded) {
        Intrinsics.checkNotNullParameter(modId, "modId");
        a(modId, true, new Function1<a, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.mod.hotpatch.ZPlanModHotPatchManager$downloadListenerProxy$1$onDownloadSuccess$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(a it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onDownloadSuccess(modId, hotPatchInfo, hasRealChecked, hasRealDownloaded);
            }
        });
    }

    @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
    public void onRealCheckStart(final String modId) {
        Intrinsics.checkNotNullParameter(modId, "modId");
        b(this, modId, false, new Function1<a, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.mod.hotpatch.ZPlanModHotPatchManager$downloadListenerProxy$1$onRealCheckStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(a it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onRealCheckStart(modId);
            }
        }, 2, null);
    }

    static /* synthetic */ void b(ZPlanModHotPatchManager$downloadListenerProxy$1 zPlanModHotPatchManager$downloadListenerProxy$1, String str, boolean z16, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        zPlanModHotPatchManager$downloadListenerProxy$1.a(str, z16, function1);
    }
}
