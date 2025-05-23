package com.tencent.mobileqq.weiyun.sdk.download;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b implements Cloneable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public int f315188d;

    /* renamed from: e, reason: collision with root package name */
    public int f315189e;

    /* renamed from: f, reason: collision with root package name */
    public int f315190f;

    /* renamed from: h, reason: collision with root package name */
    public int f315191h;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f315188d = 0;
        this.f315189e = 0;
        this.f315190f = 0;
        this.f315191h = 0;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public synchronized b clone() {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        try {
            bVar = (b) super.clone();
        } catch (CloneNotSupportedException unused) {
            bVar = null;
        }
        return bVar;
    }

    public synchronized b b(com.tencent.mobileqq.weiyun.model.b bVar, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (b) iPatchRedirector.redirect((short) 4, this, bVar, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (i3 != i16) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 5) {
                            this.f315191h--;
                        }
                    } else {
                        this.f315190f--;
                    }
                } else {
                    this.f315189e--;
                }
            } else {
                this.f315188d--;
            }
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        if (i16 == 5) {
                            this.f315191h++;
                        }
                    } else {
                        this.f315190f++;
                    }
                } else {
                    this.f315189e++;
                }
            } else {
                this.f315188d++;
            }
        }
        return clone();
    }
}
