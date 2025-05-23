package com.tencent.biz.qqcircle.aspectj.utils;

import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleScrollMonitorConfig {
    private static final String TAG = "QCircleScrollMonitorConfig";
    private static final int WNS_ENABLED = 1;
    private IAppSettingApi mAppSettingApi = (IAppSettingApi) QRoute.api(IAppSettingApi.class);
    private boolean mIsPackageVersionEnabled = isGrayOrDevPackageVersion();
    private boolean mIsWnsMonitorEnabled = isWnsEnabled();

    private boolean isGrayOrDevPackageVersion() {
        IAppSettingApi iAppSettingApi = this.mAppSettingApi;
        if (iAppSettingApi == null) {
            QLog.w(TAG, 1, "[isWnsEnabledCollect] current app setting api should not be null.");
            return false;
        }
        if ((iAppSettingApi.isPublicVersion() || this.mAppSettingApi.isGrayVersion()) && !this.mAppSettingApi.isGrayVersion()) {
            return false;
        }
        return true;
    }

    private boolean isWnsEnabled() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qcircle_open_performance_enable", 1) == 1) {
            return true;
        }
        return false;
    }

    public boolean isPackageVersionEnabled() {
        return this.mIsPackageVersionEnabled;
    }

    public boolean isWnsMonitorEnabled() {
        return this.mIsWnsMonitorEnabled;
    }
}
