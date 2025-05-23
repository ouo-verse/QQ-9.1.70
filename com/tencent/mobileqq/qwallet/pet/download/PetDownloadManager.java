package com.tencent.mobileqq.qwallet.pet.download;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadStaticApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.f;
import com.tencent.mobileqq.vip.g;
import com.tencent.mobileqq.vip.h;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u00015B\t\b\u0002\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u0018\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010#\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010$\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010&\u001a\u00020%2\u0006\u0010\u0016\u001a\u00020\u0002H\u0002J\u0010\u0010'\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0002J\u0016\u0010(\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0012\u0010)\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010*\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010+\u001a\u00020\u0002J\u000e\u0010,\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010-\u001a\u00020\bR&\u00102\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060/0.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/download/PetDownloadManager;", "", "", "url", "", "r", "Lcom/tencent/mobileqq/qwallet/pet/download/PetDownloadManager$a;", "callback", "", "i", "downloadUrl", "fileMd5", "H", "Lcom/tencent/mobileqq/qwallet/preload/DownloadParam;", "downloadParams", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/vip/g;", "task", "j", "t", "D", "B", "filePath", "folderPath", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "errCode", "k", "", "process", "l", "E", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, BdhLogUtil.LogTag.Tag_Conn, HippyTKDListViewAdapter.X, "I", "", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "u", "p", "v", "w", ReportConstant.COSTREPORT_PREFIX, DomainData.DOMAIN_NAME, "Ljava/util/concurrent/ConcurrentHashMap;", "", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "callbackMaps", "<init>", "()V", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class PetDownloadManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final PetDownloadManager f278805a = new PetDownloadManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, Set<a>> callbackMaps = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H&J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/download/PetDownloadManager$a;", "", "", "url", "", "process", "", "onDownloadProgress", "filePath", "onDownloadSucceed", "", "errCode", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface a {
        void a(@NotNull String url, int errCode);

        void onDownloadProgress(@NotNull String url, float process);

        void onDownloadSucceed(@NotNull String url, @NotNull String filePath);
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/qwallet/pet/download/PetDownloadManager$b", "Lcom/tencent/mobileqq/vip/f;", "Lcom/tencent/mobileqq/vip/g;", "task", "", "onDoneFile", "onProgress", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DownloadParam f278807a;

        b(DownloadParam downloadParam) {
            this.f278807a = downloadParam;
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDoneFile(@NotNull g task) {
            Intrinsics.checkNotNullParameter(task, "task");
            QLog.i("QWallet.Pet.Downloader", 1, "[onDoneFile] url:" + task.f313004c + ",cost:" + (System.currentTimeMillis() - task.H));
            PetDownloadManager.f278805a.t(task, this.f278807a);
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onProgress(@NotNull g task) {
            Intrinsics.checkNotNullParameter(task, "task");
            PetDownloadManager petDownloadManager = PetDownloadManager.f278805a;
            String str = task.f313004c;
            Intrinsics.checkNotNullExpressionValue(str, "task.key");
            petDownloadManager.l(str, task.f313015m);
        }
    }

    PetDownloadManager() {
    }

    private final String A(String url) {
        if (D(url)) {
            return B(url);
        }
        return v(url);
    }

    private final String B(String url) {
        return w() + "/" + MD5Utils.toMD5(url + "_unzip");
    }

    private final boolean C(String url) {
        return FileUtils.fileExists(v(url));
    }

    private final boolean D(String url) {
        String substring = url.substring(url.length() - 4);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return Intrinsics.areEqual(substring, ".zip");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean E(String url) {
        return FileUtils.fileExists(A(url));
    }

    private final void F(final DownloadParam downloadParams) {
        final b bVar = new b(downloadParams);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qwallet.pet.download.b
            @Override // java.lang.Runnable
            public final void run() {
                PetDownloadManager.G(DownloadParam.this, bVar);
            }
        }, 128, null, true);
        QLog.i("QWallet.Pet.Downloader", 2, "[realTimeDownload] params:" + downloadParams + ",process:" + MobileQQ.processName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(DownloadParam downloadParams, f ls5) {
        Intrinsics.checkNotNullParameter(downloadParams, "$downloadParams");
        Intrinsics.checkNotNullParameter(ls5, "$ls");
        h downloader = ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).getDownloader(7);
        if (downloader != null) {
            g gVar = new g(downloadParams.url, new File(downloadParams.filePath));
            gVar.S = "business_qwallet_pet";
            f278805a.j(downloadParams, gVar);
            downloader.startDownload(gVar, ls5, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(String downloadUrl, String fileMd5) {
        DownloadParam downloadParam = new DownloadParam();
        downloadParam.filePath = f278805a.v(downloadUrl);
        downloadParam.url = downloadUrl;
        downloadParam.md5ForChecked = fileMd5;
        F(downloadParam);
    }

    private final void I(String filePath) {
        if (filePath != null) {
            com.tencent.mobileqq.qwallet.utils.g.o(f278805a.z(filePath), System.currentTimeMillis());
        }
    }

    private final void i(String url, a callback) {
        ConcurrentHashMap<String, Set<a>> concurrentHashMap = callbackMaps;
        Set<a> set = concurrentHashMap.get(url);
        if (set == null) {
            set = new LinkedHashSet<>();
            concurrentHashMap.put(url, set);
        }
        set.add(callback);
    }

    private final void j(DownloadParam downloadParams, g task) {
        List<Pair<String, String>> list = downloadParams.headers;
        if (list != null) {
            for (Pair<String, String> header : list) {
                if (header != null) {
                    Intrinsics.checkNotNullExpressionValue(header, "header");
                    task.b(header.first, header.second);
                }
            }
        }
    }

    private final void k(String url, int errCode) {
        Set<a> set = callbackMaps.get(url);
        if (set != null) {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(url, errCode);
            }
        }
        callbackMaps.remove(url);
        QLog.i("QWallet.Pet.Downloader", 1, "[callbackFail] url:" + url + ",errCode:" + errCode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(String url, float process) {
        Set<a> set = callbackMaps.get(url);
        if (set != null) {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                ((a) it.next()).onDownloadProgress(url, process);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(String url) {
        String A = A(url);
        Set<a> set = callbackMaps.get(url);
        if (set != null) {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                ((a) it.next()).onDownloadSucceed(url, A);
            }
        }
        callbackMaps.remove(url);
        I(A);
        QLog.i("QWallet.Pet.Downloader", 1, "[callbackSucceed] url:" + url + ",filePath:" + A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o() {
        File[] listFiles = new File(f278805a.w()).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                PetDownloadManager petDownloadManager = f278805a;
                String absolutePath = file.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "it.absolutePath");
                long y16 = petDownloadManager.y(absolutePath);
                if (y16 > 0 && Math.abs(System.currentTimeMillis() - y16) > 1728000000) {
                    String absolutePath2 = file.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath2, "it.absolutePath");
                    petDownloadManager.s(absolutePath2);
                    QLog.i("QWallet.Pet.Downloader", 2, "[checkAndCleanExpireRes] path:" + file.getAbsolutePath());
                }
            }
        }
    }

    private final synchronized boolean q(String filePath, String folderPath) {
        boolean z16;
        QRouteApi api = QRoute.api(IPreloadStaticApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IPreloadStaticApi::class.java)");
        IPreloadStaticApi iPreloadStaticApi = (IPreloadStaticApi) api;
        z16 = true;
        if (iPreloadStaticApi.isFolderPathValid(folderPath)) {
            QLog.i("QWallet.Pet.Downloader", 1, "isFolderPathValid true");
        } else {
            QLog.i("QWallet.Pet.Downloader", 1, "unzipAtomically filePath:" + filePath + ",folderPath:" + folderPath);
            z16 = iPreloadStaticApi.unzipAtomically(filePath, folderPath);
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean r(String url) {
        if (C(url) && Math.abs(System.currentTimeMillis() - new File(v(url)).lastModified()) < 60000) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(g task, DownloadParam downloadParams) {
        Map<String, File> map;
        File file;
        boolean equals;
        String url = task.f313004c;
        if (task.f313006d == 0 && !TextUtils.isEmpty(url) && (map = task.f313010h) != null && (file = map.get(url)) != null && file.exists()) {
            String str = downloadParams.md5ForChecked;
            if (!TextUtils.isEmpty(str)) {
                equals = StringsKt__StringsJVMKt.equals(str, MD5Utils.encodeFileHexStr(file.getAbsolutePath()), true);
                if (!equals) {
                    PetDownloadManager petDownloadManager = f278805a;
                    Intrinsics.checkNotNullExpressionValue(url, "url");
                    petDownloadManager.k(url, 1);
                    String absolutePath = file.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "absolutePath");
                    petDownloadManager.s(absolutePath);
                    return;
                }
            }
            PetDownloadManager petDownloadManager2 = f278805a;
            Intrinsics.checkNotNullExpressionValue(url, "url");
            if (petDownloadManager2.D(url)) {
                String B = petDownloadManager2.B(url);
                if (!petDownloadManager2.q(file.getAbsolutePath(), B)) {
                    petDownloadManager2.k(url, 2);
                    String absolutePath2 = file.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath2, "absolutePath");
                    petDownloadManager2.s(absolutePath2);
                    petDownloadManager2.s(B);
                    return;
                }
                String absolutePath3 = file.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath3, "absolutePath");
                petDownloadManager2.s(absolutePath3);
            }
            petDownloadManager2.m(url);
            return;
        }
        Intrinsics.checkNotNullExpressionValue(url, "url");
        k(url, task.f313006d);
    }

    private final String x() {
        String e16 = com.tencent.mobileqq.vfs.b.i().e();
        if (TextUtils.isEmpty(e16)) {
            return ".";
        }
        return e16;
    }

    private final long y(String filePath) {
        return com.tencent.mobileqq.qwallet.utils.g.f279262a.g(z(filePath));
    }

    private final String z(String filePath) {
        return "qwallet_pet_download_res_use_time" + MD5Utils.toMD5(filePath);
    }

    public final void n() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qwallet.pet.download.a
            @Override // java.lang.Runnable
            public final void run() {
                PetDownloadManager.o();
            }
        }, 64, null, true);
    }

    @Nullable
    public final String p(@Nullable String url) {
        boolean z16;
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        String str = null;
        if (z16) {
            return null;
        }
        if (E(url)) {
            str = A(url);
        }
        I(str);
        return str;
    }

    public final void s(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        FileUtils.delete(filePath, false);
        com.tencent.mobileqq.qwallet.utils.g.s(z(filePath));
    }

    public final void u(@NotNull String url, @NotNull a callback) {
        boolean z16;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (url.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            callback.a(url, 3);
            return;
        }
        i(url, callback);
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "QWallet.Pet.Downloader", null, null, null, new PetDownloadManager$download$1(url, null), 14, null);
        }
    }

    @NotNull
    public final String v(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return w() + "/" + MD5Utils.toMD5(url);
    }

    @NotNull
    public final String w() {
        return x() + "/files/QWallet/financial_pet";
    }
}
