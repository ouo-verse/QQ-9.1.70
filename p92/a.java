package p92;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import java.io.File;

/* compiled from: P */
/* loaded from: classes34.dex */
public class a {
    public static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap createBitmap = Bitmap.createBitmap(120, 120, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static Bitmap b(String str) {
        if (str == null) {
            return null;
        }
        try {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            j.d(file.getAbsolutePath(), options);
            int i3 = options.outWidth;
            if (i3 > 150) {
                options.inSampleSize = i3 / 150;
            }
            options.inJustDecodeBounds = false;
            return j.d(file.getAbsolutePath(), options);
        } catch (OutOfMemoryError e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("HotChatHelper", 2, "makeShareBitmap", e16);
            return null;
        } catch (Throwable th5) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("HotChatHelper", 2, "makeShareBitmap", th5);
            return null;
        }
    }

    public static void c(QQAppInterface qQAppInterface, BaseActivity baseActivity, String str, String str2, String str3, String str4, String str5, String str6, String str7, URLDrawable uRLDrawable, DialogInterface.OnDismissListener onDismissListener) {
        QQToastUtil.showQQToastInUiThread(0, HardCodeUtil.qqStr(R.string.f169731xa1));
    }
}
