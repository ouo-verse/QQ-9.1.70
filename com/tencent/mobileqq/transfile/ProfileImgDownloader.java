package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.vas.profilecard.util.LevelUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import mqq.app.AppRuntime;

/* loaded from: classes19.dex */
public class ProfileImgDownloader extends AbsDownloader {
    static IPatchRedirector $redirector_ = null;
    public static final String PROTOCOL_PROFILE_IMG_BIG = "profile_img_big";
    public static final String PROTOCOL_PROFILE_IMG_BIG_FHD = "profile_img_big_fhd";
    public static final String PROTOCOL_PROFILE_IMG_ICON = "profile_img_icon";
    public static final String PROTOCOL_PROFILE_IMG_THUMB = "profile_img_thumb";
    protected static final String TAG = "ProfileImgDownloader";

    public ProfileImgDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i3, int i16) {
        int i17 = 1;
        if (i3 != 0 && i16 != 0 && i3 != -1 && i16 != -1) {
            int i18 = options.outHeight;
            int i19 = options.outWidth;
            while (true) {
                if (i18 <= i16 && i19 <= i3) {
                    break;
                }
                int round = Math.round(i18 / i16);
                int round2 = Math.round(i19 / i3);
                if (round <= round2) {
                    round = round2;
                }
                if (round < 2) {
                    break;
                }
                i19 /= 2;
                i18 /= 2;
                i17 *= 2;
            }
        }
        return i17;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x00b0: MOVE (r0 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:177), block:B:35:0x00b0 */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        BufferedInputStream bufferedInputStream;
        OutOfMemoryError e16;
        InputStream inputStream;
        BitmapFactory.Options options;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, this, file, downloadParams, uRLDrawableHandler);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "decodeFile() url = " + downloadParams.url + ", path = " + file.getAbsolutePath());
        }
        if (PROTOCOL_PROFILE_IMG_THUMB.equals(downloadParams.url.getProtocol())) {
            InputStream inputStream2 = null;
            try {
                try {
                    options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(file.getAbsolutePath(), options);
                    options.inSampleSize = calculateInSampleSize(options, 160, 160);
                    options.inJustDecodeBounds = false;
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file.getAbsolutePath()));
                } catch (OutOfMemoryError e17) {
                    bufferedInputStream = null;
                    e16 = e17;
                } catch (Throwable th5) {
                    th = th5;
                    if (inputStream2 != null) {
                    }
                    throw th;
                }
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused) {
                    }
                    return decodeStream;
                } catch (OutOfMemoryError e18) {
                    e16 = e18;
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, "decodeFile(): OutOfMemoryError, " + e16.getMessage());
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return super.decodeFile(file, downloadParams, uRLDrawableHandler);
                }
            } catch (Throwable th6) {
                th = th6;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        }
        return super.decodeFile(file, downloadParams, uRLDrawableHandler);
    }

    /* JADX WARN: Type inference failed for: r4v9, types: [boolean] */
    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        boolean z16;
        int length;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, this, outputStream, downloadParams, uRLDrawableHandler);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "downloadImage() url = " + downloadParams.url);
        }
        String protocol2 = downloadParams.url.getProtocol();
        String host = downloadParams.url.getHost();
        String file = downloadParams.url.getFile();
        if (host != null && (host.startsWith("[") || host.endsWith("]"))) {
            ?? startsWith = host.startsWith("[");
            if (host.endsWith("]")) {
                length = host.length() - 1;
            } else {
                length = host.length();
            }
            if (startsWith < length) {
                host = host.substring(startsWith == true ? 1 : 0, length);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "downloadImage() [" + protocol2 + "," + host + "," + file + "]");
        }
        if (!TextUtils.isEmpty(file)) {
            File file2 = new File(file);
            if (!file2.exists()) {
                if (PROTOCOL_PROFILE_IMG_ICON.equals(protocol2)) {
                    String str = file + "_temp";
                    File file3 = new File(str);
                    if (file3.exists()) {
                        file3.delete();
                    }
                    File parentFile = file3.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    try {
                        z16 = HttpDownloadUtil.download((AppRuntime) null, MsfSdkUtils.insertMtype("qzone", host), file3);
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.i(LevelUtil.PROFILE_CARD_TAG, 2, "downloadQzonePic() " + e16.toString());
                        }
                        z16 = false;
                    }
                    if (z16) {
                        FileUtils.copyFile(str, file);
                    } else if (QLog.isColorLevel()) {
                        QLog.i(LevelUtil.PROFILE_CARD_TAG, 2, "downloadQzonePic() fail");
                    }
                    file3.delete();
                } else {
                    throw new RuntimeException("downloadImage() file not exist, path = " + file);
                }
            }
            return file2;
        }
        throw new RuntimeException("downloadImage() path is null");
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public boolean useDiskCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }
}
