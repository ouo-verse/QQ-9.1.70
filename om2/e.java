package om2;

import android.graphics.Bitmap;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    protected Bitmap[] f423149b;

    /* renamed from: d, reason: collision with root package name */
    protected int f423151d;

    /* renamed from: e, reason: collision with root package name */
    protected int[] f423152e;

    /* renamed from: a, reason: collision with root package name */
    private final d f423148a = new d();

    /* renamed from: c, reason: collision with root package name */
    protected long f423150c = 0;

    protected int a() {
        this.f423148a.a();
        int i3 = this.f423151d;
        this.f423151d = i3 + 1;
        this.f423149b[i3] = this.f423148a.b();
        this.f423152e[i3] = this.f423148a.c();
        if (i3 > 0) {
            int[] iArr = this.f423152e;
            iArr[i3] = iArr[i3] + iArr[i3 - 1];
        }
        if (this.f423151d == this.f423148a.e()) {
            this.f423150c = this.f423152e[i3];
        }
        return i3;
    }

    public Bitmap b(int i3) {
        if (i3 < 0) {
            return null;
        }
        int e16 = i3 % this.f423148a.e();
        while (e16 >= this.f423151d) {
            a();
        }
        return this.f423149b[e16];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c(long j3) {
        if (e()) {
            int binarySearch = Arrays.binarySearch(this.f423152e, (int) (j3 % this.f423150c));
            if (binarySearch < 0) {
                if (binarySearch == -1) {
                    return 0;
                }
                return -(binarySearch + 2);
            }
            return binarySearch;
        }
        for (int i3 = 0; i3 < this.f423151d; i3++) {
            if (j3 < this.f423152e[i3]) {
                return i3;
            }
        }
        while (this.f423151d < this.f423148a.e()) {
            int a16 = a();
            if (j3 < this.f423152e[a16]) {
                return a16;
            }
        }
        this.f423150c = this.f423152e[this.f423148a.e() - 1];
        return c(j3);
    }

    public String d() {
        return this.f423148a.g();
    }

    public boolean e() {
        if (this.f423150c != 0) {
            return true;
        }
        return false;
    }

    public boolean f(String str) {
        if (!this.f423148a.h(str)) {
            return false;
        }
        this.f423149b = new Bitmap[this.f423148a.e()];
        this.f423152e = new int[this.f423148a.e()];
        return true;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        g();
    }

    public void g() {
        Bitmap[] bitmapArr = this.f423149b;
        if (bitmapArr != null) {
            for (Bitmap bitmap : bitmapArr) {
                bitmap.recycle();
            }
            this.f423149b = null;
        }
        this.f423148a.i();
    }
}
