package com.tencent.luggage.wxa.z7;

import android.os.Looper;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.c0;
import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static b f146373b;

    /* renamed from: a, reason: collision with root package name */
    public static final a f146372a = new a();

    /* renamed from: c, reason: collision with root package name */
    public static Queue f146374c = new ArrayDeque(2);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.z7.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C6975a {

        /* renamed from: a, reason: collision with root package name */
        public final int f146375a;

        /* renamed from: b, reason: collision with root package name */
        public final int f146376b;

        public C6975a(int i3, int i16) {
            this.f146375a = i3;
            this.f146376b = i16;
        }

        public final int a() {
            return this.f146375a;
        }

        public final int b() {
            return this.f146376b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C6975a)) {
                return false;
            }
            C6975a c6975a = (C6975a) obj;
            if (this.f146375a == c6975a.f146375a && this.f146376b == c6975a.f146376b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f146375a * 31) + this.f146376b;
        }

        public String toString() {
            return "KeyboardDisplayAction(keyboardType=" + this.f146375a + ", viewId=" + this.f146376b + ')';
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f146377a;

        /* renamed from: b, reason: collision with root package name */
        public final int f146378b;

        /* renamed from: c, reason: collision with root package name */
        public final Integer f146379c;

        /* renamed from: d, reason: collision with root package name */
        public final Function0 f146380d;

        public b(int i3, int i16, Integer num, Function0 function0) {
            this.f146377a = i3;
            this.f146378b = i16;
            this.f146379c = num;
            this.f146380d = function0;
        }

        public final Function0 a() {
            return this.f146380d;
        }

        public final int b() {
            return this.f146377a;
        }

        public final int c() {
            return this.f146378b;
        }

        public final Integer d() {
            return this.f146379c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f146377a == bVar.f146377a && this.f146378b == bVar.f146378b && Intrinsics.areEqual(this.f146379c, bVar.f146379c) && Intrinsics.areEqual(this.f146380d, bVar.f146380d)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int i3 = ((this.f146377a * 31) + this.f146378b) * 31;
            Integer num = this.f146379c;
            int i16 = 0;
            if (num == null) {
                hashCode = 0;
            } else {
                hashCode = num.hashCode();
            }
            int i17 = (i3 + hashCode) * 31;
            Function0 function0 = this.f146380d;
            if (function0 != null) {
                i16 = function0.hashCode();
            }
            return i17 + i16;
        }

        public String toString() {
            return "KeyboardHeightDispatchContent(keyboardHeight=" + this.f146377a + ", keyboardPanelHeight=" + this.f146378b + ", viewId=" + this.f146379c + ", dispatchCallback=" + this.f146380d + ')';
        }
    }

    public final void a(C6975a action) {
        Object last;
        Intrinsics.checkNotNullParameter(action, "action");
        if (!f146374c.isEmpty()) {
            int b16 = action.b();
            last = CollectionsKt___CollectionsKt.last(f146374c);
            if (b16 == ((C6975a) last).b()) {
                return;
            }
        }
        if (f146374c.size() == 2) {
            f146374c.poll();
        }
        f146374c.offer(action);
    }

    public final void b(com.tencent.luggage.wxa.xd.f fVar, com.tencent.luggage.wxa.xd.d dVar) {
        int i3;
        int i16;
        Integer d16;
        b bVar = f146373b;
        if (bVar != null && fVar != null) {
            c0 c0Var = new c0();
            if (bVar.b() > 0) {
                i3 = bVar.c();
            } else {
                i3 = 0;
            }
            Integer d17 = bVar.d();
            if (d17 != null) {
                i16 = d17.intValue();
            } else {
                i16 = -1;
            }
            if (i16 < 0) {
                d16 = null;
            } else {
                d16 = bVar.d();
            }
            c0Var.a(i3, dVar, fVar, d16);
        }
    }

    public final boolean a() {
        Object first;
        Object last;
        if (f146374c.size() < 2) {
            return true;
        }
        first = CollectionsKt___CollectionsKt.first(f146374c);
        C6975a c6975a = (C6975a) first;
        int a16 = c6975a != null ? c6975a.a() : -1;
        last = CollectionsKt___CollectionsKt.last(f146374c);
        C6975a c6975a2 = (C6975a) last;
        return a16 == (c6975a2 != null ? c6975a2.a() : -1);
    }

    public final void a(com.tencent.luggage.wxa.xd.f fVar, com.tencent.luggage.wxa.xd.d dVar, b content) {
        Intrinsics.checkNotNullParameter(content, "content");
        if (com.tencent.luggage.wxa.tn.e.f141559a) {
            com.tencent.luggage.wxa.er.a.b(Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()));
        }
        if (fVar != null && dVar != null) {
            f146373b = content;
            a(fVar, dVar);
            f146373b = null;
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("appBrandPage == null: ");
            sb5.append(fVar == null);
            sb5.append(", appBrandService == null: ");
            sb5.append(dVar == null);
            w.d("Luggage.ExtendEditableKeyboardHeightDispatcher", sb5.toString());
        }
    }

    public final void a(com.tencent.luggage.wxa.xd.f fVar, com.tencent.luggage.wxa.xd.d dVar) {
        Function0 a16;
        b bVar = f146373b;
        if (bVar != null && (a16 = bVar.a()) != null) {
            a16.invoke();
        }
        b(fVar, dVar);
    }
}
