package com.tencent.mobileqq.zplan.download.api.impl;

import bh3.DownloadTask;
import com.tencent.mobileqq.z1.download.ZPlanResDownloadReq;
import com.tencent.mobileqq.z1.download.data.ZootopiaDownloadParams;
import com.tencent.mobileqq.z1.download.data.ZootopiaResData;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager;
import com.tencent.mobileqq.zootopia.download.ah;
import com.tencent.mobileqq.zootopia.download.proxy.ZPlanResProxyDownloader;
import com.tencent.mobileqq.zootopia.download.x;
import com.tencent.mobileqq.zplan.download.api.ICommonDownloadHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001'B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J&\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0014\u0010\u0018\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00070\u0016H\u0016J\"\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0003\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0013\u0010$\u001a\u00020!*\u00020 H\u0000\u00a2\u0006\u0004\b\"\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/zplan/download/api/impl/CommonDownloadHelper;", "Lcom/tencent/mobileqq/zplan/download/api/ICommonDownloadHelper;", "Lbh3/b;", "listener", "Lbh3/c;", "createCommonDownloadListenerWrapper", "listenerWrapper", "", "addDownloadListener", "removeDownloadListener", "Lpb3/a;", "addManagerListener", "removeManagerListener", "Lcom/tencent/mobileqq/z1/download/data/ZootopiaDownloadParams;", "downloadParams", "startDownload", "", "id", "pause", "", "getDownloadingCount", "getCurrentDownloadCount", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/z1/download/data/ZootopiaResData;", "callback", "getZootopiaResInfo", "Lcom/tencent/mobileqq/z1/download/ZPlanResDownloadReq;", "param", "Lqb3/b;", "", "skipLog", "downloadResByPath", "Lcom/tencent/mobileqq/zootopia/download/x;", "Lbh3/d;", "toDownloadTask$zplan_impl_release", "(Lcom/tencent/mobileqq/zootopia/download/x;)Lbh3/d;", "toDownloadTask", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class CommonDownloadHelper implements ICommonDownloadHelper {
    public static final CommonDownloadHelper INSTANCE = new CommonDownloadHelper();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/download/api/impl/CommonDownloadHelper$a;", "Lbh3/c;", "Lbh3/b;", "a", "Lbh3/b;", "b", "()Lbh3/b;", "wrapped", "Lcom/tencent/mobileqq/zootopia/download/ah;", "Lcom/tencent/mobileqq/zootopia/download/ah;", "()Lcom/tencent/mobileqq/zootopia/download/ah;", "real", "<init>", "(Lbh3/b;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements bh3.c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final bh3.b wrapped;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final ah real;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/zplan/download/api/impl/CommonDownloadHelper$a$a", "Lcom/tencent/mobileqq/zootopia/download/ah;", "Lcom/tencent/mobileqq/zootopia/download/x;", "task", "", "b", "e", "", "code", h.F, "c", "", "progress", "f", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.zplan.download.api.impl.CommonDownloadHelper$a$a, reason: collision with other inner class name */
        /* loaded from: classes35.dex */
        public static final class C9165a extends ah {
            C9165a() {
                super(null, 1, null);
            }

            @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
            public void a(x task) {
                Intrinsics.checkNotNullParameter(task, "task");
                a.this.getWrapped().f(CommonDownloadHelper.INSTANCE.toDownloadTask$zplan_impl_release(task));
            }

            @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
            public void b(x task) {
                Intrinsics.checkNotNullParameter(task, "task");
                a.this.getWrapped().d(CommonDownloadHelper.INSTANCE.toDownloadTask$zplan_impl_release(task));
            }

            @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
            public void c(x task) {
                Intrinsics.checkNotNullParameter(task, "task");
                a.this.getWrapped().b(CommonDownloadHelper.INSTANCE.toDownloadTask$zplan_impl_release(task));
            }

            @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
            public void d(x task) {
                Intrinsics.checkNotNullParameter(task, "task");
                a.this.getWrapped().c(CommonDownloadHelper.INSTANCE.toDownloadTask$zplan_impl_release(task));
            }

            @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
            public void e(x task) {
                Intrinsics.checkNotNullParameter(task, "task");
                a.this.getWrapped().a(CommonDownloadHelper.INSTANCE.toDownloadTask$zplan_impl_release(task));
            }

            @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
            public void f(float progress, x task) {
                Intrinsics.checkNotNullParameter(task, "task");
                a.this.getWrapped().h(CommonDownloadHelper.INSTANCE.toDownloadTask$zplan_impl_release(task));
            }

            @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
            public void h(int code, x task) {
                Intrinsics.checkNotNullParameter(task, "task");
                a.this.getWrapped().g(CommonDownloadHelper.INSTANCE.toDownloadTask$zplan_impl_release(task), code, task.getDownloadFailInfo());
            }
        }

        public a(bh3.b wrapped) {
            Intrinsics.checkNotNullParameter(wrapped, "wrapped");
            this.wrapped = wrapped;
            this.real = new C9165a();
        }

        /* renamed from: a, reason: from getter */
        public final ah getReal() {
            return this.real;
        }

        /* renamed from: b, reason: from getter */
        public bh3.b getWrapped() {
            return this.wrapped;
        }
    }

    CommonDownloadHelper() {
    }

    @Override // com.tencent.mobileqq.zplan.download.api.ICommonDownloadHelper
    public void addDownloadListener(bh3.c listenerWrapper) {
        Intrinsics.checkNotNullParameter(listenerWrapper, "listenerWrapper");
        ZootopiaDownloadManager.f327992a.G(((a) listenerWrapper).getReal());
    }

    @Override // com.tencent.mobileqq.zplan.download.api.ICommonDownloadHelper
    public void addManagerListener(pb3.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ZootopiaDownloadManager.f327992a.H(listener);
    }

    @Override // com.tencent.mobileqq.zplan.download.api.ICommonDownloadHelper
    public bh3.c createCommonDownloadListenerWrapper(bh3.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return new a(listener);
    }

    @Override // com.tencent.mobileqq.zplan.download.api.ICommonDownloadHelper
    public void downloadResByPath(ZPlanResDownloadReq param, qb3.b listener, boolean skipLog) {
        Intrinsics.checkNotNullParameter(param, "param");
        ZPlanResProxyDownloader.f328186a.i(param, listener, skipLog);
    }

    @Override // com.tencent.mobileqq.zplan.download.api.ICommonDownloadHelper
    public int getCurrentDownloadCount() {
        return ZootopiaDownloadManager.f327992a.X();
    }

    @Override // com.tencent.mobileqq.zplan.download.api.ICommonDownloadHelper
    public int getDownloadingCount() {
        return ZootopiaDownloadManager.f327992a.a0();
    }

    @Override // com.tencent.mobileqq.zplan.download.api.ICommonDownloadHelper
    public void getZootopiaResInfo(String id5, Function1<? super ZootopiaResData, Unit> callback) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ZootopiaDownloadManager.f327992a.c0(id5, callback);
    }

    @Override // com.tencent.mobileqq.zplan.download.api.ICommonDownloadHelper
    public void pause(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        ZootopiaDownloadManager.y0(ZootopiaDownloadManager.f327992a, id5, false, 2, null);
    }

    @Override // com.tencent.mobileqq.zplan.download.api.ICommonDownloadHelper
    public void removeDownloadListener(bh3.c listenerWrapper) {
        Intrinsics.checkNotNullParameter(listenerWrapper, "listenerWrapper");
        ZootopiaDownloadManager.f327992a.D0(((a) listenerWrapper).getReal());
    }

    @Override // com.tencent.mobileqq.zplan.download.api.ICommonDownloadHelper
    public void removeManagerListener(pb3.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ZootopiaDownloadManager.f327992a.E0(listener);
    }

    @Override // com.tencent.mobileqq.zplan.download.api.ICommonDownloadHelper
    public void startDownload(ZootopiaDownloadParams downloadParams) {
        Intrinsics.checkNotNullParameter(downloadParams, "downloadParams");
        ZootopiaDownloadManager.M0(ZootopiaDownloadManager.f327992a, downloadParams, false, null, false, 14, null);
    }

    public final DownloadTask toDownloadTask$zplan_impl_release(x xVar) {
        Intrinsics.checkNotNullParameter(xVar, "<this>");
        return new DownloadTask(-1, xVar.getId(), xVar.getUrl(), xVar.m(), xVar.getDownloadStatus(), xVar.getCurProgress(), xVar.getCurRealTimeSpeed(), xVar.getCurAverageSpeed(), xVar.getIsSilentDownload());
    }
}
