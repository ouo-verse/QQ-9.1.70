package com.tencent.mobileqq.mini.config.ad;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAdConfigBean implements IConfigData {
    private static final String KEY_MINI_LOADING_AD_EXPO_CHECK_DURATION_1 = "mini_loading_ad_expo_check_duration_1";
    private static final String KEY_MINI_LOADING_AD_EXPO_CHECK_DURATION_2 = "mini_loading_ad_expo_check_duration_2";
    private static final String KEY_MINI_LOADING_AD_EXPO_CHECK_TIME_1 = "mini_loading_ad_expo_check_time_1";
    private static final String KEY_MINI_LOADING_AD_EXPO_CHECK_TIME_2 = "mini_loading_ad_expo_check_time_2";
    public static final String TAG = "MiniAdConfigBean";
    private long miniLoadingAdCheckDuration1 = 0;
    private long miniLoadingAdCheckDuration2 = 0;
    private int miniLoadingAdCheckTime1 = 0;
    private int miniLoadingAdCheckTime2 = 0;

    public static MiniAdConfigBean parse(String str) {
        MiniAdConfigBean miniAdConfigBean = new MiniAdConfigBean();
        if (TextUtils.isEmpty(str)) {
            return miniAdConfigBean;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            miniAdConfigBean.miniLoadingAdCheckDuration1 = jSONObject.optLong(KEY_MINI_LOADING_AD_EXPO_CHECK_DURATION_1);
            miniAdConfigBean.miniLoadingAdCheckDuration2 = jSONObject.optLong(KEY_MINI_LOADING_AD_EXPO_CHECK_DURATION_2);
            miniAdConfigBean.miniLoadingAdCheckTime1 = jSONObject.optInt(KEY_MINI_LOADING_AD_EXPO_CHECK_TIME_1);
            miniAdConfigBean.miniLoadingAdCheckTime2 = jSONObject.optInt(KEY_MINI_LOADING_AD_EXPO_CHECK_TIME_2);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        return miniAdConfigBean;
    }

    public long getMiniLoadingAdCheckDuration1() {
        return this.miniLoadingAdCheckDuration1;
    }

    public long getMiniLoadingAdCheckDuration2() {
        return this.miniLoadingAdCheckDuration2;
    }

    public int getMiniLoadingAdCheckTime1() {
        return this.miniLoadingAdCheckTime1;
    }

    public int getMiniLoadingAdCheckTime2() {
        return this.miniLoadingAdCheckTime2;
    }

    public String toString() {
        return "MiniAdConfigBean{,mini_loading_ad_expo_check_duration_1=" + this.miniLoadingAdCheckDuration1 + ",mini_loading_ad_expo_check_duration_2=" + this.miniLoadingAdCheckDuration2 + ",mini_loading_ad_expo_check_time_1=" + this.miniLoadingAdCheckTime1 + ",mini_loading_ad_expo_check_time_2=" + this.miniLoadingAdCheckTime2 + '}';
    }
}
