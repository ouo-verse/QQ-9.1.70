package com.tencent.mobileqq.zootopia.download.hotpatch;

import bk3.b;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.zplan.resource.api.ZPlanSceneResourceErrType;
import cy4.ZPlanResourceBusinessData;
import cy4.c;
import hv4.f;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Y\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002J2\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u001a\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J \u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J \u0010 \u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0006\u0010!\u001a\u00020\u0006\u00a8\u0006\""}, d2 = {"com/tencent/mobileqq/zootopia/download/hotpatch/ZPlanUEHotPatchManager$downloadListenerProxy$1", "Lbk3/b;", "", "needRemove", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/zootopia/download/hotpatch/a;", "", "action", "g", "Lcom/tencent/zplan/resource/api/ZPlanSceneResourceErrType;", ImageTaskConst.ERROR_TYPE, "", "errorCode", "", "errorMessage", "totalTaskCount", "failedTaskCount", "d", "Lcy4/b;", OpenHippyInfo.EXTRA_KEY_BUSINESS_DATA, "Lcy4/c;", "statisticData", "c", "", "progress", "completedTaskCount", "f", "", "checkCostTime", "needDownloadRes", "Lhv4/f;", "originalRspInfo", "a", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanUEHotPatchManager$downloadListenerProxy$1 implements b {
    private final void g(final boolean needRemove, final Function1<? super a, Unit> action) {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.hotpatch.ZPlanUEHotPatchManager$downloadListenerProxy$1$notifyAllListeners$1
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
                Iterator it = ZPlanUEHotPatchManager.downloadListenerList.iterator();
                while (it.hasNext()) {
                    arrayList.add((a) it.next());
                }
                if (needRemove) {
                    QLog.i("ZPlanUEHotPatchManager", 1, "proxy# removeListener");
                    ZPlanUEHotPatchManager.downloadListenerList.clear();
                }
                Function1<a, Unit> function1 = action;
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    function1.invoke((a) it5.next());
                }
            }
        });
    }

    @Override // bk3.b
    public void a(long checkCostTime, boolean needDownloadRes, f originalRspInfo) {
        Intrinsics.checkNotNullParameter(originalRspInfo, "originalRspInfo");
    }

    @Override // com.tencent.zplan.resource.api.a
    public void c(final ZPlanResourceBusinessData businessData, final c statisticData) {
        Intrinsics.checkNotNullParameter(businessData, "businessData");
        g(true, new Function1<a, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.hotpatch.ZPlanUEHotPatchManager$downloadListenerProxy$1$onDownloadSuccess$1
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
                it.c(ZPlanResourceBusinessData.this, statisticData);
            }
        });
    }

    @Override // com.tencent.zplan.resource.api.a
    public void d(final ZPlanSceneResourceErrType errType, final int errorCode, final String errorMessage, final int totalTaskCount, final int failedTaskCount) {
        Intrinsics.checkNotNullParameter(errType, "errType");
        g(true, new Function1<a, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.hotpatch.ZPlanUEHotPatchManager$downloadListenerProxy$1$onDownloadError$1
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
                it.d(ZPlanSceneResourceErrType.this, errorCode, errorMessage, totalTaskCount, failedTaskCount);
            }
        });
    }

    @Override // com.tencent.zplan.resource.api.a
    public void f(final float progress, final int totalTaskCount, final int completedTaskCount) {
        g(false, new Function1<a, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.hotpatch.ZPlanUEHotPatchManager$downloadListenerProxy$1$onDownloadProgress$1
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
                it.f(progress, totalTaskCount, completedTaskCount);
            }
        });
    }

    public final void e() {
        g(true, new Function1<a, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.hotpatch.ZPlanUEHotPatchManager$downloadListenerProxy$1$onCancelDownload$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(a it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.e();
            }
        });
    }
}
