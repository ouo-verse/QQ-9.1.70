package com.tencent.image;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes7.dex */
public class Utils {
    static IPatchRedirector $redirector_ = null;
    public static final String AIO_PIC_DISPATCH_WAIT = "AioPicDispatchWait";
    public static final String AIO_PIC_DOWNLOAD_WAIT = "AioPicDownloadWait";
    private static long[] CRCTable = null;
    public static final byte[] HEIF_SIGNATURE;
    private static final long INITIALCRC = -1;
    private static final long POLY64REV = -7661587058870466123L;
    public static final String PROTOCOL_CHAT_THUMB = "chatthumb";
    public static final String TAG = "URLDrawable.Utils";
    private static boolean init;
    private static ThreadLocal<LinkedList<Long>> sBeginTimeList;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12752);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HEIF_SIGNATURE = new byte[]{0, 0, 0, 24, 102, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, PublicAccountH5AbilityPluginImpl.OPENCAMERA, 104, 101, 105, 99};
        init = false;
        CRCTable = new long[256];
        sBeginTimeList = new ThreadLocal<>();
    }

    Utils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static final long Crc64Long(String str) {
        if (str != null && str.length() != 0) {
            if (!init) {
                for (int i3 = 0; i3 < 256; i3++) {
                    long j3 = i3;
                    for (int i16 = 0; i16 < 8; i16++) {
                        if ((((int) j3) & 1) != 0) {
                            j3 = (j3 >> 1) ^ POLY64REV;
                        } else {
                            j3 >>= 1;
                        }
                    }
                    CRCTable[i3] = j3;
                }
                init = true;
            }
            int length = str.length();
            long j16 = -1;
            for (int i17 = 0; i17 < length; i17++) {
                j16 = (j16 >> 8) ^ CRCTable[(str.charAt(i17) ^ ((int) j16)) & 255];
            }
            return j16;
        }
        return 0L;
    }

    public static final String Crc64String(String str) {
        return Long.toString(Crc64Long(str), 16);
    }

    public static void beginPile() {
        if (URLDrawable.depImp.mLog.isColorLevel()) {
            LinkedList<Long> linkedList = sBeginTimeList.get();
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                sBeginTimeList.set(linkedList);
            }
            linkedList.addFirst(Long.valueOf(SystemClock.uptimeMillis()));
        }
    }

    public static int calculateInSampleSize(Rect rect, int i3, int i16) {
        int i17 = 1;
        if (i3 != 0 && i16 != 0 && i3 != -1 && i16 != -1) {
            int width = rect.width();
            int height = rect.height();
            while (true) {
                if (height <= i16 && width <= i3) {
                    break;
                }
                int round = Math.round(height / i16);
                int round2 = Math.round(width / i3);
                if (round <= round2) {
                    round = round2;
                }
                if (round < 2) {
                    break;
                }
                width /= 2;
                height /= 2;
                i17 *= 2;
            }
            return i17;
        }
        if (rect.width() * rect.height() <= 5000000) {
            return 1;
        }
        if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.d("URLDrawable.Utils", 2, "calculateInSampleSize options.outWidth*options.outHeight=" + (rect.width() * rect.height()));
        }
        return 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0039 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void copyFile(File file, File file2) throws IOException {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (IOException e16) {
                e = e16;
                fileOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
            }
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read <= 0) {
                        break;
                    } else {
                        fileOutputStream.write(bArr, 0, read);
                    }
                }
                fileOutputStream.flush();
                try {
                    fileInputStream2.close();
                } catch (IOException unused) {
                }
                try {
                    fileOutputStream.close();
                } catch (IOException unused2) {
                }
            } catch (IOException e17) {
                e = e17;
                fileInputStream = fileInputStream2;
                try {
                    throw e;
                } catch (Throwable th6) {
                    th = th6;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (fileOutputStream == null) {
                        try {
                            fileOutputStream.close();
                            throw th;
                        } catch (IOException unused4) {
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
                if (fileOutputStream == null) {
                }
            }
        } catch (IOException e18) {
            e = e18;
            fileOutputStream = null;
        } catch (Throwable th8) {
            th = th8;
            fileOutputStream = null;
        }
    }

    public static void disableConnectionReuseIfNecessary() {
        if (hasHttpConnectionBug()) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    public static void endPile(String str, String str2) {
        if (URLDrawable.depImp.mLog.isColorLevel()) {
            LinkedList<Long> linkedList = sBeginTimeList.get();
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                sBeginTimeList.set(linkedList);
                linkedList.addFirst(Long.valueOf(SystemClock.uptimeMillis()));
            }
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 1; i3 < linkedList.size(); i3++) {
                sb5.append("    ");
            }
            sb5.append(str2);
            sb5.append(":cost ");
            sb5.append(SystemClock.uptimeMillis() - sBeginTimeList.get().removeFirst().longValue());
            sb5.append("ms");
            URLDrawable.depImp.mLog.i(str, 2, sb5.toString());
        }
    }

    @TargetApi(11)
    public static <Params, Progress, Result> void executeAsyncTaskOnNewThreadPool(Executor executor, AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        if (executor != null) {
            asyncTask.executeOnExecutor(executor, paramsArr);
        } else {
            asyncTask.execute(paramsArr);
        }
    }

    @TargetApi(11)
    public static <Params, Progress, Result> void executeAsyncTaskOnSerialExcuter(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        asyncTask.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, paramsArr);
    }

    @TargetApi(11)
    public static <Params, Progress, Result> void executeAsyncTaskOnThreadPool(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramsArr);
    }

    @SuppressLint({"NewApi"})
    public static int getBitmapSize(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getByteCount();
    }

    @SuppressLint({"NewApi"})
    public static File getExternalCacheDir(Context context) {
        if (hasExternalCacheDir()) {
            return context.getExternalCacheDir();
        }
        return new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/imagecache/"));
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0036 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getHeifOrientation(String str) {
        ExifInterface exifInterface;
        try {
            exifInterface = new ExifInterface(str);
        } catch (IOException e16) {
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                URLDrawable.depImp.mLog.e("URLDrawable.Utils", 2, "new ExifInterface", e16);
            }
            exifInterface = null;
            if (exifInterface == null) {
            }
        } catch (RuntimeException e17) {
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                URLDrawable.depImp.mLog.e("URLDrawable.Utils", 2, "new ExifInterface", e17);
            }
            exifInterface = null;
            if (exifInterface == null) {
            }
        }
        if (exifInterface == null) {
            return 1;
        }
        return exifInterface.getAttributeInt("Orientation", 1);
    }

    public static int getMemoryClass(Context context) {
        return ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getMemoryClass();
    }

    @SuppressLint({"NewApi"})
    public static long getUsableSpace(File file) {
        return file.getUsableSpace();
    }

    public static boolean hasActionBar() {
        return true;
    }

    public static boolean hasExternalCacheDir() {
        return true;
    }

    public static boolean hasHttpConnectionBug() {
        return false;
    }

    @SuppressLint({"NewApi"})
    public static boolean isExternalStorageRemovable() {
        return Environment.isExternalStorageRemovable();
    }

    public static boolean isHeifFile(String str) {
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(new File(str), "r");
                try {
                    byte[] bArr = new byte[HEIF_SIGNATURE.length];
                    randomAccessFile2.read(bArr);
                    int i3 = 0;
                    while (true) {
                        byte[] bArr2 = HEIF_SIGNATURE;
                        if (i3 < bArr2.length) {
                            if (i3 >= 4 && bArr[i3] != bArr2[i3]) {
                                try {
                                    randomAccessFile2.close();
                                } catch (Exception e16) {
                                    e16.printStackTrace();
                                }
                                return false;
                            }
                            i3++;
                        } else {
                            try {
                                randomAccessFile2.close();
                                return true;
                            } catch (Exception e17) {
                                e17.printStackTrace();
                                return true;
                            }
                        }
                    }
                } catch (IOException e18) {
                    e = e18;
                    randomAccessFile = randomAccessFile2;
                    e.printStackTrace();
                    try {
                        randomAccessFile.close();
                    } catch (Exception e19) {
                        e19.printStackTrace();
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    randomAccessFile = randomAccessFile2;
                    try {
                        randomAccessFile.close();
                    } catch (Exception e26) {
                        e26.printStackTrace();
                    }
                    throw th;
                }
            } catch (IOException e27) {
                e = e27;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i3, int i16) {
        return calculateInSampleSize(new Rect(0, 0, options.outWidth, options.outHeight), i3, i16);
    }
}
