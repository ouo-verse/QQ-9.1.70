package com.tencent.mobileqq.troop.troopapps.data;

import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.utils.j;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f299426a;

    /* renamed from: b, reason: collision with root package name */
    public String f299427b;

    /* renamed from: c, reason: collision with root package name */
    public int f299428c;

    /* renamed from: d, reason: collision with root package name */
    public ConcurrentHashMap<Integer, TroopAIOAppInfo> f299429d;

    /* renamed from: e, reason: collision with root package name */
    private List<TroopAIOAppInfo> f299430e;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f299426a = 0;
        this.f299427b = "";
        this.f299428c = 0;
        this.f299429d = new ConcurrentHashMap<>();
        this.f299430e = new ArrayList();
    }

    public synchronized void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f299430e.clear();
        }
    }

    public synchronized ArrayList<TroopAIOAppInfo> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new ArrayList<>(this.f299430e);
    }

    public synchronized boolean c(List<Integer> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) list)).booleanValue();
        }
        if (this.f299430e.size() != list.size()) {
            return true;
        }
        ListIterator<TroopAIOAppInfo> listIterator = this.f299430e.listIterator();
        ListIterator<Integer> listIterator2 = list.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().appid != listIterator2.next().intValue()) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_TROOP_APP, 2, "makeAppidsInOrder() app order changed!");
                }
                return true;
            }
        }
        return false;
    }

    public synchronized boolean d(TroopAIOAppInfo troopAIOAppInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopAIOAppInfo)).booleanValue();
        }
        return this.f299430e.remove(troopAIOAppInfo);
    }

    public synchronized void e(List<Integer> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list, i3);
            return;
        }
        this.f299430e.clear();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            TroopAIOAppInfo troopAIOAppInfo = this.f299429d.get(Integer.valueOf(intValue));
            j.b(troopAIOAppInfo);
            if (troopAIOAppInfo != null) {
                this.f299430e.add(troopAIOAppInfo);
            } else {
                TroopAIOAppInfo troopAIOAppInfo2 = new TroopAIOAppInfo();
                troopAIOAppInfo2.appid = intValue;
                troopAIOAppInfo2.groupType = i3;
                f(intValue, troopAIOAppInfo2);
            }
        }
    }

    public void f(int i3, TroopAIOAppInfo troopAIOAppInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) troopAIOAppInfo);
            return;
        }
        TroopAIOAppInfo troopAIOAppInfo2 = this.f299429d.get(Integer.valueOf(i3));
        if (troopAIOAppInfo2 != null) {
            troopAIOAppInfo2.copyFrom(troopAIOAppInfo);
            return;
        }
        this.f299429d.put(Integer.valueOf(i3), troopAIOAppInfo);
        synchronized (this) {
            this.f299430e.add(troopAIOAppInfo);
        }
    }
}
