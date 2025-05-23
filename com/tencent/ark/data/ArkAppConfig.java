package com.tencent.ark.data;

import android.text.TextUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArkAppConfig {
    public Integer autoSize;
    public Integer fitWidthAndCentered;
    public Integer forward;
    public Integer height;
    public Integer hintHeight;
    public Integer hintWidth;
    public Integer menuMode;
    public Integer round;
    public Integer showSender;
    public Integer showTime;
    public String type;
    public Integer width;

    public boolean fromJson(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return false;
        }
        int optInt = jSONObject.optInt("round", -1);
        if (optInt != -1) {
            this.round = Integer.valueOf(optInt);
        } else if (jSONObject.optBoolean("round")) {
            this.round = 1;
        }
        int optInt2 = jSONObject.optInt("forward", -1);
        if (optInt2 != -1) {
            this.forward = Integer.valueOf(optInt2);
        } else if (jSONObject.optBoolean("forward")) {
            this.forward = 1;
        }
        int optInt3 = jSONObject.optInt("autosize", -1);
        if (optInt3 != -1) {
            this.autoSize = Integer.valueOf(optInt3);
        } else if (jSONObject.optBoolean("autosize")) {
            this.autoSize = 1;
        }
        this.type = jSONObject.optString("type", "");
        if (jSONObject.has("width") && jSONObject.has("height")) {
            this.width = Integer.valueOf(jSONObject.optInt("width", -1));
            this.height = Integer.valueOf(jSONObject.optInt("height", -1));
        }
        int optInt4 = jSONObject.optInt("showSender", -1);
        if (optInt4 != -1) {
            this.showSender = Integer.valueOf(optInt4);
        } else {
            this.showSender = Integer.valueOf(jSONObject.optBoolean("showSender", true) ? 1 : 0);
        }
        this.fitWidthAndCentered = Integer.valueOf(jSONObject.optInt("fitWidthAndCentered", 0));
        if (jSONObject.has("hintWidth") && jSONObject.has("hintHeight")) {
            this.hintWidth = Integer.valueOf(jSONObject.optInt("hintWidth", -1));
            this.hintHeight = Integer.valueOf(jSONObject.optInt("hintHeight", -1));
        }
        if (jSONObject.has(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME)) {
            this.showTime = Integer.valueOf(jSONObject.optInt(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME, 1));
        }
        if (jSONObject.has("menuMode")) {
            this.menuMode = Integer.valueOf(jSONObject.optInt("menuMode", -1));
        }
        return true;
    }

    public boolean fromString(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return fromJson(new JSONObject(str));
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean isRectangleBorder() {
        Integer num;
        if (TextUtils.equals("normal", this.type) && (num = this.round) != null && num.intValue() == 0) {
            return true;
        }
        return false;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            Integer num = this.round;
            if (num != null) {
                jSONObject.put("round", num.intValue());
            }
            Integer num2 = this.forward;
            if (num2 != null) {
                jSONObject.put("forward", num2.intValue());
            }
            Integer num3 = this.autoSize;
            if (num3 != null) {
                jSONObject.put("autosize", num3.intValue());
            }
            String str = this.type;
            if (str != null) {
                jSONObject.put("type", str);
            }
            Integer num4 = this.width;
            if (num4 != null) {
                jSONObject.put("width", num4.intValue());
            }
            Integer num5 = this.height;
            if (num5 != null) {
                jSONObject.put("height", num5.intValue());
            }
            Integer num6 = this.showSender;
            if (num6 != null) {
                jSONObject.put("showSender", num6.intValue());
            }
            Integer num7 = this.fitWidthAndCentered;
            if (num7 != null) {
                jSONObject.put("fitWidthAndCentered", num7.intValue());
            }
            Integer num8 = this.hintWidth;
            if (num8 != null) {
                jSONObject.put("hintWidth", num8.intValue());
            }
            Integer num9 = this.hintHeight;
            if (num9 != null) {
                jSONObject.put("hintHeight", num9.intValue());
            }
            Integer num10 = this.showTime;
            if (num10 != null) {
                jSONObject.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME, num10.intValue());
            }
            Integer num11 = this.menuMode;
            if (num11 != null) {
                jSONObject.put("menuMode", num11.intValue());
                return jSONObject;
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public String toString() {
        JSONObject json = toJson();
        if (json != null) {
            return json.toString();
        }
        return "";
    }
}
