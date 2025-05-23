package com.tencent.luggage.wxa.k2;

import android.telephony.TelephonyManager;
import com.tencent.luggage.wxa.qm.k;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.zp.h;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.k2.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6353a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f131414a;

        public RunnableC6353a(String str) {
            this.f131414a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.y9.a.makeText(z.c(), this.f131414a, 0).show();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static a f131416a = new a();
    }

    public static a a() {
        return b.f131416a;
    }

    public final String b() {
        if (d()) {
            return z.c().getString(R.string.f159931tn);
        }
        if (c()) {
            return z.c().getString(R.string.f159941to);
        }
        return null;
    }

    public final boolean c() {
        if (com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.uc.e.class) == null) {
            return false;
        }
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.uc.e.class));
        throw null;
    }

    public final boolean d() {
        boolean z16;
        TelephonyManager telephonyManager;
        try {
            telephonyManager = (TelephonyManager) z.c().getSystemService("phone");
        } catch (Exception e16) {
            e = e16;
            z16 = false;
        }
        if (telephonyManager == null) {
            return false;
        }
        int callState = SystemMethodProxy.getCallState(telephonyManager);
        if (callState != 1 && callState != 2) {
            z16 = false;
        } else {
            z16 = true;
        }
        try {
            w.d("MicroMsg.GlobalMusicFloatBallHelper", "isPhoneInUse, isPhoneInUse:%s, callState:%s", Boolean.valueOf(z16), Integer.valueOf(callState));
        } catch (Exception e17) {
            e = e17;
            w.a("MicroMsg.GlobalMusicFloatBallHelper", e, "isPhoneInUse, exception:%s", e);
            return z16;
        }
        return z16;
    }

    public final boolean e() {
        String b16 = b();
        if (w0.c(b16)) {
            return false;
        }
        com.tencent.luggage.wxa.rb.a.g();
        h.f146825d.a(new RunnableC6353a(b16));
        return true;
    }

    public void a(com.tencent.luggage.wxa.p9.h hVar) {
        if (!k.i()) {
            w.b("MicroMsg.GlobalMusicFloatBallHelper", "floatBallMusicActionListener don't anything, must init MusicPlayerManager first with MusicLogic before!");
            return;
        }
        int i3 = hVar.f137468d.f137469a;
        if (i3 == 0 || i3 == 1) {
            e();
        }
    }
}
