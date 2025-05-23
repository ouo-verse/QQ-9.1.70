package com.tencent.mobileqq.subaccount.logic;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x7a2.oidb_0x7a2$RspBody;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f291121a;

    /* renamed from: b, reason: collision with root package name */
    public String f291122b;

    /* renamed from: c, reason: collision with root package name */
    public String f291123c;

    /* renamed from: d, reason: collision with root package name */
    public String f291124d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<String> f291125e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList<String> f291126f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<String> f291127g;

    /* renamed from: h, reason: collision with root package name */
    public Object f291128h;

    /* renamed from: i, reason: collision with root package name */
    public int f291129i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f291130j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f291131k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f291132l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f291133m;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f291121a = -99999;
        this.f291122b = null;
        this.f291123c = null;
        this.f291124d = null;
        this.f291125e = null;
        this.f291126f = null;
        this.f291127g = null;
        this.f291128h = null;
        this.f291129i = -99999;
        this.f291130j = true;
        this.f291131k = false;
        this.f291132l = false;
        this.f291133m = false;
    }

    public static a c(a aVar) {
        if (aVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "SubAccountBackProtocData.clone() return, backData == null.");
                return null;
            }
            return null;
        }
        a aVar2 = new a();
        aVar2.f291122b = aVar.f291122b;
        aVar2.f291121a = aVar.f291121a;
        aVar2.f291123c = aVar.f291123c;
        aVar2.f291124d = aVar.f291124d;
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = aVar.f291125e;
        if (arrayList2 != null) {
            arrayList.addAll(arrayList2);
        }
        aVar2.f291125e = arrayList;
        ArrayList<String> arrayList3 = new ArrayList<>();
        ArrayList<String> arrayList4 = aVar.f291126f;
        if (arrayList4 != null) {
            arrayList3.addAll(arrayList4);
        }
        aVar2.f291126f = arrayList3;
        ArrayList<String> arrayList5 = new ArrayList<>();
        ArrayList<String> arrayList6 = aVar.f291127g;
        if (arrayList6 != null) {
            arrayList5.addAll(arrayList6);
        }
        aVar2.f291127g = arrayList5;
        aVar2.f291128h = aVar.f291128h;
        aVar2.f291129i = aVar.f291129i;
        aVar2.f291130j = aVar.f291130j;
        aVar2.f291131k = aVar.f291131k;
        aVar2.f291132l = aVar.f291132l;
        aVar2.f291133m = aVar.f291133m;
        return aVar2;
    }

    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "SubAccountBackProtocData.addNewUin subUin=" + str);
        }
        if (str != null && str.length() >= 4) {
            if (this.f291125e == null) {
                this.f291125e = new ArrayList<>();
            }
            if (!this.f291125e.contains(str)) {
                this.f291125e.add(str);
            }
            if (this.f291126f == null) {
                this.f291126f = new ArrayList<>();
            }
            if (!this.f291126f.contains(str)) {
                this.f291126f.add(str);
            }
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "SubAccountBackProtocData.clearNewUins()");
        }
        ArrayList<String> arrayList = this.f291126f;
        if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList<String> arrayList2 = this.f291127g;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
    }

    public ArrayList<String> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = this.f291126f;
        if (arrayList2 != null) {
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    public ArrayList<String> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = this.f291127g;
        if (arrayList2 != null) {
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    public ArrayList<String> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        String str = this.f291124d;
        if (str != null && str.length() > 4) {
            if (this.f291125e == null) {
                this.f291125e = new ArrayList<>();
            }
            if (!this.f291125e.contains(this.f291124d)) {
                this.f291125e.add(0, this.f291124d);
            }
        } else {
            this.f291125e = null;
            if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "getUinsBinded() return null, mSubUin is null");
            }
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = this.f291125e;
        if (arrayList2 != null) {
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        ArrayList<String> arrayList = this.f291126f;
        if (arrayList != null && arrayList.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        ArrayList<String> arrayList = this.f291127g;
        if (arrayList != null && arrayList.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        String str = this.f291124d;
        if (str != null && str.length() > 4) {
            if (this.f291125e == null) {
                this.f291125e = new ArrayList<>();
            }
            if (!this.f291125e.contains(this.f291124d)) {
                this.f291125e.add(0, this.f291124d);
            }
        }
        ArrayList<String> arrayList = this.f291125e;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return true;
    }

    public void j(oidb_0x7a2$RspBody oidb_0x7a2_rspbody, ArrayList<String> arrayList) {
        List<Long> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) oidb_0x7a2_rspbody, (Object) arrayList);
            return;
        }
        if (oidb_0x7a2_rspbody == null) {
            return;
        }
        ArrayList<String> arrayList2 = this.f291125e;
        if (arrayList2 == null) {
            this.f291125e = new ArrayList<>();
        } else {
            arrayList2.clear();
        }
        if (oidb_0x7a2_rspbody.uint64_bind_uin.has() && oidb_0x7a2_rspbody.uint64_bind_uin.get() > 10000) {
            String l3 = Long.toString(oidb_0x7a2_rspbody.uint64_bind_uin.get());
            this.f291124d = l3;
            this.f291125e.add(l3);
        }
        if (oidb_0x7a2_rspbody.uint64_multi_bind_uin.has() && (list = oidb_0x7a2_rspbody.uint64_multi_bind_uin.get()) != null) {
            for (Long l16 : list) {
                if (l16.longValue() > 10000) {
                    String l17 = Long.toString(l16.longValue());
                    if (!this.f291125e.contains(l17)) {
                        this.f291125e.add(l17);
                    }
                    if (this.f291124d == null) {
                        this.f291124d = l17;
                    }
                }
            }
        }
        this.f291127g = new ArrayList<>();
        ArrayList<String> arrayList3 = new ArrayList<>();
        this.f291126f = arrayList3;
        arrayList3.addAll(this.f291125e);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!this.f291125e.contains(next)) {
                    this.f291127g.add(next);
                }
                this.f291126f.remove(next);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "SubAccountBackProtocData.parseUins() figure new subUins. localSubUins is null. new SubUins=" + String.valueOf(this.f291126f) + " overdue SubUins=" + String.valueOf(this.f291127g));
        }
    }
}
