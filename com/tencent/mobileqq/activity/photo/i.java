package com.tencent.mobileqq.activity.photo;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes10.dex */
public class i implements BitmapDecoder {
    static IPatchRedirector $redirector_;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0131 A[RETURN] */
    @Override // com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder
    @TargetApi(10)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap getBitmap(URL url) {
        Bitmap bitmap;
        float f16;
        int i3;
        BufferedInputStream bufferedInputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
        }
        LocalMediaInfo parseUrl = LocalMediaInfo.parseUrl(url);
        if (parseUrl != null) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                SafeBitmapFactory.decodeFile(parseUrl.path, options);
                int i16 = options.outWidth;
                int i17 = options.outHeight;
                if (i16 > i17) {
                    f16 = i16 / i17;
                    i3 = i17;
                } else {
                    f16 = i17 / i16;
                    i3 = i16;
                }
                if (f16 <= 3.0f) {
                    options.inSampleSize = ThumbDecoder.calSampleSize(i16, i17, parseUrl.thumbWidth);
                    options.inJustDecodeBounds = false;
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                    bitmap = BaseImageUtil.decodeFileWithBufferedStream(parseUrl.path, options);
                } else {
                    Rect rect = new Rect(0, 0, i3, i3);
                    options.inSampleSize = ThumbDecoder.calSampleSize(i3, i3, parseUrl.thumbWidth);
                    options.inJustDecodeBounds = false;
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                    try {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(parseUrl.path));
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedInputStream = null;
                    }
                    try {
                        BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance((InputStream) bufferedInputStream, true);
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused) {
                        }
                        if (newInstance != null) {
                            bitmap = newInstance.decodeRegion(rect, options);
                            try {
                                newInstance.recycle();
                            } catch (Exception e16) {
                                e = e16;
                                if (QLog.isColorLevel()) {
                                    QLog.e("RegionalThumbDecoder", 2, "can't getBitmap", e);
                                }
                                if (bitmap == null) {
                                    return null;
                                }
                                return bitmap;
                            } catch (OutOfMemoryError e17) {
                                e = e17;
                                if (QLog.isColorLevel()) {
                                    QLog.e("RegionalThumbDecoder", 2, "Can't getBitmap", e);
                                }
                                if (bitmap != null) {
                                    return bitmap;
                                }
                            }
                        } else {
                            bitmap = null;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                }
                if (bitmap == null) {
                    if (QLog.isColorLevel()) {
                        QLog.e("RegionalThumbDecoder", 2, "decode bitmap return null,maybe oom");
                    }
                    return bitmap;
                }
                int exifRotation = URLDrawableHelper.getExifRotation(parseUrl.path);
                if (exifRotation == 0 && bitmap.getWidth() == parseUrl.thumbWidth && bitmap.getHeight() == parseUrl.thumbWidth) {
                    return bitmap;
                }
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                Rect rect2 = new Rect();
                int i18 = parseUrl.thumbWidth;
                RectF rectF = new RectF(0.0f, 0.0f, i18, i18);
                if (width > height) {
                    int i19 = (width - height) / 2;
                    rect2.set(i19, 0, i19 + height, height + 0);
                } else {
                    int i26 = (height - width) / 2;
                    rect2.set(0, i26, width + 0, width + i26);
                }
                int i27 = parseUrl.thumbWidth;
                Bitmap createBitmap = Bitmap.createBitmap(i27, i27, Bitmap.Config.RGB_565);
                Canvas canvas = new Canvas(createBitmap);
                if (exifRotation != 0) {
                    int i28 = parseUrl.thumbWidth;
                    canvas.rotate(exifRotation, i28 / 2.0f, i28 / 2.0f);
                }
                canvas.drawBitmap(bitmap, rect2, rectF, new Paint(6));
                if (createBitmap != null) {
                    bitmap.recycle();
                    return createBitmap;
                }
            } catch (Exception e18) {
                e = e18;
                bitmap = null;
            } catch (OutOfMemoryError e19) {
                e = e19;
                bitmap = null;
            }
        }
        return null;
    }
}
