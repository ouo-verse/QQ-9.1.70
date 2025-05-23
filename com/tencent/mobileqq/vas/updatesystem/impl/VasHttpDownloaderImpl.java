package com.tencent.mobileqq.vas.updatesystem.impl;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.api.IVasDownloader;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vip.h;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.callback.listener.IDownloadListener;
import com.tencent.vas.update.entity.Constants;
import com.tencent.vas.update.entity.DownloadInfoParams;
import java.io.File;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasHttpDownloaderImpl extends com.tencent.mobileqq.vip.f implements sw4.d {

    /* renamed from: a, reason: collision with root package name */
    private IDownloadListener f311213a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.vip.f f311214b = new a();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends com.tencent.mobileqq.vip.f {
        a() {
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(com.tencent.mobileqq.vip.g gVar) {
            boolean z16;
            if (VasHttpDownloaderImpl.this.f311213a != null && gVar != null) {
                int i3 = 0;
                if (gVar.i() == 3 && gVar.f313006d == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                Bundle h16 = gVar.h();
                if (h16 != null && h16.getString("from") != null && h16.getString("from").contains(Constants.UpdateFrom.SILENT_DOWNLOAD)) {
                    VasHttpDownloaderImpl.this.f(gVar.f313011i, gVar.f313013k);
                }
                IDownloadListener iDownloadListener = VasHttpDownloaderImpl.this.f311213a;
                String str = gVar.f313004c;
                if (!z16) {
                    i3 = 8;
                }
                iDownloadListener.onCompleted(str, i3, gVar.f313006d, gVar.f313007e);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onProgress(com.tencent.mobileqq.vip.g gVar) {
            if (VasHttpDownloaderImpl.this.f311213a != null && gVar != null) {
                VasHttpDownloaderImpl.this.f311213a.onProgress(gVar.f313004c, gVar.f313014l, gVar.f313013k, (int) gVar.f313015m);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public boolean onStart(com.tencent.mobileqq.vip.g gVar) {
            if (gVar == null) {
                return false;
            }
            if (VasHttpDownloaderImpl.this.f311213a != null) {
                VasHttpDownloaderImpl.this.f311213a.onDownloadStart(gVar.f313004c);
            }
            return super.onStart(gVar);
        }
    }

    private com.tencent.mobileqq.vip.g d(@NonNull DownloadInfoParams downloadInfoParams) {
        com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(downloadInfoParams.mUrl, new File(downloadInfoParams.mSavePath));
        gVar.S = VasUpdateConstants.BUSINESS_VAS_UPDATE_SYSTEM;
        gVar.f313025w = true;
        gVar.U = true;
        gVar.X = true;
        gVar.W = true;
        gVar.Q = false;
        gVar.f313001a0 = false;
        gVar.f313004c = downloadInfoParams.mItemId;
        return gVar;
    }

    private h e() {
        if (VasToggle.FEATURE_DONWLOADER.isEnable(false)) {
            return (h) QRoute.api(IVasDownloader.class);
        }
        return ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).getDownloader(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, long j3) {
        if (QLog.isColorLevel()) {
            QLog.i("VasUpdate_HttpImpl", 2, "onPreloadDownloadComplete url = " + str + " fileSize = " + j3);
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            ((IPreDownloadController) ((QQAppInterface) runtime).getRuntimeService(IPreDownloadController.class)).preDownloadSuccess(str, j3);
        } else {
            QLog.e("VasUpdate_HttpImpl", 1, "onPreloadDownloadComplete app is not QQAppInterface");
        }
    }

    private void g(final DownloadInfoParams downloadInfoParams, final IDownloadListener iDownloadListener) {
        if (e() != null && downloadInfoParams != null) {
            if (QLog.isColorLevel()) {
                QLog.i("VasUpdate_HttpImpl", 2, "onPreloadDownloadStart");
            }
            Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.vas.updatesystem.impl.VasHttpDownloaderImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    if (downloadInfoParams != null && iDownloadListener != null) {
                        if (QLog.isColorLevel()) {
                            QLog.i("VasUpdate_HttpImpl", 2, "onPreloadDownloadStart  itemId = " + downloadInfoParams.mItemId + " url= " + downloadInfoParams.mUrl + " savePath = " + downloadInfoParams.mSavePath + " from = " + downloadInfoParams.mFrom);
                        }
                        VasHttpDownloaderImpl.this.a(downloadInfoParams, iDownloadListener, new Bundle());
                    }
                }
            };
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime instanceof QQAppInterface) {
                QQAppInterface qQAppInterface = (QQAppInterface) runtime;
                ((IPreDownloadController) qQAppInterface.getRuntimeService(IPreDownloadController.class)).requestPreDownload(10019, PreDownloadConstants.DEPARTMENT_VAS, downloadInfoParams.mItemId, 3, downloadInfoParams.mUrl, downloadInfoParams.mSavePath, 2, 0, true, new RunnableTask(qQAppInterface, downloadInfoParams.mUrl, runnable, 4000L));
                return;
            }
            QLog.e("VasUpdate_HttpImpl", 1, "onPreloadDownloadStart app is not QQAppInterface");
            runnable.run();
            return;
        }
        QLog.e("VasUpdate_HttpImpl", 1, "startDownload download = null or params = null");
    }

    @Override // sw4.d
    public void a(DownloadInfoParams downloadInfoParams, IDownloadListener iDownloadListener, Bundle bundle) {
        if (e() != null && downloadInfoParams != null) {
            QLog.d("VasUpdate_HttpImpl", 2, "start download item " + downloadInfoParams.mItemId);
            this.f311213a = iDownloadListener;
            String str = downloadInfoParams.mFrom;
            if (str != null && str.contains(Constants.UpdateFrom.SILENT_DOWNLOAD) && bundle == null) {
                g(downloadInfoParams, iDownloadListener);
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("from", downloadInfoParams.mFrom);
            e().startDownload(d(downloadInfoParams), this.f311214b, bundle2);
            return;
        }
        QLog.e("VasUpdate_HttpImpl", 1, "startDownload download = null  or params = null");
    }

    @Override // sw4.d
    public void cancelDownload(String str) {
        if (e() == null) {
            QLog.e("VasUpdate_HttpImpl", 1, "startDownload download = null");
        } else {
            e().cancelTask(false, str);
        }
    }
}
