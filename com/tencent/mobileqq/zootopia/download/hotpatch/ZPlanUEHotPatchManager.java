package com.tencent.mobileqq.zootopia.download.hotpatch;

import bk3.a;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.resource.api.ZPlanSceneResourceErrType;
import com.tencent.zplan.resource.api.a;
import cy4.ZPlanResourceBusinessData;
import cy4.c;
import hv4.f;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\b\u0007*\u0001\u0016\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\t\u001a\u00020\u0004R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/hotpatch/ZPlanUEHotPatchManager;", "", "Lcom/tencent/mobileqq/zootopia/download/hotpatch/a;", "listener", "", "e", h.F, "", "g", "f", "Ljava/util/concurrent/CopyOnWriteArrayList;", "b", "Ljava/util/concurrent/CopyOnWriteArrayList;", "downloadListenerList", "Lcom/tencent/mobileqq/zootopia/download/hotpatch/ZPlanUEHotPatchManager$ZPlanUEHotPatchStatus;", "c", "Lcom/tencent/mobileqq/zootopia/download/hotpatch/ZPlanUEHotPatchManager$ZPlanUEHotPatchStatus;", "hotPatchStatus", "", "d", "J", "lastFinishTime", "com/tencent/mobileqq/zootopia/download/hotpatch/ZPlanUEHotPatchManager$downloadListenerProxy$1", "Lcom/tencent/mobileqq/zootopia/download/hotpatch/ZPlanUEHotPatchManager$downloadListenerProxy$1;", "downloadListenerProxy", "<init>", "()V", "ZPlanUEHotPatchStatus", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanUEHotPatchManager {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile ZPlanUEHotPatchStatus hotPatchStatus;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static volatile long lastFinishTime;

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanUEHotPatchManager f328056a = new ZPlanUEHotPatchManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<com.tencent.mobileqq.zootopia.download.hotpatch.a> downloadListenerList = new CopyOnWriteArrayList<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final ZPlanUEHotPatchManager$downloadListenerProxy$1 downloadListenerProxy = new ZPlanUEHotPatchManager$downloadListenerProxy$1();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/hotpatch/ZPlanUEHotPatchManager$ZPlanUEHotPatchStatus;", "", "(Ljava/lang/String;I)V", "Querying", "Downloading", "Finish", "Error", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public enum ZPlanUEHotPatchStatus {
        Querying,
        Downloading,
        Finish,
        Error
    }

    @Metadata(d1 = {"\u0000M\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J2\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u001a\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016\u00a8\u0006\u001c"}, d2 = {"com/tencent/mobileqq/zootopia/download/hotpatch/ZPlanUEHotPatchManager$a", "Lbk3/b;", "", "checkCostTime", "", "needDownloadRes", "Lhv4/f;", "originalRspInfo", "", "a", "", "progress", "", "totalTaskCount", "completedTaskCount", "f", "Lcom/tencent/zplan/resource/api/ZPlanSceneResourceErrType;", ImageTaskConst.ERROR_TYPE, "errorCode", "", "errorMessage", "failedTaskCount", "d", "Lcy4/b;", OpenHippyInfo.EXTRA_KEY_BUSINESS_DATA, "Lcy4/c;", "statisticData", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements bk3.b {
        a() {
        }

        @Override // bk3.b
        public void a(long checkCostTime, boolean needDownloadRes, f originalRspInfo) {
            Intrinsics.checkNotNullParameter(originalRspInfo, "originalRspInfo");
            QLog.i("ZPlanUEHotPatchManager", 1, "onDownloadInfoCheckResult - " + needDownloadRes);
            if (needDownloadRes) {
                ZPlanUEHotPatchManager zPlanUEHotPatchManager = ZPlanUEHotPatchManager.f328056a;
                ZPlanUEHotPatchManager.hotPatchStatus = ZPlanUEHotPatchStatus.Downloading;
            }
            ZPlanUEHotPatchManager.downloadListenerProxy.a(checkCostTime, needDownloadRes, originalRspInfo);
        }

        @Override // com.tencent.zplan.resource.api.a
        public void c(ZPlanResourceBusinessData businessData, c statisticData) {
            Intrinsics.checkNotNullParameter(businessData, "businessData");
            QLog.i("ZPlanUEHotPatchManager", 1, "onDownloadSuccess");
            ZPlanUEHotPatchManager zPlanUEHotPatchManager = ZPlanUEHotPatchManager.f328056a;
            ZPlanUEHotPatchManager.hotPatchStatus = ZPlanUEHotPatchStatus.Finish;
            ZPlanUEHotPatchManager.lastFinishTime = System.currentTimeMillis();
            ZPlanUEHotPatchManager.downloadListenerProxy.c(businessData, statisticData);
        }

        @Override // com.tencent.zplan.resource.api.a
        public void d(ZPlanSceneResourceErrType errType, int errorCode, String errorMessage, int totalTaskCount, int failedTaskCount) {
            Intrinsics.checkNotNullParameter(errType, "errType");
            QLog.e("ZPlanUEHotPatchManager", 1, "onDownloadError - " + errorCode + " - " + errorMessage);
            ZPlanUEHotPatchManager zPlanUEHotPatchManager = ZPlanUEHotPatchManager.f328056a;
            ZPlanUEHotPatchManager.hotPatchStatus = ZPlanUEHotPatchStatus.Error;
            ZPlanUEHotPatchManager.lastFinishTime = 0L;
            if (errorCode == -99001) {
                QLog.e("ZPlanUEHotPatchManager", 1, "download canceled");
                ZPlanUEHotPatchManager.downloadListenerProxy.e();
            } else {
                ZPlanUEHotPatchManager.downloadListenerProxy.d(errType, errorCode, errorMessage, totalTaskCount, failedTaskCount);
            }
        }

        @Override // com.tencent.zplan.resource.api.a
        public void f(float progress, int totalTaskCount, int completedTaskCount) {
            ZPlanUEHotPatchManager.downloadListenerProxy.f(progress, totalTaskCount, completedTaskCount);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zootopia/download/hotpatch/ZPlanUEHotPatchManager$b", "Lvj3/b;", "", "a", "", "needDownloadSize", "Lvj3/c;", "resultCallback", "", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements vj3.b {
        b() {
        }

        @Override // vj3.b
        public boolean a() {
            return true;
        }

        @Override // vj3.b
        public void b(long needDownloadSize, vj3.c resultCallback) {
            Object lastOrNull;
            Unit unit;
            Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
            QLog.e("ZPlanUEHotPatchManager", 1, "checkWhenMobileDownload, needDownloadSize= " + needDownloadSize + ", listenerSize= " + ZPlanUEHotPatchManager.downloadListenerList.size());
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) ZPlanUEHotPatchManager.downloadListenerList);
            com.tencent.mobileqq.zootopia.download.hotpatch.a aVar = (com.tencent.mobileqq.zootopia.download.hotpatch.a) lastOrNull;
            if (aVar != null) {
                aVar.b(needDownloadSize, resultCallback);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                QLog.i("ZPlanUEHotPatchManager", 1, "checkWhenMobileDownload, default");
                resultCallback.a(true);
            }
        }
    }

    ZPlanUEHotPatchManager() {
    }

    private final void h() {
        QLog.i("ZPlanUEHotPatchManager", 1, "realDownloadHotPatch --- hotPatchStatus = " + hotPatchStatus);
        hotPatchStatus = ZPlanUEHotPatchStatus.Querying;
        ((bk3.a) vb3.a.f441346a.a(bk3.a.class)).B(new a(), new b(), true);
    }

    public final void f() {
        QLog.e("ZPlanUEHotPatchManager", 1, "cancelDownloadHotPatch - hotPatchStatus = " + hotPatchStatus);
        boolean a16 = a.C0132a.a((bk3.a) vb3.a.f441346a.a(bk3.a.class), 1, null, 2, null);
        hotPatchStatus = ZPlanUEHotPatchStatus.Error;
        QLog.i("ZPlanUEHotPatchManager", 1, "cancelDownloadHotPatch - " + a16);
        downloadListenerProxy.e();
    }

    public final boolean g(com.tencent.mobileqq.zootopia.download.hotpatch.a listener) {
        QLog.i("ZPlanUEHotPatchManager", 1, "checkHotPatch --- hotPatchStatus= " + hotPatchStatus + ", lastFinishTime= " + lastFinishTime + ", " + listener);
        boolean z16 = hotPatchStatus == ZPlanUEHotPatchStatus.Querying || hotPatchStatus == ZPlanUEHotPatchStatus.Downloading;
        if (hotPatchStatus == ZPlanUEHotPatchStatus.Finish && lastFinishTime > 0 && System.currentTimeMillis() - lastFinishTime < 3600000) {
            QLog.i("ZPlanUEHotPatchManager", 1, "direct callbackSuccess");
            if (listener != null) {
                a.C10071a.b(listener, ZPlanResourceBusinessData.INSTANCE.a(), null, 2, null);
            }
        } else if (z16) {
            e(listener);
        } else {
            e(listener);
            h();
        }
        return z16;
    }

    private final void e(com.tencent.mobileqq.zootopia.download.hotpatch.a listener) {
        if (listener != null) {
            CopyOnWriteArrayList<com.tencent.mobileqq.zootopia.download.hotpatch.a> copyOnWriteArrayList = downloadListenerList;
            if (copyOnWriteArrayList.contains(listener)) {
                return;
            }
            copyOnWriteArrayList.add(listener);
        }
    }
}
