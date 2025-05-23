package com.tencent.open.appcommon.js;

import android.os.Handler;
import android.os.Message;
import com.tencent.smtt.sdk.WebView;

/* compiled from: P */
/* loaded from: classes22.dex */
public class g extends Handler {
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        f fVar;
        WebView webView;
        String str;
        if (message.what == 0 && (fVar = (f) message.obj) != null && (webView = fVar.f340702a) != null && (str = fVar.f340703b) != null) {
            try {
                webView.loadUrl(str);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }
}
