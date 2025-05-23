package com.tencent.hippy.qq.update;

import com.tencent.hippy.qq.api.MMKVCommonFileKeys;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import java.io.File;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes7.dex */
public class UpdateSetting {
    static volatile UpdateSetting INSTANCE;

    UpdateSetting() {
    }

    public static UpdateSetting getInstance() {
        if (INSTANCE == null) {
            synchronized (UpdateSetting.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UpdateSetting();
                }
            }
        }
        return INSTANCE;
    }

    public int getModuleVersion(String str) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        String str2 = MMKVCommonFileKeys.HIPPY_JS_BUNDLE_VERSION_PREFIX + str;
        int decodeInt = from.decodeInt(str2, -1);
        if (decodeInt != -1 && !HippyQQFileUtil.getModuleIndex(str, decodeInt).exists()) {
            from.encodeInt(str2, -1).commitAsync();
            return -1;
        }
        return decodeInt;
    }

    public boolean isModuleVersionFileExists(String str, int i3) {
        if (i3 < 0) {
            return false;
        }
        File moduleIndex = HippyQQFileUtil.getModuleIndex(str, i3);
        if (!moduleIndex.exists() || moduleIndex.length() <= 0) {
            return false;
        }
        return true;
    }

    public void setModuleVersion(String str, int i3) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeInt(MMKVCommonFileKeys.HIPPY_JS_BUNDLE_VERSION_PREFIX + str, i3).commitAsync();
    }
}
