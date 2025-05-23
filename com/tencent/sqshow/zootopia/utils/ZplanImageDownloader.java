package com.tencent.sqshow.zootopia.utils;

import bh3.DownloadTask;
import bh3.e;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.z1.download.ZPlanFileCategory;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.download.api.IFileDownloadHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001'B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001eR\u001b\u0010$\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/sqshow/zootopia/utils/ZplanImageDownloader;", "", "", "url", "path", "", tl.h.F, "e", "absFilePath", "k", "imageUrl", "g", "Lcom/tencent/sqshow/zootopia/utils/ZplanImageDownloader$a;", "listener", "d", "j", "filePath", "i", "", "b", "Ljava/util/Map;", "absFilePathMap", "", "c", "I", "CATEGORY_IMAGE", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "imageDownloadListenerList", "Lbh3/f;", "Lbh3/f;", "downloadListener", "Lcom/tencent/mobileqq/zplan/download/api/IFileDownloadHelper;", "f", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/zplan/download/api/IFileDownloadHelper;", "downloadHelper", "<init>", "()V", "a", "superqqshow-portal-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZplanImageDownloader {

    /* renamed from: a, reason: collision with root package name */
    public static final ZplanImageDownloader f373239a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, String> absFilePathMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int CATEGORY_IMAGE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<a> imageDownloadListenerList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final bh3.f downloadListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final Lazy downloadHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/sqshow/zootopia/utils/ZplanImageDownloader$a;", "", "", "url", "filePath", "", "a", "superqqshow-portal-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface a {
        void a(String url, String filePath);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/utils/ZplanImageDownloader$b", "Lbh3/e;", "Lbh3/d;", "task", "", "e", "", "b", "superqqshow-portal-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements bh3.e {
        b() {
        }

        @Override // bh3.a
        public void a(DownloadTask downloadTask) {
            e.b.e(this, downloadTask);
        }

        @Override // bh3.a
        public void b(DownloadTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
            e.b.b(this, task);
            ZplanImageDownloader.f373239a.h(task.getUrl(), task.getPath());
        }

        @Override // bh3.a
        public void c(DownloadTask downloadTask) {
            e.b.h(this, downloadTask);
        }

        @Override // bh3.a
        public void d(DownloadTask downloadTask) {
            e.b.g(this, downloadTask);
        }

        @Override // bh3.e
        public boolean e(DownloadTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
            return task.getCategory() == ZplanImageDownloader.CATEGORY_IMAGE;
        }

        @Override // bh3.a
        public void f(DownloadTask downloadTask) {
            e.b.c(this, downloadTask);
        }

        @Override // bh3.a
        public void g(DownloadTask downloadTask, int i3, String str) {
            e.b.d(this, downloadTask, i3, str);
        }

        @Override // bh3.a
        public void h(DownloadTask downloadTask) {
            e.b.f(this, downloadTask);
        }
    }

    static {
        Lazy lazy;
        ZplanImageDownloader zplanImageDownloader = new ZplanImageDownloader();
        f373239a = zplanImageDownloader;
        absFilePathMap = new LinkedHashMap();
        CATEGORY_IMAGE = ZPlanFileCategory.IMAGE.getValue();
        imageDownloadListenerList = new CopyOnWriteArrayList<>();
        bh3.f a16 = bh3.e.INSTANCE.a(new b());
        downloadListener = a16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IFileDownloadHelper>() { // from class: com.tencent.sqshow.zootopia.utils.ZplanImageDownloader$downloadHelper$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IFileDownloadHelper invoke() {
                return (IFileDownloadHelper) QRoute.api(IFileDownloadHelper.class);
            }
        });
        downloadHelper = lazy;
        zplanImageDownloader.f().addFileDownloadListener(a16);
    }

    ZplanImageDownloader() {
    }

    private final String e(String url) {
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString(url, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IFileDownloadHelper f() {
        return (IFileDownloadHelper) downloadHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(String url, String path) {
        QLog.i("ZPlanImageelper", 4, "onComplete :: url == " + url + " , filePath == " + path);
        Map<String, String> map = absFilePathMap;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ZPLAN_IMAGE_");
        sb5.append(url);
        map.put(sb5.toString(), path);
        k("ZPLAN_IMAGE_" + url, path);
        i(url, path);
    }

    private final void k(String url, String absFilePath) {
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString(url, absFilePath);
    }

    public final void d(a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        imageDownloadListenerList.add(listener);
    }

    public final String g(final String imageUrl) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        boolean z16 = true;
        if (imageUrl.length() == 0) {
            QLog.i("ZPlanImageelper", 4, "image url is empty");
            return null;
        }
        String str = absFilePathMap.get("ZPLAN_IMAGE_" + imageUrl);
        QLog.i("ZPlanImageelper", 4, "getImageFileByUrl :: path:  url == " + str);
        if (str == null || str.length() == 0) {
            str = e("ZPLAN_IMAGE_" + imageUrl);
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (z16) {
            QLog.i("ZPlanImageelper", 4, "getImageFileByUrl :: file not exist , url == " + imageUrl);
            f().download(ZPlanFileCategory.IMAGE, imageUrl);
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            QLog.i("ZPlanImageelper", 4, "get Image file ByUrl :: file exist , absFilePath == " + str);
            return file.getAbsolutePath();
        }
        QLog.i("ZPlanImageelper", 4, "getImageFileByUrl :: file not exist , maybe deleted by others , url == " + imageUrl);
        f().delete(ZPlanFileCategory.IMAGE, imageUrl, new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.utils.ZplanImageDownloader$getFilePathByUrl$1
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
                IFileDownloadHelper f16;
                QLog.i("ZPlanImageelper", 4, "deleteTask & reDownload -> " + imageUrl);
                f16 = ZplanImageDownloader.f373239a.f();
                f16.download(ZPlanFileCategory.IMAGE, imageUrl);
            }
        });
        return null;
    }

    public final void i(String url, String filePath) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        for (a aVar : imageDownloadListenerList) {
            if (aVar != null) {
                aVar.a(url, filePath);
            }
        }
    }

    public final void j(a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArrayList<a> copyOnWriteArrayList = imageDownloadListenerList;
        if (copyOnWriteArrayList.contains(listener)) {
            copyOnWriteArrayList.remove(listener);
        }
    }
}
