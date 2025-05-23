package com.tencent.hippy.qq.adapter;

import androidx.annotation.NonNull;
import com.tencent.hippy.qq.api.MMKVCommonFileKeys;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mtt.hippy.adapter.HippyLogAdapter;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyQQLogAdapter implements HippyLogAdapter {
    private final String hippySDKTagPrefix = "HippySDK_";

    @Override // com.tencent.mtt.hippy.adapter.HippyLogAdapter
    public void onReceiveLogMessage(int i3, @NonNull String str, @NonNull String str2) {
        if (i3 > 1) {
            QLog.e("HippySDK_" + str, 1, str2);
            return;
        }
        if (QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool(MMKVCommonFileKeys.IS_OPEN_HIPPY_SDK_LOG, false)) {
            QLog.i("HippySDK_" + str, 1, str2);
        }
    }
}
