package ho2;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f405443a;

    /* renamed from: b, reason: collision with root package name */
    private String f405444b;

    /* renamed from: c, reason: collision with root package name */
    private C10457a f405445c;

    public a() {
        this.f405443a = "";
        this.f405444b = "";
        this.f405445c = new C10457a();
    }

    public String a() {
        return this.f405443a;
    }

    public C10457a b() {
        return this.f405445c;
    }

    public String toString() {
        return "GuildMedalInfo{iconUrl='" + this.f405443a + "', name='" + this.f405444b + "', officialMedalInfoExt=" + this.f405445c + '}';
    }

    /* compiled from: P */
    /* renamed from: ho2.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static class C10457a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f405446a;

        /* renamed from: b, reason: collision with root package name */
        private String f405447b;

        public C10457a() {
            this.f405446a = false;
            this.f405447b = "";
        }

        public String a() {
            return this.f405447b;
        }

        public boolean b() {
            return this.f405446a;
        }

        public String toString() {
            return "GuildOfficialMedalInfo{isOfficial=" + this.f405446a + ", iconUrl='" + this.f405447b + "'}";
        }

        public C10457a(boolean z16, String str) {
            this.f405446a = z16;
            this.f405447b = str;
        }
    }

    public a(String str, String str2, C10457a c10457a) {
        this.f405443a = str;
        this.f405444b = str2;
        this.f405445c = c10457a;
    }
}
