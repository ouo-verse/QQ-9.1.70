package com.tencent.mobileqq.qwallet.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.image.ApngImage;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.io.File;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a extends AbsDownloader {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qwallet.impl.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C8470a implements IPreloadService.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f278224a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f278225b;

        C8470a(File file, AtomicBoolean atomicBoolean) {
            this.f278224a = file;
            this.f278225b = atomicBoolean;
        }

        @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService.c
        public void onResult(int i3, IPreloadService.PathResult pathResult) {
            if (i3 != 0 || TextUtils.isEmpty(pathResult.filePath)) {
                QLog.e("QWalletPicDownloader", 2, "downloadImage file not succeed, pathRes=" + pathResult);
            }
            synchronized (this.f278224a) {
                this.f278224a.notify();
                this.f278225b.set(true);
            }
        }
    }

    private void a(String str, String str2, File file) {
        DownloadParam downloadParam = new DownloadParam();
        downloadParam.url = str;
        downloadParam.md5 = str2;
        downloadParam.useQWalletConfig = true;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.tencent.mobileqq.qwallet.preload.a.h().getResPath(downloadParam, new C8470a(file, atomicBoolean));
        if (!atomicBoolean.get()) {
            synchronized (file) {
                if (!atomicBoolean.get()) {
                    try {
                        file.wait(30000L);
                    } catch (InterruptedException e16) {
                        QLog.e("QWalletPicDownloader", 1, e16, new Object[0]);
                    }
                }
            }
        }
    }

    private String b(DownloadParams downloadParams) {
        Bundle bundle;
        Object obj = downloadParams.mExtraInfo;
        if (obj instanceof Bundle) {
            bundle = (Bundle) obj;
        } else {
            bundle = null;
        }
        if (bundle == null) {
            return "";
        }
        return bundle.getString(QWalletPicHelper.KEY_QWALLET_MD5, "");
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        Bundle bundle;
        if (downloadParams != null) {
            if (file != null && file.exists() && downloadParams.useApngImage && "png".equals(FileUtils.estimateFileType(file.getPath()))) {
                Object obj = downloadParams.mExtraInfo;
                if (obj instanceof Bundle) {
                    bundle = (Bundle) obj;
                } else {
                    bundle = null;
                }
                ApngImage apngImage = new ApngImage(file, true, bundle);
                if (apngImage.firstFrame == null) {
                    ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).reportDeviceCantPlayBackground(file.getAbsolutePath());
                }
                return apngImage;
            }
            downloadParams.useApngImage = false;
        }
        return super.decodeFile(file, downloadParams, uRLDrawableHandler);
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        if (downloadParams == null) {
            return null;
        }
        String host = downloadParams.url.getHost();
        File file = new File(host);
        String b16 = b(downloadParams);
        if (file.exists() && TextUtils.isEmpty(b16)) {
            return file;
        }
        String file2 = downloadParams.url.getFile();
        if (TextUtils.isEmpty(file2)) {
            QLog.e("QWalletPicDownloader", 2, "downloadImage url err, url=" + file2 + ", path=" + host);
            return null;
        }
        if (file2.startsWith(File.separator)) {
            file2 = file2.substring(1);
        }
        if (!file2.startsWith("http")) {
            if (QLog.isColorLevel()) {
                QLog.e("QWalletPicDownloader", 2, "downloadImage url has no http err, url=" + file2 + ", path=" + host);
            }
            return null;
        }
        a(file2, b16, file);
        return file;
    }
}
