package com.tencent.mobileqq.pic.compress;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.JpegCompressor;
import com.tencent.mobileqq.pic.JpegDataDest;
import com.tencent.mobileqq.pic.JpegDecompressor;
import com.tencent.mobileqq.pic.JpegOptions;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AIOImgThumbHelper;
import com.tencent.mobileqq.transfile.CommonImgThumbHelper;
import com.tencent.mobileqq.transfile.richmediavfs.RmVFSUtils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.utils.bm;
import com.tencent.mobileqq.widget.n;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.SyncFailedException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements JpegDataDest {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f258691a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CompressInfo f258692b;

        a(File file, CompressInfo compressInfo) {
            this.f258691a = file;
            this.f258692b = compressInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) file, (Object) compressInfo);
            }
        }

        @Override // com.tencent.mobileqq.pic.JpegDataDest
        public void dataArrived(ByteBuffer byteBuffer, boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, byteBuffer, Boolean.valueOf(z16), obj);
                return;
            }
            FileChannel fileChannel = null;
            try {
                try {
                    fileChannel = new FileOutputStream(this.f258691a, true).getChannel();
                    fileChannel.write(byteBuffer);
                    if (z16) {
                        try {
                            fileChannel.force(true);
                            if (QLog.isColorLevel()) {
                                QLog.i("peak_pgjpeg", 2, "file len " + this.f258691a.length());
                            }
                        } catch (IOException e16) {
                            e16.printStackTrace();
                            if (QLog.isColorLevel()) {
                                QLog.i("peak_pgjpeg", 2, e16.toString());
                            }
                        }
                    }
                    try {
                        fileChannel.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                } catch (IOException unused) {
                    CompressInfo compressInfo = this.f258692b;
                    if (compressInfo != null) {
                        compressInfo.c(true);
                    }
                    if (fileChannel != null) {
                        if (z16) {
                            try {
                                fileChannel.force(true);
                                if (QLog.isColorLevel()) {
                                    QLog.i("peak_pgjpeg", 2, "file len " + this.f258691a.length());
                                }
                            } catch (IOException e18) {
                                e18.printStackTrace();
                                if (QLog.isColorLevel()) {
                                    QLog.i("peak_pgjpeg", 2, e18.toString());
                                }
                            }
                        }
                        try {
                            fileChannel.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th5) {
                if (fileChannel != null) {
                    if (z16) {
                        try {
                            fileChannel.force(true);
                            if (QLog.isColorLevel()) {
                                QLog.i("peak_pgjpeg", 2, "file len " + this.f258691a.length());
                            }
                        } catch (IOException e26) {
                            e26.printStackTrace();
                            if (QLog.isColorLevel()) {
                                QLog.i("peak_pgjpeg", 2, e26.toString());
                            }
                        }
                    }
                    try {
                        fileChannel.close();
                    } catch (IOException e27) {
                        e27.printStackTrace();
                    }
                }
                throw th5;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface b {
        void compress(OutputStream outputStream);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f258693a;

        /* renamed from: b, reason: collision with root package name */
        public int f258694b;

        /* renamed from: c, reason: collision with root package name */
        public int f258695c;

        /* renamed from: d, reason: collision with root package name */
        public int f258696d;

        public c(int i3, int i16, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                return;
            }
            this.f258693a = i3;
            this.f258694b = i16;
            this.f258695c = i17;
            this.f258696d = i18;
        }
    }

    public static boolean a(BitmapFactory.Options options, String str, int i3, int i16) {
        if (options != null && !TextUtils.isEmpty(str)) {
            if (i3 >= 0 && i16 >= 0 && i3 >= i16) {
                if (i16 <= i3 / 2) {
                    options.inJustDecodeBounds = true;
                    BaseImageUtil.decodeFileWithBufferedStream(str, options);
                    int i17 = options.outHeight;
                    int i18 = options.outWidth;
                    if (i18 > i17) {
                        i17 = i18;
                    }
                    if (i17 > i3) {
                        int i19 = 1;
                        while (true) {
                            i17 >>= 1;
                            i19 *= 2;
                            if (i17 >= i16 && i17 <= i3) {
                                break;
                            }
                        }
                        options.inSampleSize = i19;
                    }
                    options.inJustDecodeBounds = false;
                    int i26 = options.inSampleSize;
                    if (i26 < 1) {
                        i26 = 1;
                    }
                    options.inSampleSize = i26;
                    com.tencent.mobileqq.pic.f.b("compress.Utils", "calculateInSampleSize()", "options.inSampleSize=" + options.inSampleSize);
                    return true;
                }
                throw new IllegalArgumentException("min > max / 2");
            }
            throw new IllegalArgumentException("max < 0 || min < 0 || max < min");
        }
        com.tencent.mobileqq.pic.f.d("compress.Utils", "calculateInSampleSize()", "options == null || TextUtils.isEmpty(filepath)");
        return false;
    }

    public static boolean b(BitmapFactory.Options options, int i3) {
        if (options == null) {
            com.tencent.mobileqq.pic.f.d("compress.Utils", "calculateInSampleSizeThumbnail()", "options is null");
            return false;
        }
        int i16 = options.outWidth;
        int i17 = options.outHeight;
        if (i16 != 0 && i17 != 0) {
            int i18 = i16;
            int i19 = i17;
            int i26 = 1;
            while (true) {
                i18 >>= 1;
                i19 >>= 1;
                if (i18 < i3 || i19 < i3) {
                    break;
                }
                i26 *= 2;
            }
            options.inSampleSize = i26;
            options.inJustDecodeBounds = false;
            if (i26 < 1) {
                i26 = 1;
            }
            options.inSampleSize = i26;
            com.tencent.mobileqq.pic.f.b("compress.Utils", "calculateInSampleSizeThumbnail()", "options.inSampleSize=" + options.inSampleSize + " srcWidth:" + i16 + " srcHeight:" + i17);
            return true;
        }
        com.tencent.mobileqq.pic.f.d("compress.Utils", "calculateInSampleSizeThumbnail()", "width == 0 || height ==0");
        return false;
    }

    static boolean c(JpegOptions jpegOptions, int i3) {
        if (jpegOptions == null) {
            com.tencent.mobileqq.pic.f.d("compress.Utils", "calculateInSampleSizeThumbnail()", "options is null");
            return false;
        }
        int i16 = jpegOptions.outWidth;
        int i17 = jpegOptions.outHeight;
        if (i16 != 0 && i17 != 0) {
            int i18 = i16;
            int i19 = i17;
            int i26 = 1;
            while (true) {
                i18 >>= 1;
                i19 >>= 1;
                if (i18 < i3 || i19 < i3) {
                    break;
                }
                i26 *= 2;
            }
            jpegOptions.inSampleSize = i26;
            jpegOptions.inJustDecodeBounds = false;
            if (i26 < 1) {
                i26 = 1;
            }
            jpegOptions.inSampleSize = i26;
            com.tencent.mobileqq.pic.f.b("compress.Utils", "calculateInSampleSizeThumbnail()", "options.inSampleSize=" + jpegOptions.inSampleSize + " srcWidth:" + i16 + " srcHeight:" + i17);
            return true;
        }
        com.tencent.mobileqq.pic.f.d("compress.Utils", "calculateInSampleSizeThumbnail()", "width == 0 || height ==0");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap d(Bitmap bitmap, ThumbWidthHeightDP thumbWidthHeightDP) {
        int i3;
        int i16;
        int i17;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f16 = width;
        float f17 = height;
        float f18 = f17 * 3.0f;
        try {
            if (f16 > f18) {
                i3 = (int) f18;
            } else {
                float f19 = f16 * 3.0f;
                if (f17 > f19) {
                    i16 = (int) f19;
                    i3 = width;
                    int i18 = thumbWidthHeightDP.mMinWidth;
                    int i19 = thumbWidthHeightDP.mMinHeight;
                    int i26 = thumbWidthHeightDP.mMaxWidth;
                    int i27 = thumbWidthHeightDP.mMaxHeight;
                    if (i3 >= i16) {
                        if (i3 < i18) {
                            i19 = (int) (((i16 * i18) * 1.0f) / i3);
                        } else {
                            i18 = i3;
                            i19 = i16;
                        }
                        if (i16 > i27) {
                            i26 = (int) (((i3 * i27) * 1.0f) / i16);
                        } else {
                            i26 = i18;
                            i27 = i19;
                        }
                    } else {
                        if (i16 < i19) {
                            i17 = (int) (((i3 * i19) * 1.0f) / i16);
                        } else {
                            i17 = i3;
                            i19 = i16;
                        }
                        if (i3 > i26) {
                            i27 = (int) (((i16 * i26) * 1.0f) / i3);
                        } else {
                            i26 = i17;
                            i27 = i19;
                        }
                    }
                    float f26 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
                    int i28 = (int) ((i26 * f26) + 0.5f);
                    int i29 = (int) ((i27 * f26) + 0.5f);
                    Bitmap createBitmap = Bitmap.createBitmap(i28, i29, bitmap.getConfig());
                    createBitmap.setDensity(BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi);
                    Paint paint = new Paint(1);
                    paint.setColor(-16777216);
                    QLog.d("compress.Utils", 1, "clip w=" + width + ", h=" + height + ", wClip=" + i3 + ", hClip=" + i16 + ", dstW=" + i28 + ", dstH=" + i29);
                    new Canvas(createBitmap).drawBitmap(bitmap, new Rect(0, 0, i3, i16), new Rect(0, 0, i28, i29), paint);
                    return createBitmap;
                }
                i3 = width;
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(i28, i29, bitmap.getConfig());
            createBitmap2.setDensity(BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi);
            Paint paint2 = new Paint(1);
            paint2.setColor(-16777216);
            QLog.d("compress.Utils", 1, "clip w=" + width + ", h=" + height + ", wClip=" + i3 + ", hClip=" + i16 + ", dstW=" + i28 + ", dstH=" + i29);
            new Canvas(createBitmap2).drawBitmap(bitmap, new Rect(0, 0, i3, i16), new Rect(0, 0, i28, i29), paint2);
            return createBitmap2;
        } catch (Exception e16) {
            QLog.e("compress.Utils", 1, "Exception", e16);
            return bitmap;
        } catch (OutOfMemoryError e17) {
            QLog.e("compress.Utils", 1, "OutOfMemoryError", e17);
            return bitmap;
        }
        i16 = height;
        int i182 = thumbWidthHeightDP.mMinWidth;
        int i192 = thumbWidthHeightDP.mMinHeight;
        int i262 = thumbWidthHeightDP.mMaxWidth;
        int i272 = thumbWidthHeightDP.mMaxHeight;
        if (i3 >= i16) {
        }
        float f262 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
        int i282 = (int) ((i262 * f262) + 0.5f);
        int i292 = (int) ((i272 * f262) + 0.5f);
    }

    static Bitmap e(Bitmap bitmap, boolean z16, String str, String str2, String str3, ThumbWidthHeightDP thumbWidthHeightDP, c cVar) {
        int i3;
        Bitmap a16;
        if (thumbWidthHeightDP != null && thumbWidthHeightDP.mLimitSizeByServer) {
            a16 = d(bitmap, thumbWidthHeightDP);
        } else {
            int i16 = cVar.f258695c;
            int i17 = cVar.f258693a;
            if (z16) {
                i3 = BaseImageUtil.getExifOrientation(str);
            } else {
                i3 = 0;
            }
            com.tencent.mobileqq.pic.compress.b bVar = new com.tencent.mobileqq.pic.compress.b(i16, i17, i3);
            a16 = bVar.a(bitmap);
            com.tencent.mobileqq.pic.f.b("compress.Utils", str2, " needCut:" + bVar.f258682f + " needScale:" + bVar.f258683g);
        }
        if (a16 == null) {
            com.tencent.mobileqq.pic.f.b("compress.Utils", str2, str3 + " ClipStrategy fail");
            return null;
        }
        com.tencent.mobileqq.pic.f.b("compress.Utils", str2, str3 + " ClipStrategy suc, destWidth\uff1a" + a16.getWidth() + " destHeight:" + a16.getHeight());
        return a16;
    }

    static Bitmap f(Bitmap bitmap) {
        if (bitmap == null) {
            return bitmap;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawColor(-1);
            Paint paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            paint.setXfermode(null);
            bitmap.recycle();
            return createBitmap;
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
            return bitmap;
        }
    }

    public static boolean g(String str, String str2, boolean z16, String str3, int i3, ThumbWidthHeightDP thumbWidthHeightDP) {
        Bitmap decodeFileWithBufferedStream;
        Bitmap safeDecode;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && FileUtils.fileExistsAndNotEmpty(str)) {
            com.tencent.mobileqq.pic.f.b("compress.Utils", "compressAIOThumbnail", str3);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BaseImageUtil.decodeFileWithBufferedStream(str, options);
            c u16 = u(thumbWidthHeightDP, i3, Math.max(options.outHeight, options.outWidth));
            if (!b(options, u16.f258695c)) {
                com.tencent.mobileqq.pic.f.d("compress.Utils", "compressAIOThumbnail", str3 + " calculateInSampleSize fail");
                return false;
            }
            try {
                safeDecode = SafeBitmapFactory.safeDecode(str, options);
            } catch (OutOfMemoryError e16) {
                e16.printStackTrace();
                com.tencent.mobileqq.pic.f.d("compress.Utils", "compressAIOThumbnail", str3 + " decodeFile OutOfMemoryError");
                options.inSampleSize = options.inSampleSize * 2;
                try {
                    decodeFileWithBufferedStream = BaseImageUtil.decodeFileWithBufferedStream(str, options);
                } catch (OutOfMemoryError e17) {
                    e17.printStackTrace();
                    com.tencent.mobileqq.pic.f.d("compress.Utils", "compressAIOThumbnail", str3 + " decodeFile OutOfMemoryError, op.inSampleSize:" + options.inSampleSize);
                    return false;
                }
            }
            if (safeDecode == null) {
                com.tencent.mobileqq.pic.f.d("compress.Utils", "compressAIOThumbnail", str3 + " bm == null, maybe is broken");
                return false;
            }
            decodeFileWithBufferedStream = safeDecode;
            com.tencent.mobileqq.pic.f.b("compress.Utils", "compressAIOThumbnail", str3 + " sample after W:" + decodeFileWithBufferedStream.getWidth() + " H:" + decodeFileWithBufferedStream.getHeight());
            Bitmap e18 = e(decodeFileWithBufferedStream, z16, str, "compressAIOThumbnail", str3, thumbWidthHeightDP, u16);
            if (e18 == null) {
                return false;
            }
            return y(e18, str2, "compressAIOThumbnail", str3, i3);
        }
        com.tencent.mobileqq.pic.f.d("compress.Utils", "compressAIOThumbnail", str3 + " infilePath is empty, or outfilePath is empty, or file does not exist. infilePath:" + str + " outfilePath:" + str2);
        return false;
    }

    public static boolean h(String str, String str2, boolean z16, String str3, int i3) throws Exception {
        Bitmap decodeFile;
        Bitmap decodeFile2;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && FileUtils.fileExistsAndNotEmpty(str)) {
            com.tencent.mobileqq.pic.f.b("compress.Utils", "compressAIOThumbnailWithTrubo", str3);
            JpegOptions jpegOptions = new JpegOptions();
            jpegOptions.inJustDecodeBounds = true;
            JpegDecompressor.decodeFile(str, jpegOptions);
            c u16 = u(null, i3, Math.max(jpegOptions.outHeight, jpegOptions.outWidth));
            if (!c(jpegOptions, u16.f258695c)) {
                com.tencent.mobileqq.pic.f.d("compress.Utils", "compressAIOThumbnailWithTrubo", str3 + " calculateInSampleSize fail");
                return false;
            }
            try {
                decodeFile2 = JpegDecompressor.decodeFile(str, jpegOptions);
            } catch (OutOfMemoryError e16) {
                e16.printStackTrace();
                com.tencent.mobileqq.pic.f.d("compress.Utils", "compressAIOThumbnailWithTrubo", str3 + " decodeFile OutOfMemoryError");
                jpegOptions.inSampleSize = jpegOptions.inSampleSize * 2;
                try {
                    decodeFile = JpegDecompressor.decodeFile(str, jpegOptions);
                } catch (OutOfMemoryError e17) {
                    e17.printStackTrace();
                    com.tencent.mobileqq.pic.f.d("compress.Utils", "compressAIOThumbnailWithTrubo", str3 + " decodeFile OutOfMemoryError, op.inSampleSize:" + jpegOptions.inSampleSize);
                    return false;
                }
            }
            if (decodeFile2 == null) {
                com.tencent.mobileqq.pic.f.d("compress.Utils", "compressAIOThumbnailWithTrubo", str3 + " bm == null, maybe is broken");
                return false;
            }
            decodeFile = decodeFile2;
            com.tencent.mobileqq.pic.f.b("compress.Utils", "compressAIOThumbnailWithTrubo", str3 + " sample after W:" + decodeFile.getWidth() + " H:" + decodeFile.getHeight());
            Bitmap e18 = e(decodeFile, z16, str, "compressAIOThumbnailWithTrubo", str3, null, u16);
            if (e18 == null) {
                return false;
            }
            return y(e18, str2, "compressAIOThumbnailWithTrubo", str3, i3);
        }
        com.tencent.mobileqq.pic.f.d("compress.Utils", "compressAIOThumbnailWithTrubo", str3 + " infilePath is empty, or outfilePath is empty, or file does not exist. infilePath:" + str + " outfilePath:" + str2);
        return false;
    }

    public static boolean i(String str, Bitmap bitmap, int i3, String str2, CompressInfo compressInfo) {
        ColorSpace colorSpace;
        ColorSpace colorSpace2;
        boolean isSrgb;
        boolean z16 = false;
        if (Build.VERSION.SDK_INT >= 26) {
            colorSpace = bitmap.getColorSpace();
            if (colorSpace != null) {
                colorSpace2 = bitmap.getColorSpace();
                isSrgb = colorSpace2.isSrgb();
                if (!isSrgb) {
                    z16 = true;
                }
            }
        }
        if (!z16 && q()) {
            return k(str, bitmap, i3, str2, compressInfo);
        }
        return j(str, bitmap, i3, str2, compressInfo);
    }

    private static boolean j(String str, Bitmap bitmap, int i3, String str2, CompressInfo compressInfo) {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        if (!TextUtils.isEmpty(str) && bitmap != null && i3 <= 100 && i3 > 0) {
            com.tencent.mobileqq.pic.f.b("compress.Utils", "compressQualityWithBaseline()", str2 + " quality:" + i3);
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                try {
                    FileUtils.createFile(str);
                    fileOutputStream = new FileOutputStream(file);
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                } catch (FileNotFoundException e16) {
                    e = e16;
                } catch (Exception e17) {
                    e = e17;
                }
                try {
                    try {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, i3, bufferedOutputStream);
                        try {
                            bufferedOutputStream.flush();
                            FileDescriptor fd5 = fileOutputStream.getFD();
                            if (fd5 != null && fd5.valid()) {
                                fd5.sync();
                            }
                        } catch (SyncFailedException unused) {
                            if (compressInfo != null) {
                                compressInfo.c(true);
                            }
                            com.tencent.mobileqq.pic.f.d("compress.Utils", "compressQualityWithBaseline()", "SyncFailedException");
                        } catch (IOException unused2) {
                            if (compressInfo != null) {
                                compressInfo.c(true);
                            }
                            com.tencent.mobileqq.pic.f.d("compress.Utils", "compressQualityWithBaseline()", "IOException");
                        }
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                        if (FileUtils.fileExistsAndNotEmpty(str)) {
                            return true;
                        }
                        com.tencent.mobileqq.pic.f.d("compress.Utils", "compressQualityWithBaseline()", str2 + "create file error");
                        return false;
                    } catch (Exception e19) {
                        e = e19;
                        bufferedOutputStream2 = bufferedOutputStream;
                        com.tencent.mobileqq.pic.f.d("compress.Utils", "compressQualityWithBaseline()", str2 + " createNewFile Exception");
                        e.printStackTrace();
                        if (bufferedOutputStream2 != null) {
                            try {
                                bufferedOutputStream2.close();
                            } catch (IOException e26) {
                                e26.printStackTrace();
                            }
                        }
                        return false;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedOutputStream2 = bufferedOutputStream;
                        if (bufferedOutputStream2 != null) {
                            try {
                                bufferedOutputStream2.close();
                            } catch (IOException e27) {
                                e27.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e28) {
                    e = e28;
                    bufferedOutputStream2 = bufferedOutputStream;
                    com.tencent.mobileqq.pic.f.d("compress.Utils", "compressQualityWithBaseline()", str2 + " FileOutputStream FileNotFoundException");
                    e.printStackTrace();
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e29) {
                            e29.printStackTrace();
                        }
                    }
                    return false;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } else {
            com.tencent.mobileqq.pic.f.d("compress.Utils", "compressQualityWithBaseline()", str2 + " TextUtils.isEmpty(destPath) || bm == null || quality > 100 || quality <= 0");
            return false;
        }
    }

    private static boolean k(String str, Bitmap bitmap, int i3, String str2, CompressInfo compressInfo) {
        if (!TextUtils.isEmpty(str) && bitmap != null && i3 <= 100 && i3 > 0) {
            com.tencent.mobileqq.pic.f.b("compress.Utils", "compressQualityWithProgressive()", str2 + " quality:" + i3);
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            try {
                file.createNewFile();
                JpegCompressor jpegCompressor = new JpegCompressor(new a(file, compressInfo));
                jpegCompressor.setParams(i3, true, true, false);
                try {
                    bm.a();
                    jpegCompressor.compress(bitmap);
                    bm.b("peak_pgjpeg", "pgjpeg " + bitmap.getWidth() + HippyTKDListViewAdapter.X + bitmap.getHeight() + " compress");
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str2);
                    sb5.append(" quality:");
                    sb5.append(i3);
                    com.tencent.mobileqq.pic.f.b("compress.Utils", "compressQualityWithProgressive()", sb5.toString());
                    return true;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i("peak_pgjpeg", 2, "JpegCompressor.compress() error", e16);
                    }
                    return j(str, bitmap, i3, str2, compressInfo);
                }
            } catch (FileNotFoundException e17) {
                com.tencent.mobileqq.pic.f.d("compress.Utils", "compressQualityWithProgressive()", str2 + " FileOutputStream FileNotFoundException");
                e17.printStackTrace();
                return false;
            } catch (IOException e18) {
                com.tencent.mobileqq.pic.f.d("compress.Utils", "compressQualityWithProgressive()", str2 + " createNewFile IOException");
                e18.printStackTrace();
                return false;
            }
        }
        com.tencent.mobileqq.pic.f.d("compress.Utils", "compressQualityWithProgressive()", str2 + " TextUtils.isEmpty(destPath) || bm == null || quality > 100 || quality <= 0");
        return false;
    }

    public static boolean l(Bitmap bitmap, String str, String str2, boolean z16, String str3, int i3, ThumbWidthHeightDP thumbWidthHeightDP) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outHeight = bitmap.getHeight();
        int width = bitmap.getWidth();
        options.outWidth = width;
        c u16 = u(thumbWidthHeightDP, i3, Math.max(options.outHeight, width));
        if (!b(options, u16.f258695c)) {
            com.tencent.mobileqq.pic.f.d("compress.Utils", "compressAIOThumbnail", str3 + " calculateInSampleSize fail");
            return false;
        }
        com.tencent.mobileqq.pic.f.b("compress.Utils", "compressAIOThumbnail", str3 + " sample after W:" + bitmap.getWidth() + " H:" + bitmap.getHeight());
        Bitmap e16 = e(bitmap, z16, str, "compressAIOThumbnail", str3, thumbWidthHeightDP, u16);
        if (e16 == null) {
            return false;
        }
        return y(e16, str2, "compressAIOThumbnail", str3, i3);
    }

    public static boolean m(String str, String str2, CompressInfo compressInfo, b bVar) {
        BufferedOutputStream bufferedOutputStream;
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                FileUtils.createFile(str);
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            } catch (FileNotFoundException e16) {
                e = e16;
            } catch (Exception e17) {
                e = e17;
            }
            try {
                try {
                    bVar.compress(bufferedOutputStream);
                    try {
                        bufferedOutputStream.flush();
                    } catch (SyncFailedException unused) {
                        if (compressInfo != null) {
                            compressInfo.c(true);
                        }
                        com.tencent.mobileqq.pic.f.d("compress.Utils", "compressWithOutputStream()", "SyncFailedException");
                    } catch (IOException unused2) {
                        if (compressInfo != null) {
                            compressInfo.c(true);
                        }
                        com.tencent.mobileqq.pic.f.d("compress.Utils", "compressWithOutputStream()", "IOException");
                    }
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                    }
                    if (FileUtils.fileExistsAndNotEmpty(str)) {
                        return true;
                    }
                    com.tencent.mobileqq.pic.f.d("compress.Utils", "compressWithOutputStream()", str2 + "create file error");
                    return false;
                } catch (Exception e19) {
                    e = e19;
                    bufferedOutputStream2 = bufferedOutputStream;
                    com.tencent.mobileqq.pic.f.d("compress.Utils", "compressWithOutputStream()", str2 + " createNewFile Exception");
                    e.printStackTrace();
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e26) {
                            e26.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream2 = bufferedOutputStream;
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e27) {
                            e27.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e28) {
                e = e28;
                bufferedOutputStream2 = bufferedOutputStream;
                com.tencent.mobileqq.pic.f.d("compress.Utils", "compressWithOutputStream()", str2 + " FileOutputStream FileNotFoundException");
                e.printStackTrace();
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e29) {
                        e29.printStackTrace();
                    }
                }
                return false;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static boolean n() {
        String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.pg_switch.name(), "1|1|1");
        if (QLog.isDevelopLevel()) {
            QLog.d("peak_pgjpeg", 4, "DeviceProfileManager.DpcNames.pg_switch value " + featureValue);
        }
        String[] split = featureValue.split("\\|");
        if (split.length < 2) {
            return false;
        }
        return split[1].equals("1");
    }

    static boolean o(Bitmap bitmap) {
        try {
            Bitmap s16 = s();
            if (s16 == null) {
                return false;
            }
            int width = s16.getWidth() / 2;
            int height = s16.getHeight() / 2;
            int width2 = (bitmap.getWidth() - width) - 7;
            int height2 = (bitmap.getHeight() - height) - 7;
            if (width2 > 0 && height2 > 0) {
                new Canvas(bitmap).drawBitmap(s16, (Rect) null, new Rect(width2, height2, width + width2, height + height2), new Paint(2));
                return true;
            }
            return true;
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static void p(Bitmap bitmap, String str, float f16) {
        Canvas canvas = new Canvas(bitmap);
        TextPaint textPaint = new TextPaint();
        float a16 = al.a(MobileQQ.sMobileQQ.getApplicationContext(), f16);
        Rect rect = new Rect();
        textPaint.setTextSize(a16);
        textPaint.setAntiAlias(true);
        textPaint.setStrokeWidth(2.0f);
        textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        textPaint.setColor(-1);
        textPaint.getTextBounds(str, 0, str.length(), rect);
        canvas.translate(bitmap.getWidth() * 0.05f, bitmap.getHeight() * 0.05f);
        new StaticLayout(str, 0, str.length(), textPaint, (int) (bitmap.getWidth() - a16), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.5f, true).draw(canvas);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(-16776961);
        new StaticLayout(str, 0, str.length(), textPaint, (int) (bitmap.getWidth() - a16), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.5f, true).draw(canvas);
        canvas.save();
        canvas.restore();
    }

    static boolean q() {
        String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.pg_switch.name(), "1|1|1");
        if (QLog.isDevelopLevel()) {
            QLog.d("peak_pgjpeg", 4, "DeviceProfileManager.DpcNames.pg_switch value " + featureValue);
        }
        String[] split = featureValue.split("\\|");
        if (split.length < 1) {
            return false;
        }
        return split[0].equals("1");
    }

    public static long r(String str) {
        if (!TextUtils.isEmpty(str) && FileUtils.fileExistsAndNotEmpty(str)) {
            return new File(str).length();
        }
        com.tencent.mobileqq.pic.f.d("compress.Utils", "getFileSize()", "path is empty, or file does not exist. path:" + str);
        return 0L;
    }

    public static Bitmap s() {
        Drawable drawable = BaseApplication.getContext().getResources().getDrawable(R.drawable.c2o);
        if (drawable != null) {
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            if (drawable instanceof SkinnableBitmapDrawable) {
                return ((SkinnableBitmapDrawable) drawable).getBitmap();
            }
        }
        return null;
    }

    public static String t(String str, int i3) {
        String substring;
        String str2;
        if (!TextUtils.isEmpty(str) && FileUtils.fileExists(str) && w(i3)) {
            int lastIndexOf = str.lastIndexOf("/");
            int lastIndexOf2 = str.lastIndexOf(".");
            if (lastIndexOf2 > 0 && lastIndexOf2 > lastIndexOf) {
                substring = str.substring(lastIndexOf + 1, lastIndexOf2);
            } else {
                substring = str.substring(lastIndexOf + 1);
            }
            long lastModified = new File(str).lastModified();
            String vFSPath = RmVFSUtils.getVFSPath(AppConstants.SDCARD_PATH + "photo/");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(vFSPath);
            stringBuffer.append("_");
            stringBuffer.append(str.hashCode());
            stringBuffer.append("_");
            stringBuffer.append(substring);
            stringBuffer.append("_");
            stringBuffer.append(lastModified);
            stringBuffer.append("_");
            if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
                str2 = "wifi";
            } else {
                str2 = "xg";
            }
            stringBuffer.append(str2);
            stringBuffer.append("_");
            stringBuffer.append(i3);
            stringBuffer.append(".jpg");
            File file = new File(vFSPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            return stringBuffer.toString();
        }
        com.tencent.mobileqq.pic.f.b("compress.Utils", "getSendPhotoPath()", "realpath is empty, or file does not exist, or picQuality Illegal realpath:" + str + " picQuality:" + i3);
        return "";
    }

    public static c u(ThumbWidthHeightDP thumbWidthHeightDP, int i3, int i16) {
        boolean z16;
        boolean z17;
        boolean z18;
        int max;
        int i17;
        if (i3 == 2) {
            i17 = n.f317097d;
            max = n.f317094a;
        } else if (thumbWidthHeightDP != null) {
            int maxPx = thumbWidthHeightDP.maxPx();
            max = thumbWidthHeightDP.minPx();
            i17 = maxPx;
        } else {
            boolean z19 = false;
            if (i3 == 3) {
                z16 = true;
            } else {
                z16 = false;
            }
            int aioThumbMaxPx = AIOImgThumbHelper.getAioThumbMaxPx(z16, true, i16);
            if (i3 == 3) {
                z17 = true;
            } else {
                z17 = false;
            }
            int max2 = Math.max(aioThumbMaxPx, CommonImgThumbHelper.getImgThumbMaxPx(z17));
            if (i3 == 3) {
                z18 = true;
            } else {
                z18 = false;
            }
            int aioThumbMinPx = AIOImgThumbHelper.getAioThumbMinPx(z18, true, i16);
            if (i3 == 3) {
                z19 = true;
            }
            max = Math.max(aioThumbMinPx, CommonImgThumbHelper.getImgThumbMinPx(z19));
            i17 = max2;
        }
        return new c(max, max, i17, i17);
    }

    public static String v(String str) {
        String substring;
        if (!TextUtils.isEmpty(str) && FileUtils.fileExists(str)) {
            String vFSPath = RmVFSUtils.getVFSPath(AppConstants.SDCARD_PATH + "thumb/");
            if (str.startsWith(vFSPath)) {
                return str;
            }
            int lastIndexOf = str.lastIndexOf("/");
            int lastIndexOf2 = str.lastIndexOf(".");
            if (lastIndexOf2 <= 0) {
                substring = str.substring(lastIndexOf + 1);
            } else if (lastIndexOf < lastIndexOf2 + 1) {
                substring = str.substring(lastIndexOf + 1, lastIndexOf2);
            } else {
                substring = str.substring(lastIndexOf + 1);
            }
            long lastModified = new File(str).lastModified();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(vFSPath);
            stringBuffer.append("_");
            stringBuffer.append(str.hashCode());
            stringBuffer.append("_");
            stringBuffer.append(substring);
            stringBuffer.append("_");
            stringBuffer.append(lastModified);
            stringBuffer.append(".jpg");
            File file = new File(vFSPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            return stringBuffer.toString();
        }
        com.tencent.mobileqq.pic.f.b("compress.Utils", "getThumbnailPath()", "realpath is empty, or file does not exist, realpath:" + str);
        return "";
    }

    public static boolean w(int i3) {
        if (i3 == 0 || i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    public static boolean x(String str) {
        boolean z16 = false;
        if (FileUtils.fileExistsAndNotEmpty(str) && FileUtils.estimateFileType(str).equals("jpg")) {
            try {
                float jpegQuality = JpegCompressor.getJpegQuality(str);
                long fileSizes = FileUtils.getFileSizes(str);
                if (jpegQuality <= 80.0f && fileSizes < 307200) {
                    z16 = true;
                }
                com.tencent.mobileqq.pic.f.b("compress.Utils", "isMatchQualityAndSizeCondition()", "getJpegQuality = " + jpegQuality + ",picSize = " + fileSizes + "result = " + z16);
            } catch (OutOfMemoryError e16) {
                com.tencent.mobileqq.pic.f.d("compress.Utils", "isMatchQualityAndSizeCondition()", "getJpegQuality OutOfMemoryError error = " + e16 + ",return false!");
                return false;
            } catch (RuntimeException e17) {
                com.tencent.mobileqq.pic.f.d("compress.Utils", "isMatchQualityAndSizeCondition()", "getJpegQuality RuntimeException error = " + e17 + ",return false!");
            }
        }
        return z16;
    }

    static boolean y(Bitmap bitmap, String str, String str2, String str3, int i3) {
        Bitmap f16 = f(bitmap);
        if (i3 == 3) {
            com.tencent.mobileqq.pic.f.b("compress.Utils", str2, str3 + " isDrawGIFSucc\uff1a" + o(f16));
        }
        boolean j3 = j(str, f16, 70, str3, null);
        if (f16 != null) {
            f16.recycle();
        }
        return j3;
    }
}
