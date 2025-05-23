package com.tencent.mobileqq.soload.download;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.vas.comm.api.IWadlSoDownloader;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.g;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001.B\u001b\u0012\b\u0010*\u001a\u0004\u0018\u00010)\u0012\b\u0010+\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b,\u0010-J&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J.\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\f\u001a\u00020\bH\u0002J$\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\u0010\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0006\u0010\u0017\u001a\u00020\bJ\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0019\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u001a\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0016R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010!R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010$R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010'\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/soload/download/SoPriorityDownloader;", "Lcom/tencent/mobileqq/vip/h;", "Lcom/tencent/mobileqq/vip/g;", "task", "Lcom/tencent/mobileqq/vip/f;", "listener", "Landroid/os/Bundle;", "params", "", "f", "taskInQueue", "i", "l", "g", h.F, "j", "startDownload", "", "stopAll", "", "key", "", "cancelTask", "e", "getTask", "k", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "toString", "Lcom/tencent/mobileqq/vip/DownloaderFactory$b;", "d", "Lcom/tencent/mobileqq/vip/DownloaderFactory$b;", DownloadInfo.spKey_Config, "Ljava/util/LinkedList;", "Ljava/util/LinkedList;", "downloadQueue", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "downloadingTaskCount", "Lcom/tencent/mobileqq/soload/download/b;", "Lcom/tencent/mobileqq/soload/download/b;", "sodownLoader", "Lmqq/app/AppRuntime;", "app", "conf", "<init>", "(Lmqq/app/AppRuntime;Lcom/tencent/mobileqq/vip/DownloaderFactory$b;)V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SoPriorityDownloader implements com.tencent.mobileqq.vip.h {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private DownloaderFactory.b config;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinkedList<g> downloadQueue;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicInteger downloadingTaskCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b sodownLoader;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/soload/download/SoPriorityDownloader$a;", "", "", "MAX_QUEUE_SIZE", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.soload.download.SoPriorityDownloader$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60483);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SoPriorityDownloader(@Nullable AppRuntime appRuntime, @Nullable DownloaderFactory.b bVar) {
        b aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) bVar);
            return;
        }
        this.downloadingTaskCount = new AtomicInteger(0);
        if (appRuntime != null) {
            this.config = bVar == null ? new DownloaderFactory.b() : bVar;
            this.downloadQueue = new LinkedList<>();
        }
        if (((IWadlSoDownloader) QRoute.api(IWadlSoDownloader.class)).isWadlDownloader()) {
            aVar = new f();
        } else {
            aVar = new a();
        }
        this.sodownLoader = aVar;
    }

    private final void f(g task, com.tencent.mobileqq.vip.f listener, Bundle params) {
        int i3;
        int i16;
        LinkedList<g> linkedList = this.downloadQueue;
        LinkedList<g> linkedList2 = null;
        if (linkedList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadQueue");
            linkedList = null;
        }
        synchronized (linkedList) {
            Intrinsics.checkNotNull(task);
            g task2 = getTask(task.f313004c);
            if (task2 != null) {
                if (!task.k() && (i3 = task.f313000a) > (i16 = task2.f313000a)) {
                    QLog.e("SoLoadWidget.SoPriorityDownloader", 1, "[enqueue] update priority,old:" + i16 + ",new:" + i3 + ",key:" + task.f313004c);
                    task2.f313000a = task.f313000a;
                }
                if (task2 == task) {
                    QLog.e("SoLoadWidget.SoPriorityDownloader", 1, "[enqueue] this task alReady in queue");
                    return;
                } else {
                    i(task2, task, listener, params);
                    return;
                }
            }
            g(task, listener, params);
            task.f313028z = System.currentTimeMillis() / 1000;
            if (task.f313019q) {
                LinkedList<g> linkedList3 = this.downloadQueue;
                if (linkedList3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("downloadQueue");
                } else {
                    linkedList2 = linkedList3;
                }
                linkedList2.addFirst(task);
            } else {
                LinkedList<g> linkedList4 = this.downloadQueue;
                if (linkedList4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("downloadQueue");
                } else {
                    linkedList2 = linkedList4;
                }
                linkedList2.addLast(task);
            }
            l();
            QLog.d("SoLoadWidget.SoPriorityDownloader", 2, "[enqueue] task=" + task.f313004c);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void g(g task, com.tencent.mobileqq.vip.f listener, Bundle params) {
        task.u(listener);
        task.w(params);
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null) {
            g.a aVar = task.Z;
            if (aVar.f313030b < 0) {
                aVar.f313030b = runtime.getLongAccountUin();
            }
        }
    }

    private final g h() {
        LinkedList<g> linkedList = this.downloadQueue;
        if (linkedList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadQueue");
            linkedList = null;
        }
        synchronized (linkedList) {
            LinkedList<g> linkedList2 = this.downloadQueue;
            if (linkedList2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("downloadQueue");
                linkedList2 = null;
            }
            if (!linkedList2.isEmpty()) {
                LinkedList<g> linkedList3 = this.downloadQueue;
                if (linkedList3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("downloadQueue");
                    linkedList3 = null;
                }
                Iterator<g> it = linkedList3.iterator();
                while (it.hasNext()) {
                    g next = it.next();
                    if (!next.k()) {
                        next.l();
                        return next;
                    }
                }
            }
            return null;
        }
    }

    private final void i(g taskInQueue, g task, com.tencent.mobileqq.vip.f listener, Bundle params) {
        if (taskInQueue.f313001a0) {
            Intrinsics.checkNotNull(task);
            g(task, listener, params);
            taskInQueue.a(task);
        }
    }

    private final void j(g task) {
        this.downloadingTaskCount.addAndGet(1);
        ThreadManagerV2.postDownLoadTask(new SoPriorityDownloader$postTask$r$1(task, this), 2, null, false);
    }

    private final void l() {
        LinkedList<g> linkedList = this.downloadQueue;
        LinkedList<g> linkedList2 = null;
        if (linkedList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadQueue");
            linkedList = null;
        }
        synchronized (linkedList) {
            LinkedList<g> linkedList3 = this.downloadQueue;
            if (linkedList3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("downloadQueue");
                linkedList3 = null;
            }
            final SoPriorityDownloader$sortTask$1$1 soPriorityDownloader$sortTask$1$1 = SoPriorityDownloader$sortTask$1$1.INSTANCE;
            CollectionsKt__MutableCollectionsJVMKt.sortWith(linkedList3, new Comparator() { // from class: com.tencent.mobileqq.soload.download.d
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int m3;
                    m3 = SoPriorityDownloader.m(Function2.this, obj, obj2);
                    return m3;
                }
            });
            if (QLog.isColorLevel()) {
                LinkedList<g> linkedList4 = this.downloadQueue;
                if (linkedList4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("downloadQueue");
                } else {
                    linkedList2 = linkedList4;
                }
                Iterator<g> it = linkedList2.iterator();
                while (it.hasNext()) {
                    g next = it.next();
                    QLog.i("SoLoadWidget.SoPriorityDownloader", 2, "[sortTask] priority:" + next.f313000a + ",task:" + next.f313004c);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int m(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    @Override // com.tencent.mobileqq.vip.h
    public int cancelTask(boolean stopAll, @Nullable String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(stopAll), key)).intValue();
        }
        LinkedList<g> linkedList = this.downloadQueue;
        LinkedList<g> linkedList2 = null;
        if (linkedList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadQueue");
            linkedList = null;
        }
        synchronized (linkedList) {
            LinkedList<g> linkedList3 = this.downloadQueue;
            if (linkedList3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("downloadQueue");
                linkedList3 = null;
            }
            QLog.d("SoLoadWidget.SoPriorityDownloader", 1, "[cancelTask] stopAll=" + stopAll + ",key=" + key + ",queueSize=" + linkedList3.size());
            LinkedList<g> linkedList4 = this.downloadQueue;
            if (linkedList4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("downloadQueue");
                linkedList4 = null;
            }
            if (!linkedList4.isEmpty()) {
                if (stopAll) {
                    LinkedList<g> linkedList5 = this.downloadQueue;
                    if (linkedList5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("downloadQueue");
                        linkedList5 = null;
                    }
                    Iterator<g> it = linkedList5.iterator();
                    while (it.hasNext()) {
                        g next = it.next();
                        next.c(true);
                        next.d();
                    }
                    LinkedList<g> linkedList6 = this.downloadQueue;
                    if (linkedList6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("downloadQueue");
                    } else {
                        linkedList2 = linkedList6;
                    }
                    linkedList2.clear();
                } else if (key != null && !TextUtils.isEmpty(key)) {
                    LinkedList<g> linkedList7 = this.downloadQueue;
                    if (linkedList7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("downloadQueue");
                        linkedList7 = null;
                    }
                    Iterator<g> it5 = linkedList7.iterator();
                    Intrinsics.checkNotNullExpressionValue(it5, "downloadQueue.iterator()");
                    ArrayList arrayList = new ArrayList();
                    while (it5.hasNext()) {
                        g next2 = it5.next();
                        Intrinsics.checkNotNullExpressionValue(next2, "it.next()");
                        g gVar = next2;
                        if (Intrinsics.areEqual(key, gVar.f313004c)) {
                            if (!gVar.k()) {
                                it5.remove();
                                arrayList.add(gVar);
                            } else {
                                gVar.c(true);
                                gVar.d();
                            }
                        } else if (gVar.j() && !gVar.k()) {
                            it5.remove();
                            arrayList.add(gVar);
                        }
                    }
                    if (arrayList.size() > 0) {
                        LinkedList<g> linkedList8 = this.downloadQueue;
                        if (linkedList8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("downloadQueue");
                        } else {
                            linkedList2 = linkedList8;
                        }
                        linkedList2.removeAll(arrayList);
                    }
                } else {
                    return -1;
                }
            }
            Unit unit = Unit.INSTANCE;
            return 0;
        }
    }

    public final synchronized void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        LinkedList<g> linkedList = this.downloadQueue;
        LinkedList<g> linkedList2 = null;
        if (linkedList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadQueue");
            linkedList = null;
        }
        synchronized (linkedList) {
            LinkedList<g> linkedList3 = this.downloadQueue;
            if (linkedList3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("downloadQueue");
                linkedList3 = null;
            }
            Iterator<g> it = linkedList3.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "downloadQueue.iterator()");
            while (it.hasNext()) {
                g next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "it.next()");
                g gVar = next;
                boolean z16 = false;
                if (gVar.A > 0) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (!gVar.k() && currentTimeMillis > gVar.f313028z + gVar.A) {
                        z16 = true;
                    }
                }
                if (gVar.j() || z16) {
                    it.remove();
                    QLog.d("SoLoadWidget.SoPriorityDownloader", 1, "[doTask] remove task[" + gVar.f313004c + "], isCancel=" + gVar.j() + ", timeOut=" + z16);
                }
            }
            int i3 = this.downloadingTaskCount.get();
            LinkedList<g> linkedList4 = this.downloadQueue;
            if (linkedList4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("downloadQueue");
            } else {
                linkedList2 = linkedList4;
            }
            QLog.d("SoLoadWidget.SoPriorityDownloader", 2, "[doTask] downloadLimitCount=" + i3 + ",maxDownloadCount=3,downloadQueue size=" + linkedList2.size());
            Unit unit = Unit.INSTANCE;
        }
        while (this.downloadingTaskCount.get() < 3) {
            g h16 = h();
            if (h16 == null) {
                return;
            } else {
                j(h16);
            }
        }
    }

    @Override // com.tencent.mobileqq.vip.h
    @Nullable
    public g getTask(@Nullable String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (g) iPatchRedirector.redirect((short) 5, (Object) this, (Object) key);
        }
        LinkedList<g> linkedList = this.downloadQueue;
        if (linkedList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadQueue");
            linkedList = null;
        }
        synchronized (linkedList) {
            if (key != null) {
                LinkedList<g> linkedList2 = this.downloadQueue;
                if (linkedList2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("downloadQueue");
                    linkedList2 = null;
                }
                if (!linkedList2.isEmpty()) {
                    LinkedList<g> linkedList3 = this.downloadQueue;
                    if (linkedList3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("downloadQueue");
                        linkedList3 = null;
                    }
                    Iterator<g> it = linkedList3.iterator();
                    while (it.hasNext()) {
                        g next = it.next();
                        if (Intrinsics.areEqual(key, next.f313004c)) {
                            QLog.d("SoLoadWidget.SoPriorityDownloader", 2, "[getTask] " + key + " task find =" + next);
                            return next;
                        }
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            QLog.d("SoLoadWidget.SoPriorityDownloader", 2, "[getTask] " + key + " task not find");
            return null;
        }
    }

    public final void k(@Nullable g task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) task);
            return;
        }
        this.downloadingTaskCount.addAndGet(-1);
        LinkedList<g> linkedList = this.downloadQueue;
        LinkedList<g> linkedList2 = null;
        if (linkedList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadQueue");
            linkedList = null;
        }
        synchronized (linkedList) {
            if (task != null) {
                LinkedList<g> linkedList3 = this.downloadQueue;
                if (linkedList3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("downloadQueue");
                    linkedList3 = null;
                }
                if (!linkedList3.isEmpty()) {
                    LinkedList<g> linkedList4 = this.downloadQueue;
                    if (linkedList4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("downloadQueue");
                        linkedList4 = null;
                    }
                    if (linkedList4.contains(task)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("SoLoadWidget.SoPriorityDownloader", 2, "[removeTask] task=" + task);
                        }
                        task.d();
                        LinkedList<g> linkedList5 = this.downloadQueue;
                        if (linkedList5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("downloadQueue");
                        } else {
                            linkedList2 = linkedList5;
                        }
                        linkedList2.remove(task);
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.mobileqq.vip.h
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            cancelTask(true, null);
        }
    }

    @Override // com.tencent.mobileqq.vip.h
    public void startDownload(@Nullable g task, @Nullable com.tencent.mobileqq.vip.f listener, @Nullable Bundle params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, task, listener, params);
            return;
        }
        if (!DownloaderFactory.e(task)) {
            QLog.i("SoLoadWidget.SoPriorityDownloader", 1, "[startDownload] task is invalid:" + task);
            return;
        }
        f(task, listener, params);
        e();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        LinkedList<g> linkedList = this.downloadQueue;
        LinkedList<g> linkedList2 = null;
        if (linkedList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadQueue");
            linkedList = null;
        }
        synchronized (linkedList) {
            LinkedList<g> linkedList3 = this.downloadQueue;
            if (linkedList3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("downloadQueue");
            } else {
                linkedList2 = linkedList3;
            }
            Iterator<g> it = linkedList2.iterator();
            while (it.hasNext()) {
                g next = it.next();
                sb5.append("key=");
                sb5.append(next.f313004c);
                List<String> list = next.f313009g;
                if (list != null && list.size() > 0) {
                    sb5.append(",size=");
                    sb5.append(next.f313009g.size());
                    sb5.append(JefsClass.INDEX_URL);
                    sb5.append(next.f313009g.get(0));
                }
                sb5.append(";");
            }
            Unit unit = Unit.INSTANCE;
        }
        return "SoPriorityDownloader task url:" + ((Object) sb5);
    }
}
