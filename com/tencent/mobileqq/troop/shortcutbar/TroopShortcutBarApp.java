package com.tencent.mobileqq.troop.shortcutbar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import tencent.im.oidb.cmd0xe82.cmd0xe82$App;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopShortcutBarApp extends ShortcutBarInfo {
    static IPatchRedirector $redirector_;
    private String adId;
    private boolean add_point;
    private long add_ts;
    private String app_url;
    private int appid_unreadNum;
    private boolean need_scroll;

    public TroopShortcutBarApp(long j3, String str, String str2, int i3) {
        super(j3, str, str2, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), str, str2, Integer.valueOf(i3));
            return;
        }
        this.appid_unreadNum = 0;
        this.add_ts = 0L;
        this.add_point = false;
        this.need_scroll = false;
        this.adId = "";
    }

    public static TroopShortcutBarApp convertPbToShortcutBarApp(cmd0xe82$App cmd0xe82_app) {
        long j3;
        String str;
        if (cmd0xe82_app != null) {
            if (cmd0xe82_app.appid.has()) {
                j3 = cmd0xe82_app.appid.get();
            } else {
                j3 = 0;
            }
            long j16 = j3;
            if (cmd0xe82_app.url.has()) {
                str = cmd0xe82_app.url.get();
            } else {
                str = "";
            }
            TroopShortcutBarApp troopShortcutBarApp = new TroopShortcutBarApp(j16, cmd0xe82_app.name.get(), cmd0xe82_app.icon.get(), cmd0xe82_app.show_frame.get());
            troopShortcutBarApp.app_url = str;
            troopShortcutBarApp.appid_unreadNum = cmd0xe82_app.redpoint.get();
            troopShortcutBarApp.add_ts = cmd0xe82_app.add_ts.get();
            troopShortcutBarApp.adId = cmd0xe82_app.ad_id.get();
            return troopShortcutBarApp;
        }
        return null;
    }

    public static TroopShortcutBarApp createManagerShortcutBarApp(String str, String str2) {
        TroopShortcutBarApp troopShortcutBarApp = new TroopShortcutBarApp(999L, str, str2, 0);
        troopShortcutBarApp.app_url = "local";
        return troopShortcutBarApp;
    }

    public String getAdId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.adId;
    }

    public boolean getAddPoint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.add_point;
    }

    public int getAppIdUnreadNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.appid_unreadNum;
    }

    public String getAppUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.app_url;
    }

    public boolean getNeedScroll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.need_scroll;
    }

    public long getaddts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.add_ts;
    }

    public void setAddPoint(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.add_point = z16;
        }
    }

    public void setAppidUnReadNum(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.appid_unreadNum = i3;
        }
    }

    public void setNeedScroll(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.need_scroll = z16;
        }
    }
}
