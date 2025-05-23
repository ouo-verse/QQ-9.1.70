package com.tencent.luggage.wxa.ta;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements com.tencent.luggage.wxa.ua.a {
    public int a() {
        return 4;
    }

    @Override // com.tencent.luggage.wxa.ua.a
    public void a(int i3, String str, String str2, Object... objArr) {
        if (i3 < a()) {
            return;
        }
        Log.println(i3, str, String.format(str2, objArr));
    }
}
