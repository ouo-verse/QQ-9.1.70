package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public abstract class b implements k<Character> {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static abstract class a extends b {
        a() {
        }

        @Override // com.google.common.base.k
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch5) {
            return super.b(ch5);
        }
    }

    /* compiled from: P */
    /* renamed from: com.google.common.base.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static final class C0243b extends a {

        /* renamed from: d, reason: collision with root package name */
        private final char f34677d;

        C0243b(char c16) {
            this.f34677d = c16;
        }

        @Override // com.google.common.base.b
        public boolean e(char c16) {
            if (c16 == this.f34677d) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "CharMatcher.is('" + b.g(this.f34677d) + "')";
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static abstract class c extends a {

        /* renamed from: d, reason: collision with root package name */
        private final String f34678d;

        c(String str) {
            this.f34678d = (String) j.m(str);
        }

        public final String toString() {
            return this.f34678d;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class d extends c {

        /* renamed from: e, reason: collision with root package name */
        static final d f34679e = new d();

        d() {
            super("CharMatcher.none()");
        }

        @Override // com.google.common.base.b
        public int c(CharSequence charSequence, int i3) {
            j.p(i3, charSequence.length());
            return -1;
        }

        @Override // com.google.common.base.b
        public boolean e(char c16) {
            return false;
        }
    }

    protected b() {
    }

    public static b d(char c16) {
        return new C0243b(c16);
    }

    public static b f() {
        return d.f34679e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(char c16) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i3 = 0; i3 < 4; i3++) {
            cArr[5 - i3] = "0123456789ABCDEF".charAt(c16 & 15);
            c16 = (char) (c16 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    @Deprecated
    public boolean b(Character ch5) {
        return e(ch5.charValue());
    }

    public int c(CharSequence charSequence, int i3) {
        int length = charSequence.length();
        j.p(i3, length);
        while (i3 < length) {
            if (e(charSequence.charAt(i3))) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public abstract boolean e(char c16);
}
