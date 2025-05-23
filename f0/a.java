package f0;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

/* compiled from: P */
/* loaded from: classes.dex */
public class a implements e<Drawable> {

    /* renamed from: a, reason: collision with root package name */
    private final int f397477a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f397478b;

    /* renamed from: c, reason: collision with root package name */
    private b f397479c;

    /* compiled from: P */
    /* renamed from: f0.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C10274a {

        /* renamed from: a, reason: collision with root package name */
        private final int f397480a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f397481b;

        public C10274a() {
            this(300);
        }

        public a a() {
            return new a(this.f397480a, this.f397481b);
        }

        public C10274a(int i3) {
            this.f397480a = i3;
        }
    }

    protected a(int i3, boolean z16) {
        this.f397477a = i3;
        this.f397478b = z16;
    }

    private d<Drawable> b() {
        if (this.f397479c == null) {
            this.f397479c = new b(this.f397477a, this.f397478b);
        }
        return this.f397479c;
    }

    @Override // f0.e
    public d<Drawable> a(DataSource dataSource, boolean z16) {
        if (dataSource == DataSource.MEMORY_CACHE) {
            return c.b();
        }
        return b();
    }
}
