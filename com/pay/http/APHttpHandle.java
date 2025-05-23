package com.pay.http;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.midas.comm.APLog;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class APHttpHandle extends Handler {
    private static APHttpHandle handle;
    private static byte[] lock = new byte[0];
    private HashMap<String, IAPHttpAnsObserver> observerMap = new HashMap<>();

    APHttpHandle() {
    }

    public static APHttpHandle getIntanceHandel() {
        synchronized (lock) {
            if (handle == null) {
                try {
                    if (Thread.currentThread() != Looper.getMainLooper().getThread() && Looper.myLooper() == null) {
                        Looper.prepare();
                    }
                } catch (Exception e16) {
                    APLog.i("APHttpHandle", e16.toString());
                }
                handle = new APHttpHandle();
            }
        }
        return handle;
    }

    private void runObserverOnMainThread(Message message) {
        try {
            int i3 = message.what;
            APBaseHttpAns aPBaseHttpAns = (APBaseHttpAns) message.obj;
            String httpReqKey = aPBaseHttpAns.getHttpReqKey();
            IAPHttpAnsObserver iAPHttpAnsObserver = this.observerMap.get(httpReqKey);
            if (iAPHttpAnsObserver == null) {
                Log.i("HttpHandler", "observer is null");
                return;
            }
            unregister(httpReqKey);
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 == 5) {
                        iAPHttpAnsObserver.onStop(aPBaseHttpAns);
                        return;
                    }
                    return;
                }
                iAPHttpAnsObserver.onError(aPBaseHttpAns);
                return;
            }
            iAPHttpAnsObserver.onFinish(aPBaseHttpAns);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        runObserverOnMainThread(message);
    }

    public void register(String str, IAPHttpAnsObserver iAPHttpAnsObserver) {
        HashMap<String, IAPHttpAnsObserver> hashMap = this.observerMap;
        if (hashMap != null) {
            hashMap.put(str, iAPHttpAnsObserver);
        }
    }

    public void release() {
        handle = null;
    }

    public void unregister(String str) {
        HashMap<String, IAPHttpAnsObserver> hashMap = this.observerMap;
        if (hashMap != null) {
            hashMap.remove(str);
        }
    }
}
