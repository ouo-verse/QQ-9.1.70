package com.tencent.mobileqq.util.api.impl;

import com.tencent.mobileqq.app.RefreshBadgeHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class AppBadgeServiceImpl implements IAppBadgeService {
    private static final long LOG_TIME_OFFSET = 60000;
    private static final String TAG = "AppBadgeServiceImpl";
    RefreshBadgeHelper badgeHelper;
    private AppRuntime mAppRuntime;
    private long[] mLastLogTime = {-1, -1};
    private Boolean isSupportBadge = null;
    private Boolean updateBadgeWhenForeground = null;

    private boolean shouldUpdateBadge() {
        if (this.isSupportBadge == null) {
            this.isSupportBadge = Boolean.valueOf(BadgeUtils.j(this.mAppRuntime.getApplicationContext()));
            QLog.i(TAG, 1, "[shouldUpdateBadge] isSupportBadge = " + this.isSupportBadge);
        }
        if (!this.isSupportBadge.booleanValue()) {
            return false;
        }
        if (this.updateBadgeWhenForeground == null) {
            this.updateBadgeWhenForeground = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("notification_refresh_badge_on_foreground_9015", true));
        }
        if (this.updateBadgeWhenForeground.booleanValue()) {
            return true;
        }
        AppRuntime appRuntime = this.mAppRuntime;
        if (appRuntime.isBackgroundPause || appRuntime.isBackgroundStop) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.util.api.IAppBadgeService
    public int getAppBadgeCount(int i3) {
        return this.badgeHelper.h(i3);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mAppRuntime = appRuntime;
        this.badgeHelper = new RefreshBadgeHelper(appRuntime);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        RefreshBadgeHelper refreshBadgeHelper = this.badgeHelper;
        if (refreshBadgeHelper != null) {
            refreshBadgeHelper.m(true);
        }
    }

    @Override // com.tencent.mobileqq.util.api.IAppBadgeService
    public void refreshAppBadge() {
        refreshAppBadge(-1);
    }

    @Override // com.tencent.mobileqq.util.api.IAppBadgeService
    public void refreshAppBadge(int i3) {
        if (shouldUpdateBadge()) {
            if (QLog.isColorLevel() && System.currentTimeMillis() - this.mLastLogTime[0] >= 60000) {
                QLog.d(TAG, 2, "refreshAppBadge");
                this.mLastLogTime[0] = System.currentTimeMillis();
            }
            this.badgeHelper.l(i3);
            return;
        }
        if (!QLog.isColorLevel() || System.currentTimeMillis() - this.mLastLogTime[1] < 60000) {
            return;
        }
        QLog.d(TAG, 2, "refreshAppBadge fail cause isBackground_Pause = " + this.mAppRuntime.isBackgroundPause + ", isBackground_Stop = " + this.mAppRuntime.isBackgroundStop + ", isSupportBadge + " + BadgeUtils.j(this.mAppRuntime.getApplicationContext()));
        this.mLastLogTime[1] = System.currentTimeMillis();
    }
}
