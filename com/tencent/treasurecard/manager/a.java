package com.tencent.treasurecard.manager;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.treasurecard.FtConstants;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static long f381202b;

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, com.tencent.treasurecard.bean.a> f381203a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12705);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f381202b = JoinTimeType.SIX_HOUR;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f381203a = new HashMap<>();
        }
    }

    public com.tencent.treasurecard.bean.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.treasurecard.bean.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Context g16 = ((d) d.i()).g();
        com.tencent.treasurecard.bean.a aVar = this.f381203a.get(com.tencent.treasurecard.util.a.f381233a);
        if (aVar != null) {
            return aVar;
        }
        com.tencent.treasurecard.bean.a aVar2 = new com.tencent.treasurecard.bean.a();
        if (g16 != null) {
            aVar2.f381151a = com.tencent.treasurecard.util.d.d(g16, "treasurecard_sp").getInt("treasurecard_state" + com.tencent.treasurecard.util.a.f381233a, -1);
        }
        this.f381203a.put(com.tencent.treasurecard.util.a.f381233a, aVar2);
        return aVar2;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        SharedPreferences d16 = com.tencent.treasurecard.util.d.d(((d) d.i()).g(), "treasurecard_sp");
        if ((System.currentTimeMillis() - d16.getLong(FtConstants.PC_ID_UPDATE_TIME + com.tencent.treasurecard.util.a.f381233a, 0L)) / 1000 > f381202b) {
            return null;
        }
        return d16.getString(FtConstants.PC_ID + com.tencent.treasurecard.util.a.f381233a, null);
    }

    public void c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        Context g16 = ((d) d.i()).g();
        com.tencent.treasurecard.bean.a aVar = this.f381203a.get(com.tencent.treasurecard.util.a.f381233a);
        if (aVar == null) {
            aVar = new com.tencent.treasurecard.bean.a();
            this.f381203a.put(com.tencent.treasurecard.util.a.f381233a, aVar);
        }
        aVar.f381151a = i3;
        if (g16 != null) {
            com.tencent.treasurecard.util.d.d(g16, "treasurecard_sp").edit().putInt("treasurecard_state" + com.tencent.treasurecard.util.a.f381233a, aVar.f381151a).apply();
        }
    }

    public void d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        Context g16 = ((d) d.i()).g();
        if (g16 != null) {
            com.tencent.treasurecard.util.d.d(g16, "treasurecard_sp").edit().putString(FtConstants.PC_ID + com.tencent.treasurecard.util.a.f381233a, str).putLong(FtConstants.PC_ID_UPDATE_TIME + com.tencent.treasurecard.util.a.f381233a, System.currentTimeMillis()).apply();
        }
    }
}
