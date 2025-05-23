package com.tencent.mobileqq.troop.troopurl.config;

import android.text.TextUtils;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f301841a;

    /* renamed from: b, reason: collision with root package name */
    public String f301842b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f301843c;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f301841a = "https://web.qun.qq.com/mannounce/index.html?_wv=1031&_bid=148#gc=$GCODE$&role=$ROLE$&actionIcon=1&from=troop_profile";
        this.f301842b = "https://qun.qq.com/qqweb/m/qun/qun_robot/auto-approval.html?_wv=1027&gc=$GCODE$&page=groupSetting";
        this.f301843c = false;
    }

    public static a a(ai[] aiVarArr) {
        String str;
        a aVar = new a();
        if (aiVarArr != null && aiVarArr.length > 0) {
            for (ai aiVar : aiVarArr) {
                if (aiVar != null && (str = aiVar.f202268b) != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.has("announcementUrl")) {
                            aVar.f301841a = jSONObject.optString("announcementUrl");
                        }
                        if (jSONObject.has("autoApprovalUrl")) {
                            aVar.f301842b = jSONObject.optString("autoApprovalUrl");
                        }
                        if (jSONObject.has("frequencyLimitVisible")) {
                            boolean z16 = true;
                            if (jSONObject.getInt("frequencyLimitVisible") != 1) {
                                z16 = false;
                            }
                            aVar.f301843c = z16;
                        } else {
                            aVar.f301843c = false;
                        }
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("TroopUrlConfBean", 2, "parse: " + str);
                    }
                }
            }
        }
        if (TextUtils.isEmpty(aVar.f301841a)) {
            aVar.f301841a = "https://web.qun.qq.com/mannounce/index.html?_wv=1031&_bid=148#gc=$GCODE$&role=$ROLE$&actionIcon=1&from=troop_profile";
        }
        if (TextUtils.isEmpty(aVar.f301842b)) {
            aVar.f301842b = "https://qun.qq.com/qqweb/m/qun/qun_robot/auto-approval.html?_wv=1027&gc=$GCODE$&page=groupSetting";
        }
        return aVar;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder(200);
        sb5.append("TroopUrlConfBean [announcement: ");
        sb5.append(this.f301841a);
        sb5.append(", autoApproval: ");
        sb5.append(this.f301842b);
        sb5.append(", freqLimitVisible: ");
        sb5.append(this.f301843c);
        sb5.append("]");
        return sb5.toString();
    }
}
