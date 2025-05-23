package as;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f26821a;

    /* renamed from: b, reason: collision with root package name */
    public final String f26822b;

    /* renamed from: c, reason: collision with root package name */
    public final int f26823c;

    /* renamed from: d, reason: collision with root package name */
    public String f26824d;

    /* compiled from: P */
    /* renamed from: as.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public static abstract class AbstractC0067a<T extends a> {

        /* renamed from: a, reason: collision with root package name */
        public final View f26825a;

        /* renamed from: b, reason: collision with root package name */
        public T f26826b;

        /* renamed from: c, reason: collision with root package name */
        protected int f26827c;

        /* JADX INFO: Access modifiers changed from: protected */
        public AbstractC0067a(Context context, ViewGroup viewGroup) {
            View b16 = b(context, viewGroup);
            this.f26825a = b16;
            if (b16 == null) {
                throw new NullPointerException("onCreateView can not return null");
            }
        }

        public void a(T t16, int i3) {
            this.f26826b = t16;
            this.f26827c = i3;
        }

        protected abstract View b(Context context, ViewGroup viewGroup);

        public boolean d() {
            T t16 = this.f26826b;
            return t16 != null && t16.c();
        }

        public void c() {
            this.f26826b = null;
            this.f26827c = -1;
        }
    }

    public a(int i3, String str, int i16) {
        this.f26821a = i3;
        this.f26822b = str;
        this.f26823c = i16;
    }

    public abstract AbstractC0067a a(Context context, ViewGroup viewGroup);

    public abstract Class<? extends AbstractC0067a> b();

    public boolean c() {
        return false;
    }

    public String toString() {
        return "Filter:{" + this.f26822b + "}";
    }
}
