package com.tencent.mobileqq.qqgamepub.utils;

import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes16.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f264721a;

    /* renamed from: b, reason: collision with root package name */
    private String f264722b;

    /* renamed from: c, reason: collision with root package name */
    private CopyOnWriteArrayList<Pair<String, Long>> f264723c;

    public e(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
        } else {
            g(str, str2);
        }
    }

    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.f264723c.add(new Pair<>(str, Long.valueOf(SystemClock.elapsedRealtime())));
        }
    }

    public List<Long> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 1; i3 < this.f264723c.size(); i3++) {
            arrayList.add(Long.valueOf(this.f264723c.get(i3).second.longValue() - this.f264723c.get(i3 - 1).second.longValue()));
        }
        return arrayList;
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.d(this.f264721a, 1, this.f264722b + ": begin");
        try {
            long longValue = this.f264723c.get(0).second.longValue();
            long j3 = longValue;
            for (int i3 = 1; i3 < this.f264723c.size(); i3++) {
                j3 = this.f264723c.get(i3).second.longValue();
                String str = this.f264723c.get(i3).first;
                long longValue2 = this.f264723c.get(i3 - 1).second.longValue();
                QLog.d(this.f264721a, 1, this.f264722b + ":      " + (j3 - longValue2) + " ms, " + str);
            }
            QLog.d(this.f264721a, 1, this.f264722b + ": end, " + (j3 - longValue) + " ms");
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public long d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str)).longValue();
        }
        if (!TextUtils.isEmpty(str)) {
            Iterator<Pair<String, Long>> it = this.f264723c.iterator();
            while (it.hasNext()) {
                Pair<String, Long> next = it.next();
                if (next.first.equals(str)) {
                    return next.second.longValue();
                }
            }
            return 0L;
        }
        return 0L;
    }

    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<Pair<String, Long>> it = this.f264723c.iterator();
        while (it.hasNext()) {
            Pair<String, Long> next = it.next();
            String str = next.first;
            Long l3 = next.second;
            stringBuffer.append(str);
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(l3);
            stringBuffer.append("| ");
        }
        return stringBuffer.toString();
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        CopyOnWriteArrayList<Pair<String, Long>> copyOnWriteArrayList = this.f264723c;
        if (copyOnWriteArrayList == null) {
            this.f264723c = new CopyOnWriteArrayList<>();
        } else {
            copyOnWriteArrayList.clear();
        }
        a("begin");
    }

    public void g(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.f264721a = str;
        this.f264722b = str2;
        f();
    }
}
