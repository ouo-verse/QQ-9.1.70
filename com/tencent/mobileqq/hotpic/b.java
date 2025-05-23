package com.tencent.mobileqq.hotpic;

import android.os.SystemClock;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b extends ProtocolDownloader.Adapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final String f237006d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72540);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f237006d = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "hotpic/");
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String b(String str) {
        try {
            return f237006d + Utils.Crc64String(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static boolean d(String str) {
        if (getDiskFile(str).exists()) {
            return true;
        }
        return false;
    }

    public static File getDiskFile(String str) {
        try {
            return new File(b(str));
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static URL getURL(String str) {
        try {
            return new URL(ShortVideoConstants.FILE_SOURCE_HOT_PIC, "", str);
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(String str, File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) file)).intValue();
        }
        com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(str.replaceFirst("https", "http"), file);
        gVar.B = 20000;
        gVar.Q = true;
        gVar.f313008f = 2;
        return DownloaderFactory.n(gVar, null, null);
    }

    protected String c(HotPicData hotPicData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) hotPicData);
        }
        return hotPicData.url;
    }

    protected void e(int i3, HotPicData hotPicData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) hotPicData);
        } else if (hotPicData instanceof EmotionSearchItem) {
            EmoticonOperateReport.reportEmoticonOperateMonitorGetStatus(String.valueOf(i3), 7);
        }
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public boolean hasDiskFile(DownloadParams downloadParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) downloadParams)).booleanValue();
        }
        try {
            return d(c((HotPicData) downloadParams.mExtraInfo));
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
        HotPicData hotPicData = (HotPicData) downloadParams.mExtraInfo;
        String c16 = c(hotPicData);
        boolean z16 = hotPicData instanceof HotPicSendData;
        File diskFile = getDiskFile(c16);
        if (diskFile.exists()) {
            if (!z16 && uRLDrawableHandler != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("HotPicManager.HotPicDownLoader", 2, "onFileDownloadSucceed:" + hotPicData.picIndex);
                }
                uRLDrawableHandler.onFileDownloadSucceed(hotPicData.picIndex);
            }
            return diskFile;
        }
        diskFile.getParentFile().mkdirs();
        if (com.tencent.mobileqq.util.Utils.B() && com.tencent.mobileqq.util.Utils.z() < GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV) {
            throw new IOException("SD card free space is " + com.tencent.mobileqq.util.Utils.z());
        }
        File file = new File(f237006d);
        if (!file.exists()) {
            file.mkdir();
        }
        SystemClock.uptimeMillis();
        int a16 = a(c16, diskFile);
        e(a16, hotPicData);
        if (a16 == 0) {
            String e16 = com.tencent.mobileqq.portal.o.e(diskFile.getAbsolutePath());
            String str = hotPicData.md5;
            if (!str.equalsIgnoreCase(e16) && QLog.isColorLevel()) {
                QLog.d("HotPicManager.HotPicDownLoader", 2, "md5 match fail: " + str + " " + e16);
            }
            if (!z16) {
                if (QLog.isColorLevel()) {
                    QLog.d("HotPicManager.HotPicDownLoader", 2, "onFileDownloadSucceed download:" + hotPicData.picIndex + diskFile.getAbsolutePath());
                }
                if (uRLDrawableHandler != null) {
                    uRLDrawableHandler.onFileDownloadSucceed(hotPicData.picIndex);
                }
            }
            return diskFile;
        }
        if (uRLDrawableHandler != null) {
            if (QLog.isColorLevel()) {
                QLog.d("HotPicManager.HotPicDownLoader", 2, "onFileDownloadFailed:" + hotPicData.picIndex + " " + a16);
            }
            uRLDrawableHandler.onFileDownloadFailed(hotPicData.picIndex);
            return null;
        }
        return null;
    }
}
