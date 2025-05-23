package com.tencent.mobileqq.qroute.module;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.module.a;

/* compiled from: P */
/* loaded from: classes17.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f276434a;

    /* renamed from: b, reason: collision with root package name */
    public Dialog f276435b;

    /* renamed from: c, reason: collision with root package name */
    public int f276436c;

    /* renamed from: d, reason: collision with root package name */
    public String f276437d;

    /* renamed from: e, reason: collision with root package name */
    public Class f276438e;

    /* renamed from: f, reason: collision with root package name */
    public Intent f276439f;

    /* renamed from: g, reason: collision with root package name */
    public String f276440g;

    /* renamed from: h, reason: collision with root package name */
    public Context f276441h;

    /* renamed from: i, reason: collision with root package name */
    public Object f276442i;

    /* renamed from: j, reason: collision with root package name */
    public a.InterfaceC8440a f276443j;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f276444a;

        /* renamed from: b, reason: collision with root package name */
        public Dialog f276445b;

        /* renamed from: c, reason: collision with root package name */
        public int f276446c;

        /* renamed from: d, reason: collision with root package name */
        public String f276447d;

        /* renamed from: e, reason: collision with root package name */
        public Class f276448e;

        /* renamed from: f, reason: collision with root package name */
        public Intent f276449f;

        /* renamed from: g, reason: collision with root package name */
        public String f276450g;

        /* renamed from: h, reason: collision with root package name */
        public Context f276451h;

        /* renamed from: i, reason: collision with root package name */
        public Object f276452i;

        /* renamed from: j, reason: collision with root package name */
        public a.InterfaceC8440a f276453j;

        public b(@NonNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
                return;
            }
            this.f276444a = -1;
            this.f276450g = "";
            this.f276451h = context;
        }

        public d a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (d) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            d dVar = new d(null);
            dVar.f276434a = this.f276444a;
            dVar.f276435b = this.f276445b;
            dVar.f276439f = this.f276449f;
            dVar.f276437d = this.f276447d;
            dVar.f276443j = this.f276453j;
            dVar.f276436c = this.f276446c;
            dVar.f276438e = this.f276448e;
            dVar.f276440g = this.f276450g;
            dVar.f276441h = this.f276451h;
            dVar.f276442i = this.f276452i;
            return dVar;
        }

        public b b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (b) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
            this.f276447d = str;
            return this;
        }

        public b c(Class cls) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (b) iPatchRedirector.redirect((short) 6, (Object) this, (Object) cls);
            }
            this.f276448e = cls;
            return this;
        }

        public b d(Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (b) iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
            }
            this.f276449f = intent;
            return this;
        }

        public b e(a.InterfaceC8440a interfaceC8440a) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (b) iPatchRedirector.redirect((short) 10, (Object) this, (Object) interfaceC8440a);
            }
            this.f276453j = interfaceC8440a;
            return this;
        }

        public b f(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (b) iPatchRedirector.redirect((short) 9, (Object) this, obj);
            }
            this.f276452i = obj;
            return this;
        }

        public b g(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (b) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            }
            this.f276450g = str;
            return this;
        }

        public b h(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (b) iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            this.f276446c = i3;
            return this;
        }
    }

    /* synthetic */ d(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f276434a = -1;
            this.f276440g = "";
        }
    }
}
