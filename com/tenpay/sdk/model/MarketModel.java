package com.tenpay.sdk.model;

import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class MarketModel {
    public String balance_desc;
    public int check_fixed;
    public String comment;
    public int disable;
    public long fee;
    public String group;
    public int hide;

    /* renamed from: id, reason: collision with root package name */
    public long f386900id;
    public boolean isCheck;
    public boolean isPointModel;
    public int recommend_flag;
    public String show_msg;

    public MarketModel(JSONObject jSONObject, boolean z16) {
        if (z16) {
            this.f386900id = jSONObject.optLong("id");
            this.fee = jSONObject.optLong("fee");
            this.show_msg = jSONObject.optString("show_msg");
            this.balance_desc = jSONObject.optString("balance_desc");
            this.group = jSONObject.optString(VipFunCallConstants.KEY_GROUP);
            this.disable = jSONObject.optInt("disable");
            int optInt = jSONObject.optInt("recommend_flag");
            this.recommend_flag = optInt;
            if (optInt == 1) {
                this.isCheck = true;
                return;
            }
            return;
        }
        this.fee = jSONObject.optLong("promotion_fee");
        this.show_msg = jSONObject.optString("promotion_show");
        this.group = jSONObject.optString("promotion_group");
        this.comment = jSONObject.optString("comment");
        this.disable = jSONObject.optInt("disable");
        int optInt2 = jSONObject.optInt("recommend_flag");
        this.recommend_flag = optInt2;
        if (optInt2 == 1) {
            this.isCheck = true;
        }
        this.hide = jSONObject.optInt("hide");
        this.check_fixed = jSONObject.optInt("fix");
        this.f386900id = jSONObject.optLong("promotion_id");
    }
}
