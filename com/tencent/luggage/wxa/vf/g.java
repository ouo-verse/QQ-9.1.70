package com.tencent.luggage.wxa.vf;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends g {

        /* renamed from: a, reason: collision with root package name */
        public final int f143473a;

        /* renamed from: b, reason: collision with root package name */
        public final String f143474b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i3, String errMsg) {
            super(null);
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f143473a = i3;
            this.f143474b = errMsg;
        }

        public final int a() {
            return this.f143473a;
        }

        public final String b() {
            return this.f143474b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f143473a == aVar.f143473a && Intrinsics.areEqual(this.f143474b, aVar.f143474b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f143473a * 31) + this.f143474b.hashCode();
        }

        public String toString() {
            return "Failure(errCode=" + this.f143473a + ", errMsg=" + this.f143474b + ')';
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends g {

        /* renamed from: a, reason: collision with root package name */
        public final Object f143475a;

        public b(Object obj) {
            super(null);
            this.f143475a = obj;
        }

        public final Object a() {
            return this.f143475a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof b) && Intrinsics.areEqual(this.f143475a, ((b) obj).f143475a)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            Object obj = this.f143475a;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public String toString() {
            return "Success(ret=" + this.f143475a + ')';
        }
    }

    public g() {
    }

    public /* synthetic */ g(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
