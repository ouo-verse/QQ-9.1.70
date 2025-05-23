package com.tencent.mobileqq.activity.photo;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.libra.request.Option;
import com.tencent.libra.util.LibraImageUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b implements BitmapDecoder {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Bitmap a(Bitmap bitmap, int i3, int i16) {
        Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.RGB_565);
        new Canvas(createBitmap).drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new RectF(0.0f, 0.0f, i3, i16), new Paint(6));
        return createBitmap;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0104 A[Catch: Exception -> 0x0130, OutOfMemoryError -> 0x0132, TryCatch #4 {Exception -> 0x0130, OutOfMemoryError -> 0x0132, blocks: (B:14:0x002f, B:16:0x0041, B:18:0x0048, B:20:0x0072, B:21:0x00f4, B:23:0x0104, B:25:0x012b, B:32:0x007a, B:34:0x0082, B:41:0x0090, B:43:0x0098, B:44:0x009c, B:46:0x00a3, B:48:0x00cd, B:50:0x00d3, B:52:0x00db, B:58:0x00e8, B:60:0x00f0), top: B:13:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder
    @TargetApi(10)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap getBitmap(URL url) {
        Bitmap bitmap;
        Bitmap a16;
        int rotateDegree;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
        }
        LocalMediaInfo parseUrl = LocalMediaInfo.parseUrl(url);
        if (parseUrl != null) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                bitmap = BaseImageUtil.decodeFileWithBufferedStream(parseUrl.path, options);
            } catch (Exception e16) {
                e = e16;
                bitmap = null;
            } catch (OutOfMemoryError e17) {
                e = e17;
                bitmap = null;
            }
            try {
                int i3 = parseUrl.thumbHeight;
                int i16 = parseUrl.thumbWidth;
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (height > width) {
                    if (height / width > 3.0f) {
                        Bitmap createBitmap = Bitmap.createBitmap(i16, i3, Bitmap.Config.RGB_565);
                        int i17 = width * 3;
                        new Canvas(createBitmap).drawBitmap(bitmap, new Rect(0, (height - i17) / 2, width, (height + i17) / 2), new RectF(0.0f, 0.0f, i16, i3), new Paint(6));
                        if (createBitmap != null) {
                            bitmap.recycle();
                            bitmap = createBitmap;
                        }
                    } else if (height > i3) {
                        a16 = a(bitmap, (width * i3) / height, i3);
                        if (a16 != null) {
                            bitmap.recycle();
                            bitmap = a16;
                        }
                    } else if ((height >= i3 || height <= i16 || width >= i3 || width <= i16) && (a16 = a(bitmap, i16, (height * i16) / width)) != null) {
                        bitmap.recycle();
                        bitmap = a16;
                    }
                    rotateDegree = LibraImageUtil.getRotateDegree(Option.obtain().setLocalPath(parseUrl.path));
                    if (rotateDegree == 0) {
                        Matrix matrix = new Matrix();
                        matrix.setRotate(rotateDegree, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
                        Bitmap createBitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                        if (createBitmap2 != null) {
                            bitmap.recycle();
                            return createBitmap2;
                        }
                        return bitmap;
                    }
                    return bitmap;
                }
                if (width / height > 3.0f) {
                    a16 = Bitmap.createBitmap(i3, i16, Bitmap.Config.RGB_565);
                    int i18 = height * 3;
                    new Canvas(a16).drawBitmap(bitmap, new Rect((width - i18) / 2, 0, (width + i18) / 2, height), new RectF(0.0f, 0.0f, i3, i16), new Paint(6));
                    if (a16 != null) {
                        bitmap.recycle();
                        bitmap = a16;
                    }
                    rotateDegree = LibraImageUtil.getRotateDegree(Option.obtain().setLocalPath(parseUrl.path));
                    if (rotateDegree == 0) {
                    }
                } else if (width > i3) {
                    a16 = a(bitmap, i3, (height * i3) / width);
                    if (a16 != null) {
                        bitmap.recycle();
                        bitmap = a16;
                    }
                    rotateDegree = LibraImageUtil.getRotateDegree(Option.obtain().setLocalPath(parseUrl.path));
                    if (rotateDegree == 0) {
                    }
                } else {
                    if ((width >= i3 || width <= i16 || height >= i3 || height <= i16) && (a16 = a(bitmap, (width * i16) / height, i16)) != null) {
                        bitmap.recycle();
                        bitmap = a16;
                    }
                    rotateDegree = LibraImageUtil.getRotateDegree(Option.obtain().setLocalPath(parseUrl.path));
                    if (rotateDegree == 0) {
                    }
                }
            } catch (Exception e18) {
                e = e18;
                if (QLog.isColorLevel()) {
                    QLog.e("RegionalThumbDecoder", 2, "can't getBitmap", e);
                }
                if (bitmap != null) {
                    return bitmap;
                }
                return null;
            } catch (OutOfMemoryError e19) {
                e = e19;
                if (QLog.isColorLevel()) {
                    QLog.e("RegionalThumbDecoder", 2, "Can't getBitmap", e);
                }
                if (bitmap != null) {
                    return bitmap;
                }
                return null;
            }
        } else {
            return null;
        }
    }
}
