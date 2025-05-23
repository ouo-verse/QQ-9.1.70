package com.tencent.mobileqq.ark.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.ark.api.IArkSoPreLoader;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* loaded from: classes11.dex */
public class ArkSoPreLoaderImpl implements IArkSoPreLoader {
    public static final String ARK_SP_KEY_JSC_LIB_PATH = "ark_sp_key_jsc_lib_path";
    private static final String TAG = "ArkSoPreLoaderImpl";
    private String sLibJscPath;

    @Override // com.tencent.mobileqq.ark.api.IArkSoPreLoader
    public String getLibJscPath() {
        if (TextUtils.isEmpty(this.sLibJscPath)) {
            this.sLibJscPath = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeString(ARK_SP_KEY_JSC_LIB_PATH, null);
        }
        QLog.d(TAG, 1, "getLibJscPath, sLibJscPath=", this.sLibJscPath);
        return this.sLibJscPath;
    }

    @Override // com.tencent.mobileqq.ark.api.IArkSoPreLoader
    public void setLibJscPath(String str) {
        QLog.d(TAG, 1, "setLibJscPath, libJscPath=", str);
        this.sLibJscPath = str;
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeString(ARK_SP_KEY_JSC_LIB_PATH, this.sLibJscPath);
    }
}
