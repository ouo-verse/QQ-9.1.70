package com.tencent.hlyyb.downloader.e;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f114569a;

    /* renamed from: b, reason: collision with root package name */
    public long f114570b;

    /* renamed from: c, reason: collision with root package name */
    public volatile long f114571c;

    /* renamed from: d, reason: collision with root package name */
    public volatile long f114572d;

    /* renamed from: e, reason: collision with root package name */
    public volatile long f114573e;

    /* renamed from: f, reason: collision with root package name */
    public String f114574f;

    /* renamed from: g, reason: collision with root package name */
    public String f114575g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f114576h;

    /* renamed from: i, reason: collision with root package name */
    public List<i> f114577i;

    /* renamed from: j, reason: collision with root package name */
    public List<i> f114578j;

    /* renamed from: k, reason: collision with root package name */
    public volatile long f114579k;

    /* renamed from: l, reason: collision with root package name */
    public volatile int f114580l;

    public g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f114569a = -1L;
        this.f114570b = 0L;
        this.f114571c = 0L;
        this.f114572d = 0L;
        this.f114573e = 0L;
        this.f114574f = "";
        this.f114575g = "";
        this.f114576h = false;
        this.f114577i = new LinkedList();
        this.f114578j = new LinkedList();
        this.f114579k = 0L;
        this.f114580l = 0;
        this.f114576h = false;
        try {
            if (!TextUtils.isEmpty(str)) {
                try {
                    String[] split = str.split("\\|");
                    if (split == null || split.length == 0 || !split[0].equals("3.0") || split.length < 7) {
                        return;
                    }
                    try {
                        this.f114569a = Long.parseLong(split[1]);
                        this.f114571c = Long.parseLong(split[2]);
                        this.f114572d = Long.parseLong(split[3]);
                        this.f114573e = Long.parseLong(split[4]);
                        for (String str2 : split[5].split(";")) {
                            i iVar = new i(this, str2);
                            if (iVar.f114632a) {
                                this.f114577i.add(iVar);
                            } else {
                                this.f114577i.clear();
                                return;
                            }
                        }
                        if (split.length >= 9) {
                            a(split[7]);
                            b(split[8]);
                        }
                        if (split.length >= 11) {
                            for (String str3 : split[9].split(";")) {
                                i iVar2 = new i(this, str3);
                                if (iVar2.f114632a) {
                                    this.f114578j.add(iVar2);
                                } else {
                                    this.f114578j.clear();
                                }
                            }
                            try {
                                String[] split2 = split[10].split(";");
                                this.f114579k = Long.parseLong(split2[0]);
                                this.f114580l = Integer.parseInt(split2[1]);
                            } catch (Throwable th5) {
                                th5.printStackTrace();
                                return;
                            }
                        }
                    } catch (NumberFormatException e16) {
                        e16.printStackTrace();
                        return;
                    }
                } catch (Exception unused) {
                    return;
                }
            }
            this.f114570b = m();
            this.f114576h = true;
        } catch (Exception e17) {
            this.f114576h = false;
            e17.printStackTrace();
        }
    }

    private i j() {
        i iVar;
        i iVar2;
        synchronized (this.f114577i) {
            if (this.f114577i.size() == 0) {
                iVar2 = new i(this, 0L, 0L, 0L, -1L);
            } else {
                i iVar3 = this.f114577i.get(0);
                Iterator<i> it = this.f114577i.iterator();
                while (true) {
                    if (it.hasNext()) {
                        iVar = it.next();
                        if (!iVar.f114639h) {
                            long j3 = this.f114569a;
                            if (iVar.f114638g != -1) {
                                j3 = iVar.f114638g;
                            }
                            if (j3 - iVar.f114637f > 0) {
                                break;
                            }
                        }
                        long j16 = this.f114569a;
                        if (iVar.f114638g != -1) {
                            j16 = iVar.f114638g;
                        }
                        long j17 = j16 - iVar.f114637f;
                        long j18 = this.f114569a;
                        if (iVar3.f114638g != -1) {
                            j18 = iVar3.f114638g;
                        }
                        if (j17 > j18 - iVar3.f114637f) {
                            iVar3 = iVar;
                        }
                    } else {
                        iVar = null;
                        break;
                    }
                }
                if (iVar == null) {
                    long j19 = this.f114569a;
                    if (iVar3.f114638g != -1) {
                        j19 = iVar3.f114638g;
                    }
                    long j26 = j19 - iVar3.f114637f;
                    long j27 = iVar3.f114637f;
                    if (j26 > (com.tencent.hlyyb.downloader.a.b.a() << 1)) {
                        long j28 = j27 + (j26 / 2);
                        i iVar4 = new i(this, j28, j28, j28, iVar3.f114638g);
                        iVar4.f114634c = iVar3.f114633b;
                        iVar2 = iVar4;
                    } else {
                        iVar2 = null;
                    }
                } else {
                    iVar2 = iVar;
                }
            }
            if (iVar2 != null) {
                iVar2.f114639h = true;
            }
        }
        return iVar2;
    }

    private i k() {
        i iVar;
        synchronized (this.f114578j) {
            Iterator<i> it = this.f114578j.iterator();
            while (true) {
                if (it.hasNext()) {
                    iVar = it.next();
                    if (!iVar.f114639h && iVar.f114637f != iVar.f114638g) {
                        break;
                    }
                } else {
                    iVar = null;
                    break;
                }
            }
            if (iVar != null) {
                iVar.f114639h = true;
            }
        }
        return iVar;
    }

    private long l() {
        long j3;
        long j16;
        long j17;
        synchronized (this.f114577i) {
            j3 = 0;
            for (i iVar : this.f114577i) {
                j3 += iVar.f114636e - iVar.f114635d;
            }
        }
        synchronized (this.f114578j) {
            j16 = 0;
            for (i iVar2 : this.f114578j) {
                j16 += iVar2.f114638g - iVar2.f114635d;
            }
            j17 = 0;
            for (i iVar3 : this.f114578j) {
                j17 += iVar3.f114636e - iVar3.f114635d;
            }
        }
        long j18 = (j3 - j16) + j17;
        if (j18 <= 0) {
            return 0L;
        }
        return j18;
    }

    private long m() {
        long j3;
        synchronized (this.f114577i) {
            j3 = 0;
            for (i iVar : this.f114577i) {
                j3 += iVar.f114636e - iVar.f114635d;
            }
        }
        synchronized (this.f114578j) {
            for (i iVar2 : this.f114578j) {
                j3 += iVar2.f114636e - iVar2.f114635d;
            }
        }
        return j3;
    }

    public final i a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (i) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        i j3 = j();
        return j3 != null ? j3 : k();
    }

    public final int b() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        synchronized (this.f114578j) {
            i3 = 0;
            for (i iVar : this.f114578j) {
                i3 = (int) (i3 + (iVar.f114636e - iVar.f114635d));
            }
        }
        return i3;
    }

    public final String c() {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder("3.0");
        sb5.append("|");
        sb5.append(this.f114569a);
        sb5.append("|");
        sb5.append(this.f114571c);
        sb5.append("|");
        sb5.append(this.f114572d);
        sb5.append("|");
        sb5.append(this.f114573e);
        sb5.append("|");
        synchronized (this.f114577i) {
            Iterator<i> it = this.f114577i.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().a());
                sb5.append(";");
            }
            if (this.f114577i.size() > 0) {
                sb5.deleteCharAt(sb5.length() - 1);
            }
        }
        sb5.append("|");
        sb5.append("null");
        sb5.append("|");
        if (TextUtils.isEmpty(this.f114574f)) {
            str = "null";
        } else {
            str = this.f114574f;
        }
        sb5.append(str);
        sb5.append("|");
        if (TextUtils.isEmpty(this.f114575g)) {
            str2 = "null";
        } else {
            str2 = this.f114575g;
        }
        sb5.append(str2);
        sb5.append("|");
        synchronized (this.f114578j) {
            Iterator<i> it5 = this.f114578j.iterator();
            while (it5.hasNext()) {
                sb5.append(it5.next().a());
                sb5.append(";");
            }
            if (this.f114578j.size() > 0) {
                sb5.deleteCharAt(sb5.length() - 1);
            }
        }
        sb5.append("|");
        sb5.append(this.f114579k + ";" + this.f114580l);
        return sb5.toString();
    }

    public final long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
        }
        return l();
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        long j3 = this.f114569a;
        if (j3 > 0 && j3 == l()) {
            return true;
        }
        return false;
    }

    public final long f() {
        long j3;
        long j16;
        long j17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
        }
        synchronized (this.f114577i) {
            j3 = 0;
            for (i iVar : this.f114577i) {
                j3 += iVar.f114637f - iVar.f114635d;
            }
        }
        synchronized (this.f114578j) {
            j16 = 0;
            for (i iVar2 : this.f114578j) {
                j16 += iVar2.f114638g - iVar2.f114635d;
            }
            j17 = 0;
            for (i iVar3 : this.f114578j) {
                j17 += iVar3.f114637f - iVar3.f114635d;
            }
        }
        long j18 = (j3 - j16) + j17;
        if (j18 <= 0) {
            return 0L;
        }
        return j18;
    }

    public final long g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
        }
        return m() - this.f114570b;
    }

    public final long h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this)).longValue();
        }
        return this.f114579k;
    }

    public final int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.f114580l;
    }

    public final String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return c();
    }

    public final i a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (i) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        synchronized (this.f114577i) {
            try {
                try {
                    for (i iVar : this.f114577i) {
                        if (iVar.f114633b == i3) {
                            return iVar;
                        }
                    }
                } finally {
                }
            } catch (Exception unused) {
            }
            synchronized (this.f114578j) {
                try {
                    try {
                        for (i iVar2 : this.f114578j) {
                            if (iVar2.f114633b == i3) {
                                return iVar2;
                            }
                        }
                    } finally {
                    }
                } catch (Exception unused2) {
                }
                return null;
            }
        }
    }

    public final void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else if (TextUtils.isEmpty(str) || str.equals("null")) {
            this.f114575g = "";
        } else {
            this.f114575g = str.replace("|", "");
        }
    }

    public final void a(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        if (this.f114579k != 0 && this.f114579k > j3) {
            j3 = this.f114579k;
        }
        this.f114579k = j3;
        if (this.f114580l != 0 && this.f114580l > i3) {
            i3 = this.f114580l;
        }
        this.f114580l = i3;
    }

    public final boolean b(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) iVar)).booleanValue();
        }
        if (iVar.f114633b == -1) {
            synchronized (this.f114577i) {
                int i3 = iVar.f114634c;
                if (i3 == -1) {
                    if (this.f114577i.size() == 0) {
                        iVar.f114633b = 0;
                        iVar.f114638g = this.f114569a;
                        this.f114577i.add(iVar);
                        return true;
                    }
                } else if (i3 < this.f114577i.size()) {
                    i iVar2 = null;
                    for (i iVar3 : this.f114577i) {
                        if (iVar3.f114633b == iVar.f114634c) {
                            if (iVar3.f114637f >= iVar3.f114638g) {
                                return false;
                            }
                            if (iVar3.f114637f + com.tencent.hlyyb.downloader.a.b.a() > iVar.f114635d) {
                                return false;
                            }
                            iVar2 = iVar3;
                        } else if (iVar3.f114638g > iVar.f114635d && iVar3.f114635d < iVar.f114638g) {
                            return false;
                        }
                    }
                    if (iVar2 == null) {
                        return false;
                    }
                    iVar.f114633b = this.f114577i.size();
                    iVar2.f114638g = iVar.f114635d;
                    this.f114577i.add(iVar);
                    return true;
                }
            }
        }
        return false;
    }

    public final void a(i iVar) {
        i iVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iVar);
            return;
        }
        if (iVar.f114638g != -1 && iVar.f114635d < iVar.f114638g) {
            synchronized (this.f114578j) {
                int i3 = 0;
                int i16 = 0;
                while (true) {
                    if (i16 >= this.f114578j.size()) {
                        iVar2 = null;
                        break;
                    }
                    iVar2 = this.f114578j.get(i16);
                    if (iVar2.f114635d == iVar.f114635d) {
                        i3 = i16;
                        break;
                    }
                    i16++;
                }
                if (iVar2 == null) {
                    int size = this.f114578j.size();
                    int i17 = size > 0 ? this.f114578j.get(size - 1).f114633b + 1 : 10000;
                    iVar.f114634c = i17;
                    iVar.f114633b = i17;
                    this.f114578j.add(iVar);
                    return;
                }
                if (iVar.f114638g <= iVar2.f114638g) {
                    iVar = iVar2;
                }
                iVar.f114633b = iVar2.f114633b;
                iVar.f114634c = iVar2.f114634c;
                this.f114578j.remove(i3);
                this.f114578j.add(i3, iVar);
            }
        }
    }

    public final void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else if (TextUtils.isEmpty(str) || str.equals("null")) {
            this.f114574f = "";
        } else {
            this.f114574f = str.replace("|", "");
        }
    }
}
