package com.tencent.sqshow.widget.pag;

import android.graphics.Matrix;
import bh3.DownloadTask;
import bh3.e;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.z1.download.ZPlanFileCategory;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.download.api.IFileDownloadHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGFile;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0002J\u0018\u0010\u0014\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015J\u0016\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001eR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00150 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001b\u0010*\u001a\u00020'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010(\u001a\u0004\b$\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/sqshow/widget/pag/ZPlanPAGLoader;", "", "", "url", "path", "", "i", "d", "absFilePath", "l", "pagUrl", "", "isAutoDownload", "g", "Lorg/libpag/PAGFile;", "f", DomainData.DOMAIN_NAME, "pagFile", "", "dp", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lvk3/a;", "listener", "c", "k", "j", "", "b", "Ljava/util/Map;", "absFilePathMap", "I", "CATEGORY_PAG", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "pagDownloadListenerList", "Lbh3/f;", "e", "Lbh3/f;", "downloadListener", "Lcom/tencent/mobileqq/zplan/download/api/IFileDownloadHelper;", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/zplan/download/api/IFileDownloadHelper;", "downloadHelper", "<init>", "()V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanPAGLoader {

    /* renamed from: a */
    public static final ZPlanPAGLoader f369875a;

    /* renamed from: b, reason: from kotlin metadata */
    private static final Map<String, String> absFilePathMap;

    /* renamed from: c, reason: from kotlin metadata */
    private static final int CATEGORY_PAG;

    /* renamed from: d, reason: from kotlin metadata */
    private static final CopyOnWriteArrayList<vk3.a> pagDownloadListenerList;

    /* renamed from: e, reason: from kotlin metadata */
    private static final bh3.f downloadListener;

    /* renamed from: f, reason: from kotlin metadata */
    private static final Lazy downloadHelper;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/widget/pag/ZPlanPAGLoader$a", "Lbh3/e;", "Lbh3/d;", "task", "", "b", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements bh3.e {
        a() {
        }

        @Override // bh3.a
        public void a(DownloadTask downloadTask) {
            e.b.e(this, downloadTask);
        }

        @Override // bh3.a
        public void b(DownloadTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
            ZPlanPAGLoader.f369875a.i(task.getUrl(), task.getPath());
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
        public boolean e(DownloadTask downloadTask) {
            return e.b.a(this, downloadTask);
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
        ZPlanPAGLoader zPlanPAGLoader = new ZPlanPAGLoader();
        f369875a = zPlanPAGLoader;
        absFilePathMap = new LinkedHashMap();
        CATEGORY_PAG = ZPlanFileCategory.PAG.getValue();
        pagDownloadListenerList = new CopyOnWriteArrayList<>();
        bh3.f a16 = bh3.e.INSTANCE.a(new a());
        downloadListener = a16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IFileDownloadHelper>() { // from class: com.tencent.sqshow.widget.pag.ZPlanPAGLoader$downloadHelper$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IFileDownloadHelper invoke() {
                return (IFileDownloadHelper) QRoute.api(IFileDownloadHelper.class);
            }
        });
        downloadHelper = lazy;
        zPlanPAGLoader.e().addFileDownloadListener(a16);
    }

    ZPlanPAGLoader() {
    }

    private final String d(String url) {
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString(url, "");
    }

    public final IFileDownloadHelper e() {
        return (IFileDownloadHelper) downloadHelper.getValue();
    }

    public final void i(String url, String path) {
        QLog.i("ZPlanPAGHelper", 4, "onComplete :: url == " + url + ", filePath == " + path);
        Map<String, String> map = absFilePathMap;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ZPLAN_PAG_");
        sb5.append(url);
        map.put(sb5.toString(), path);
        l("ZPLAN_PAG_" + url, path);
        j(url, path);
    }

    private final void l(String url, String absFilePath) {
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString(url, absFilePath);
    }

    public final void c(vk3.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        pagDownloadListenerList.add(listener);
    }

    public final PAGFile f(String pagUrl) {
        Intrinsics.checkNotNullParameter(pagUrl, "pagUrl");
        String g16 = g(pagUrl, false);
        if (g16 == null || g16.length() == 0) {
            QLog.i("ZPlanPAGHelper", 4, "getPAGFileByUrl :: file not exist , url == " + pagUrl);
            e().download(ZPlanFileCategory.PAG, pagUrl);
            return null;
        }
        File file = new File(g16);
        if (file.exists()) {
            QLog.i("ZPlanPAGHelper", 4, "getPAGFileByUrl :: file exist , absFilePath == " + g16);
            return PagViewMonitor.Load(file.getAbsolutePath());
        }
        QLog.i("ZPlanPAGHelper", 4, "getPAGFileByUrl :: file not exist , maybe deleted by others , url == " + pagUrl);
        e().download(ZPlanFileCategory.PAG, pagUrl);
        return null;
    }

    public final String g(final String pagUrl, boolean isAutoDownload) {
        Intrinsics.checkNotNullParameter(pagUrl, "pagUrl");
        String str = absFilePathMap.get("ZPLAN_PAG_" + pagUrl);
        if (str == null || str.length() == 0) {
            str = d("ZPLAN_PAG_" + pagUrl);
        }
        if (!isAutoDownload) {
            return str;
        }
        if (str == null || str.length() == 0) {
            QLog.i("ZPlanPAGHelper", 4, "getPAGFileByUrl :: file not exist , url == " + pagUrl);
            e().download(ZPlanFileCategory.PAG, pagUrl);
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            QLog.i("ZPlanPAGHelper", 4, "getPAGFileByUrl :: file exist , absFilePath == " + str);
            return file.getAbsolutePath();
        }
        QLog.i("ZPlanPAGHelper", 4, "getPAGFileByUrl :: file not exist , maybe deleted by others , url == " + pagUrl);
        e().delete(ZPlanFileCategory.PAG, pagUrl, new Function0<Unit>() { // from class: com.tencent.sqshow.widget.pag.ZPlanPAGLoader$getPAGFilePath$1
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
                IFileDownloadHelper e16;
                QLog.i("ZPlanPAGHelper", 4, "deleteTask & reDownload -> " + pagUrl);
                e16 = ZPlanPAGLoader.f369875a.e();
                e16.download(ZPlanFileCategory.PAG, pagUrl);
            }
        });
        return null;
    }

    public final void j(String url, String path) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(path, "path");
        Iterator<T> it = pagDownloadListenerList.iterator();
        while (it.hasNext()) {
            ((vk3.a) it.next()).a(url, path);
        }
    }

    public final void k(vk3.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        pagDownloadListenerList.remove(listener);
    }

    public final void n(final String pagUrl) {
        Intrinsics.checkNotNullParameter(pagUrl, "pagUrl");
        e().delete(ZPlanFileCategory.PAG, pagUrl, new Function0<Unit>() { // from class: com.tencent.sqshow.widget.pag.ZPlanPAGLoader$startDownload$1
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
                IFileDownloadHelper e16;
                QLog.i("ZPlanPAGHelper", 4, "deleteTask & reDownload -> " + pagUrl);
                e16 = ZPlanPAGLoader.f369875a.e();
                e16.download(ZPlanFileCategory.PAG, pagUrl);
            }
        });
    }

    public final void m(PAGFile pAGFile, int i3) {
        if (pAGFile == null) {
            QLog.e("ZPlanPAGHelper", 4, "loadNumPag :: pagFile is null");
            return;
        }
        Matrix totalMatrix = pAGFile.getTotalMatrix();
        float n3 = (Utils.n(i3, BaseApplication.context.getResources()) * 1.0f) / pAGFile.width();
        totalMatrix.setScale(n3, n3);
        pAGFile.setMatrix(totalMatrix);
    }

    public static /* synthetic */ String h(ZPlanPAGLoader zPlanPAGLoader, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        return zPlanPAGLoader.g(str, z16);
    }
}
