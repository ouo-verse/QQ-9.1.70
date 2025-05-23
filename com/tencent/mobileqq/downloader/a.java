package com.tencent.mobileqq.downloader;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.NativeGifFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a extends AbsDownloader {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean a(Context context, String str, String str2) {
        String c16 = c(str);
        String str3 = e(context) + File.separator + c16;
        for (int i3 = 0; i3 < 3; i3++) {
            File file = new File(str3);
            if (file.exists() && (TextUtils.isEmpty(str2) || str2.equalsIgnoreCase(FileUtils.calcMd5(str3)))) {
                return true;
            }
            if (file.exists()) {
                file.delete();
            }
            b(context, str, c16);
        }
        QLog.i("AssetImgDownloader", 1, "checkFileAndCopy:file copy fail");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00b2 A[Catch: IOException -> 0x00ae, TRY_LEAVE, TryCatch #8 {IOException -> 0x00ae, blocks: (B:48:0x00aa, B:41:0x00b2), top: B:47:0x00aa }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void b(Context context, String str, String str2) {
        FileOutputStream fileOutputStream;
        InputStream open;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && context != null) {
            long currentTimeMillis = System.currentTimeMillis();
            File file = new File(e(context));
            if (!file.exists()) {
                file.mkdirs();
            }
            InputStream inputStream = null;
            try {
                try {
                    File file2 = new File(file, str2);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    open = context.getResources().getAssets().open(str);
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                    } catch (Exception e16) {
                        inputStream = open;
                        e = e16;
                        fileOutputStream = null;
                    } catch (Throwable th5) {
                        inputStream = open;
                        th = th5;
                        fileOutputStream = null;
                    }
                } catch (Exception e17) {
                    e = e17;
                    fileOutputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    fileOutputStream = null;
                }
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = open.read(bArr);
                        if (read <= 0) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, read);
                        }
                    }
                    open.close();
                    fileOutputStream.close();
                } catch (Exception e18) {
                    inputStream = open;
                    e = e18;
                    try {
                        QLog.e("AssetImgDownloader", 1, "copy accets file error! ", e);
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        QLog.e("AssetImgDownloader", 1, "copy accets file cost time:", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        return;
                    } catch (Throwable th7) {
                        th = th7;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e19) {
                                e19.printStackTrace();
                                throw th;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th8) {
                    inputStream = open;
                    th = th8;
                    if (inputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (IOException e26) {
                e26.printStackTrace();
            }
            QLog.e("AssetImgDownloader", 1, "copy accets file cost time:", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return;
        }
        QLog.e("AssetImgDownloader", 1, " assetFilePath or fileName or context == null");
    }

    private static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.split("/")[r1.length - 1];
    }

    private static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = str.split("\\?")[0];
        if (str2.startsWith("/") && str2.length() > 1) {
            return str2.substring(1);
        }
        return str2;
    }

    private static String e(Context context) {
        return context.getFilesDir().getAbsolutePath() + File.separator + "asset_img";
    }

    private HashMap<String, String> f(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        String[] split = str.split("\\?");
        if (split.length != 2) {
            return hashMap;
        }
        for (String str2 : split[1].split(ContainerUtils.FIELD_DELIMITER)) {
            if (str2.split(ContainerUtils.KEY_VALUE_DELIMITER).length == 2) {
                int indexOf = str2.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);
                hashMap.put(str2.substring(0, indexOf), str2.substring(indexOf + 1));
            }
        }
        return hashMap;
    }

    protected Object decodeApngImage(File file) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this, (Object) file);
        }
        if (QLog.isColorLevel()) {
            QLog.d("AssetImgDownloader", 2, "decodeFile isAPNGFile, path = " + file.getAbsolutePath());
        }
        ApngImage apngImage = new ApngImage(file, true, null);
        apngImage.setDensity(320);
        return apngImage;
    }

    protected Object decodeBitmap(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        return BitmapFactory.decodeFile(str);
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, this, file, downloadParams, uRLDrawableHandler);
        }
        if (file == null) {
            return null;
        }
        if (GifDrawable.isGifFile(file)) {
            return decodeGifFile(file);
        }
        if (isApngFile(file)) {
            try {
                return decodeApngImage(file);
            } catch (Throwable th5) {
                QLog.e("AssetImgDownloader", 2, th5, new Object[0]);
                return decodeBitmap(file.getAbsolutePath());
            }
        }
        return decodeBitmap(file.getAbsolutePath());
    }

    protected Object decodeGifFile(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, (Object) this, (Object) file);
        }
        return NativeGifFactory.getNativeGifObject(file, false);
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, this, outputStream, downloadParams, uRLDrawableHandler);
        }
        String host = downloadParams.url.getHost();
        String file = downloadParams.url.getFile();
        QLog.d("AssetImgDownloader", 1, String.format("hostType[%s], fileInfo[%s]", host, file));
        if (TextUtils.isEmpty(file)) {
            return null;
        }
        String d16 = d(file);
        String c16 = c(d16);
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        if (applicationContext == null) {
            QLog.d("AssetImgDownloader", 1, String.format("Context null", new Object[0]));
            return null;
        }
        String str = e(applicationContext) + File.separator + c16;
        QLog.d("AssetImgDownloader", 1, String.format("fileName[%s], filePath[%s]", c16, str));
        if (!a(applicationContext, d16, f(file).get("md5"))) {
            return null;
        }
        return new File(str);
    }

    protected boolean isApngFile(File file) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) file)).booleanValue();
        }
        return ApngDrawable.isApngFile(file);
    }
}
