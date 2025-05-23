package h02;

import android.graphics.Bitmap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private String f404015a;

    /* renamed from: b, reason: collision with root package name */
    private int f404016b;

    /* renamed from: c, reason: collision with root package name */
    private int f404017c;

    /* renamed from: d, reason: collision with root package name */
    private Bitmap f404018d;

    /* renamed from: e, reason: collision with root package name */
    private Bitmap f404019e;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private String f404020a;

        /* renamed from: b, reason: collision with root package name */
        private int f404021b;

        /* renamed from: c, reason: collision with root package name */
        private int f404022c;

        /* renamed from: d, reason: collision with root package name */
        private Bitmap f404023d;

        /* renamed from: e, reason: collision with root package name */
        private Bitmap f404024e;

        a() {
        }

        public b f() {
            return new b(this);
        }

        public a g(Bitmap bitmap) {
            this.f404024e = bitmap;
            return this;
        }
    }

    b(a aVar) {
        this.f404015a = aVar.f404020a;
        this.f404016b = aVar.f404021b;
        this.f404017c = aVar.f404022c;
        this.f404018d = aVar.f404023d;
        this.f404019e = aVar.f404024e;
    }

    public static a c() {
        return new a();
    }

    public Bitmap a() {
        return this.f404018d;
    }

    public Bitmap b() {
        return this.f404019e;
    }

    public String toString() {
        return "GuildQrCodeParams{mUrl='" + this.f404015a + "', mSize=" + this.f404016b + ", mColor=" + this.f404017c + ", mLogoBitmap=" + this.f404018d + '}';
    }
}
