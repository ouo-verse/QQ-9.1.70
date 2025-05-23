package com.tencent.mobileqq.bubble;

import com.tencent.mobileqq.bubble.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f200644a;

    /* renamed from: b, reason: collision with root package name */
    public String f200645b;

    /* renamed from: c, reason: collision with root package name */
    public int f200646c;

    /* renamed from: d, reason: collision with root package name */
    public int f200647d;

    /* renamed from: e, reason: collision with root package name */
    public int f200648e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f200649f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f200650g;

    /* renamed from: h, reason: collision with root package name */
    public double f200651h;

    /* renamed from: i, reason: collision with root package name */
    public a f200652i;

    /* renamed from: j, reason: collision with root package name */
    public a f200653j;

    /* renamed from: k, reason: collision with root package name */
    public a f200654k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList<a> f200655l;

    /* renamed from: m, reason: collision with root package name */
    public a f200656m;

    /* renamed from: n, reason: collision with root package name */
    public a f200657n;

    /* renamed from: o, reason: collision with root package name */
    public a f200658o;

    /* renamed from: p, reason: collision with root package name */
    public HashSet<String> f200659p;

    /* renamed from: q, reason: collision with root package name */
    @Deprecated
    public g.a f200660q;

    /* renamed from: r, reason: collision with root package name */
    public HashMap<String, g> f200661r;

    /* renamed from: s, reason: collision with root package name */
    public ArrayList<Integer> f200662s;

    /* renamed from: t, reason: collision with root package name */
    public int f200663t;

    /* renamed from: u, reason: collision with root package name */
    public int f200664u;

    /* renamed from: v, reason: collision with root package name */
    public int f200665v;

    /* renamed from: w, reason: collision with root package name */
    public ArrayList<String> f200666w;

    /* renamed from: x, reason: collision with root package name */
    public HashMap<String, d> f200667x;

    public b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        this.f200644a = 0;
        this.f200659p = new HashSet<>();
        this.f200661r = new HashMap<>(4);
        this.f200662s = null;
        this.f200663t = 0;
        this.f200664u = -1;
        this.f200665v = 2;
        this.f200666w = null;
        this.f200667x = null;
        this.f200644a = i3;
    }

    private boolean c(File file, String str) {
        String[] list;
        File file2 = new File(file, str);
        if (!file2.exists() || !file2.isDirectory() || (list = file2.list()) == null || list.length <= 0) {
            return false;
        }
        return true;
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        if (d()) {
            return this.f200662s.get(this.f200663t).intValue();
        }
        return -1;
    }

    public boolean b(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) file)).booleanValue();
        }
        Iterator<String> it = this.f200659p.iterator();
        while (it.hasNext()) {
            if (c(file, it.next())) {
                return true;
            }
        }
        return false;
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        ArrayList<Integer> arrayList = this.f200662s;
        if (arrayList != null && arrayList.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3)).booleanValue();
        }
        ArrayList<Integer> arrayList = this.f200662s;
        if (arrayList != null && arrayList.contains(Integer.valueOf(i3))) {
            return true;
        }
        return false;
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (d()) {
            this.f200663t = (this.f200663t + 1) % this.f200662s.size();
            if (QLog.isColorLevel()) {
                QLog.i("BubbleConfig", 2, "now change bubble sub id: " + this.f200662s.get(this.f200663t));
                return;
            }
            return;
        }
        this.f200663t = 0;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[ bubbleId=" + this.f200644a);
        stringBuffer.append(",");
        stringBuffer.append("name=" + this.f200645b);
        stringBuffer.append(" ]");
        return stringBuffer.toString();
    }
}
