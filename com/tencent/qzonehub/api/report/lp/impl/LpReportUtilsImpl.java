package com.tencent.qzonehub.api.report.lp.impl;

import android.content.Intent;
import android.content.SharedPreferences;
import com.qzone.reborn.feedx.fragment.QZoneFeedxDIYUserHomeFragment;
import com.qzone.reborn.feedx.fragment.QZoneFeedxUserHomeFragment;
import com.qzone.reborn.feedx.fragment.QZoneFriendFeedXFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import common.config.service.b;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import cooperation.qzone.report.lp.LpReportNewIntent;
import cooperation.qzone.util.NetworkState;

/* compiled from: P */
/* loaded from: classes34.dex */
public class LpReportUtilsImpl implements ILpReportUtils {
    protected static final String TAG = "LpReportUtilsImpl";

    @Override // com.tencent.qzonehub.api.report.lp.ILpReportUtils
    public int convertNetworkTypeToFitInDc00518(int i3) {
        int i16 = 1;
        if (i3 != 1) {
            i16 = 3;
            if (i3 != 2) {
                if (i3 == 3) {
                    return 2;
                }
                if (i3 != 6) {
                    return 9;
                }
                return 4;
            }
        }
        return i16;
    }

    @Override // com.tencent.qzonehub.api.report.lp.ILpReportUtils
    public String getAPN() {
        return NetworkState.getAPN();
    }

    @Override // com.tencent.qzonehub.api.report.lp.ILpReportUtils
    public String getAccount() {
        if (BaseApplicationImpl.getApplication() != null && BaseApplicationImpl.getApplication().getRuntime() != null && BaseApplicationImpl.getApplication().getRuntime().getAccount() != null) {
            return BaseApplicationImpl.getApplication().getRuntime().getAccount();
        }
        return "";
    }

    @Override // com.tencent.qzonehub.api.report.lp.ILpReportUtils
    public String getAlphaConfig(String str, String str2, String str3) {
        return b.e().d(str, str2, str3);
    }

    @Override // com.tencent.qzonehub.api.report.lp.ILpReportUtils
    public int getChatSettingForTroopQZONEPHOTOCode() {
        return 7;
    }

    @Override // com.tencent.qzonehub.api.report.lp.ILpReportUtils
    public String getDeviceInfor() {
        return PlatformInfor.g().getDeviceInfor();
    }

    @Override // com.tencent.qzonehub.api.report.lp.ILpReportUtils
    public String getIMEI() {
        return PlatformInfor.g().getIMEI();
    }

    @Override // com.tencent.qzonehub.api.report.lp.ILpReportUtils
    public String getIMSI() {
        return PlatformInfor.g().getIMSI();
    }

    @Override // com.tencent.qzonehub.api.report.lp.ILpReportUtils
    public String getInternalCacheDir() {
        return CacheManager.getInternalCacheDir();
    }

    @Override // com.tencent.qzonehub.api.report.lp.ILpReportUtils
    public long getLongAccountUin() {
        if (BaseApplicationImpl.getApplication() != null && BaseApplicationImpl.getApplication().getRuntime() != null) {
            return BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
        }
        QLog.e(TAG, 1, "getLongAccountUin runtime null");
        return 0L;
    }

    @Override // com.tencent.qzonehub.api.report.lp.ILpReportUtils
    public String getModuleFilePath(String str) {
        return QzoneModuleManager.getInstance().getModuleFilePath(str);
    }

    @Override // com.tencent.qzonehub.api.report.lp.ILpReportUtils
    public int getNetworkType() {
        return com.tencent.component.network.module.common.NetworkState.g().getNetworkType();
    }

    @Override // com.tencent.qzonehub.api.report.lp.ILpReportUtils
    public String getQUA3() {
        return QUA.getQUA3();
    }

    @Override // com.tencent.qzonehub.api.report.lp.ILpReportUtils
    public String getReportUserType(BaseQQAppInterface baseQQAppInterface) {
        if (VipMMKV.getLoveZone(baseQQAppInterface.getCurrentUin()).decodeInt(AppConstants.Preferences.LOVE_STATE_FOR_CURRENT_UIN, 0) == 1) {
            return "1";
        }
        return "2";
    }

    @Override // com.tencent.qzonehub.api.report.lp.ILpReportUtils
    public long getServerTimeMillis() {
        return NetConnInfoCenter.getServerTimeMillis();
    }

    @Override // com.tencent.qzonehub.api.report.lp.ILpReportUtils
    public SharedPreferences getSharedPreferences(String str) {
        return BaseApplicationImpl.getApplication().getSharedPreferences(str, 0);
    }

    @Override // com.tencent.qzonehub.api.report.lp.ILpReportUtils
    public String getVersionForHabo() {
        return QUA.getVersionForHabo();
    }

    @Override // com.tencent.qzonehub.api.report.lp.ILpReportUtils
    public int getnetworkType() {
        return NetworkState.getNetworkType();
    }

    @Override // com.tencent.qzonehub.api.report.lp.ILpReportUtils
    public boolean isBackgroundPause() {
        return (BaseApplicationImpl.getApplication() == null || BaseApplicationImpl.getApplication().getRuntime() == null || !BaseApplicationImpl.getApplication().getRuntime().isBackgroundPause) ? false : true;
    }

    @Override // com.tencent.qzonehub.api.report.lp.ILpReportUtils
    public boolean isWap() {
        return NetworkState.isWap();
    }

    @Override // com.tencent.qzonehub.api.report.lp.ILpReportUtils
    public boolean loadModule(String str, ClassLoader classLoader, boolean z16, boolean z17) {
        return QzoneModuleManager.getInstance().loadModule(str, getClass().getClassLoader(), false, false);
    }

    @Override // com.tencent.qzonehub.api.report.lp.ILpReportUtils
    public void showToast(String str, int i3) {
        ToastUtil.a().f(str, i3);
    }

    @Override // com.tencent.qzonehub.api.report.lp.ILpReportUtils
    public void startServlet(LpReportNewIntent lpReportNewIntent) {
        if (BaseApplicationImpl.getApplication() != null && BaseApplicationImpl.getApplication().getRuntime() != null) {
            BaseApplicationImpl.getApplication().getRuntime().startServlet(lpReportNewIntent);
        } else {
            QLog.e(TAG, 1, "startServlet runtime null");
        }
    }

    @Override // com.tencent.qzonehub.api.report.lp.ILpReportUtils
    public int detectLoginFromInIntent(Intent intent) {
        if (intent != null && intent.hasExtra("public_fragment_class")) {
            String stringExtra = intent.getStringExtra("public_fragment_class");
            if (stringExtra == null) {
                stringExtra = "";
            }
            if (stringExtra.equals(QZoneFriendFeedXFragment.class.getName())) {
                return 43;
            }
            if (stringExtra.equals(QZoneFeedxDIYUserHomeFragment.class.getName()) || stringExtra.equals(QZoneFeedxUserHomeFragment.class.getName())) {
                return 44;
            }
        }
        return 0;
    }
}
