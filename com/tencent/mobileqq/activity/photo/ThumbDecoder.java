package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ThumbDecoder extends BaseThumbDecoder implements BitmapDecoder {
    static IPatchRedirector $redirector_ = null;
    static final String TAG = "QQAlbum";
    private float mDensity;
    private LocalMediaInfo mInfo;

    public ThumbDecoder(Context context, LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) localMediaInfo);
        } else {
            this.mDensity = context.getResources().getDisplayMetrics().density;
            this.mInfo = localMediaInfo;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int calSampleSize(int i3, int i16, int i17) {
        int i18;
        if (i3 > i16) {
            i18 = i16;
        } else {
            i18 = i3;
        }
        int i19 = 1;
        while (i18 > i17 * 2) {
            i19 *= 2;
            i18 /= 2;
        }
        return checkSquareLarge(i3, i16, i17, i19);
    }

    private static int checkSquareLarge(int i3, int i16, int i17, int i18) {
        int i19 = i17 * i17 * i18 * i18;
        while (true) {
            i19 *= 4;
            if (i3 * i16 > i19) {
                i18 *= 2;
            } else {
                return i18;
            }
        }
    }

    @Override // com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder
    public Bitmap getBitmap(URL url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
        }
        LocalMediaInfo localMediaInfo = this.mInfo;
        if (localMediaInfo != null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            SafeBitmapFactory.decodeFile(localMediaInfo.path, options);
            options.inSampleSize = calSampleSize(options.outWidth, options.outHeight, localMediaInfo.thumbWidth);
            options.inJustDecodeBounds = false;
            Bitmap realDecodeBitmap = BaseThumbDecoder.realDecodeBitmap(localMediaInfo, options, "QQAlbum");
            if (realDecodeBitmap == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("ThumbDecoder", 2, "decode bitmap return null,maybe oom");
                }
                return realDecodeBitmap;
            }
            int exifRotation = URLDrawableHelper.getExifRotation(localMediaInfo.path);
            if (BaseThumbDecoder.checkBitmapValid(localMediaInfo, realDecodeBitmap, exifRotation)) {
                return realDecodeBitmap;
            }
            int width = realDecodeBitmap.getWidth();
            int height = realDecodeBitmap.getHeight();
            Rect rect = new Rect();
            int i3 = localMediaInfo.thumbWidth;
            RectF rectF = new RectF(0.0f, 0.0f, i3, i3);
            if (width > height) {
                int i16 = (width - height) / 2;
                rect.set(i16, 0, i16 + height, height + 0);
            } else {
                int i17 = (height - width) / 2;
                rect.set(0, i17, width + 0, width + i17);
            }
            int i18 = localMediaInfo.thumbWidth;
            Bitmap createBitmap = Bitmap.createBitmap(i18, i18, Bitmap.Config.RGB_565);
            if (createBitmap != null) {
                new Canvas(createBitmap).drawBitmap(realDecodeBitmap, rect, rectF, new Paint(6));
                realDecodeBitmap.recycle();
                if (exifRotation != 0) {
                    return FlowThumbDecoder.rotate(createBitmap, exifRotation);
                }
                return createBitmap;
            }
            return null;
        }
        return null;
    }
}
