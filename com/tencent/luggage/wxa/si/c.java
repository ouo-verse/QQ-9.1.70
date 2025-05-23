package com.tencent.luggage.wxa.si;

import android.text.TextUtils;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {
    public static boolean a(b bVar) {
        if (!TextUtils.isEmpty(bVar.f140375e) && bVar.f140371a >= 0 && bVar.f140374d > 0 && bVar.f140372b > 0 && bVar.f140373c > 0) {
            return true;
        }
        return false;
    }

    public static void b(b bVar) {
        w.d("MicroMsg.Record.RecordParamCompatibility", "recordParam duration:%d, numberOfChannels:%d, sampleRate:%d, encodeBitRate:%d", Integer.valueOf(bVar.f140371a), Integer.valueOf(bVar.f140373c), Integer.valueOf(bVar.f140372b), Integer.valueOf(bVar.f140374d));
        int i3 = bVar.f140371a;
        if (i3 <= 0) {
            bVar.f140371a = 60000;
        } else if (i3 >= 600000) {
            bVar.f140371a = 600000;
        }
        int i16 = bVar.f140373c;
        if (i16 < 1 && i16 > 2) {
            bVar.f140373c = 2;
        }
        int i17 = bVar.f140372b;
        if (i17 > 48000) {
            bVar.f140372b = 48000;
        } else if (i17 < 8000) {
            bVar.f140372b = 8000;
        }
        int i18 = bVar.f140374d;
        if (i18 > 320000) {
            bVar.f140374d = 320000;
        } else if (i18 < 16000) {
            bVar.f140374d = 16000;
        }
    }
}
