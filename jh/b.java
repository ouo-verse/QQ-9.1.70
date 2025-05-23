package jh;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private String f409919a;

    /* renamed from: b, reason: collision with root package name */
    private int f409920b;

    /* renamed from: c, reason: collision with root package name */
    private int f409921c;

    /* renamed from: d, reason: collision with root package name */
    private Bitmap f409922d;

    /* renamed from: e, reason: collision with root package name */
    private ErrorCorrectionLevel f409923e;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private String f409924a;

        /* renamed from: b, reason: collision with root package name */
        private int f409925b;

        /* renamed from: c, reason: collision with root package name */
        private int f409926c;

        /* renamed from: d, reason: collision with root package name */
        private Bitmap f409927d;

        /* renamed from: e, reason: collision with root package name */
        private ErrorCorrectionLevel f409928e;

        a() {
        }

        public b f() {
            return new b(this);
        }

        public a g(int i3) {
            this.f409926c = i3;
            return this;
        }

        public a h(ErrorCorrectionLevel errorCorrectionLevel) {
            this.f409928e = errorCorrectionLevel;
            return this;
        }

        public a i(Bitmap bitmap) {
            this.f409927d = bitmap;
            return this;
        }

        public a j(int i3) {
            this.f409925b = i3;
            return this;
        }

        public a k(String str) {
            this.f409924a = str;
            return this;
        }
    }

    b(a aVar) {
        this.f409919a = aVar.f409924a;
        this.f409920b = aVar.f409925b;
        this.f409921c = aVar.f409926c;
        this.f409922d = aVar.f409927d;
        this.f409923e = aVar.f409928e;
    }

    public static a g() {
        return new a();
    }

    public int a() {
        return this.f409921c;
    }

    public ErrorCorrectionLevel b() {
        return this.f409923e;
    }

    public Bitmap c() {
        return this.f409922d;
    }

    public int d() {
        return this.f409920b;
    }

    public String e() {
        return this.f409919a;
    }

    public boolean f() {
        return TextUtils.isEmpty(this.f409919a) || this.f409920b < 0;
    }

    public String toString() {
        return "QrCodeParams{mUrl='" + this.f409919a + "', mSize=" + this.f409920b + ", mColor=" + this.f409921c + ", mLogoBitmap=" + this.f409922d + ", mCorrectionLevel=" + this.f409923e + '}';
    }
}
