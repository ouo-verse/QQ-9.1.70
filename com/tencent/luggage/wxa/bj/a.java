package com.tencent.luggage.wxa.bj;

import java.io.IOException;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends IOException {

    /* renamed from: a, reason: collision with root package name */
    public final EnumC6074a f122898a;

    /* renamed from: b, reason: collision with root package name */
    public final int f122899b;

    /* renamed from: c, reason: collision with root package name */
    public final String f122900c;

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.luggage.wxa.fn.b f122901d;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.bj.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public enum EnumC6074a {
        NONE,
        ENCODE,
        DECODE,
        SEND,
        RECV,
        TRANSFER,
        NETWORK,
        NOT_ACTIVATE_DEVICE,
        SERVER,
        UNKNOWN;


        /* renamed from: a, reason: collision with root package name */
        public final int f122912a = (-10000) - ordinal();

        /* renamed from: b, reason: collision with root package name */
        public final String f122913b = null;

        /* renamed from: c, reason: collision with root package name */
        public String f122914c;

        EnumC6074a() {
        }

        @Override // java.lang.Enum
        public String toString() {
            return String.format(Locale.ENGLISH, "%s(%d)", name(), Integer.valueOf(this.f122912a));
        }
    }

    public a(EnumC6074a enumC6074a, int i3, String str) {
        this(enumC6074a, i3, str, null);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "CgiError{err=" + this.f122898a + ", errCode=" + this.f122899b + ", message='" + this.f122900c + "'}";
    }

    public a(EnumC6074a enumC6074a, int i3, String str, com.tencent.luggage.wxa.fn.b bVar) {
        super(String.format(Locale.US, "[%s %d %s]", enumC6074a.toString(), Integer.valueOf(i3), str));
        this.f122898a = enumC6074a;
        this.f122899b = i3;
        this.f122900c = str;
        this.f122901d = bVar;
    }
}
