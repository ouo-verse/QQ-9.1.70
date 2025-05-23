package kz4;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.an;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f413508a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f413509b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f413510c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f413511d;

    /* renamed from: e, reason: collision with root package name */
    private long f413512e;

    /* renamed from: f, reason: collision with root package name */
    private long f413513f;

    /* renamed from: g, reason: collision with root package name */
    private long f413514g;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private int f413515a = -1;

        /* renamed from: b, reason: collision with root package name */
        private int f413516b = -1;

        /* renamed from: c, reason: collision with root package name */
        private int f413517c = -1;

        /* renamed from: d, reason: collision with root package name */
        private String f413518d = null;

        /* renamed from: e, reason: collision with root package name */
        private long f413519e = -1;

        /* renamed from: f, reason: collision with root package name */
        private long f413520f = -1;

        /* renamed from: g, reason: collision with root package name */
        private long f413521g = -1;

        public a h(Context context) {
            return new a(context, this);
        }

        public b i(String str) {
            this.f413518d = str;
            return this;
        }

        public b j(boolean z16) {
            this.f413515a = z16 ? 1 : 0;
            return this;
        }

        public b k(long j3) {
            this.f413520f = j3;
            return this;
        }

        public b l(boolean z16) {
            this.f413516b = z16 ? 1 : 0;
            return this;
        }

        public b m(long j3) {
            this.f413519e = j3;
            return this;
        }

        public b n(long j3) {
            this.f413521g = j3;
            return this;
        }

        public b o(boolean z16) {
            this.f413517c = z16 ? 1 : 0;
            return this;
        }
    }

    public static a a(Context context) {
        return b().j(true).i(an.b(context)).m(1048576L).l(false).k(86400L).o(false).n(86400L).h(context);
    }

    public static b b() {
        return new b();
    }

    public long c() {
        return this.f413513f;
    }

    public long d() {
        return this.f413512e;
    }

    public long e() {
        return this.f413514g;
    }

    public boolean f() {
        return this.f413509b;
    }

    public boolean g() {
        return this.f413510c;
    }

    public boolean h() {
        return this.f413511d;
    }

    public String toString() {
        return "Config{mEventEncrypted=" + this.f413509b + ", mAESKey='" + this.f413508a + "', mMaxFileLength=" + this.f413512e + ", mEventUploadSwitchOpen=" + this.f413510c + ", mPerfUploadSwitchOpen=" + this.f413511d + ", mEventUploadFrequency=" + this.f413513f + ", mPerfUploadFrequency=" + this.f413514g + '}';
    }

    a(Context context, b bVar) {
        this.f413509b = true;
        this.f413510c = false;
        this.f413511d = false;
        this.f413512e = 1048576L;
        this.f413513f = 86400L;
        this.f413514g = 86400L;
        if (bVar.f413515a != 0) {
            if (bVar.f413515a == 1) {
                this.f413509b = true;
            } else {
                this.f413509b = true;
            }
        } else {
            this.f413509b = false;
        }
        if (!TextUtils.isEmpty(bVar.f413518d)) {
            this.f413508a = bVar.f413518d;
        } else {
            this.f413508a = an.b(context);
        }
        if (bVar.f413519e > -1) {
            this.f413512e = bVar.f413519e;
        } else {
            this.f413512e = 1048576L;
        }
        if (bVar.f413520f > -1) {
            this.f413513f = bVar.f413520f;
        } else {
            this.f413513f = 86400L;
        }
        if (bVar.f413521g > -1) {
            this.f413514g = bVar.f413521g;
        } else {
            this.f413514g = 86400L;
        }
        if (bVar.f413516b != 0) {
            if (bVar.f413516b == 1) {
                this.f413510c = true;
            } else {
                this.f413510c = false;
            }
        } else {
            this.f413510c = false;
        }
        if (bVar.f413517c != 0) {
            if (bVar.f413517c == 1) {
                this.f413511d = true;
                return;
            } else {
                this.f413511d = false;
                return;
            }
        }
        this.f413511d = false;
    }
}
