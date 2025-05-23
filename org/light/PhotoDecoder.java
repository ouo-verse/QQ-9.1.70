package org.light;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import android.os.Build;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.light.device.LightDeviceProperty;
import org.light.utils.LightLogUtil;

/* loaded from: classes29.dex */
public class PhotoDecoder {
    private static final String ASSET = "asset://";
    private static final int AlphaType_Opaque = 1;
    private static final int AlphaType_Premul = 2;
    private static final int AlphaType_Unpremul = 3;
    private static final int ColorSpace_DISPLAY_P3 = 2;
    private static final int ColorSpace_SRGB = 1;
    private static final int ColorSpace_UNKNOWN = 0;
    private static final int ColorType_ARGB_4444 = 3;
    private static final int ColorType_Alpha_8 = 1;
    private static final int ColorType_BGRA_8888 = 5;
    private static final int ColorType_Gray_8 = 7;
    private static final int ColorType_Index_8 = 6;
    private static final int ColorType_RGBA_8888 = 4;
    private static final int ColorType_RGBA_F16 = 8;
    private static final int ColorType_RGB_565 = 2;
    private static final String TAG = "PhotoDecoder";
    boolean isNoConstrictFlag;
    private ColorSpace photoColorSpace;
    private int photoHeight;
    private String photoPath;
    private int photoWidth;
    private OutputBitmap successBitmap = null;

    /* loaded from: classes29.dex */
    private static class OutputBitmap {
        Bitmap bitmap;
        int height;
        boolean isPremultiplied;
        byte[] pixels;
        int rowBytes;
        int width;

        OutputBitmap() {
        }
    }

