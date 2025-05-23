package com.qzone.proxy.feedcomponent;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.qq.taf.jce.JceStruct;
import com.qzone.adapter.feedcomponent.m;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class FeedGlobalEnv {
    public static boolean PRAISE_AVATAR_MODE = false;
    static int SHOW_FAMOUS_FOLLOW_GUIDE_LIMIT = 0;
    static int hasShownFamousFollowGuideNum = 0;
    public static final boolean isIndependent = false;
    static Application sApplication;
    static Context sContext;
    static FeedGlobalEnv sInstance;

    public static boolean canShowFamousFollowGuide() {
        int i3 = hasShownFamousFollowGuideNum;
        return i3 >= 0 && i3 < SHOW_FAMOUS_FOLLOW_GUIDE_LIMIT;
    }

    public static FeedGlobalEnv g() {
        if (sInstance == null) {
            sInstance = com.qzone.util.i.d();
        }
        FeedGlobalEnv feedGlobalEnv = sInstance;
        if (feedGlobalEnv != null) {
            return feedGlobalEnv;
        }
        throw new RuntimeException("FeedGlobalEnv does not init");
    }

    public static Application getApplication() {
        if (sApplication == null) {
            sApplication = com.qzone.util.i.a();
        }
        return sApplication;
    }

    public static Context getContext() {
        if (sContext == null) {
            sContext = com.qzone.util.i.b();
        }
        return sContext;
    }

    public static void init(Context context, Application application, FeedGlobalEnv feedGlobalEnv, j jVar) {
        sInstance = feedGlobalEnv;
        sContext = context;
        sApplication = application;
        b.h(jVar);
    }

    public static boolean updateShownFamousFollowGuideNum() {
        int i3 = hasShownFamousFollowGuideNum;
        hasShownFamousFollowGuideNum = i3 + 1;
        return i3 >= 0 && i3 < SHOW_FAMOUS_FOLLOW_GUIDE_LIMIT;
    }

    public abstract void assertUiThread();

    public abstract boolean canDownloadFont();

    public abstract boolean checkHasInstallPackage(Context context, String str);

    public abstract boolean checkLiveVideoGuest();

    public abstract Object createViewSection(ViewSectionType viewSectionType, Context context, Object obj);

    public abstract Bitmap drawableToBitmap(Drawable drawable);

    public abstract byte[] encodeJceStrcut(JceStruct jceStruct);

    public abstract Class getAddGroupQQProxy();

    public abstract Handler getAsyncRenderHandler();

    public abstract Handler getBackgroundHandler();

    public abstract String getCacheDir(String str);

    public abstract SharedPreferences getCachePreference(Context context, long j3);

    public abstract int getColor(int i3);

    public abstract int getColorId(int i3);

    public abstract int getCurrentPhotoMode();

    public abstract float getDensity();

    public abstract int getDensityDpi();

    public abstract Drawable getDrawable(int i3);

    public abstract int getDrawableId(int i3);

    public abstract String getGuideCommentRedpocketIconUrl();

    public abstract String getImgUrlByStrEmotion(String str);

    public abstract ExecutorService getLightThreadPool();

    public abstract int getNetworkType();

    public abstract int getNumCores();

    public abstract int getPixelPerCM();

    public abstract Context getPluginContext();

    public abstract String getPraiseResrourceUrl(String str);

    public abstract float getScaledDensity();

    public abstract int getScreenHeight();

    public abstract double getScreenSizeCM();

    public abstract int getScreenWidth();

    public abstract float getSpValue(float f16);

    public abstract String getStrEmotionByPos(int i3);

    public abstract long getUin();

    public abstract boolean isAccessibilityEnable();

    public abstract boolean isAudioPlayerParameter();

    public abstract boolean isBestPerformanceDevice();

    public abstract boolean isDebug();

    public abstract boolean isNetworkAvailable(Context context);

    public abstract boolean isViewDebugMode();

    public abstract m obtainDbManager(Class cls, long j3, String str);

    public abstract void postRunnableToBackgroundThread(Runnable runnable);

    public abstract void postRunnableToNormalThread(Runnable runnable);

    public abstract void postRunnableToTTTThread(Runnable runnable);

    public abstract void postRunnableToUIThread(Runnable runnable);

    public abstract void postTaskToHeavyThreadPool(Runnable runnable);

    public abstract void putEmotionUrlMap(String str, String str2);

    public abstract void removeButton(Object obj);

    public abstract void savePraiseResrourceUrl(String str, String str2);

    public abstract void sendFeedActionReportDataToOutbox(String str, long j3);

    public abstract void setPossibleCrashText(String str);

    public abstract void showToast(int i3, Context context, CharSequence charSequence);

    public abstract void showToast(int i3, Context context, CharSequence charSequence, int i16);

    public abstract void submitRealTimeJob(Runnable runnable);

    public abstract void tryPreLoadAdData(BusinessFeedData businessFeedData);

    public abstract void updateButtonStatus(String str, Object obj);
}
