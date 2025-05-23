package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class q implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    public boolean f202702d = false;

    /* renamed from: e, reason: collision with root package name */
    public String f202704e = "https://ti.qq.com/hybrid-h5/intimate/list?_wv=83886083";

    /* renamed from: f, reason: collision with root package name */
    public String f202706f = "https://ti.qq.com/hybrid-h5/intimate/launch?_wv=83886083";

    /* renamed from: h, reason: collision with root package name */
    public String f202709h = "";

    /* renamed from: i, reason: collision with root package name */
    public String f202711i = "";

    /* renamed from: m, reason: collision with root package name */
    public String f202716m = "";
    public String C = "";
    public String D = "";
    public String E = "";
    public String F = "";
    public String G = "";
    public String H = "";
    public String I = "";
    public String J = "";
    public String K = "";
    public String L = "";
    public String M = "";
    public String N = "";
    public String P = "";
    public String Q = "";
    public String R = "";
    public String S = "";
    public String T = "";
    public String U = "";
    public String V = "";
    public String W = "";
    public String X = "";
    public String Y = "";
    public String Z = "";

    /* renamed from: a0, reason: collision with root package name */
    public String f202699a0 = "";

    /* renamed from: b0, reason: collision with root package name */
    public String f202700b0 = "";

    /* renamed from: c0, reason: collision with root package name */
    public String f202701c0 = "";

    /* renamed from: d0, reason: collision with root package name */
    public String f202703d0 = "";

    /* renamed from: e0, reason: collision with root package name */
    public String f202705e0 = "";

    /* renamed from: f0, reason: collision with root package name */
    public String f202707f0 = "";

    /* renamed from: g0, reason: collision with root package name */
    public String f202708g0 = "";

    /* renamed from: h0, reason: collision with root package name */
    public String f202710h0 = "";

    /* renamed from: i0, reason: collision with root package name */
    public String f202712i0 = "";

    /* renamed from: j0, reason: collision with root package name */
    public String f202713j0 = "";

    /* renamed from: k0, reason: collision with root package name */
    public String f202714k0 = "";

    /* renamed from: l0, reason: collision with root package name */
    public String f202715l0 = "";

    /* renamed from: m0, reason: collision with root package name */
    public String f202717m0 = "";

    /* renamed from: n0, reason: collision with root package name */
    public String f202718n0 = "";

    /* renamed from: o0, reason: collision with root package name */
    public String f202719o0 = "";

    /* renamed from: p0, reason: collision with root package name */
    public String f202720p0 = "";

    /* renamed from: q0, reason: collision with root package name */
    public String f202721q0 = "";

    /* renamed from: r0, reason: collision with root package name */
    public int f202722r0 = 80;

    /* renamed from: s0, reason: collision with root package name */
    public int f202723s0 = 100;

    /* renamed from: t0, reason: collision with root package name */
    public int f202724t0 = 80;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f202725u0 = true;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f202726v0 = false;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f202727w0 = true;

    /* renamed from: x0, reason: collision with root package name */
    public String f202728x0 = "mqqapi://miniapp/open?_atype=0&_mappid=1110647717&_mvid=&_vt=3&via=2016_71&_sig=1295754989";

    public static q a(String str) {
        boolean z16;
        String str2;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        JSONArray optJSONArray3;
        JSONArray optJSONArray4;
        JSONArray optJSONArray5;
        JSONArray optJSONArray6;
        JSONArray optJSONArray7;
        JSONArray optJSONArray8;
        JSONArray optJSONArray9;
        JSONArray optJSONArray10;
        JSONArray optJSONArray11;
        JSONArray optJSONArray12;
        JSONArray optJSONArray13;
        JSONArray optJSONArray14;
        if (str == null) {
            return null;
        }
        try {
            q qVar = new q();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("isUpgradeOpen", 0) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            qVar.f202702d = z16;
            String optString = jSONObject.optString("managePageURL", "https://ti.qq.com/hybrid-h5/intimate/list?_wv=83886083");
            qVar.f202704e = optString;
            if (TextUtils.isEmpty(optString)) {
                qVar.f202704e = "https://ti.qq.com/hybrid-h5/intimate/list?_wv=83886083";
            }
            String optString2 = jSONObject.optString("bindPageURL", "https://ti.qq.com/hybrid-h5/intimate/launch?_wv=83886083");
            qVar.f202706f = optString2;
            if (TextUtils.isEmpty(optString2)) {
                qVar.f202706f = "https://ti.qq.com/hybrid-h5/intimate/launch?_wv=83886083";
            }
            if (!jSONObject.has("bgImg")) {
                str2 = "scoreDisplayIntimateMin";
            } else {
                JSONObject optJSONObject = jSONObject.optJSONObject("bgImg");
                if (optJSONObject != null && optJSONObject.has("relationNo") && (optJSONArray14 = optJSONObject.optJSONArray("relationNo")) != null && optJSONArray14.length() > 0) {
                    qVar.f202709h = optJSONArray14.getString(0);
                }
                if (optJSONObject == null || !optJSONObject.has("relationGuimi") || (optJSONArray13 = optJSONObject.optJSONArray("relationGuimi")) == null) {
                    str2 = "scoreDisplayIntimateMin";
                } else {
                    str2 = "scoreDisplayIntimateMin";
                    if (optJSONArray13.length() > 2) {
                        qVar.f202711i = optJSONArray13.getString(0);
                        qVar.f202716m = optJSONArray13.getString(1);
                        qVar.C = optJSONArray13.getString(2);
                    }
                }
                if (optJSONObject != null && optJSONObject.has("relationBestFriend") && (optJSONArray12 = optJSONObject.optJSONArray("relationBestFriend")) != null && optJSONArray12.length() > 2) {
                    qVar.D = optJSONArray12.getString(0);
                    qVar.E = optJSONArray12.getString(1);
                    qVar.F = optJSONArray12.getString(2);
                }
                if (optJSONObject != null && optJSONObject.has("relationJiyou") && (optJSONArray11 = optJSONObject.optJSONArray("relationJiyou")) != null && optJSONArray11.length() > 2) {
                    qVar.G = optJSONArray11.getString(0);
                    qVar.H = optJSONArray11.getString(1);
                    qVar.I = optJSONArray11.getString(2);
                }
                if (optJSONObject != null && optJSONObject.has("relationLover") && (optJSONArray10 = optJSONObject.optJSONArray("relationLover")) != null && optJSONArray10.length() > 2) {
                    qVar.J = optJSONArray10.getString(0);
                    qVar.K = optJSONArray10.getString(1);
                    qVar.L = optJSONArray10.getString(2);
                }
            }
            if (jSONObject.has("darkBgImg")) {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("darkBgImg");
                if (optJSONObject2 != null && optJSONObject2.has("relationGuimi") && (optJSONArray9 = optJSONObject2.optJSONArray("relationGuimi")) != null && optJSONArray9.length() > 2) {
                    qVar.M = optJSONArray9.getString(0);
                    qVar.N = optJSONArray9.getString(1);
                    qVar.P = optJSONArray9.getString(2);
                }
                if (optJSONObject2 != null && optJSONObject2.has("relationBestFriend") && (optJSONArray8 = optJSONObject2.optJSONArray("relationBestFriend")) != null && optJSONArray8.length() > 2) {
                    qVar.Q = optJSONArray8.getString(0);
                    qVar.R = optJSONArray8.getString(1);
                    qVar.S = optJSONArray8.getString(2);
                }
                if (optJSONObject2 != null && optJSONObject2.has("relationJiyou") && (optJSONArray7 = optJSONObject2.optJSONArray("relationJiyou")) != null && optJSONArray7.length() > 2) {
                    qVar.T = optJSONArray7.getString(0);
                    qVar.U = optJSONArray7.getString(1);
                    qVar.V = optJSONArray7.getString(2);
                }
                if (optJSONObject2 != null && optJSONObject2.has("relationLover") && (optJSONArray6 = optJSONObject2.optJSONArray("relationLover")) != null && optJSONArray6.length() > 2) {
                    qVar.W = optJSONArray6.getString(0);
                    qVar.X = optJSONArray6.getString(1);
                    qVar.Y = optJSONArray6.getString(2);
                }
            }
            if (jSONObject.has("shareImg")) {
                JSONObject optJSONObject3 = jSONObject.optJSONObject("shareImg");
                if (optJSONObject3 != null && optJSONObject3.has("relationNo") && (optJSONArray5 = optJSONObject3.optJSONArray("relationNo")) != null && optJSONArray5.length() > 0) {
                    qVar.Z = optJSONArray5.getString(0);
                }
                if (optJSONObject3 != null && optJSONObject3.has("relationGuimi") && (optJSONArray4 = optJSONObject3.optJSONArray("relationGuimi")) != null && optJSONArray4.length() > 2) {
                    qVar.f202699a0 = optJSONArray4.getString(0);
                    qVar.f202700b0 = optJSONArray4.getString(1);
                    qVar.f202701c0 = optJSONArray4.getString(2);
                }
                if (optJSONObject3 != null && optJSONObject3.has("relationBestFriend") && (optJSONArray3 = optJSONObject3.optJSONArray("relationBestFriend")) != null && optJSONArray3.length() > 2) {
                    qVar.f202703d0 = optJSONArray3.getString(0);
                    qVar.f202705e0 = optJSONArray3.getString(1);
                    qVar.f202707f0 = optJSONArray3.getString(2);
                }
                if (optJSONObject3 != null && optJSONObject3.has("relationJiyou") && (optJSONArray2 = optJSONObject3.optJSONArray("relationJiyou")) != null && optJSONArray2.length() > 2) {
                    qVar.f202708g0 = optJSONArray2.getString(0);
                    qVar.f202710h0 = optJSONArray2.getString(1);
                    qVar.f202712i0 = optJSONArray2.getString(2);
                }
                if (optJSONObject3 != null && optJSONObject3.has("relationLover") && (optJSONArray = optJSONObject3.optJSONArray("relationLover")) != null && optJSONArray.length() > 2) {
                    qVar.f202713j0 = optJSONArray.getString(0);
                    qVar.f202714k0 = optJSONArray.getString(1);
                    qVar.f202715l0 = optJSONArray.getString(2);
                }
            }
            if (jSONObject.has("scoreAnimation")) {
                qVar.f202719o0 = jSONObject.optString("scoreAnimation");
            }
            if (jSONObject.has("scoreAnimationMd5")) {
                qVar.f202720p0 = jSONObject.optString("scoreAnimationMd5");
            }
            if (jSONObject.has("scoreRuleURL")) {
                qVar.f202721q0 = jSONObject.optString("scoreRuleURL");
            }
            String str3 = str2;
            if (jSONObject.has(str3)) {
                qVar.f202722r0 = jSONObject.optInt(str3);
            }
            if (jSONObject.has("scoreDisplayFriendMin")) {
                qVar.f202723s0 = jSONObject.optInt("scoreDisplayFriendMin");
            }
            if (jSONObject.has("scoreDisplayFriendMin818")) {
                qVar.f202724t0 = jSONObject.optInt("scoreDisplayFriendMin818");
            }
            if (jSONObject.has("coupleAchievementSwitch")) {
                qVar.f202725u0 = jSONObject.optBoolean("coupleAchievementSwitch");
            }
            if (jSONObject.has("oldFriendDnaSwitch")) {
                qVar.f202726v0 = jSONObject.optBoolean("oldFriendDnaSwitch");
            }
            if (jSONObject.has("newFriendDnaSwitch")) {
                qVar.f202727w0 = jSONObject.optBoolean("newFriendDnaSwitch");
            }
            if (jSONObject.has("loveAchieveScheme")) {
                qVar.f202728x0 = jSONObject.optString("loveAchieveScheme");
            }
            qVar.f202717m0 = jSONObject.optString("gifNormalUrl");
            qVar.f202718n0 = jSONObject.optString("gifNightUrl");
            return qVar;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public String toString() {
        return "FriendIntimateRelationshipBean isUpgradeOpen:" + this.f202702d + " managePageURL:" + this.f202704e + " bindPageURL:" + this.f202706f + " relationNoBgUrl:" + this.f202709h + " relationGuimiBg0Url:" + this.f202711i + " relationGuimiBg1Url:" + this.f202716m + " relationGuimiBg2Url:" + this.C + " relationSidangBg0Url:" + this.D + " relationSidangBg1Url:" + this.E + " relationSidangBg2Url:" + this.F + " relationJiyouBg0Url:" + this.G + " relationJiyouBg1Url:" + this.H + " relationJiyouBg2Url:" + this.I + " relationLoverBg0Url:" + this.J + " relationLoverBg1Url:" + this.K + " relationLoverBg2Url:" + this.L + " relationGuimiDarkBg0Url:" + this.M + " relationGuimiDarkBg1Url:" + this.N + " relationGuimiDarkBg2Url:" + this.P + " relationSidangDarkBg0Url:" + this.Q + " relationSidangDarkBg1Url:" + this.R + " relationSidangDarkBg2Url:" + this.S + " relationJiyouDarkBg0Url:" + this.T + " relationJiyouDarkBg1Url:" + this.U + " relationJiyouDarkBg2Url:" + this.V + " relationLoverDarkBg0Url:" + this.W + " relationLoverDarkBg1Url:" + this.X + " relationLoverDarkBg2Url:" + this.Y + " relationNoShareUrl:" + this.Z + " relationGuimiShare0Url:" + this.f202699a0 + " relationGuimiShare1Url:" + this.f202700b0 + " relationGuimiShare2Url:" + this.f202701c0 + " relationSidangShare0Url:" + this.f202703d0 + " relationSidangShare1Url:" + this.f202705e0 + " relationSidangShare2Url:" + this.f202707f0 + " relationJiyouShare0Url:" + this.f202708g0 + " relationJiyouShare1Url:" + this.f202710h0 + " relationJiyouShare2Url:" + this.f202712i0 + " relationLoverShare0Url:" + this.f202713j0 + " relationLoverShare1Url:" + this.f202714k0 + " relationLoverShare2Url:" + this.f202715l0 + " coupleAchievementSwitch:" + this.f202725u0 + " oldFriendDnaSwitch:" + this.f202726v0 + " newFriendDnaSwitch:" + this.f202727w0 + " loveAchieveScheme:" + this.f202728x0 + " gifNormalUrl:" + this.f202717m0 + " gifNightUrl:" + this.f202718n0;
    }
}
