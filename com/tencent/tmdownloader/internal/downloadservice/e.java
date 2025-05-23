package com.tencent.tmdownloader.internal.downloadservice;

import android.text.TextUtils;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.tmassistantbase.util.r;
import common.config.service.QzoneConfig;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected static e f380711d;

    /* renamed from: a, reason: collision with root package name */
    protected boolean f380712a;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f380713b;

    /* renamed from: c, reason: collision with root package name */
    protected int f380714c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(TVKEventId.PLAYER_STATE_CGI_START);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f380712a = true;
        this.f380713b = false;
        this.f380714c = 5;
        d();
    }

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            if (f380711d == null) {
                f380711d = new e();
            }
            eVar = f380711d;
        }
        return eVar;
    }

    private void d() {
        HashMap<String, String> a16 = com.tencent.tmdownloader.internal.storage.table.d.a();
        String str = a16.get("isTaskAutoResume");
        if (str != null && str.length() > 0) {
            this.f380712a = !str.equals("false");
        }
        String str2 = a16.get("isDownloadWifiOnly");
        if (str2 != null && str2.length() > 0) {
            this.f380713b = !str2.equals("false");
        }
        String str3 = a16.get("maxTaskNum");
        if (str3 != null && str3.length() > 0) {
            this.f380714c = Integer.valueOf(str3).intValue();
        }
    }

    public void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        e eVar = f380711d;
        if (eVar.f380712a == z16) {
            return;
        }
        eVar.f380712a = z16;
        com.tencent.tmdownloader.internal.storage.table.d.a("isTaskAutoResume", String.valueOf(z16), HippyControllerProps.BOOLEAN);
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.f380712a) {
            String a16 = b.a();
            if (a16.contains("wifi") || a16.contains("net")) {
                return true;
            }
            return false;
        }
        if (b.a().contains("wifi")) {
            return true;
        }
        return false;
    }

    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        e eVar = f380711d;
        if (eVar.f380713b == z16) {
            return;
        }
        eVar.f380713b = z16;
        com.tencent.tmdownloader.internal.storage.table.d.a("isDownloadWifiOnly", String.valueOf(z16), HippyControllerProps.BOOLEAN);
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? this.f380713b : ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
    }

    public boolean b(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        r.b(QzoneConfig.MAIN_KEY_DOWNLOAD_SETTING, "isAutoPause downloadInfoNetType = " + str + ",currentNetType = " + str2);
        return (TextUtils.isEmpty(str) || !str.equalsIgnoreCase(Global.TRACKING_WIFI) || str2.equalsIgnoreCase(Global.TRACKING_WIFI)) ? false : true;
    }

    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        e eVar = f380711d;
        if (eVar.f380714c == i3) {
            return;
        }
        eVar.f380714c = i3;
        com.tencent.tmdownloader.internal.storage.table.d.a("maxTaskNum", String.valueOf(i3), "Integer");
    }

    public boolean a(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        r.b(QzoneConfig.MAIN_KEY_DOWNLOAD_SETTING, "isAutoDownload downloadInfoNetType = " + str + ",currentNetType = " + str2);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str2.equalsIgnoreCase(Global.TRACKING_WIFI)) {
            return true;
        }
        return str2.contains("net") && !str.equalsIgnoreCase(Global.TRACKING_WIFI);
    }
}
