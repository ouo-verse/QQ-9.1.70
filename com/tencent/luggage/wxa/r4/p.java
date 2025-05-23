package com.tencent.luggage.wxa.r4;

import android.webkit.JavascriptInterface;
import com.tencent.mm.plugin.appbrand.debugger.RemoteDebugJsEngine;

/* compiled from: P */
/* loaded from: classes8.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public RemoteDebugJsEngine f139233a;

    public p(d dVar) {
    }

    public void a(RemoteDebugJsEngine remoteDebugJsEngine) {
        this.f139233a = remoteDebugJsEngine;
    }

    @JavascriptInterface
    public void sendCustomMessage(String str, String str2) {
        RemoteDebugJsEngine remoteDebugJsEngine = this.f139233a;
        if (remoteDebugJsEngine != null) {
            remoteDebugJsEngine.b(str, str2);
        }
    }

    @JavascriptInterface
    public void sendMessage(String str, String str2) {
    }
}
