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
public final class g extends com.tencent.luggage.wxa.uf.b {
    public static final int CTRL_INDEX = 841;

    @NotNull
    public static final String NAME = "NFCGetAtqa";

    /* renamed from: f, reason: collision with root package name */
    public static final b f142329f = new b(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f142330a = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            byte[] bArr;
            if (obj != null && (obj instanceof byte[])) {
                bArr = (byte[]) obj;
            } else {
                bArr = new byte[0];
            }
            byte[] encode = Base64.encode(bArr, 2);
            Intrinsics.checkNotNullExpressionValue(encode, "encode(byteArray, Base64.NO_WRAP)");
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            return new String(encode, UTF_8);
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

    public g() {
        super(com.tencent.luggage.wxa.wf.b.f144219h.f(), "getAtqa", "atqa", a.f142330a);
    }
}
