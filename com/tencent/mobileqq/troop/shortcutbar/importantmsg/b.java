package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.view.View;
import com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private LeftAppShortcutBarPanel f298717a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a f298718b;

    /* renamed from: c, reason: collision with root package name */
    private TroopAppShortcutBarHelper f298719c;

    /* renamed from: d, reason: collision with root package name */
    private HashSet<Long> f298720d;

    /* renamed from: e, reason: collision with root package name */
    private HashSet<Long> f298721e;

    /* renamed from: f, reason: collision with root package name */
    private HashMap<Long, Long> f298722f;

    /* renamed from: g, reason: collision with root package name */
    private HashMap<Long, Long> f298723g;

    /* renamed from: h, reason: collision with root package name */
    private HashMap<Long, Long> f298724h;

    /* renamed from: i, reason: collision with root package name */
    private HashMap<Long, Long> f298725i;

    public b(a aVar, com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a aVar2, TroopAppShortcutBarHelper troopAppShortcutBarHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aVar, aVar2, troopAppShortcutBarHelper);
            return;
        }
        this.f298720d = new HashSet<>();
        this.f298721e = new HashSet<>();
        this.f298722f = new HashMap<>();
        this.f298723g = new HashMap<>();
        this.f298724h = new HashMap<>();
        this.f298725i = new HashMap<>();
        this.f298717a = (LeftAppShortcutBarPanel) aVar;
        this.f298718b = aVar2;
        this.f298719c = troopAppShortcutBarHelper;
    }

    private int d(long j3) {
        if (this.f298720d.contains(Long.valueOf(j3))) {
            return 1;
        }
        return 2;
    }

    public void a(Long l3, Long l16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) l3, (Object) l16);
        } else {
            this.f298722f.put(l3, l16);
            this.f298725i.put(l3, l16);
        }
    }

    public void b(Long l3, Long l16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) l3, (Object) l16);
        } else {
            this.f298724h.put(l3, l16);
        }
    }

    public void c(Long l3, Long l16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) l3, (Object) l16);
        } else {
            this.f298723g.put(l3, l16);
            this.f298725i.put(l3, l16);
        }
    }

    public void e(View view, int i3) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, i3);
            return;
        }
        if (this.f298719c != null && this.f298717a != null) {
            if (i3 == 0) {
                str = "0X800B19C";
            } else {
                str = "0X800B1A0";
            }
            String str2 = str;
            if (view.getTag() != null && (view.getTag() instanceof ShortcutBarInfo)) {
                ShortcutBarInfo shortcutBarInfo = (ShortcutBarInfo) view.getTag();
                ReportController.o(null, "dc00898", "", this.f298719c.p(), str2, str2, 0, 0, String.valueOf(shortcutBarInfo.getAppId()), String.valueOf(this.f298717a.n()), String.valueOf(d(shortcutBarInfo.getMsgSeq())), "");
                this.f298720d.add(Long.valueOf(shortcutBarInfo.getMsgSeq()));
            }
        }
    }

    public void f(View view, int i3) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
            return;
        }
        if (this.f298719c != null && this.f298717a != null) {
            if (i3 == 1) {
                str = "0X800B19F";
            } else {
                str = "0X800B19A";
            }
            String str2 = str;
            if (view.getTag() != null && (view.getTag() instanceof ShortcutBarInfo)) {
                ShortcutBarInfo shortcutBarInfo = (ShortcutBarInfo) view.getTag();
                ReportController.o(null, "dc00898", "", this.f298719c.p(), str2, str2, 0, 0, String.valueOf(shortcutBarInfo.getAppId()), "", String.valueOf(this.f298717a.n()), "");
                this.f298720d.add(Long.valueOf(shortcutBarInfo.getAppId()));
            }
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.f298720d.clear();
        this.f298721e.clear();
        this.f298719c = null;
        this.f298717a = null;
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        TroopAppShortcutBarHelper troopAppShortcutBarHelper = this.f298719c;
        if (troopAppShortcutBarHelper != null && this.f298717a != null) {
            ReportController.o(null, "dc00898", "", troopAppShortcutBarHelper.p(), "0X800B19D", "0X800B19D", 0, 0, "", "", "", "");
        }
    }

    public void i(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        TroopAppShortcutBarHelper troopAppShortcutBarHelper = this.f298719c;
        if (troopAppShortcutBarHelper != null && this.f298717a != null) {
            ReportController.o(null, "dc00898", "", troopAppShortcutBarHelper.p(), "0X800B19E", "0X800B19E", 0, 0, "", "", String.valueOf(i3), "");
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (this.f298723g.size() != 0 && this.f298719c != null && this.f298717a != null) {
            String str = "";
            for (Long l3 : this.f298724h.values()) {
                if (l3 != null) {
                    str = str + ";" + String.valueOf(l3);
                }
            }
            ReportController.o(null, "dc00898", "", this.f298719c.p(), "0X800B198", "0X800B198", 0, 0, String.valueOf(this.f298724h.size()), String.valueOf(this.f298717a.n()), str, String.valueOf(this.f298725i.size()));
            this.f298724h.clear();
            this.f298725i.clear();
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (this.f298722f.size() != 0 && this.f298719c != null && this.f298717a != null) {
            for (Long l3 : this.f298722f.values()) {
                if (l3 != null && !this.f298721e.contains(l3)) {
                    this.f298721e.add(l3);
                    ReportController.o(null, "dc00898", "", this.f298719c.p(), "0X800B199", "0X800B199", 0, 0, String.valueOf(l3), "", "", "");
                }
            }
            this.f298722f.clear();
        }
    }
}
