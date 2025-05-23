package com.tencent.turingcam;

import android.content.Context;
import android.content.pm.Signature;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes27.dex */
public class gELYz {
    public static Signature[] a(Context context, String str) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 64).signatures;
        } catch (Throwable unused) {
            return null;
        }
    }
}
