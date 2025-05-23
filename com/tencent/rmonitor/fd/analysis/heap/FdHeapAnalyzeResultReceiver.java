package com.tencent.rmonitor.fd.analysis.heap;

import a14.c;
import android.os.Bundle;
import android.os.ResultReceiver;

/* compiled from: P */
/* loaded from: classes25.dex */
public class FdHeapAnalyzeResultReceiver extends ResultReceiver {
    @Override // android.os.ResultReceiver
    protected void onReceiveResult(int i3, Bundle bundle) {
        c.d("RMonitor_FdLeak_FdHeapAnalyzeResultReceiver", "onReceiveResult: resultCode=" + i3);
        c.e("RMonitor_FdLeak_FdHeapAnalyzeResultReceiver", "onReceiveResult: listener == null");
    }
}
