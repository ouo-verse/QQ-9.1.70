package com.tencent.mobileqq.zplan.download.impl.manager;

import ac3.b;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zootopia.download.ah;
import com.tencent.mobileqq.zootopia.download.normal.BaseDownloadQueue;
import com.tencent.mobileqq.zootopia.download.v;
import com.tencent.mobileqq.zootopia.download.x;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import zg3.MultiDownloadParam;
import zg3.ZPlanDownloadParam;
import zg3.c;

@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001(\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u001a\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u001e\u0010\u0011\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005J\u0014\u0010\u0013\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u000e\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0005J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0004J\u000e\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\nJ\u000e\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0005J\u000e\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0005R\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R$\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00140$j\b\u0012\u0004\u0012\u00020\u0014`%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010&R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/zplan/download/impl/manager/ZPlanDownloadManager;", "", "", "totalFileSize", "", "Lzg3/b;", "downloadParmaList", "", "d", "downloadParams", "", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "outerParams", "Lzg3/c;", "cacheTask", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "e", "Lcom/tencent/mobileqq/zootopia/download/ah;", "listener", "c", "l", "g", "Lcom/tencent/mobileqq/zootopia/download/x;", "k", "id", "f", "data", "i", h.F, "Lcom/tencent/mobileqq/zootopia/download/normal/BaseDownloadQueue;", "b", "Lcom/tencent/mobileqq/zootopia/download/normal/BaseDownloadQueue;", "downloadQueue", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "downloadListeners", "com/tencent/mobileqq/zplan/download/impl/manager/ZPlanDownloadManager$taskListener$1", "Lcom/tencent/mobileqq/zplan/download/impl/manager/ZPlanDownloadManager$taskListener$1;", "taskListener", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanDownloadManager {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanDownloadManager f332806a = new ZPlanDownloadManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final BaseDownloadQueue downloadQueue;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ArrayList<ah> downloadListeners;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final ZPlanDownloadManager$taskListener$1 taskListener;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.tencent.mobileqq.zplan.download.impl.manager.ZPlanDownloadManager$taskListener$1, com.tencent.mobileqq.zootopia.download.ah] */
    static {
        BaseDownloadQueue baseDownloadQueue = new BaseDownloadQueue(b.INSTANCE.c().getOtherTaskLimit(), 0, 2, null);
        downloadQueue = baseDownloadQueue;
        downloadListeners = new ArrayList<>();
        ?? r16 = new ah() { // from class: com.tencent.mobileqq.zplan.download.impl.manager.ZPlanDownloadManager$taskListener$1
            private final void k(Function1<? super ah, Unit> action) {
                ArrayList arrayList;
                ArrayList arrayList2 = new ArrayList();
                arrayList = ZPlanDownloadManager.downloadListeners;
                arrayList2.addAll(arrayList);
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    action.invoke((ah) it.next());
                }
            }

            @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
            public void a(x task) {
                Intrinsics.checkNotNullParameter(task, "task");
                super.a(task);
                QLog.i("ZPlanDownloadManager", 1, task.getId() + " onDecompress");
            }

            @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
            public void b(final x task) {
                Intrinsics.checkNotNullParameter(task, "task");
                QLog.i("ZPlanDownloadManager", 1, task.getId() + " onStartDownload");
                k(new Function1<ah, Unit>() { // from class: com.tencent.mobileqq.zplan.download.impl.manager.ZPlanDownloadManager$taskListener$1$onStartDownload$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ah ahVar) {
                        invoke2(ahVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ah it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.b(x.this);
                    }
                });
            }

            @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
            public void c(final x task) {
                Intrinsics.checkNotNullParameter(task, "task");
                QLog.i("ZPlanDownloadManager", 1, task.getId() + " complete");
                Pair<Integer, Integer> index = task.getIndex();
                int intValue = index != null ? index.getFirst().intValue() : 0;
                int intValue2 = index != null ? index.getSecond().intValue() : 0;
                if (intValue <= 0 || intValue2 <= 0) {
                    k(new Function1<ah, Unit>() { // from class: com.tencent.mobileqq.zplan.download.impl.manager.ZPlanDownloadManager$taskListener$1$onComplete$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ah ahVar) {
                            invoke2(ahVar);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(ah it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            it.c(x.this);
                        }
                    });
                } else if (intValue == intValue2) {
                    k(new Function1<ah, Unit>() { // from class: com.tencent.mobileqq.zplan.download.impl.manager.ZPlanDownloadManager$taskListener$1$onComplete$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ah ahVar) {
                            invoke2(ahVar);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(ah it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            it.c(x.this);
                        }
                    });
                }
            }

            @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
            public void d(final x task) {
                Intrinsics.checkNotNullParameter(task, "task");
                QLog.i("ZPlanDownloadManager", 4, task.getId() + " onWaitingDownload");
                k(new Function1<ah, Unit>() { // from class: com.tencent.mobileqq.zplan.download.impl.manager.ZPlanDownloadManager$taskListener$1$onWaitingDownload$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ah ahVar) {
                        invoke2(ahVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ah it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.d(x.this);
                    }
                });
            }

            @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
            public void e(final x task) {
                Intrinsics.checkNotNullParameter(task, "task");
                QLog.i("ZPlanDownloadManager", 4, task.getId() + " onPause");
                k(new Function1<ah, Unit>() { // from class: com.tencent.mobileqq.zplan.download.impl.manager.ZPlanDownloadManager$taskListener$1$onPause$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ah ahVar) {
                        invoke2(ahVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ah it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.e(x.this);
                    }
                });
            }

            @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
            public void f(final float progress, final x task) {
                Intrinsics.checkNotNullParameter(task, "task");
                QLog.i("ZPlanDownloadManager", 4, task.getId() + " onProgress :: process == " + progress);
                k(new Function1<ah, Unit>() { // from class: com.tencent.mobileqq.zplan.download.impl.manager.ZPlanDownloadManager$taskListener$1$onProgress$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ah ahVar) {
                        invoke2(ahVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ah it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.f(x.this.k(progress), x.this);
                    }
                });
            }

            @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
            public void h(final int code, final x task) {
                Intrinsics.checkNotNullParameter(task, "task");
                QLog.e("ZPlanDownloadManager", 1, task.getId() + " onFailed " + code);
                k(new Function1<ah, Unit>() { // from class: com.tencent.mobileqq.zplan.download.impl.manager.ZPlanDownloadManager$taskListener$1$onFailed$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ah ahVar) {
                        invoke2(ahVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ah it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.h(code, task);
                    }
                });
            }

            @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
            public void i(final long size, final x task) {
                Intrinsics.checkNotNullParameter(task, "task");
                QLog.i("ZPlanDownloadManager", 4, task.getId() + " onDetectedSize :: size == " + size);
                k(new Function1<ah, Unit>() { // from class: com.tencent.mobileqq.zplan.download.impl.manager.ZPlanDownloadManager$taskListener$1$onDetectedSize$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ah ahVar) {
                        invoke2(ahVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ah it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.i(size, task);
                    }
                });
            }
        };
        taskListener = r16;
        baseDownloadQueue.f(r16);
    }

    ZPlanDownloadManager() {
    }

    private final String j(ZPlanDownloadParam downloadParams) {
        return downloadParams.getCategory() + downloadParams.getUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(ZPlanDownloadParam downloadParams) {
        Intrinsics.checkNotNullParameter(downloadParams, "$downloadParams");
        QLog.i("ZPlanDownloadManager", 1, "real :: mapid == " + downloadParams.getUrl());
        f332806a.q(downloadParams);
    }

    private final void q(ZPlanDownloadParam downloadParams) {
        String url = downloadParams.getUrl();
        QLog.i("ZPlanDownloadManager", 1, "try startDownload " + url);
        String j3 = j(downloadParams);
        BaseDownloadQueue baseDownloadQueue = downloadQueue;
        if (baseDownloadQueue.h(j3)) {
            x k3 = baseDownloadQueue.k(j3);
            r(downloadParams, k3 instanceof c ? (c) k3 : null);
            QLog.i("ZPlanDownloadManager", 1, "startDownload by taskId , taskId == " + j3 + " , url == " + url);
            BaseDownloadQueue.w(baseDownloadQueue, j3, false, null, 6, null);
            return;
        }
        c g16 = g(downloadParams);
        QLog.i("ZPlanDownloadManager", 1, "startDownload by new task ,taskId == " + j3 + " , url == " + url);
        BaseDownloadQueue.v(baseDownloadQueue, g16, false, 2, null);
    }

    private final void r(ZPlanDownloadParam outerParams, c cacheTask) {
        QLog.i("ZPlanDownloadManager", 1, "updateCacheTaskParam outerParams:" + outerParams + ", cacheTask:" + cacheTask);
        if (cacheTask == null) {
            return;
        }
        cacheTask.a0(outerParams.getMultiDownloadParam());
    }

    public final void c(ah listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        downloadListeners.add(listener);
    }

    public final long e(List<ZPlanDownloadParam> downloadParmaList) {
        Intrinsics.checkNotNullParameter(downloadParmaList, "downloadParmaList");
        Iterator<T> it = downloadParmaList.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            j3 += ((ZPlanDownloadParam) it.next()).getFileSize();
        }
        return j3;
    }

    public final void f(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        downloadQueue.g(id5);
    }

    public final c g(ZPlanDownloadParam downloadParams) {
        Intrinsics.checkNotNullParameter(downloadParams, "downloadParams");
        return new c(downloadParams.getCategory() + downloadParams.getUrl(), downloadParams.getCategory(), downloadParams.getUrl(), i(downloadParams), h(downloadParams), downloadParams.getFileSize(), downloadParams.getMultiDownloadParam());
    }

    public final String h(ZPlanDownloadParam data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return data.getCategory() + ".zip";
    }

    public final String i(ZPlanDownloadParam data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return v.f328299a.c() + File.separator + data.getCategory();
    }

    public final List<x> k() {
        return downloadQueue.n();
    }

    public final void l(ah listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        downloadListeners.remove(listener);
    }

    public final void m(List<ZPlanDownloadParam> downloadParmaList, long totalFileSize) {
        Intrinsics.checkNotNullParameter(downloadParmaList, "downloadParmaList");
        if (downloadParmaList.size() > 1) {
            d(totalFileSize, downloadParmaList);
        }
        Iterator<T> it = downloadParmaList.iterator();
        while (it.hasNext()) {
            f332806a.n((ZPlanDownloadParam) it.next());
        }
    }

    public final void n(final ZPlanDownloadParam downloadParams) {
        Intrinsics.checkNotNullParameter(downloadParams, "downloadParams");
        QLog.i("ZPlanDownloadManager", 1, "before :: mapid == " + downloadParams.getUrl());
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.zplan.download.impl.manager.a
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanDownloadManager.p(ZPlanDownloadParam.this);
            }
        });
    }

    public static /* synthetic */ void o(ZPlanDownloadManager zPlanDownloadManager, List list, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = 0;
        }
        zPlanDownloadManager.m(list, j3);
    }

    private final void d(long totalFileSize, List<ZPlanDownloadParam> downloadParmaList) {
        if (totalFileSize <= 0) {
            totalFileSize = e(downloadParmaList);
        }
        int i3 = 0;
        float f16 = 0.0f;
        for (Object obj : downloadParmaList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ZPlanDownloadParam zPlanDownloadParam = (ZPlanDownloadParam) obj;
            zPlanDownloadParam.e(new MultiDownloadParam(f16, totalFileSize, i16, downloadParmaList.size()));
            QLog.i("ZPlanDownloadManager", 4, "calculate complete :: startProgress == " + f16);
            f16 += (float) (((double) zPlanDownloadParam.getFileSize()) / ((double) totalFileSize));
            i3 = i16;
        }
    }
}
