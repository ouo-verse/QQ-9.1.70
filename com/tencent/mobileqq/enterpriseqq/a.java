package com.tencent.mobileqq.enterpriseqq;

import android.text.TextUtils;
import com.tencent.crmqq.structmsg.StructMsg$ButtonInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Long> f205325a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, Integer> f205326b;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, List<StructMsg$ButtonInfo>> f205327c;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f205328d;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f205325a = new HashMap();
        this.f205326b = new HashMap();
        this.f205327c = new HashMap();
        this.f205328d = new byte[1];
    }

    public int a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).intValue();
        }
        synchronized (this.f205328d) {
            if (!TextUtils.isEmpty(str) && this.f205326b.containsKey(str)) {
                return this.f205326b.get(str).intValue();
            }
            return -1;
        }
    }

    public long b(String str) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).longValue();
        }
        synchronized (this.f205328d) {
            if (!TextUtils.isEmpty(str) && this.f205325a.containsKey(str)) {
                j3 = this.f205325a.get(str).longValue();
            } else {
                j3 = -1;
            }
        }
        return j3;
    }

    public void c(String str, List<StructMsg$ButtonInfo> list, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, list, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f205328d) {
                if (this.f205327c.containsKey(str)) {
                    this.f205327c.remove(str);
                }
                this.f205327c.put(str, list);
                this.f205326b.put(str, Integer.valueOf(i3));
                this.f205325a.put(str, Long.valueOf(j3));
            }
        }
    }

    public void d(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Long.valueOf(j3));
        } else if (!TextUtils.isEmpty(str)) {
            synchronized (this.f205328d) {
                this.f205325a.put(str, Long.valueOf(j3));
            }
        }
    }
}
