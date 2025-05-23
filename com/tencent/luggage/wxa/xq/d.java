package com.tencent.luggage.wxa.xq;

import android.webkit.WebStorage;

/* compiled from: P */
/* loaded from: classes9.dex */
public class d implements com.tencent.luggage.wxa.tq.b {
    @Override // com.tencent.luggage.wxa.tq.b
    public void deleteOrigin(String str) {
        WebStorage.getInstance().deleteOrigin(str);
    }
}
