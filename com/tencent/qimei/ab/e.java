package com.tencent.qimei.ab;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.aa.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static volatile e f342924d;

    /* renamed from: a, reason: collision with root package name */
    public AtomicBoolean f342925a;

    /* renamed from: b, reason: collision with root package name */
    public String f342926b;

    /* renamed from: c, reason: collision with root package name */
    public String f342927c;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f342925a = new AtomicBoolean(false);
        }
    }

    public static e a() {
        if (f342924d == null) {
            synchronized (e.class) {
                if (f342924d == null) {
                    f342924d = new e();
                }
            }
        }
        return f342924d;
    }

    public final void b(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            return;
        }
        com.tencent.qimei.aa.b bVar = b.a.f342891a;
        if (bVar.a() == null ? false : bVar.f342889a.contains(str2)) {
            return;
        }
        String d16 = com.tencent.qimei.aa.f.b(str).d(str2);
        if (TextUtils.isEmpty(d16)) {
            return;
        }
        com.tencent.qimei.aa.f.b(str).a(str2);
        if (d16.length() <= 1024 && bVar.a() != null) {
            bVar.f342889a.edit().putString(str2, d16).apply();
        }
    }

    public String a(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
        }
        if (!this.f342925a.get()) {
            a(str);
        }
        return str2.equals("c_f_uptimes") ? this.f342926b : str2.equals("c_f_bootids") ? this.f342927c : "";
    }

    public final boolean a(LinkedList<String> linkedList, String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) linkedList, (Object) str)).booleanValue();
        }
        if ((linkedList.size() == 0 || !linkedList.getFirst().equals(str)) && !TextUtils.isEmpty(str)) {
            linkedList.addFirst(str);
            z16 = true;
        } else {
            z16 = false;
        }
        if (linkedList.size() > 5) {
            linkedList.remove(linkedList.size() - 1);
        }
        return z16;
    }

    public synchronized void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        if (this.f342925a.get()) {
            return;
        }
        com.tencent.qimei.aa.f b16 = com.tencent.qimei.aa.f.b(str);
        if (!(b16.a() == null ? false : b16.f342905a.contains("f_uptimes"))) {
            com.tencent.qimei.aa.f.b(str).a("f_uptimes");
        }
        b(str, "c_f_uptimes");
        b(str, "c_f_bootids");
        this.f342926b = b("c_f_uptimes");
        this.f342927c = b("c_f_bootids");
        this.f342925a.set(true);
    }

    public final String b(String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        com.tencent.qimei.aa.b bVar = b.a.f342891a;
        String str3 = "";
        if (bVar.a() == null || (str2 = bVar.f342889a.getString(str, "")) == null) {
            str2 = "";
        }
        LinkedList<String> linkedList = new LinkedList<>();
        for (String str4 : str2.split(";")) {
            if (!str4.isEmpty()) {
                linkedList.add(str4);
            }
        }
        if (str.equals("c_f_uptimes")) {
            str3 = String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
        } else {
            str.equals("c_f_bootids");
        }
        boolean a16 = a(linkedList, str3);
        StringBuilder sb5 = new StringBuilder();
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            sb5.append(it.next());
            sb5.append(";");
        }
        if (!linkedList.isEmpty()) {
            sb5.deleteCharAt(sb5.length() - 1);
        }
        String sb6 = sb5.toString();
        if (a16) {
            com.tencent.qimei.aa.b bVar2 = b.a.f342891a;
            if (bVar2.a() != null) {
                bVar2.f342889a.edit().putString(str, sb6).apply();
            }
        }
        return sb6;
    }
}
