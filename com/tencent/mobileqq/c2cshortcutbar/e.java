package com.tencent.mobileqq.c2cshortcutbar;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class e implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f200962d;

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<Long, List<b>> f200963e;

    /* renamed from: f, reason: collision with root package name */
    private ConcurrentHashMap<Long, Long> f200964f;

    /* renamed from: h, reason: collision with root package name */
    private ConcurrentHashMap<String, List<b>> f200965h;

    /* renamed from: i, reason: collision with root package name */
    private ConcurrentHashMap<String, Integer> f200966i;

    /* renamed from: m, reason: collision with root package name */
    private int f200967m;

    public e(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f200962d = qQAppInterface;
            i();
        }
    }

    public static e d(QQAppInterface qQAppInterface) {
        return (e) qQAppInterface.getManager(QQManagerFactory.C2C_SHORTCUT_BAR_MANAGER);
    }

    private void i() {
        this.f200963e = new ConcurrentHashMap<>();
        this.f200964f = new ConcurrentHashMap<>();
        this.f200965h = new ConcurrentHashMap<>(16);
        this.f200966i = new ConcurrentHashMap<>(16);
    }

    public boolean a(Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) l3)).booleanValue();
        }
        if (System.currentTimeMillis() / 1000 > e(l3).longValue()) {
            return true;
        }
        return false;
    }

    public List<b> b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (List) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        }
        if (QLog.isColorLevel()) {
            QLog.d("C2CShortcutBarSwitcher", 2, "getC2CShortcutBarStoreInfo() data = " + this.f200965h.get(str));
        }
        return this.f200965h.get(str);
    }

    public C2CShortcutBarHandler c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (C2CShortcutBarHandler) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return (C2CShortcutBarHandler) this.f200962d.getBusinessHandler(BusinessHandlerFactory.C2C_SHORTCUT_BAR_HANDLER);
    }

    public Long e(Long l3) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Long) iPatchRedirector.redirect((short) 3, (Object) this, (Object) l3);
        }
        Long l16 = this.f200964f.get(l3);
        if (l16 != null) {
            j3 = l16.longValue();
        } else {
            j3 = 0;
        }
        return Long.valueOf(j3);
    }

    public int f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).intValue();
        }
        if (this.f200966i.containsKey(str)) {
            return this.f200966i.get(str).intValue();
        }
        return 0;
    }

    public List<b> g(Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (List) iPatchRedirector.redirect((short) 12, (Object) this, (Object) l3);
        }
        List<b> list = this.f200963e.get(l3);
        int h16 = h();
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        if (list.size() > h16) {
            arrayList.addAll(list.subList(0, h16));
            b bVar = new b();
            bVar.f200937c = BaseApplication.getContext().getResources().getString(R.string.zgw);
            bVar.f200938d = "https://qzonestyle.gtimg.cn/aoi/sola/20191009150544_g1DgkNhLui.png";
            arrayList.add(bVar);
        } else {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f200967m;
    }

    public boolean j(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("C2CShortcutBarSwitcher", 2, "isClickManager() position =", Integer.valueOf(i3), " appListSize = ", Integer.valueOf(i16), " shortcutBarMaxAppNum =", Integer.valueOf(this.f200967m));
        }
        if (i3 != i16 - 1 || i16 <= this.f200967m) {
            return false;
        }
        return true;
    }

    public void k(String str, List<b> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) list);
        } else {
            this.f200965h.put(str, list);
        }
    }

    public void l(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Boolean.valueOf(z16), str);
        } else {
            c().J2(str, z16);
        }
    }

    public void m(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, i3);
        } else {
            this.f200966i.put(str, Integer.valueOf(i3));
        }
    }

    public void n(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("C2CShortcutBarSwitcher", 2, "setShortcutBarMaxAppNum " + i3);
        }
        if (i3 > 0) {
            this.f200967m = i3;
        }
    }

    public void o(Long l3, List<b> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) l3, (Object) list);
        } else {
            this.f200963e.put(l3, list);
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        this.f200965h.clear();
        this.f200965h = null;
        this.f200963e.clear();
        this.f200966i.clear();
    }

    public void p(Long l3, Long l16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) l3, (Object) l16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("C2CShortcutBarSwitcher", 2, "updateShortcutAppInfoReqTimeStamp friendUin = " + l3 + ",nextReqTimeStamp = " + l16);
        }
        this.f200964f.put(l3, l16);
    }
}
