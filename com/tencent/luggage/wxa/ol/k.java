package com.tencent.luggage.wxa.ol;

import android.util.SparseIntArray;
import android.view.ViewGroup;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k {

    /* renamed from: c, reason: collision with root package name */
    public static final k f136800c = new k();

    /* renamed from: a, reason: collision with root package name */
    public final b f136801a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    public Function1 f136802b = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Function1 {
        public a() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void invoke(com.tencent.luggage.wxa.kj.v vVar) {
            try {
                com.tencent.luggage.wxa.kj.o0 D0 = vVar.D0();
                D0.getWrapperView().setFocusable(true);
                D0.getWrapperView().setFocusableInTouchMode(true);
                D0.getContentView().setFocusable(true);
                D0.getContentView().setFocusableInTouchMode(true);
                return null;
            } catch (NullPointerException unused) {
                return null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final SparseIntArray f136804a;

        public b() {
            this.f136804a = new SparseIntArray();
        }

        public int a(com.tencent.luggage.wxa.kj.o0 o0Var, int i3) {
            return this.f136804a.get(o0Var.hashCode(), i3);
        }

        public void b(com.tencent.luggage.wxa.kj.o0 o0Var, int i3) {
            this.f136804a.put(o0Var.hashCode(), i3);
        }

        public void a(com.tencent.luggage.wxa.kj.o0 o0Var) {
            this.f136804a.delete(o0Var.hashCode());
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public static k a() {
        return f136800c;
    }

    public void b(com.tencent.luggage.wxa.kj.v vVar) {
        com.tencent.luggage.wxa.kj.o0 D0 = vVar.D0();
        if (D0 == null) {
            return;
        }
        this.f136801a.b(D0, this.f136801a.a(D0, 0) + 1);
        try {
            D0.getWrapperView().setFocusable(false);
            D0.getWrapperView().setFocusableInTouchMode(false);
            D0.getContentView().setFocusable(false);
            D0.getContentView().setFocusableInTouchMode(false);
            if (D0.getWrapperView() instanceof ViewGroup) {
                ((ViewGroup) D0.getWrapperView()).setDescendantFocusability(393216);
            }
        } catch (NullPointerException unused) {
        }
    }

    public void c(com.tencent.luggage.wxa.kj.v vVar) {
        com.tencent.luggage.wxa.kj.o0 D0 = vVar.D0();
        if (D0 == null) {
            return;
        }
        int a16 = this.f136801a.a(D0, 0) - 1;
        if (a16 <= 0) {
            a(vVar);
        } else {
            this.f136801a.b(D0, a16);
        }
    }

    public void a(com.tencent.luggage.wxa.kj.v vVar) {
        com.tencent.luggage.wxa.kj.o0 D0 = vVar.D0();
        if (D0 == null) {
            return;
        }
        this.f136801a.a(D0);
        this.f136802b.invoke(vVar);
    }
}
