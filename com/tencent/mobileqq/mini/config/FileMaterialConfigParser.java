package com.tencent.mobileqq.mini.config;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes33.dex */
public class FileMaterialConfigParser extends BaseConfigParser<FileMaterialConfig> {
    private static final String CONFIG_ID = "100892";
    private static final String TAG = "FileMaterialConfigParser";

    public static FileMaterialConfig getConfig() {
        FileMaterialConfig fileMaterialConfig = (FileMaterialConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(CONFIG_ID);
        return fileMaterialConfig == null ? new FileMaterialConfig() : fileMaterialConfig;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public FileMaterialConfig defaultConfig() {
        return new FileMaterialConfig();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    public FileMaterialConfig parse(byte[] bArr) {
        String str = new String(bArr);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "[onParsed] , content = " + str);
        }
        FileMaterialConfig fileMaterialConfig = new FileMaterialConfig();
        fileMaterialConfig.parse(str);
        return fileMaterialConfig;
    }
}
