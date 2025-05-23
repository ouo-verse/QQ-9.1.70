package com.tencent.mobileqq.filemanager.api.impl;

import android.app.Activity;
import android.os.StatFs;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FMSettingsImpl implements IFMSettings {
    @Override // com.tencent.mobileqq.filemanager.api.IFMSettings
    public long getDefalutStorgeFreeSpace() {
        try {
            StatFs statFs = new StatFs(AppConstants.SDCARD_FILE_SAVE_PATH);
            return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
        } catch (Exception e16) {
            e16.printStackTrace();
            return TTL.MAX_VALUE;
        }
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMSettings
    public String getDefaultRecvPath() {
        return AppConstants.SDCARD_FILE_SAVE_PATH;
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMSettings
    public String getDefaultThumbPath() {
        return AppConstants.SDCARD_FILE_SAVE_THUMB_PATH;
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMSettings
    public String getDefaultTmpPath() {
        return AppConstants.SDCARD_FILE_SAVE_TMP_PATH;
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMSettings
    public String getOtherRecvPath() {
        return "";
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMSettings
    public void justDoIt(long j3, List<String> list, Activity activity, lc1.a aVar) {
        aVar.a(12);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMSettings
    public void free() {
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMSettings
    public void refreshInfos() {
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMSettings
    public void remove(String str) {
    }
}
