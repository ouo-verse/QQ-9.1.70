package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.config.business.qfile.IQFileFileReaderConfigBean;
import com.tencent.mobileqq.config.business.qfile.g;
import com.tencent.mobileqq.config.business.qfile.h;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.app.QFileConfigManager;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QFileConfigManagerImpl implements IQFileConfigManager {
    private AppRuntime mApp;
    private QFileConfigManager mQFileConfigManager;

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public boolean getC2CFileIPv6Switch() {
        return QFileConfigManager.J(this.mApp).r();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public com.tencent.mobileqq.config.business.qfile.d getDatalineConfig() {
        return QFileConfigManager.J(this.mApp).s();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public boolean getDatalineFileIPv6Switch() {
        return QFileConfigManager.J(this.mApp).t();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public int getDebugDatalineSettingDevice() {
        return QFileConfigManager.J(this.mApp).u();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public String getDebugDatalineSettingUin() {
        return QFileConfigManager.J(this.mApp).v();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public boolean getDebugTroopAIOVideoDownloadPlay() {
        return QFileConfigManager.J(this.mApp).w();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public boolean getDiscFileIPv6Switch() {
        return QFileConfigManager.J(this.mApp).x();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public com.tencent.mobileqq.config.business.qfile.e getExcitingC2CDownloadConfig() {
        return QFileConfigManager.J(this.mApp).y();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public com.tencent.mobileqq.config.business.qfile.f getExcitingC2CUploadConfig() {
        return QFileConfigManager.J(this.mApp).z();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public g getExcitingGroupDownloadConfig() {
        return QFileConfigManager.J(this.mApp).A();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public h getExcitingGroupUploadConfig() {
        return QFileConfigManager.J(this.mApp).B();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public qb1.c getFileAssistantTipsConfig() {
        return QFileConfigManager.J(this.mApp).C();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public com.tencent.mobileqq.filemanager.data.c getFileAutoDownloadConfig(String str) {
        return QFileConfigManager.J(this.mApp).D(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public int getFileIPv6Strategy() {
        return QFileConfigManager.J(this.mApp).E();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public boolean getFileIPv6Switch() {
        return QFileConfigManager.J(this.mApp).F();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public IQFileFileReaderConfigBean getFileReaderConfig() {
        return QFileConfigManager.J(this.mApp).G();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public boolean getGroupFileIPv6Switch() {
        return QFileConfigManager.J(this.mApp).H();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public String getHarcodeIP() {
        return QFileConfigManager.J(this.mApp).I();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public com.tencent.mobileqq.config.business.qfile.a getQFileConfigManager() {
        if (this.mQFileConfigManager == null) {
            this.mQFileConfigManager = new QFileConfigManager(this.mApp);
        }
        return this.mQFileConfigManager;
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public boolean getTroopVideoFileSVIPSwitch() {
        return QFileConfigManager.J(this.mApp).K();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public boolean getTroopVideoFileSwitch() {
        return QFileConfigManager.J(this.mApp).L();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public boolean getTroopVideoFileYearSVIPSwitch() {
        return QFileConfigManager.J(this.mApp).M();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public com.tencent.mobileqq.config.business.qfile.b getYYBPromoteConfig() {
        return QFileConfigManager.J(this.mApp).N();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public com.tencent.mobileqq.config.business.qfile.c getYYBPromoteDialogConfig() {
        return QFileConfigManager.J(this.mApp).O();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public boolean isHarcodeIP() {
        return QFileConfigManager.J(this.mApp).a0();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public boolean isMMApkFileCheckEnable() {
        return QFileConfigManager.J(this.mApp).b0();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public boolean isMediaPlatformEnabled() {
        return QFileConfigManager.J(this.mApp).c0();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public boolean isMediaPlatformLocalEnabled() {
        return QFileConfigManager.J(this.mApp).d0();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public boolean isUseMediaPlatformLocalConfig() {
        return QFileConfigManager.J(this.mApp).e0();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public boolean isWlanOnly() {
        return QFileConfigManager.J(this.mApp).f0();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mApp = appRuntime;
        this.mQFileConfigManager = new QFileConfigManager(appRuntime);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public void setDatalineConfig() {
        QFileConfigManager.J(this.mApp).r0();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public void setDebugDatalineSettingDevice(int i3) {
        QFileConfigManager.J(this.mApp).t0(i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public void setDebugDatalineSettingUin(String str) {
        QFileConfigManager.J(this.mApp).u0(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public void setDebugTroopAIOVideoDownloadPlay(boolean z16) {
        QFileConfigManager.J(this.mApp).v0(z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public void setFileReaderConfig() {
        QFileConfigManager.J(this.mApp).E0();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public void setHarcodeIP(boolean z16) {
        QFileConfigManager.J(this.mApp).H0(z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public void setMMApkFileCheckEnable(boolean z16) {
        QFileConfigManager.J(this.mApp).I0(z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public void setMediaPlatformLocalEnabled(boolean z16) {
        QFileConfigManager.J(this.mApp).J0(z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public void setUseMediaPlatformLocalConfig(boolean z16) {
        QFileConfigManager.J(this.mApp).K0(z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public void setWlanOnly(boolean z16) {
        QFileConfigManager.J(this.mApp).L0(z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileConfigManager
    public void setHarcodeIP(String str) {
        QFileConfigManager.J(this.mApp).G0(str);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
