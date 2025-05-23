package or;

import dov.com.qq.im.ae.current.SessionWrap;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private SessionWrap f423406a;

    /* renamed from: b, reason: collision with root package name */
    private String f423407b;

    /* renamed from: c, reason: collision with root package name */
    private int f423408c;

    /* renamed from: d, reason: collision with root package name */
    private int f423409d;

    /* renamed from: e, reason: collision with root package name */
    private int f423410e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f423411f;

    /* renamed from: g, reason: collision with root package name */
    private int f423412g;

    /* renamed from: h, reason: collision with root package name */
    private String f423413h;

    /* renamed from: i, reason: collision with root package name */
    private int f423414i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f423415j;

    /* renamed from: k, reason: collision with root package name */
    public int f423416k;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private SessionWrap f423417a;

        /* renamed from: b, reason: collision with root package name */
        private String f423418b;

        /* renamed from: c, reason: collision with root package name */
        private int f423419c;

        /* renamed from: g, reason: collision with root package name */
        private int f423423g;

        /* renamed from: h, reason: collision with root package name */
        private String f423424h;

        /* renamed from: d, reason: collision with root package name */
        private int f423420d = 1;

        /* renamed from: e, reason: collision with root package name */
        private boolean f423421e = true;

        /* renamed from: f, reason: collision with root package name */
        private int f423422f = 11;

        /* renamed from: i, reason: collision with root package name */
        private int f423425i = 0;

        /* renamed from: j, reason: collision with root package name */
        public boolean f423426j = true;

        /* renamed from: k, reason: collision with root package name */
        public int f423427k = 0;

        public a(int i3) {
            this.f423419c = i3 == 2 ? 0 : 1;
        }

        public b j() {
            return new b(this);
        }

        public a k(String str) {
            this.f423418b = str;
            return this;
        }

        public a l(int i3) {
            this.f423420d = i3;
            return this;
        }

        public a m(SessionWrap sessionWrap) {
            this.f423417a = sessionWrap;
            if (sessionWrap != null) {
                this.f423422f = com.tencent.aelight.camera.aioeditor.a.a(sessionWrap.f394449f);
            }
            return this;
        }

        public a n(int i3) {
            this.f423425i = i3;
            return this;
        }
    }

    b(a aVar) {
        this.f423406a = aVar.f423417a;
        this.f423407b = aVar.f423418b;
        this.f423408c = aVar.f423419c;
        this.f423409d = aVar.f423422f;
        this.f423410e = aVar.f423420d;
        this.f423411f = aVar.f423421e;
        this.f423412g = aVar.f423423g;
        this.f423413h = aVar.f423424h;
        this.f423414i = aVar.f423425i;
        this.f423415j = aVar.f423426j;
        this.f423416k = aVar.f423427k;
    }

    public String a() {
        return this.f423407b;
    }

    public int b() {
        return this.f423409d;
    }

    public int c() {
        return this.f423410e;
    }

    public int d() {
        return this.f423408c;
    }

    public SessionWrap e() {
        return this.f423406a;
    }

    public int f() {
        return this.f423414i;
    }

    public String g() {
        return this.f423413h;
    }

    public boolean h() {
        return this.f423411f;
    }
}
