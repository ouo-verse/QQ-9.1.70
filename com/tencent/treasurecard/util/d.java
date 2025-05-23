package com.tencent.treasurecard.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.vas.treasurecard.FtConstants;
import com.tencent.mobileqq.vaswebviewplugin.TreasureCardJsPlugin;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final d f381234a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13137);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f381234a = new d();
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static d c() {
        return f381234a;
    }

    public static SharedPreferences d(Context context, String str) {
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(context, "treasure_card_" + str, "vas_mmkv_configurations");
        if (!fromSpAdapter.getBoolean("migrate_flag", false)) {
            QMMKV.migrateToSpAdapter(context, str, "vas_mmkv_configurations");
            fromSpAdapter.edit().putBoolean("migrate_flag", true).apply();
        }
        return fromSpAdapter;
    }

    private void i(Long l3) {
        e().edit().putLong(FtConstants.TC_LAST_ACTIVE_TIME + a.f381233a, l3.longValue()).apply();
    }

    public void a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
            return;
        }
        l(0L);
        i(0L);
        j(-1);
        h("", "");
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return e().getInt(FtConstants.TREASURE_CARD + a.f381233a, -1);
    }

    public SharedPreferences e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return d(((com.tencent.treasurecard.manager.d) com.tencent.treasurecard.manager.d.i()).g(), FtConstants.TC_SP_NAME);
    }

    public Boolean f(Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) l3);
        }
        long j3 = e().getLong(FtConstants.TC_LAST_ACTIVE_TIME + a.f381233a, 0L);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis < j3 + l3.longValue()) {
            return Boolean.TRUE;
        }
        i(Long.valueOf(currentTimeMillis));
        return Boolean.FALSE;
    }

    public Boolean g(Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) l3);
        }
        long j3 = e().getLong(FtConstants.TC_NEXT_REQ_TIME + a.f381233a, 0L);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis < j3) {
            return Boolean.FALSE;
        }
        l(Long.valueOf(currentTimeMillis + l3.longValue()));
        return Boolean.TRUE;
    }

    public void h(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            return;
        }
        e().edit().putString(FtConstants.TC_ACTIVE_URL + a.f381233a, str).putString(FtConstants.TC_ACTIVE_TIPS + a.f381233a, str2).apply();
    }

    public void j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        e().edit().putInt(FtConstants.TREASURE_CARD + a.f381233a, i3).apply();
    }

    public void k(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) str);
            return;
        }
        SharedPreferences.Editor edit = e().edit();
        edit.putInt("flowThreshold", i3);
        edit.putString("flowThresholdText", str);
        edit.apply();
        Log.d(TreasureCardJsPlugin.BUSINESS_NAME, "updateFlowThreshold flowThreshold:$flowThreshold flowThresholdText:$flowThresholdText");
    }

    public void l(Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) l3);
            return;
        }
        e().edit().putLong(FtConstants.TC_NEXT_REQ_TIME + a.f381233a, l3.longValue()).apply();
    }
}
