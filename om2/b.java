package om2;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b implements c {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    e f423133a;

    /* renamed from: b, reason: collision with root package name */
    long f423134b = 0;

    /* renamed from: c, reason: collision with root package name */
    int f423135c = 0;

    /* renamed from: d, reason: collision with root package name */
    boolean f423136d = false;

    public b(@NonNull e eVar) {
        this.f423133a = eVar;
    }

    public static b c(String str) {
        e c16 = a.b().c(str);
        if (c16 == null) {
            return null;
        }
        return new b(c16);
    }

    @Override // om2.c
    public void a(int i3) {
        this.f423135c = i3;
    }

    @Override // om2.c
    public int b(long j3) {
        return this.f423133a.c(j3);
    }

    void d() {
        if (!this.f423136d) {
            return;
        }
        this.f423135c = this.f423133a.c(System.currentTimeMillis() - this.f423134b);
    }

    @Override // om2.g
    public Bitmap getBitmap() {
        d();
        return this.f423133a.b(this.f423135c);
    }
}
