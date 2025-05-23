package com.qzone.proxy.feedcomponent.model.gdt;

import android.text.TextUtils;
import com.qq.e.comm.pi.AppDownloadCallback;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Objects;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class GdtTimeLineComponentData implements Comparable {
    private static final String TAG = "GdtTimeLineComponentData";
    public int beginTimeSeconds;
    public String brandImageUrl;
    public String buttonText;
    public int countDownAnchorSeconds;
    public int endTimeSeconds;
    public boolean isShowCountDown;
    public String text;

    GdtTimeLineComponentData() {
    }

    public static GdtTimeLineComponentData build(JSONObject jSONObject) {
        GdtTimeLineComponentData gdtTimeLineComponentData = new GdtTimeLineComponentData();
        gdtTimeLineComponentData.parseData(jSONObject);
        return gdtTimeLineComponentData;
    }

    private void parseData(JSONObject jSONObject) {
        if (AdJSONUtil.isJSONObjectNull(jSONObject)) {
            return;
        }
        this.text = AdJSONUtil.optString(jSONObject, "text", "");
        this.brandImageUrl = AdJSONUtil.optString(jSONObject, "brand_image_url", "");
        this.isShowCountDown = AdJSONUtil.optInt(jSONObject, "is_show_count_down", 0) == 1;
        this.countDownAnchorSeconds = AdJSONUtil.optInt(jSONObject, "count_down_anchor", Integer.MIN_VALUE);
        JSONObject optJSONObject = AdJSONUtil.optJSONObject(jSONObject, "duration");
        if (!AdJSONUtil.isJSONObjectNull(optJSONObject)) {
            this.beginTimeSeconds = AdJSONUtil.optInt(optJSONObject, "begin", Integer.MIN_VALUE);
            this.endTimeSeconds = AdJSONUtil.optInt(optJSONObject, "end", Integer.MIN_VALUE);
        }
        this.buttonText = AdJSONUtil.optString(jSONObject, AppDownloadCallback.BUTTON_TXT, "");
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (!(obj instanceof GdtTimeLineComponentData)) {
            QLog.e(TAG, 1, "[compareTo] error");
            return 0;
        }
        return Integer.compare(this.beginTimeSeconds, ((GdtTimeLineComponentData) obj).beginTimeSeconds);
    }

    public boolean isValid() {
        int i3;
        int i16;
        return (TextUtils.isEmpty(this.text) || TextUtils.isEmpty(this.brandImageUrl) || TextUtils.isEmpty(this.buttonText) || (i3 = this.countDownAnchorSeconds) == Integer.MIN_VALUE || this.beginTimeSeconds == Integer.MIN_VALUE || (i16 = this.endTimeSeconds) == Integer.MIN_VALUE || (i16 > i3 && i3 != 0)) ? false : true;
    }

    public String toString() {
        return "GdtTimeLineComponentData{text='" + this.text + "', brandImageUrl='" + this.brandImageUrl + "', isShowCountDown=" + this.isShowCountDown + ", countDownAnchorSeconds=" + this.countDownAnchorSeconds + ", beginTimeSeconds=" + this.beginTimeSeconds + ", endTimeSeconds=" + this.endTimeSeconds + ", buttonText='" + this.buttonText + "'}";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GdtTimeLineComponentData.class != obj.getClass()) {
            return false;
        }
        GdtTimeLineComponentData gdtTimeLineComponentData = (GdtTimeLineComponentData) obj;
        return this.isShowCountDown == gdtTimeLineComponentData.isShowCountDown && this.countDownAnchorSeconds == gdtTimeLineComponentData.countDownAnchorSeconds && this.beginTimeSeconds == gdtTimeLineComponentData.beginTimeSeconds && this.endTimeSeconds == gdtTimeLineComponentData.endTimeSeconds && Objects.equals(this.text, gdtTimeLineComponentData.text) && Objects.equals(this.brandImageUrl, gdtTimeLineComponentData.brandImageUrl) && Objects.equals(this.buttonText, gdtTimeLineComponentData.buttonText);
    }
}
