package com.tencent.mobileqq.qcircle.api.global;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Size;
import androidx.annotation.Nullable;
import com.tencent.biz.qcircleshadow.lib.variation.HostFaceUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.data.QFSClockInBean;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StIconDecorate;
import feedcloud.FeedCloudMeta$StUser;
import mqq.app.MobileQQ;
import qqcircle.QQCircleEnvHub$UserInfo;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleHostGlobalInfo {
    public static final int QFS_NEW_LAYER_UI_TYPE_IN_DYNAMIC = 2;
    public static final int QFS_NEW_LAYER_UI_TYPE_IN_TAB = 3;
    private static final String TAG = "QCircleHostGlobalInfo";
    private static boolean isByShareOpenQCircle = false;
    private static boolean mCurrentQCircleTabIsActive = false;
    private static int mFolderUIType = 3;
    private static boolean mIsNowFlatState = false;
    private static boolean mIsSplitViewMode = false;
    private static int mQCircleTabHeight = 0;
    private static Size mQFunctionZoneSize = null;
    private static QFSClockInBean sClockInBean = null;
    private static String sCurMsfServerId = "";
    private static boolean sIsEnableMultiShare = true;
    private static boolean sIsLostUser = false;
    private static boolean sIsNeedRestoreFolderUi;
    private static boolean sIsQQVip;
    private static String sTabModeSchema;
    private static QQCircleEnvHub$UserInfo sUserInfo;
    private static FeedCloudMeta$StUser stUserInfo;

    public static void clearMemoryInfo() {
        QLog.d(TAG, 1, "clearMemoryInfo");
        sUserInfo = null;
        sIsLostUser = false;
        isByShareOpenQCircle = false;
        sClockInBean = null;
        sIsQQVip = false;
        sIsEnableMultiShare = true;
    }

    public static QFSClockInBean getClockInfoBean() {
        return sClockInBean;
    }

    public static String getCurMsfServerId() {
        SharedPreferences sharedPreferences;
        if (TextUtils.isEmpty(sCurMsfServerId) && (sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("RFW_COMMON_SHARE", 0)) != null) {
            sCurMsfServerId = sharedPreferences.getString("rfw_common_msf_server_id", "production");
        }
        return sCurMsfServerId;
    }

    public static int getFolderUIType() {
        return mFolderUIType;
    }

    public static Drawable getHeadDrawable(String str) {
        return getHeadDrawable(str, 1);
    }

    public static int getQCircleTabHeight() {
        return mQCircleTabHeight;
    }

    public static Size getQFunctionZoneSize() {
        return mQFunctionZoneSize;
    }

    @Nullable
    public static FeedCloudMeta$StUser getStUserInfo() {
        return stUserInfo;
    }

    public static String getTabModeSchema() {
        return sTabModeSchema;
    }

    public static QQCircleEnvHub$UserInfo getUserInfo() {
        return sUserInfo;
    }

    public static boolean isCurrentTabActive() {
        return mCurrentQCircleTabIsActive;
    }

    public static boolean isEnableMultiShare() {
        return sIsEnableMultiShare;
    }

    public static boolean isLostUser() {
        return sIsLostUser;
    }

    public static boolean isNeedRestoreFolderUI() {
        boolean z16 = sIsNeedRestoreFolderUi;
        sIsNeedRestoreFolderUi = false;
        return z16;
    }

    public static boolean isNowFlatState() {
        return mIsNowFlatState;
    }

    public static boolean isQQVip() {
        return sIsQQVip;
    }

    public static boolean isSplitViewMode() {
        return mIsSplitViewMode;
    }

    public static boolean isWifiState() {
        return AppNetConnInfo.isWifiConn();
    }

    public static void setByShareOpenQCircle(boolean z16) {
        isByShareOpenQCircle = z16;
    }

    public static void setClockInfoBean(QFSClockInBean qFSClockInBean) {
        sClockInBean = qFSClockInBean;
    }

    public static void setCurMsfServerId(String str) {
        sCurMsfServerId = str;
    }

    public static void setCurrentTabActive(boolean z16) {
        mCurrentQCircleTabIsActive = z16;
        QLog.d(TAG, 1, "setCurrentIsActive:" + z16);
    }

    public static void setFolderUIType(int i3) {
        mFolderUIType = i3;
    }

    public static void setIsEnableMultiShare(boolean z16) {
        sIsEnableMultiShare = z16;
    }

    public static void setIsLostUser(boolean z16) {
        QLog.d(TAG, 1, "setIsLostUser " + z16);
        sIsLostUser = z16;
    }

    public static void setIsNowFlatState(boolean z16) {
        mIsNowFlatState = z16;
    }

    public static void setIsSplitViewMode(boolean z16) {
        mIsSplitViewMode = z16;
    }

    public static void setNeedRestoreFolderUi(boolean z16) {
        sIsNeedRestoreFolderUi = z16;
    }

    public static void setQCircleTabHeight(int i3) {
        mQCircleTabHeight = i3;
    }

    public static void setQFunctionZoneSize(Size size) {
        mQFunctionZoneSize = size;
    }

    public static void setQQVip(boolean z16) {
        sIsQQVip = z16;
    }

    public static void setStUserInfo(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        stUserInfo = feedCloudMeta$StUser;
    }

    public static void setTabModeSchema(String str) {
        sTabModeSchema = str;
    }

    public static void setUserInfo(QQCircleEnvHub$UserInfo qQCircleEnvHub$UserInfo) {
        sUserInfo = qQCircleEnvHub$UserInfo;
    }

    public static void updateIconDecorate(FeedCloudMeta$StIconDecorate feedCloudMeta$StIconDecorate) {
        FeedCloudMeta$StUser feedCloudMeta$StUser = stUserInfo;
        if (feedCloudMeta$StUser != null) {
            feedCloudMeta$StUser.iconDecorate.set(feedCloudMeta$StIconDecorate);
        }
    }

    public static Drawable getHeadDrawable(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return RFWApplication.getApplication().getDrawable(R.drawable.ntp);
        }
        Drawable headDrawable = HostFaceUtils.getHeadDrawable(str, i3);
        return headDrawable == null ? RFWApplication.getApplication().getDrawable(R.drawable.ntp) : headDrawable;
    }
}
