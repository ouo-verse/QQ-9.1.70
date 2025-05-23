package com.tencent.luggage.wxa.x1;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes9.dex */
public enum a {
    TEXT,
    EMOJI;


    /* renamed from: a, reason: collision with root package name */
    public static final C6896a f144486a = new C6896a(null);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.x1.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C6896a {
        public C6896a() {
        }

        public /* synthetic */ C6896a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a(String str) {
            a aVar = (a) com.tencent.luggage.wxa.vl.e.a(str, a.class);
            if (aVar == null) {
                return a.TEXT;
            }
            return aVar;
        }
    }

    public static final a a(String str) {
        return f144486a.a(str);
    }
}
