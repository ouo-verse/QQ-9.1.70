package com.tencent.mobileqq.qwallet.preload.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.impl.PreloadResourceImpl;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.f;
import com.tencent.mobileqq.vip.g;
import com.tencent.mobileqq.vip.h;
import com.tencent.util.Pair;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import java.io.File;
import java.util.List;
import mqq.app.AppRuntime;

/* loaded from: classes16.dex */
public class PreloadComDownloader {

    /* renamed from: b, reason: collision with root package name */
    private static volatile PreloadComDownloader f279001b;

    /* renamed from: a, reason: collision with root package name */
    private h f279002a = ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).getDownloader(1);

    /* renamed from: com.tencent.mobileqq.qwallet.preload.impl.PreloadComDownloader$4, reason: invalid class name */
    /* loaded from: classes16.dex */
    class AnonymousClass4 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f279006d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f279007e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Bundle f279008f;
        final /* synthetic */ PreloadComDownloader this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.f279002a != null) {
                this.this$0.f279002a.startDownload(this.f279006d, this.f279007e, this.f279008f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a extends PreloadResourceImpl.d {
        a(f fVar) {
            super(fVar);
        }

        @Override // com.tencent.mobileqq.qwallet.preload.impl.PreloadResourceImpl.d, com.tencent.mobileqq.vip.f
        public void onDoneFile(g gVar) {
            File file;
            AppRuntime appRuntime;
            super.onDoneFile(gVar);
            if (gVar != null && gVar.f313010h != null && !TextUtils.isEmpty(gVar.f313004c) && (file = gVar.f313010h.get(gVar.f313004c)) != null && (appRuntime = QWalletHelperImpl.getAppRuntime()) != null) {
                IPreDownloadController iPreDownloadController = (IPreDownloadController) ((AppInterface) appRuntime).getRuntimeService(IPreDownloadController.class, "");
                String str = gVar.f313004c;
                long j3 = -1;
                if (gVar.f313006d == 0 && file.exists()) {
                    j3 = file.length();
                }
                iPreDownloadController.preDownloadSuccess(str, j3);
            }
        }
    }

    PreloadComDownloader() {
    }

    public static PreloadComDownloader c() {
        if (f279001b == null) {
            synchronized (PreloadComDownloader.class) {
                if (f279001b == null) {
                    f279001b = new PreloadComDownloader();
                }
            }
        }
        return f279001b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final Bundle bundle, final f fVar, final DownloadParam downloadParam) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.preload.impl.PreloadComDownloader.3
            @Override // java.lang.Runnable
            public void run() {
                g gVar = new g(downloadParam.url, new File(downloadParam.filePath));
                gVar.S = "QwalletPreload";
                List<Pair<String, String>> list = downloadParam.headers;
                if (list != null) {
                    for (Pair<String, String> pair : list) {
                        if (pair != null) {
                            gVar.b(pair.first, pair.second);
                        }
                    }
                }
                if (PreloadComDownloader.this.f279002a != null) {
                    PreloadComDownloader.this.f279002a.startDownload(gVar, fVar, bundle);
                }
            }
        }, 8, null, true);
    }

    public void e(DownloadParam downloadParam, f fVar, Bundle bundle) {
        if (downloadParam != null && !TextUtils.isEmpty(downloadParam.url) && !TextUtils.isEmpty(downloadParam.filePath)) {
            if (downloadParam.isPreDownload) {
                AppRuntime appRuntime = QWalletHelperImpl.getAppRuntime();
                if (appRuntime == null) {
                    return;
                }
                BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) appRuntime;
                b bVar = new b(baseQQAppInterface, downloadParam.url, bundle, new a(fVar), downloadParam);
                IPreDownloadController iPreDownloadController = (IPreDownloadController) baseQQAppInterface.getRuntimeService(IPreDownloadController.class);
                String str = downloadParam.url;
                iPreDownloadController.requestPreDownload(10069, PreDownloadConstants.DEPARTMENT_QQPAY, str, 0, str, downloadParam.filePath, 2, 0, true, bVar);
                return;
            }
            d(bundle, fVar, downloadParam);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class b extends AbsPreDownloadTask {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f279010d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f279011e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ DownloadParam f279012f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, f fVar, DownloadParam downloadParam) {
            super(baseQQAppInterface, str);
            this.f279010d = bundle;
            this.f279011e = fVar;
            this.f279012f = downloadParam;
        }

        @Override // com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask
        protected void realStart() {
            PreloadComDownloader.this.d(this.f279010d, this.f279011e, this.f279012f);
        }

        @Override // com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask
        protected void realCancel() {
        }
    }
}
