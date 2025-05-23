package com.nostra13.universalimageloader.core.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.utils.ImageSizeUtils;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.nostra13.universalimageloader.utils.L;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes2.dex */
public class BaseImageDecoder implements ImageDecoder {
    protected static final String ERROR_CANT_DECODE_IMAGE = "Image can't be decoded [%s]";
    protected static final String ERROR_NO_IMAGE_STREAM = "No stream for image [%s]";
    protected static final String LOG_FLIP_IMAGE = "Flip image horizontally [%s]";
    protected static final String LOG_ROTATE_IMAGE = "Rotate image on %1$d\u00b0 [%2$s]";
    protected static final String LOG_SCALE_IMAGE = "Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]";
    protected static final String LOG_SUBSAMPLE_IMAGE = "Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]";
    protected final boolean loggingEnabled;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class ImageFileInfo {
        public final ExifInfo exif;
        public final ImageSize imageSize;

        protected ImageFileInfo(ImageSize imageSize, ExifInfo exifInfo) {
            this.imageSize = imageSize;
            this.exif = exifInfo;
        }
    }

    public BaseImageDecoder(boolean z16) {
        this.loggingEnabled = z16;
    }

    private boolean canDefineExifParams(String str, String str2) {
        if ("image/jpeg".equalsIgnoreCase(str2) && ImageDownloader.Scheme.ofUri(str) == ImageDownloader.Scheme.FILE) {
            return true;
        }
        return false;
    }

