package com.tencent.mobileqq.microapp.apkg;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class k implements Cloneable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f245864a;

    /* renamed from: b, reason: collision with root package name */
    public int f245865b;

    /* renamed from: c, reason: collision with root package name */
    public int f245866c;

    /* renamed from: d, reason: collision with root package name */
    public String f245867d;

    /* renamed from: e, reason: collision with root package name */
    public String f245868e;

    /* renamed from: f, reason: collision with root package name */
    public List f245869f;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a implements Cloneable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f245870a;

        /* renamed from: b, reason: collision with root package name */
        public String f245871b;

        /* renamed from: c, reason: collision with root package name */
        public Bitmap f245872c;

        /* renamed from: d, reason: collision with root package name */
        public Bitmap f245873d;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a clone() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            try {
                return (a) super.clone();
            } catch (Throwable th5) {
                th5.printStackTrace();
                return null;
            }
        }
    }

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public k clone() {
        k kVar;
        Throwable th5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (k) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        try {
            kVar = (k) super.clone();
        } catch (Throwable th6) {
            kVar = null;
            th5 = th6;
        }
        try {
            kVar.f245869f = new LinkedList();
            Iterator it = this.f245869f.iterator();
            while (it.hasNext()) {
                kVar.f245869f.add(((a) it.next()).clone());
            }
        } catch (Throwable th7) {
            th5 = th7;
            th5.printStackTrace();
            return kVar;
        }
        return kVar;
    }
}
