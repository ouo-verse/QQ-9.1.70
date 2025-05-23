package com.tencent.mobileqq.zplan.smallhome.status;

import android.os.Looper;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.guild.aio.util.PostUtilKt;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.z1.download.data.ZootopiaResData;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager;
import com.tencent.mobileqq.zootopia.download.ah;
import com.tencent.mobileqq.zootopia.download.data.ZootopiaDownloadData;
import com.tencent.mobileqq.zootopia.download.x;
import com.tencent.mobileqq.zootopia.ipc.f;
import com.tencent.mobileqq.zplan.smallhome.event.ZPlanUEScaleEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import k74.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001)\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\f\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\tH\u0002J\u0016\u0010\u000f\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0002J\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\nJ\u0016\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0002J&\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aJ&\u0010!\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001aJ\u000e\u0010\"\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\n0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/zplan/smallhome/status/ZPlanModLoadStatusManagerForMain;", "", "", "g", "Lcom/tencent/mobileqq/zplan/smallhome/status/ZPlanModLoadStatus;", "oldStatus", "Lcom/tencent/mobileqq/zplan/smallhome/status/ZPlanModLoadStatusInfo;", "statusInfo", "j", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/zplan/smallhome/status/a;", "action", DomainData.DOMAIN_NAME, "Lkotlin/Function0;", "runner", "o", h.F, "listener", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "mapId", "", "isFromGame", "i", "f", "progress", "", "tips1", "tips2", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "version1", "version2", "version3", "l", "k", "b", "Lcom/tencent/mobileqq/zplan/smallhome/status/ZPlanModLoadStatusInfo;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "c", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listenerList", "com/tencent/mobileqq/zplan/smallhome/status/ZPlanModLoadStatusManagerForMain$modDownloadListener$1", "d", "Lcom/tencent/mobileqq/zplan/smallhome/status/ZPlanModLoadStatusManagerForMain$modDownloadListener$1;", "modDownloadListener", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanModLoadStatusManagerForMain {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static ZPlanModLoadStatusInfo statusInfo;

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanModLoadStatusManagerForMain f335706a = new ZPlanModLoadStatusManagerForMain();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<a> listenerList = new CopyOnWriteArrayList<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final ZPlanModLoadStatusManagerForMain$modDownloadListener$1 modDownloadListener = new ah() { // from class: com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatusManagerForMain$modDownloadListener$1
        private final void k(x task, String from) {
            ZPlanModLoadStatusInfo zPlanModLoadStatusInfo;
            ZPlanModLoadStatusInfo zPlanModLoadStatusInfo2;
            ZPlanModLoadStatusInfo zPlanModLoadStatusInfo3;
            ZPlanModLoadStatusInfo zPlanModLoadStatusInfo4;
            if (l(task)) {
                String id5 = task.getId();
                zPlanModLoadStatusInfo = ZPlanModLoadStatusManagerForMain.statusInfo;
                QLog.i("ZPlanModLoadStatusManagerForMain", 1, from + " - " + id5 + ", curStatus= " + (zPlanModLoadStatusInfo != null ? zPlanModLoadStatusInfo.printSimpleInfo() : null));
                zPlanModLoadStatusInfo2 = ZPlanModLoadStatusManagerForMain.statusInfo;
                if ((zPlanModLoadStatusInfo2 != null ? zPlanModLoadStatusInfo2.getStatus() : null) != ZPlanModLoadStatus.MainPakPausing) {
                    ZPlanModLoadStatusManagerForMain.f335706a.g();
                }
                ZPlanModLoadStatusManagerForMain zPlanModLoadStatusManagerForMain = ZPlanModLoadStatusManagerForMain.f335706a;
                zPlanModLoadStatusInfo3 = ZPlanModLoadStatusManagerForMain.statusInfo;
                ZPlanModLoadStatus status = zPlanModLoadStatusInfo3 != null ? zPlanModLoadStatusInfo3.getStatus() : null;
                zPlanModLoadStatusInfo4 = ZPlanModLoadStatusManagerForMain.statusInfo;
                if (zPlanModLoadStatusInfo4 == null) {
                    zPlanModLoadStatusInfo4 = new ZPlanModLoadStatusInfo(task.getId());
                }
                zPlanModLoadStatusInfo4.setStatus(ZPlanModLoadStatus.MainPakDownloading);
                zPlanModLoadStatusInfo4.setDownloadProgress(task.getCurProgress());
                zPlanModLoadStatusInfo4.setDownloadReceivedBytes(task.getCurReceivedLength());
                zPlanModLoadStatusInfo4.setDownloadTotalBytes(task.getCurTotalLength());
                zPlanModLoadStatusInfo4.setDownloadTaskUrl(task.getUrl());
                Unit unit = Unit.INSTANCE;
                zPlanModLoadStatusManagerForMain.j(status, zPlanModLoadStatusInfo4);
            }
        }

        private final boolean l(x task) {
            ZPlanModLoadStatusInfo zPlanModLoadStatusInfo;
            String id5 = task.getId();
            zPlanModLoadStatusInfo = ZPlanModLoadStatusManagerForMain.statusInfo;
            return Intrinsics.areEqual(id5, zPlanModLoadStatusInfo != null ? zPlanModLoadStatusInfo.getMapId() : null);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void b(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            super.b(task);
            k(task, "onStartDownload");
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void c(final x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            if (l(task)) {
                ZootopiaDownloadManager.f327992a.c0(task.getId(), new Function1<ZootopiaResData, Unit>() { // from class: com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatusManagerForMain$modDownloadListener$1$onComplete$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ZootopiaResData zootopiaResData) {
                        invoke2(zootopiaResData);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ZootopiaResData zootopiaResData) {
                        ZPlanModLoadStatusInfo zPlanModLoadStatusInfo;
                        ZPlanModLoadStatusInfo zPlanModLoadStatusInfo2;
                        String str;
                        ZPlanModLoadStatusManagerForMain zPlanModLoadStatusManagerForMain = ZPlanModLoadStatusManagerForMain.f335706a;
                        zPlanModLoadStatusInfo = ZPlanModLoadStatusManagerForMain.statusInfo;
                        ZPlanModLoadStatus status = zPlanModLoadStatusInfo != null ? zPlanModLoadStatusInfo.getStatus() : null;
                        zPlanModLoadStatusInfo2 = ZPlanModLoadStatusManagerForMain.statusInfo;
                        if (zPlanModLoadStatusInfo2 == null) {
                            zPlanModLoadStatusInfo2 = new ZPlanModLoadStatusInfo(x.this.getId());
                        }
                        zPlanModLoadStatusInfo2.setStatus(ZPlanModLoadStatus.MainPakDownloadFinish);
                        zPlanModLoadStatusInfo2.setDownloadProgress(1.0f);
                        if (zootopiaResData == null || (str = zootopiaResData.getVersion()) == null) {
                            str = "";
                        }
                        zPlanModLoadStatusInfo2.setMapVersion(str);
                        Unit unit = Unit.INSTANCE;
                        zPlanModLoadStatusManagerForMain.j(status, zPlanModLoadStatusInfo2);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void d(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            super.d(task);
            k(task, "onWaitingDownload");
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void e(x task) {
            ZPlanModLoadStatusInfo zPlanModLoadStatusInfo;
            ZPlanModLoadStatusInfo zPlanModLoadStatusInfo2;
            Intrinsics.checkNotNullParameter(task, "task");
            if (l(task)) {
                ZPlanModLoadStatusManagerForMain zPlanModLoadStatusManagerForMain = ZPlanModLoadStatusManagerForMain.f335706a;
                zPlanModLoadStatusInfo = ZPlanModLoadStatusManagerForMain.statusInfo;
                ZPlanModLoadStatus status = zPlanModLoadStatusInfo != null ? zPlanModLoadStatusInfo.getStatus() : null;
                zPlanModLoadStatusInfo2 = ZPlanModLoadStatusManagerForMain.statusInfo;
                if (zPlanModLoadStatusInfo2 == null) {
                    zPlanModLoadStatusInfo2 = new ZPlanModLoadStatusInfo(task.getId());
                }
                zPlanModLoadStatusInfo2.setStatus(ZPlanModLoadStatus.MainPakPausing);
                zPlanModLoadStatusInfo2.setDownloadProgress(task.getCurProgress());
                zPlanModLoadStatusInfo2.setDownloadReceivedBytes(task.getCurReceivedLength());
                zPlanModLoadStatusInfo2.setDownloadTotalBytes(task.getCurTotalLength());
                Unit unit = Unit.INSTANCE;
                zPlanModLoadStatusManagerForMain.j(status, zPlanModLoadStatusInfo2);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void f(float progress, x task) {
            ZPlanModLoadStatusInfo zPlanModLoadStatusInfo;
            ZPlanModLoadStatusInfo zPlanModLoadStatusInfo2;
            Intrinsics.checkNotNullParameter(task, "task");
            if (l(task)) {
                ZPlanModLoadStatusManagerForMain zPlanModLoadStatusManagerForMain = ZPlanModLoadStatusManagerForMain.f335706a;
                zPlanModLoadStatusInfo = ZPlanModLoadStatusManagerForMain.statusInfo;
                ZPlanModLoadStatus status = zPlanModLoadStatusInfo != null ? zPlanModLoadStatusInfo.getStatus() : null;
                zPlanModLoadStatusInfo2 = ZPlanModLoadStatusManagerForMain.statusInfo;
                if (zPlanModLoadStatusInfo2 == null) {
                    zPlanModLoadStatusInfo2 = new ZPlanModLoadStatusInfo(task.getId());
                }
                zPlanModLoadStatusInfo2.setStatus(ZPlanModLoadStatus.MainPakDownloading);
                zPlanModLoadStatusInfo2.setDownloadProgress(Math.min(progress, 0.9999f));
                zPlanModLoadStatusInfo2.setDownloadReceivedBytes(task.getCurReceivedLength());
                zPlanModLoadStatusInfo2.setDownloadTotalBytes(task.getCurTotalLength());
                Unit unit = Unit.INSTANCE;
                zPlanModLoadStatusManagerForMain.j(status, zPlanModLoadStatusInfo2);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void h(int code, x task) {
            ZPlanModLoadStatusInfo zPlanModLoadStatusInfo;
            ZPlanModLoadStatusInfo zPlanModLoadStatusInfo2;
            Intrinsics.checkNotNullParameter(task, "task");
            if (l(task)) {
                ZPlanModLoadStatusManagerForMain zPlanModLoadStatusManagerForMain = ZPlanModLoadStatusManagerForMain.f335706a;
                zPlanModLoadStatusInfo = ZPlanModLoadStatusManagerForMain.statusInfo;
                ZPlanModLoadStatus status = zPlanModLoadStatusInfo != null ? zPlanModLoadStatusInfo.getStatus() : null;
                zPlanModLoadStatusInfo2 = ZPlanModLoadStatusManagerForMain.statusInfo;
                if (zPlanModLoadStatusInfo2 == null) {
                    zPlanModLoadStatusInfo2 = new ZPlanModLoadStatusInfo(task.getId());
                }
                zPlanModLoadStatusInfo2.setStatus(ZPlanModLoadStatus.MainPakDownloadError);
                zPlanModLoadStatusInfo2.setErrCode(code);
                zPlanModLoadStatusInfo2.setErrMsg(task.getDownloadFailInfo());
                zPlanModLoadStatusInfo2.setDownloadTaskUrl(task.getUrl());
                Unit unit = Unit.INSTANCE;
                zPlanModLoadStatusManagerForMain.j(status, zPlanModLoadStatusInfo2);
                com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.u(task.getId(), task.getUrl(), code, task.getDownloadFailInfo(), 0);
            }
        }
    };

    ZPlanModLoadStatusManagerForMain() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x003d, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g() {
        ZPlanModLoadStatusInfo zPlanModLoadStatusInfo;
        Integer intOrNull;
        ZPlanModLoadStatusInfo zPlanModLoadStatusInfo2 = statusInfo;
        QLog.i("ZPlanModLoadStatusManagerForMain", 1, "clearModStatusIfNecessary, cur - " + (zPlanModLoadStatusInfo2 != null ? zPlanModLoadStatusInfo2.printSimpleInfo() : null));
        if (!((f) i.INSTANCE.a(f.class)).isFloat() || (zPlanModLoadStatusInfo = statusInfo) == null || (r0 = zPlanModLoadStatusInfo.getMapId()) == null || intOrNull == null) {
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new ZPlanUEScaleEvent(intOrNull.intValue(), "", "", 4, 0, 16, null), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(ZPlanModLoadStatus oldStatus, final ZPlanModLoadStatusInfo statusInfo2) {
        if (statusInfo2.getStatus() != oldStatus) {
            QLog.i("ZPlanModLoadStatusManagerForMain", 1, "finalUpdateStatus statusChanged, old= " + oldStatus + ", new= " + statusInfo2.getStatus());
        }
        statusInfo = statusInfo2;
        n(new Function1<a, Unit>() { // from class: com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatusManagerForMain$finalUpdateStatus$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                it.updateStatus(ZPlanModLoadStatusInfo.this);
            }
        });
        o(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatusManagerForMain$finalUpdateStatus$2
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
                ((sk3.a) i.INSTANCE.a(sk3.a.class)).updateStatus(ZPlanModLoadStatusInfo.this);
            }
        });
    }

    private final void n(final Function1<? super a, Unit> action) {
        PostUtilKt.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatusManagerForMain$notifyAllListeners$1
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
                CopyOnWriteArrayList copyOnWriteArrayList;
                ArrayList arrayList = new ArrayList();
                copyOnWriteArrayList = ZPlanModLoadStatusManagerForMain.listenerList;
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    arrayList.add((a) it.next());
                }
                Function1<a, Unit> function1 = action;
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    function1.invoke((a) it5.next());
                }
                arrayList.clear();
            }
        });
    }

    private final void o(final Function0<Unit> runner) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.smallhome.status.b
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanModLoadStatusManagerForMain.p(Function0.this);
                }
            }, 16, null, false);
        } else {
            runner.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function0 runner) {
        Intrinsics.checkNotNullParameter(runner, "$runner");
        runner.invoke();
    }

    public final void f() {
        ZPlanModLoadStatusInfo zPlanModLoadStatusInfo = statusInfo;
        QLog.i("ZPlanModLoadStatusManagerForMain", 1, "clearLoadStatus, cur= " + (zPlanModLoadStatusInfo != null ? zPlanModLoadStatusInfo.printSimpleInfo() : null) + " - " + this);
        statusInfo = null;
        ZootopiaDownloadManager.f327992a.D0(modDownloadListener);
        listenerList.clear();
        o(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatusManagerForMain$clearLoadStatus$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ((sk3.a) i.INSTANCE.a(sk3.a.class)).clearLoadStatus();
            }
        });
    }

    public final ZPlanModLoadStatusInfo h() {
        return statusInfo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x004a, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0, r2 != null ? r2.getMapId() : null) == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i(int mapId, boolean isFromGame) {
        ZPlanModLoadStatusInfo zPlanModLoadStatusInfo = statusInfo;
        QLog.i("ZPlanModLoadStatusManagerForMain", 1, "enterLoadStatus - " + mapId + ", isFromGame= " + isFromGame + ", curStatus= " + (zPlanModLoadStatusInfo != null ? zPlanModLoadStatusInfo.printSimpleInfo() : null));
        if (isFromGame) {
            String valueOf = String.valueOf(mapId);
            ZPlanModLoadStatusInfo zPlanModLoadStatusInfo2 = statusInfo;
        }
        statusInfo = new ZPlanModLoadStatusInfo(String.valueOf(mapId));
        ZPlanModLoadStatusInfo zPlanModLoadStatusInfo3 = statusInfo;
        if (zPlanModLoadStatusInfo3 != null) {
            zPlanModLoadStatusInfo3.setFromGame(isFromGame);
        }
        ZootopiaDownloadManager zootopiaDownloadManager = ZootopiaDownloadManager.f327992a;
        zootopiaDownloadManager.Y(String.valueOf(mapId), new Function1<ZootopiaDownloadData, Unit>() { // from class: com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatusManagerForMain$enterLoadStatus$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ZootopiaDownloadData zootopiaDownloadData) {
                invoke2(zootopiaDownloadData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ZootopiaDownloadData zootopiaDownloadData) {
                ZPlanModLoadStatusInfo zPlanModLoadStatusInfo4;
                ZPlanModLoadStatusInfo zPlanModLoadStatusInfo5;
                ZPlanModLoadStatusInfo zPlanModLoadStatusInfo6;
                ZPlanModLoadStatusInfo zPlanModLoadStatusInfo7;
                ZPlanModLoadStatusInfo zPlanModLoadStatusInfo8;
                if (zootopiaDownloadData != null) {
                    QLog.i("ZPlanModLoadStatusManagerForMain", 1, "enterLoadStatus - it.resData.downloadStatus = " + zootopiaDownloadData.getResData().getDownloadStatus());
                    int downloadStatus = zootopiaDownloadData.getResData().getDownloadStatus();
                    if (downloadStatus == 2) {
                        zPlanModLoadStatusInfo4 = ZPlanModLoadStatusManagerForMain.statusInfo;
                        if (zPlanModLoadStatusInfo4 != null) {
                            zPlanModLoadStatusInfo4.setStatus(ZPlanModLoadStatus.MainPakDownloading);
                        }
                        zPlanModLoadStatusInfo5 = ZPlanModLoadStatusManagerForMain.statusInfo;
                        if (zPlanModLoadStatusInfo5 != null) {
                            zPlanModLoadStatusInfo5.setDownloadProgress(zootopiaDownloadData.getResData().getProgress());
                        }
                    } else if (downloadStatus == 4) {
                        zPlanModLoadStatusInfo7 = ZPlanModLoadStatusManagerForMain.statusInfo;
                        if (zPlanModLoadStatusInfo7 != null) {
                            zPlanModLoadStatusInfo7.setStatus(ZPlanModLoadStatus.MainPakPausing);
                        }
                        zPlanModLoadStatusInfo8 = ZPlanModLoadStatusManagerForMain.statusInfo;
                        if (zPlanModLoadStatusInfo8 != null) {
                            zPlanModLoadStatusInfo8.setDownloadProgress(zootopiaDownloadData.getResData().getProgress());
                        }
                    }
                    zPlanModLoadStatusInfo6 = ZPlanModLoadStatusManagerForMain.statusInfo;
                    if (zPlanModLoadStatusInfo6 == null) {
                        return;
                    }
                    zPlanModLoadStatusInfo6.setMapVersion(zootopiaDownloadData.getResData().getVersion());
                }
            }
        });
        ZPlanModLoadStatusInfo zPlanModLoadStatusInfo4 = statusInfo;
        if (zPlanModLoadStatusInfo4 != null) {
            f335706a.j(null, zPlanModLoadStatusInfo4);
        }
        zootopiaDownloadManager.G(modDownloadListener);
    }

    public final void k(int mapId) {
        String valueOf = String.valueOf(mapId);
        ZPlanModLoadStatusInfo zPlanModLoadStatusInfo = statusInfo;
        boolean areEqual = Intrinsics.areEqual(valueOf, zPlanModLoadStatusInfo != null ? zPlanModLoadStatusInfo.getMapId() : null);
        QLog.i("ZPlanModLoadStatusManagerForMain", 1, "mapCloseLoadingView - " + areEqual + ", mapId= " + mapId);
        if (areEqual) {
            ZPlanModLoadStatusInfo zPlanModLoadStatusInfo2 = statusInfo;
            ZPlanModLoadStatus status = zPlanModLoadStatusInfo2 != null ? zPlanModLoadStatusInfo2.getStatus() : null;
            ZPlanModLoadStatusInfo zPlanModLoadStatusInfo3 = statusInfo;
            if (zPlanModLoadStatusInfo3 == null) {
                zPlanModLoadStatusInfo3 = new ZPlanModLoadStatusInfo(String.valueOf(mapId));
            }
            zPlanModLoadStatusInfo3.setStatus(ZPlanModLoadStatus.AllReady);
            Unit unit = Unit.INSTANCE;
            j(status, zPlanModLoadStatusInfo3);
        }
    }

    public final void l(int mapId, String version1, String version2, String version3) {
        Intrinsics.checkNotNullParameter(version1, "version1");
        Intrinsics.checkNotNullParameter(version2, "version2");
        Intrinsics.checkNotNullParameter(version3, "version3");
        String valueOf = String.valueOf(mapId);
        ZPlanModLoadStatusInfo zPlanModLoadStatusInfo = statusInfo;
        boolean areEqual = Intrinsics.areEqual(valueOf, zPlanModLoadStatusInfo != null ? zPlanModLoadStatusInfo.getMapId() : null);
        QLog.i("ZPlanModLoadStatusManagerForMain", 1, "mapSetGameVer - " + areEqual + ", mapId= " + mapId + ", version1= " + version1 + ", version2= " + version2 + ", version3= " + version3);
        if (areEqual) {
            ZPlanModLoadStatusInfo zPlanModLoadStatusInfo2 = statusInfo;
            ZPlanModLoadStatus status = zPlanModLoadStatusInfo2 != null ? zPlanModLoadStatusInfo2.getStatus() : null;
            ZPlanModLoadStatusInfo zPlanModLoadStatusInfo3 = statusInfo;
            if (zPlanModLoadStatusInfo3 == null) {
                zPlanModLoadStatusInfo3 = new ZPlanModLoadStatusInfo(String.valueOf(mapId));
            }
            zPlanModLoadStatusInfo3.setGameVersion1(version1);
            zPlanModLoadStatusInfo3.setGameVersion2(version2);
            zPlanModLoadStatusInfo3.setGameVersion3(version3);
            Unit unit = Unit.INSTANCE;
            j(status, zPlanModLoadStatusInfo3);
        }
    }

    public final void m(int mapId, int progress, String tips1, String tips2) {
        boolean areEqual;
        Intrinsics.checkNotNullParameter(tips1, "tips1");
        Intrinsics.checkNotNullParameter(tips2, "tips2");
        if (statusInfo == null) {
            areEqual = true;
        } else {
            String valueOf = String.valueOf(mapId);
            ZPlanModLoadStatusInfo zPlanModLoadStatusInfo = statusInfo;
            areEqual = Intrinsics.areEqual(valueOf, zPlanModLoadStatusInfo != null ? zPlanModLoadStatusInfo.getMapId() : null);
        }
        ZPlanModLoadStatusInfo zPlanModLoadStatusInfo2 = statusInfo;
        QLog.i("ZPlanModLoadStatusManagerForMain", 4, "mapSetLoadingProgress - " + areEqual + ", mapId= " + mapId + ", progress= " + progress + ", tips1= " + tips1 + ", tips2= " + tips2 + ", current: " + (zPlanModLoadStatusInfo2 != null ? zPlanModLoadStatusInfo2.getMapId() : null));
        if (areEqual) {
            ZPlanModLoadStatusInfo zPlanModLoadStatusInfo3 = statusInfo;
            ZPlanModLoadStatus status = zPlanModLoadStatusInfo3 != null ? zPlanModLoadStatusInfo3.getStatus() : null;
            ZPlanModLoadStatusInfo zPlanModLoadStatusInfo4 = statusInfo;
            if (zPlanModLoadStatusInfo4 == null) {
                zPlanModLoadStatusInfo4 = new ZPlanModLoadStatusInfo(String.valueOf(mapId));
            }
            zPlanModLoadStatusInfo4.setStatus(ZPlanModLoadStatus.InnerResDownloading);
            zPlanModLoadStatusInfo4.setDownloadProgress(progress / 100.0f);
            zPlanModLoadStatusInfo4.setDownloadTips1(tips1);
            zPlanModLoadStatusInfo4.setDownloadTips2(tips2);
            Unit unit = Unit.INSTANCE;
            j(status, zPlanModLoadStatusInfo4);
        }
    }

    public final void q(a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        QLog.i("ZPlanModLoadStatusManagerForMain", 1, "unRegisterListener - " + listener);
        listenerList.remove(listener);
    }
}
