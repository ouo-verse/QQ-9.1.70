package com.tencent.luggage.wxa.vk;

import android.content.Intent;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d {
    public c a(Intent intent) {
        c cVar = new c();
        cVar.f143643b = b(intent);
        cVar.f143642a = c(intent);
        return cVar;
    }

    public int b(Intent intent) {
        if (intent == null) {
            return -1;
        }
        int intExtra = intent.getIntExtra("level", -1);
        if (intent.getIntExtra("scale", -1) <= 0 || intExtra < 0) {
            return -1;
        }
        return Math.min(Math.max((int) Math.floor((intExtra * 100.0f) / r4), 0), 100);
    }

    public boolean c(Intent intent) {
        if (intent == null) {
            return false;
        }
        int intExtra = intent.getIntExtra("status", -1);
        int intExtra2 = intent.getIntExtra("plugged", 0);
        if (intExtra != 2 && intExtra2 != 1 && intExtra2 != 2 && intExtra2 != 4) {
            return false;
        }
        return true;
    }
}
