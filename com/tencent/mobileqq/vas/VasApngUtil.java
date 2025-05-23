package com.tencent.mobileqq.vas;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.shortvideo.filter.QQFilterConstants;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Deprecated
/* loaded from: classes20.dex */
public class VasApngUtil {
    public static final int CAN_PLAY_TAG_AIO = 0;
    public static final int CAN_PLAY_TAG_C2C_SETTING = 27;
    public static final int CAN_PLAY_TAG_CALL = 6;
    public static final int CAN_PLAY_TAG_CARD = 9;
    public static final int CAN_PLAY_TAG_COMIC_TABBAR = 12;
    public static final int CAN_PLAY_TAG_CONTACTS = 3;
    public static final int CAN_PLAY_TAG_CONVERSATION = 2;
    public static final int CAN_PLAY_TAG_DYNAMIC = 13;
    public static final int CAN_PLAY_TAG_LEBA = 4;
    public static final int CAN_PLAY_TAG_LEBA_ANIM_ICON = 39;
    public static final int CAN_PLAY_TAG_LIGHT_RECOGNITION_GUIDE = 25;
    public static final int CAN_PLAY_TAG_LOGIN = 11;
    public static final int CAN_PLAY_TAG_MINIAPP = 32;
    public static final int CAN_PLAY_TAG_NEARBY_CARD = 15;
    public static final int CAN_PLAY_TAG_NOW = 5;
    public static final int CAN_PLAY_TAG_OPT_1 = 28;
    public static final int CAN_PLAY_TAG_OPT_2 = 29;
    public static final int CAN_PLAY_TAG_OPT_3 = 30;
    public static final int CAN_PLAY_TAG_OPT_4 = 31;
    public static final int CAN_PLAY_TAG_PENDANT = 10;
    public static final int CAN_PLAY_TAG_QCIRCLE = 33;
    public static final int CAN_PLAY_TAG_QCIRCLE_PERSONAL_TIP = 34;
    public static final int CAN_PLAY_TAG_QQ_SHOP = 40;
    public static final int CAN_PLAY_TAG_QR = 35;
    public static final int CAN_PLAY_TAG_QZONE_BIRTH_GIFT = 20000;
    public static final int CAN_PLAY_TAG_QZONE_MOOD_SHORTCUT_LIST = 24;
    public static final int CAN_PLAY_TAG_QZONE_MSG_CONTENT_BOX = 10000;
    public static final int CAN_PLAY_TAG_QZONE_PLUS_MENU_FIRST = 18;
    public static final int CAN_PLAY_TAG_QZONE_PLUS_MENU_FORTH = 21;
    public static final int CAN_PLAY_TAG_QZONE_PLUS_MENU_SECOND = 19;
    public static final int CAN_PLAY_TAG_QZONE_PLUS_MENU_SIXTH = 23;
    public static final int CAN_PLAY_TAG_QZONE_PLUS_MENU_TFIFTH = 22;
    public static final int CAN_PLAY_TAG_QZONE_PLUS_MENU_THIRD = 20;
    public static final int CAN_PLAY_TAG_RED_PACK = 26;
    public static final int CAN_PLAY_TAG_SEARCH_FRIEND_LIST = 36;
    public static final int CAN_PLAY_TAG_SEARCH_FRIEND_MIXT = 37;
    public static final int CAN_PLAY_TAG_SEARCH_NET = 38;
    public static final int CAN_PLAY_TAG_SEARCH_RESULT = 41;
    public static final int CAN_PLAY_TAG_SEE = 8;
    public static final int CAN_PLAY_TAG_SETTING = 1;
    public static final int CAN_PLAY_TAG_SHORTVIDEO_TRANSITION = 16;
    public static final int CAN_PLAY_TAG_SIGNATURE_EDIT = 17;
    public static final int CAN_PLAY_TAG_VISITORS = 14;
    public static final int CAN_PLAY_TAG_WZRY_CARD_LOGO = 7;
    public static final int CAN_PLAY_TAG_ZPLAN = 30000;
    public static final String KEY_PLAY_APNG = "key_play_apng";
    public static final String KEY_USE_CACHE = "key_use_cache";
    private static final String TAG = "VasApngUtil";
    public static boolean MOVE_SWITCH = ar.a("anzaihuang", "2024-05-29", "vas_apng_move_dir_switch").isEnable(true);
    public static int[] converstionTag = {2, 3, 4, 5, 6, 8};
    public static final int[] VIP_APNG_TAGS = {1, 0, 2, 3, 9, 27};

