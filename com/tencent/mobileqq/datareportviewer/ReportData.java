package com.tencent.mobileqq.datareportviewer;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ReportData implements Serializable {
    static IPatchRedirector $redirector_;
    public String actionName;
    public boolean isLightBlueBg;
    public String mainAction;
    public int opType;

    /* renamed from: r2, reason: collision with root package name */
    public String f203338r2;

    /* renamed from: r3, reason: collision with root package name */
    public String f203339r3;

    /* renamed from: r4, reason: collision with root package name */
    public String f203340r4;

    /* renamed from: r5, reason: collision with root package name */
    public String f203341r5;
    public int result;
    public String subAction;
    public String table;

    public ReportData(String str, String str2, String str3, String str4, int i3, int i16, String str5, String str6, String str7, String str8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, str4, Integer.valueOf(i3), Integer.valueOf(i16), str5, str6, str7, str8);
            return;
        }
        this.table = str;
        this.mainAction = str2;
        this.subAction = str3;
        this.actionName = str4;
        this.opType = i3;
        this.result = i16;
        this.f203338r2 = str5;
        this.f203339r3 = str6;
        this.f203340r4 = str7;
        this.f203341r5 = str8;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("table", this.table);
            jSONObject.put("mainAction", this.mainAction);
            jSONObject.put("subAction", this.subAction);
            jSONObject.put("actionName", this.actionName);
            jSONObject.put("opType", this.opType);
            jSONObject.put("result", this.result);
            jSONObject.put("r2", this.f203338r2);
            jSONObject.put("r3", this.f203339r3);
            jSONObject.put("r4", this.f203340r4);
            jSONObject.put("r5", this.f203341r5);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject.toString();
    }
}
