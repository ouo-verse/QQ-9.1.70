package com.tencent.mobileqq.filemanager.api;

import com.tencent.mobileqq.config.business.qfile.IQFileFileReaderConfigBean;
import com.tencent.mobileqq.config.business.qfile.a;
import com.tencent.mobileqq.config.business.qfile.b;
import com.tencent.mobileqq.config.business.qfile.d;
import com.tencent.mobileqq.config.business.qfile.e;
import com.tencent.mobileqq.config.business.qfile.f;
import com.tencent.mobileqq.config.business.qfile.g;
import com.tencent.mobileqq.config.business.qfile.h;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;
import qb1.c;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes12.dex */
public interface IQFileConfigManager extends IRuntimeService {
    boolean getC2CFileIPv6Switch();

    d getDatalineConfig();

    boolean getDatalineFileIPv6Switch();

    int getDebugDatalineSettingDevice();

    String getDebugDatalineSettingUin();

    boolean getDebugTroopAIOVideoDownloadPlay();

    boolean getDiscFileIPv6Switch();

    e getExcitingC2CDownloadConfig();

    f getExcitingC2CUploadConfig();

    g getExcitingGroupDownloadConfig();

    h getExcitingGroupUploadConfig();

    c getFileAssistantTipsConfig();

    com.tencent.mobileqq.filemanager.data.c getFileAutoDownloadConfig(String str);

    int getFileIPv6Strategy();

    boolean getFileIPv6Switch();

    IQFileFileReaderConfigBean getFileReaderConfig();

    boolean getGroupFileIPv6Switch();

    String getHarcodeIP();

    a getQFileConfigManager();

    boolean getTroopVideoFileSVIPSwitch();

    boolean getTroopVideoFileSwitch();

    boolean getTroopVideoFileYearSVIPSwitch();

    b getYYBPromoteConfig();

    com.tencent.mobileqq.config.business.qfile.c getYYBPromoteDialogConfig();

    boolean isHarcodeIP();

    boolean isMMApkFileCheckEnable();

    boolean isMediaPlatformEnabled();

    boolean isMediaPlatformLocalEnabled();

    boolean isUseMediaPlatformLocalConfig();

    boolean isWlanOnly();

    void setDatalineConfig();

    void setDebugDatalineSettingDevice(int i3);

    void setDebugDatalineSettingUin(String str);

    void setDebugTroopAIOVideoDownloadPlay(boolean z16);

    void setFileReaderConfig();

    void setHarcodeIP(String str);

    void setHarcodeIP(boolean z16);

    void setMMApkFileCheckEnable(boolean z16);

    void setMediaPlatformLocalEnabled(boolean z16);

    void setUseMediaPlatformLocalConfig(boolean z16);

    void setWlanOnly(boolean z16);
}
