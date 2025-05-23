package com.tenpay.sdk.model;

import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class PayTypeModel {
    public JSONObject channel_info;
    public int disable;
    public String disable_comment;
    public String disable_title;
    public String disable_url;
    public int highlight_flag;
    public boolean isCheck;
    public boolean isHasPromotion;
    public String nick;
    public String pay_channel;
    public long promotion_fee;
    public long promotion_id;
    public String sub_title1;
    public String sub_title2;
    public String title;

    public PayTypeModel(JSONObject jSONObject) {
        this.pay_channel = jSONObject.optString("pay_channel");
        this.title = jSONObject.optString("title");
        this.sub_title1 = jSONObject.optString("sub_title1");
        this.sub_title2 = jSONObject.optString("sub_title2");
        this.channel_info = jSONObject.optJSONObject(CGNonAgeReport.EVENT_CHANNEL);
        this.disable = jSONObject.optInt("disable");
        this.disable_url = jSONObject.optString("disable_url");
        this.disable_title = jSONObject.optString("disable_title");
        this.highlight_flag = jSONObject.optInt("highlight_flag");
        if (this.disable != 0) {
            this.disable_comment = this.sub_title2;
            this.sub_title2 = null;
        }
    }
}
