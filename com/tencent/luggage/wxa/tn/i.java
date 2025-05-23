package com.tencent.luggage.wxa.tn;

import android.content.Context;
import android.text.ClipboardManager;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i {
    public void a(Context context, CharSequence charSequence, CharSequence charSequence2) {
        ((ClipboardManager) z.c().getSystemService("clipboard")).setText(charSequence2);
    }
}
