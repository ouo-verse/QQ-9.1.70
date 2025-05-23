package com.tencent.qqnt.indicators.magicindicator;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes24.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private SparseBooleanArray f357044a;

    /* renamed from: b, reason: collision with root package name */
    private SparseArray<Float> f357045b;

    /* renamed from: c, reason: collision with root package name */
    private int f357046c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f357047d;

    /* renamed from: e, reason: collision with root package name */
    private InterfaceC9635a f357048e;

    /* compiled from: P */
    /* renamed from: com.tencent.qqnt.indicators.magicindicator.a$a, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public interface InterfaceC9635a {
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f357044a = new SparseBooleanArray();
            this.f357045b = new SparseArray<>();
        }
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f357046c;
    }

    public void b(InterfaceC9635a interfaceC9635a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) interfaceC9635a);
        } else {
            this.f357048e = interfaceC9635a;
        }
    }

    public void c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.f357047d = z16;
        }
    }
}
