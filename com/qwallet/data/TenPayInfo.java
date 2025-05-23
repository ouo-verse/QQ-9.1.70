package com.qwallet.data;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.api.DefaultTVKDataProvider;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TenPayInfo {

    /* renamed from: a, reason: collision with root package name */
    public String f41528a;

    /* renamed from: b, reason: collision with root package name */
    public String f41529b = "1";

    /* renamed from: c, reason: collision with root package name */
    public List<BankCardInfo> f41530c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public String f41531d = "0";

    /* renamed from: e, reason: collision with root package name */
    public String f41532e;

    /* renamed from: f, reason: collision with root package name */
    public String f41533f;

    /* renamed from: g, reason: collision with root package name */
    public JSONObject f41534g;

    /* renamed from: h, reason: collision with root package name */
    public JSONObject f41535h;

    /* renamed from: i, reason: collision with root package name */
    public String f41536i;

    /* renamed from: j, reason: collision with root package name */
    public String f41537j;

    /* renamed from: k, reason: collision with root package name */
    public String f41538k;

    /* renamed from: l, reason: collision with root package name */
    public String f41539l;

    /* renamed from: m, reason: collision with root package name */
    public String f41540m;

    /* renamed from: n, reason: collision with root package name */
    public String f41541n;

    /* loaded from: classes3.dex */
    public static class BankCardInfo implements Serializable {
        public static final String CARD_TYPE_CREDIT = "CREDIT";
        public static final String CARD_TYPE_DEBIT = "DEBIT";
        public static final String CARD_TYPE_SPFA = "SPFA";
        public static final long QUOTA_NONE = -1;
        public String bankName;
        public String bankType;
        public String bindSerial;
        public String cardTail;
        public String cardType;
        public String cardTypeHanzi;
        public int color;
        public long dayQuotaReal;
        public long dayQuotaVirtual;
        public String desc;
        public String disable;
        public String disableComment;
        public String friendPayNickName;
        public String imageId;
        public int isCreditPay;
        public boolean isYDTCard;
        public String jumpUrl;
        public long monthLimit;
        public long singleQuotaReal;
        public long singleQuotaVirtual;
        public String topic;
        public String trueName;
        public String uin;
        public a webankInfo = null;

        public static List<BankCardInfo> parseBankListFromJSONArray(JSONArray jSONArray) {
            String[] split;
            if (jSONArray != null && jSONArray.length() != 0) {
                ArrayList arrayList = new ArrayList();
                try {
                    int length = jSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i3);
                        BankCardInfo bankCardInfo = new BankCardInfo();
                        bankCardInfo.bankType = jSONObject.optString("bank_type");
                        bankCardInfo.bankName = jSONObject.optString("bank_name");
                        bankCardInfo.cardTail = jSONObject.optString("card_tail");
                        bankCardInfo.bindSerial = jSONObject.optString("bind_serial");
                        bankCardInfo.imageId = jSONObject.optString("image_id");
                        bankCardInfo.isCreditPay = jSONObject.optInt("is_creditpay");
                        bankCardInfo.isYDTCard = jSONObject.optString(DefaultTVKDataProvider.KEY_PAY_TYPE).equals("YDT");
                        String optString = jSONObject.optString(LayoutAttrDefine.BG_Color);
                        if (TextUtils.isEmpty(optString)) {
                            optString = "#5e6379";
                        }
                        bankCardInfo.color = Color.parseColor(optString);
                        bankCardInfo.singleQuotaVirtual = jSONObject.optLong("single_quota_virtual", -1L);
                        bankCardInfo.singleQuotaReal = jSONObject.optLong("single_quota_real", -1L);
                        bankCardInfo.dayQuotaVirtual = jSONObject.optLong("day_quota_virtual", -1L);
                        bankCardInfo.disable = jSONObject.optString("disable");
                        bankCardInfo.disableComment = jSONObject.optString("disable_comment");
                        bankCardInfo.dayQuotaReal = jSONObject.optLong("day_quota_real", -1L);
                        bankCardInfo.cardType = jSONObject.optString("cardtype");
                        if (!bankCardInfo.bankType.equals("3355")) {
                            if (bankCardInfo.isCreditPay == 1) {
                                a aVar = new a();
                                bankCardInfo.webankInfo = aVar;
                                aVar.f41542a = jSONObject.optInt("card_status");
                                bankCardInfo.webankInfo.f41543b = jSONObject.optString("available_amount");
                                bankCardInfo.webankInfo.f41544c = jSONObject.optString("overdue_amount");
                                bankCardInfo.webankInfo.f41545d = jSONObject.optString("jump_url");
                                bankCardInfo.webankInfo.f41546e = jSONObject.optString("sub_title");
                                bankCardInfo.webankInfo.f41547f = jSONObject.optString("index_desc");
                                bankCardInfo.webankInfo.f41548g = jSONObject.optInt("is_recommend");
                                bankCardInfo.webankInfo.f41549h = jSONObject.optString("recommend_img");
                                bankCardInfo.webankInfo.f41550i = jSONObject.optString("lock_img");
                            }
                            if (bankCardInfo.cardType.equals("CREDIT") || bankCardInfo.cardType.equals("DEBIT") || bankCardInfo.cardType.equals(CARD_TYPE_SPFA)) {
                                if (bankCardInfo.cardType.equals(CARD_TYPE_SPFA)) {
                                    String optString2 = jSONObject.optString("uin");
                                    bankCardInfo.friendPayNickName = optString2;
                                    bankCardInfo.uin = optString2;
                                    bankCardInfo.trueName = jSONObject.optString("true_name");
                                    bankCardInfo.desc = jSONObject.optString("desc");
                                    bankCardInfo.jumpUrl = jSONObject.optString("jump_url");
                                    bankCardInfo.topic = jSONObject.optString("topic");
                                    bankCardInfo.monthLimit = jSONObject.optLong("month_limit");
                                }
                                if (!TextUtils.isEmpty(bankCardInfo.bankName) && (split = bankCardInfo.bankName.split("-")) != null) {
                                    if (split.length > 0) {
                                        bankCardInfo.bankName = split[0];
                                    }
                                    if (split.length > 1) {
                                        bankCardInfo.cardTypeHanzi = split[1];
                                    }
                                }
                                arrayList.add(bankCardInfo);
                            }
                        }
                    }
                } catch (JSONException e16) {
                    QLog.e("TenPayInfo", 1, "", e16);
                }
                return arrayList;
            }
            return new ArrayList();
        }
    }

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f41542a;

        /* renamed from: b, reason: collision with root package name */
        public String f41543b;

        /* renamed from: c, reason: collision with root package name */
        public String f41544c;

        /* renamed from: d, reason: collision with root package name */
        public String f41545d;

        /* renamed from: e, reason: collision with root package name */
        public String f41546e;

        /* renamed from: f, reason: collision with root package name */
        public String f41547f;

        /* renamed from: g, reason: collision with root package name */
        public int f41548g;

        /* renamed from: h, reason: collision with root package name */
        public String f41549h;

        /* renamed from: i, reason: collision with root package name */
        public String f41550i;
    }

    public static TenPayInfo d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new TenPayInfo();
        }
        QLog.i("TenPayInfo", 1, "parseTenPayFromJSON ,jsonObject : " + jSONObject.toString());
        TenPayInfo tenPayInfo = new TenPayInfo();
        try {
            tenPayInfo.f41528a = jSONObject.optString("balance", "0");
            tenPayInfo.f41531d = jSONObject.optString("bind_ad_flag");
            tenPayInfo.f41529b = jSONObject.optString("user_attr");
            tenPayInfo.f41532e = jSONObject.optString("bind_ad_url");
            tenPayInfo.f41533f = jSONObject.optString("bind_ad_title");
            tenPayInfo.f41534g = jSONObject.optJSONObject("qwallet_tips");
            tenPayInfo.f41530c = BankCardInfo.parseBankListFromJSONArray(new JSONArray(jSONObject.optString("bind_banks")));
            tenPayInfo.f41535h = jSONObject.optJSONObject("ctpay_param");
            tenPayInfo.f41536i = jSONObject.optString("balance_title");
            tenPayInfo.f41537j = jSONObject.optString("balance_url");
            tenPayInfo.f41538k = jSONObject.optString("guide_text");
            tenPayInfo.f41539l = jSONObject.optString("guide_link");
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info_extend");
            if (optJSONObject != null) {
                tenPayInfo.f41541n = optJSONObject.optString("realauth_content");
                tenPayInfo.f41540m = optJSONObject.optString("realauth_url");
            }
        } catch (JSONException e16) {
            QLog.e("TenPayInfo", 1, "", e16);
        }
        return tenPayInfo;
    }

    public boolean a() {
        if (!TextUtils.isEmpty(this.f41529b) && !this.f41529b.equals("0") && !this.f41529b.equals("3")) {
            return true;
        }
        return false;
    }

    public boolean b() {
        if (!TextUtils.isEmpty(this.f41529b) && this.f41529b.equals("2")) {
            return true;
        }
        return false;
    }

    public boolean c() {
        JSONObject jSONObject = this.f41534g;
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("tips_title"))) {
            return true;
        }
        return false;
    }
}
