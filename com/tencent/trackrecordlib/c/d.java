package com.tencent.trackrecordlib.c;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.trackrecordlib.enums.EventTopic;
import com.tencent.trackrecordlib.enums.UiAction;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d extends com.tencent.trackrecordlib.c.a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private final UiAction f380981b;

    /* renamed from: c, reason: collision with root package name */
    private final com.tencent.trackrecordlib.b.a f380982c;

    /* renamed from: d, reason: collision with root package name */
    private final String f380983d;

    /* renamed from: e, reason: collision with root package name */
    private final String f380984e;

    /* renamed from: f, reason: collision with root package name */
    private final String f380985f;

    /* renamed from: g, reason: collision with root package name */
    private final String f380986g;

    /* renamed from: h, reason: collision with root package name */
    private final String f380987h;

    /* renamed from: i, reason: collision with root package name */
    private final String f380988i;

    /* renamed from: j, reason: collision with root package name */
    private final String f380989j;

    /* renamed from: k, reason: collision with root package name */
    private final String f380990k;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private UiAction f380991a;

        /* renamed from: b, reason: collision with root package name */
        private com.tencent.trackrecordlib.b.a f380992b;

        /* renamed from: c, reason: collision with root package name */
        private String f380993c;

        /* renamed from: d, reason: collision with root package name */
        private String f380994d;

        /* renamed from: e, reason: collision with root package name */
        private String f380995e;

        /* renamed from: f, reason: collision with root package name */
        private String f380996f;

        /* renamed from: g, reason: collision with root package name */
        private String f380997g;

        /* renamed from: h, reason: collision with root package name */
        private String f380998h;

        /* renamed from: i, reason: collision with root package name */
        private String f380999i;

        /* renamed from: j, reason: collision with root package name */
        private String f381000j;

        /* renamed from: k, reason: collision with root package name */
        private String f381001k;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f380991a = null;
            this.f380992b = null;
            this.f380993c = null;
            this.f380994d = null;
            this.f380995e = null;
            this.f380996f = null;
            this.f380997g = null;
            this.f380998h = null;
            this.f380999i = null;
            this.f381000j = null;
            this.f381001k = null;
        }

        public a a(UiAction uiAction) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) uiAction);
            }
            this.f380991a = uiAction;
            return this;
        }

        public a b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
            this.f380994d = str;
            return this;
        }

        public a c(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (a) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            }
            this.f380995e = str;
            return this;
        }

        public a d(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (a) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            }
            this.f380996f = str;
            return this;
        }

        public a e(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (a) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            }
            this.f380997g = str;
            return this;
        }

        public a f(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (a) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            }
            this.f380998h = str;
            return this;
        }

        public a g(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (a) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            }
            this.f380999i = str;
            return this;
        }

        public a h(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (a) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            }
            this.f381000j = str;
            return this;
        }

        public a i(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (a) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            }
            this.f381001k = str;
            return this;
        }

        public a a(com.tencent.trackrecordlib.b.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            }
            this.f380992b = aVar;
            return this;
        }

        public a a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            this.f380993c = str;
            return this;
        }

        public d a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) ? new d(this) : (d) iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }

    public d(a aVar) {
        super(EventTopic.EVENT_UI_ACTION);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.f380981b = aVar.f380991a;
        this.f380982c = aVar.f380992b;
        this.f380983d = aVar.f380993c;
        this.f380984e = aVar.f380994d;
        this.f380985f = aVar.f380995e;
        this.f380986g = aVar.f380996f;
        this.f380987h = aVar.f380997g;
        this.f380988i = aVar.f380998h;
        this.f380989j = aVar.f380999i;
        this.f380990k = aVar.f381000j;
        a(aVar.f381001k);
    }

    @Override // com.tencent.trackrecordlib.c.b
    public JSONObject e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JSONObject) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        try {
            UiAction uiAction = this.f380981b;
            if (uiAction != null) {
                this.f380959a.put("op", uiAction.getSeq());
            }
            com.tencent.trackrecordlib.b.a aVar = this.f380982c;
            if (aVar != null) {
                this.f380959a.put("data", aVar.a());
            }
            this.f380959a.put("view_type", this.f380983d);
            this.f380959a.put("view_tag", this.f380984e);
            this.f380959a.put("view_text", this.f380985f);
            this.f380959a.put("view_desc", this.f380986g);
            this.f380959a.put("view_pos", this.f380987h);
            this.f380959a.put("view_super", this.f380988i);
            this.f380959a.put("page", this.f380989j);
            this.f380959a.put("page_id", this.f380990k);
            return this.f380959a;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    public UiAction f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (UiAction) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f380981b;
    }
}
