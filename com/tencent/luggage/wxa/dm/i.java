package com.tencent.luggage.wxa.dm;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.mc.k0;
import com.tencent.luggage.wxa.tn.w0;
import java.io.Closeable;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i extends e {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.jq.g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.g f124392a;

        public a(com.tencent.luggage.wxa.ic.g gVar) {
            this.f124392a = gVar;
        }

        @Override // com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.f
        public String getKey() {
            return "PackageIconLoader";
        }

        @Override // java.lang.Runnable
        public void run() {
            InputStream d16 = k0.d(this.f124392a, i.this.f124383a);
            Bitmap decodeStream = BitmapFactory.decodeStream(d16);
            if (decodeStream == null) {
                i iVar = i.this;
                iVar.f124385c.a("Failed to load icon via package path", iVar);
            } else {
                i.this.a(decodeStream);
            }
            if (d16 != null) {
                w0.a((Closeable) d16);
            }
        }
    }

    public i(String str, d dVar, l lVar) {
        super(str, dVar, lVar);
    }

    @Override // com.tencent.luggage.wxa.dm.e
    public void e() {
        com.tencent.luggage.wxa.ic.g runtime = this.f124384b.getRuntime();
        if (runtime != null && this.f124383a != null) {
            com.tencent.luggage.wxa.zp.h.f146825d.execute(new a(runtime));
        }
    }
}