    PhotoDecoder(String str) {
        ColorSpace colorSpace;
        this.photoWidth = 0;
        this.photoHeight = 0;
        this.photoPath = str;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(this.photoPath, options);
            this.photoWidth = options.outWidth;
            this.photoHeight = options.outHeight;
            if (Build.VERSION.SDK_INT >= 26) {
                colorSpace = options.outColorSpace;
                this.photoColorSpace = colorSpace;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private static PhotoDecoder Create(String str) {
        LightLogUtil.i(TAG, "Create:" + str);
        PhotoDecoder photoDecoder = new PhotoDecoder(str);
        photoDecoder.isNoConstrictFlag = false;
        return photoDecoder;
    }

    private int colorSpace() {
        ColorSpace colorSpace;
        ColorSpace.Named named;
        ColorSpace colorSpace2;
        boolean equals;
        ColorSpace.Named named2;
        ColorSpace colorSpace3;
        boolean equals2;
        if (Build.VERSION.SDK_INT >= 26 && (colorSpace = this.photoColorSpace) != null) {
            named = ColorSpace.Named.SRGB;
            colorSpace2 = ColorSpace.get(named);
            equals = colorSpace.equals(colorSpace2);
            if (equals) {
                return 1;
            }
            ColorSpace colorSpace4 = this.photoColorSpace;
            named2 = ColorSpace.Named.DISPLAY_P3;
            colorSpace3 = ColorSpace.get(named2);
            equals2 = colorSpace4.equals(colorSpace3);
            if (equals2) {
                return 2;
            }
            return 0;
        }
        return 0;
    }

    private Bitmap convert(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(0);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    private OutputBitmap decode(boolean z16) {
        Bitmap decodeStream;
        ExifInterface exifInterface;
        ByteBuffer byteBuffer;
        Bitmap.Config config;
        ColorSpace colorSpace;
        ColorSpace.Named named;
        ColorSpace colorSpace2;
        boolean equals;
        ColorSpace.Named named2;
        ColorSpace colorSpace3;
        LightLogUtil.i(TAG, "decode :" + this.photoPath + ", nativeReadPixel:" + z16);
        OutputBitmap outputBitmap = this.successBitmap;
        if (outputBitmap != null) {
            return outputBitmap;
        }
        if (TextUtils.isEmpty(this.photoPath)) {
            return null;
        }
        if (this.photoPath.startsWith(ASSET)) {
            try {
                InputStream open = LibraryLoadUtils.getAppContext().getAssets().open(this.photoPath.substring(8));
                decodeStream = BitmapFactory.decodeStream(open);
                if (Build.VERSION.SDK_INT >= 24) {
                    try {
                        exifInterface = new ExifInterface(open);
                    } catch (IOException e16) {
                        LightLogUtil.e(TAG, this.photoPath + " read exif failed:" + e16);
                    }
                }
                exifInterface = null;
            } catch (Exception unused) {
                return null;
            }
        } else {
            BitmapFactory.Options options = new BitmapFactory.Options();
            if (Build.VERSION.SDK_INT >= 26 && (colorSpace = this.photoColorSpace) != null) {
                named = ColorSpace.Named.DISPLAY_P3;
                colorSpace2 = ColorSpace.get(named);
                equals = colorSpace.equals(colorSpace2);
                if (equals) {
                    named2 = ColorSpace.Named.SRGB;
                    colorSpace3 = ColorSpace.get(named2);
                    options.inPreferredColorSpace = colorSpace3;
                }
            }
            decodeStream = BitmapFactory.decodeFile(this.photoPath, options);
            try {
                exifInterface = new ExifInterface(this.photoPath);
            } catch (IOException e17) {
                LightLogUtil.e(TAG, this.photoPath + " read exif failed:" + e17);
            }
        }
        if (decodeStream == null) {
            return null;
        }
        if (exifInterface != null) {
            decodeStream = rotateBitmapIfRequired(decodeStream, exifInterface.getAttributeInt("Orientation", 1));
        }
        if (!this.isNoConstrictFlag && LightDeviceProperty.VERSION.SDK_INT >= 26) {
            Bitmap.Config config2 = decodeStream.getConfig();
            config = Bitmap.Config.HARDWARE;
            if (config2 == config) {
                return null;
            }
        }
        LightLogUtil.i(TAG, "decode done:" + this.photoPath + ", isPremultiplied:" + decodeStream.isPremultiplied());
        if (!z16 && !this.isNoConstrictFlag) {
            byteBuffer = ByteBuffer.allocate(decodeStream.getHeight() * decodeStream.getRowBytes());
            decodeStream.copyPixelsToBuffer(byteBuffer);
        } else {
            byteBuffer = null;
        }
        Bitmap.Config config3 = decodeStream.getConfig();
        if (config3 == null) {
            config3 = Bitmap.Config.ARGB_8888;
        }
        if (config3 != Bitmap.Config.ARGB_8888) {
            LightLogUtil.i(TAG, this.photoPath + " need to convert");
            decodeStream = convert(decodeStream);
            if (decodeStream == null) {
                return null;
            }
        }
        OutputBitmap outputBitmap2 = new OutputBitmap();
        this.successBitmap = outputBitmap2;
        if (!z16) {
            if (!this.isNoConstrictFlag && byteBuffer != null) {
                outputBitmap2.pixels = byteBuffer.array();
            }
        } else {
            outputBitmap2.bitmap = decodeStream;
        }
        this.successBitmap.width = decodeStream.getWidth();
        this.successBitmap.height = decodeStream.getHeight();
        this.successBitmap.rowBytes = decodeStream.getRowBytes();
        this.successBitmap.isPremultiplied = decodeStream.isPremultiplied();
        return this.successBitmap;
    }

    private int height() {
        return this.photoHeight;
    }

    private void onRelease() {
        this.successBitmap = null;
    }

    private static Bitmap rotateBitmapIfRequired(Bitmap bitmap, int i3) {
        if (i3 != 3) {
            if (i3 != 6) {
                if (i3 != 8) {
                    return bitmap;
                }
                return rotateImage(bitmap, 270);
            }
            return rotateImage(bitmap, 90);
        }
        return rotateImage(bitmap, 180);
    }

    private static Bitmap rotateImage(Bitmap bitmap, int i3) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i3);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private int width() {
        return this.photoWidth;
    }

    public void setNoConstrictFlag(boolean z16) {
        LightLogUtil.i(TAG, "setNoConstrictFlag:" + z16);
        this.isNoConstrictFlag = z16;
    }
}
