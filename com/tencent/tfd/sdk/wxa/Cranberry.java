package com.tencent.tfd.sdk.wxa;

import android.app.Activity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Cranberry {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static List<Foxnut> f375568a;

    /* renamed from: b, reason: collision with root package name */
    public static Celse f375569b;

    /* renamed from: c, reason: collision with root package name */
    public static Set<String> f375570c;

    /* renamed from: d, reason: collision with root package name */
    public static final Cdo f375571d;

    /* renamed from: e, reason: collision with root package name */
    public static Cif f375572e;

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.Cranberry$do, reason: invalid class name */
    /* loaded from: classes26.dex */
    public class Cdo implements Foxnut {
        static IPatchRedirector $redirector_;

        public Cdo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List<com.tencent.tfd.sdk.wxa.Foxnut>, java.util.ArrayList] */
        @Override // com.tencent.tfd.sdk.wxa.Foxnut
        public final void a(String str, int i3, int i16, Betelnut betelnut) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16), betelnut);
                return;
            }
            Iterator it = Cranberry.f375568a.iterator();
            while (it.hasNext()) {
                Foxnut foxnut = (Foxnut) it.next();
                if (foxnut != null) {
                    foxnut.a(str, i3, i16, betelnut);
                }
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.Cranberry$if, reason: invalid class name */
    /* loaded from: classes26.dex */
    public class Cif implements Celse {
        static IPatchRedirector $redirector_;

        public Cif() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.tfd.sdk.wxa.Celse
        public final void onActivityPaused(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
                return;
            }
            Bilberry a16 = Bilberry.a();
            activity.getApplicationContext();
            a16.a(activity.getClass().getName());
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.HashSet, java.util.Set<java.lang.String>] */
        @Override // com.tencent.tfd.sdk.wxa.Celse
        public final void onActivityResumed(Activity activity) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
                return;
            }
            Celse celse = Cranberry.f375569b;
            if (celse != null) {
                celse.onActivityResumed(activity);
            }
            if (Cranberry.f375570c.contains(activity.getClass().getName())) {
                i3 = 100;
            } else {
                i3 = 999;
            }
            Bilberry a16 = Bilberry.a();
            activity.getApplicationContext();
            a16.a(activity.getClass().getName(), i3, Cranberry.f375571d);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62540);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f375568a = new ArrayList();
        f375570c = new HashSet();
        f375571d = new Cdo();
        f375572e = new Cif();
    }
}
