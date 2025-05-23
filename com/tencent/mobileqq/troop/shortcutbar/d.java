package com.tencent.mobileqq.troop.shortcutbar;

import com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.shortcutbar.essencemsg.EssenceMsgProcessor;
import com.tencent.mobileqq.troop.shortcutbar.importantmsg.FansBeatRankProcessor;
import com.tencent.mobileqq.troop.shortcutbar.importantmsg.QCircleMsgProcessor;
import com.tencent.mobileqq.troop.shortcutbar.trooptopic.m;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d extends com.tencent.mobileqq.troop.shortcutbar.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a f298625a;

    /* renamed from: b, reason: collision with root package name */
    private TroopAppShortcutBarHelper f298626b;

    /* renamed from: c, reason: collision with root package name */
    private CopyOnWriteArrayList<c> f298627c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<Integer> f298628d;

    /* renamed from: e, reason: collision with root package name */
    private HashMap<Integer, ArrayList<ShortcutBarInfo>> f298629e;

    /* renamed from: f, reason: collision with root package name */
    private AppRuntime f298630f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f298631g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements Comparator<ArrayList<ShortcutBarInfo>> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ArrayList<ShortcutBarInfo> arrayList, ArrayList<ShortcutBarInfo> arrayList2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList, (Object) arrayList2)).intValue();
            }
            return arrayList2.get(0).getPriority() - arrayList.get(0).getPriority();
        }
    }

    public d(com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a aVar, TroopAppShortcutBarHelper troopAppShortcutBarHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) troopAppShortcutBarHelper);
            return;
        }
        this.f298627c = new CopyOnWriteArrayList<>();
        this.f298628d = new ArrayList<>();
        this.f298629e = new HashMap<>();
        this.f298631g = false;
        this.f298625a = aVar;
        this.f298626b = troopAppShortcutBarHelper;
        r();
        p();
        this.f298630f = aVar.d();
    }

    private void j(int i3, ArrayList<ShortcutBarInfo> arrayList) {
        ArrayList<ShortcutBarInfo> arrayList2;
        TroopShortcutBarApp k3;
        if (i3 == 0) {
            arrayList2 = this.f298629e.get(2);
        } else {
            arrayList = this.f298629e.get(0);
            arrayList2 = arrayList;
        }
        if (arrayList != null && arrayList2 != null) {
            Iterator<ShortcutBarInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                ShortcutBarInfo next = it.next();
                Iterator<ShortcutBarInfo> it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    if (next.getAppId() == it5.next().getAppId() && (k3 = k(next)) != null) {
                        k3.setAddPoint(false);
                        k3.setAppidUnReadNum(0);
                    }
                }
            }
        }
    }

    private TroopShortcutBarApp k(ShortcutBarInfo shortcutBarInfo) {
        if (!(shortcutBarInfo instanceof TroopShortcutBarApp)) {
            return null;
        }
        return (TroopShortcutBarApp) shortcutBarInfo;
    }

    private ArrayList<ShortcutBarInfo> l() {
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = this.f298628d.iterator();
        while (it.hasNext()) {
            ArrayList<ShortcutBarInfo> arrayList2 = this.f298629e.get(Integer.valueOf(it.next().intValue()));
            if (arrayList2 != null && arrayList2.size() > 0) {
                arrayList.add(arrayList2);
            }
        }
        Collections.sort(arrayList, new a());
        ArrayList<ShortcutBarInfo> arrayList3 = new ArrayList<>();
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            ArrayList arrayList4 = (ArrayList) it5.next();
            if (arrayList4 != null) {
                arrayList3.addAll(arrayList4);
            }
        }
        return arrayList3;
    }

    private void r() {
        if (this.f298626b.f178724s) {
            s();
            return;
        }
        m();
        q();
        o();
        n();
        s();
    }

    private void t() {
        this.f298627c.clear();
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.a
    public void a(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, str, Long.valueOf(j3));
            return;
        }
        TroopAppShortcutBarHelper troopAppShortcutBarHelper = this.f298626b;
        if (troopAppShortcutBarHelper != null) {
            troopAppShortcutBarHelper.d(str, j3);
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.a
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        try {
            Iterator<c> it = this.f298627c.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        } catch (Exception e16) {
            QLog.e("ShortBarDataProvider", 1, "loadData error", e16);
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.b
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        Iterator<c> it = this.f298627c.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
        this.f298628d.clear();
        t();
        this.f298629e.clear();
        this.f298625a = null;
        this.f298626b = null;
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.b
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        Iterator<c> it = this.f298627c.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.a
    public void e(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, obj);
            return;
        }
        Iterator<c> it = this.f298627c.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null) {
                next.b(obj);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.a
    public void f(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, obj);
            return;
        }
        Iterator<c> it = this.f298627c.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null) {
                next.e(obj);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.a
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        try {
            Iterator<c> it = this.f298627c.iterator();
            while (it.hasNext()) {
                it.next().f();
            }
        } catch (Exception e16) {
            QLog.e("ShortBarDataProvider", 1, "onPause error", e16);
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.a
    public void i(int i3, ArrayList<ShortcutBarInfo> arrayList, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), arrayList, Boolean.valueOf(z16));
            return;
        }
        if (this.f298625a != null && this.f298626b != null) {
            if (QLog.isColorLevel()) {
                QLog.d("ShortBarDataProvider", 2, "updatePanel. from:" + i3 + ", list:" + arrayList + ", bShowManageBtn:" + z16);
            }
            if (i3 == 6) {
                if (arrayList != null && arrayList.size() > 0) {
                    this.f298626b.G(6, arrayList, z16);
                    return;
                }
                this.f298626b.u();
                this.f298626b.G(1, l(), z16);
                this.f298626b.G(0, this.f298629e.get(0), this.f298631g);
                return;
            }
            this.f298629e.put(Integer.valueOf(i3), arrayList);
            j(i3, arrayList);
            if (this.f298628d.contains(Integer.valueOf(i3))) {
                this.f298626b.G(1, l(), z16);
                this.f298626b.G(0, this.f298629e.get(0), this.f298631g);
            } else {
                this.f298631g = z16;
                this.f298626b.G(0, arrayList, z16);
                this.f298626b.G(1, l(), false);
            }
        }
    }

    protected void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f298627c.add(new com.tencent.mobileqq.troop.shortcutbar.troopapp.c(this.f298625a, this));
        }
    }

    protected void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a aVar = this.f298625a;
        if (aVar != null && aVar.b() == 3) {
            this.f298627c.add(new EssenceMsgProcessor(this.f298625a, this));
        }
    }

    protected void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f298627c.add(new FansBeatRankProcessor(this.f298625a, this));
        }
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f298628d.add(2);
        this.f298628d.add(3);
        this.f298628d.add(4);
        this.f298628d.add(5);
    }

    protected void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f298627c.add(new QCircleMsgProcessor(this.f298625a, this));
        }
    }

    protected void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a aVar = this.f298625a;
        if (aVar != null && aVar.b() == 3) {
            this.f298627c.add(new m(this.f298625a, this));
        }
    }
}
