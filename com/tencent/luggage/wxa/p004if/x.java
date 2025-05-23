package com.tencent.luggage.wxa.p004if;

import com.tencent.luggage.wxa.bo.b;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class x extends j {
    public static final int CTRL_INDEX = 217;
    public static final String NAME = "saveImageToPhotosAlbum";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.y9.a.makeText(z.c(), z.c().getString(R.string.zpf, b.b()), 1).show();
        }
    }

    @Override // com.tencent.luggage.wxa.p004if.j
    public boolean b(String str) {
        return w0.d(str).toLowerCase().contains("image");
    }

    @Override // com.tencent.luggage.wxa.p004if.j
    public String c(String str) {
        return b.b(str);
    }

    @Override // com.tencent.luggage.wxa.p004if.j
    public void d(String str) {
        c0.a(new a());
    }
}
