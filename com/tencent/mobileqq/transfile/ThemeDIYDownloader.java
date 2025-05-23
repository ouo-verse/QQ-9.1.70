package com.tencent.mobileqq.transfile;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.manager.api.IThemeSwitchManager;
import com.tencent.mobileqq.vas.theme.diy.ResData;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vas.theme.diy.ThemeDiyStyleLogic;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.g;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtil;
import com.tencent.theme.SkinEngine;
import java.io.File;
import java.io.OutputStream;
import org.apache.http.Header;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ThemeDIYDownloader extends AbsDownloader {
    static IPatchRedirector $redirector_ = null;
    public static final String HEADER_ID = "my_id";
    public static final String HEADER_PAGEINDEX = "page_index";
    public static final String HEADER_TYPE = "my_type";
    public static final String HEADER_UIN = "my_uin";
    public static final String PROTOCAL_THEME_DIY_PIC = "themediydownloader";

    public ThemeDIYDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, this, file, downloadParams, uRLDrawableHandler);
        }
        ApngImage apngImage = null;
        if (downloadParams == null) {
            return null;
        }
        if (file != null && file.exists() && downloadParams.useApngImage && ChatBackgroundManager.t(file)) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_use_rect", true);
            bundle.putBoolean("key_double_bitmap", true);
            bundle.putIntArray("key_tagId_arr", new int[]{0});
            apngImage = new ApngImage(file, true, bundle);
            if (apngImage.firstFrame == null) {
                ChatBackgroundManager.w(file.getAbsolutePath());
            }
        } else {
            downloadParams.useApngImage = false;
        }
        return apngImage;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0191 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        boolean z16;
        int parseInt;
        Header header;
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, this, outputStream, downloadParams, uRLDrawableHandler);
        }
        String file = downloadParams.url.getFile();
        String host = downloadParams.url.getHost();
        if (file.startsWith(File.separator)) {
            file = file.substring(1);
        }
        File file2 = new File(host);
        String str = null;
        int i17 = 0;
        if (!file2.exists()) {
            File file3 = new File(com.tencent.qqsharpP.a.a(file2));
            boolean z17 = downloadParams.useSharpPImage;
            if (z17 && file3.exists()) {
                if (QLog.isColorLevel()) {
                    QLog.d(PROTOCAL_THEME_DIY_PIC, 2, "downloadImage shpFile.exists url=" + file + ", path=" + host);
                }
                return file3;
            }
            if (QLog.isColorLevel()) {
                QLog.d(PROTOCAL_THEME_DIY_PIC, 2, "downloadImage download url=" + file + ", path=" + host + ", isSharpPAv=" + z17);
            }
            g gVar = new g(file, file2);
            gVar.L = z17;
            if (DownloaderFactory.o(gVar, BaseApplicationImpl.sApplication.getRuntime()) == 0) {
                if (file2.exists() && !SignatureManager.o(file2.getAbsolutePath())) {
                    file2.delete();
                    QLog.e(PROTOCAL_THEME_DIY_PIC, 1, "downloadImage file Error url=" + file + ", path=" + host);
                    file2 = null;
                } else if (SharpPUtil.isSharpPFile(file2)) {
                    file2 = com.tencent.qqsharpP.a.h(file2);
                }
                Object obj = downloadParams.mExtraInfo;
                if (obj instanceof Integer) {
                    try {
                        parseInt = Integer.parseInt(String.valueOf(obj));
                    } catch (Exception e16) {
                        QLog.e(PROTOCAL_THEME_DIY_PIC, 1, "downloadImage parseInt Error:" + e16.getMessage());
                    }
                    QLog.i(PROTOCAL_THEME_DIY_PIC, 1, "downloadImage onPostThemeChanged pageIndex: " + parseInt + ", needUpdateThemeForBg=" + ThemeBackground.needUpdateThemeForBg);
                    if (ThemeBackground.needUpdateThemeForBg && 100 == parseInt) {
                        ThemeBackground.needUpdateThemeForBg = false;
                        Intent intent = new Intent(SkinEngine.ACTION_THEME_INVALIDATE);
                        intent.putExtra("pid", Process.myPid());
                        BaseApplicationImpl.sApplication.sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
                    }
                }
                parseInt = 0;
                QLog.i(PROTOCAL_THEME_DIY_PIC, 1, "downloadImage onPostThemeChanged pageIndex: " + parseInt + ", needUpdateThemeForBg=" + ThemeBackground.needUpdateThemeForBg);
                if (ThemeBackground.needUpdateThemeForBg) {
                    ThemeBackground.needUpdateThemeForBg = false;
                    Intent intent2 = new Intent(SkinEngine.ACTION_THEME_INVALIDATE);
                    intent2.putExtra("pid", Process.myPid());
                    BaseApplicationImpl.sApplication.sendBroadcast(intent2, "com.tencent.msg.permission.pushnotify");
                }
            } else {
                file2 = new File(AppConstants.SDCARD_PATH);
                QLog.e(PROTOCAL_THEME_DIY_PIC, 1, "downloadImage Error url=" + file + ", path=" + host);
                z16 = false;
                header = downloadParams.getHeader("my_uin");
                if (header != null) {
                    try {
                        IThemeSwitchManager themeSwitchManager = VasUtil.getService().getThemeSwitchManager();
                        if (themeSwitchManager.getstyleCallBack() != null) {
                            Header header2 = downloadParams.getHeader(HEADER_ID);
                            ResData resData = new ResData();
                            if (header2 != null) {
                                str = header2.getValue();
                            }
                            resData.f310908id = str;
                            resData.path = host;
                            resData.url = file;
                            Header header3 = downloadParams.getHeader(HEADER_TYPE);
                            if (header3 != null) {
                                i17 = Integer.parseInt(header3.getValue());
                            }
                            resData.type = i17;
                            Bundle bundle = new Bundle();
                            Header header4 = downloadParams.getHeader(HEADER_PAGEINDEX);
                            if (header4 != null) {
                                i3 = Integer.parseInt(header4.getValue());
                            } else {
                                i3 = -1;
                            }
                            bundle.putInt(HEADER_PAGEINDEX, i3);
                            ThemeDiyStyleLogic.StyleCallBack styleCallBack = themeSwitchManager.getstyleCallBack();
                            if (z16) {
                                i16 = 4;
                            } else {
                                i16 = 8;
                            }
                            styleCallBack.callback(18, i16, bundle, resData);
                        }
                    } catch (Exception e17) {
                        QLog.e(PROTOCAL_THEME_DIY_PIC, 1, "downloadImage Error:" + e17.getMessage());
                    }
                }
                return file2;
            }
        }
        z16 = true;
        header = downloadParams.getHeader("my_uin");
        if (header != null) {
        }
        return file2;
    }
}
