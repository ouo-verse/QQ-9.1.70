package eh4;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public C10240b f396290a;

    /* renamed from: b, reason: collision with root package name */
    public a f396291b;

    /* renamed from: c, reason: collision with root package name */
    public c f396292c;

    /* renamed from: d, reason: collision with root package name */
    public d f396293d;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f396294a;

        /* renamed from: b, reason: collision with root package name */
        public String f396295b;

        public a(String str, String str2) {
            this.f396294a = str;
            this.f396295b = str2;
        }
    }

    /* compiled from: P */
    /* renamed from: eh4.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static class C10240b {

        /* renamed from: a, reason: collision with root package name */
        public String f396296a;

        public C10240b(String str) {
            this.f396296a = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f396297a;

        public c(int i3) {
            this.f396297a = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public String f396298a;

        public d(String str) {
            this.f396298a = str;
        }
    }

    public b(C10240b c10240b, a aVar, c cVar, d dVar) {
        this.f396290a = c10240b;
        this.f396291b = aVar;
        this.f396292c = cVar;
        this.f396293d = dVar;
    }

    private static String a(int i3) {
        if (i3 != 1) {
            return "https://onlinecgi.yes.qq.com/onlinen/getinitconfig";
        }
        return "https://testcgi.yes.qq.com/testn/getinitconfig";
    }

    public static b b(int i3) {
        String str;
        String str2;
        int i16;
        if (i3 != 1) {
            str = "server/yes_online.xml";
        } else {
            str = "server/yes_test.xml";
        }
        C10240b c10240b = new C10240b(str);
        if (i3 != 1) {
            str2 = "https://picupload.yes.qq.com/online";
        } else {
            str2 = "https://test-pic-upload.yes.qq.com/test";
        }
        a aVar = new a(str2, "");
        d dVar = new d(a(i3));
        if (i3 != 1) {
            i16 = 1400527057;
        } else {
            i16 = 1400525290;
        }
        return new b(c10240b, aVar, new c(i16), dVar);
    }

    public int c() {
        return this.f396292c.f396297a;
    }
}
