package com.tencent.image.downloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.SystemClock;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.DownloadParams;
import com.tencent.image.JpegExifReader;
import com.tencent.image.LocaleFileDownloader;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.SliceBitmap;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.Utils;
import com.tencent.image.VideoDrawable;
import com.tencent.image.utils.PicFormatUtils;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.pic.JpegDecompressor;
import com.tencent.mobileqq.pic.JpegOptions;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.FileInputStream;

/* compiled from: P */
/* loaded from: classes7.dex */
public class GalleryDecoder extends LocaleFileDownloader {
    static IPatchRedirector $redirector_ = null;
    public static final int DECODE_TYPE_GALLERY = 1;
    public static final int DECODE_TYPE_NORMAL = 0;
    public static final int DECODE_TYPE_NOSAMPLE = 2;
    public static final int DECODE_TYPE_VIDEO = 3;
    private static final int FILE_LENGTH_LIMIT = 5242880;
    private static final float HEIGHER_IMGE_FACTOR = 1.5f;
    private static final String TAG = "GalleryDecoder";
    private float density;
    private Context mContext;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class DownloadParamsExtraInfo {
        static IPatchRedirector $redirector_;
        public int mCornerRadius;

        public DownloadParamsExtraInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public GalleryDecoder(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.mContext = context;
            this.density = context.getResources().getDisplayMetrics().density;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0075, code lost:
    
        if ((1.5f * r8) >= r9) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x007d, code lost:
    
        if ((1.5f * r8) >= r9) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0087, code lost:
    
        if (r8 < (1.5f * r9)) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int calculateSampleSize(int i3, int i16, int i17, int i18, int i19, int i26) {
        float f16;
        float f17;
        float f18;
        float f19;
        int i27;
        int i28 = 1;
        if ((i26 == 2 || i17 == Integer.MAX_VALUE || i18 == Integer.MAX_VALUE) && i3 * i16 <= this.mContext.getResources().getDisplayMetrics().widthPixels * this.mContext.getResources().getDisplayMetrics().heightPixels * 4) {
            return 1;
        }
        if (i26 == 1) {
            if (i19 == 5 || i19 == 6 || i19 == 7 || i19 == 8) {
                i16 = i3;
                i3 = i16;
            }
            if (i3 > i17 * 2 && i16 > i18) {
                float f26 = this.density;
                i3 = (int) ((i3 * f26) + 0.5d);
                i16 = (int) ((i16 * f26) + 0.5d);
            }
            int i29 = (i16 * i17) / i3;
            if (i3 >= i17) {
                if (i18 < i29) {
                    float f27 = i18;
                    if (1.5f * f27 >= i29) {
                        f18 = f27 / i16;
                        if (this.density > 2.0f) {
                            f19 = ((1.0f / f18) * 3.0f) / 4.0f;
                        } else {
                            f19 = 1.0f / f18;
                        }
                        i27 = (int) f19;
                        if (i27 <= 1) {
                            return 1;
                        }
                        if (i27 > 64) {
                            if (URLDrawable.depImp.mLog.isColorLevel()) {
                                URLDrawable.depImp.mLog.d(getLogTag(), 2, "the pic it fxxking large.....");
                            }
                            return 64;
                        }
                        for (int i36 = 64; i36 != 0; i36 >>= 1) {
                            int i37 = i27 & i36;
                            if (i37 != 0) {
                                return i37;
                            }
                        }
                        return 1;
                    }
                }
                f17 = i17;
                f16 = i3;
                f18 = f17 / f16;
                if (this.density > 2.0f) {
                }
                i27 = (int) f19;
                if (i27 <= 1) {
                }
            } else {
                if (i16 < i18) {
                    if (i18 >= i29) {
                        f16 = i3;
                        f17 = i17;
                    } else {
                        f16 = i16;
                        f17 = i18;
                    }
                } else {
                    if (i16 > i18) {
                        f16 = i16;
                        f17 = i18;
                    }
                    f18 = 1.0f;
                }
                if (this.density > 2.0f) {
                }
                i27 = (int) f19;
                if (i27 <= 1) {
                }
            }
        } else {
            if (i17 != 0 && i18 != 0 && i17 != -1 && i18 != -1) {
                while (true) {
                    if (i16 <= i18 && i3 <= i17) {
                        break;
                    }
                    int round = Math.round(i16 / i18);
                    int round2 = Math.round(i3 / i17);
                    if (round <= round2) {
                        round = round2;
                    }
                    if (round < 2) {
                        break;
                    }
                    i3 /= 2;
                    i16 /= 2;
                    i28 *= 2;
                }
            }
            return i28;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01d2 A[Catch: all -> 0x0215, TRY_LEAVE, TryCatch #2 {all -> 0x0215, blocks: (B:67:0x0193, B:69:0x0197, B:70:0x01b4, B:59:0x01c8, B:61:0x01d2), top: B:66:0x0193 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0193 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x018e A[EDGE_INSN: B:90:0x018e->B:56:0x018e BREAK  A[LOOP:0: B:38:0x0099->B:84:0x018a], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Object decodeFileNormal(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler, int i3) throws Exception {
        boolean z16;
        BitmapFactory.Options options;
        boolean z17;
        int i16;
        Object obj;
        FileInputStream fileInputStream = new FileInputStream(file);
        boolean z18 = false;
        try {
            byte[] bArr = new byte[2];
            fileInputStream.read(bArr);
            int i17 = (bArr[1] & 255) | ((bArr[0] << 8) & 65280);
            fileInputStream.close();
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                Bitmap.Config config = Bitmap.Config.ARGB_8888;
                Object obj2 = null;
                try {
                    try {
                        if (i17 != 8273 && i17 != 16973) {
                            if (i17 != 18249) {
                                if (i17 != 18761 && i17 != 19789 && i17 != 65496) {
                                    z16 = false;
                                    options = new BitmapFactory.Options();
                                    options.inJustDecodeBounds = true;
                                    options.inPreferredConfig = config;
                                    options.inDensity = 160;
                                    options.inTargetDensity = 160;
                                    options.inScreenDensity = 160;
                                    SafeBitmapFactory.decodeStream(fileInputStream2, null, options);
                                    int i18 = options.outWidth;
                                    int i19 = options.outHeight;
                                    fileInputStream2.close();
                                    if (z16) {
                                        try {
                                            downloadParams.outOrientation = JpegExifReader.readOrientation(file.getAbsolutePath());
                                        } catch (Throwable th5) {
                                            th = th5;
                                            z18 = true;
                                            fileInputStream = fileInputStream2;
                                            if (!z18) {
                                            }
                                            throw th;
                                        }
                                    }
                                    options.inJustDecodeBounds = false;
                                    int calculateSampleSize = calculateSampleSize(i18, i19, downloadParams.reqWidth, downloadParams.reqHeight, downloadParams.outOrientation, i3);
                                    i16 = 1;
                                    while (true) {
                                        if (i16 <= 3) {
                                            break;
                                        }
                                        try {
                                            try {
                                                options.inSampleSize = calculateSampleSize;
                                                SafeBitmapFactory.SafeDecodeOption safeDecodeOption = new SafeBitmapFactory.SafeDecodeOption();
                                                safeDecodeOption.inOptions = options;
                                                safeDecodeOption.inNeedFlashBackTest = URLDrawable.depImp.mVersion.isPublicVersion();
                                                Bitmap safeDecode = SafeBitmapFactory.safeDecode(file.getAbsolutePath(), safeDecodeOption);
                                                if (URLDrawable.depImp.mLog.isColorLevel()) {
                                                    URLDrawable.depImp.mLog.d(getLogTag(), 2, "GalleryDecoder regionDecodeInfo:" + safeDecodeOption.toString());
                                                }
                                                reportSafeDecode(safeDecodeOption);
                                                safeDecode.setDensity(160);
                                                if (SliceBitmap.needSliceBitmap(safeDecode)) {
                                                    try {
                                                        Object sliceBitmap = new SliceBitmap(safeDecode);
                                                        safeDecode.recycle();
                                                        obj = sliceBitmap;
                                                    } catch (Exception unused) {
                                                        safeDecode.recycle();
                                                        throw new OutOfMemoryError("slice failed.");
                                                    }
                                                } else {
                                                    Object obj3 = downloadParams.mExtraInfo;
                                                    if (obj3 != null && DownloadParamsExtraInfo.class.isInstance(obj3)) {
                                                        int i26 = ((DownloadParamsExtraInfo) downloadParams.mExtraInfo).mCornerRadius;
                                                        if (i26 > 0) {
                                                            RoundRectBitmap resizeAndClipBitmap = resizeAndClipBitmap(safeDecode, i26);
                                                            boolean equals = resizeAndClipBitmap.mBitmap.equals(safeDecode);
                                                            obj = resizeAndClipBitmap;
                                                            if (!equals) {
                                                                safeDecode.recycle();
                                                                obj = resizeAndClipBitmap;
                                                            }
                                                        }
                                                    } else {
                                                        obj2 = safeDecode;
                                                    }
                                                }
                                                obj2 = obj;
                                            } catch (NullPointerException e16) {
                                                e16.printStackTrace();
                                                return null;
                                            }
                                        } catch (OutOfMemoryError e17) {
                                            try {
                                                if (URLDrawable.depImp.mLog.isColorLevel()) {
                                                    URLDrawable.depImp.mLog.d(getLogTag(), 2, "DecodeFile ERROR,oom retryCount=" + i16 + ",options.inSampleSize=" + options.inSampleSize + JefsClass.INDEX_URL + downloadParams.urlStr + ",oom.msg:" + e17.getMessage());
                                                }
                                                calculateSampleSize *= 2;
                                                System.gc();
                                                Thread.yield();
                                                System.gc();
                                                i16++;
                                            } catch (Throwable th6) {
                                                th = th6;
                                                fileInputStream = fileInputStream2;
                                                z18 = true;
                                                if (!z18) {
                                                }
                                                throw th;
                                            }
                                        }
                                    }
                                    z17 = true;
                                    if (options.inSampleSize > 1) {
                                        try {
                                            if (downloadParams.mAutoScaleByDensity) {
                                                downloadParams.outWidth = (int) Math.ceil(i18 * this.density);
                                                downloadParams.outHeight = (int) Math.ceil(i19 * this.density);
                                            } else {
                                                downloadParams.outWidth = (int) Math.ceil(i18);
                                                downloadParams.outHeight = (int) Math.ceil(i19);
                                            }
                                        } catch (Throwable th7) {
                                            th = th7;
                                            z18 = z17;
                                            fileInputStream = fileInputStream2;
                                            if (!z18) {
                                                fileInputStream.close();
                                            }
                                            throw th;
                                        }
                                    }
                                    if (URLDrawable.depImp.mLog.isColorLevel()) {
                                        URLDrawable.depImp.mLog.d(getLogTag(), 2, "image file size:" + file.length() + " , bound:" + options.outWidth + HippyTKDListViewAdapter.X + options.outHeight + " , sampleSize: " + options.inSampleSize);
                                    }
                                    return obj2;
                                }
                                z16 = true;
                            } else {
                                fileInputStream2.close();
                                return null;
                            }
                        } else {
                            z16 = false;
                        }
                        int calculateSampleSize2 = calculateSampleSize(i18, i19, downloadParams.reqWidth, downloadParams.reqHeight, downloadParams.outOrientation, i3);
                        i16 = 1;
                        while (true) {
                            if (i16 <= 3) {
                            }
                        }
                        z17 = true;
                        if (options.inSampleSize > 1) {
                        }
                        if (URLDrawable.depImp.mLog.isColorLevel()) {
                        }
                        return obj2;
                    } catch (Throwable th8) {
                        th = th8;
                        z17 = true;
                    }
                    options.inJustDecodeBounds = false;
                } catch (Throwable th9) {
                    th = th9;
                    z17 = true;
                }
                config = Bitmap.Config.RGB_565;
                options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                options.inPreferredConfig = config;
                options.inDensity = 160;
                options.inTargetDensity = 160;
                options.inScreenDensity = 160;
                SafeBitmapFactory.decodeStream(fileInputStream2, null, options);
                int i182 = options.outWidth;
                int i192 = options.outHeight;
                fileInputStream2.close();
                if (z16) {
                }
            } catch (Throwable th10) {
                th = th10;
            }
        } catch (Throwable th11) {
            th = th11;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005d A[Catch: all -> 0x01bd, RuntimeException -> 0x01c0, TryCatch #5 {RuntimeException -> 0x01c0, blocks: (B:9:0x000d, B:23:0x0047, B:25:0x005d, B:26:0x0067, B:31:0x0083, B:37:0x0095, B:39:0x00b3, B:41:0x00b7, B:43:0x00bf, B:45:0x00c7, B:47:0x00d3, B:64:0x00a7, B:65:0x00b2, B:49:0x0134, B:51:0x0138, B:53:0x013c, B:54:0x0159, B:55:0x016d, B:57:0x0177, B:67:0x00db, B:69:0x00e5, B:71:0x0125, B:75:0x0045), top: B:8:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0138 A[Catch: all -> 0x01bd, RuntimeException -> 0x01c0, TryCatch #5 {RuntimeException -> 0x01c0, blocks: (B:9:0x000d, B:23:0x0047, B:25:0x005d, B:26:0x0067, B:31:0x0083, B:37:0x0095, B:39:0x00b3, B:41:0x00b7, B:43:0x00bf, B:45:0x00c7, B:47:0x00d3, B:64:0x00a7, B:65:0x00b2, B:49:0x0134, B:51:0x0138, B:53:0x013c, B:54:0x0159, B:55:0x016d, B:57:0x0177, B:67:0x00db, B:69:0x00e5, B:71:0x0125, B:75:0x0045), top: B:8:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0177 A[Catch: all -> 0x01bd, RuntimeException -> 0x01c0, TRY_LEAVE, TryCatch #5 {RuntimeException -> 0x01c0, blocks: (B:9:0x000d, B:23:0x0047, B:25:0x005d, B:26:0x0067, B:31:0x0083, B:37:0x0095, B:39:0x00b3, B:41:0x00b7, B:43:0x00bf, B:45:0x00c7, B:47:0x00d3, B:64:0x00a7, B:65:0x00b2, B:49:0x0134, B:51:0x0138, B:53:0x013c, B:54:0x0159, B:55:0x016d, B:57:0x0177, B:67:0x00db, B:69:0x00e5, B:71:0x0125, B:75:0x0045), top: B:8:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0134 A[EDGE_INSN: B:73:0x0134->B:49:0x0134 BREAK  A[LOOP:0: B:28:0x0080->B:71:0x0125], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Object decodeFileNormalWithTrubo(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler, int i3) throws Exception {
        boolean z16;
        boolean z17;
        JpegOptions jpegOptions;
        int i16;
        Object obj;
        FileInputStream fileInputStream = null;
        r11 = null;
        Object obj2 = null;
        r11 = null;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                try {
                    FileInputStream fileInputStream3 = new FileInputStream(file);
                    try {
                        try {
                            byte[] bArr = new byte[2];
                            fileInputStream3.read(bArr);
                            int i17 = (bArr[1] & 255) | ((bArr[0] << 8) & 65280);
                            Bitmap.Config config = Bitmap.Config.ARGB_8888;
                            if (i17 != 8273 && i17 != 16973) {
                                if (i17 != 18249) {
                                    if (i17 != 18761 && i17 != 19789 && i17 != 65496) {
                                        z17 = false;
                                        jpegOptions = new JpegOptions();
                                        jpegOptions.inJustDecodeBounds = true;
                                        jpegOptions.inPreferredConfig = config;
                                        JpegDecompressor.decodeFile(file.getAbsolutePath(), jpegOptions);
                                        int i18 = jpegOptions.outWidth;
                                        int i19 = jpegOptions.outHeight;
                                        if (z17) {
                                            downloadParams.outOrientation = JpegExifReader.readOrientation(file.getAbsolutePath());
                                        }
                                        jpegOptions.inJustDecodeBounds = false;
                                        int calculateSampleSize = calculateSampleSize(i18, i19, downloadParams.reqWidth, downloadParams.reqHeight, downloadParams.outOrientation, i3);
                                        i16 = 1;
                                        while (true) {
                                            if (i16 <= 3) {
                                                break;
                                            }
                                            try {
                                                jpegOptions.inSampleSize = calculateSampleSize;
                                                Bitmap decodeFile = JpegDecompressor.decodeFile(file.getAbsolutePath(), jpegOptions);
                                                if (decodeFile == null) {
                                                    fileInputStream3.close();
                                                    return null;
                                                }
                                                decodeFile.setDensity(160);
                                                if (SliceBitmap.needSliceBitmap(decodeFile)) {
                                                    try {
                                                        Object sliceBitmap = new SliceBitmap(decodeFile);
                                                        decodeFile.recycle();
                                                        obj = sliceBitmap;
                                                    } catch (Exception unused) {
                                                        decodeFile.recycle();
                                                        throw new OutOfMemoryError("slice failed.");
                                                    }
                                                } else {
                                                    Object obj3 = downloadParams.mExtraInfo;
                                                    if (obj3 != null && DownloadParamsExtraInfo.class.isInstance(obj3)) {
                                                        int i26 = ((DownloadParamsExtraInfo) downloadParams.mExtraInfo).mCornerRadius;
                                                        if (i26 > 0) {
                                                            RoundRectBitmap resizeAndClipBitmap = resizeAndClipBitmap(decodeFile, i26);
                                                            boolean equals = resizeAndClipBitmap.mBitmap.equals(decodeFile);
                                                            obj = resizeAndClipBitmap;
                                                            if (!equals) {
                                                                decodeFile.recycle();
                                                                obj = resizeAndClipBitmap;
                                                            }
                                                        }
                                                    } else {
                                                        obj2 = decodeFile;
                                                    }
                                                }
                                                obj2 = obj;
                                            } catch (OutOfMemoryError e16) {
                                                if (URLDrawable.depImp.mLog.isColorLevel()) {
                                                    URLDrawable.depImp.mLog.d(getLogTag(), 2, "DecodeFile ERROR,oom retryCount=" + i16 + ",options.inSampleSize=" + jpegOptions.inSampleSize + JefsClass.INDEX_URL + downloadParams.urlStr + ",oom.msg:" + e16.getMessage());
                                                }
                                                calculateSampleSize *= 2;
                                                System.gc();
                                                Thread.yield();
                                                System.gc();
                                                i16++;
                                            }
                                        }
                                        if (jpegOptions.inSampleSize > 1) {
                                            if (downloadParams.mAutoScaleByDensity) {
                                                downloadParams.outWidth = (int) Math.ceil(i18 * this.density);
                                                downloadParams.outHeight = (int) Math.ceil(i19 * this.density);
                                            } else {
                                                downloadParams.outWidth = (int) Math.ceil(i18);
                                                downloadParams.outHeight = (int) Math.ceil(i19);
                                            }
                                        }
                                        if (URLDrawable.depImp.mLog.isColorLevel()) {
                                            URLDrawable.depImp.mLog.d(getLogTag(), 2, "image file size:" + file.length() + " , bound:" + jpegOptions.outWidth + HippyTKDListViewAdapter.X + jpegOptions.outHeight + " , sampleSize: " + jpegOptions.inSampleSize);
                                        }
                                        fileInputStream3.close();
                                        return obj2;
                                    }
                                    z16 = true;
                                } else {
                                    fileInputStream3.close();
                                    return null;
                                }
                            } else {
                                z16 = false;
                            }
                            config = Bitmap.Config.RGB_565;
                            z17 = z16;
                            jpegOptions = new JpegOptions();
                            jpegOptions.inJustDecodeBounds = true;
                            jpegOptions.inPreferredConfig = config;
                            JpegDecompressor.decodeFile(file.getAbsolutePath(), jpegOptions);
                            int i182 = jpegOptions.outWidth;
                            int i192 = jpegOptions.outHeight;
                            if (z17) {
                            }
                            jpegOptions.inJustDecodeBounds = false;
                            int calculateSampleSize2 = calculateSampleSize(i182, i192, downloadParams.reqWidth, downloadParams.reqHeight, downloadParams.outOrientation, i3);
                            i16 = 1;
                            while (true) {
                                if (i16 <= 3) {
                                }
                            }
                            if (jpegOptions.inSampleSize > 1) {
                            }
                            if (URLDrawable.depImp.mLog.isColorLevel()) {
                            }
                            fileInputStream3.close();
                            return obj2;
                        } catch (Throwable th5) {
                            th = th5;
                            fileInputStream = fileInputStream3;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                    } catch (RuntimeException e17) {
                        e = e17;
                        fileInputStream2 = fileInputStream3;
                        if (URLDrawable.depImp.mLog.isColorLevel()) {
                            URLDrawable.depImp.mLog.i(getLogTag(), 2, "GalleryDecoder.decodeFileNormalWithTrubo() error", e);
                        }
                        Object decodeFileNormal = decodeFileNormal(file, downloadParams, uRLDrawableHandler, i3);
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        return decodeFileNormal;
                    }
                } catch (RuntimeException e18) {
                    e = e18;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (RuntimeException e19) {
            e = e19;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x00c1 A[Catch: all -> 0x025d, TRY_ENTER, TryCatch #8 {all -> 0x025d, blocks: (B:20:0x0061, B:22:0x0093, B:25:0x00cb, B:105:0x00c1), top: B:19:0x0061 }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b6 A[Catch: all -> 0x008f, TRY_ENTER, TRY_LEAVE, TryCatch #10 {all -> 0x008f, blocks: (B:107:0x006b, B:24:0x00b6), top: B:106:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0140 A[Catch: all -> 0x00f8, OutOfMemoryError -> 0x0169, NullPointerException -> 0x016d, TryCatch #0 {NullPointerException -> 0x016d, blocks: (B:32:0x0119, B:35:0x011c, B:38:0x0122, B:40:0x0140, B:42:0x0144, B:44:0x014c, B:46:0x0154, B:48:0x0160, B:75:0x0134, B:76:0x013f), top: B:31:0x0119, outer: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0219 A[Catch: all -> 0x0258, TRY_LEAVE, TryCatch #4 {all -> 0x0258, blocks: (B:66:0x01d5, B:68:0x01d9, B:54:0x020f, B:56:0x0219, B:69:0x01f6), top: B:65:0x01d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x012b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0180 A[Catch: all -> 0x00f8, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x00f8, blocks: (B:100:0x00d5, B:32:0x0119, B:35:0x011c, B:38:0x0122, B:73:0x012b, B:40:0x0140, B:42:0x0144, B:44:0x014c, B:46:0x0154, B:48:0x0160, B:75:0x0134, B:76:0x013f, B:80:0x0180, B:91:0x016e), top: B:99:0x00d5, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01d0 A[EDGE_INSN: B:84:0x01d0->B:50:0x01d0 BREAK  A[LOOP:0: B:31:0x0119->B:85:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[LOOP:0: B:31:0x0119->B:85:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Object decodeFileWidthByteArray(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler, int i3) throws Exception {
        boolean z16;
        int length;
        byte[] bArr;
        boolean z17;
        BitmapFactory.Options options;
        int calculateSampleSize;
        int i16;
        int i17;
        Bitmap decodeByteArray;
        Object obj;
        FileInputStream fileInputStream = new FileInputStream(file);
        boolean z18 = false;
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            byte[] bArr2 = new byte[2];
            fileInputStream.read(bArr2);
            int i18 = ((bArr2[0] << 8) & 65280) | (bArr2[1] & 255);
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            Object obj2 = null;
            try {
                try {
                    if (i18 != 8273 && i18 != 16973) {
                        if (i18 != 18249) {
                            if (i18 != 18761 && i18 != 19789 && i18 != 65496) {
                                z16 = false;
                                length = (int) file.length();
                                bArr = new byte[length];
                                System.arraycopy(bArr2, 0, bArr, 0, 2);
                                fileInputStream.read(bArr, 2, fileInputStream.available());
                                fileInputStream.close();
                                if (URLDrawable.depImp.mLog.isColorLevel()) {
                                    try {
                                        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                                        URLDrawable.depImp.mLog.d(getLogTag(), 2, "read file to memory cost: " + uptimeMillis2);
                                    } catch (Throwable th5) {
                                        th = th5;
                                        z18 = true;
                                        if (!z18) {
                                        }
                                        throw th;
                                    }
                                }
                                long uptimeMillis3 = SystemClock.uptimeMillis();
                                options = new BitmapFactory.Options();
                                options.inJustDecodeBounds = true;
                                options.inPreferredConfig = config;
                                options.inDensity = 160;
                                options.inTargetDensity = 160;
                                options.inScreenDensity = 160;
                                options.inPurgeable = true;
                                options.inInputShareable = true;
                                SafeBitmapFactory.decodeByteArray(bArr, 0, length, options);
                                int i19 = options.outWidth;
                                int i26 = options.outHeight;
                                if (!z16) {
                                    downloadParams.outOrientation = JpegExifReader.readOrientation(file.getAbsolutePath());
                                } else {
                                    downloadParams.outOrientation = Utils.getHeifOrientation(file.getAbsolutePath());
                                }
                                if (URLDrawable.depImp.mLog.isColorLevel()) {
                                    try {
                                        long uptimeMillis4 = SystemClock.uptimeMillis() - uptimeMillis3;
                                        URLDrawable.depImp.mLog.d(getLogTag(), 2, "read size & exif cost: " + uptimeMillis4);
                                    } catch (Throwable th6) {
                                        th = th6;
                                        z18 = true;
                                        if (!z18) {
                                        }
                                        throw th;
                                    }
                                }
                                options.inJustDecodeBounds = false;
                                calculateSampleSize = calculateSampleSize(i19, i26, downloadParams.reqWidth, downloadParams.reqHeight, downloadParams.outOrientation, i3);
                                while (true) {
                                    try {
                                        try {
                                            options.inSampleSize = calculateSampleSize;
                                        } catch (OutOfMemoryError e16) {
                                            e = e16;
                                        }
                                        try {
                                            decodeByteArray = SafeBitmapFactory.decodeByteArray(bArr, 0, length, options);
                                        } catch (OutOfMemoryError e17) {
                                            e = e17;
                                            if (URLDrawable.depImp.mLog.isColorLevel()) {
                                            }
                                            calculateSampleSize *= 2;
                                            System.gc();
                                            Thread.yield();
                                            System.gc();
                                            if (calculateSampleSize > 8) {
                                            }
                                        }
                                        try {
                                            decodeByteArray.setDensity(160);
                                            if (!SliceBitmap.needSliceBitmap(decodeByteArray)) {
                                                try {
                                                    Object sliceBitmap = new SliceBitmap(decodeByteArray);
                                                    decodeByteArray.recycle();
                                                    obj = sliceBitmap;
                                                } catch (Exception unused) {
                                                    decodeByteArray.recycle();
                                                    throw new OutOfMemoryError("slice failed.");
                                                }
                                            } else {
                                                Object obj3 = downloadParams.mExtraInfo;
                                                if (obj3 != null && DownloadParamsExtraInfo.class.isInstance(obj3)) {
                                                    int i27 = ((DownloadParamsExtraInfo) downloadParams.mExtraInfo).mCornerRadius;
                                                    if (i27 > 0) {
                                                        RoundRectBitmap resizeAndClipBitmap = resizeAndClipBitmap(decodeByteArray, i27);
                                                        boolean equals = resizeAndClipBitmap.mBitmap.equals(decodeByteArray);
                                                        obj = resizeAndClipBitmap;
                                                        if (!equals) {
                                                            decodeByteArray.recycle();
                                                            obj = resizeAndClipBitmap;
                                                        }
                                                    }
                                                } else {
                                                    obj2 = decodeByteArray;
                                                }
                                            }
                                            obj2 = obj;
                                        } catch (OutOfMemoryError e18) {
                                            e = e18;
                                            if (URLDrawable.depImp.mLog.isColorLevel()) {
                                                URLDrawable.depImp.mLog.d(getLogTag(), 2, "DecodeFile ERROR,oom retryCount=1,options.inSampleSize=" + options.inSampleSize + JefsClass.INDEX_URL + downloadParams.urlStr + ",oom.msg:" + e.getMessage());
                                            }
                                            calculateSampleSize *= 2;
                                            System.gc();
                                            Thread.yield();
                                            System.gc();
                                            if (calculateSampleSize > 8) {
                                                z17 = true;
                                                if (options.inSampleSize > 1) {
                                                }
                                                if (URLDrawable.depImp.mLog.isColorLevel()) {
                                                }
                                                return obj2;
                                            }
                                        }
                                    } catch (NullPointerException e19) {
                                        e19.printStackTrace();
                                        return null;
                                    }
                                }
                                z17 = true;
                                if (options.inSampleSize > 1) {
                                    try {
                                        if (downloadParams.mAutoScaleByDensity) {
                                            i17 = i19;
                                            downloadParams.outWidth = (int) Math.ceil(i17 * this.density);
                                            i16 = i26;
                                            downloadParams.outHeight = (int) Math.ceil(i16 * this.density);
                                        } else {
                                            i16 = i26;
                                            i17 = i19;
                                            downloadParams.outWidth = (int) Math.ceil(i17);
                                            downloadParams.outHeight = (int) Math.ceil(i16);
                                        }
                                    } catch (Throwable th7) {
                                        th = th7;
                                        z18 = z17;
                                        if (!z18) {
                                            fileInputStream.close();
                                        }
                                        throw th;
                                    }
                                } else {
                                    i16 = i26;
                                    i17 = i19;
                                }
                                if (URLDrawable.depImp.mLog.isColorLevel()) {
                                    URLDrawable.depImp.mLog.d(getLogTag(), 2, "image file size:" + file.length() + " , bound:" + i17 + HippyTKDListViewAdapter.X + i16 + " , sampleSize: " + options.inSampleSize);
                                }
                                return obj2;
                            }
                            z16 = true;
                        } else {
                            fileInputStream.close();
                            return null;
                        }
                    } else {
                        z16 = false;
                    }
                    options.inJustDecodeBounds = false;
                    calculateSampleSize = calculateSampleSize(i19, i26, downloadParams.reqWidth, downloadParams.reqHeight, downloadParams.outOrientation, i3);
                    while (true) {
                        options.inSampleSize = calculateSampleSize;
                        decodeByteArray = SafeBitmapFactory.decodeByteArray(bArr, 0, length, options);
                        decodeByteArray.setDensity(160);
                        if (!SliceBitmap.needSliceBitmap(decodeByteArray)) {
                        }
                        obj2 = obj;
                    }
                    z17 = true;
                    if (options.inSampleSize > 1) {
                    }
                    if (URLDrawable.depImp.mLog.isColorLevel()) {
                    }
                    return obj2;
                } catch (Throwable th8) {
                    th = th8;
                    z17 = true;
                }
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                }
                long uptimeMillis32 = SystemClock.uptimeMillis();
                options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                options.inPreferredConfig = config;
                options.inDensity = 160;
                options.inTargetDensity = 160;
                options.inScreenDensity = 160;
                options.inPurgeable = true;
                options.inInputShareable = true;
                SafeBitmapFactory.decodeByteArray(bArr, 0, length, options);
                int i192 = options.outWidth;
                int i262 = options.outHeight;
                if (!z16) {
                }
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                }
            } catch (Throwable th9) {
                th = th9;
                z17 = true;
            }
            config = Bitmap.Config.RGB_565;
            length = (int) file.length();
            bArr = new byte[length];
            System.arraycopy(bArr2, 0, bArr, 0, 2);
            fileInputStream.read(bArr, 2, fileInputStream.available());
            fileInputStream.close();
        } catch (Throwable th10) {
            th = th10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ac A[Catch: all -> 0x008e, RuntimeException -> 0x0092, TRY_ENTER, TRY_LEAVE, TryCatch #13 {RuntimeException -> 0x0092, all -> 0x008e, blocks: (B:113:0x006a, B:24:0x00ac), top: B:112:0x006a }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0255 A[Catch: all -> 0x0248, TryCatch #4 {all -> 0x0248, blocks: (B:3:0x000d, B:17:0x004c, B:28:0x024b, B:30:0x0255, B:31:0x0264, B:119:0x004a), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0109 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x010a A[Catch: all -> 0x00e3, RuntimeException -> 0x00e7, NullPointerException -> 0x0156, OutOfMemoryError -> 0x015c, TRY_LEAVE, TryCatch #2 {all -> 0x00e3, blocks: (B:44:0x00c0, B:53:0x0101, B:56:0x010a, B:89:0x0115, B:58:0x012b, B:60:0x012f, B:62:0x0137, B:64:0x013f, B:66:0x014b, B:92:0x011f, B:93:0x012a, B:105:0x0157, B:98:0x0168), top: B:43:0x00c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01f6 A[Catch: all -> 0x0236, RuntimeException -> 0x0238, TRY_LEAVE, TryCatch #14 {RuntimeException -> 0x0238, all -> 0x0236, blocks: (B:83:0x01bf, B:85:0x01c3, B:86:0x01dc, B:73:0x01ec, B:75:0x01f6), top: B:82:0x01bf }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v19, types: [com.tencent.image.SliceBitmap] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Object decodeFileWidthByteArrayWithTrubo(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler, int i3) throws Exception {
        boolean z16;
        byte[] bArr;
        boolean z17;
        JpegOptions jpegOptions;
        int calculateSampleSize;
        ?? r26;
        Bitmap bitmap;
        RoundRectBitmap roundRectBitmap;
        FileInputStream fileInputStream = new FileInputStream(file);
        boolean z18 = false;
        try {
            try {
                long uptimeMillis = SystemClock.uptimeMillis();
                byte[] bArr2 = new byte[2];
                fileInputStream.read(bArr2);
                int i16 = ((bArr2[0] << 8) & 65280) | (bArr2[1] & 255);
                Bitmap.Config config = Bitmap.Config.ARGB_8888;
                try {
                    try {
                        if (i16 != 8273 && i16 != 16973) {
                            if (i16 != 18249) {
                                if (i16 != 18761 && i16 != 19789 && i16 != 65496) {
                                    z16 = false;
                                    bArr = new byte[(int) file.length()];
                                    System.arraycopy(bArr2, 0, bArr, 0, 2);
                                    fileInputStream.read(bArr, 2, fileInputStream.available());
                                    fileInputStream.close();
                                    if (URLDrawable.depImp.mLog.isColorLevel()) {
                                        try {
                                            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                                            URLDrawable.depImp.mLog.d(getLogTag(), 2, "read file to memory cost: " + uptimeMillis2);
                                        } catch (RuntimeException e16) {
                                            e = e16;
                                            z18 = true;
                                            if (URLDrawable.depImp.mLog.isColorLevel()) {
                                            }
                                            Object decodeFileWidthByteArray = decodeFileWidthByteArray(file, downloadParams, uRLDrawableHandler, i3);
                                            if (!z18) {
                                            }
                                            return decodeFileWidthByteArray;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            z18 = true;
                                            if (!z18) {
                                            }
                                            throw th;
                                        }
                                    }
                                    long uptimeMillis3 = SystemClock.uptimeMillis();
                                    jpegOptions = new JpegOptions();
                                    jpegOptions.inJustDecodeBounds = true;
                                    jpegOptions.inPreferredConfig = config;
                                    JpegDecompressor.decodeByteArray(bArr, jpegOptions);
                                    int i17 = jpegOptions.outWidth;
                                    int i18 = jpegOptions.outHeight;
                                    if (z16) {
                                        downloadParams.outOrientation = JpegExifReader.readOrientation(file.getAbsolutePath());
                                    }
                                    if (URLDrawable.depImp.mLog.isColorLevel()) {
                                        try {
                                            try {
                                                long uptimeMillis4 = SystemClock.uptimeMillis() - uptimeMillis3;
                                                URLDrawable.depImp.mLog.d(getLogTag(), 2, "read size & exif cost: " + uptimeMillis4);
                                            } catch (RuntimeException e17) {
                                                e = e17;
                                                z18 = true;
                                                if (URLDrawable.depImp.mLog.isColorLevel()) {
                                                    URLDrawable.depImp.mLog.i(getLogTag(), 2, "GalleryDecoder.decodeFileWidthByteArrayWithTrubo() error", e);
                                                }
                                                Object decodeFileWidthByteArray2 = decodeFileWidthByteArray(file, downloadParams, uRLDrawableHandler, i3);
                                                if (!z18) {
                                                    fileInputStream.close();
                                                }
                                                return decodeFileWidthByteArray2;
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                            z18 = true;
                                            if (!z18) {
                                                fileInputStream.close();
                                            }
                                            throw th;
                                        }
                                    }
                                    jpegOptions.inJustDecodeBounds = false;
                                    calculateSampleSize = calculateSampleSize(i17, i18, downloadParams.reqWidth, downloadParams.reqHeight, downloadParams.outOrientation, i3);
                                    while (true) {
                                        try {
                                            try {
                                                jpegOptions.inSampleSize = calculateSampleSize;
                                                bitmap = JpegDecompressor.decodeByteArray(bArr, jpegOptions);
                                                if (bitmap != null) {
                                                    return bitmap;
                                                }
                                                bitmap.setDensity(160);
                                                if (SliceBitmap.needSliceBitmap(bitmap)) {
                                                    try {
                                                        r26 = new SliceBitmap(bitmap);
                                                        bitmap.recycle();
                                                    } catch (Exception unused) {
                                                        bitmap.recycle();
                                                        throw new OutOfMemoryError("slice failed.");
                                                    }
                                                } else {
                                                    Object obj = downloadParams.mExtraInfo;
                                                    if (obj != null && DownloadParamsExtraInfo.class.isInstance(obj)) {
                                                        int i19 = ((DownloadParamsExtraInfo) downloadParams.mExtraInfo).mCornerRadius;
                                                        if (i19 > 0) {
                                                            RoundRectBitmap resizeAndClipBitmap = resizeAndClipBitmap(bitmap, i19);
                                                            if (!resizeAndClipBitmap.mBitmap.equals(bitmap)) {
                                                                bitmap.recycle();
                                                            }
                                                            roundRectBitmap = resizeAndClipBitmap;
                                                        } else {
                                                            roundRectBitmap = null;
                                                        }
                                                        bitmap = roundRectBitmap;
                                                    }
                                                }
                                            } catch (NullPointerException e18) {
                                                e18.printStackTrace();
                                                return null;
                                            }
                                        } catch (OutOfMemoryError e19) {
                                            r26 = 0;
                                            if (URLDrawable.depImp.mLog.isColorLevel()) {
                                                URLDrawable.depImp.mLog.d(getLogTag(), 2, "DecodeFile ERROR,oom retryCount=1,options.inSampleSize=" + jpegOptions.inSampleSize + JefsClass.INDEX_URL + downloadParams.urlStr + ",oom.msg:" + e19.getMessage());
                                            }
                                            calculateSampleSize *= 2;
                                            System.gc();
                                            Thread.yield();
                                            System.gc();
                                            if (calculateSampleSize >= 8) {
                                                break;
                                            }
                                        }
                                    }
                                    bitmap = r26;
                                    z17 = true;
                                    if (jpegOptions.inSampleSize > 1) {
                                        try {
                                            if (downloadParams.mAutoScaleByDensity) {
                                                downloadParams.outWidth = (int) Math.ceil(i17 * this.density);
                                                downloadParams.outHeight = (int) Math.ceil(i18 * this.density);
                                            } else {
                                                downloadParams.outWidth = (int) Math.ceil(i17);
                                                downloadParams.outHeight = (int) Math.ceil(i18);
                                            }
                                        } catch (RuntimeException e26) {
                                            e = e26;
                                            z18 = z17;
                                            if (URLDrawable.depImp.mLog.isColorLevel()) {
                                            }
                                            Object decodeFileWidthByteArray22 = decodeFileWidthByteArray(file, downloadParams, uRLDrawableHandler, i3);
                                            if (!z18) {
                                            }
                                            return decodeFileWidthByteArray22;
                                        } catch (Throwable th7) {
                                            th = th7;
                                            z18 = z17;
                                            if (!z18) {
                                            }
                                            throw th;
                                        }
                                    }
                                    if (URLDrawable.depImp.mLog.isColorLevel()) {
                                        URLDrawable.depImp.mLog.d(getLogTag(), 2, "image file size:" + file.length() + " , bound:" + i17 + HippyTKDListViewAdapter.X + i18 + " , sampleSize: " + jpegOptions.inSampleSize);
                                    }
                                    return bitmap;
                                }
                                z16 = true;
                            } else {
                                fileInputStream.close();
                                return null;
                            }
                        } else {
                            z16 = false;
                        }
                        jpegOptions.inJustDecodeBounds = false;
                        calculateSampleSize = calculateSampleSize(i17, i18, downloadParams.reqWidth, downloadParams.reqHeight, downloadParams.outOrientation, i3);
                        while (true) {
                            jpegOptions.inSampleSize = calculateSampleSize;
                            bitmap = JpegDecompressor.decodeByteArray(bArr, jpegOptions);
                            if (bitmap != null) {
                            }
                        }
                        bitmap = r26;
                        z17 = true;
                        if (jpegOptions.inSampleSize > 1) {
                        }
                        if (URLDrawable.depImp.mLog.isColorLevel()) {
                        }
                        return bitmap;
                    } catch (RuntimeException e27) {
                        e = e27;
                        z17 = true;
                    } catch (Throwable th8) {
                        th = th8;
                        z17 = true;
                    }
                    if (URLDrawable.depImp.mLog.isColorLevel()) {
                    }
                    long uptimeMillis32 = SystemClock.uptimeMillis();
                    jpegOptions = new JpegOptions();
                    jpegOptions.inJustDecodeBounds = true;
                    jpegOptions.inPreferredConfig = config;
                    JpegDecompressor.decodeByteArray(bArr, jpegOptions);
                    int i172 = jpegOptions.outWidth;
                    int i182 = jpegOptions.outHeight;
                    if (z16) {
                    }
                    if (URLDrawable.depImp.mLog.isColorLevel()) {
                    }
                } catch (RuntimeException e28) {
                    e = e28;
                    z17 = true;
                } catch (Throwable th9) {
                    th = th9;
                    z17 = true;
                }
                config = Bitmap.Config.RGB_565;
                bArr = new byte[(int) file.length()];
                System.arraycopy(bArr2, 0, bArr, 0, 2);
                fileInputStream.read(bArr, 2, fileInputStream.available());
                fileInputStream.close();
            } catch (RuntimeException e29) {
                e = e29;
            }
        } catch (Throwable th10) {
            th = th10;
        }
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, this, file, downloadParams, uRLDrawableHandler);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            if (VideoDrawable.isVideo(file)) {
                return decodeVideo(file, downloadParams, uRLDrawableHandler);
            }
            long length = file.length();
            Object obj = downloadParams.tag;
            if (obj != null) {
                i3 = ((Integer) obj).intValue();
            } else {
                i3 = 0;
            }
            if (useJpegTurbo() && PicFormatUtils.isJPEGImage(file.getAbsolutePath())) {
                if (length < 5242880) {
                    Object decodeFileWidthByteArrayWithTrubo = decodeFileWidthByteArrayWithTrubo(file, downloadParams, uRLDrawableHandler, i3);
                    if (URLDrawable.depImp.mLog.isColorLevel()) {
                        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                        URLDrawable.depImp.mLog.d(getLogTag(), 2, "decode file:" + file.getAbsolutePath() + " cost: " + uptimeMillis2);
                    }
                    return decodeFileWidthByteArrayWithTrubo;
                }
                Object decodeFileNormalWithTrubo = decodeFileNormalWithTrubo(file, downloadParams, uRLDrawableHandler, i3);
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    long uptimeMillis3 = SystemClock.uptimeMillis() - uptimeMillis;
                    URLDrawable.depImp.mLog.d(getLogTag(), 2, "decode file:" + file.getAbsolutePath() + " cost: " + uptimeMillis3);
                }
                return decodeFileNormalWithTrubo;
            }
            if (length < 5242880) {
                Object decodeFileWidthByteArray = decodeFileWidthByteArray(file, downloadParams, uRLDrawableHandler, i3);
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    long uptimeMillis4 = SystemClock.uptimeMillis() - uptimeMillis;
                    URLDrawable.depImp.mLog.d(getLogTag(), 2, "decode file:" + file.getAbsolutePath() + " cost: " + uptimeMillis4);
                }
                return decodeFileWidthByteArray;
            }
            Object decodeFileNormal = decodeFileNormal(file, downloadParams, uRLDrawableHandler, i3);
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                long uptimeMillis5 = SystemClock.uptimeMillis() - uptimeMillis;
                URLDrawable.depImp.mLog.d(getLogTag(), 2, "decode file:" + file.getAbsolutePath() + " cost: " + uptimeMillis5);
            }
            return decodeFileNormal;
        } finally {
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                long uptimeMillis6 = SystemClock.uptimeMillis() - uptimeMillis;
                URLDrawable.depImp.mLog.d(getLogTag(), 2, "decode file:" + file.getAbsolutePath() + " cost: " + uptimeMillis6);
            }
        }
    }

    protected Object decodeVideo(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, file, downloadParams, uRLDrawableHandler);
        }
        return null;
    }

    protected String getLogTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return TAG;
    }

    protected void reportSafeDecode(SafeBitmapFactory.SafeDecodeOption safeDecodeOption) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) safeDecodeOption);
        }
    }

    protected RoundRectBitmap resizeAndClipBitmap(Bitmap bitmap, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RoundRectBitmap) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bitmap, i3);
        }
        return new RoundRectBitmap(bitmap, i3);
    }

    protected boolean useJpegTurbo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return true;
    }
}
