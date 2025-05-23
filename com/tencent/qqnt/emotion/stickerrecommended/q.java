package com.tencent.qqnt.emotion.stickerrecommended;

import android.text.TextUtils;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.temp.report.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.api.IEmosmService;
import com.tencent.qqnt.emotion.stickerrecommended.impl.StickerRecManagerImpl;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes24.dex */
public class q extends ProtocolDownloader.Adapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final String f356622d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42904);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f356622d = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "keyword_emotion/");
    }

    public q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String b(g gVar) {
        if (!TextUtils.isEmpty(gVar.getThumbUrl())) {
            return gVar.getThumbUrl();
        }
        if (!TextUtils.isEmpty(gVar.getImgUrl())) {
            return gVar.getImgUrl();
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (File) iPatchRedirector.redirect((short) 3, this, str, file, uRLDrawableHandler);
        }
        long currentTimeMillis = System.currentTimeMillis();
        DownloadParams downloadParams = new DownloadParams();
        downloadParams.url = new URL(str);
        downloadParams.urlStr = str;
        String path = file.getPath();
        if (com.tencent.qqnt.emotion.utils.l.a(BaseApplication.getContext())) {
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecDrawableDownLoader", 2, "keyword emotion download: " + str + " -> " + path);
            }
            String str2 = path + ".tmp";
            File file2 = new File(str2);
            if (file2.exists()) {
                file2.delete();
            }
            uRLDrawableHandler.publishProgress(0);
            try {
                File downloadImage = ((IEmosmService) QRoute.api(IEmosmService.class)).downloadImage(null, downloadParams, uRLDrawableHandler);
                if (!downloadImage.renameTo(file)) {
                    FileUtils.copyFile(downloadImage, file);
                    downloadImage.delete();
                }
            } catch (Exception unused) {
                new File(str2).delete();
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("sticker_url", str);
        if (file.exists() && file.length() > 0) {
            StatisticCollector.d(BaseApplication.getContext()).c(null, "StickerRecImgDownload", true, currentTimeMillis2, 0L, hashMap, "");
            return file;
        }
        StatisticCollector.d(BaseApplication.getContext()).c(null, "StickerRecImgDownload", false, currentTimeMillis2, 0L, null, "");
        file.delete();
        QLog.e("StickerRecDrawableDownLoader", 1, "downloadImage|file not exist or empty. filepath=" + path);
        throw new IOException("File not Found. url: " + downloadParams.url);
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public boolean hasDiskFile(DownloadParams downloadParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) downloadParams)).booleanValue();
        }
        try {
            return c(b((o) downloadParams.mExtraInfo));
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public File loadImageFile(DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) uRLDrawableHandler);
        }
        String b16 = b((g) downloadParams.mExtraInfo);
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
        File file = new File(f356622d);
        if (!file.exists()) {
            file.mkdir();
        }
        return a(b16, diskFile, uRLDrawableHandler);
    }
}
