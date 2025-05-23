package com.tencent.mobileqq.troop.homework.config;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a implements IConfigData {
    static IPatchRedirector $redirector_;
    public String C;
    public String D;
    public boolean E;

    /* renamed from: d, reason: collision with root package name */
    private boolean f296874d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f296875e;

    /* renamed from: f, reason: collision with root package name */
    private String f296876f;

    /* renamed from: h, reason: collision with root package name */
    private String f296877h;

    /* renamed from: i, reason: collision with root package name */
    private String f296878i;

    /* renamed from: m, reason: collision with root package name */
    private String f296879m;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f296874d = false;
        this.f296875e = false;
        this.f296876f = "";
        this.f296877h = "";
        this.f296878i = "";
        this.f296879m = "";
        this.C = "";
        this.D = "";
        this.E = false;
    }

    public static a e(JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String str4;
        boolean z16;
        boolean z17;
        if (jSONObject == null) {
            return new a();
        }
        boolean z18 = false;
        int optInt = jSONObject.optInt("globalOpen", 0);
        int optInt2 = jSONObject.optInt("globalOpenTXDoc", 0);
        int optInt3 = jSONObject.optInt("globalOpenWenku", 0);
        JSONObject optJSONObject = jSONObject.optJSONObject("weikeUrls");
        if (optJSONObject == null) {
            str = "";
            str2 = str;
        } else {
            String optString = optJSONObject.optString("choose_exam");
            str2 = optJSONObject.optString("get_exam_info");
            str = optString;
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("txDocUrls");
        if (optJSONObject2 == null) {
            str3 = "";
            str4 = str3;
        } else {
            String optString2 = optJSONObject2.optString("choose_doc");
            str4 = optJSONObject2.optString("get_doc_info");
            str3 = optString2;
        }
        if (optInt == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (optInt2 == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        a aVar = new a(z16, str, str2, z17, str3, str4);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("txWenkuUrls");
        if (optJSONObject3 != null) {
            aVar.C = optJSONObject3.optString("choose_wenku", "");
            aVar.D = optJSONObject3.optString("get_wenku_info", "");
        }
        if (optInt3 == 1) {
            z18 = true;
        }
        aVar.E = z18;
        if (QLog.isDevelopLevel()) {
            QLog.d("PublishHwkThirdPartyEntryConfig", 4, "got config" + jSONObject);
        }
        return aVar;
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f296879m;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f296877h;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f296876f;
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f296874d;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "mIsGlobalOpenWeiKe:" + this.f296874d + "\r\nmIsGlobalOpenTXDoc:" + this.f296875e + "\r\nmStrSelectWeiKeUrl:" + this.f296876f + "\r\nmStrDetailWeiKeUrl:" + this.f296877h + "\r\nmStrSelectDocUrl:" + this.f296878i + "\r\nmStrDetailDocUrl:" + this.f296879m + "\r\n";
    }

    public a(boolean z16, String str, String str2, boolean z17, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, str2, Boolean.valueOf(z17), str3, str4);
            return;
        }
        this.C = "";
        this.D = "";
        this.E = false;
        this.f296874d = z16;
        this.f296875e = z17;
        this.f296876f = str;
        this.f296877h = str2;
        this.f296878i = str3;
        this.f296879m = str4;
    }
}
