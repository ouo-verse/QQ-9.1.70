package com.tencent.luggage.wxa.k1;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.luggage.wxa.hd.a;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends a {
    @Override // com.tencent.luggage.wxa.hd.a.InterfaceC6261a
    public Bitmap a(String str, Rect rect, a.b bVar) {
        return null;
    }

    @Override // com.tencent.luggage.wxa.hd.a.InterfaceC6261a
    public String b() {
        return "NetworkImageReader";
    }

    @Override // com.tencent.luggage.wxa.k1.a
    public void a(String str, a.c cVar) {
    }

    @Override // com.tencent.luggage.wxa.hd.a.InterfaceC6261a
    public boolean a(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.startsWith("http://") || lowerCase.startsWith("https://");
    }
}
