package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class i extends ProtocolDownloader.Adapter {

    /* renamed from: f, reason: collision with root package name */
    public static final String f179916f = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "keyword_emotion/");

    /* renamed from: d, reason: collision with root package name */
    public EntityManager f179917d;

    /* renamed from: e, reason: collision with root package name */
    public Handler f179918e;

    public i() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime instanceof BaseQQAppInterface) {
            this.f179917d = waitAppRuntime.getEntityManagerFactory().createEntityManager();
        }
        Looper fileThreadLooper = ThreadManagerV2.getFileThreadLooper();
        if (fileThreadLooper != null) {
            this.f179918e = new Handler(fileThreadLooper);
        }
    }

    public static String b(IStickerRecEmoticon iStickerRecEmoticon) {
        if (!TextUtils.isEmpty(iStickerRecEmoticon.getThumbUrl())) {
            return iStickerRecEmoticon.getThumbUrl();
        }
        if (!TextUtils.isEmpty(iStickerRecEmoticon.getImgUrl())) {
            return iStickerRecEmoticon.getImgUrl();
        }
        return null;
    }

    public static boolean c(String str) {
        if (StickerRecManagerImpl.getDiskFile(str).exists()) {
            return true;
        }
        return false;
    }

    public File a(String str, File file, URLDrawableHandler uRLDrawableHandler) throws IOException {
        long currentTimeMillis;
        FileOutputStream fileOutputStream;
        long currentTimeMillis2 = System.currentTimeMillis();
        DownloadParams downloadParams = new DownloadParams();
        downloadParams.url = new URL(str);
        downloadParams.urlStr = str;
        String path = file.getPath();
        if (NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecDrawableDownLoader", 2, "keyword emotion download: " + str + " -> " + path);
            }
            String str2 = path + ".tmp";
            File file2 = new File(str2);
            if (file2.exists()) {
                file2.delete();
            }
            uRLDrawableHandler.publishProgress(0);
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(str2);
            } catch (Exception unused) {
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                ((IEmosmService) QRoute.api(IEmosmService.class)).downloadImage(fileOutputStream, downloadParams, uRLDrawableHandler);
                fileOutputStream.close();
                File file3 = new File(str2);
                if (!file3.renameTo(file)) {
                    FileUtils.copyFile(file3, file);
                    file3.delete();
                }
            } catch (Exception unused2) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused3) {
                        QLog.e("StickerRecDrawableDownLoader", 1, "downloadImage close fos error!");
                    }
                }
                new File(str2).delete();
                currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("sticker_url", str);
                if (!file.exists()) {
                }
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StickerRecImgDownload", false, currentTimeMillis, 0L, null, "");
                file.delete();
                QLog.e("StickerRecDrawableDownLoader", 1, "downloadImage|file not exist or empty. filepath=" + path);
                throw new IOException("File not Found. url: " + downloadParams.url);
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused4) {
                        QLog.e("StickerRecDrawableDownLoader", 1, "downloadImage close fos error!");
                    }
                }
                throw th;
            }
        }
        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("sticker_url", str);
        if (!file.exists() && file.length() > 0) {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StickerRecImgDownload", true, currentTimeMillis, 0L, hashMap2, "");
            return file;
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StickerRecImgDownload", false, currentTimeMillis, 0L, null, "");
        file.delete();
        QLog.e("StickerRecDrawableDownLoader", 1, "downloadImage|file not exist or empty. filepath=" + path);
        throw new IOException("File not Found. url: " + downloadParams.url);
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public boolean hasDiskFile(DownloadParams downloadParams) {
        try {
            return c(b((StickerRecData) downloadParams.mExtraInfo));
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public File loadImageFile(DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        String b16 = b((IStickerRecEmoticon) downloadParams.mExtraInfo);
        QLog.d("StickerRecDrawableDownLoader", 1, "loadImageFile");
        File diskFile = StickerRecManagerImpl.getDiskFile(b16);
        if (diskFile.exists() && diskFile.length() > 0) {
            QLog.d("StickerRecDrawableDownLoader", 1, "loadImageFile file.exists()");
            return diskFile;
        }
        diskFile.getParentFile().mkdirs();
        if (Utils.B() && Utils.z() < GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV) {
            throw new IOException("SD card free space is " + Utils.z());
        }
        File file = new File(f179916f);
        if (!file.exists()) {
            file.mkdir();
        }
        return a(b16, diskFile, uRLDrawableHandler);
    }
}
