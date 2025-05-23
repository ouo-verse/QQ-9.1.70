package com.tencent.timi.game.utils;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class a {
    @TargetApi(11)
    public static void a(Context context, String str) {
        ClipboardMonitor.setPrimaryClip((ClipboardManager) context.getSystemService("clipboard"), ClipData.newPlainText(null, str));
    }
}
