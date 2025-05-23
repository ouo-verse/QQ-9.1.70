package com.tencent.luggage.wxa.b9;

import android.text.TextUtils;
import com.eclipsesource.mmv8.MultiContextV8;
import com.tencent.luggage.wxa.b9.d;
import com.tencent.luggage.wxa.b9.k0;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h0 extends com.tencent.luggage.wxa.b9.a {
    public MultiContextV8 B;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements k0.a {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.b9.k0.a
        public void a() {
            h0.this.B.getV8().pumpMessageLoopDirect();
        }
    }

    public h0(d.a aVar) {
        super(aVar);
    }

    @Override // com.tencent.luggage.wxa.b9.a
    public void l() {
        super.l();
        try {
            this.B.release();
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.V8JSRuntime", "commonCleanUp exp = %s", e16);
        }
    }

    @Override // com.tencent.luggage.wxa.b9.a
    public e s() {
        return k0.a(new a(), k().f122194j);
    }

    @Override // com.tencent.luggage.wxa.b9.a
    public MultiContextV8 t() {
        boolean z16;
        String str = this.f122097m;
        String str2 = this.f122092h;
        byte[] bArr = this.f122093i;
        String str3 = this.f122094j;
        if (!TextUtils.isEmpty(str3) && this.f122095k) {
            z16 = true;
        } else {
            z16 = false;
        }
        MultiContextV8 createMultiContextV8 = MultiContextV8.createMultiContextV8(str, str2, bArr, str3, z16, 2);
        this.B = createMultiContextV8;
        this.f122093i = null;
        return createMultiContextV8;
    }

    public static h0 a(d.a aVar) {
        return new h0(aVar);
    }
}
