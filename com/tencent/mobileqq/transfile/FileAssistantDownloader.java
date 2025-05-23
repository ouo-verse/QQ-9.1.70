package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.JpegExifReader;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.SliceBitmap;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.pic.api.IPicAIO;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.mobileqq.widget.n;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes19.dex */
public class FileAssistantDownloader extends AbsDownloader {
    static IPatchRedirector $redirector_ = null;
    public static final int RADIUS = 16;
    private static final String TAG = "FileAssistantDownloader";
    protected BaseApplicationImpl application;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class PhotoInfo {
        static IPatchRedirector $redirector_;
        public long fileSize;
        public boolean isAIOFilePic;
        public boolean isApkIcon;
        public boolean isRaw;
        public boolean isRound;
        public long modifiedDate;
        public String path;
        public int thumbHeight;
        public int thumbWidth;

        public PhotoInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FileAssistantDownloader.this);
                return;
            }
            this.isRaw = false;
            this.isRound = false;
            this.isApkIcon = false;
            this.isAIOFilePic = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class VideoBitmapCreator implements BitmapDecoder {
        static IPatchRedirector $redirector_;

        VideoBitmapCreator() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FileAssistantDownloader.this);
            }
        }

        @Override // com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder
        public Bitmap getBitmap(URL url) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
            }
            PhotoInfo parseUrl = FileAssistantDownloader.this.parseUrl(url);
            if (parseUrl == null) {
                return null;
            }
            return ShortVideoUtils.getVideoThumbnail(null, parseUrl.path);
        }
    }

    public FileAssistantDownloader(BaseApplicationImpl baseApplicationImpl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseApplicationImpl);
        } else {
            this.application = baseApplicationImpl;
        }
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private Object internalDecodeFile(DownloadParams downloadParams, PhotoInfo photoInfo) throws Exception {
        FileInputStream fileInputStream;
        BufferedInputStream bufferedInputStream;
        String str = photoInfo.path;
        BufferedInputStream bufferedInputStream2 = null;
        if (str == null) {
            return null;
        }
        File file = new File(str);
        try {
            if (GifDrawable.isGifFile(file) && photoInfo.isRaw) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "DecodeFile END,GIF image,cacheFile=" + file.getAbsolutePath() + JefsClass.INDEX_URL + str);
                }
                return null;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = URLDrawableHelper.mConfig;
            options.inDensity = 160;
            options.inTargetDensity = 160;
            options.inScreenDensity = 160;
            downloadParams.outOrientation = JpegExifReader.readOrientation(str);
            options.inJustDecodeBounds = true;
            try {
                fileInputStream = new FileInputStream(file.getAbsolutePath());
                try {
                    bufferedInputStream = new BufferedInputStream(fileInputStream);
                } catch (Exception unused) {
                    bufferedInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Exception unused2) {
                bufferedInputStream = null;
                fileInputStream = null;
            } catch (Throwable th6) {
                th = th6;
                fileInputStream = null;
            }
            try {
                byte[] bArr = new byte[2];
                bufferedInputStream.read(bArr);
                if (bArr[0] == 66 || bArr[1] == 77) {
                    bufferedInputStream.read(new byte[4]);
                    bufferedInputStream.skip(12L);
                    byte[] bArr2 = new byte[4];
                    bufferedInputStream.read(bArr2);
                    int byte2Int = byte2Int(bArr2);
                    byte[] bArr3 = new byte[4];
                    bufferedInputStream.read(bArr3);
                    int abs = Math.abs(byte2Int(bArr3));
                    if (byte2Int < 0 || byte2Int * abs > 2280000) {
                        Bitmap drawableToBitmap = drawableToBitmap(BaseApplication.getContext().getResources().getDrawable(R.drawable.asd));
                        bufferedInputStream.close();
                        fileInputStream.close();
                        return drawableToBitmap;
                    }
                }
                bufferedInputStream.close();
            } catch (Exception unused3) {
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                options.inJustDecodeBounds = true;
                SafeBitmapFactory.decodeFile(file.getAbsolutePath(), options);
                if (options.outHeight == 0) {
                }
                throw new IOException("step:decode bounds error, not valid pic");
            } catch (Throwable th7) {
                th = th7;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
            fileInputStream.close();
            options.inJustDecodeBounds = true;
            SafeBitmapFactory.decodeFile(file.getAbsolutePath(), options);
            if (options.outHeight == 0 && options.outWidth != 0) {
                options.inSampleSize = AbstractImageDownloader.calculateInSampleSize(options, downloadParams.reqWidth, downloadParams.reqHeight);
                if (options.outHeight * options.outWidth > 16000000) {
                    QLog.i(TAG, 1, "pic size is big h[" + options.outHeight + "] w[" + options.outWidth + "], igon,return null");
                    return null;
                }
                options.inJustDecodeBounds = false;
                Object internalDecodeFile_decodeImage = internalDecodeFile_decodeImage(str, file, options);
                if (internalDecodeFile_decodeImage != null) {
                    return internalDecodeFile_decodeImage;
                }
                throw new IOException("decode image failed");
            }
            throw new IOException("step:decode bounds error, not valid pic");
        } catch (Exception e16) {
            throw e16;
        }
    }

    @Nullable
    private Object internalDecodeFile_decodeImage(String str, File file, BitmapFactory.Options options) {
        Bitmap bitmap = null;
        int i3 = 1;
        while (i3 <= 3) {
            try {
                Bitmap decodeFile = SafeBitmapFactory.decodeFile(file.getAbsolutePath(), options);
                if (decodeFile != null) {
                    SliceBitmap.needSlice(decodeFile);
                    return decodeFile;
                }
                throw new OutOfMemoryError("DecodeFile Failed,bitmap == null, url:" + str + " ,retry count: " + i3 + ",path:" + file.getAbsolutePath());
            } catch (OutOfMemoryError e16) {
                if (0 != 0) {
                    bitmap.recycle();
                }
                String message = e16.getMessage();
                if (i3 == 3 && QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "DecodeFile ERROR,oom retryCount=" + i3 + ",options.inSampleSize=" + options.inSampleSize + ",cacheFile=" + file.getAbsolutePath() + JefsClass.INDEX_URL + str + ",oom.msg:" + message);
                }
                i3++;
                options.inSampleSize *= 2;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x007b, code lost:
    
        r0 = (int) ((r4 * (r12 / r3)) + 0.5f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0082, code lost:
    
        if (r0 <= r13) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0085, code lost:
    
        r13 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private RoundRectBitmap resizeAndClipBitmap(Bitmap bitmap, DownloadParams downloadParams, int i3, int i16) {
        float f16;
        float f17;
        try {
            float f18 = this.application.getResources().getDisplayMetrics().density;
            int i17 = this.application.getResources().getDisplayMetrics().densityDpi;
            float aioImageRoundCorner = ((IPicAIO) QRoute.api(IPicAIO.class)).getAioImageRoundCorner(downloadParams) * f18;
            Paint paint = new Paint(1);
            paint.setColor(-16777216);
            if (i3 <= 0 || i16 <= 0) {
                i3 = n.f317095b;
                i16 = n.f317096c;
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int i18 = FilePicURLDrawlableHelper.f209167a;
                int i19 = FilePicURLDrawlableHelper.f209168b;
                if (width >= i19 && height >= i19) {
                    if (width < i18 && height < i18) {
                        i3 = (int) ((width * f18) + 0.5f);
                        i16 = (int) ((height * f18) + 0.5f);
                    } else {
                        float f19 = i16;
                        if (width > height) {
                            f16 = width;
                        } else {
                            f16 = height;
                        }
                        float f26 = f19 / f16;
                        float f27 = i3;
                        if (width > height) {
                            f17 = height;
                        } else {
                            f17 = width;
                        }
                        float max = Math.max(f26, f27 / f17);
                        i16 = (int) ((width * max) + 0.5f);
                        i3 = (int) ((height * max) + 0.5f);
                        int i26 = i16;
                        i16 = i3;
                        i3 = i26;
                    }
                }
                int i27 = (int) ((width * (i3 / height)) + 0.5f);
                if (i27 <= i16) {
                    i16 = i27;
                }
                int i262 = i16;
                i16 = i3;
                i3 = i262;
            }
            Bitmap createBitmap = Bitmap.createBitmap(i3, i16, URLDrawableHelper.mThumbConfig);
            createBitmap.setDensity(i17);
            new Canvas(createBitmap).drawBitmap(bitmap, (Rect) null, new Rect(0, 0, i3, i16), paint);
            return new RoundRectBitmap(createBitmap, aioImageRoundCorner);
        } catch (OutOfMemoryError unused) {
            return new RoundRectBitmap(bitmap, URLDrawableHelper.getRoundCorner());
        }
    }

    int byte2Int(byte[] bArr) {
        return (bArr[0] & 255) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8);
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        boolean z16;
        Bitmap thumb;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, this, file, downloadParams, uRLDrawableHandler);
        }
        AlbumThumbManager albumThumbManager = AlbumThumbManager.getInstance(BaseApplication.getContext());
        PhotoInfo parseUrl = parseUrl(downloadParams.url);
        if (parseUrl == null) {
            return null;
        }
        if (FileManagerUtil.getFileType(parseUrl.path) == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (parseUrl.isRaw && !parseUrl.isApkIcon && !z16) {
            if (parseUrl.isAIOFilePic) {
                return internalDecodeAIOFilePic(downloadParams, parseUrl);
            }
            Bitmap bitmap = (Bitmap) internalDecodeFile(downloadParams, parseUrl);
            if (parseUrl.isRound) {
                return FileManagerUtil.getCircleFaceBitmap(this.application, bitmap, 16);
            }
            return bitmap;
        }
        if (parseUrl.isApkIcon) {
            Drawable apkIcon = ((IQQFileSelectorUtil) QRoute.api(IQQFileSelectorUtil.class)).getApkIcon(this.application, parseUrl.path);
            if (apkIcon != null) {
                thumb = drawableToBitmap(apkIcon);
            } else {
                thumb = drawableToBitmap(BaseApplication.getContext().getResources().getDrawable(R.drawable.filelook_apk));
            }
        } else {
            thumb = albumThumbManager.getThumb(downloadParams.url, new VideoBitmapCreator());
        }
        if (thumb == null) {
            thumb = drawableToBitmap(BaseApplication.getContext().getResources().getDrawable(FileManagerUtil.getFileIconResId(FileManagerUtil.getFileType(parseUrl.path))));
        }
        if (thumb == null) {
            return null;
        }
        if (parseUrl.isRound) {
            return FileManagerUtil.getCircleFaceBitmap(this.application, thumb, 16);
        }
        return thumb;
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, this, outputStream, downloadParams, uRLDrawableHandler);
        }
        PhotoInfo parseUrl = parseUrl(downloadParams.url);
        if (parseUrl != null && parseUrl.path != null) {
            return new File(parseUrl.path);
        }
        return new File(AppConstants.SDCARD_ROOT);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object internalDecodeAIOFilePic(DownloadParams downloadParams, PhotoInfo photoInfo) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this, (Object) downloadParams, (Object) photoInfo);
        }
        String str = photoInfo.path;
        if (str == null) {
            return null;
        }
        File file = new File(str);
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = URLDrawableHelper.mThumbConfig;
            options.inDensity = 160;
            options.inTargetDensity = 160;
            options.inScreenDensity = 160;
            options.inJustDecodeBounds = false;
            Bitmap decodeFile = SafeBitmapFactory.decodeFile(file.getAbsolutePath(), options);
            Bitmap bitmap = decodeFile;
            if (decodeFile != null) {
                RoundRectBitmap resizeAndClipBitmap = resizeAndClipBitmap(decodeFile, downloadParams, photoInfo.thumbWidth, photoInfo.thumbHeight);
                if (!decodeFile.equals(resizeAndClipBitmap.mBitmap)) {
                    decodeFile.recycle();
                }
                RoundRectBitmap roundRectBitmap = new RoundRectBitmap(((IPicUtil) QRoute.api(IPicUtil.class)).getExifBitmap(file.getAbsolutePath(), resizeAndClipBitmap.mBitmap), resizeAndClipBitmap.mCornerRadius, resizeAndClipBitmap.mBoardColor, resizeAndClipBitmap.mBorderWidth);
                BaseApplicationImpl baseApplicationImpl = this.application;
                bitmap = roundRectBitmap;
                if (baseApplicationImpl != null) {
                    roundRectBitmap.mDisplayWidth = baseApplicationImpl.getResources().getDisplayMetrics().widthPixels;
                    roundRectBitmap.mDisplayHeight = this.application.getResources().getDisplayMetrics().heightPixels;
                    bitmap = roundRectBitmap;
                }
            }
            return bitmap;
        } catch (Exception e16) {
            throw e16;
        }
    }

    public PhotoInfo parseUrl(URL url) {
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (PhotoInfo) iPatchRedirector.redirect((short) 6, (Object) this, (Object) url);
        }
        try {
            String[] split = url.getFile().split("\\|");
            PhotoInfo photoInfo = new PhotoInfo();
            boolean z19 = false;
            photoInfo.path = split[0];
            photoInfo.thumbWidth = Integer.parseInt(split[1]);
            photoInfo.thumbHeight = Integer.parseInt(split[2]);
            photoInfo.modifiedDate = Long.parseLong(split[3]);
            if (split.length > 4) {
                if (Integer.parseInt(split[4]) == 1) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                photoInfo.isRaw = z18;
            }
            if (split.length > 5) {
                if (Integer.parseInt(split[5]) == 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                photoInfo.isRound = z17;
            }
            if (split.length > 6) {
                if (Integer.parseInt(split[6]) == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                photoInfo.isApkIcon = z16;
            }
            if (split.length > 7) {
                if (Integer.parseInt(split[7]) == 1) {
                    z19 = true;
                }
                photoInfo.isAIOFilePic = z19;
            }
            return photoInfo;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public boolean useDiskCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }
}
