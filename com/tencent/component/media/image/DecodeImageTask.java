package com.tencent.component.media.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.animwebp.AnimWebPHelper;
import com.tencent.component.media.animwebp.AnimWebpImage;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.drawable.BitmapImageDrawable;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;
import com.tencent.component.media.image.image.AvifDynamicImage;
import com.tencent.component.media.image.image.BitmapImage;
import com.tencent.component.media.image.image.FeedsBitmapImage;
import com.tencent.component.media.image.image.NewGifImage;
import com.tencent.component.media.image.processor.NewGifDrawableSpecifiedRegionProcessor;
import com.tencent.component.media.image.region.RegionDrawable;
import com.tencent.component.media.image.region.RegionImageUtil;
import com.tencent.component.media.photogif.PhotoGifDrawable;
import com.tencent.component.media.photogif.PhotoGifImage;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.component.media.utils.ImageManagerLog;
import com.tencent.component.media.utils.QZoneImageDecodeUtils;
import com.tencent.qzone.avif.AvifImageDetector;
import com.tencent.qzone.avif.a;
import com.tencent.sharpP.SharpPDecoderHelper;
import com.tencent.sharpP.SharpPDecoderWrapper;
import com.tencent.sharpP.SharpPUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import libavif.AvifDecoder;
import libavif.AvifImage;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DecodeImageTask extends ImageTask {
    private static final int MAX_CROP_PIC_WIDTH = 500;
    private static final int MAX_CROP_TRY_TIME = 3;
    private static String TAG = "DecodeImageTask";
    private DecodeImageTask next;
    private static final long MIN_LOG_DECODE_COST = TimeUnit.SECONDS.toNanos(2);
    private static ConcurrentHashMap<String, ImageAttri> mImagePath2AttriMap = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Integer> mImagePath2RotationMap = new ConcurrentHashMap<>();
    private static DecodeImageTask sPool = null;
    private static final Object sPoolSync = new Object();
    private static int mObjectPoolSize = 0;
    private static ConcurrentHashMap<Integer, Integer> mImageKey2SampleSizeMap = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class DecodeTask implements Runnable, Comparable<DecodeTask> {
        private ImageKey key;

        public DecodeTask(ImageKey imageKey) {
            this.key = imageKey;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageLoader.Options options;
            ImageKey imageKey = DecodeImageTask.this.mImageKey;
            if (imageKey != null) {
                ImageTaskTracer.removeImageDecodeThreadPendingRecord(imageKey.hashCodeEx());
                ImageTaskTracer.addImageDecodeThreadDecodingRecord(DecodeImageTask.this.mImageKey.hashCodeEx());
            }
            try {
                Drawable drawbleFromCache = ImageManager.getInstance().getDrawbleFromCache(DecodeImageTask.this.mImageKey);
                if (drawbleFromCache == null) {
                    DecodeImageTask.this.handlerImageDecodeMessage(this.key);
                } else {
                    DecodeImageTask.this.setResult(11, drawbleFromCache);
                }
            } catch (Throwable th5) {
                ImageManagerLog.e(DecodeImageTask.TAG, Log.getStackTraceString(th5));
                ImageKey imageKey2 = DecodeImageTask.this.mImageKey;
                if (imageKey2 != null && (options = imageKey2.options) != null) {
                    options.errCode = ImageManager.getErrorString(imageKey2, 101);
                }
                DecodeImageTask.this.setResult(9, new Object[0]);
                ImageKey imageKey3 = this.key;
                if (imageKey3 != null) {
                    ImageTaskTracer.addImageDecodeFailedRecord(imageKey3.hashCodeEx());
                    ImageTaskTracer.removeImageDecodeThreadDecodingRecord(this.key.hashCodeEx());
                }
            }
            ImageManager.getInstance().nocachedDeleteLocalFile(this.key);
            this.key = null;
        }

        @Override // java.lang.Comparable
        public int compareTo(DecodeTask decodeTask) {
            ImageLoader.Options options;
            ImageKey imageKey = DecodeImageTask.this.mImageKey;
            return (imageKey == null || (options = imageKey.options) == null || !options.priority) ? 0 : 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class ImageAttri {
        public static final String UNKNOWN = "unknown";
        public int srcWidth = 0;
        public int srcHeight = 0;
        public String mimeType = "";

        ImageAttri() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DecodeImageTask(ImageTask imageTask) {
        super(imageTask);
        this.next = null;
    }

    public static void clearImageKey2SampleSizeMap() {
        mImageKey2SampleSizeMap.clear();
    }

    public static void clearImagePath2AttriMap() {
        mImagePath2AttriMap.clear();
    }

    public static void clearImagePath2RotationMap() {
        mImagePath2RotationMap.clear();
    }

    private boolean decodeAnimateWebp(ImageKey imageKey) {
        byte[] bytesFromFile;
        if (imageKey == null || !AnimWebPHelper.isAnimWebpUrl(imageKey.url) || !AnimWebPHelper.isReady() || (bytesFromFile = AnimWebPHelper.bytesFromFile(imageKey.filePath)) == null || !AnimWebPHelper.isAnimWebP(bytesFromFile)) {
            return false;
        }
        AnimWebpImage animWebpImage = new AnimWebpImage(bytesFromFile);
        Drawable drawable = animWebpImage.getDrawable();
        if (drawable == null) {
            ImageManagerLog.e(TAG, "decodeWebp fail");
            ImageLoader.Options options = imageKey.options;
            if (options != null) {
                options.errCode = ImageManager.getErrorString(imageKey, 113);
            }
            setResult(9, new Object[0]);
            ImageTaskTracer.addImageDecodeFailedRecord(imageKey.hashCodeEx());
            ImageTaskTracer.removeImageDecodeThreadDecodingRecord(imageKey.hashCodeEx());
        } else {
            int hashCodeEx = imageKey.hashCodeEx();
            ImageManager.getInstance().putDrawableInMemoryCache(imageKey, hashCodeEx, animWebpImage, drawable, imageKey.options);
            setResult(8, drawable, null, imageKey.urlKey, Integer.valueOf(hashCodeEx), animWebpImage, drawable);
            ImageTaskTracer.removeImageDecodeThreadDecodingRecord(imageKey.hashCodeEx());
            ImageTracer.endDecode(imageKey.url);
        }
        return true;
    }

    private boolean decodeAvif(ImageKey imageKey) {
        if (a.b(imageKey.url) && imageKey.filePath != null) {
            ImageManagerLog.d("AVIF_", "decodeAvif -- url: " + imageKey.url + " --is Avif");
            if (handlerAvifDecodeMessage(imageKey)) {
                return true;
            }
            if (a.a(new File(imageKey.filePath))) {
                ImageManagerLog.e("AVIF_", "is avif but decode fail");
                recordDecodeFail(imageKey, "image/avif", "decode avif failed");
                return true;
            }
            ImageManagerLog.w("AVIF_", "decodeAvif fail: " + imageKey.url + " --is not really Avif, so try normal decode");
            return false;
        }
        return false;
    }

    private void decodeBounds(ImageKey imageKey, InputStream inputStream, ImageAttri imageAttri, BitmapFactory.Options options) {
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        String str = options.outMimeType;
        if (str == null) {
            str = "unknown";
        }
        imageAttri.mimeType = str;
        imageAttri.srcHeight = options.outHeight;
        imageAttri.srcWidth = options.outWidth;
        mImagePath2AttriMap.put(imageKey.filePath, imageAttri);
    }

    private boolean decodeGif(ImageKey imageKey, ImageAttri imageAttri) {
        ImageLoader.Options options;
        if (ImageManagerEnv.g().isForceShutdownGif()) {
            ImageManagerLog.w(TAG, "[decodeGif] force shutdown gif decode");
            return false;
        }
        if (!QZoneImageDecodeUtils.isGif(imageAttri.mimeType) || (options = imageKey.options) == null || !options.needShowGifAnimation) {
            return false;
        }
        int i3 = options.clipWidth;
        int i16 = options.clipHeight;
        if (i3 <= 0 || i16 <= 0) {
            i3 = ImageManagerEnv.g().getScreenWidth();
            i16 = ImageManagerEnv.g().getScreenHeight();
        }
        NewGifImage newGifImage = new NewGifImage(imageKey, i3, i16);
        Drawable drawable = newGifImage.getDrawable();
        ImageManagerEnv.g().reportImageDecodingResMTA("gif_collect", "normal/gif");
        if (drawable != null) {
            ImageLoader.Options options2 = imageKey.options;
            if (options2 != null) {
                ImageProcessor imageProcessor = options2.extraProcessor;
                if (imageProcessor instanceof NewGifDrawableSpecifiedRegionProcessor) {
                    drawable = imageProcessor.doProcess(drawable);
                }
            }
            int hashCodeEx = imageKey.hashCodeEx();
            ImageManager.getInstance().putDrawableInMemoryCache(imageKey, hashCodeEx, newGifImage, drawable, imageKey.options);
            setResult(8, drawable, null, imageKey.urlKey, Integer.valueOf(hashCodeEx), newGifImage, drawable);
        } else {
            if (!TextUtils.isEmpty(imageKey.filePath) && SharpPUtils.isSharpP(new File(imageKey.filePath))) {
                ImageManagerLog.e(TAG, "decodeGif url----" + imageKey.url + "   is not normal gif picture,try sharpP decode");
                boolean handlerSharpPDecodeMessage = handlerSharpPDecodeMessage(imageKey);
                if (!handlerSharpPDecodeMessage) {
                    setResult(9, new Object[0]);
                }
                return handlerSharpPDecodeMessage;
            }
            ImageLoader.Options options3 = imageKey.options;
            if (options3 != null) {
                options3.errCode = ImageManager.getErrorString(imageKey, 107);
            }
            setResult(9, new Object[0]);
            ImageTaskTracer.addImageDecodeFailedRecord(imageKey.hashCodeEx());
        }
        ImageTaskTracer.removeImageDecodeThreadDecodingRecord(imageKey.hashCodeEx());
        return true;
    }

    private boolean decodeImageFrame(ImageKey imageKey) {
        if (!PhotoGifDrawable.isPhotoGif(imageKey)) {
            return false;
        }
        int hashCodeEx = imageKey.hashCodeEx();
        PhotoGifImage photoGifImage = new PhotoGifImage(imageKey);
        Drawable drawable = photoGifImage.getDrawable();
        if (drawable != null) {
            ImageManager.getInstance().putDrawableInMemoryCache(imageKey, hashCodeEx, photoGifImage, drawable, imageKey.options);
            setResult(8, drawable, null, imageKey.urlKey, Integer.valueOf(hashCodeEx), photoGifImage, drawable);
        } else {
            ImageLoader.Options options = imageKey.options;
            if (options != null) {
                options.errCode = ImageManager.getErrorString(imageKey, 106);
            }
            setResult(9, new Object[0]);
            ImageManagerEnv.g().reportImageDecodingTask(ImageConsts.IMAGE_TYPE_GIF, imageKey.url, new File(imageKey.filePath).length(), 51000, "decode gif failed, gif drawable is null", System.currentTimeMillis());
        }
        return true;
    }

    private BitmapReference decodeImageStream(IDecoder iDecoder, FileInputStream fileInputStream, BitmapFactory.Options options, boolean z16) {
        if (fileInputStream == null) {
            return null;
        }
        if (iDecoder != null) {
            return iDecoder.decodeImage(fileInputStream, options);
        }
        ImageManagerLog.e(TAG, "decodeImageStream wtf decoder==null");
        return null;
    }

    private boolean decodeNormalImage(ImageKey imageKey, ImageAttri imageAttri, FileInputStream fileInputStream, BitmapFactory.Options options) {
        int intValue;
        BitmapReference bitmapReference;
        int i3;
        int i16;
        Bitmap.Config config;
        long nanoTime = System.nanoTime();
        int hashCodeEx = imageKey.hashCodeEx();
        if (imageKey.options != null && !TextUtils.isEmpty(imageKey.filePath)) {
            ImageLoader.Options options2 = imageKey.options;
            if (options2.isNeedPieceLoad) {
                options2.isNeedPieceLoad = RegionImageUtil.isValidRegionImageFormat(imageKey.filePath);
                ImageManagerLog.i(TAG, "decodeNormalImage Region decode file isValidRegionImageFormat with isNeedPieceLoad = " + imageKey.options.isNeedPieceLoad);
            }
        }
        Integer num = mImageKey2SampleSizeMap.get(Integer.valueOf(hashCodeEx));
        if (num == null) {
            intValue = ImageOptionSampleSize.computeSampleSize(imageKey.options, imageAttri.srcWidth, imageAttri.srcHeight);
            mImageKey2SampleSizeMap.put(Integer.valueOf(hashCodeEx), Integer.valueOf(intValue));
        } else {
            intValue = num.intValue();
        }
        ImageLoader.Options options3 = imageKey.options;
        if (options3 != null && (config = options3.imageConfig) != null) {
            options.inPreferredConfig = config;
        } else if (QZoneImageDecodeUtils.isPng(imageAttri.mimeType)) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        } else {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        if (intValue == 1 && options.inPreferredConfig == Bitmap.Config.ARGB_8888) {
            int i17 = imageAttri.srcHeight;
            int i18 = imageAttri.srcWidth;
            float f16 = i17 / i18;
            if ((f16 > 2.0f || f16 < 0.5f) && i17 * i18 > ImageManagerEnv.g().getScreenHeight() * ImageManagerEnv.g().getScreenWidth()) {
                options.inPreferredConfig = Bitmap.Config.RGB_565;
            }
        }
        Bitmap.Config config2 = options.inPreferredConfig;
        Bitmap.Config config3 = Bitmap.Config.RGB_565;
        if (config2 == config3) {
            options.inDither = true;
        }
        ImageLoader.Options options4 = imageKey.options;
        if (options4 != null && ((i3 = options4.mImageType) == 3 || i3 == 4)) {
            Bitmap.Config config4 = options4.imageConfig;
            if (config4 != null) {
                options.inPreferredConfig = config4;
            } else {
                if (imageAttri.srcWidth != 0 && (i16 = imageAttri.srcHeight) != 0 && r7 / i16 == 2.0f) {
                    options.inPreferredConfig = config3;
                } else {
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                }
            }
        }
        imageKey.inSampleSize = intValue;
        int i19 = imageAttri.srcWidth;
        imageKey.orgWidth = i19;
        int i26 = imageAttri.srcHeight;
        imageKey.orgHeight = i26;
        options.outWidth = i19;
        options.outHeight = i26;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = intValue;
        options.outMimeType = imageAttri.mimeType;
        if (options4 != null && options4.cropHead) {
            bitmapReference = decodePicCropHead(fileInputStream, options4.cropHwRation);
        } else {
            bitmapReference = null;
        }
        if (bitmapReference == null) {
            bitmapReference = decodeImageStream(ImageManager.getInstance().getDecoder(), fileInputStream, options, false);
        }
        BitmapReference bitmapReference2 = bitmapReference;
        if (bitmapReference2 == null && !TextUtils.isEmpty(imageKey.filePath) && SharpPUtils.isSharpP(new File(imageKey.filePath))) {
            ImageManagerLog.e(TAG, "decodeNormalImage --url=" + imageKey.url + "  is not normal picture,try sharpP decode");
            boolean handlerSharpPDecodeMessage = handlerSharpPDecodeMessage(imageKey);
            if (!handlerSharpPDecodeMessage) {
                setResult(9, new Object[0]);
                ImageManagerLog.e(TAG, "decodeNormalImage -- url=" + imageKey.url + "  is not normal picture,try sharpP decode failed");
            }
            return handlerSharpPDecodeMessage;
        }
        if (System.nanoTime() - nanoTime > MIN_LOG_DECODE_COST) {
            ImageManagerLog.w(TAG, "decodeNormalImage: decode " + imageKey.filePath + " " + imageKey.url + " cost too much time");
        }
        processBitmap(bitmapReference2, imageKey, hashCodeEx, true, imageAttri.mimeType);
        if (bitmapReference2 != null) {
            return true;
        }
        return false;
    }

    private BitmapReference decodePicCropHead(InputStream inputStream, float f16) {
        BitmapRegionDecoder bitmapRegionDecoder;
        BitmapReference bitmapReference = null;
        if (inputStream != null && f16 > 0.0f) {
            int i3 = 0;
            while (true) {
                if (i3 < 3) {
                    try {
                        bitmapRegionDecoder = BitmapRegionDecoder.newInstance(inputStream, false);
                        break;
                    } catch (IOException e16) {
                        ImageManagerEnv.getLogger().w(TAG, "decodePicCropHead: failed to get decoder " + i3, e16);
                        i3++;
                    }
                } else {
                    bitmapRegionDecoder = null;
                    break;
                }
            }
            if (bitmapRegionDecoder == null) {
                return null;
            }
            int width = bitmapRegionDecoder.getWidth();
            int height = bitmapRegionDecoder.getHeight();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = (width / 500) + 1;
            float f17 = width * f16;
            if (f17 > height) {
                return null;
            }
            Rect rect = new Rect(0, 0, width, (int) f17);
            for (int i16 = 0; i16 < 3; i16++) {
                if (i16 == 1) {
                    options.inSampleSize *= 2;
                }
                try {
                    bitmapReference = BitmapReference.getBitmapReference(bitmapRegionDecoder.decodeRegion(rect, options));
                    break;
                } catch (Throwable th5) {
                    ImageManagerEnv.getLogger().w(TAG, "decodePicCropHead: failed to decode bitmap " + i16, th5);
                }
            }
        }
        return bitmapReference;
    }

    private boolean decodeSharpP(ImageKey imageKey) {
        if (SharpPUtils.isSharpP(imageKey.url) && imageKey.filePath != null) {
            ImageManagerLog.d(TAG, "decodeSharpP -- url: " + imageKey.url + " --is SharpP");
            boolean handlerSharpPDecodeMessage = handlerSharpPDecodeMessage(imageKey);
            if (!handlerSharpPDecodeMessage && !SharpPUtils.isSharpP(new File(imageKey.filePath))) {
                ImageManagerLog.w(TAG, "decodeSharpP -- url: " + imageKey.url + " --is not really SharpP,so try normal decode");
            } else {
                if (!handlerSharpPDecodeMessage) {
                    ImageManager.getInstance().checkBitmapDecodeFailCount(imageKey);
                    setResult(9, new Object[0]);
                    ImageManagerLog.e(TAG, "decodeSharpP -- url: " + imageKey.url + " --  decode sharpp failed.");
                    ImageTaskTracer.addImageDecodeFailedRecord(imageKey.hashCodeEx());
                    ImageTaskTracer.removeImageDecodeThreadDecodingRecord(imageKey.hashCodeEx());
                    ImageTracer.decodeFail(imageKey.url);
                    ImageManagerEnv.g().reportImageDecodingTask(ImageConsts.IMAGE_TYPE_SHARPP, imageKey.url, new File(imageKey.filePath).length(), 51000, "decode sharpP image failed", System.currentTimeMillis());
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    private boolean decodeVideoThumb(ImageKey imageKey) {
        if (VideoThumbnail.isVideo(imageKey.filePath)) {
            processBitmap(VideoThumbnail.getThumb(ImageManagerEnv.getAppContext(), imageKey.filePath), imageKey, imageKey.hashCodeEx(), false, "");
            return true;
        }
        return false;
    }

    private Bitmap.Config getBitmapConfig(ImageKey imageKey, int i3, int i16, int i17, String str) {
        Bitmap.Config config;
        Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
        ImageLoader.Options options = imageKey.options;
        if (options != null && (config = options.imageConfig) != null) {
            config2 = config;
        } else if (SharpPUtils.isJpg(str)) {
            config2 = Bitmap.Config.RGB_565;
        }
        if (i3 == 1 && config2 == Bitmap.Config.ARGB_8888) {
            float f16 = i17 / i16;
            if ((f16 > 2.0f || f16 < 0.5f) && i17 * i16 > ImageManagerEnv.g().getScreenHeight() * ImageManagerEnv.g().getScreenWidth()) {
                config2 = Bitmap.Config.RGB_565;
            }
        }
        ImageLoader.Options options2 = imageKey.options;
        if (options2 != null) {
            int i18 = options2.mImageType;
            if (i18 == 3 || i18 == 4) {
                Bitmap.Config config3 = options2.imageConfig;
                if (config3 == null) {
                    if (i16 != 0 && i17 != 0 && i16 / i17 == 2.0f) {
                        return Bitmap.Config.RGB_565;
                    }
                    return Bitmap.Config.ARGB_8888;
                }
                return config3;
            }
            return config2;
        }
        return config2;
    }

    private ImageAttri getImageAttrFromAvifImage(AvifImage avifImage, ImageKey imageKey) {
        ImageAttri imageAttri = mImagePath2AttriMap.get(imageKey.filePath);
        if (imageAttri == null || "unknown".equals(imageAttri.mimeType)) {
            ImageAttri imageAttri2 = new ImageAttri();
            imageAttri2.srcHeight = avifImage.a();
            imageAttri2.srcWidth = avifImage.b();
            imageAttri2.mimeType = "image/avif";
            mImagePath2AttriMap.put(imageKey.filePath, imageAttri2);
            return imageAttri2;
        }
        return imageAttri;
    }

    public static Integer getImagePath2Rotation(String str) {
        if (str != null) {
            return mImagePath2RotationMap.get(str);
        }
        return null;
    }

    private boolean handleAvifDynamicImage(AvifDecoder avifDecoder, ImageKey imageKey, int i3) {
        ImageManagerLog.d("AVIF_", "avif dynamic image");
        AvifDynamicImage avifDynamicImage = new AvifDynamicImage(avifDecoder);
        Drawable drawable = avifDynamicImage.getDrawable();
        ImageManagerEnv.g().reportImageDecodingResMTA("gif_collect", ImageConsts.IMAGE_TYPE_AVIF_DYNAMIC);
        if (drawable != null) {
            ImageProcessor imageProcessor = imageKey.options.extraProcessor;
            if (imageProcessor instanceof NewGifDrawableSpecifiedRegionProcessor) {
                drawable = imageProcessor.doProcess(drawable);
            }
            ImageManager.getInstance().putDrawableInMemoryCache(imageKey, i3, avifDynamicImage, drawable, imageKey.options);
            setResult(8, drawable, null, imageKey.urlKey, Integer.valueOf(i3), avifDynamicImage, drawable);
            ImageTaskTracer.removeImageDecodeThreadDecodingRecord(imageKey.hashCodeEx());
            ImageTracer.endDecode(imageKey.url);
            return true;
        }
        ImageLoader.Options options = imageKey.options;
        if (options != null) {
            options.errCode = ImageManager.getErrorString(imageKey, 114);
        }
        return false;
    }

    private boolean handleAvifStaticImage(AvifDecoder avifDecoder, ImageKey imageKey, int i3, ImageAttri imageAttri) {
        int i16 = imageAttri.srcWidth;
        imageKey.orgWidth = i16;
        int i17 = imageAttri.srcHeight;
        imageKey.orgHeight = i17;
        Bitmap createBitmap = Bitmap.createBitmap(i16, i17, Bitmap.Config.ARGB_8888);
        avifDecoder.f(createBitmap);
        avifDecoder.b();
        processBitmap(BitmapReference.getBitmapReference(createBitmap), imageKey, i3, true, imageAttri.mimeType);
        return true;
    }

    private boolean handlerAvifDecodeMessage(ImageKey imageKey) {
        int hashCodeEx = imageKey.hashCodeEx();
        try {
            ImageManagerLog.d("AVIF_", "handlerAvifDecodeMessage path: " + imageKey.filePath + ", hashcode: " + hashCodeEx + ", url: " + imageKey.url);
            byte[] readFile = ImageManagerEnv.g().readFile(imageKey.filePath);
            if (readFile != null && readFile.length > 0) {
                AvifDecoder c16 = AvifDecoder.c(readFile);
                if (c16 != null && c16.j()) {
                    ImageLoader.Options options = imageKey.options;
                    if (options != null && options.isNeedPieceLoad) {
                        options.isNeedPieceLoad = false;
                    }
                    ImageAttri imageAttrFromAvifImage = getImageAttrFromAvifImage(c16.g(), imageKey);
                    ImageLoader.Options options2 = imageKey.options;
                    if (options2 != null && options2.needShowGifAnimation && AvifImageDetector.c(ByteBuffer.wrap(readFile))) {
                        return handleAvifDynamicImage(c16, imageKey, hashCodeEx);
                    }
                    return handleAvifStaticImage(c16, imageKey, hashCodeEx, imageAttrFromAvifImage);
                }
                ImageManagerLog.w("AVIF_", "get avif decoder error: " + c16);
                return false;
            }
            ImageManagerLog.w("AVIF_", "read file error, fail to decode avif image.");
            return false;
        } catch (Throwable th5) {
            ImageManagerLog.e("AVIF_DecodeError", th5.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Not initialized variable reg: 16, insn: 0x026c: IF  (r16 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:108:0x0271 (LINE:621), block:B:107:0x026c */
    /* JADX WARN: Removed duplicated region for block: B:38:0x022c A[Catch: all -> 0x026b, TryCatch #6 {all -> 0x026b, blocks: (B:58:0x0199, B:60:0x019d, B:61:0x01a5, B:49:0x01e0, B:51:0x01e4, B:52:0x01ec, B:36:0x0228, B:38:0x022c, B:39:0x0234), top: B:26:0x00ef }] */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01e4 A[Catch: all -> 0x026b, TryCatch #6 {all -> 0x026b, blocks: (B:58:0x0199, B:60:0x019d, B:61:0x01a5, B:49:0x01e0, B:51:0x01e4, B:52:0x01ec, B:36:0x0228, B:38:0x022c, B:39:0x0234), top: B:26:0x00ef }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x019d A[Catch: all -> 0x026b, TryCatch #6 {all -> 0x026b, blocks: (B:58:0x0199, B:60:0x019d, B:61:0x01a5, B:49:0x01e0, B:51:0x01e4, B:52:0x01ec, B:36:0x0228, B:38:0x022c, B:39:0x0234), top: B:26:0x00ef }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handlerImageDecodeMessage(ImageKey imageKey) {
        long j3;
        String str;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        ImageLoader.Options options;
        ImageLoader.Options options2;
        ImageLoader.Options options3;
        boolean z16;
        long currentTimeMillis;
        ImageManagerEnv g16;
        String str2;
        int i3;
        if (!ImageManagerEnv.g().getCurrentLoadingImgStatus()) {
            ImageManagerLog.d(TAG, "\u6ed1\u52a8\u89e3\u7801\uff1a" + imageKey.url + ",path:" + imageKey.filePath);
        } else {
            ImageManagerLog.d(TAG, "\u6ed1\u52a8\u505c\u6b62\u89e3\u7801\uff1a" + imageKey.url + ",path:" + imageKey.filePath);
        }
        ImageTracer.startDecode(imageKey.url);
        ProgressTracer.print(3, imageKey.urlKey);
        ImageManager.getInstance().imageKeyFilePathCheck(imageKey);
        long currentTimeMillis2 = System.currentTimeMillis();
        File file = new File(imageKey.filePath);
        if (!TextUtils.isEmpty(imageKey.filePath)) {
            j3 = file.length();
        } else {
            j3 = 0;
        }
        if (decodeVideoThumb(imageKey)) {
            return;
        }
        if (decodeAvif(imageKey)) {
            ImageManagerEnv.g().reportImageDecodingRes("image/avif", imageKey.url, j3, true, System.currentTimeMillis() - currentTimeMillis2, 0);
            return;
        }
        if (decodeSharpP(imageKey)) {
            ImageManagerEnv.g().reportImageDecodingRes(ImageConsts.IMAGE_TYPE_SHARPP, imageKey.url, j3, true, System.currentTimeMillis() - currentTimeMillis2, 0);
            return;
        }
        if (decodeImageFrame(imageKey)) {
            ImageManagerEnv.g().reportImageDecodingRes(ImageConsts.IMAGE_TYPE_GIF, imageKey.url, j3, true, System.currentTimeMillis() - currentTimeMillis2, 0);
            return;
        }
        if (!decodeAnimateWebp(imageKey)) {
            ImageAttri imageAttri = mImagePath2AttriMap.get(imageKey.filePath);
            FileInputStream fileInputStream3 = null;
            try {
                try {
                    BitmapFactory.Options options4 = BitmapUtils.getOptions();
                    if (imageAttri == null) {
                        imageAttri = new ImageAttri();
                        FileInputStream fileInputStream4 = new FileInputStream(imageKey.filePath);
                        try {
                            decodeBounds(imageKey, new BufferedInputStream(fileInputStream4), imageAttri, options4);
                            fileInputStream3 = fileInputStream4;
                        } catch (Exception e16) {
                            e = e16;
                            str = "unknown";
                            fileInputStream = fileInputStream4;
                            options3 = imageKey.options;
                            if (options3 != null) {
                            }
                            ImageManagerLog.e(TAG, Log.getStackTraceString(e));
                            ImageManagerEnv.g().reportImageDecodingRes(str, imageKey.url, j3, false, System.currentTimeMillis() - currentTimeMillis2, 3);
                            ImageManagerEnv.g().reportImageDecodingTask(str, imageKey.url, j3, 51000, "decode exception", System.currentTimeMillis());
                            if (fileInputStream == null) {
                            }
                            fileInputStream.close();
                        } catch (OutOfMemoryError e17) {
                            e = e17;
                            str = "unknown";
                            fileInputStream = fileInputStream4;
                            options2 = imageKey.options;
                            if (options2 != null) {
                            }
                            ImageManagerLog.e(TAG, Log.getStackTraceString(e));
                            ImageManagerEnv.g().reportImageDecodingRes(str, imageKey.url, j3, false, System.currentTimeMillis() - currentTimeMillis2, 2);
                            ImageManagerEnv.g().reportImageDecodingTask(str, imageKey.url, j3, 51000, "decode oom", System.currentTimeMillis());
                            if (fileInputStream == null) {
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            str = "unknown";
                            fileInputStream = fileInputStream4;
                            options = imageKey.options;
                            if (options != null) {
                            }
                            ImageManagerLog.e(TAG, Log.getStackTraceString(th));
                            ImageManagerEnv.g().reportImageDecodingRes(str, imageKey.url, j3, false, System.currentTimeMillis() - currentTimeMillis2, 4);
                            ImageManagerEnv.g().reportImageDecodingTask(str, imageKey.url, j3, 51000, "decode throwable", System.currentTimeMillis());
                            if (fileInputStream == null) {
                            }
                        }
                    }
                    if (!decodeGif(imageKey, imageAttri)) {
                        if (fileInputStream3 == null) {
                            fileInputStream3 = new FileInputStream(imageKey.filePath);
                        } else {
                            reset(fileInputStream3);
                        }
                        options4.inJustDecodeBounds = false;
                        fileInputStream = fileInputStream3;
                        z16 = decodeNormalImage(imageKey, imageAttri, fileInputStream3, options4);
                    } else {
                        fileInputStream = fileInputStream3;
                        z16 = true;
                    }
                    try {
                        String str3 = imageAttri.mimeType;
                        try {
                            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                            g16 = ImageManagerEnv.g();
                            str2 = imageKey.url;
                            if (z16) {
                                i3 = 0;
                            } else {
                                i3 = 1;
                            }
                            str = str3;
                        } catch (Exception e18) {
                            e = e18;
                            str = str3;
                        } catch (OutOfMemoryError e19) {
                            e = e19;
                            str = str3;
                        } catch (Throwable th6) {
                            th = th6;
                            str = str3;
                        }
                        try {
                            g16.reportImageDecodingRes(str3, str2, j3, z16, currentTimeMillis, i3);
                            if (!z16) {
                                ImageManager.getInstance().checkBitmapDecodeFailCount(imageKey);
                            }
                            if (fileInputStream == null) {
                                return;
                            }
                        } catch (Exception e26) {
                            e = e26;
                            options3 = imageKey.options;
                            if (options3 != null) {
                                options3.errCode = ImageManager.getErrorString(imageKey, 110);
                            }
                            ImageManagerLog.e(TAG, Log.getStackTraceString(e));
                            ImageManagerEnv.g().reportImageDecodingRes(str, imageKey.url, j3, false, System.currentTimeMillis() - currentTimeMillis2, 3);
                            ImageManagerEnv.g().reportImageDecodingTask(str, imageKey.url, j3, 51000, "decode exception", System.currentTimeMillis());
                            if (fileInputStream == null) {
                                return;
                            }
                            fileInputStream.close();
                        } catch (OutOfMemoryError e27) {
                            e = e27;
                            options2 = imageKey.options;
                            if (options2 != null) {
                                options2.errCode = ImageManager.getErrorString(imageKey, 111);
                            }
                            ImageManagerLog.e(TAG, Log.getStackTraceString(e));
                            ImageManagerEnv.g().reportImageDecodingRes(str, imageKey.url, j3, false, System.currentTimeMillis() - currentTimeMillis2, 2);
                            ImageManagerEnv.g().reportImageDecodingTask(str, imageKey.url, j3, 51000, "decode oom", System.currentTimeMillis());
                            if (fileInputStream == null) {
                                fileInputStream.close();
                            } else {
                                return;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            options = imageKey.options;
                            if (options != null) {
                                options.errCode = ImageManager.getErrorString(imageKey, 112);
                            }
                            ImageManagerLog.e(TAG, Log.getStackTraceString(th));
                            ImageManagerEnv.g().reportImageDecodingRes(str, imageKey.url, j3, false, System.currentTimeMillis() - currentTimeMillis2, 4);
                            ImageManagerEnv.g().reportImageDecodingTask(str, imageKey.url, j3, 51000, "decode throwable", System.currentTimeMillis());
                            if (fileInputStream == null) {
                                fileInputStream.close();
                            } else {
                                return;
                            }
                        }
                    } catch (Exception e28) {
                        e = e28;
                        str = "unknown";
                    } catch (OutOfMemoryError e29) {
                        e = e29;
                        str = "unknown";
                    } catch (Throwable th8) {
                        th = th8;
                        str = "unknown";
                    }
                } catch (Exception e36) {
                    e = e36;
                    str = "unknown";
                    fileInputStream = fileInputStream3;
                } catch (OutOfMemoryError e37) {
                    e = e37;
                    str = "unknown";
                    fileInputStream = fileInputStream3;
                } catch (Throwable th9) {
                    th = th9;
                    str = "unknown";
                    fileInputStream = fileInputStream3;
                }
                try {
                    fileInputStream.close();
                } catch (IOException unused) {
                }
            } catch (Throwable th10) {
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th10;
            }
        }
    }

    private boolean handlerSharpPDecodeMessage(ImageKey imageKey) {
        int intValue;
        Bitmap decodeSharpP2PNG;
        ImageLoader.Options options;
        int hashCodeEx = imageKey.hashCodeEx();
        SharpPDecoderHelper sharpPDecoderHelper = new SharpPDecoderHelper(imageKey.filePath);
        int parseHeader = sharpPDecoderHelper.parseHeader();
        if (parseHeader != 0) {
            ImageManagerLog.w(TAG, "parseHeader error,status=" + parseHeader + "," + imageKey.url + ",hashCode=" + imageKey.hashCodeEx() + ",filePath=" + imageKey.filePath + ", try again");
            return false;
        }
        ImageAttri imageAttri = mImagePath2AttriMap.get(imageKey.filePath);
        SharpPDecoderWrapper.SharpPFeatureWrapper featureInfo = sharpPDecoderHelper.getFeatureInfo();
        String str = "unknown";
        if (imageAttri == null || imageAttri.mimeType.equals("unknown")) {
            imageAttri = new ImageAttri();
            imageAttri.srcHeight = featureInfo.getHeight();
            imageAttri.srcWidth = featureInfo.getWidth();
            String mimeType = sharpPDecoderHelper.getMimeType();
            if (mimeType != null) {
                str = mimeType;
            }
            imageAttri.mimeType = str;
            mImagePath2AttriMap.put(imageKey.filePath, imageAttri);
        }
        ImageAttri imageAttri2 = imageAttri;
        Integer num = mImageKey2SampleSizeMap.get(Integer.valueOf(hashCodeEx));
        int width = featureInfo.getWidth();
        int height = featureInfo.getHeight();
        if (imageKey.options != null && !TextUtils.isEmpty(imageKey.filePath)) {
            ImageLoader.Options options2 = imageKey.options;
            if (options2.isNeedPieceLoad) {
                options2.isNeedPieceLoad = RegionImageUtil.isValidRegionImageFormat(imageKey.filePath);
                ImageManagerLog.i(TAG, "handlerSharpPDecodeMessage Region decode file isValidRegionImageFormat with isNeedPieceLoad = " + imageKey.options.isNeedPieceLoad);
            }
        }
        if (num == null) {
            intValue = ImageOptionSampleSize.computeSampleSize(imageKey.options, width, height);
            mImageKey2SampleSizeMap.put(Integer.valueOf(hashCodeEx), Integer.valueOf(intValue));
        } else {
            intValue = num.intValue();
        }
        int i3 = intValue;
        if (QZoneImageDecodeUtils.isGif(imageAttri2.mimeType) && (options = imageKey.options) != null && options.needShowGifAnimation) {
            ImageManagerLog.d(TAG, "handlerSharpPDecodeMessage -- url: " + imageKey.url + " --is sharp gif\uff1a" + imageAttri2.mimeType);
            NewGifImage newGifImage = new NewGifImage(imageKey.filePath, width, height, (float) i3, imageKey.url);
            Drawable drawable = newGifImage.getDrawable();
            ImageManagerEnv.g().reportImageDecodingResMTA("gif_collect", "sharp/gif");
            if (drawable != null) {
                ImageProcessor imageProcessor = imageKey.options.extraProcessor;
                if (imageProcessor != null && (imageProcessor instanceof NewGifDrawableSpecifiedRegionProcessor)) {
                    drawable = imageProcessor.doProcess(drawable);
                }
                Drawable drawable2 = drawable;
                ImageManager.getInstance().putDrawableInMemoryCache(imageKey, hashCodeEx, newGifImage, drawable2, imageKey.options);
                setResult(8, drawable2, null, imageKey.urlKey, Integer.valueOf(hashCodeEx), newGifImage, drawable2);
                ImageTaskTracer.removeImageDecodeThreadDecodingRecord(imageKey.hashCodeEx());
                ImageTracer.endDecode(imageKey.url);
                return true;
            }
            ImageLoader.Options options3 = imageKey.options;
            if (options3 != null) {
                options3.errCode = ImageManager.getErrorString(imageKey, 103);
            }
            return false;
        }
        Bitmap.Config bitmapConfig = getBitmapConfig(imageKey, i3, width, height, imageAttri2.mimeType);
        int i16 = width / i3;
        int i17 = height / i3;
        imageKey.inSampleSize = i3;
        imageKey.orgWidth = width;
        imageKey.orgHeight = height;
        if (SharpPUtils.isJpg(imageAttri2.mimeType)) {
            decodeSharpP2PNG = sharpPDecoderHelper.decodeSharpP2JPG(i16, i17, bitmapConfig);
        } else {
            decodeSharpP2PNG = sharpPDecoderHelper.decodeSharpP2PNG(i16, i17, Bitmap.Config.ARGB_8888);
        }
        if (decodeSharpP2PNG == null) {
            ImageLoader.Options options4 = imageKey.options;
            if (options4 != null) {
                options4.errCode = ImageManager.getErrorString(imageKey, 104);
            }
            return false;
        }
        processBitmap(BitmapReference.getBitmapReference(decodeSharpP2PNG), imageKey, hashCodeEx, true, imageAttri2.mimeType);
        return true;
    }

    public static DecodeImageTask obtain(ImageTask imageTask) {
        if (ImageTask.needRecycle) {
            synchronized (sPoolSync) {
                DecodeImageTask decodeImageTask = sPool;
                if (decodeImageTask != null) {
                    sPool = decodeImageTask.next;
                    decodeImageTask.next = null;
                    mObjectPoolSize--;
                    decodeImageTask.setImageTask(imageTask);
                    return decodeImageTask;
                }
            }
        }
        return new DecodeImageTask(imageTask);
    }

    private void processBitmap(BitmapReference bitmapReference, ImageKey imageKey, int i3, boolean z16, String str) {
        ImageLoader.Options options;
        int i16;
        int i17;
        BitmapReference bitmapReference2 = bitmapReference;
        if (bitmapReference2 != null) {
            long nanoTime = System.nanoTime();
            ImageManager.getInstance().updateLruFile(imageKey);
            if (z16) {
                bitmapReference2 = BitmapUtils.processExif(bitmapReference2, imageKey.filePath, str);
            }
            BitmapImage processImage = QZoneImageDecodeUtils.processImage(bitmapReference2, imageKey.options);
            ImageLoader.Options options2 = imageKey.options;
            if (options2 != null) {
                i16 = options2.clipWidth;
                i17 = options2.clipHeight;
            } else {
                i16 = -1;
                i17 = -1;
            }
            if (options2 != null && options2.extraProcessor != null) {
                Drawable bitmapImageDrawable = new BitmapImageDrawable(processImage, i16, i17);
                if (ImageManagerEnv.g().isHighScaleUrl(imageKey.url)) {
                    ImageManagerLog.w(TAG, "super resolution. check high scale not process. url=" + imageKey.url);
                    if (QZoneImageDecodeUtils.needTryScaleDrawable(bitmapImageDrawable)) {
                        bitmapImageDrawable = QZoneImageDecodeUtils.scaleLargeDrawable(bitmapImageDrawable);
                    }
                }
                imageKey.options.extraProcessor.setImageKey(imageKey);
                Drawable doProcess = imageKey.options.extraProcessor.doProcess(bitmapImageDrawable);
                if (doProcess instanceof SpecifiedBitmapDrawable) {
                    BitmapReference bitmapRef = ((SpecifiedBitmapDrawable) doProcess).getBitmapRef();
                    ImageManager.getInstance().putDrawableInMemoryCache(imageKey, i3, new FeedsBitmapImage(bitmapRef), doProcess, imageKey.options);
                    setResult(8, doProcess, bitmapRef, imageKey.urlKey, Integer.valueOf(i3), new FeedsBitmapImage(bitmapRef), doProcess);
                    ImageTaskTracer.removeImageDecodeThreadDecodingRecord(imageKey.hashCodeEx());
                } else if (doProcess instanceof RegionDrawable) {
                    Object bitmapRef2 = ((RegionDrawable) doProcess).getBitmapRef();
                    ImageManager.getInstance().putDrawableInMemoryCache(imageKey, i3, processImage, doProcess, imageKey.options);
                    setResult(8, doProcess, bitmapRef2, imageKey.urlKey, Integer.valueOf(i3), processImage, doProcess);
                    ImageTaskTracer.removeImageDecodeThreadDecodingRecord(imageKey.hashCodeEx());
                } else {
                    Object bitmap = processImage.getBitmap();
                    ImageManager.getInstance().putDrawableInMemoryCache(imageKey, i3, processImage, doProcess, imageKey.options);
                    setResult(8, doProcess, bitmap, imageKey.urlKey, Integer.valueOf(i3), processImage, doProcess);
                    ImageTaskTracer.removeImageDecodeThreadDecodingRecord(imageKey.hashCodeEx());
                }
                ImageTracer.endDecode(imageKey.url);
            } else {
                SpecifiedBitmapDrawable specifiedBitmapDrawable = new SpecifiedBitmapDrawable(processImage.getBitmap());
                ImageTracer.endDecode(imageKey.url);
                ImageManager.getInstance().putDrawableInMemoryCache(imageKey, i3, processImage, specifiedBitmapDrawable, imageKey.options);
                setResult(8, specifiedBitmapDrawable, processImage.getBitmap(), imageKey.urlKey, Integer.valueOf(i3), processImage, specifiedBitmapDrawable);
                ImageTaskTracer.removeImageDecodeThreadDecodingRecord(imageKey.hashCodeEx());
            }
            if (System.nanoTime() - nanoTime > MIN_LOG_DECODE_COST) {
                ImageManagerLog.w(TAG, "processBitmap: " + imageKey.url + " cost too much time");
                return;
            }
            return;
        }
        if (imageKey != null && (options = imageKey.options) != null) {
            options.errCode = ImageManager.getErrorString(imageKey, 105);
        }
        setResult(9, new Object[0]);
        if (imageKey != null) {
            File file = new File(imageKey.filePath);
            ImageManagerEnv.g().reportImageDecodingTask("unknown", imageKey.url, file.length(), 51000, "processBitmap, bm is null", System.currentTimeMillis());
            ImageManagerLog.w(TAG, "processBitmap, bm is null, url=" + imageKey.url + ", file length=" + file.length());
        }
        ImageTaskTracer.addImageDecodeFailedRecord(imageKey.hashCodeEx());
        ImageTaskTracer.removeImageDecodeThreadDecodingRecord(imageKey.hashCodeEx());
    }

    public static void putImagePath2Rotation(String str, int i3) {
        mImagePath2RotationMap.put(str, Integer.valueOf(i3));
    }

    private void recordDecodeFail(ImageKey imageKey, String str, String str2) {
        ImageManagerLog.e(TAG, "decode fail -- url: " + imageKey.url + " --" + str2);
        ImageManager.getInstance().checkBitmapDecodeFailCount(imageKey);
        setResult(9, new Object[0]);
        ImageTaskTracer.addImageDecodeFailedRecord(imageKey.hashCodeEx());
        ImageTaskTracer.removeImageDecodeThreadDecodingRecord(imageKey.hashCodeEx());
        ImageTracer.decodeFail(imageKey.url);
        ImageManagerEnv.g().reportImageDecodingTask(str, imageKey.url, new File(imageKey.filePath).length(), 51000, str2, System.currentTimeMillis());
    }

    private void reset(FileInputStream fileInputStream) throws IOException {
        fileInputStream.getChannel().position(0L);
    }

    @Override // com.tencent.component.media.image.ImageTask
    public /* bridge */ /* synthetic */ void cancel() {
        super.cancel();
    }

    @Override // com.tencent.component.media.image.ImageTask
    public void excuteTask() {
        ImageLoader.Options options;
        Drawable drawbleFromCache = ImageManager.getInstance().getDrawbleFromCache(this.mImageKey);
        if (drawbleFromCache != null) {
            setResult(11, drawbleFromCache);
            return;
        }
        ImageManager.getInstance().imageKeyFilePathCheck(this.mImageKey);
        File file = new File(this.mImageKey.filePath);
        SharpPUtils.deleteSharppCacheFileIfNessary(file, this.mImageKey.url);
        SharpPUtils.checkNotSharppCacheFileIfNessary(file, this.mImageKey.url);
        if (file.exists()) {
            ImageManager.getInstance().traceImageFile(true);
            if (!ImageManagerEnv.g().getCurrentLoadingImgStatus()) {
                ImageTaskManager.getInstance().addWaitToDecodeImageTask(this);
                return;
            } else {
                startDecodeTask();
                return;
            }
        }
        ImageManager.getInstance().traceImageFile(false);
        ImageKey imageKey = this.mImageKey;
        if (imageKey != null && (options = imageKey.options) != null && options.mImageType == 2) {
            ImageTaskBuilder.stampMap.put(imageKey.url, Long.valueOf(System.currentTimeMillis()));
            ImageManagerLog.w(TAG, "no file hashCodeEx:" + this.mImageKey.hashCodeEx() + " isGifPlayWhileDownloading:" + this.mImageKey.options.isGifPlayWhileDownloading);
        }
        ImageTask imageTask = this.mNextTask;
        if (imageTask != null) {
            imageTask.excuteTask();
            return;
        }
        ImageKey imageKey2 = this.mImageKey;
        ImageLoader.Options options2 = imageKey2.options;
        if (options2 != null) {
            options2.errCode = ImageManager.getErrorString(imageKey2, 100);
        }
        setResult(9, new Object[0]);
    }

    @Override // com.tencent.component.media.image.ImageTask
    public /* bridge */ /* synthetic */ ImageKey getImageKey() {
        return super.getImageKey();
    }

    @Override // com.tencent.component.media.image.ImageTask
    public /* bridge */ /* synthetic */ ImageTask getNextTask() {
        return super.getNextTask();
    }

    @Override // com.tencent.component.media.image.ImageTask
    public /* bridge */ /* synthetic */ ImageTask getPreviousTask() {
        return super.getPreviousTask();
    }

    @Override // com.tencent.component.media.image.ImageTask
    public /* bridge */ /* synthetic */ boolean isCanceled() {
        return super.isCanceled();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.component.media.image.ImageTask
    public void onResult(int i3, Object... objArr) {
        Object obj;
        if (i3 != 0 && i3 != 1) {
            if (i3 != 2 && i3 != 12) {
                setResult(i3, objArr);
                return;
            }
            ImageManager.getInstance().imageKeyFilePathCheck(this.mImageKey);
            if (QZoneImageDecodeUtils.isAvatarUrl(this.mImageKey.url) && (obj = objArr[1]) != null) {
                this.mImageKey.filePath = obj.toString();
            }
            File file = new File(this.mImageKey.filePath);
            if (file.exists()) {
                if (!ImageManagerEnv.g().getCurrentLoadingImgStatus()) {
                    ImageTaskManager.getInstance().addWaitToDecodeImageTask(this);
                    return;
                } else {
                    startDecodeTask();
                    return;
                }
            }
            ImageKey imageKey = this.mImageKey;
            ImageLoader.Options options = imageKey.options;
            if (options != null) {
                options.errCode = ImageManager.getErrorString(imageKey, 102);
            }
            setResult(9, new Object[0]);
            if (this.mImageKey != null) {
                ImageManagerEnv.g().reportImageDecodingTask("unknown", this.mImageKey.url, file.length(), 51000, "download success, file does not exist", System.currentTimeMillis());
                ImageManagerLog.w(TAG, "onResult, download success, file does not exist!, url=" + this.mImageKey.url + ", file length=" + file.length());
                return;
            }
            return;
        }
        setResult(9, new Object[0]);
    }

    @Override // com.tencent.component.media.image.ImageTask
    public void recycle() {
        if (!ImageTask.needRecycle) {
            return;
        }
        reset();
        synchronized (sPoolSync) {
            int i3 = mObjectPoolSize;
            if (i3 < 50) {
                this.next = sPool;
                sPool = this;
                mObjectPoolSize = i3 + 1;
            }
        }
    }

    public void startDecodeTask() {
        boolean z16;
        ImageLoader.Options options;
        ImageKey imageKey = this.mImageKey;
        if (imageKey != null) {
            ImageTaskTracer.addImageDecodeThreadPendingRecord(imageKey.hashCodeEx());
        }
        DecodeTask decodeTask = new DecodeTask(this.mImageKey);
        ImageKey imageKey2 = this.mImageKey;
        if (imageKey2 != null && (options = imageKey2.options) != null && options.priority) {
            z16 = true;
        } else {
            z16 = false;
        }
        ImageManager.post(decodeTask, z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DecodeImageTask(ImageKey imageKey) {
        super(imageKey);
        this.next = null;
    }

    public static DecodeImageTask obtain(ImageKey imageKey) {
        if (ImageTask.needRecycle) {
            synchronized (sPoolSync) {
                DecodeImageTask decodeImageTask = sPool;
                if (decodeImageTask != null) {
                    sPool = decodeImageTask.next;
                    decodeImageTask.next = null;
                    mObjectPoolSize--;
                    decodeImageTask.setImageKey(imageKey);
                    return decodeImageTask;
                }
            }
        }
        return new DecodeImageTask(imageKey);
    }
}
