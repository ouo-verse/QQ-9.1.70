package cooperation.qwallet.plugin;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

/* loaded from: classes28.dex */
public class QWalletPicHelper {
    public static final String KEY_EXTRA_CACHE_SUFFIX = "extra_cache_suffix";
    public static final String KEY_QWALLET_MD5 = "qwallet_config_md5";
    public static final int PIC_TAG = 26;
    public static final String PROTOCOL_QWALLET_DOWNLOAD = "qwallet_downloader";
    private static final String TAG = "QWalletPicHelper";

    public static Drawable getDrawableForAIO(String str, Drawable drawable) {
        return getDrawableInner(str, str, drawable, drawable, new int[]{0}, null);
    }

    public static URLDrawable getDrawableForQWallet(String str, Drawable drawable, Bundle bundle) {
        URLDrawable drawableInner = getDrawableInner(str, str, drawable, drawable, new int[]{26}, bundle);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ApngImage.playByTag(26);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: cooperation.qwallet.plugin.QWalletPicHelper.3
                @Override // java.lang.Runnable
                public void run() {
                    ApngImage.playByTag(26);
                }
            });
        }
        return drawableInner;
    }

    public static URLDrawable getDrawableInner(String str, String str2, Drawable drawable, Drawable drawable2, int[] iArr, Bundle bundle) {
        if (bundle == null) {
            try {
                bundle = new Bundle();
            } catch (Throwable unused) {
                return null;
            }
        }
        bundle.putIntArray("key_tagId_arr", iArr);
        bundle.putString("key_name", str2);
        int i3 = bundle.getInt("key_loop");
        bundle.putBoolean("key_double_bitmap", bundle.getBoolean("key_double_bitmap", true));
        boolean z16 = bundle.getBoolean(VasApngUtil.KEY_PLAY_APNG, true);
        if (TextUtils.isEmpty(str)) {
            str = com.tencent.mobileqq.qwallet.preload.a.f(str2);
        }
        URL url = new URL(PROTOCOL_QWALLET_DOWNLOAD, str, str2);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mUseApngImage = z16;
        obtain.mUseMemoryCache = bundle.getBoolean("key_use_cache", true);
        if (i3 > 0) {
            obtain.mUseMemoryCache = false;
        }
        obtain.mMemoryCacheKeySuffix = z16 + "," + i3 + "," + bundle.getString(KEY_EXTRA_CACHE_SUFFIX, "");
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable2;
        obtain.mExtraInfo = bundle;
        URLDrawable drawable3 = URLDrawable.getDrawable(url, obtain);
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "getApngDrawable ApngImage ok path:" + str + ", urlStr=" + str2);
        }
        return drawable3;
    }

    public static URLDrawable getNetDrawableForAIO(String str, Drawable drawable, Bundle bundle) {
        int[] iArr = {0};
        String f16 = com.tencent.mobileqq.qwallet.preload.a.f(str);
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        bundle2.putBoolean(ApngImage.KEY_USE_FILE_LOOP, true);
        return getDrawableInner(f16, str, drawable, drawable, iArr, bundle2);
    }

    public static URLDrawable getNetDrawableForQWallet(String str) {
        ColorDrawable colorDrawable = new ColorDrawable(0);
        return getNetDrawableForQWallet(str, colorDrawable, colorDrawable);
    }

    public static void setNetDrawableForAIO(ImageView imageView, String str, String str2, Drawable drawable) {
        if (TextUtils.isEmpty(str2)) {
            imageView.setImageDrawable(getNetDrawableForQWallet(str, drawable, drawable));
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mUseApngImage = true;
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        obtain.mMemoryCacheKeySuffix = "grapHbApng";
        Bundle bundle = new Bundle();
        int[] iArr = {26};
        bundle.putIntArray("key_tagId_arr", iArr);
        bundle.putBoolean("key_double_bitmap", true);
        obtain.mExtraInfo = bundle;
        imageView.setImageDrawable(URLDrawable.getDrawable(str2, obtain));
        ApngImage.playByTag(iArr[0]);
    }

    public static URLDrawable getNetDrawableForQWallet(String str, Bundle bundle) {
        ColorDrawable colorDrawable = new ColorDrawable(0);
        return getNetDrawableForQWallet(str, colorDrawable, colorDrawable, bundle);
    }

    public static URLDrawable getNetDrawableForAIO(String str, Drawable drawable) {
        return getNetDrawableForAIO(str, drawable, null);
    }

    public static URLDrawable getNetDrawableForQWallet(String str, Drawable drawable) {
        return getNetDrawableForQWallet(str, drawable, drawable, (String) null);
    }

    public static URLDrawable getNetDrawableForQWallet(String str, Drawable drawable, Drawable drawable2) {
        return getNetDrawableForQWallet(str, drawable, drawable2, (String) null);
    }

    public static URLDrawable getNetDrawableForQWallet(String str, Drawable drawable, Drawable drawable2, String str2) {
        int[] iArr = {26};
        String f16 = com.tencent.mobileqq.qwallet.preload.a.f(str);
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString(KEY_QWALLET_MD5, str2);
        }
        URLDrawable drawableInner = getDrawableInner(f16, str, drawable, drawable2, iArr, bundle);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ApngImage.playByTag(26);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: cooperation.qwallet.plugin.QWalletPicHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    ApngImage.playByTag(26);
                }
            });
        }
        return drawableInner;
    }

    public static URLDrawable getNetDrawableForQWallet(String str, Drawable drawable, Drawable drawable2, Bundle bundle) {
        URLDrawable drawableInner = getDrawableInner(com.tencent.mobileqq.qwallet.preload.a.f(str), str, drawable, drawable2, new int[]{26}, bundle);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ApngImage.playByTag(26);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: cooperation.qwallet.plugin.QWalletPicHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    ApngImage.playByTag(26);
                }
            });
        }
        return drawableInner;
    }

    /* loaded from: classes28.dex */
    public static class UrlDrawableAdapter implements URLDrawable.URLDrawableListener {
        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            QLog.d(QWalletPicHelper.TAG, 2, "onLoadCanceled");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            QLog.d(QWalletPicHelper.TAG, 2, "onLoadFialed");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            QLog.d(QWalletPicHelper.TAG, 2, "onLoadSuccessed");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }
}
