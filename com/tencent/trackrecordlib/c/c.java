package com.tencent.trackrecordlib.c;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.trackrecordlib.enums.EventTopic;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c extends com.tencent.trackrecordlib.c.a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private final String f380966b;

    /* renamed from: c, reason: collision with root package name */
    private final String f380967c;

    /* renamed from: d, reason: collision with root package name */
    private final String f380968d;

    /* renamed from: e, reason: collision with root package name */
    private final String f380969e;

    /* renamed from: f, reason: collision with root package name */
    private final String f380970f;

    /* renamed from: g, reason: collision with root package name */
    private final String f380971g;

    /* renamed from: h, reason: collision with root package name */
    private final String f380972h;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private String f380973a;

        /* renamed from: b, reason: collision with root package name */
        private String f380974b;

        /* renamed from: c, reason: collision with root package name */
        private String f380975c;

        /* renamed from: d, reason: collision with root package name */
        private String f380976d;

        /* renamed from: e, reason: collision with root package name */
        private String f380977e;

        /* renamed from: f, reason: collision with root package name */
        private String f380978f;

        /* renamed from: g, reason: collision with root package name */
        private String f380979g;

        /* renamed from: h, reason: collision with root package name */
        private String f380980h;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f380973a = null;
            this.f380974b = null;
            this.f380975c = null;
            this.f380976d = null;
            this.f380977e = null;
            this.f380978f = null;
            this.f380979g = null;
            this.f380980h = null;
        }

        public a a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.f380973a = str;
            return this;
        }

        public a b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.f380974b = str;
            return this;
        }

        public a c(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            this.f380975c = str;
            return this;
        }

        public a d(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
            this.f380976d = str;
            return this;
        }

        public a e(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (a) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            }
            this.f380977e = str;
            return this;
        }

        public a f(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (a) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            }
            this.f380978f = str;
            return this;
        }

        public a g(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (a) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            }
            this.f380979g = str;
            return this;
        }

        public a h(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (a) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            }
            this.f380980h = str;
            return this;
        }

        public c a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) ? new c(this) : (c) iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    public c(a aVar) {
        super(EventTopic.EVENT_PAGE_CHANGE);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.f380966b = aVar.f380973a;
        this.f380967c = aVar.f380974b;
        this.f380968d = aVar.f380975c;
        this.f380969e = aVar.f380976d;
        this.f380970f = aVar.f380977e;
        this.f380971g = aVar.f380978f;
        this.f380972h = aVar.f380979g;
        a(aVar.f380980h);
    }

    @Override // com.tencent.trackrecordlib.c.b
    public JSONObject e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JSONObject) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        try {
            this.f380959a.put("pre_page_id", this.f380966b);
            this.f380959a.put("pre_page", this.f380967c);
            this.f380959a.put("page_id", this.f380968d);
            this.f380959a.put("page", this.f380969e);
            this.f380959a.put("pre_page_start", this.f380970f);
            this.f380959a.put("pre_page_end", this.f380971g);
            this.f380959a.put("page_start", this.f380972h);
            return this.f380959a;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }
}
