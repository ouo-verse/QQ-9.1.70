package g1;

import android.graphics.Typeface;
import androidx.annotation.RestrictTo;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public final class a extends f {

    /* renamed from: a, reason: collision with root package name */
    private final Typeface f401056a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC10346a f401057b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f401058c;

    /* compiled from: P */
    /* renamed from: g1.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC10346a {
        void a(Typeface typeface);
    }

    public a(InterfaceC10346a interfaceC10346a, Typeface typeface) {
        this.f401056a = typeface;
        this.f401057b = interfaceC10346a;
    }

    private void d(Typeface typeface) {
        if (!this.f401058c) {
            this.f401057b.a(typeface);
        }
    }

    @Override // g1.f
    public void a(int i3) {
        d(this.f401056a);
    }

    @Override // g1.f
    public void b(Typeface typeface, boolean z16) {
        d(typeface);
    }

    public void c() {
        this.f401058c = true;
    }
}
