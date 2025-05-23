package com.tencent.luggage.wxa.p004if;

import android.text.TextUtils;
import com.tencent.luggage.wxa.bo.b;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class y extends j {
    public static final int CTRL_INDEX = 216;
    public static final String NAME = "saveVideoToPhotosAlbum";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f130259a;

        public a(String str) {
            this.f130259a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.y9.a.makeText(z.c(), z.c().getString(R.string.f238147iz, b.d(this.f130259a)), 1).show();
        }
    }

    @Override // com.tencent.luggage.wxa.p004if.j
    public boolean b(String str) {
        return w0.d(str).toLowerCase().contains("video");
    }

    @Override // com.tencent.luggage.wxa.p004if.j
    public String c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "mp4";
        }
        return b.c(str);
    }

    @Override // com.tencent.luggage.wxa.p004if.j
    public void d(String str) {
        c0.a(new a(str));
    }
}
