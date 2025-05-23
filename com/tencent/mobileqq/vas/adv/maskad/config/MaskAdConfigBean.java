package com.tencent.mobileqq.vas.adv.maskad.config;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class MaskAdConfigBean implements IConfigData {
    private static final String KEY_CONFIG_MASK_AD_CLICK_DAY_FREQUENCY = "mask_ad_click_day_frequency";
    private static final String KEY_CONFIG_MASK_AD_CLICK_HOUR_FREQUENCY = "mask_ad_click_hour_frequency";
    private static final String KEY_CONFIG_MASK_AD_CLICK_MINUTE_FREQUENCY = "mask_ad_click_minute_frequency";
    private static final String KEY_CONFIG_MASK_AD_CLICK_SECOND_DURATION = "mask_ad_click_second_duration";
    private static final String KEY_CONFIG_MASK_AD_CLICK_SECOND_FREQUENCY = "mask_ad_click_second_frequency";
    public static final String TAG = "MaskAdConfigBean";
    private long maskAdClickSecondDuration = 0;
    private int maskAdClickSecondFrequency = 0;
    private int maskAdClickMinuteFrequency = 0;
    private int maskAdClickHourFrequency = 0;
    private int maskAdClickDayFrequency = 0;

    public static MaskAdConfigBean parse(String str) {
        MaskAdConfigBean maskAdConfigBean = new MaskAdConfigBean();
        if (TextUtils.isEmpty(str)) {
            return maskAdConfigBean;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            maskAdConfigBean.maskAdClickSecondDuration = jSONObject.optLong(KEY_CONFIG_MASK_AD_CLICK_SECOND_DURATION);
            maskAdConfigBean.maskAdClickSecondFrequency = jSONObject.optInt(KEY_CONFIG_MASK_AD_CLICK_SECOND_FREQUENCY);
            maskAdConfigBean.maskAdClickMinuteFrequency = jSONObject.optInt(KEY_CONFIG_MASK_AD_CLICK_MINUTE_FREQUENCY);
            maskAdConfigBean.maskAdClickHourFrequency = jSONObject.optInt(KEY_CONFIG_MASK_AD_CLICK_HOUR_FREQUENCY);
            maskAdConfigBean.maskAdClickDayFrequency = jSONObject.optInt(KEY_CONFIG_MASK_AD_CLICK_DAY_FREQUENCY);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        return maskAdConfigBean;
    }

    public int getMaskAdClickDayFrequency() {
        return this.maskAdClickDayFrequency;
    }

    public int getMaskAdClickHourFrequency() {
        return this.maskAdClickHourFrequency;
    }

    public int getMaskAdClickMinuteFrequency() {
        return this.maskAdClickMinuteFrequency;
    }

    public long getMaskAdClickSecondDuration() {
        return this.maskAdClickSecondDuration;
    }

    public int getMaskAdClickSecondFrequency() {
        return this.maskAdClickSecondFrequency;
    }

    public String toString() {
        return "MaskAdConfigBean{,mask_ad_click_second_duration=" + this.maskAdClickSecondDuration + ",mask_ad_click_second_frequency=" + this.maskAdClickSecondFrequency + ",mask_ad_click_minute_frequency=" + this.maskAdClickMinuteFrequency + ",mask_ad_click_hour_frequency=" + this.maskAdClickHourFrequency + ",mask_ad_click_day_frequency=" + this.maskAdClickDayFrequency + '}';
    }
}
