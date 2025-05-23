package com.tencent.open.api.impl;

import android.content.Intent;
import android.os.Bundle;
import aq3.a;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.api.IOpenSdkCommonChannelJumpActionMgr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import hd0.c;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import xp3.b;
import zp3.d;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OpenSdkCommonChannelJumpActionMgrImpl implements IOpenSdkCommonChannelJumpActionMgr {
    private static final String CONFIG_KEY = "opensdk_common_channel_login_handle_switch";
    private static final String TAG = "OpenSdkCommonChannelJumpActionMgrImpl";
    private ConcurrentHashMap<String, Boolean> configSwitchMap = new ConcurrentHashMap<>();

    private ax parseJumpAction(QBaseActivity qBaseActivity, String str) {
        return new a().a((BaseQQAppInterface) qBaseActivity.getAppRuntime(), qBaseActivity, str, b.d(str));
    }

    @Override // com.tencent.open.api.IOpenSdkCommonChannelJumpActionMgr
    public d buildHelper(QBaseActivity qBaseActivity, Intent intent) {
        if (qBaseActivity == null) {
            QLog.e(TAG, 1, "buildHelper error. activity = null");
            return null;
        }
        if (!(qBaseActivity.getAppRuntime() instanceof BaseQQAppInterface)) {
            QLog.e(TAG, 1, "buildHelper error. appRuntime not baseQQAppInterface");
            return null;
        }
        if (intent == null) {
            QLog.e(TAG, 1, "buildHelper error. intent = null");
            return null;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            QLog.e(TAG, 1, "buildHelper error. bundle = null");
            return null;
        }
        String string = extras.getString(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT);
        String string2 = extras.getString("pkg_name");
        if (string != null && string2 != null) {
            ax parseJumpAction = parseJumpAction(qBaseActivity, string);
            if (!(parseJumpAction instanceof yp3.b)) {
                return null;
            }
            parseJumpAction.f307444i = string2;
            return new zp3.b((yp3.b) parseJumpAction);
        }
        QLog.e(TAG, 1, "buildHelper error. scheme= " + string + ", packageName= " + string2);
        return null;
    }

    @Override // com.tencent.open.api.IOpenSdkCommonChannelJumpActionMgr
    public Class getParserClass() {
        return a.class;
    }

    @Override // com.tencent.open.api.IOpenSdkCommonChannelJumpActionMgr
    public boolean handleCommonChannelJumpAction(QBaseActivity qBaseActivity, Intent intent) {
        if (qBaseActivity != null && intent != null) {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                QLog.d(TAG, 1, "extras: null");
                return false;
            }
            if (!extras.getBoolean("k_from_login")) {
                QLog.d(TAG, 1, "fromLogin: false");
                return false;
            }
            String string = extras.getString(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT);
            String string2 = extras.getString("pkg_name");
            if (string != null && string2 != null) {
                ax parseJumpAction = parseJumpAction(qBaseActivity, string);
                if (parseJumpAction == null) {
                    QLog.d(TAG, 1, "jumpAction == null");
                    return false;
                }
                try {
                    parseJumpAction.B(string2);
                    parseJumpAction.b();
                    return true;
                } catch (Exception e16) {
                    c.h(TAG, "handleCommonChannelJumpAction exception", e16);
                    return false;
                }
            }
            QLog.d(TAG, 1, ZPlanPublishSource.FROM_SCHEME + string + ", packageName: " + string2);
            return false;
        }
        QLog.d(TAG, 1, WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY + qBaseActivity + ", intent: " + intent);
        return false;
    }

    @Override // com.tencent.open.api.IOpenSdkCommonChannelJumpActionMgr
    public boolean isCommonChannelHandleSwitchOn() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "isCommonChannelHandleSwitchOn appRuntime is null");
            return false;
        }
        String currentUin = peekAppRuntime.getCurrentUin();
        if (currentUin == null) {
            QLog.e(TAG, 1, "isCommonChannelHandleSwitchOn uin is null");
            return false;
        }
        Boolean bool = this.configSwitchMap.get(currentUin);
        if (bool != null) {
            QLog.i(TAG, 1, "isCommonChannelHandleSwitchOn value: " + bool);
            return bool.booleanValue();
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(CONFIG_KEY, false);
        this.configSwitchMap.put(currentUin, Boolean.valueOf(isSwitchOn));
        return isSwitchOn;
    }

    @Override // com.tencent.open.api.IOpenSdkCommonChannelJumpActionMgr
    public boolean isCommonChannelJumpAction(Object obj) {
        return obj instanceof yp3.b;
    }
}
