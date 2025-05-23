package com.tencent.mobileqq.troop.utils;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.cl;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes19.dex */
public class bh implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, Integer> f302145d;

    /* renamed from: e, reason: collision with root package name */
    protected Handler f302146e;

    /* renamed from: f, reason: collision with root package name */
    QQAppInterface f302147f;

    public bh(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f302145d = new ConcurrentHashMap();
        this.f302147f = qQAppInterface;
        this.f302146e = new Handler(Looper.getMainLooper());
        b();
    }

    public int a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).intValue();
        }
        Integer num = this.f302145d.get(String.valueOf(str));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void b() {
        String[] split;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        String d16 = cl.d(this.f302147f.getApp(), "TroopVideoNotify");
        if (!TextUtils.isEmpty(d16) && (split = d16.split(";")) != null) {
            for (String str : split) {
                this.f302145d.put(str, 1);
            }
        }
    }

    public void c(long j3) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
            return;
        }
        Integer num = this.f302145d.get(String.valueOf(j3));
        int i16 = 0;
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        boolean S = this.f302147f.getAVNotifyCenter().S(j3);
        if (S && i3 == 0) {
            i16 = 1;
        } else if (S) {
            i16 = i3;
        }
        this.f302145d.put(String.valueOf(j3), Integer.valueOf(i16));
        if (i16 != i3) {
            d();
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        for (String str : this.f302145d.keySet()) {
            if (this.f302145d.get(str).intValue() == 1) {
                sb5.append(str);
                sb5.append(";");
            }
        }
        if (sb5.length() > 0) {
            cl.j(this.f302147f.getApp(), "TroopVideoNotify", sb5.substring(0, sb5.length() - 1).toString());
        } else {
            cl.j(this.f302147f.getApp(), "TroopVideoNotify", "");
        }
    }

    public void e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else if (a(str) == 1) {
            this.f302145d.put(str, 2);
            d();
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }
}
