package com.tencent.luggage.wxa.x2;

import android.content.Context;
import com.tencent.luggage.wxa.kj.k1;
import com.tencent.luggage.wxa.kj.m0;
import com.tencent.luggage.wxa.kj.o0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class b extends com.tencent.luggage.wxa.kj.a {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.luggage.wxa.xd.d t16 = b.this.t();
            Intrinsics.checkNotNull(t16);
            ((com.tencent.luggage.wxa.m4.b) t16).e("onLoadURL");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull com.tencent.luggage.wxa.m4.b p16) {
        super(p16);
        Intrinsics.checkNotNullParameter(p16, "p");
    }

    @Override // com.tencent.luggage.wxa.kj.a, com.tencent.luggage.wxa.kj.x
    public boolean a(String str, k1 type) {
        Intrinsics.checkNotNullParameter(type, "type");
        com.tencent.luggage.wxa.xd.d t16 = t();
        Intrinsics.checkNotNull(t16);
        ((com.tencent.luggage.wxa.m4.b) t16).a(new a());
        return true;
    }

    @Override // com.tencent.luggage.wxa.kj.a
    public o0 b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new m0();
    }
}
