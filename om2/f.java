package om2;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.tencent.rlottie.AXrLottieDrawable;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f implements c {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    AXrLottieDrawable f423153a;

    /* renamed from: b, reason: collision with root package name */
    private final int f423154b;

    /* renamed from: c, reason: collision with root package name */
    private final int f423155c;

    /* renamed from: d, reason: collision with root package name */
    private final int f423156d;

    /* renamed from: e, reason: collision with root package name */
    private long f423157e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f423158f = false;

    /* renamed from: g, reason: collision with root package name */
    private int f423159g = 0;

    public f(@NonNull AXrLottieDrawable aXrLottieDrawable) {
        this.f423153a = aXrLottieDrawable;
        int e06 = aXrLottieDrawable.e0();
        this.f423154b = e06;
        int a06 = aXrLottieDrawable.a0() != 0 ? 1000 / aXrLottieDrawable.a0() : 1000;
        this.f423155c = a06;
        this.f423156d = e06 * a06;
    }

    @Override // om2.c
    public void a(int i3) {
        if (this.f423156d == 0) {
            this.f423159g = i3;
        } else {
            this.f423159g = i3 % this.f423154b;
        }
    }

    @Override // om2.c
    public int b(long j3) {
        int i3 = this.f423155c;
        if (i3 == 0) {
            return 0;
        }
        int i16 = this.f423156d;
        if (i16 > 0) {
            j3 %= i16;
        }
        return (int) (j3 / i3);
    }

    void c() {
        if (!this.f423158f) {
            return;
        }
        this.f423159g = b(System.currentTimeMillis() - this.f423157e);
    }

    @Override // om2.g
    public Bitmap getBitmap() {
        c();
        com.tencent.rlottie.c c06 = this.f423153a.c0(this.f423159g);
        if (c06.b()) {
            return c06.a();
        }
        return null;
    }
}
