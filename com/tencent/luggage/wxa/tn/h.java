package com.tencent.luggage.wxa.tn;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h {
    public void a(Context context, CharSequence charSequence, CharSequence charSequence2) {
        ClipboardMonitor.setPrimaryClip((ClipboardManager) z.c().getSystemService("clipboard"), ClipData.newPlainText(charSequence, charSequence2));
    }
}
