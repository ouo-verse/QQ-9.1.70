package com.tencent.mobileqq.zplan.download.api.impl;

import bh3.DownloadTask;
import com.tencent.mobileqq.z1.download.FileDownloadParams;
import com.tencent.mobileqq.z1.download.ZPlanFileCategory;
import com.tencent.mobileqq.zootopia.download.ah;
import com.tencent.mobileqq.zootopia.download.normal.FileDownloadManager;
import com.tencent.mobileqq.zootopia.download.x;
import com.tencent.mobileqq.zplan.download.api.IFileDownloadHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J&\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0016J\u0013\u0010\u0016\u001a\u00020\u0013*\u00020\u0012H\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zplan/download/api/impl/FileDownloadHelper;", "Lcom/tencent/mobileqq/zplan/download/api/IFileDownloadHelper;", "Lbh3/e;", "listener", "Lbh3/f;", "createFileDownloadListenerWrapper", "listenerWrapper", "", "addFileDownloadListener", "removeFileDownloadListener", "Lcom/tencent/mobileqq/z1/download/ZPlanFileCategory;", "category", "", "url", "download", "Lkotlin/Function0;", "callback", "delete", "Lcom/tencent/mobileqq/zootopia/download/normal/f;", "Lbh3/d;", "toDownloadTask$zplan_impl_release", "(Lcom/tencent/mobileqq/zootopia/download/normal/f;)Lbh3/d;", "toDownloadTask", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class FileDownloadHelper implements IFileDownloadHelper {
    public static final FileDownloadHelper INSTANCE = new FileDownloadHelper();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/download/api/impl/FileDownloadHelper$a;", "Lbh3/f;", "Lbh3/e;", "a", "Lbh3/e;", "b", "()Lbh3/e;", "wrapped", "Lcom/tencent/mobileqq/zootopia/download/ah;", "Lcom/tencent/mobileqq/zootopia/download/ah;", "()Lcom/tencent/mobileqq/zootopia/download/ah;", "real", "<init>", "(Lbh3/e;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements bh3.f {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final bh3.e wrapped;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final ah real;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/zplan/download/api/impl/FileDownloadHelper$a$a", "Lcom/tencent/mobileqq/zootopia/download/ah;", "Lcom/tencent/mobileqq/zootopia/download/x;", "Lbh3/d;", "k", "task", "", "b", "e", "", "code", h.F, "c", "", "progress", "f", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.zplan.download.api.impl.FileDownloadHelper$a$a, reason: collision with other inner class name */
        /* loaded from: classes35.dex */
        public static final class C9166a extends ah {
            C9166a() {
                super(null, 1, null);
            }

            private final DownloadTask k(x xVar) {
                if (xVar instanceof com.tencent.mobileqq.zootopia.download.normal.f) {
                    return FileDownloadHelper.INSTANCE.toDownloadTask$zplan_impl_release((com.tencent.mobileqq.zootopia.download.normal.f) xVar);
                }
                return null;
            }

            @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
            public void a(x task) {
                Intrinsics.checkNotNullParameter(task, "task");
                DownloadTask k3 = k(task);
                if (k3 == null || a.this.getWrapped().e(k3)) {
                    return;
                }
                a.this.getWrapped().f(k3);
            }

            @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
            public void b(x task) {
                Intrinsics.checkNotNullParameter(task, "task");
                DownloadTask k3 = k(task);
                if (k3 == null || a.this.getWrapped().e(k3)) {
                    return;
                }
                a.this.getWrapped().d(k3);
            }

            @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
            public void c(x task) {
                Intrinsics.checkNotNullParameter(task, "task");
                DownloadTask k3 = k(task);
                if (k3 == null || a.this.getWrapped().e(k3)) {
                    return;
                }
                a.this.getWrapped().b(k3);
            }

            @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
            public void d(x task) {
                Intrinsics.checkNotNullParameter(task, "task");
                DownloadTask k3 = k(task);
                if (k3 == null || a.this.getWrapped().e(k3)) {
                    return;
                }
                a.this.getWrapped().c(k3);
            }

            @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
            public void e(x task) {
                Intrinsics.checkNotNullParameter(task, "task");
                DownloadTask k3 = k(task);
                if (k3 == null || a.this.getWrapped().e(k3)) {
                    return;
                }
                a.this.getWrapped().a(k3);
            }

            @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
            public void f(float progress, x task) {
                Intrinsics.checkNotNullParameter(task, "task");
                DownloadTask k3 = k(task);
                if (k3 == null || a.this.getWrapped().e(k3)) {
                    return;
                }
                a.this.getWrapped().h(k3);
            }

            @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
            public void h(int code, x task) {
                Intrinsics.checkNotNullParameter(task, "task");
                DownloadTask k3 = k(task);
                if (k3 == null || a.this.getWrapped().e(k3)) {
                    return;
                }
                a.this.getWrapped().g(k3, code, task.getDownloadFailInfo());
            }
        }

        public a(bh3.e wrapped) {
            Intrinsics.checkNotNullParameter(wrapped, "wrapped");
            this.wrapped = wrapped;
            this.real = new C9166a();
        }

        /* renamed from: a, reason: from getter */
        public final ah getReal() {
            return this.real;
        }

        /* renamed from: b, reason: from getter */
        public bh3.e getWrapped() {
            return this.wrapped;
        }
    }

    FileDownloadHelper() {
    }

    @Override // com.tencent.mobileqq.zplan.download.api.IFileDownloadHelper
    public void addFileDownloadListener(bh3.f listenerWrapper) {
        Intrinsics.checkNotNullParameter(listenerWrapper, "listenerWrapper");
        FileDownloadManager.f328148a.f(((a) listenerWrapper).getReal());
    }

    @Override // com.tencent.mobileqq.zplan.download.api.IFileDownloadHelper
    public bh3.f createFileDownloadListenerWrapper(bh3.e listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return new a(listener);
    }

    @Override // com.tencent.mobileqq.zplan.download.api.IFileDownloadHelper
    public void download(ZPlanFileCategory category, String url) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(url, "url");
        FileDownloadManager.f328148a.y(new FileDownloadParams(category.getValue(), url, null, null, null, null, null, null, null, false, 1020, null));
    }

    @Override // com.tencent.mobileqq.zplan.download.api.IFileDownloadHelper
    public void removeFileDownloadListener(bh3.f listenerWrapper) {
        Intrinsics.checkNotNullParameter(listenerWrapper, "listenerWrapper");
        FileDownloadManager.f328148a.x(((a) listenerWrapper).getReal());
    }

    public final DownloadTask toDownloadTask$zplan_impl_release(com.tencent.mobileqq.zootopia.download.normal.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "<this>");
        return new DownloadTask(fVar.getCategory(), fVar.getId(), fVar.getUrl(), fVar.m(), fVar.getDownloadStatus(), fVar.getCurProgress(), fVar.getCurRealTimeSpeed(), fVar.getCurAverageSpeed(), fVar.g());
    }

    @Override // com.tencent.mobileqq.zplan.download.api.IFileDownloadHelper
    public void delete(ZPlanFileCategory category, String url, final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        FileDownloadManager.f328148a.l(new FileDownloadParams(category.getValue(), url, null, null, null, null, null, null, null, false, 1020, null), new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.download.api.impl.FileDownloadHelper$delete$1
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
                callback.invoke();
            }
        });
    }
}
