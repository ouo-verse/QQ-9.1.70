package com.tencent.mobileqq.config.api.impl;

import android.content.Context;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AppSettingApiImpl implements IAppSettingApi {
    @Override // com.tencent.mobileqq.config.api.IAppSettingApi
    public String buildNum() {
        return AppSetting.f99542b;
    }

    @Override // com.tencent.mobileqq.config.api.IAppSettingApi
    public boolean enableTalkBack() {
        return AppSetting.f99565y;
    }

    @Override // com.tencent.mobileqq.config.api.IAppSettingApi
    public int getAppId() {
        return AppSetting.f();
    }

    @Override // com.tencent.mobileqq.config.api.IAppSettingApi
    public String getBranchName() {
        return AppSetting.f99544d;
    }

    @Override // com.tencent.mobileqq.config.api.IAppSettingApi
    public String getPublishVersionString() {
        return AppSetting.j(BaseApplication.getContext());
    }

    @Override // com.tencent.mobileqq.config.api.IAppSettingApi
    public String getReportVersionName() {
        return AppSetting.f99554n;
    }

    @Override // com.tencent.mobileqq.config.api.IAppSettingApi
    public String getSubVersion() {
        return AppSetting.f99551k;
    }

    @Override // com.tencent.mobileqq.config.api.IAppSettingApi
    public String getVersion() {
        return AppSetting.n();
    }

    @Override // com.tencent.mobileqq.config.api.IAppSettingApi
    public boolean isAllowLandscape() {
        return AppSetting.o(BaseApplication.getContext());
    }

    @Override // com.tencent.mobileqq.config.api.IAppSettingApi
    public boolean isDebugVersion() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.api.IAppSettingApi
    public boolean isGrayVersion() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.api.IAppSettingApi
    public boolean isPublicVersion() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.api.IAppSettingApi
    public boolean isSplitViewMode(Context context) {
        return AppSetting.t(context);
    }

    @Override // com.tencent.mobileqq.config.api.IAppSettingApi
    public boolean isUITest() {
        return AppSetting.u();
    }

    @Override // com.tencent.mobileqq.config.api.IAppSettingApi
    public boolean isAllowLandscape(Context context) {
        return AppSetting.o(context);
    }
}
