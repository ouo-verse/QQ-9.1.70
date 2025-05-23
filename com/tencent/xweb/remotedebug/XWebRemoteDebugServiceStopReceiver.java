package com.tencent.xweb.remotedebug;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.tq.d;
import com.tencent.luggage.wxa.tq.g;
import com.tencent.xweb.WebView;
import com.tencent.xweb.internal.ConstValue;

/* compiled from: P */
/* loaded from: classes27.dex */
public class XWebRemoteDebugServiceStopReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        x0.d("XWebRemoteDebugServiceStopReceiver", "onReceive, stop remote debug service");
        d a16 = g.a(WebView.getCurrentModuleWebCoreType());
        if (a16 != null) {
            a16.invokeRuntimeChannel(ConstValue.INVOKE_RUNTIME_ID_STOP_REMOTE_DEBUG, new Object[0]);
        } else {
            x0.f("XWebRemoteDebugServiceStopReceiver", "onReceive, current process has not init core yet");
        }
    }
}
