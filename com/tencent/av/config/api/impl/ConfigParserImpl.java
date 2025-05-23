package com.tencent.av.config.api.impl;

import android.text.TextUtils;
import com.tencent.av.config.api.IConfigParser;
import com.tencent.avcore.jni.NtrtcVideoRender;
import com.tencent.avcore.util.AVCoreLog;

/* loaded from: classes3.dex */
public class ConfigParserImpl implements IConfigParser {
    public static final String DEFAULT_VALUE = "unknown";
    private static final String TAG = "ConfigParserImpl";
    protected String mData = null;

    private String findConfigValue(String str) {
        try {
            NtrtcVideoRender.getInstance().findConfigValue(this.mData, str, "unknown");
            return null;
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
            AVCoreLog.e(TAG, "findConfigValue", e16);
            return null;
        }
    }

    @Override // com.tencent.av.config.api.IConfigParser
    public String getData() {
        return this.mData;
    }

    @Override // com.tencent.av.config.api.IConfigParser
    public int getIntValue(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return i3;
        }
        int[] intValues = getIntValues(str);
        if (intValues != null && intValues.length > 0) {
            return intValues[0];
        }
        return i3;
    }

    @Override // com.tencent.av.config.api.IConfigParser
    public int[] getIntValues(String str) {
        String findConfigValue = findConfigValue(str);
        if (findConfigValue != null && !findConfigValue.equalsIgnoreCase("unknown")) {
            String[] split = findConfigValue.split(",");
            int length = split.length;
            int[] iArr = new int[length];
            for (int i3 = 0; i3 < length; i3++) {
                try {
                    iArr[i3] = Integer.parseInt(split[i3].trim());
                } catch (Exception unused) {
                    iArr[i3] = 0;
                }
            }
            return iArr;
        }
        return null;
    }

    @Override // com.tencent.av.config.api.IConfigParser
    public String getStringValue(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String[] stringValues = getStringValues(str);
        if (stringValues != null && stringValues.length > 0) {
            return stringValues[0];
        }
        return str2;
    }

    @Override // com.tencent.av.config.api.IConfigParser
    public String[] getStringValues(String str) {
        String findConfigValue = findConfigValue(str);
        if (findConfigValue != null && !findConfigValue.equalsIgnoreCase("unknown")) {
            return findConfigValue.trim().split(",");
        }
        return null;
    }

    @Override // com.tencent.av.config.api.IConfigParser
    public boolean isEmpty() {
        return TextUtils.isEmpty(this.mData);
    }

    @Override // com.tencent.av.config.api.IConfigParser
    public void setData(String str) {
        this.mData = str;
    }
}
