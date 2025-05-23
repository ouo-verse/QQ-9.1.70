package com.tencent.qqlive.tvkplayer.tools.baseinfo;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import java.util.Map;

/* loaded from: classes23.dex */
public class TVKCommParams {
    public static final String DOLBY_VISION_DVMA_LICENSE = "zVhSunfvcVD8n4WjbXz2LtanHm7KSSotgQcfxaaIuAldgC32TBaP5cJ165dZjwme400DZdq7jVPYFXaDMqPIuQp9wvYWQbh0BZ9OBjcnzFTu5yhJBI1MbNNTyXYROuXx";
    public static final int FREE_TYPE_UNICOM_DAWANG = 2;
    public static final int FREE_TYPE_UNICOM_MONTHLY_PAYMENT = 0;
    public static final int FREE_TYPE_UNICOM_TWEN_MONTHLY_PAYMENT = 3;
    public static final int FREE_TYPE_UNICOM_XIAOWANG = 1;
    private static final String TAG = "TVKPlayer[TVKCommParams]";
    private static String mAbUserId = "";
    private static Context mApplicationContext = null;
    private static String mAssetCacheFilePath = "";
    private static String mExpName = "";
    private static Map<String, String> mFreeNetFlowRequestMap = null;
    private static boolean mIsDebug = false;
    private static boolean mIsPreviewMode = false;
    private static boolean mIsVip = false;
    private static String mOriginalUpc = "";
    private static String mPolicyId = "";
    private static String mQQ = "";
    private static String mQUA = null;
    private static String mQimei36 = "";
    private static boolean mSelfPlayerAvailable = true;
    private static String mStaGuid = "";
    private static boolean mSurfaceViewDestroyedAsyncEnabled = false;
    private static boolean mTextureViewDestroyedAsyncEnabled = false;
    private static int mUpcState = 0;
    private static String mVsAppKey = "";
    private static int ottFlag;
    private static Map<String, String> reportInfoMap;

    public static String getAbUserId() {
        if (TextUtils.isEmpty(mAbUserId)) {
            return "";
        }
        return mAbUserId;
    }

    public static Context getApplicationContext() {
        return mApplicationContext;
    }

    public static String getAssetCacheFilePath() {
        return mAssetCacheFilePath;
    }

    public static Map<String, String> getFreeNetFlowRequestMap() {
        return mFreeNetFlowRequestMap;
    }

    public static String getOriginalUpc() {
        return mOriginalUpc;
    }

    public static int getOttFlag() {
        return ottFlag;
    }

    public static String getQQ() {
        return mQQ;
    }

    public static String getQimei36() {
        if (TextUtils.isEmpty(mQimei36)) {
            return "";
        }
        return mQimei36;
    }

    public static String getStaGuid() {
        if (TextUtils.isEmpty(mStaGuid)) {
            return "";
        }
        return mStaGuid;
    }

    @NonNull
    public static String getTabExpName() {
        return mExpName;
    }

    @NonNull
    public static String getTabPolicyId() {
        return mPolicyId;
    }

    public static int getUpcState() {
        return mUpcState;
    }

    public static String getVsAppKey() {
        if (TextUtils.isEmpty(mVsAppKey)) {
            return "";
        }
        return mVsAppKey;
    }

    public static synchronized void init(Context context, String str) {
        synchronized (TVKCommParams.class) {
            if (context == null) {
                TVKLogUtil.w(TAG, "context is null");
                return;
            }
            mApplicationContext = context.getApplicationContext();
            ottFlag = 0;
            if (TextUtils.isEmpty(str)) {
                mQQ = "";
            } else {
                mQQ = str;
            }
        }
    }

    public static void isDebug(boolean z16) {
        mIsDebug = z16;
    }

    public static void isPreviewMode(boolean z16) {
        mIsPreviewMode = z16;
    }

    public static boolean isSelfPlayerAvailable() {
        return mSelfPlayerAvailable;
    }

    public static boolean isSurfaceViewDestroyedAsyncEnabled() {
        return mSurfaceViewDestroyedAsyncEnabled;
    }

    public static boolean isTextureViewDestroyedAsyncEnabled() {
        return mTextureViewDestroyedAsyncEnabled;
    }

    public static boolean isVip() {
        return mIsVip;
    }

    public static void setAbUserId(String str) {
        mAbUserId = str;
    }

    public static void setApplicationContext(Context context) {
        mApplicationContext = context;
    }

    public static void setAssetCacheFilePath(String str) {
        mAssetCacheFilePath = str;
    }

    public static void setFreeNetFlowRequestMap(Map<String, String> map) {
        mFreeNetFlowRequestMap = map;
    }

    public static void setIsVIP(boolean z16) {
        mIsVip = z16;
    }

    public static void setOriginalUpc(String str) {
        mOriginalUpc = str;
    }

    public static void setQQ(String str) {
        mQQ = str;
    }

    public static void setQimei36(String str) {
        mQimei36 = str;
    }

    public static void setSelfPlayerAvailable(boolean z16) {
        mSelfPlayerAvailable = z16;
    }

    public static void setStaGuid(String str) {
        mStaGuid = str;
    }

    public static void setSurfaceViewDestroyedAsyncEnabled(boolean z16) {
        mSurfaceViewDestroyedAsyncEnabled = z16;
    }

    public static void setTabExpName(@NonNull String str) {
        mExpName = str;
    }

    public static void setTabPolicyId(@NonNull String str) {
        try {
            Integer.parseInt(str);
            mPolicyId = str;
        } catch (NumberFormatException e16) {
            TVKLogUtil.e(TAG, e16);
        }
    }

    public static void setTextureViewDestroyedAsyncEnabled(boolean z16) {
        mTextureViewDestroyedAsyncEnabled = z16;
    }

    public static void setUpcState(int i3) {
        mUpcState = i3;
    }

    public static void setVsAppKey(String str) {
        mVsAppKey = str;
    }

    public static boolean isDebug() {
        return mIsDebug;
    }

    public static boolean isPreviewMode() {
        return mIsPreviewMode;
    }
}