    @Deprecated
    public static URLDrawable getApngDrawable(String str, String str2, Drawable drawable, int[] iArr, String str3, Bundle bundle) {
        return getApngDrawable(null, str, str2, drawable, iArr, str3, bundle);
    }

    private static URLDrawable getApngDrawableFromUrl(String str, String str2, Drawable drawable, int[] iArr, String str3, Bundle bundle) {
        return getApngDrawableFromUrl(str, str2, drawable, iArr, str3, true, bundle);
    }

    public static URLDrawable getApngURLDrawable(String str, final int[] iArr, Drawable drawable) {
        return getApngURLDrawable(str, iArr, drawable, null, new URLDrawable.URLDrawableListener() { // from class: com.tencent.mobileqq.vas.VasApngUtil.2
            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d(VasApngUtil.TAG, 2, "applyNormalPaster onLoadFialed");
                }
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadSuccessed(final URLDrawable uRLDrawable) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.VasApngUtil.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QLog.isColorLevel()) {
                            QLog.d(VasApngUtil.TAG, 2, "urlDrawableListener onLoadSuccessed");
                        }
                        Drawable currDrawable = uRLDrawable.getCurrDrawable();
                        if (currDrawable != null && (currDrawable instanceof ApngDrawable) && ((ApngDrawable) currDrawable).getImage() != null) {
                            ApngImage.playByTag(iArr[0]);
                        }
                    }
                });
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadCanceled(URLDrawable uRLDrawable) {
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            }
        });
    }

    public static String getCacheFilePath(String str) {
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            return str;
        }
        return VasConstant.CARD_DOWN_LOAD_DIR + str.hashCode() + ".png";
    }

    public static String getNewCacheFilePath(String str, String str2) {
        if (!MOVE_SWITCH) {
            return getCacheFilePath(str);
        }
        if (!TextUtils.isEmpty(str) && ((!str.startsWith("https:") || !str.startsWith("http:")) && new File(str).exists())) {
            return str;
        }
        return VasConstant.NEW_CARD_DOWN_LOAD_DIR + str2 + "_" + str.hashCode() + ".png";
    }

    public static Drawable getOptimizedApngDrawable(String str, String str2, Drawable drawable, int[] iArr, String str3, Bundle bundle) {
        return getApngDrawable(str, str2, drawable, iArr, str3, bundle);
    }

    public static URLDrawable getRegionUrlDrawable(String str, final int i3) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable colorDrawable = ApngOptions.TRANSPARENT;
        obtain.mLoadingDrawable = colorDrawable;
        obtain.mFailedDrawable = colorDrawable;
        URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
        drawable.setURLDrawableListener(new URLDrawable.URLDrawableListener() { // from class: com.tencent.mobileqq.vas.VasApngUtil.1
            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadSuccessed(URLDrawable uRLDrawable) {
                if (uRLDrawable.getCurrDrawable() instanceof RegionDrawable) {
                    ((RegionDrawable) uRLDrawable.getCurrDrawable()).getBitmap().setDensity(i3);
                }
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadCanceled(URLDrawable uRLDrawable) {
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadProgressed(URLDrawable uRLDrawable, int i16) {
            }
        });
        return drawable;
    }

    public static void loadApngUrlInImageView(ImageView imageView, String str, int[] iArr, Drawable drawable) {
        URLDrawable apngURLDrawable = getApngURLDrawable(str, iArr, drawable);
        if (apngURLDrawable != null) {
            imageView.setImageDrawable(apngURLDrawable);
        }
    }

    @Deprecated
    public static URLDrawable getApngDrawable(@Nullable AppRuntime appRuntime, String str, String str2, Drawable drawable, int[] iArr, String str3, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (bundle == null) {
            try {
                bundle = new Bundle();
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getApngDrawable ApngImage err:" + e16.toString() + ", path:" + str + ", name=" + str3);
                return null;
            }
        }
        boolean z16 = bundle.getBoolean(KEY_PLAY_APNG, true);
        int i3 = bundle.getInt("key_loop");
        URL url = new URL("vasapngdownloader", str, str2);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mUseApngImage = z16;
        obtain.mUseMemoryCache = bundle.getBoolean("key_use_cache", true);
        obtain.mMemoryCacheKeySuffix = z16 + "," + i3;
        int i16 = bundle.getInt(QQFilterConstants.FilterParameters.KEY_WIDTH, 0);
        int i17 = bundle.getInt(QQFilterConstants.FilterParameters.KEY_HEIGHT, 0);
        if (i16 > 0 && i17 > 0) {
            obtain.mRequestWidth = i16;
            obtain.mRequestHeight = i17;
        }
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        bundle.putIntArray("key_tagId_arr", iArr);
        bundle.putString("key_name", str3);
        bundle.putBoolean("key_double_bitmap", true);
        obtain.mExtraInfo = bundle;
        if ("-Dynamic-".equals(str2)) {
            obtain.mUseAutoScaleParams = false;
        }
        if (!bundle.getBoolean("key_use_auto_scale_params", true)) {
            obtain.mUseAutoScaleParams = false;
        }
        return URLDrawable.getDrawable(url, obtain);
    }

    private static URLDrawable getApngDrawableFromUrl(String str, String str2, Drawable drawable, int[] iArr, String str3, boolean z16, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (bundle == null) {
            try {
                bundle = new Bundle();
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getApngDrawable ApngImage err:" + e16.toString() + ", path:" + str + ", name=" + str3);
                return null;
            }
        }
        boolean z17 = bundle.getBoolean(KEY_PLAY_APNG, true);
        int i3 = bundle.getInt("key_loop");
        URL url = new URL("vasapngdownloader", str, str2);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mUseApngImage = z17;
        obtain.mUseMemoryCache = bundle.getBoolean("key_use_cache", true);
        obtain.mMemoryCacheKeySuffix = z17 + "," + i3;
        obtain.mUseUnFinishCache = z16;
        int i16 = bundle.getInt(QQFilterConstants.FilterParameters.KEY_WIDTH, 0);
        int i17 = bundle.getInt(QQFilterConstants.FilterParameters.KEY_HEIGHT, 0);
        if (i16 > 0 && i17 > 0) {
            obtain.mRequestWidth = i16;
            obtain.mRequestHeight = i17;
        }
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        bundle.putIntArray("key_tagId_arr", iArr);
        bundle.putString("key_name", str3);
        bundle.putBoolean("key_double_bitmap", true);
        obtain.mExtraInfo = bundle;
        obtain.mUseAutoScaleParams = false;
        return URLDrawable.getDrawable(url, obtain);
    }

    @Deprecated
    public static Drawable getOptimizedApngDrawable(String str, Drawable drawable, int[] iArr, String str2) {
        return getOptimizedApngDrawable(str, drawable, iArr, str2, true);
    }

    @Deprecated
    public static URLDrawable getApngURLDrawable(String str, final int[] iArr, Drawable drawable, Bundle bundle, URLDrawable.URLDrawableListener uRLDrawableListener) {
        final URLDrawable apngDrawableFromUrl = getApngDrawableFromUrl(getNewCacheFilePath(str, TAG), str, drawable, iArr, new File(str).getName(), bundle);
        if (apngDrawableFromUrl == null) {
            return null;
        }
        int status = apngDrawableFromUrl.getStatus();
        if (status != 1) {
            if (QLog.isColorLevel()) {
                QLog.e("ddddd", 2, "urlDrawable is not  SUCCESSED :" + status);
            }
            apngDrawableFromUrl.setURLDrawableListener(uRLDrawableListener);
            if (status == 2) {
                apngDrawableFromUrl.restartDownload();
            } else {
                apngDrawableFromUrl.startDownload();
            }
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.VasApngUtil.3
                @Override // java.lang.Runnable
                public void run() {
                    Drawable currDrawable = URLDrawable.this.getCurrDrawable();
                    if (currDrawable != null && (currDrawable instanceof ApngDrawable) && ((ApngDrawable) currDrawable).getImage() != null) {
                        ApngImage.playByTag(iArr[0]);
                    }
                }
            });
        }
        return apngDrawableFromUrl;
    }

    public static Drawable getOptimizedApngDrawable(String str, Drawable drawable, int[] iArr, String str2, boolean z16) {
        Bundle bundle = new Bundle();
        if (!z16) {
            bundle.putInt("key_loop", 1);
        }
        return getApngDrawableFromUrl(str, "", drawable, iArr, str2, false, bundle);
    }
}
