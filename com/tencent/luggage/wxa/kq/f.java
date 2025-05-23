package com.tencent.luggage.wxa.kq;

import android.os.Message;
import com.tencent.luggage.wxa.kq.c;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f extends c {

    /* renamed from: h, reason: collision with root package name */
    public final Object f132742h;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends c.h {
        public a(Message message) {
            super(message);
        }

        @Override // com.tencent.luggage.wxa.kq.c.h, java.lang.Runnable
        public void run() {
            synchronized (f.this.f132742h) {
                super.run();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(com.tencent.luggage.wxa.kq.a serial) {
        super(serial);
        Intrinsics.checkNotNullParameter(serial, "serial");
        this.f132742h = new Object();
    }

    @Override // com.tencent.luggage.wxa.kq.c
    public c.h b(Message message) {
        return new a(message);
    }
}
