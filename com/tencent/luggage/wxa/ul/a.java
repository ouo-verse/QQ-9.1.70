package com.tencent.luggage.wxa.ul;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.wxa.ol.r0;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface a extends r0 {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ul.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6806a implements a {

        /* renamed from: a, reason: collision with root package name */
        public View f142817a;

        /* renamed from: b, reason: collision with root package name */
        public int f142818b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f142819c;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ul.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6807a extends View {
            public C6807a(Context context) {
                super(context);
            }

            @Override // android.view.View
            public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
                C6806a.this.f142819c = true;
                super.onLayout(z16, i3, i16, i17, i18);
                C6806a.this.f142819c = false;
            }

            @Override // android.view.View
            public void onMeasure(int i3, int i16) {
                if (C6806a.this.f142818b > 0) {
                    i16 = View.MeasureSpec.makeMeasureSpec(C6806a.this.f142818b, 1073741824);
                }
                super.onMeasure(i3, i16);
            }
        }

        public C6806a(Context context) {
            this.f142817a = new C6807a(context);
        }

        @Override // com.tencent.luggage.wxa.ul.a
        public void a(c cVar) {
        }

        @Override // com.tencent.luggage.wxa.ul.a
        public void b(boolean z16) {
        }

        @Override // com.tencent.luggage.wxa.ul.a
        public void c(boolean z16) {
            this.f142817a.setVisibility(4);
        }

        @Override // com.tencent.luggage.wxa.ul.a
        public void d(boolean z16) {
        }

        @Override // com.tencent.luggage.wxa.ol.r0
        public boolean e() {
            return true;
        }

        @Override // com.tencent.luggage.wxa.ul.a
        public boolean b() {
            return false;
        }

        @Override // com.tencent.luggage.wxa.ul.a
        public boolean c() {
            return this.f142817a.isInLayout();
        }

        @Override // com.tencent.luggage.wxa.ul.a
        public void d() {
            this.f142817a.setVisibility(0);
        }

        @Override // com.tencent.luggage.wxa.ul.a
        public boolean b(int i3) {
            if (i3 <= 0 || this.f142818b == i3) {
                return false;
            }
            this.f142818b = i3;
            return true;
        }

        @Override // com.tencent.luggage.wxa.ul.a
        public View a() {
            return this.f142817a;
        }

        @Override // com.tencent.luggage.wxa.ul.a
        public void onDestroy() {
        }

        @Override // com.tencent.luggage.wxa.ul.a
        public void onPause() {
        }

        @Override // com.tencent.luggage.wxa.ul.a
        public void onResume() {
        }

        @Override // com.tencent.luggage.wxa.ul.a
        public void setOnEmoticonOperationListener(com.tencent.luggage.wxa.ul.b bVar) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b extends com.tencent.luggage.wxa.eo.c {
    }

    View a();

    void a(c cVar);

    void b(boolean z16);

    boolean b();

    boolean b(int i3);

    void c(boolean z16);

    boolean c();

    void d();

    void d(boolean z16);

    void onDestroy();

    void onPause();

    void onResume();

    void setOnEmoticonOperationListener(com.tencent.luggage.wxa.ul.b bVar);
}
