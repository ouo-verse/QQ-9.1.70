package com.tencent.luggage.wxa.dm;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends e {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.jq.g {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.f
        public String getKey() {
            return "Base64IconLoader";
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                c cVar = c.this;
                c.this.a(cVar.a(cVar.f124383a));
            } catch (Exception unused) {
                c cVar2 = c.this;
                cVar2.f124385c.a("Failed to load icon via base64 icon", cVar2);
            }
        }
    }

    public c(String str, d dVar) {
        super(str, dVar);
    }

    @Override // com.tencent.luggage.wxa.dm.e
    public void e() {
        if (this.f124383a != null) {
            com.tencent.luggage.wxa.zp.h.f146825d.execute(new a());
        } else {
            this.f124385c.a("Failed to load icon via base64 icon", this);
        }
    }

    public final Bitmap a(String str) {
        byte[] decode = Base64.decode(str, 0);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
        if (decodeByteArray == null) {
            this.f124385c.a("Failed to load icon via base64 icon", this);
        }
        return decodeByteArray;
    }
}
