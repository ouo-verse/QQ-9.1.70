package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.DownloadParams;
import com.tencent.image.NativeGifFactory;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.e;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticon.data.MarketFaceConstants;
import com.tencent.mobileqq.emoticon.data.MarketFaceStorageUtil;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.emoticonview.MagicFaceAdapter;
import com.tencent.mobileqq.emoticonview.VoiceGifFactory;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.g;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.apache.http.Header;

/* loaded from: classes19.dex */
public class PicEmotionDownloader extends AbsDownloader implements EmotionConstants {
    static IPatchRedirector $redirector_ = null;
    private static final String KEY = "emoticon_key";
    private static final String TAG = "PicEmotionDownloader";
    protected MobileQQ application;
    private BitmapFactory.Options mOptions;

    public PicEmotionDownloader(MobileQQ mobileQQ) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mobileQQ);
            return;
        }
        this.application = mobileQQ;
        BitmapFactory.Options options = new BitmapFactory.Options();
        this.mOptions = options;
        options.inDensity = 320;
        options.inTargetDensity = mobileQQ.getResources().getDisplayMetrics().densityDpi;
        this.mOptions.inScreenDensity = mobileQQ.getResources().getDisplayMetrics().densityDpi;
    }

    private int configParams(DownloadParams downloadParams, Emoticon emoticon, QQEmoticonMainPanelApp qQEmoticonMainPanelApp, Bundle bundle, String str) {
        int i3;
        int i16;
        String str2;
        int i17;
        boolean z16;
        EmoticonPackage syncFindEmoticonPackageById;
        Header header = downloadParams.getHeader(ProtocolDownloaderConstants.HEADER_EMOTICON_TYPE);
        boolean k3 = com.tencent.mobileqq.core.util.a.k();
        if (!k3) {
            if (header != null) {
                k3 = header.getValue().equals(String.valueOf(2));
            }
            Header header2 = downloadParams.getHeader(ProtocolDownloaderConstants.HEADER_EMOTICON_NEED_BIG);
            if (!k3 && header2 != null) {
                k3 = header2.getValue().equals("true");
            }
        }
        if (emoticon.jobType == 3) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        String host = downloadParams.url.getHost();
        if (host != null) {
            int i18 = 4;
            if (host.equals(EmotionConstants.FROM_PANEL)) {
                str2 = EmotionConstants.PANEL_PREVIEW;
                i16 = 2;
            } else if (host.equals(EmotionConstants.FROM_AIO) && k3) {
                if (emoticon.jobType == 3) {
                    i3 = 2;
                }
                if (downloadParams.useApngImage) {
                    i17 = i3 | 32;
                } else {
                    i17 = i3 | 4;
                }
                if (emoticon.isSound) {
                    str2 = EmotionConstants.BIG_SOUND;
                    i16 = 12;
                } else {
                    i16 = i17;
                    str2 = EmotionConstants.BIG_IMAGE;
                }
            } else {
                i16 = i3;
                str2 = str;
            }
            Header header3 = downloadParams.getHeader("2g_use_gif");
            if (header3 != null) {
                z16 = header3.getValue().equals("true");
            } else {
                z16 = false;
            }
            if (z16) {
                bundle.putString(EmotionConstants.DISPLAY_TYPE, EmotionConstants.BIG_IMAGE);
                if (emoticon.jobType == 3) {
                    i18 = 6;
                }
                i16 = i18;
            } else {
                bundle.putString(EmotionConstants.DISPLAY_TYPE, str2);
            }
            if (!downloadParams.useApngImage && (syncFindEmoticonPackageById = ((EmoticonManagerServiceProxy) qQEmoticonMainPanelApp.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(emoticon.epId)) != null && syncFindEmoticonPackageById.isAPNG == 2) {
                downloadParams.useApngImage = true;
            }
            return i16;
        }
        QLog.d(TAG, 2, "downloadImage| host is null");
        throw new com.tencent.mobileqq.emoticon.exception.FileDownloadFailedException(9302, 0L, "downloadImage host is null", false, false);
    }

    private Bitmap getAIOPreviewBitmap(String str, String str2, boolean z16, boolean z17) {
        String panelPreviewImagePath;
        if (z16) {
            panelPreviewImagePath = MarketFaceStorageUtil.getAIOPreviewImagePath(str, str2);
        } else {
            panelPreviewImagePath = MarketFaceStorageUtil.getPanelPreviewImagePath(str, str2);
        }
        Bitmap bitmap = null;
        if (!TextUtils.isEmpty(panelPreviewImagePath)) {
            if (new File(panelPreviewImagePath).exists()) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(panelPreviewImagePath);
                    bitmap = SafeBitmapFactory.decodeStream(new BufferedInputStream(fileInputStream), null, this.mOptions);
                    if (z17) {
                        bitmap = BaseImageUtil.grey(bitmap);
                    }
                    fileInputStream.close();
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "decode exception :path = " + panelPreviewImagePath, e16);
                } catch (OutOfMemoryError unused) {
                    QLog.e(TAG, 1, "decode oom11 :path = " + panelPreviewImagePath);
                }
                return bitmap;
            }
            QLog.e(TAG, 1, "getAIOPreviewBitmap path is not exits! " + panelPreviewImagePath);
        }
        return null;
    }

    protected Object decodeApngImage(DownloadParams downloadParams, String str) throws IOException {
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return iPatchRedirector.redirect((short) 10, (Object) this, (Object) downloadParams, (Object) str);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "decodeFile isAPNGFile, path = " + str);
        }
        File file = new File(str);
        if (downloadParams != null) {
            Object obj = downloadParams.mExtraInfo;
            if (obj instanceof Bundle) {
                bundle = (Bundle) obj;
                bundle.putInt(ApngImage.KEY_DECRYPTTYPE, ApngImage.DECRYPTTYPE_DECRYPT);
                ApngImage apngImage = new ApngImage(file, true, bundle);
                apngImage.setDensity(320);
                return apngImage;
            }
        }
        bundle = new Bundle();
        bundle.putInt(ApngImage.KEY_DECRYPTTYPE, ApngImage.DECRYPTTYPE_DECRYPT);
        ApngImage apngImage2 = new ApngImage(file, true, bundle);
        apngImage2.setDensity(320);
        return apngImage2;
    }

    protected Object decodeBitmapFile(Bundle bundle, Emoticon emoticon, boolean z16, boolean z17, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return iPatchRedirector.redirect((short) 12, this, bundle, emoticon, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3));
        }
        String str = emoticon.epId;
        String str2 = emoticon.eId;
        if (i3 == 3 || !z17) {
            z18 = false;
        }
        Bitmap aIOPreviewBitmap = getAIOPreviewBitmap(str, str2, z18, z16);
        if (aIOPreviewBitmap != null && z17) {
            bundle.putString(EmotionConstants.DISPLAY_TYPE, EmotionConstants.AIO_PREVIEW);
        }
        return aIOPreviewBitmap;
    }

    protected Object decodeDecryptFileData(String str, byte[] bArr) {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) bArr);
        }
        try {
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, this.mOptions);
        } catch (OutOfMemoryError unused) {
            QLog.e("emoticon", 1, "decode oom path = " + str);
            bitmap = null;
        }
        if (bitmap == null) {
            QLog.e(TAG, 2, "decode MARKET File:file error" + str);
            return null;
        }
        return bitmap;
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, this, file, downloadParams, uRLDrawableHandler);
        }
        if (downloadParams != null) {
            Object obj = downloadParams.tag;
            if (obj instanceof Bundle) {
                Bundle bundle = (Bundle) obj;
                Emoticon emoticon = (Emoticon) bundle.getSerializable(KEY);
                String host = downloadParams.url.getHost();
                if (host != null) {
                    boolean isGrayPic = isGrayPic(downloadParams, host);
                    String string = bundle.getString(EmotionConstants.DISPLAY_TYPE);
                    boolean equals = host.equals(EmotionConstants.FROM_AIO);
                    if (equals && string.equals(EmotionConstants.AIO_PREVIEW) && new File(MarketFaceConstants.emoticonEncryptPath.replace("[epId]", emoticon.epId).replace("[eId]", emoticon.eId)).exists()) {
                        string = emoticon.isSound ? EmotionConstants.BIG_SOUND : EmotionConstants.BIG_IMAGE;
                    }
                    return decodePicEmoticon(downloadParams, bundle, emoticon, isGrayPic, string, equals);
                }
                QLog.d(TAG, 2, "downloadImage| host is null");
                throw new com.tencent.mobileqq.emoticon.exception.FileDownloadFailedException(9302, 0L, "downloadImage host is null", false, false);
            }
            throw new com.tencent.mobileqq.emoticon.exception.FileDownloadFailedException(9302, 0L, "downloadImage can't find emoticon!", false, false);
        }
        QLog.d(TAG, 2, "downloadImage| config is null");
        throw new com.tencent.mobileqq.emoticon.exception.FileDownloadFailedException(9302, 0L, "downloadImage config is null", false, false);
    }

    protected Object decodeGifFile(DownloadParams downloadParams, String str, String str2) {
        AbstractGifImage abstractGifImage;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return iPatchRedirector.redirect((short) 11, this, downloadParams, str, str2);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "decodeFile isGifFile,path=" + str2);
        }
        File file = new File(str2);
        if (EmotionConstants.BIG_IMAGE.equals(str)) {
            abstractGifImage = NativeGifFactory.getNativeGifObject(file, true, true, downloadParams.reqWidth, downloadParams.reqHeight, 0.0f);
        } else if (EmotionConstants.BIG_SOUND.equals(str)) {
            abstractGifImage = VoiceGifFactory.getVoiceGifObject(file, 0, true);
        } else {
            abstractGifImage = null;
        }
        if (abstractGifImage != null) {
            abstractGifImage.setDensity(320);
        }
        return abstractGifImage;
    }

    protected Object decodeMagicFile(Bundle bundle, Emoticon emoticon, boolean z16, String str, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return iPatchRedirector.redirect((short) 13, this, bundle, emoticon, Boolean.valueOf(z16), str, Boolean.valueOf(z17));
        }
        bundle.putString(EmotionConstants.DISPLAY_TYPE, str);
        File file = new File(MarketFaceConstants.emoticonEncryptPath.replace("[epId]", emoticon.epId).replace("[eId]", emoticon.eId));
        if (!file.exists()) {
            Bitmap aIOPreviewBitmap = getAIOPreviewBitmap(emoticon.epId, emoticon.eId, z17, z16);
            if (aIOPreviewBitmap != null && z17) {
                bundle.putString(EmotionConstants.DISPLAY_TYPE, EmotionConstants.AIO_PREVIEW);
            }
            return aIOPreviewBitmap;
        }
        AbstractGifImage nativeGifObject = NativeGifFactory.getNativeGifObject(file, true, true, 0, 0, 0.0f);
        if (nativeGifObject != null) {
            nativeGifObject.setDensity(320);
        }
        return nativeGifObject;
    }

    protected Object decodePicEmoticon(DownloadParams downloadParams, Bundle bundle, Emoticon emoticon, boolean z16, String str, boolean z17) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return iPatchRedirector.redirect((short) 7, this, downloadParams, bundle, emoticon, Boolean.valueOf(z16), str, Boolean.valueOf(z17));
        }
        int i3 = emoticon.jobType;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "showType: " + str);
        }
        if (!EmotionConstants.BIG_IMAGE.equals(str) && !EmotionConstants.BIG_SOUND.equals(str)) {
            if (z17) {
                str2 = EmotionConstants.AIO_PREVIEW;
            } else {
                str2 = EmotionConstants.PANEL_PREVIEW;
            }
            bundle.putString(EmotionConstants.DISPLAY_TYPE, str2);
            if (z17 && i3 != 1 && i3 != 3) {
                z18 = true;
            }
            return getAIOPreviewBitmap(emoticon.epId, emoticon.eId, z18, z16);
        }
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "decodeFile jobType not supported: " + i3);
                        }
                        return null;
                    }
                }
            }
            return decodeMagicFile(bundle, emoticon, z16, str, z17);
        }
        bundle.putString(EmotionConstants.DISPLAY_TYPE, str);
        String replace = MarketFaceConstants.emoticonEncryptPath.replace("[epId]", emoticon.epId).replace("[eId]", emoticon.eId);
        if (downloadParams.useApngImage) {
            replace = MarketFaceConstants.emoticonAPNGPath.replace("[epId]", emoticon.epId).replace("[eId]", emoticon.eId);
        }
        if (!new File(replace).exists()) {
            return decodeBitmapFile(bundle, emoticon, z16, z17, i3);
        }
        try {
        } catch (FileNotFoundException e16) {
            QLog.e(TAG, 1, "decode MARKET File", e16);
        } catch (IOException e17) {
            QLog.e(TAG, 1, "decode MARKET File", e17);
        } catch (Exception e18) {
            QLog.e(TAG, 1, "decode MARKET File", e18);
        }
        if (e.B(replace)) {
            return decodeGifFile(downloadParams, str, replace);
        }
        if (downloadParams.useApngImage) {
            return decodeApngImage(downloadParams, replace);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "decodeFile getDecryptFileData,path=" + replace);
        }
        byte[] q16 = e.q(replace);
        if (q16 != null) {
            return decodeDecryptFileData(replace, q16);
        }
        return null;
    }

    protected void downlaodAIOEmoticon(Emoticon emoticon, QQEmoticonMainPanelApp qQEmoticonMainPanelApp, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, emoticon, qQEmoticonMainPanelApp, Integer.valueOf(i3));
            return;
        }
        EmojiManagerServiceProxy emojiManagerServiceProxy = (EmojiManagerServiceProxy) qQEmoticonMainPanelApp.getRuntimeService(IEmojiManagerService.class);
        boolean z16 = !emojiManagerServiceProxy.tasksFileExists(emoticon, i3);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "need download:" + z16);
        }
        if (z16) {
            boolean downloadAIOEmoticon = emojiManagerServiceProxy.downloadAIOEmoticon(emoticon, i3);
            if (QLog.isColorLevel()) {
                QLog.d("Q.emoji.EmoDown", 2, "downloadImage| downloadAIOEmoticon result=" + downloadAIOEmoticon + " eId: " + emoticon.eId);
            }
            reportEmoticonMonitor(emoticon, downloadAIOEmoticon);
            if (!downloadAIOEmoticon) {
                QLog.e(TAG, 1, "emotion down fail : epid = " + emoticon.epId + ";eid = " + emoticon.eId);
                throw new com.tencent.mobileqq.emoticon.exception.FileDownloadFailedException(9301, 0L, "downloadImage fail", false, false);
            }
        }
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        String str;
        AppRuntime appRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, this, outputStream, downloadParams, uRLDrawableHandler);
        }
        if (downloadParams != null) {
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "downloadImage| useGifAnimation=", Boolean.valueOf(downloadParams.useGifAnimation), " url.toString=", downloadParams.url);
            }
            Object obj = downloadParams.tag;
            if (obj instanceof Emoticon) {
                Emoticon emoticon = (Emoticon) obj;
                Header header = downloadParams.getHeader("my_uin");
                if (header != null) {
                    str = header.getValue();
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "downloadImage| myUin:" + str);
                    }
                    try {
                        appRuntime = this.application.getAppRuntime(str);
                    } catch (Throwable th5) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "exception:" + th5.getMessage());
                        }
                        String lastLoginUin = MobileQQ.sMobileQQ.getLastLoginUin();
                        AppRuntime appRuntime2 = this.application.getAppRuntime(lastLoginUin);
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "downloadImage| a second time: uin->" + lastLoginUin);
                        }
                        appRuntime = appRuntime2;
                    }
                    if (appRuntime == null) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "downloadImage app is null");
                        }
                        throw new com.tencent.mobileqq.emoticon.exception.FileDownloadFailedException(9301, 0L, "mApp is null", false, false);
                    }
                    Bundle bundle = new Bundle();
                    downloadParams.tag = bundle;
                    bundle.putSerializable(KEY, emoticon);
                    QQEmoticonMainPanelApp qQEmoticonMainPanelApp = new QQEmoticonMainPanelApp(appRuntime);
                    downlaodAIOEmoticon(emoticon, qQEmoticonMainPanelApp, configParams(downloadParams, emoticon, qQEmoticonMainPanelApp, bundle, EmotionConstants.AIO_PREVIEW));
                    return new File(AppConstants.SDCARD_PATH);
                }
                QLog.d(TAG, 2, "downloadImage| uin is null");
                throw new com.tencent.mobileqq.emoticon.exception.FileDownloadFailedException(9302, 0L, "can't find myUin!", false, false);
            }
            throw new com.tencent.mobileqq.emoticon.exception.FileDownloadFailedException(9302, 0L, "downloadImage can't find emoticon!", false, false);
        }
        QLog.d(TAG, 2, "downloadImage| config is null");
        throw new com.tencent.mobileqq.emoticon.exception.FileDownloadFailedException(9302, 0L, "downloadImage config is null", false, false);
    }

    protected void downloadSmallEmoticon(Emoticon emoticon, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) emoticon, (Object) appRuntime);
            return;
        }
        if (emoticon.jobType == 3) {
            String[] strArr = {EmotionPanelConstans.smallEmoticonThumbUrl.replace("[epId]", emoticon.epId).replace("[eId]", emoticon.eId), MarketFaceConstants.emoticonPreviewPath.replace("[epId]", emoticon.epId).replace("[eId]", emoticon.eId)};
            int download = ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).download(new g(strArr[0], new File(strArr[1])), appRuntime);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "download small emoji, ret:" + download);
            }
        }
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public boolean gifHasDifferentState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return true;
    }

    protected boolean isGrayPic(DownloadParams downloadParams, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) downloadParams, (Object) str)).booleanValue();
        }
        if (str.equals(EmotionConstants.FROM_PANEL)) {
            String file = downloadParams.url.getFile();
            if (!TextUtils.isEmpty(file) && file.endsWith(MagicFaceAdapter.MAGIC_GRAY_PIC)) {
                return true;
            }
        }
        return false;
    }

    protected void reportEmoticonMonitor(Emoticon emoticon, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, emoticon, Boolean.valueOf(z16));
            return;
        }
        int i3 = emoticon.jobType;
        String str = "0";
        if (i3 == 3) {
            if (!z16) {
                str = "5002";
            }
            EmoticonOperateReport.reportAIOEmoticonMonitorReceiveStatus(str, 5);
        } else {
            if (i3 != 2 && i3 != 4) {
                if (i3 == 0) {
                    if (!z16) {
                        str = "66001";
                    }
                    EmoticonOperateReport.reportAIOEmoticonMonitorReceiveStatus(str, 6);
                    return;
                }
                return;
            }
            if (!z16) {
                str = "7001";
            }
            EmoticonOperateReport.reportAIOEmoticonMonitorReceiveStatus(str, 7);
        }
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public boolean useDiskCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return false;
    }
}
