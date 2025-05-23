package com.tencent.mobileqq.zootopia.download.normal;

import com.tencent.mobileqq.zootopia.download.x;
import com.tencent.mobileqq.zootopia.download.y;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0006\u001a\u00020\u0004*\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\u0018"}, d2 = {"com/tencent/mobileqq/zootopia/download/normal/BaseDownloadQueue$taskListener$1", "Lcom/tencent/mobileqq/zootopia/download/y;", "Lcom/tencent/mobileqq/zootopia/download/x;", "Lkotlin/Function1;", "", "action", "j", "task", "d", "b", "a", "c", "k", "e", "", "code", tl.h.F, "", "progress", "f", "", "size", "i", "g", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class BaseDownloadQueue$taskListener$1 implements y {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaseDownloadQueue f328147a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseDownloadQueue$taskListener$1(BaseDownloadQueue baseDownloadQueue) {
        this.f328147a = baseDownloadQueue;
    }

    private final void j(x xVar, Function1<? super y, Unit> function1) {
        HashMap hashMap;
        HashMap hashMap2;
        hashMap = this.f328147a.downloadListeners;
        CopyOnWriteArraySet<y> copyOnWriteArraySet = (CopyOnWriteArraySet) hashMap.get(xVar.getId());
        if (copyOnWriteArraySet != null) {
            for (y listener : copyOnWriteArraySet) {
                Intrinsics.checkNotNullExpressionValue(listener, "listener");
                function1.invoke(listener);
            }
        }
        hashMap2 = this.f328147a.downloadListeners;
        CopyOnWriteArraySet<y> copyOnWriteArraySet2 = (CopyOnWriteArraySet) hashMap2.get("all");
        if (copyOnWriteArraySet2 != null) {
            for (y listener2 : copyOnWriteArraySet2) {
                Intrinsics.checkNotNullExpressionValue(listener2, "listener");
                function1.invoke(listener2);
            }
        }
    }

    @Override // com.tencent.mobileqq.zootopia.download.y
    public void a(final x task) {
        Intrinsics.checkNotNullParameter(task, "task");
        j(task, new Function1<y, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.normal.BaseDownloadQueue$taskListener$1$onDecompress$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(y yVar) {
                invoke2(yVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(y it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.a(x.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.zootopia.download.y
    public void b(final x task) {
        Intrinsics.checkNotNullParameter(task, "task");
        j(task, new Function1<y, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.normal.BaseDownloadQueue$taskListener$1$onStartDownload$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(y yVar) {
                invoke2(yVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(y it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.b(x.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.zootopia.download.y
    public void c(x task) {
        AtomicInteger atomicInteger;
        Intrinsics.checkNotNullParameter(task, "task");
        QLog.i("Zootopia_BaseDownloadQueue", 1, task.getId() + " complete");
        k(task);
        atomicInteger = this.f328147a.downloadingCount;
        atomicInteger.decrementAndGet();
        this.f328147a.x();
    }

    @Override // com.tencent.mobileqq.zootopia.download.y
    public void d(final x task) {
        Intrinsics.checkNotNullParameter(task, "task");
        j(task, new Function1<y, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.normal.BaseDownloadQueue$taskListener$1$onWaitingDownload$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(y yVar) {
                invoke2(yVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(y it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.d(x.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.zootopia.download.y
    public void e(final x task) {
        Intrinsics.checkNotNullParameter(task, "task");
        j(task, new Function1<y, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.normal.BaseDownloadQueue$taskListener$1$onPause$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(y yVar) {
                invoke2(yVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(y it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.e(x.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.zootopia.download.y
    public void f(final float progress, final x task) {
        Intrinsics.checkNotNullParameter(task, "task");
        j(task, new Function1<y, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.normal.BaseDownloadQueue$taskListener$1$onProgress$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(y yVar) {
                invoke2(yVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(y it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.f(progress, task);
            }
        });
    }

    @Override // com.tencent.mobileqq.zootopia.download.y
    public void g(final x task) {
        Intrinsics.checkNotNullParameter(task, "task");
        j(task, new Function1<y, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.normal.BaseDownloadQueue$taskListener$1$onTaskDeleted$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(y yVar) {
                invoke2(yVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(y it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.g(x.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.zootopia.download.y
    public void h(final int code, final x task) {
        AtomicInteger atomicInteger;
        Intrinsics.checkNotNullParameter(task, "task");
        QLog.e("Zootopia_BaseDownloadQueue", 1, task.getId() + " onFailed " + code);
        j(task, new Function1<y, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.normal.BaseDownloadQueue$taskListener$1$onFailed$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(y yVar) {
                invoke2(yVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(y it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.h(code, task);
            }
        });
        atomicInteger = this.f328147a.downloadingCount;
        atomicInteger.decrementAndGet();
        this.f328147a.x();
    }

    @Override // com.tencent.mobileqq.zootopia.download.y
    public void i(final long size, final x task) {
        Intrinsics.checkNotNullParameter(task, "task");
        j(task, new Function1<y, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.normal.BaseDownloadQueue$taskListener$1$onDetectedSize$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(y yVar) {
                invoke2(yVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(y it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.i(size, task);
            }
        });
    }

    public final void k(final x task) {
        Intrinsics.checkNotNullParameter(task, "task");
        j(task, new Function1<y, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.normal.BaseDownloadQueue$taskListener$1$notifyAllOnComplete$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(y yVar) {
                invoke2(yVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(y it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.c(x.this);
            }
        });
    }
}
