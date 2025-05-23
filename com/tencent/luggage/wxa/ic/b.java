package com.tencent.luggage.wxa.ic;

import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.b9.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f129701a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ic.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6293a implements com.tencent.luggage.wxa.ei.p {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.b9.t f129702a;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.ic.b$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6294a implements t.s {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ ValueCallback f129703a;

                public C6294a(ValueCallback valueCallback) {
                    this.f129703a = valueCallback;
                }

                @Override // com.tencent.luggage.wxa.b9.t.s
                public final void a(String str, t.C6044t c6044t) {
                    ValueCallback valueCallback = this.f129703a;
                    if (valueCallback != null) {
                        valueCallback.onReceiveValue(str);
                    }
                }
            }

            public C6293a(com.tencent.luggage.wxa.b9.t tVar) {
                this.f129702a = tVar;
            }

            @Override // com.tencent.luggage.wxa.ei.p
            public void evaluateJavascript(String str, ValueCallback valueCallback) {
                this.f129702a.a(str, (t.s) new C6294a(valueCallback));
            }

            public String toString() {
                return "AppBrandAdWorkerHelper$convertToAdWorkerExecutable@" + this.f129702a.hashCode();
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final com.tencent.luggage.wxa.ei.p a(com.tencent.luggage.wxa.b9.t engine) {
            Intrinsics.checkNotNullParameter(engine, "engine");
            return new C6293a(engine);
        }
    }

    public static final com.tencent.luggage.wxa.ei.p a(com.tencent.luggage.wxa.b9.t tVar) {
        return f129701a.a(tVar);
    }
}
