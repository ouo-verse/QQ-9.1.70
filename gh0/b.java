package gh0;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002J\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010\u00a8\u0006\u0015"}, d2 = {"Lgh0/b;", "", "Landroid/graphics/Bitmap;", "bm", "", "newWidth", "newHeight", "c", "Landroid/graphics/drawable/Drawable;", "drawable", "b", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "srcBitmap", "a", "src", "", "corner", "d", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f402040a = new b();

    b() {
    }

    private final Bitmap c(Bitmap bm5, int newWidth, int newHeight) {
        int width = bm5.getWidth();
        int height = bm5.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(newWidth / width, newHeight / height);
        Bitmap createBitmap = Bitmap.createBitmap(bm5, 0, 0, width, height, matrix, false);
        bm5.recycle();
        return createBitmap;
    }

    public final Bitmap a(Activity activity, Bitmap srcBitmap) {
        int dimension = (int) activity.getResources().getDimension(R.dimen.app_icon_size);
        Object systemService = activity.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (systemService != null) {
            int launcherLargeIconSize = ((ActivityManager) systemService).getLauncherLargeIconSize();
            if (launcherLargeIconSize > dimension) {
                dimension = launcherLargeIconSize;
            }
            Bitmap c16 = c(srcBitmap, dimension, dimension);
            if (c16 != null) {
                return f402040a.d(c16, dimension * 0.15f);
            }
            return null;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
    }

    public final Bitmap b(Drawable drawable) {
        Bitmap.Config config;
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap bitmap = null;
        if (intrinsicWidth > 0 && intrinsicHeight > 0) {
            try {
                if (drawable.getOpacity() != -1) {
                    config = Bitmap.Config.ARGB_8888;
                } else {
                    config = Bitmap.Config.RGB_565;
                }
                bitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
            } catch (OutOfMemoryError e16) {
                cg0.a.a("ImageUtil", "drawableToBitmap", "create bitmap oom : " + e16);
            }
            if (bitmap != null) {
                Canvas canvas = new Canvas(bitmap);
                drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                drawable.draw(canvas);
            }
            return bitmap;
        }
        cg0.a.a("ImageUtil", "drawableToBitmap", "width or height must more greater than 0");
        return null;
    }

    public final Bitmap d(Bitmap src, float corner) {
        Bitmap bitmap;
        try {
            bitmap = Bitmap.createBitmap(src.getWidth(), src.getHeight(), Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e16) {
            cg0.a.a("ImageUtil", "round", "create bitmap oom : " + e16);
            bitmap = null;
        }
        if (bitmap != null) {
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, src.getWidth(), src.getHeight());
            RectF rectF = new RectF(rect);
            paint.setAntiAlias(true);
            canvas.drawRoundRect(rectF, corner, corner, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(src, rect, rect, paint);
        }
        return bitmap;
    }
}
