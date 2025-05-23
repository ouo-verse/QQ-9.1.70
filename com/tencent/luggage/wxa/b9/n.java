package com.tencent.luggage.wxa.b9;

import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum n {
    R,
    RW;


    /* renamed from: a, reason: collision with root package name */
    public static final a f122252a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final n a(String mode) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            Locale locale = Locale.ROOT;
            String lowerCase = mode.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (Intrinsics.areEqual(lowerCase, "r")) {
                return n.R;
            }
            String lowerCase2 = mode.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (Intrinsics.areEqual(lowerCase2, "rw")) {
                return n.RW;
            }
            return null;
        }
    }

    public static final n a(String str) {
        return f122252a.a(str);
    }
}
