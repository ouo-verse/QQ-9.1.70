package com.tencent.luggage.wxa.uf;

import android.util.Base64;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h extends com.tencent.luggage.wxa.uf.b {
    public static final int CTRL_INDEX = 842;

    @NotNull
    public static final String NAME = "NFCGetHistoricalBytes";

    /* renamed from: f, reason: collision with root package name */
    public static final b f142331f = new b(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f142332a = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            if (obj != null && (obj instanceof byte[])) {
                byte[] encode = Base64.encode((byte[]) obj, 2);
                Intrinsics.checkNotNullExpressionValue(encode, "encode(it, Base64.NO_WRAP)");
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                return new String(encode, UTF_8);
            }
            return null;
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

    public h() {
        super(com.tencent.luggage.wxa.wf.b.f144221j.f(), "getHistoricalBytes", "histBytes", a.f142332a);
    }
}