    protected Bitmap considerExactScaleAndOrientatiton(Bitmap bitmap, ImageDecodingInfo imageDecodingInfo, int i3, boolean z16) {
        boolean z17;
        Matrix matrix = new Matrix();
        ImageScaleType imageScaleType = imageDecodingInfo.getImageScaleType();
        if (imageScaleType == ImageScaleType.EXACTLY || imageScaleType == ImageScaleType.EXACTLY_STRETCHED) {
            ImageSize imageSize = new ImageSize(bitmap.getWidth(), bitmap.getHeight(), i3);
            ImageSize targetSize = imageDecodingInfo.getTargetSize();
            ViewScaleType viewScaleType = imageDecodingInfo.getViewScaleType();
            if (imageScaleType == ImageScaleType.EXACTLY_STRETCHED) {
                z17 = true;
            } else {
                z17 = false;
            }
            float computeImageScale = ImageSizeUtils.computeImageScale(imageSize, targetSize, viewScaleType, z17);
            if (Float.compare(computeImageScale, 1.0f) != 0) {
                matrix.setScale(computeImageScale, computeImageScale);
                if (this.loggingEnabled) {
                    L.d(LOG_SCALE_IMAGE, imageSize, imageSize.scale(computeImageScale), Float.valueOf(computeImageScale), imageDecodingInfo.getImageKey());
                }
            }
        }
        if (z16) {
            matrix.postScale(-1.0f, 1.0f);
            if (this.loggingEnabled) {
                L.d(LOG_FLIP_IMAGE, imageDecodingInfo.getImageKey());
            }
        }
        if (i3 != 0) {
            matrix.postRotate(i3);
            if (this.loggingEnabled) {
                L.d(LOG_ROTATE_IMAGE, Integer.valueOf(i3), imageDecodingInfo.getImageKey());
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    @Override // com.nostra13.universalimageloader.core.decode.ImageDecoder
    public Bitmap decode(ImageDecodingInfo imageDecodingInfo) throws IOException {
        InputStream imageStream = getImageStream(imageDecodingInfo);
        if (imageStream == null) {
            L.e(ERROR_NO_IMAGE_STREAM, imageDecodingInfo.getImageKey());
            return null;
        }
        try {
            ImageFileInfo defineImageSizeAndRotation = defineImageSizeAndRotation(imageStream, imageDecodingInfo);
            imageStream = resetStream(imageStream, imageDecodingInfo);
            Bitmap decodeStream = BitmapFactory.decodeStream(imageStream, null, prepareDecodingOptions(defineImageSizeAndRotation.imageSize, imageDecodingInfo));
            if (decodeStream == null) {
                L.e(ERROR_CANT_DECODE_IMAGE, imageDecodingInfo.getImageKey());
                return decodeStream;
            }
            ExifInfo exifInfo = defineImageSizeAndRotation.exif;
            return considerExactScaleAndOrientatiton(decodeStream, imageDecodingInfo, exifInfo.rotation, exifInfo.flipHorizontal);
        } finally {
            IoUtils.closeSilently(imageStream);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected ExifInfo defineExifOrientation(String str) {
        int i3;
        boolean z16 = true;
        int i16 = 0;
        try {
        } catch (IOException unused) {
            L.w("Can't read EXIF tags from file [%s]", str);
        }
        switch (new ExifInterface(ImageDownloader.Scheme.FILE.crop(str)).getAttributeInt("Orientation", 1)) {
            case 1:
            default:
                z16 = false;
                break;
            case 2:
                break;
            case 3:
                z16 = false;
                i3 = 180;
                i16 = i3;
                break;
            case 4:
                i3 = 180;
                i16 = i3;
                break;
            case 5:
                i3 = 270;
                i16 = i3;
                break;
            case 6:
                z16 = false;
                i3 = 90;
                i16 = i3;
                break;
            case 7:
                i3 = 90;
                i16 = i3;
                break;
            case 8:
                z16 = false;
                i3 = 270;
                i16 = i3;
                break;
        }
        return new ExifInfo(i16, z16);
    }

    protected ImageFileInfo defineImageSizeAndRotation(InputStream inputStream, ImageDecodingInfo imageDecodingInfo) throws IOException {
        ExifInfo exifInfo;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        String imageUri = imageDecodingInfo.getImageUri();
        if (imageDecodingInfo.shouldConsiderExifParams() && canDefineExifParams(imageUri, options.outMimeType)) {
            exifInfo = defineExifOrientation(imageUri);
        } else {
            exifInfo = new ExifInfo();
        }
        return new ImageFileInfo(new ImageSize(options.outWidth, options.outHeight, exifInfo.rotation), exifInfo);
    }

    protected InputStream getImageStream(ImageDecodingInfo imageDecodingInfo) throws IOException {
        return imageDecodingInfo.getDownloader().getStream(imageDecodingInfo.getImageUri(), imageDecodingInfo.getExtraForDownloader());
    }

    protected BitmapFactory.Options prepareDecodingOptions(ImageSize imageSize, ImageDecodingInfo imageDecodingInfo) {
        boolean z16;
        int computeImageSampleSize;
        ImageScaleType imageScaleType = imageDecodingInfo.getImageScaleType();
        if (imageScaleType == ImageScaleType.NONE) {
            computeImageSampleSize = 1;
        } else if (imageScaleType == ImageScaleType.NONE_SAFE) {
            computeImageSampleSize = ImageSizeUtils.computeMinImageSampleSize(imageSize);
        } else {
            ImageSize targetSize = imageDecodingInfo.getTargetSize();
            if (imageScaleType == ImageScaleType.IN_SAMPLE_POWER_OF_2) {
                z16 = true;
            } else {
                z16 = false;
            }
            computeImageSampleSize = ImageSizeUtils.computeImageSampleSize(imageSize, targetSize, imageDecodingInfo.getViewScaleType(), z16);
        }
        if (computeImageSampleSize > 1 && this.loggingEnabled) {
            L.d(LOG_SUBSAMPLE_IMAGE, imageSize, imageSize.scaleDown(computeImageSampleSize), Integer.valueOf(computeImageSampleSize), imageDecodingInfo.getImageKey());
        }
        BitmapFactory.Options decodingOptions = imageDecodingInfo.getDecodingOptions();
        decodingOptions.inSampleSize = computeImageSampleSize;
        return decodingOptions;
    }

    protected InputStream resetStream(InputStream inputStream, ImageDecodingInfo imageDecodingInfo) throws IOException {
        if (inputStream.markSupported()) {
            try {
                inputStream.reset();
                return inputStream;
            } catch (IOException unused) {
            }
        }
        IoUtils.closeSilently(inputStream);
        return getImageStream(imageDecodingInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class ExifInfo {
        public final boolean flipHorizontal;
        public final int rotation;

        protected ExifInfo() {
            this.rotation = 0;
            this.flipHorizontal = false;
        }

        protected ExifInfo(int i3, boolean z16) {
            this.rotation = i3;
            this.flipHorizontal = z16;
        }
    }
}
