package com.tencent.luggage.wxa.yp;

import android.util.Log;
import com.tencent.luggage.wxa.yp.b;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class a implements b.InterfaceC6963b {
    @Override // com.tencent.luggage.wxa.yp.b.InterfaceC6963b
    public boolean a(String str, int i3) {
        return Log.isLoggable(str, i3);
    }

    @Override // com.tencent.luggage.wxa.yp.b.InterfaceC6963b
    public void println(int i3, String str, String str2) {
        Log.println(i3, str, str2);
    }
}
