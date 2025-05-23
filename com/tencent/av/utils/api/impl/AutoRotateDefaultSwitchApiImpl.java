package com.tencent.av.utils.api.impl;

import com.tencent.av.utils.api.IAutoRotateDefaultSwitchApi;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import su.a;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AutoRotateDefaultSwitchApiImpl implements IAutoRotateDefaultSwitchApi {
    private static final int INVALID_DEFAULT_VALUE = 1;
    private static final String KEY_DEFAULT_VALUE = "default_value";
    private static final String KEY_ENABLE_DEFAULT_VALUE = "enable_default_value";
    private static final String TAG = "AutoRotateDefaultSwitchApiImpl";
    private static final String UNITED_AUTO_ROTATE_CONFIG_GROUP_ID = "105508";

    @Override // com.tencent.av.utils.api.IAutoRotateDefaultSwitchApi
    public boolean enableUseDefaultValue() {
        try {
            JSONObject b16 = a.b(UNITED_AUTO_ROTATE_CONFIG_GROUP_ID);
            if (b16 == null) {
                return true;
            }
            boolean optBoolean = b16.optBoolean(KEY_ENABLE_DEFAULT_VALUE, true);
            QLog.i(TAG, 1, "getMCQQSwitchOn: " + optBoolean + " hasKey:" + b16.has(KEY_ENABLE_DEFAULT_VALUE) + " content=" + b16);
            return optBoolean;
        } catch (Throwable th5) {
            QLog.i(TAG, 1, "getMCQQSwitchOn exception:" + th5);
            return true;
        }
    }

    @Override // com.tencent.av.utils.api.IAutoRotateDefaultSwitchApi
    public int getDefaultValue() {
        try {
            JSONObject b16 = a.b(UNITED_AUTO_ROTATE_CONFIG_GROUP_ID);
            if (b16 == null) {
                return 1;
            }
            int optInt = b16.optInt(KEY_DEFAULT_VALUE, 1);
            QLog.i(TAG, 1, "getDefaultValue: " + optInt + " hasKey:" + b16.has(KEY_DEFAULT_VALUE) + " content=" + b16);
            return optInt;
        } catch (Throwable th5) {
            QLog.i(TAG, 1, "getDefaultValue exception:" + th5);
            return 1;
        }
    }
}
