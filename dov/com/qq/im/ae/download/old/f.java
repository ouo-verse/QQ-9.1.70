package dov.com.qq.im.ae.download.old;

/* compiled from: P */
/* loaded from: classes28.dex */
public class f {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f394498a;

        /* renamed from: b, reason: collision with root package name */
        private String[] f394499b;

        a(String str) {
            this.f394498a = str;
        }

        public int a() {
            String str = this.f394498a;
            if (str != null && !"".equals(str)) {
                String[] split = this.f394498a.split("\\_");
                this.f394499b = split;
                if (split == null) {
                    return -1;
                }
                if (split.length < 2) {
                    return -2;
                }
                return 0;
            }
            return -3;
        }

        public int b(char c16) {
            String str = this.f394498a;
            if (str != null && !"".equals(str)) {
                String[] split = this.f394498a.split("\\" + c16);
                this.f394499b = split;
                if (split == null) {
                    return -1;
                }
                if (split.length < 2) {
                    return -2;
                }
                return 0;
            }
            return -3;
        }

        public String c() {
            return this.f394499b[0].trim();
        }

        public String d() {
            return this.f394499b[1].trim();
        }

        public String e() {
            return this.f394499b[1].trim();
        }
    }

    public static a a(String str) {
        return new a(str);
    }
}
