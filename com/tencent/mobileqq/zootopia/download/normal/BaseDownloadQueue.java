package com.tencent.mobileqq.zootopia.download.normal;

import android.text.TextUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.z1.download.FileDownloadParams;
import com.tencent.mobileqq.z1.download.ZPlanFileCategory;
import com.tencent.mobileqq.zootopia.download.BaseDownloadTask;
import com.tencent.mobileqq.zootopia.download.ah;
import com.tencent.mobileqq.zootopia.download.x;
import com.tencent.mobileqq.zootopia.download.y;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0007*\u0001:\u0018\u0000 \u00102\u00020\u0001:\u0001$B\u001b\u0012\b\b\u0002\u0010&\u001a\u00020\n\u0012\b\b\u0002\u0010(\u001a\u00020\n\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u001e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015J$\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0013J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u000fJ\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\u000fJ\u000e\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 J\u000e\u0010#\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 R\u0014\u0010&\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R<\u00103\u001a*\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0.0-j\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0.`08\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001d\u00109\u001a\b\u0012\u0004\u0012\u00020\u0004048\u0006\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0014\u0010<\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010;R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010=\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/normal/BaseDownloadQueue;", "", "", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/zootopia/download/x;", "i", "j", "Lcom/tencent/mobileqq/zootopia/download/normal/g;", "queueListener", ReportConstant.COSTREPORT_PREFIX, "", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "id", "", tl.h.F, "k", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Lcom/tencent/mobileqq/z1/download/a;", "downloadParams", "Lcom/tencent/mobileqq/zootopia/download/normal/FileDownloadEntity;", "downloadEntity", "o", "needNotifyStartIfDownloading", "fileDownloadParam", "u", "task", "t", "startNext", "p", "g", "Lcom/tencent/mobileqq/zootopia/download/ah;", "listener", "f", "r", "a", "I", "maxDownloadTaskCount", "b", "orderStrategy", "Ljava/util/concurrent/atomic/AtomicInteger;", "c", "Ljava/util/concurrent/atomic/AtomicInteger;", "downloadingCount", "Ljava/util/HashMap;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/tencent/mobileqq/zootopia/download/y;", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "downloadListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "e", "Ljava/util/concurrent/CopyOnWriteArrayList;", DomainData.DOMAIN_NAME, "()Ljava/util/concurrent/CopyOnWriteArrayList;", "taskList", "com/tencent/mobileqq/zootopia/download/normal/BaseDownloadQueue$taskListener$1", "Lcom/tencent/mobileqq/zootopia/download/normal/BaseDownloadQueue$taskListener$1;", "taskListener", "Lcom/tencent/mobileqq/zootopia/download/normal/g;", "<init>", "(II)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class BaseDownloadQueue {

    /* renamed from: h */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i */
    private static int f328139i = ac3.b.INSTANCE.c().getL2nTaskLimit();

    /* renamed from: a, reason: from kotlin metadata */
    private final int maxDownloadTaskCount;

    /* renamed from: b, reason: from kotlin metadata */
    private final int orderStrategy;

    /* renamed from: c, reason: from kotlin metadata */
    private AtomicInteger downloadingCount;

    /* renamed from: d, reason: from kotlin metadata */
    private final HashMap<String, CopyOnWriteArraySet<y>> downloadListeners;

    /* renamed from: e, reason: from kotlin metadata */
    private final CopyOnWriteArrayList<x> taskList;

    /* renamed from: f, reason: from kotlin metadata */
    private final BaseDownloadQueue$taskListener$1 taskListener;

    /* renamed from: g, reason: from kotlin metadata */
    private g queueListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\n\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/normal/BaseDownloadQueue$a;", "", "", "modId", "", "maxCount", "", "b", "a", "STRATEGY_FIRST_IN_FIRST_OUT", "I", "STRATEGY_LAST_IN_FIRST_OUT", "TAG", "Ljava/lang/String;", "l2nDownloadMaxLimit", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.download.normal.BaseDownloadQueue$a */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            int i3 = BaseDownloadQueue.f328139i;
            BaseDownloadQueue.f328139i = ac3.b.INSTANCE.c().getL2nTaskLimit();
            QLog.i("Zootopia_BaseDownloadQueue", 1, "resetDefaultL2NDownloadLimit, oldValue = " + i3 + ", newValue = " + BaseDownloadQueue.f328139i);
        }

        public final void b(String modId, int maxCount) {
            Intrinsics.checkNotNullParameter(modId, "modId");
            QLog.i("Zootopia_BaseDownloadQueue", 1, "updateL2NDownloadLimitFromMod, " + modId + " -- " + maxCount + ", oldValue = " + BaseDownloadQueue.f328139i);
            BaseDownloadQueue.f328139i = Math.max(1, maxCount);
        }

        Companion() {
        }
    }

    public BaseDownloadQueue(int i3, int i16) {
        this.maxDownloadTaskCount = i3;
        this.orderStrategy = i16;
        this.downloadingCount = new AtomicInteger(0);
        this.downloadListeners = new HashMap<>();
        this.taskList = new CopyOnWriteArrayList<>();
        this.taskListener = new BaseDownloadQueue$taskListener$1(this);
    }

    private final x i() {
        boolean equals$default;
        CopyOnWriteArrayList<x> copyOnWriteArrayList = this.taskList;
        ArrayList<x> arrayList = new ArrayList();
        Iterator<T> it = copyOnWriteArrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((x) next).getDownloadStatus() == 2) {
                arrayList.add(next);
            }
        }
        x xVar = null;
        x xVar2 = null;
        for (x xVar3 : arrayList) {
            if (xVar3 instanceof f) {
                f fVar = (f) xVar3;
                int category = fVar.getCategory();
                FileDownloadParams fullDownloadParams = fVar.getFullDownloadParams();
                String srcBizScene = fullDownloadParams != null ? fullDownloadParams.getSrcBizScene() : null;
                FileDownloadParams fullDownloadParams2 = fVar.getFullDownloadParams();
                String subCategoryName = fullDownloadParams2 != null ? fullDownloadParams2.getSubCategoryName() : null;
                String b16 = com.tencent.mobileqq.zootopia.download.file.a.f328049a.b(category);
                if (!Intrinsics.areEqual("ZPlanResDownloadReq", subCategoryName) && ZPlanFileCategory.RES_HUB.getValue() != category && !TextUtils.isEmpty(srcBizScene)) {
                    equals$default = StringsKt__StringsJVMKt.equals$default(srcBizScene, b16, false, 2, null);
                    if (!equals$default) {
                        if (category != ZPlanFileCategory.LuaDownload.getValue()) {
                            xVar = xVar3;
                        } else {
                            xVar2 = xVar3;
                        }
                    }
                }
            }
        }
        x xVar4 = xVar == null ? xVar2 : xVar;
        QLog.i("Zootopia_BaseDownloadQueue", 1, "findLowPriorityDownloadingTaskToPause-- canPauseTask=" + xVar4 + ", invalidSceneTaskNotL2n=" + xVar + ", invalidSceneTaskL2n=" + xVar2);
        return xVar4;
    }

    private final x j() {
        String str;
        CopyOnWriteArrayList<x> copyOnWriteArrayList = this.taskList;
        List<x> arrayList = new ArrayList();
        Iterator<T> it = copyOnWriteArrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((x) next).getDownloadStatus() == 1) {
                arrayList.add(next);
            }
        }
        if ((!arrayList.isEmpty()) && this.orderStrategy == 2) {
            QLog.i("Zootopia_BaseDownloadQueue", 1, "foundNextWaitingTask - LAST_IN_FIRST_OUT");
            arrayList = CollectionsKt__ReversedViewsKt.asReversed(arrayList);
        }
        x xVar = null;
        x xVar2 = null;
        x xVar3 = null;
        x xVar4 = null;
        for (x xVar5 : arrayList) {
            if (xVar5 instanceof f) {
                f fVar = (f) xVar5;
                int category = fVar.getCategory();
                FileDownloadParams fullDownloadParams = fVar.getFullDownloadParams();
                if (fullDownloadParams == null || (str = fullDownloadParams.getSrcBizScene()) == null) {
                    str = "";
                }
                String b16 = com.tencent.mobileqq.zootopia.download.file.a.f328049a.b(category);
                boolean z16 = category == ZPlanFileCategory.LuaDownload.getValue();
                if (Intrinsics.areEqual(str, b16)) {
                    if (z16) {
                        if (xVar == null) {
                            xVar = xVar5;
                        }
                    } else if (xVar2 == null) {
                        xVar2 = xVar5;
                    }
                } else if (z16) {
                    if (xVar4 == null) {
                        xVar4 = xVar5;
                    }
                } else if (xVar3 == null) {
                    xVar3 = xVar5;
                }
            } else if (xVar3 == null) {
                xVar3 = xVar5;
            }
        }
        if (xVar == null) {
            xVar = xVar2 == null ? xVar4 == null ? xVar3 : xVar4 : xVar2;
        }
        QLog.i("Zootopia_BaseDownloadQueue", 1, "waitingList.size = " + arrayList.size() + ", foundNextWaitingTask - " + xVar);
        return xVar;
    }

    public final synchronized void x() {
        x j3 = j();
        if (j3 != null) {
            QLog.i("Zootopia_BaseDownloadQueue", 1, j3.getId() + " as nextTask to start");
            this.downloadingCount.incrementAndGet();
            j3.startDownload();
            return;
        }
        g gVar = this.queueListener;
        if (gVar != null) {
            gVar.onDownloadingCountChanged(this.downloadingCount.get());
        }
        QLog.i("Zootopia_BaseDownloadQueue", 1, "allTask " + this.taskList.size() + " but no waiting task");
    }

    public final synchronized void f(ah listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArraySet<y> copyOnWriteArraySet = this.downloadListeners.get(listener.getId());
        if (copyOnWriteArraySet == null) {
            copyOnWriteArraySet = new CopyOnWriteArraySet<>();
            this.downloadListeners.put(listener.getId(), copyOnWriteArraySet);
        }
        if (!copyOnWriteArraySet.contains(listener)) {
            copyOnWriteArraySet.add(listener);
        }
    }

    public final synchronized void g(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        x k3 = k(id5);
        QLog.i("Zootopia_BaseDownloadQueue", 1, "cancel " + id5 + " status " + (k3 != null ? Integer.valueOf(k3.getDownloadStatus()) : null));
        if (k3 != null) {
            if (k3.getDownloadStatus() == 2) {
                this.downloadingCount.decrementAndGet();
                x();
            }
            k3.delete();
            this.taskList.remove(k3);
        }
    }

    public final boolean h(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        return k(id5) != null;
    }

    public final x k(String id5) {
        Object obj;
        Intrinsics.checkNotNullParameter(id5, "id");
        Iterator<T> it = this.taskList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((x) obj).getId(), id5)) {
                break;
            }
        }
        return (x) obj;
    }

    public final int l() {
        return this.downloadingCount.get();
    }

    /* renamed from: m, reason: from getter */
    public final int getMaxDownloadTaskCount() {
        return this.maxDownloadTaskCount;
    }

    public final CopyOnWriteArrayList<x> n() {
        return this.taskList;
    }

    public final void o(String r26, FileDownloadParams downloadParams, FileDownloadEntity downloadEntity) {
        Intrinsics.checkNotNullParameter(r26, "taskId");
        Intrinsics.checkNotNullParameter(downloadParams, "downloadParams");
        Intrinsics.checkNotNullParameter(downloadEntity, "downloadEntity");
        x k3 = k(r26);
        if (k3 == null) {
            k3 = com.tencent.mobileqq.zootopia.download.c.f328029a.g(downloadParams, downloadEntity);
        }
        this.taskListener.k(k3);
    }

    public final synchronized void p(String id5, boolean startNext) {
        Intrinsics.checkNotNullParameter(id5, "id");
        QLog.i("Zootopia_BaseDownloadQueue", 1, "pause " + id5 + " downloading " + this.downloadingCount.get());
        x k3 = k(id5);
        if (k3 != null) {
            if (!k3.canPause()) {
                QLog.e("Zootopia_BaseDownloadQueue", 1, id5 + " cant pause status " + k3.getDownloadStatus());
                return;
            }
            int downloadStatus = k3.getDownloadStatus();
            k3.pause();
            if (downloadStatus != 2) {
                return;
            }
            this.downloadingCount.decrementAndGet();
            if (startNext) {
                x();
            } else {
                g gVar = this.queueListener;
                if (gVar != null) {
                    gVar.onDownloadingCountChanged(this.downloadingCount.get());
                }
            }
        }
    }

    public final synchronized void r(ah listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArraySet<y> copyOnWriteArraySet = this.downloadListeners.get(listener.getId());
        if (copyOnWriteArraySet != null) {
            copyOnWriteArraySet.remove(listener);
        }
    }

    public final void s(g queueListener) {
        Intrinsics.checkNotNullParameter(queueListener, "queueListener");
        this.queueListener = queueListener;
    }

    public final synchronized void t(x task, boolean needNotifyStartIfDownloading) {
        int maxDownloadTaskCount;
        Intrinsics.checkNotNullParameter(task, "task");
        if (!task.c()) {
            String str = task.getId() + " cant startDownload status " + task.getDownloadStatus() + ", " + needNotifyStartIfDownloading;
            if (task.getDownloadStatus() == 5) {
                QLog.e("Zootopia_BaseDownloadQueue", 1, str + ", STATUS_COMPLETE - notifyAllOnComplete!");
                this.taskListener.k(task);
            } else if (task.getDownloadStatus() == 2 && needNotifyStartIfDownloading) {
                QLog.e("Zootopia_BaseDownloadQueue", 1, str + ", STATUS_DOWNLOADING - needNotifyStartIfDownloading! maybe silentDownload");
                this.taskListener.b(task);
                g gVar = this.queueListener;
                if (gVar != null) {
                    gVar.onDownloadingCountChanged(this.downloadingCount.get());
                }
            } else {
                QLog.e("Zootopia_BaseDownloadQueue", 1, str + ", DEFAULT!");
            }
            return;
        }
        this.taskList.addIfAbsent(task);
        task.h(this.taskListener);
        task.d();
        boolean n3 = task.n();
        if (n3) {
            maxDownloadTaskCount = f328139i;
        } else {
            maxDownloadTaskCount = getMaxDownloadTaskCount();
        }
        if (this.downloadingCount.get() < maxDownloadTaskCount) {
            int incrementAndGet = this.downloadingCount.incrementAndGet();
            QLog.i("Zootopia_BaseDownloadQueue", 1, n3 + " - real startDownload " + task.getId() + " downloadingCount " + incrementAndGet + ", maxLimit " + maxDownloadTaskCount + " - " + task);
            task.startDownload();
            g gVar2 = this.queueListener;
            if (gVar2 != null) {
                gVar2.onDownloadingCountChanged(incrementAndGet);
            }
        } else {
            String str2 = n3 + " - " + task.getId() + " wait downloadingCount " + this.downloadingCount.get() + ", maxLimit " + maxDownloadTaskCount;
            x i3 = i();
            if (i3 != null) {
                QLog.e("Zootopia_BaseDownloadQueue", 1, str2 + ", canPauseTask - " + i3 + ", insert current!! - " + task);
                i3.pause();
                i3.f();
                task.startDownload();
            } else {
                QLog.i("Zootopia_BaseDownloadQueue", 1, str2 + ", waitDownload - " + task);
                task.f();
            }
        }
    }

    public final synchronized boolean u(String id5, boolean needNotifyStartIfDownloading, FileDownloadParams fileDownloadParam) {
        Intrinsics.checkNotNullParameter(id5, "id");
        x k3 = k(id5);
        if (k3 == null) {
            QLog.e("Zootopia_BaseDownloadQueue", 1, id5 + " start error not contains");
            return false;
        }
        if (fileDownloadParam != null) {
            BaseDownloadTask baseDownloadTask = k3 instanceof BaseDownloadTask ? (BaseDownloadTask) k3 : null;
            if (baseDownloadTask != null) {
                Map<String, String> D = baseDownloadTask.D();
                Integer valueOf = D != null ? Integer.valueOf(D.size()) : null;
                Map<String, String> d16 = fileDownloadParam.d();
                if (!Intrinsics.areEqual(valueOf, d16 != null ? Integer.valueOf(d16.size()) : null)) {
                    QLog.e("Zootopia_BaseDownloadQueue", 1, id5 + ", updateDownloadHeaders, old=" + baseDownloadTask.D() + " , new= " + fileDownloadParam.d());
                }
                baseDownloadTask.Q(fileDownloadParam.d());
            }
        }
        t(k3, needNotifyStartIfDownloading);
        return true;
    }

    public static /* synthetic */ void q(BaseDownloadQueue baseDownloadQueue, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        baseDownloadQueue.p(str, z16);
    }

    public static /* synthetic */ void v(BaseDownloadQueue baseDownloadQueue, x xVar, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        baseDownloadQueue.t(xVar, z16);
    }

    public /* synthetic */ BaseDownloadQueue(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? ac3.b.INSTANCE.c().getOtherTaskLimit() : i3, (i17 & 2) != 0 ? 1 : i16);
    }

    public static /* synthetic */ boolean w(BaseDownloadQueue baseDownloadQueue, String str, boolean z16, FileDownloadParams fileDownloadParams, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            fileDownloadParams = null;
        }
        return baseDownloadQueue.u(str, z16, fileDownloadParams);
    }
}
