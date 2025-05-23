package com.tencent.luggage.wxa.d5;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.luggage.wxa.d5.a;
import com.tencent.luggage.wxa.eo.c;
import com.tencent.luggage.wxa.eo.g;
import com.tencent.luggage.wxa.tn.c0;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface a extends c {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.d5.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6131a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.d5.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6132a {

            /* renamed from: a, reason: collision with root package name */
            public static final a f124083a = new C6133a();

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.d5.a$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class C6133a implements a {
                @Override // com.tencent.luggage.wxa.d5.a
                public Drawable H() {
                    return null;
                }

                @Override // com.tencent.luggage.wxa.d5.a
                public String T() {
                    return null;
                }

                @Override // com.tencent.luggage.wxa.d5.a
                public void a(final b bVar) {
                    c0.a(new Runnable() { // from class: j21.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.b.this.a(null);
                        }
                    });
                }
            }
        }

        public static a a() {
            a aVar = (a) g.a(a.class);
            if (aVar == null) {
                return C6132a.f124083a;
            }
            return aVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a(Bitmap bitmap);
    }

    Drawable H();

    String T();

    void a(b bVar);
}
