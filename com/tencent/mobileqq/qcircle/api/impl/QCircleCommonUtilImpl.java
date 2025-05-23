package com.tencent.mobileqq.qcircle.api.impl;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.compat.RFWThemeUtil;
import com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil;
import com.tencent.mobileqq.util.SSODebugUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.m;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import mqq.app.Foreground;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleCommonUtilImpl implements IQCircleCommonUtil {
    public static final String TAG = "QCircleCommonUtilImpl";

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil
    public int getColorFromJSON(JSONObject jSONObject, String str) {
        return QCircleCommonUtil.getColorFromJSON(jSONObject, str);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil
    public long getSystemTotalMemory() {
        return m.c();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil
    @Nullable
    public Activity getTopActivity() {
        return Foreground.getTopActivity();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil
    public boolean isFriend(String str) {
        return QCircleCommonUtil.isFriend(str);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil
    public boolean isInNightMode() {
        return QQTheme.isNowThemeIsNight();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil
    public boolean isTestEnv() {
        return SSODebugUtil.isTestEnv();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil
    public Bundle jsonToLabel(Bundle bundle, String str) {
        return QCircleCommonUtil.jsonToLabel(bundle, str);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil
    public String keyGpsInfo() {
        return "key_gps_info";
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil
    public String keyParseDataErrorMsg() {
        return "key_parse_data_error_msg";
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil
    public String labelToJson(Bundle bundle) {
        return QCircleCommonUtil.labelToJson(bundle);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil
    public void setNavigationBarColor(Activity activity, int i3) {
        RFWThemeUtil.setNavigationBarColor(activity, i3);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil
    public void setStatusBarColor(Activity activity, int i3) {
        RFWThemeUtil.setStatusBarColor(activity, i3);
    }
}
