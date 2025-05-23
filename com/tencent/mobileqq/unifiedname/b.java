package com.tencent.mobileqq.unifiedname;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final a f305805a;

    /* renamed from: b, reason: collision with root package name */
    public final List<a> f305806b;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f305805a = new a();
            this.f305806b = new ArrayList();
        }
    }

    public Object clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this);
        }
        b bVar = new b();
        bVar.f305805a.a(this.f305805a);
        for (int i3 = 0; i3 < this.f305806b.size(); i3++) {
            bVar.f305806b.add((a) this.f305806b.get(i3).clone());
        }
        return bVar;
    }

    public boolean equals(Object obj) {
        int size;
        int size2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, obj)).booleanValue();
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!Utils.p(bVar.f305805a, this.f305805a)) {
            return false;
        }
        List<a> list = this.f305806b;
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        List<a> list2 = bVar.f305806b;
        if (list2 == null) {
            size2 = 0;
        } else {
            size2 = list2.size();
        }
        if (size != size2) {
            return false;
        }
        boolean z16 = true;
        for (int i3 = 0; z16 && i3 < size; i3++) {
            if (!Utils.p(this.f305806b.get(i3), bVar.f305806b.get(i3))) {
                z16 = false;
            }
        }
        return z16;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        try {
            sb5.append(String.format("[head] type=%s value=%s\n", Integer.valueOf(this.f305805a.f305803a), Utils.U(this.f305805a.f305804b)));
            int size = this.f305806b.size();
            for (int i3 = 0; i3 < size; i3++) {
                a aVar = this.f305806b.get(i3);
                if (aVar != null) {
                    sb5.append(String.format("[more item] type=%s value=%s\n", Integer.valueOf(aVar.f305803a), Utils.U(aVar.f305804b)));
                }
            }
        } catch (Exception e16) {
            QLog.e("MQQProfileName", 1, "toString fail.", e16);
        }
        return sb5.toString();
    }
}
