package com.tencent.mobileqq.transfile;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.cache.api.util.Priority;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.t;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.al;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes19.dex */
public class URLDrawableHelper extends BaseURLDrawableHelper {
    static IPatchRedirector $redirector_ = null;
    private static final float AIO_FILEPIC_ROUND_CORNER = 8.0f;
    public static final int AIO_IMAGE_DEFAULT_BG_COLOR = -921103;
    public static final int AIO_IMAGE_DEFAULT_HEIGHT = 99;
    public static final int AIO_IMAGE_DEFAULT_WIDTH = 99;
    public static int AIO_IMAGE_MAX_SIZE = 0;
    public static int AIO_IMAGE_MIN_SIZE = 0;
    public static final String TAG = "URLDrawableHelper";
    public static File diskCachePath;
    public static Bitmap.Config mConfig;
    private static int mTargetDensity;
    public static Bitmap.Config mThumbConfig;
    private static int sAioVideoMaxSize;
    private static boolean sVideoSizeInited;
    public static int smallSize;
    private static Drawable translucent;
    private static Drawable transparent;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class Adapter implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        public Adapter() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) uRLDrawable);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) uRLDrawable, (Object) th5);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) uRLDrawable, i3);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uRLDrawable);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76031);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        mConfig = Bitmap.Config.ARGB_8888;
        mThumbConfig = Bitmap.Config.RGB_565;
        smallSize = 921600;
        transparent = null;
        translucent = null;
        sVideoSizeInited = false;
        AIO_IMAGE_MIN_SIZE = 45;
        AIO_IMAGE_MAX_SIZE = 135;
        sAioVideoMaxSize = -1;
        BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            AIO_IMAGE_MIN_SIZE = (int) al.a(context, 45.0f);
            AIO_IMAGE_MAX_SIZE = (int) al.a(context, 135.0f);
            mTargetDensity = context.getResources().getDisplayMetrics().densityDpi;
        }
    }

    public URLDrawableHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void decodeLocalImage(URLDrawable uRLDrawable, String str, boolean z16) {
        String url = uRLDrawable.getURL().toString();
        if (uRLDrawable.getStatus() != 1 && AbsDownloader.hasFile(url)) {
            try {
                uRLDrawable.downloadImediatly();
            } catch (OutOfMemoryError unused) {
                if (QLog.isColorLevel()) {
                    QLog.w(TAG, 2, "downloadImediatly decode OOM,currentAccountUin=" + str + ",d.getURL=" + uRLDrawable.getURL());
                }
            }
        }
    }

    public static Bitmap getCommonProgressBitmap() {
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Bitmap f16 = imageCacheHelper.f("static://CommonProgress");
        if (f16 == null) {
            Bitmap g16 = j.g(BaseApplication.getContext().getResources(), R.drawable.common_loading2_0);
            if (g16 != null) {
                imageCacheHelper.k("static://CommonProgress", g16, Business.AIO, Priority.High, null);
            }
            return g16;
        }
        return f16;
    }

    public static URLDrawable getDrawable(t tVar, int i3) {
        return ((IPicHelper) QRoute.api(IPicHelper.class)).getDrawable(tVar, i3, null, null);
    }

    public static int getExifRotation(String str) {
        return BaseImageUtil.getExifOrientation(str);
    }

    public static Drawable getLoadingDrawable() {
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Bitmap f16 = imageCacheHelper.f("static://CommonLoadingDrawable");
        if (f16 == null) {
            Bitmap g16 = j.g(BaseApplication.getContext().getResources(), R.drawable.aio_image_default_round);
            if (g16 != null) {
                imageCacheHelper.k("static://CommonLoadingDrawable", g16, Business.AIO, Priority.High, null);
            }
            f16 = g16;
        }
        if (f16 != null) {
            return new BitmapDrawable(f16);
        }
        return new ColorDrawable();
    }

    public static URLDrawable getNestDrawable(t tVar, int i3) {
        boolean z16;
        URLDrawable drawable;
        URLDrawable drawable2 = URLDrawable.getDrawable(getURL(tVar, 65537));
        drawable2.setTargetDensity(mTargetDensity);
        if (drawable2.getStatus() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        URL url = getURL(tVar, i3);
        if (z16) {
            drawable = URLDrawable.getDrawable(url, -1, -1, (Drawable) drawable2, (Drawable) null, true);
        } else {
            drawable = URLDrawable.getDrawable(url, -1, -1, true);
        }
        drawable.setTargetDensity(mTargetDensity);
        drawable.setTag(tVar);
        return drawable;
    }

    public static float getRoundCorner() {
        return 8.0f;
    }

    public static Drawable getStickerFailedDrawable() {
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Bitmap f16 = imageCacheHelper.f("static://CommonFailedDrawable_sticker");
        if (f16 == null && (f16 = j.g(BaseApplication.getContext().getResources(), R.drawable.ee9)) != null) {
            imageCacheHelper.i("static://CommonFailedDrawable_sticker", f16, Business.AIO);
        }
        if (f16 != null) {
            return new BitmapDrawable(f16);
        }
        return new ColorDrawable();
    }

    public static Drawable getTranslucent() {
        if (translucent == null) {
            translucent = new ColorDrawable(1073741824);
        }
        return translucent;
    }

    public static Drawable getTransparent() {
        if (transparent == null) {
            transparent = new ColorDrawable(0);
        }
        return transparent;
    }

    public static URL getURL(t tVar, int i3) {
        return getURL(tVar, i3, null);
    }

    public static int getVideoThumbMaxDp() {
        initVideoAIOSizeByDpc();
        return sAioVideoMaxSize;
    }

    public static boolean hasDiskCache(Context context, t tVar, int i3) {
        if (AbsDownloader.getFile(getURL(tVar, i3).toString()) != null) {
            return true;
        }
        return false;
    }

    public static synchronized void initVideoAIOSizeByDpc() {
        synchronized (URLDrawableHelper.class) {
            if (sVideoSizeInited) {
                return;
            }
            String[] split = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_config.name(), "-1").split("\\|");
            if (split.length > 0) {
                try {
                    sAioVideoMaxSize = Integer.valueOf(split[0]).intValue();
                } catch (Exception unused) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "initVideoThumbSizeByDpc exception");
                    }
                    sAioVideoMaxSize = -1;
                }
            }
            sVideoSizeInited = true;
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "initVideoThumbSizeByDpc" + sAioVideoMaxSize);
            }
        }
    }

    public static boolean isAutoDownAt2G3GAbled(Context context) {
        return SettingCloneUtil.readValue((Context) BaseApplication.getContext(), (String) null, BaseApplication.getContext().getString(R.string.czu), AppConstants.QQSETTING_AUTO_RECEIVE_PIC_KEY, true);
    }

    public static boolean isMobileNet() {
        return AppNetConnInfo.isMobileConn();
    }

    public static boolean isMobileNetAndAutodownDisabled(Context context) {
        boolean isMobileConn = AppNetConnInfo.isMobileConn();
        boolean readValue = SettingCloneUtil.readValue((Context) BaseApplication.getContext(), (String) null, BaseApplication.getContext().getString(R.string.czu), AppConstants.QQSETTING_AUTO_RECEIVE_PIC_KEY, true);
        if (isMobileConn && !readValue) {
            return true;
        }
        return false;
    }

    public static URLDrawable getDrawable(URL url) {
        return getDrawable(url, 0, 0, null, null, false, 0.0f, null);
    }

    public static URL getURL(t tVar, int i3, String str) {
        return ((IPicHelper) QRoute.api(IPicHelper.class)).getURL(tVar, i3, str);
    }

    public static URLDrawable getDrawable(URL url, boolean z16) {
        return getDrawable(url, 0, 0, null, null, z16, 0.0f, null);
    }

    public static URLDrawable getDrawable(URL url, int i3, int i16) {
        return getDrawable(url, i3, i16, null, null, false, 0.0f, null);
    }

    public static URLDrawable getDrawable(URL url, int i3, int i16, boolean z16) {
        return getDrawable(url, i3, i16, null, null, z16, 0.0f, null);
    }

    public static URLDrawable getDrawable(URL url, Drawable drawable, Drawable drawable2) {
        return getDrawable(url, 0, 0, drawable, drawable2, false, 0.0f, null);
    }

    public static URLDrawable getDrawable(URL url, Drawable drawable, Drawable drawable2, boolean z16) {
        return getDrawable(url, 0, 0, drawable, drawable2, z16, 0.0f, null);
    }

    public static URLDrawable getDrawable(URL url, int i3, int i16, Drawable drawable, Drawable drawable2) {
        return getDrawable(url, i3, i16, drawable, drawable2, false, 0.0f, null);
    }

    public static URLDrawable getDrawable(URL url, int i3, int i16, Drawable drawable, Drawable drawable2, boolean z16) {
        return getDrawable(url, i3, i16, drawable, drawable2, z16, 0.0f, null);
    }

    public static URLDrawable getDrawable(URL url, int i3, int i16, Drawable drawable, Drawable drawable2, boolean z16, float f16, Bundle bundle) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = i3;
        obtain.mRequestHeight = i16;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable2;
        obtain.mPlayGifImage = z16;
        obtain.mGifRoundCorner = f16;
        obtain.mExtraInfo = bundle;
        return URLDrawable.getDrawable(url, obtain);
    }

    public static URLDrawable getDrawable(String str) throws IllegalArgumentException {
        return getDrawable(str, 0, 0, null, null, false, 0.0f);
    }

    public static URLDrawable getDrawable(String str, boolean z16) throws IllegalArgumentException {
        return getDrawable(str, 0, 0, null, null, z16, 0.0f);
    }

    public static URLDrawable getDrawable(String str, int i3, int i16) throws IllegalArgumentException {
        return getDrawable(str, i3, i16, null, null, false, 0.0f);
    }

    public static URLDrawable getDrawable(String str, int i3, int i16, boolean z16) throws IllegalArgumentException {
        return getDrawable(str, i3, i16, null, null, z16, 0.0f);
    }

    public static URLDrawable getDrawable(String str, Drawable drawable, Drawable drawable2) throws IllegalArgumentException {
        return getDrawable(str, 0, 0, drawable, drawable2, false, 0.0f);
    }

    public static URLDrawable getDrawable(String str, Drawable drawable, Drawable drawable2, boolean z16) throws IllegalArgumentException {
        return getDrawable(str, 0, 0, drawable, drawable2, z16, 0.0f);
    }

    public static URLDrawable getDrawable(String str, int i3, int i16, Drawable drawable, Drawable drawable2) throws IllegalArgumentException {
        return getDrawable(str, i3, i16, drawable, drawable2, false, 0.0f);
    }

    public static URLDrawable getDrawable(String str, int i3, int i16, Drawable drawable, Drawable drawable2, boolean z16, float f16) throws IllegalArgumentException {
        try {
            return getDrawable(new URL(str), i3, i16, drawable, drawable2, z16, f16, null);
        } catch (MalformedURLException unused) {
            throw new IllegalArgumentException("illegal url format: " + str);
        }
    }
}
