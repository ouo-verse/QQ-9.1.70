package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class bn {

    /* renamed from: a, reason: collision with root package name */
    public String f202633a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f202634b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f202635c = "";

    /* renamed from: d, reason: collision with root package name */
    public int f202636d = 0;

    /* renamed from: e, reason: collision with root package name */
    public String f202637e = "";

    /* renamed from: f, reason: collision with root package name */
    public int f202638f = -1;

    /* renamed from: g, reason: collision with root package name */
    public String f202639g = "";

    /* renamed from: h, reason: collision with root package name */
    public String f202640h = "";

    public static bn a(String str) {
        if (str == null) {
            return null;
        }
        try {
            bn bnVar = new bn();
            JSONObject jSONObject = new JSONObject(str);
            JSONArray optJSONArray = jSONObject.optJSONArray("whiteList");
            if (optJSONArray != null) {
                bnVar.f202633a = optJSONArray.toString();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("jumpLimit");
            if (optJSONObject != null) {
                bnVar.f202634b = optJSONObject.toString();
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("whiteListv2");
            if (optJSONArray2 != null) {
                bnVar.f202635c = optJSONArray2.toString();
            }
            int optInt = jSONObject.optInt("aio_pre_safecheck", -1);
            if (optInt != -1) {
                bnVar.f202636d = optInt;
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("kbWhiteList");
            if (optJSONArray3 != null) {
                bnVar.f202637e = optJSONArray3.toString();
            }
            int optInt2 = jSONObject.optInt("force_https_enable", -1);
            if (optInt2 != -1) {
                bnVar.f202638f = optInt2;
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("force_https_whitelist");
            if (optJSONArray4 != null) {
                bnVar.f202639g = optJSONArray4.toString();
            }
            JSONArray optJSONArray5 = jSONObject.optJSONArray("force_https_blacklist");
            if (optJSONArray5 != null) {
                bnVar.f202640h = optJSONArray5.toString();
            }
            QLog.d("ConfBean", 2, "confBean = " + bnVar.toString());
            return bnVar;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("ConfBean", 1, "parse e:", e16.toString());
            }
            return null;
        }
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(100);
        sb5.append("whitelistStr:");
        sb5.append(this.f202633a);
        sb5.append(" limit:");
        sb5.append(this.f202634b);
        sb5.append(" whiteListV2:");
        sb5.append(this.f202635c);
        sb5.append(" aioPreCheckSwitch:");
        sb5.append(this.f202636d);
        sb5.append(" kbWhiteList:");
        sb5.append(this.f202637e);
        sb5.append(" forceHttpsEnable:");
        sb5.append(this.f202638f);
        sb5.append(" forceHttpsWhitelist:");
        sb5.append(this.f202639g);
        sb5.append(" forceHttpsBlacklist:");
        sb5.append(this.f202640h);
        return sb5.toString();
    }
}
