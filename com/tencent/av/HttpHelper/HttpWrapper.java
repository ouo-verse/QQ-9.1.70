package com.tencent.av.HttpHelper;

import android.util.Log;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes3.dex */
public class HttpWrapper {
    public static final String tag = "HttpWrapper";

    public static void send(final byte[] bArr, final String str) {
        Log.e(tag, "send called with Buffer" + str + "end");
        new BaseThread(new Runnable() { // from class: com.tencent.av.HttpHelper.HttpWrapper.1
            @Override // java.lang.Runnable
            public void run() {
                HttpHelper.httpPostRequest(str, bArr, null, null, null);
            }
        }).start();
    }
}
