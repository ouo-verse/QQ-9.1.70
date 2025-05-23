package go2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.image.DownloadParams;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f402737a = new a();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements DownloadParams.DecodeHandler {
        a() {
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 3) {
                    if (iArr[0] == 0) {
                        iArr[0] = bitmap.getWidth();
                    }
                    if (iArr[1] == 0) {
                        iArr[1] = bitmap.getHeight();
                    }
                    bitmap = f.b(bitmap, iArr[2], iArr[0], iArr[1]);
                    if (bitmap == null && QLog.isDevelopLevel()) {
                        QLog.w("GuildURLDrawableDecodeHandler", 2, "ROUND_CORNER_DECODER bitmap == null");
                    }
                }
            }
            return bitmap;
        }
    }

    public static final int[] a(int i3, int i16, int i17) {
        return new int[]{i3, i16, i17};
    }

    public static Bitmap b(Bitmap bitmap, float f16, int i3, int i16) {
        if (bitmap == null) {
            return null;
        }
        try {
            float min = Math.min(bitmap.getWidth() / i3, bitmap.getHeight() / i16);
            int ceil = (int) Math.ceil(bitmap.getWidth() / min);
            int ceil2 = (int) Math.ceil(bitmap.getHeight() / min);
            if (ceil != i3 || ceil2 != i16) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, ceil, ceil2, true);
                int i17 = (ceil - i3) / 2;
                if (i17 < 0) {
                    i17 = 0;
                }
                int i18 = (ceil2 - i16) / 2;
                if (i18 < 0) {
                    i18 = 0;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("GuildURLDrawableDecodeHandler", 2, "ROUND_CORNER_DECODER scale = " + min + ", scaledWidth = " + ceil + ", scaledHeight = " + ceil2 + ", xTopLeft = " + i17 + ", yTopLeft = " + i18 + ", width = " + i3 + ", height = " + i16);
                }
                Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap, i17, i18, i3, i16);
                createScaledBitmap.recycle();
                bitmap = createBitmap;
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(createBitmap2);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            Rect rect2 = new Rect(0, 0, i3, i16);
            RectF rectF = new RectF(rect2);
            paint.setAntiAlias(true);
            paint.setDither(true);
            paint.setFilterBitmap(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-16777216);
            canvas.drawRoundRect(rectF, f16, f16, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect2, paint);
            bitmap.recycle();
            return createBitmap2;
        } catch (Throwable th5) {
            th5.printStackTrace();
            if (QLog.isDevelopLevel()) {
                QLog.w("GuildURLDrawableDecodeHandler", 2, "ROUND_CORNER_DECODER bitmap == null, ", th5);
            }
            return null;
        }
    }
}
