package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.image.DownloadParams;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/utils/c;", "Lcom/tencent/image/DownloadParams$DecodeHandler;", "Lcom/tencent/image/DownloadParams;", "params", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, TencentLocation.RUN_MODE, "", "a", "I", "getRadius", "()I", "radius", "<init>", "(I)V", "b", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class c implements DownloadParams.DecodeHandler {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int radius;

    public c(int i3) {
        this.radius = i3;
    }

    @Override // com.tencent.image.DownloadParams.DecodeHandler
    public Bitmap run(DownloadParams params, Bitmap bitmap) {
        int coerceAtMost;
        int i3;
        float width;
        float height;
        float f16;
        int coerceAtMost2;
        float coerceAtMost3;
        if (params != null && bitmap != null) {
            int i16 = params.reqWidth;
            int i17 = params.reqHeight;
            if (i16 > 0 && i17 > 0) {
                if (bitmap.getWidth() * i17 > bitmap.getHeight() * i16) {
                    i3 = RangesKt___RangesKt.coerceAtMost(bitmap.getHeight(), i17);
                    coerceAtMost = (i3 * i16) / i17;
                    width = i3 / bitmap.getHeight();
                    f16 = (coerceAtMost - (bitmap.getWidth() * width)) * 0.5f;
                    height = 0.0f;
                } else {
                    coerceAtMost = RangesKt___RangesKt.coerceAtMost(bitmap.getWidth(), i16);
                    i3 = (coerceAtMost * i17) / i16;
                    width = coerceAtMost / bitmap.getWidth();
                    if (bitmap.getHeight() / bitmap.getWidth() >= 3) {
                        f16 = 0.0f;
                        height = 0.0f;
                    } else {
                        height = (i3 - (bitmap.getHeight() * width)) * 0.5f;
                        f16 = 0.0f;
                    }
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("QQStrangerImageDecodeHandler", 4, "reqWidth=" + i16 + " reqHeight=" + i17 + " bitmapW=" + bitmap.getWidth() + " bitmapH=" + bitmap.getHeight() + " => outWidth=" + coerceAtMost + " outHeight=" + i3 + " scale=" + width + " dx=" + f16 + " dy=" + height);
                }
                Matrix matrix = new Matrix();
                matrix.postScale(width, width);
                matrix.postTranslate((int) (f16 + 0.5f), (int) (height + 0.5f));
                try {
                    Bitmap createBitmap = Bitmap.createBitmap(coerceAtMost, i3, Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(createBitmap);
                    RectF rectF = new RectF(0.0f, 0.0f, coerceAtMost, i3);
                    int i18 = this.radius;
                    if (i18 > 0) {
                        coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(coerceAtMost, i3);
                        coerceAtMost3 = RangesKt___RangesKt.coerceAtMost(i18, coerceAtMost2 / 2.0f);
                        Path path = new Path();
                        path.addRoundRect(rectF, coerceAtMost3, coerceAtMost3, Path.Direction.CCW);
                        canvas.clipPath(path);
                    }
                    Paint paint = new Paint(6);
                    paint.setAntiAlias(true);
                    canvas.drawBitmap(bitmap, matrix, paint);
                    return createBitmap;
                } catch (OutOfMemoryError e16) {
                    QLog.e("QQStrangerImageDecodeHandler", 1, "createBitmap error: ", e16);
                }
            }
        }
        return bitmap;
    }
}
