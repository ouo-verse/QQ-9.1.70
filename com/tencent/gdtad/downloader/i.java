package com.tencent.gdtad.downloader;

import android.content.Intent;
import android.text.TextUtils;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.gamematrix.gmcg.api.GmCgKingsHonorMidGameErrorCode;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.halley.downloader.DownloaderTask;
import com.tencent.halley.downloader.DownloaderTaskListener;
import com.tencent.halley.downloader.DownloaderTaskStatus;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduleUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.open.base.MD5Utils;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J8\u0010\u0015\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0016\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\fJ\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/gdtad/downloader/i;", "", "", "url", "Lcom/tencent/halley/downloader/DownloaderTask;", "g", "Lcom/tencent/open/downloadnew/DownloadInfo;", "downloadInfo", "Lcom/tencent/gdtad/downloader/t;", "listener", "", "c", "", tl.h.F, "downloaderTask", "Lcom/tencent/halley/downloader/DownloaderTaskListener;", "", "errCode", "errMsg", "", "errStack", "i", "f", "isAuto", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "e", "Lcom/tencent/halley/b;", "b", "Lcom/tencent/halley/b;", PM.APK_DOWNLOADER, "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f109183a = new i();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static com.tencent.halley.b apkDownloader = com.tencent.halley.b.f();

    static {
        com.tencent.halley.d dVar = new com.tencent.halley.d(BaseApplication.getContext(), 288, ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount(), "adDownload");
        com.tencent.halley.b bVar = apkDownloader;
        if (bVar != null) {
            bVar.h(dVar);
        }
    }

    i() {
    }

    private final void c(final DownloadInfo downloadInfo, t listener) {
        com.tencent.halley.b bVar;
        final DownloaderTask g16 = g(downloadInfo.f341186f);
        if (g16 != null && (bVar = apkDownloader) != null) {
            bVar.d(g16, true);
        }
        u.f109203a.a(4001074, downloadInfo);
        j jVar = j.f109185f;
        String str = downloadInfo.f341186f;
        Intrinsics.checkNotNullExpressionValue(str, "downloadInfo.urlStr");
        final DownloadInfo k3 = jVar.k(str);
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.gdtad.downloader.h
            @Override // java.lang.Runnable
            public final void run() {
                i.d(DownloaderTask.this, downloadInfo, k3);
            }
        }, 16, null, false, 800L);
        if (k3 != null) {
            k3.k(10);
        }
        if (listener != null) {
            listener.f(k3);
        }
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).updateAdDownloadNotice(k3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(DownloaderTask downloaderTask, DownloadInfo downloadInfo, DownloadInfo downloadInfo2) {
        String fullSavePath;
        Intrinsics.checkNotNullParameter(downloadInfo, "$downloadInfo");
        if (downloaderTask != null && (fullSavePath = downloaderTask.getFullSavePath()) != null && !new File(fullSavePath).exists()) {
            u.f109203a.a(4001075, downloadInfo);
            if (downloadInfo2 != null) {
                downloadInfo2.Q = 0;
                downloadInfo2.k(10);
                downloadInfo2.L = "";
                j.f109185f.w(downloadInfo2);
            }
        }
    }

    private final DownloaderTask g(String url) {
        boolean z16;
        com.tencent.halley.b bVar;
        List<DownloaderTask> e16;
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        Object obj = null;
        if (z16 || (bVar = apkDownloader) == null || (e16 = bVar.e()) == null) {
            return null;
        }
        Iterator<T> it = e16.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.areEqual(((DownloaderTask) next).getFileUrl(), url)) {
                obj = next;
                break;
            }
        }
        return (DownloaderTask) obj;
    }

    private final boolean h(DownloadInfo downloadInfo) {
        DownloadInfo downloadInfo2;
        String fullSavePath;
        if (AdAPKInjectUtil.d().f()) {
            j.f109185f.x(downloadInfo);
        }
        String str = null;
        if (!TextUtils.isEmpty(downloadInfo.f341186f)) {
            j jVar = j.f109185f;
            String str2 = downloadInfo.f341186f;
            Intrinsics.checkNotNullExpressionValue(str2, "downloadInfo.urlStr");
            downloadInfo2 = jVar.k(str2);
        } else {
            downloadInfo2 = null;
        }
        DownloaderTask g16 = g(downloadInfo.f341186f);
        if (g16 != null && (fullSavePath = g16.getFullSavePath()) != null) {
            str = fullSavePath;
        } else if (downloadInfo2 != null) {
            str = downloadInfo2.L;
        }
        boolean z16 = false;
        if (str != null) {
            File file = new File(str);
            if (!file.exists()) {
                return false;
            }
            z16 = true;
            if (downloadInfo2 != null && AdAPKInjectUtil.d().e(downloadInfo2, file, 325)) {
                downloadInfo2.f341205u0 = true;
                j.f109185f.w(downloadInfo2);
            }
            Intent openApkIntent = FileProvider7Helper.openApkIntent(BaseApplication.getContext(), str);
            openApkIntent.putExtra("big_brother_source_key", AdDownloadConstants.DOWNLOAD_SOURCE_AD);
            openApkIntent.putExtra(LaunchParam.KEY_REF_ID, "biz_src_WEBVIEW");
            BaseApplication.getContext().startActivity(openApkIntent);
        }
        return z16;
    }

    private final void i(DownloaderTask downloaderTask, DownloaderTaskListener listener, int errCode, String errMsg, Throwable errStack) {
        if (downloaderTask != null) {
            downloaderTask.removeListener(listener);
        }
        if (listener != null) {
            listener.onTaskFailedMainloop(downloaderTask);
        }
    }

    static /* synthetic */ void j(i iVar, DownloaderTask downloaderTask, DownloaderTaskListener downloaderTaskListener, int i3, String str, Throwable th5, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            th5 = null;
        }
        iVar.i(downloaderTask, downloaderTaskListener, i3, str, th5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(DownloadInfo downloadInfo, boolean z16) {
        String str;
        Intrinsics.checkNotNullParameter(downloadInfo, "$downloadInfo");
        j jVar = j.f109185f;
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        jVar.y(downloadInfo, str);
    }

    public final void e(@NotNull DownloadInfo downloadInfo) {
        com.tencent.halley.b bVar;
        Intrinsics.checkNotNullParameter(downloadInfo, "downloadInfo");
        DownloaderTask g16 = g(downloadInfo.f341186f);
        if (g16 != null && (bVar = apkDownloader) != null) {
            bVar.d(g16, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00de A[Catch: OutOfMemoryError -> 0x0107, Exception -> 0x0115, TryCatch #4 {Exception -> 0x0115, OutOfMemoryError -> 0x0107, blocks: (B:27:0x00da, B:29:0x00de, B:30:0x00e2, B:32:0x00e8), top: B:26:0x00da }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e8 A[Catch: OutOfMemoryError -> 0x0107, Exception -> 0x0115, TRY_LEAVE, TryCatch #4 {Exception -> 0x0115, OutOfMemoryError -> 0x0107, blocks: (B:27:0x00da, B:29:0x00de, B:30:0x00e2, B:32:0x00e8), top: B:26:0x00da }] */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f(@NotNull DownloadInfo downloadInfo, @Nullable t listener) {
        boolean z16;
        boolean z17;
        com.tencent.halley.b bVar;
        String str;
        DownloaderTask downloaderTask;
        com.tencent.halley.b bVar2;
        com.tencent.halley.b bVar3;
        Intrinsics.checkNotNullParameter(downloadInfo, "downloadInfo");
        String str2 = downloadInfo.f341186f;
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("AdDownloadClient", 1, "url is null, cancel download");
            return;
        }
        String url = downloadInfo.f341186f;
        j jVar = j.f109185f;
        Intrinsics.checkNotNullExpressionValue(url, "url");
        if (!jVar.m(url)) {
            u.f109203a.a(4001001, downloadInfo);
            jVar.u(downloadInfo);
        } else {
            u.f109203a.a(4001005, downloadInfo);
        }
        DownloaderTask g16 = g(url);
        try {
            if (g16 != null) {
                try {
                    g16.removeAllListeners();
                    g16.addListener(listener);
                    g16.resume();
                } catch (Exception e16) {
                    f109183a.i(g16, listener, GmCgKingsHonorMidGameErrorCode.InitializerGameNotFront, "download resume exception", e16);
                } catch (OutOfMemoryError e17) {
                    f109183a.i(g16, listener, -8002, "download resume OOM", e17);
                }
                if (g16.getStatus() == DownloaderTaskStatus.COMPLETE) {
                    if (!new File(g16.getFullSavePath()).exists()) {
                        z17 = true;
                        if (g16 == null && !z17) {
                            return;
                        }
                        if (g16 != null && (bVar3 = apkDownloader) != null) {
                            bVar3.d(g16, true);
                        }
                        bVar = apkDownloader;
                        str = null;
                        if (bVar == null) {
                            downloaderTask = bVar.b(url, PreDownloadScheduleUtil.getPreDownloadPathStatic("adDownload", PreDownloadConstants.DEPARTMENT_VAS, false) + "/", MD5Utils.toMD5(url) + k.f109187a.c(url), listener);
                        } else {
                            downloaderTask = null;
                        }
                        bVar2 = apkDownloader;
                        if (bVar2 != null) {
                            str = bVar2.k(downloaderTask);
                        }
                        if (TextUtils.isEmpty(str)) {
                            j(this, downloaderTask, listener, -8003, "download start error - " + str, null, 16, null);
                            return;
                        }
                        return;
                    }
                }
            }
            bVar2 = apkDownloader;
            if (bVar2 != null) {
            }
            if (TextUtils.isEmpty(str)) {
            }
        } catch (Exception e18) {
            i(downloaderTask, listener, -8004, "download start exception", e18);
            return;
        } catch (OutOfMemoryError e19) {
            i(downloaderTask, listener, -8005, "download start OOM", e19);
            return;
        }
        z17 = false;
        if (g16 == null) {
        }
        if (g16 != null) {
            bVar3.d(g16, true);
        }
        bVar = apkDownloader;
        str = null;
        if (bVar == null) {
        }
    }

    public final void k(@NotNull final DownloadInfo downloadInfo, final boolean isAuto) {
        Intrinsics.checkNotNullParameter(downloadInfo, "downloadInfo");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.downloader.g
            @Override // java.lang.Runnable
            public final void run() {
                i.l(DownloadInfo.this, isAuto);
            }
        }, 32, null, false);
        DownloaderTask g16 = g(downloadInfo.f341186f);
        if (g16 != null) {
            g16.pause();
        }
    }

    public final void m(@NotNull DownloadInfo downloadInfo, @Nullable t listener) {
        Intrinsics.checkNotNullParameter(downloadInfo, "downloadInfo");
        int i3 = downloadInfo.S;
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 5) {
                    if (i3 == 10) {
                        c(downloadInfo, listener);
                        return;
                    }
                    return;
                } else {
                    u.f109203a.a(4001010, downloadInfo);
                    h(downloadInfo);
                    return;
                }
            }
            k(downloadInfo, false);
            return;
        }
        f(downloadInfo, listener);
    }
}
