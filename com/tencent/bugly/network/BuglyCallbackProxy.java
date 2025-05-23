package com.tencent.bugly.network;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* loaded from: classes5.dex */
public class BuglyCallbackProxy implements Callback {
    private final Callback realCallback;

    public BuglyCallbackProxy(Callback callback) {
        this.realCallback = callback;
    }

    protected void callEnd(Call call) {
        BuglyListenerFactory.getInstance().onCallEnd(call, false, null);
    }

    protected void callFailed(Call call, IOException iOException) {
        BuglyListenerFactory.getInstance().onCallEnd(call, true, iOException);
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        try {
            Callback callback = this.realCallback;
            if (callback != null) {
                callback.onFailure(call, iOException);
            }
        } catch (Throwable unused) {
        }
        callFailed(call, iOException);
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        IOException e16;
        boolean z16 = false;
        try {
            Callback callback = this.realCallback;
            if (callback != null) {
                callback.onResponse(call, response);
            }
            if (response != null) {
                if (response.isSuccessful()) {
                    z16 = true;
                }
            }
            e16 = null;
        } catch (IOException e17) {
            e16 = e17;
        } catch (Throwable th5) {
            e16 = new IOException(th5.getMessage() + " " + response);
        }
        if (z16) {
            callEnd(call);
            return;
        }
        if (e16 == null) {
            e16 = new IOException("Unexpected code: " + response);
        }
        callFailed(call, e16);
    }
}
