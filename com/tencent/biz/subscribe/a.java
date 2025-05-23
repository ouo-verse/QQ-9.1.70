package com.tencent.biz.subscribe;

import android.widget.ImageView;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.cache.api.util.Priority;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    public static void a() {
        if (MobileQQ.sProcessId == 1) {
            ImageCacheHelper.f98636a.d(Priority.Low);
        } else {
            ImageCacheHelper.f98636a.e();
        }
    }

    public static URLDrawable.URLDrawableOptions b(URLImageView uRLImageView) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(R.drawable.bgq);
        if (uRLImageView != null && uRLImageView.getLayoutParams() != null) {
            obtain.mRequestWidth = uRLImageView.getLayoutParams().width;
            obtain.mRequestHeight = uRLImageView.getLayoutParams().height;
        }
        return obtain;
    }

    @NotNull
    public static URLDrawable.URLDrawableOptions c(URLImageView uRLImageView) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(R.drawable.al6);
        if (uRLImageView.getLayoutParams() != null) {
            obtain.mRequestWidth = uRLImageView.getLayoutParams().width;
            obtain.mRequestHeight = uRLImageView.getLayoutParams().height;
        }
        return obtain;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void d(String str, URLImageView uRLImageView, URLDrawable.URLDrawableOptions uRLDrawableOptions, boolean z16) {
        URLDrawable drawable;
        WeakReference weakReference = new WeakReference(uRLImageView);
        if (uRLDrawableOptions == null) {
            try {
                uRLDrawableOptions = c(uRLImageView);
            } catch (Error e16) {
                e16.printStackTrace();
                return;
            } catch (Exception e17) {
                e17.printStackTrace();
                return;
            }
        }
        if (z16) {
            drawable = URLDrawable.getFileDrawable(str, uRLDrawableOptions);
        } else {
            drawable = URLDrawable.getDrawable(str, uRLDrawableOptions);
        }
        if (drawable != null && weakReference.get() != 0) {
            ((ImageView) weakReference.get()).setImageDrawable(drawable);
        }
    }

    public static void e(String str, URLImageView uRLImageView) {
        d(str, uRLImageView, null, false);
    }
}
