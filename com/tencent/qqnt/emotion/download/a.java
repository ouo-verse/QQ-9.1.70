package com.tencent.qqnt.emotion.download;

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
import com.tencent.mobileqq.emoticonview.MagicFaceAdapter;
import com.tencent.mobileqq.emoticonview.VoiceGifFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.temp.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOEmoPanelApi;
import com.tencent.qqnt.emotion.api.IEmojiManagerService;
import com.tencent.qqnt.emotion.api.IEmoticonManagerService;
import com.tencent.qqnt.emotion.download.exception.FileDownloadFailedException;
import com.tencent.qqnt.emotion.ipc.c;
import com.tencent.qqnt.emotion.ipc.proxy.b;
import com.tencent.qqnt.emotion.utils.j;
import com.tencent.qqnt.emotion.utils.l;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.apache.http.Header;

/* compiled from: P */
/* loaded from: classes24.dex */
public class a extends AbsDownloader {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected MobileQQ f356230d;

    /* renamed from: e, reason: collision with root package name */
    private BitmapFactory.Options f356231e;

    public a(MobileQQ mobileQQ) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mobileQQ);
            return;
        }
        this.f356230d = mobileQQ;
        BitmapFactory.Options options = new BitmapFactory.Options();
        this.f356231e = options;
        options.inDensity = 320;
        options.inTargetDensity = mobileQQ.getResources().getDisplayMetrics().densityDpi;
        this.f356231e.inScreenDensity = mobileQQ.getResources().getDisplayMetrics().densityDpi;
    }

    private int a(DownloadParams downloadParams, Emoticon emoticon, c cVar, Bundle bundle, String str) {
        int i3;
        int i16;
        String str2;
        int i17;
        boolean z16;
        EmoticonPackage a16;
        Header header = downloadParams.getHeader(ProtocolDownloaderConstants.HEADER_EMOTICON_TYPE);
        boolean b16 = l.b();
        if (!b16) {
            if (header != null) {
                b16 = header.getValue().equals(String.valueOf(2));
            }
            Header header2 = downloadParams.getHeader(ProtocolDownloaderConstants.HEADER_EMOTICON_NEED_BIG);
            if (!b16 && header2 != null) {
                b16 = header2.getValue().equals("true");
            }
        }
        if (emoticon.jobType == 3) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        String host = downloadParams.url.getHost();
        if (host == null) {
            if (QLog.isColorLevel()) {
                QLog.d("PicEmotionDownloader", 2, "downloadImage| host is null");
            }
            throw new FileDownloadFailedException(9302, 0L, "downloadImage host is null", false, false);
        }
        int i18 = 4;
        if (host.equals(EmotionConstants.FROM_PANEL)) {
            str2 = EmotionConstants.PANEL_PREVIEW;
            i16 = 2;
        } else if (host.equals(EmotionConstants.FROM_AIO) && b16) {
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
        if (!downloadParams.useApngImage && (a16 = ((com.tencent.qqnt.emotion.ipc.proxy.c) cVar.c(IEmoticonManagerService.class)).a(emoticon.epId)) != null && a16.isAPNG == 2) {
            downloadParams.useApngImage = true;
        }
        return i16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0074, code lost:
    
        if (r8 == null) goto L27;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v7, types: [android.graphics.Bitmap] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bitmap getAIOPreviewBitmap(String str, String str2, boolean z16, boolean z17) {
        String f16;
        Object obj;
        FileInputStream fileInputStream;
        if (z16) {
            f16 = j.a(str, str2);
        } else {
            f16 = j.f(str, str2);
        }
        ?? r85 = 0;
        r8 = null;
        FileInputStream fileInputStream2 = null;
        if (!TextUtils.isEmpty(f16)) {
            try {
                if (new File(f16).exists()) {
                    try {
                        fileInputStream = new FileInputStream(f16);
                        try {
                            Bitmap decodeStream = SafeBitmapFactory.decodeStream(new BufferedInputStream(fileInputStream), null, this.f356231e);
                            r85 = decodeStream;
                            if (z17) {
                                r85 = BaseImageUtil.grey(decodeStream);
                            }
                        } catch (OutOfMemoryError unused) {
                            fileInputStream2 = fileInputStream;
                            obj = null;
                            QLog.e("PicEmotionDownloader", 1, "decode oom11 :path = " + f16);
                            obj = obj;
                        } catch (Throwable th5) {
                            th = th5;
                            fileInputStream2 = fileInputStream;
                            obj = null;
                            QLog.e("PicEmotionDownloader", 1, "decode exception :path = " + f16, th);
                            if (fileInputStream2 != null) {
                                obj = obj;
                                try {
                                    fileInputStream2.close();
                                } catch (IOException unused2) {
                                }
                            }
                            r85 = obj;
                            return r85;
                        }
                    } catch (OutOfMemoryError unused3) {
                        obj = null;
                    } catch (Throwable th6) {
                        th = th6;
                        obj = null;
                    }
                    try {
                        fileInputStream.close();
                    } catch (IOException unused4) {
                        return r85;
                    }
                } else {
                    QLog.e("PicEmotionDownloader", 1, "getAIOPreviewBitmap path is not exits! " + f16);
                }
            } catch (Throwable th7) {
                if (r85 != 0) {
                    try {
                        r85.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th7;
            }
        }
        return null;
    }

    protected void b(Emoticon emoticon, c cVar, int i3, URLDrawableHandler uRLDrawableHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, emoticon, cVar, Integer.valueOf(i3), uRLDrawableHandler);
            return;
        }
        b bVar = (b) cVar.c(IEmojiManagerService.class);
        boolean z16 = !bVar.e(emoticon, i3);
        if (QLog.isColorLevel()) {
            QLog.d("PicEmotionDownloader", 2, "need download:" + z16);
        }
        if (z16) {
            boolean b16 = bVar.b(emoticon, i3);
            if (QLog.isColorLevel()) {
                QLog.d("Q.emoji.EmoDown", 2, "downloadImage| downloadAIOEmoticon result=" + b16 + " eId: " + emoticon.eId);
            }
            if (b16) {
                uRLDrawableHandler.onFileDownloadSucceed(0L);
                return;
            }
            QLog.e("PicEmotionDownloader", 1, "emotion down fail : epid = " + emoticon.epId + ";eid = " + emoticon.eId);
            uRLDrawableHandler.onFileDownloadFailed(4);
            throw new FileDownloadFailedException(9301, 0L, "downloadImage fail", false, false);
        }
    }

    protected Object decodeApngImage(DownloadParams downloadParams, String str) throws IOException {
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return iPatchRedirector.redirect((short) 9, (Object) this, (Object) downloadParams, (Object) str);
        }
        if (QLog.isColorLevel()) {
            QLog.d("PicEmotionDownloader", 2, "decodeFile isAPNGFile, path = " + str);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return iPatchRedirector.redirect((short) 11, this, bundle, emoticon, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3));
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) bArr);
        }
        try {
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, this.f356231e);
        } catch (OutOfMemoryError unused) {
            QLog.e("emoticon", 1, "decode oom path = " + str);
            bitmap = null;
        }
        if (bitmap == null) {
            if (QLog.isColorLevel()) {
                QLog.e("PicEmotionDownloader", 2, "decode MARKET File:file error" + str);
            }
            return null;
        }
        return bitmap;
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, this, file, downloadParams, uRLDrawableHandler);
        }
        if (downloadParams == null) {
            if (QLog.isColorLevel()) {
                QLog.d("PicEmotionDownloader", 2, "downloadImage| config is null");
            }
            throw new FileDownloadFailedException(9302, 0L, "downloadImage config is null", false, false);
        }
        Object obj = downloadParams.tag;
        if (obj instanceof Bundle) {
            Bundle bundle = (Bundle) obj;
            Emoticon emoticon = (Emoticon) bundle.getSerializable("emoticon_key");
            String host = downloadParams.url.getHost();
            if (host == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("PicEmotionDownloader", 2, "downloadImage| host is null");
                }
                throw new FileDownloadFailedException(9302, 0L, "downloadImage host is null", false, false);
            }
            boolean isGrayPic = isGrayPic(downloadParams, host);
            String string = bundle.getString(EmotionConstants.DISPLAY_TYPE);
            boolean equals = host.equals(EmotionConstants.FROM_AIO);
            if (equals && string.equals(EmotionConstants.AIO_PREVIEW) && new File(j.c(emoticon.epId, emoticon.eId)).exists()) {
                string = emoticon.isSound ? EmotionConstants.BIG_SOUND : EmotionConstants.BIG_IMAGE;
            }
            return decodePicEmoticon(downloadParams, bundle, emoticon, isGrayPic, string, equals);
        }
        throw new FileDownloadFailedException(9302, 0L, "downloadImage can't find emoticon!", false, false);
    }

    protected Object decodeGifFile(DownloadParams downloadParams, String str, String str2) {
        AbstractGifImage abstractGifImage;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return iPatchRedirector.redirect((short) 10, this, downloadParams, str, str2);
        }
        if (QLog.isColorLevel()) {
            QLog.d("PicEmotionDownloader", 2, "decodeFile isGifFile,path=" + str2);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return iPatchRedirector.redirect((short) 12, this, bundle, emoticon, Boolean.valueOf(z16), str, Boolean.valueOf(z17));
        }
        bundle.putString(EmotionConstants.DISPLAY_TYPE, str);
        File file = new File(j.c(emoticon.epId, emoticon.eId));
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, this, downloadParams, bundle, emoticon, Boolean.valueOf(z16), str, Boolean.valueOf(z17));
        }
        int i3 = emoticon.jobType;
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
                            QLog.d("PicEmotionDownloader", 2, "decodeFile jobType not supported: " + i3);
                        }
                        return null;
                    }
                }
            }
            return decodeMagicFile(bundle, emoticon, z16, str, z17);
        }
        bundle.putString(EmotionConstants.DISPLAY_TYPE, str);
        String c16 = j.c(emoticon.epId, emoticon.eId);
        if (downloadParams.useApngImage) {
            c16 = j.b(emoticon.epId, emoticon.eId);
        }
        File file = new File(c16);
        if (QLog.isColorLevel()) {
            QLog.d("PicEmotionDownloader", 2, "decodeFile showType: " + str, ", path: ", c16, ", exists=", Boolean.valueOf(file.exists()));
        }
        if (!file.exists()) {
            return decodeBitmapFile(bundle, emoticon, z16, z17, i3);
        }
        try {
            if (com.tencent.qqnt.emotion.emosm.b.q(c16)) {
                return decodeGifFile(downloadParams, str, c16);
            }
            if (downloadParams.useApngImage) {
                return decodeApngImage(downloadParams, c16);
            }
            if (QLog.isColorLevel()) {
                QLog.d("PicEmotionDownloader", 2, "decodeFile getDecryptFileData,path=" + c16);
            }
            byte[] c17 = com.tencent.qqnt.emotion.utils.a.c(c16);
            if (c17 != null) {
                return decodeDecryptFileData(c16, c17);
            }
            return null;
        } catch (FileNotFoundException e16) {
            QLog.e("PicEmotionDownloader", 1, "decode MARKET File", e16);
            return null;
        } catch (IOException e17) {
            QLog.e("PicEmotionDownloader", 1, "decode MARKET File", e17);
            return null;
        } catch (Exception e18) {
            QLog.e("PicEmotionDownloader", 1, "decode MARKET File", e18);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.temp.transfile.AbsDownloader
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        String str;
        AppRuntime appRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (File) iPatchRedirector.redirect((short) 3, this, outputStream, downloadParams, uRLDrawableHandler);
        }
        if (downloadParams == null) {
            if (QLog.isColorLevel()) {
                QLog.d("PicEmotionDownloader", 2, "downloadImage| config is null");
            }
            throw new FileDownloadFailedException(9302, 0L, "downloadImage config is null", false, false);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("PicEmotionDownloader", 4, "downloadImage| useGifAnimation=", Boolean.valueOf(downloadParams.useGifAnimation), " url.toString=", downloadParams.url);
        }
        Emoticon convertToNtEmoticon = ((IAIOEmoPanelApi) com.tencent.qqnt.aio.adapter.a.b(IAIOEmoPanelApi.class)).convertToNtEmoticon(downloadParams.tag);
        if (convertToNtEmoticon != null) {
            Header header = downloadParams.getHeader("my_uin");
            if (header != null) {
                str = header.getValue();
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("PicEmotionDownloader", 2, "downloadImage| uin is null");
                }
                throw new FileDownloadFailedException(9302, 0L, "can't find myUin!", false, false);
            }
            if (QLog.isColorLevel()) {
                QLog.d("PicEmotionDownloader", 2, "downloadImage| myUin:" + str);
            }
            try {
                appRuntime = this.f356230d.getAppRuntime(str);
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("PicEmotionDownloader", 2, "exception:" + th5.getMessage());
                }
                String lastLoginUin = MobileQQ.sMobileQQ.getLastLoginUin();
                AppRuntime appRuntime2 = this.f356230d.getAppRuntime(lastLoginUin);
                if (QLog.isColorLevel()) {
                    QLog.d("PicEmotionDownloader", 2, "downloadImage| a second time: uin->" + lastLoginUin);
                }
                appRuntime = appRuntime2;
            }
            if (appRuntime == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("PicEmotionDownloader", 2, "downloadImage app is null");
                }
                throw new FileDownloadFailedException(9301, 0L, "mApp is null", false, false);
            }
            Bundle bundle = new Bundle();
            downloadParams.tag = bundle;
            bundle.putSerializable("emoticon_key", convertToNtEmoticon);
            c cVar = new c(appRuntime);
            b(convertToNtEmoticon, cVar, a(downloadParams, convertToNtEmoticon, cVar, bundle, EmotionConstants.AIO_PREVIEW), uRLDrawableHandler);
            return new File(AppConstants.SDCARD_PATH);
        }
        throw new FileDownloadFailedException(9302, 0L, "downloadImage can't find emoticon!", false, false);
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public boolean gifHasDifferentState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return true;
    }

    protected boolean isGrayPic(DownloadParams downloadParams, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) downloadParams, (Object) str)).booleanValue();
        }
        if (str.equals(EmotionConstants.FROM_PANEL)) {
            String file = downloadParams.url.getFile();
            if (!TextUtils.isEmpty(file) && file.endsWith(MagicFaceAdapter.MAGIC_GRAY_PIC)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.temp.transfile.AbsDownloader, com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public File loadImageFile(DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) uRLDrawableHandler);
        }
        return super.loadImageFile(downloadParams, uRLDrawableHandler);
    }
}
