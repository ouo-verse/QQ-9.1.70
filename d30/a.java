package d30;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {
    public static Bitmap a(String str) {
        return ImageCacheHelper.f98636a.f("qcircle_local_" + str);
    }

    public static Drawable b(int i3) {
        Drawable drawable;
        try {
            Bitmap f16 = ImageCacheHelper.f98636a.f("qcircle_local_" + i3);
            if (f16 != null) {
                drawable = new BitmapDrawable(BaseApplication.getContext().getResources(), f16);
            } else {
                drawable = QCircleSkinHelper.getInstance().getDrawable(i3);
            }
            return drawable;
        } catch (OutOfMemoryError e16) {
            QLog.e("QCircleDrawableCacheUtils", 1, "[getDrawable] ex: ", e16);
            return null;
        }
    }

    public static void c(String str, Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        ImageCacheHelper.f98636a.i("qcircle_local_" + str, bitmap, Business.QCircle);
    }

    public static void d(String str) {
        try {
            ImageCacheHelper.f98636a.n("qcircle_local_" + str);
        } catch (Throwable th5) {
            QLog.e("QCircleDrawableCacheUtils", 1, "[release] error: ", th5);
        }
    }
}
