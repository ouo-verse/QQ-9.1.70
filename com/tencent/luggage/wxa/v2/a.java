package com.tencent.luggage.wxa.v2;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final b f142951a = new b(null);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.v2.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6812a extends a {

        /* renamed from: b, reason: collision with root package name */
        public static final C6812a f142952b = new C6812a();

        public C6812a() {
            super(null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends a {

        /* renamed from: b, reason: collision with root package name */
        public final String f142953b;

        public c(String str) {
            super(null);
            this.f142953b = str;
        }

        public final String a() {
            return this.f142953b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof c) && Intrinsics.areEqual(this.f142953b, ((c) obj).f142953b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            String str = this.f142953b;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "FAILED(message=" + this.f142953b + ')';
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends a {

        /* renamed from: b, reason: collision with root package name */
        public final List f142954b;

        /* renamed from: c, reason: collision with root package name */
        public final int f142955c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(List files, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(files, "files");
            this.f142954b = files;
            this.f142955c = i3;
        }

        public final List a() {
            return this.f142954b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (Intrinsics.areEqual(this.f142954b, dVar.f142954b) && this.f142955c == dVar.f142955c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f142954b.hashCode() * 31) + this.f142955c;
        }

        public String toString() {
            return "OK(files=" + this.f142954b + ", from=" + this.f142955c + ')';
        }
    }

    public a() {
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
