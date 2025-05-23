package com.tencent.mobileqq.troop.troopgame;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f300258a;

    /* renamed from: b, reason: collision with root package name */
    private String f300259b;

    /* renamed from: c, reason: collision with root package name */
    private String f300260c;

    /* renamed from: d, reason: collision with root package name */
    private int f300261d;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f300258a = "";
        this.f300259b = "";
        this.f300260c = "";
        this.f300261d = 0;
    }

    public static a e(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("TroopGameCardConfig", 2, "content : " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.g(jSONObject.optString(WadlProxyConsts.RES_URL, ""));
            aVar.f(jSONObject.optString(WadlProxyConsts.RES_MD5, ""));
            aVar.f300260c = jSONObject.optString("troopCardTipsContent", "");
            aVar.f300261d = jSONObject.getInt("numOfMsgToCheck");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopGameCardConfig", 2, "resUrl : ");
        }
        return aVar;
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f300261d;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f300259b;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f300258a;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f300260c;
    }

    void f(String str) {
        this.f300259b = str;
    }

    void g(String str) {
        this.f300258a = str;
    }
}
