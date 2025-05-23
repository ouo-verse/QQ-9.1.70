package com.tencent.gdtad.util;

import android.os.Message;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.gdtad.IAdConfigApi;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.mobileqq.activity.recent.bannerprocessor.AdDownloaderBannerProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0002H\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/gdtad/util/b;", "", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "c", "Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;", "b", "", "f", "", "g", "e", "", "appName", "i", "name", "d", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f109548a = new b();

    b() {
    }

    private final FileManagerDataCenter b() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (peekAppRuntime instanceof QQAppInterface)) {
            return ((QQAppInterface) peekAppRuntime).getFileManagerDataCenter();
        }
        return null;
    }

    private final FileManagerEntity c() {
        List<FileManagerEntity> list;
        FileManagerDataCenter b16 = b();
        if (b16 != null) {
            list = b16.J(55);
        } else {
            list = null;
        }
        if (list != null && !list.isEmpty()) {
            for (FileManagerEntity fileManagerEntity : list) {
                if (f(fileManagerEntity)) {
                    return fileManagerEntity;
                }
            }
            return null;
        }
        QLog.e("AdDownloadBannerManager", 1, "queryAdApk failed, data is null");
        return null;
    }

    private final boolean f(FileManagerEntity fileManagerEntity) {
        long adBannerShowDelay = ((IGdtAPI) QRoute.api(IGdtAPI.class)).getAdBannerShowDelay();
        if (adBannerShowDelay == 0) {
            adBannerShowDelay = 3600;
        }
        if (fileManagerEntity.status == 1 && !PackageUtil.isAppInstalled(BaseApplication.context, fileManagerEntity.yybApkName) && !fileManagerEntity.bOnceSuccess && NetConnInfoCenter.getServerTime() - fileManagerEntity.lastTime > adBannerShowDelay) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h() {
        DownloadInfo downloadInfo;
        if (!((IAdConfigApi) QRoute.api(IAdConfigApi.class)).getCanShowInstallTip()) {
            QLog.e("AdDownloadBannerManager", 1, "switch return");
            return;
        }
        FileManagerEntity c16 = f109548a.c();
        if (c16 != null) {
            downloadInfo = d.f109551a.c(c16);
        } else {
            downloadInfo = null;
        }
        if (downloadInfo == null) {
            QLog.e("AdDownloadBannerManager", 1, "getDownloadInfo failed, data is null");
            return;
        }
        if (!FileUtils.fileExists(downloadInfo.L)) {
            QLog.e("AdDownloadBannerManager", 1, "file not exit");
            BannerManager.l().O(AdDownloaderBannerProcessor.INSTANCE.a(), 0, null);
        } else {
            Message message = new Message();
            message.what = 3011;
            message.obj = downloadInfo.f341191i;
            BannerManager.l().O(AdDownloaderBannerProcessor.INSTANCE.a(), 2, message);
        }
    }

    @Nullable
    public final FileManagerEntity d(@NotNull String name) {
        List<FileManagerEntity> list;
        Intrinsics.checkNotNullParameter(name, "name");
        FileManagerDataCenter b16 = b();
        if (b16 != null) {
            list = b16.J(55);
        } else {
            list = null;
        }
        if (list != null && !list.isEmpty()) {
            for (FileManagerEntity fileManagerEntity : list) {
                if (Intrinsics.areEqual(fileManagerEntity.fileName, name)) {
                    return fileManagerEntity;
                }
            }
            return null;
        }
        QLog.e("AdDownloadBannerManager", 1, "getTargetEntity failed, data is null");
        return null;
    }

    public final void e() {
        FileManagerEntity c16 = c();
        if (c16 != null) {
            DownloadInfo c17 = d.f109551a.c(c16);
            c17.M = AdDownloadConstants.DOWNLOAD_SOURCE_AD;
            c17.j(LaunchParam.KEY_REF_ID, "biz_src_jc_file");
            DownloadManagerV2.V().a0(c17);
        }
    }

    public final void g() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.util.a
            @Override // java.lang.Runnable
            public final void run() {
                b.h();
            }
        }, 32, null, false);
    }

    public final void i(@NotNull String appName) {
        Intrinsics.checkNotNullParameter(appName, "appName");
        FileManagerEntity d16 = d(appName);
        if (d16 != null && !d16.bOnceSuccess) {
            d16.bOnceSuccess = true;
            FileManagerDataCenter b16 = f109548a.b();
            if (b16 != null) {
                b16.f0(d16);
            }
        }
    }
}
