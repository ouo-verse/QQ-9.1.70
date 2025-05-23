package com.tencent.mobileqq.config.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.config.IQCircleDynamicNameApi;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QCircleDynamicNameApiImpl implements IQCircleDynamicNameApi {
    private static final String DEF_NEW_NAME = "\u77ed\u89c6\u9891";
    private static final String DEF_NEW_QQ_NAME = "QQ\u77ed\u89c6\u9891";
    public static final String MAIN_KEY_QQCIRCLE = "qqcircle";
    public static final String ORIGIN_OLD_NAME = "\u5c0f\u4e16\u754c";
    public static final String ORIGIN_OLD_QQ_NAME = "QQ\u5c0f\u4e16\u754c";
    public static final String SECONDARY_DYNAMIC_EXP_INI_URL = "qqcircle_dynamic_exp_res_url";
    public static final String SECONDARY_DYNAMIC_ICON_SWITCH = "qqcircle_dynamic_icon_switch";
    public static final String SECONDARY_DYNAMIC_NAME_SWITCH = "qqcircle_dynamic_name_switch";
    public static final String SECONDARY_DYNAMIC_NEW_NAME = "qqcircle_dynamic_new_name";
    public static final int SWITCH_CLOSE = 0;
    public static final int SWITCH_OPEN = 1;
    public static final int SWITCH_VALUE_CLOSE = 0;
    public static final int SWITCH_VALUE_OPEN = 1;
    private static final String TAG = "DTR-QCircleDynamicNameApiImpl";
    private String mDynamicNewName = "";
    private String mDynamicIniUrl = "";
    private boolean mIsEnabledDynamicName = false;
    private boolean mIsDynamicIconExp = false;

    private String getDynamicNewNameExp() {
        return QzoneConfig.getInstance().getConfig("qqcircle", SECONDARY_DYNAMIC_NEW_NAME, DEF_NEW_QQ_NAME, false);
    }

    private boolean isEnabledDynamicIcon() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", SECONDARY_DYNAMIC_ICON_SWITCH, 1, false) == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.config.IQCircleDynamicNameApi
    public boolean isDynamicIconExp() {
        if (isEnabledDynamicIcon() && this.mIsDynamicIconExp) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.config.IQCircleDynamicNameApi
    public boolean isDynamicNewNameExp() {
        String dynamicNewNameExp = getDynamicNewNameExp();
        String obtainExpDynamicIniUrl = obtainExpDynamicIniUrl();
        boolean isEnabledDynamicName = isEnabledDynamicName();
        if (this.mIsEnabledDynamicName != isEnabledDynamicName || !TextUtils.equals(obtainExpDynamicIniUrl, this.mDynamicIniUrl) || !TextUtils.equals(dynamicNewNameExp, this.mDynamicNewName)) {
            QLog.d(TAG, 1, "[isDynamicNewNameExp] isEnabledDynamicName: " + isEnabledDynamicName + " | dynamicIniUrl: " + obtainExpDynamicIniUrl + " | dynamicNewName: " + dynamicNewNameExp);
            this.mIsEnabledDynamicName = isEnabledDynamicName;
            this.mDynamicIniUrl = obtainExpDynamicIniUrl;
            this.mDynamicNewName = dynamicNewNameExp;
        }
        if (isEnabledDynamicName && !TextUtils.isEmpty(dynamicNewNameExp) && !dynamicNewNameExp.contains(ORIGIN_OLD_NAME)) {
            return true;
        }
        return false;
    }

    public boolean isEnabledDynamicName() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", SECONDARY_DYNAMIC_NAME_SWITCH, 1, false) == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.config.IQCircleDynamicNameApi
    public String obtainDynamicBusinessName() {
        if (isDynamicNewNameExp()) {
            return getDynamicNewNameExp();
        }
        return ORIGIN_OLD_NAME;
    }

    @Override // com.tencent.mobileqq.config.IQCircleDynamicNameApi
    public String obtainExpDynamicIniUrl() {
        return QzoneConfig.getInstance().getConfig("qqcircle", SECONDARY_DYNAMIC_EXP_INI_URL, "", false);
    }

    @Override // com.tencent.mobileqq.config.IQCircleDynamicNameApi
    public String replaceToDynamicNameText(String str) {
        String replace;
        if (!isDynamicNewNameExp()) {
            return str;
        }
        if (str.contains(ORIGIN_OLD_QQ_NAME)) {
            replace = str.replace(ORIGIN_OLD_QQ_NAME, obtainDynamicBusinessName());
        } else if (str.contains(ORIGIN_OLD_NAME)) {
            replace = str.replace(ORIGIN_OLD_NAME, obtainDynamicBusinessName());
        } else if (str.contains(DEF_NEW_QQ_NAME)) {
            replace = str.replace(DEF_NEW_QQ_NAME, obtainDynamicBusinessName());
        } else {
            replace = str.replace("\u77ed\u89c6\u9891", obtainDynamicBusinessName());
        }
        QLog.d(TAG, 4, "[replaceStrToNewVal] oldVal: " + str + " | newStr: " + replace);
        return replace;
    }

    @Override // com.tencent.mobileqq.config.IQCircleDynamicNameApi
    public void updateDynamicIconExp(boolean z16) {
        this.mIsDynamicIconExp = z16;
    }
}
