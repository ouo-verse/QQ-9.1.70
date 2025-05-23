package com.tencent.luggage.wxa.tf;

import android.content.Context;
import android.nfc.NfcAdapter;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {
    public static boolean a() {
        return true;
    }

    public static boolean b() {
        if (a()) {
            return z.c().getPackageManager().hasSystemFeature("android.hardware.nfc.hce");
        }
        return false;
    }

    public static boolean c() {
        Context c16 = z.c();
        if (!c16.getPackageManager().hasSystemFeature("android.hardware.nfc") || NfcAdapter.getDefaultAdapter(c16) == null) {
            return false;
        }
        return true;
    }

    public static boolean d() {
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(z.c());
        if (defaultAdapter == null) {
            w.d("MicroMsg.HceUtils", "alvinluo no nfc chip !");
            return false;
        }
        if (!defaultAdapter.isEnabled()) {
            return false;
        }
        return true;
    }
}
