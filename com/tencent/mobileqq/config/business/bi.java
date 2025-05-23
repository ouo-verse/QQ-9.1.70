package com.tencent.mobileqq.config.business;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class bi {

    /* renamed from: a, reason: collision with root package name */
    public boolean f202612a = false;

    /* renamed from: b, reason: collision with root package name */
    public bo f202613b = new bo();

    public static bi a(String str) {
        if (str == null) {
            return null;
        }
        try {
            bi biVar = new bi();
            JSONObject jSONObject = new JSONObject(str);
            biVar.f202612a = jSONObject.optBoolean("showTogetherWatchInTroopSettingCard", false);
            JSONObject optJSONObject = jSONObject.optJSONObject("watchTogether");
            if (optJSONObject != null) {
                bo boVar = new bo();
                boVar.h(optJSONObject.optInt("version"));
                boVar.f(optJSONObject.optInt("jumpType"));
                boVar.g(optJSONObject.optString(WadlProxyConsts.KEY_JUMP_URL));
                boVar.e(optJSONObject.optString("jumpExtensionInfo"));
                biVar.f202613b = boVar;
            }
            QLog.d("TogetherBusinessConfProcessor", 2, "confBean = " + biVar.toString());
            return biVar;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("TogetherBusinessConfProcessor", 1, "parse e:", e16.toString());
            }
            return null;
        }
    }

    public String toString() {
        String boVar;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("TogetherConfigureBean{showTogetherWatchInTroopSettingCard=");
        sb5.append(this.f202612a);
        sb5.append(", watchTogether=");
        bo boVar2 = this.f202613b;
        if (boVar2 == null) {
            boVar = "null";
        } else {
            boVar = boVar2.toString();
        }
        sb5.append(boVar);
        sb5.append('}');
        return sb5.toString();
    }
}
