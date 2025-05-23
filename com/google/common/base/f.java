package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public final class f {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f34681a;

        /* renamed from: b, reason: collision with root package name */
        private final a f34682b;

        /* renamed from: c, reason: collision with root package name */
        private a f34683c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f34684d;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            @NullableDecl
            String f34685a;

            /* renamed from: b, reason: collision with root package name */
            @NullableDecl
            Object f34686b;

            /* renamed from: c, reason: collision with root package name */
            @NullableDecl
            a f34687c;

            a() {
            }
        }

        private a d() {
            a aVar = new a();
            this.f34683c.f34687c = aVar;
            this.f34683c = aVar;
            return aVar;
        }

        private b e(@NullableDecl Object obj) {
            d().f34686b = obj;
            return this;
        }

        private b f(String str, @NullableDecl Object obj) {
            a d16 = d();
            d16.f34686b = obj;
            d16.f34685a = (String) j.m(str);
            return this;
        }

        @CanIgnoreReturnValue
        public b a(String str, int i3) {
            return f(str, String.valueOf(i3));
        }

        @CanIgnoreReturnValue
        public b b(String str, long j3) {
            return f(str, String.valueOf(j3));
        }

        @CanIgnoreReturnValue
        public b c(String str, @NullableDecl Object obj) {
            return f(str, obj);
        }

        @CanIgnoreReturnValue
        public b g(@NullableDecl Object obj) {
            return e(obj);
        }

        public String toString() {
            boolean z16 = this.f34684d;
            StringBuilder sb5 = new StringBuilder(32);
            sb5.append(this.f34681a);
            sb5.append('{');
            String str = "";
            for (a aVar = this.f34682b.f34687c; aVar != null; aVar = aVar.f34687c) {
                Object obj = aVar.f34686b;
                if (!z16 || obj != null) {
                    sb5.append(str);
                    String str2 = aVar.f34685a;
                    if (str2 != null) {
                        sb5.append(str2);
                        sb5.append('=');
                    }
                    if (obj != null && obj.getClass().isArray()) {
                        String deepToString = Arrays.deepToString(new Object[]{obj});
                        sb5.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                    } else {
                        sb5.append(obj);
                    }
                    str = ", ";
                }
            }
            sb5.append('}');
            return sb5.toString();
        }

        b(String str) {
            a aVar = new a();
            this.f34682b = aVar;
            this.f34683c = aVar;
            this.f34684d = false;
            this.f34681a = (String) j.m(str);
        }
    }

    public static <T> T a(@NullableDecl T t16, @NullableDecl T t17) {
        if (t16 != null) {
            return t16;
        }
        if (t17 != null) {
            return t17;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static b b(Object obj) {
        return new b(obj.getClass().getSimpleName());
    }
}
