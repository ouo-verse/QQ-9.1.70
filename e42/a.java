package e42;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    public static void a(URLImageView uRLImageView, Drawable drawable, int i3, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mFailedDrawable = drawable;
                int dip2px = ViewUtils.dip2px(i3);
                URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
                drawable2.setTag(new int[]{dip2px, dip2px});
                uRLImageView.setImageDrawable(drawable2);
            } catch (Exception e16) {
                QLog.e("ImageUtil", 1, "loadRoundImg + " + e16);
            }
        }
    }
}
