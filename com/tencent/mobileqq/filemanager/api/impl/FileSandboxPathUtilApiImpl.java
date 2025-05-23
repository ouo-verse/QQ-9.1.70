package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.api.IFileSandboxPathUtilApi;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;

/* loaded from: classes12.dex */
public class FileSandboxPathUtilApiImpl implements IFileSandboxPathUtilApi {
    private static final String SDCARD_FILE_ORIGIN_PATH = AppConstants.SDCARD_ROOT + "/Tencent/QQfile_recv/";
    private static final String TAG = "MobileQQFilePathUtilApiImpl";
    private static final String UC_CONFIG_FILE_SANDBOX_PATH = "file_sandbox_path_switch";

    @Override // com.tencent.mobileqq.filemanager.api.IFileSandboxPathUtilApi
    public String getMobileQQFileSavePath() {
        return getSandboxPath(SDCARD_FILE_ORIGIN_PATH);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileSandboxPathUtilApi
    public String getSandboxPath(String str) {
        return VFSAssistantUtils.getSDKPrivatePath(str);
    }
}
