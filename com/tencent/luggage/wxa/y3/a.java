package com.tencent.luggage.wxa.y3;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.qbar.QbarNative;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C6933a f145414a = new C6933a(null);

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f145415b;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.y3.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C6933a {
        public C6933a() {
        }

        public /* synthetic */ C6933a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            boolean z16;
            Boolean bool = a.f145415b;
            if (bool == null) {
                try {
                    QbarNative.QBarReportMsg.class.getDeclaredField("qrcodeVersion");
                    z16 = true;
                } catch (ClassNotFoundException | NoSuchFieldException unused) {
                    z16 = false;
                }
                bool = Boolean.valueOf(z16);
            }
            a.f145415b = bool;
            w.d("Luggage.ScannerUtil", "is wxa qbar ready: " + a.f145415b);
            Boolean bool2 = a.f145415b;
            Intrinsics.checkNotNull(bool2);
            return bool2.booleanValue();
        }
    }
}
