package com.immersion.touchsensesdk;

import android.util.Log;
import java.net.SocketTimeoutException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ConnectionProxy implements IConnectionListener, IConnectionProxy {
    private static final String TAG = "ConnectionProxy";
    private boolean mAborted;
    private Object mConnectionLock = new Object();
    private boolean mGotResponse;
    private AsyncConnectionProxy mProxy;
    private IConnection mResponse;

    public ConnectionProxy(AsyncConnectionProxy asyncConnectionProxy) {
        this.mProxy = asyncConnectionProxy;
        asyncConnectionProxy.setConnectionListener(this);
    }

    public void abort() {
        synchronized (this.mConnectionLock) {
            this.mResponse = null;
            this.mAborted = true;
            this.mConnectionLock.notifyAll();
        }
    }

    @Override // com.immersion.touchsensesdk.IConnectionProxy
    public synchronized IConnection connect(String str, int i3, int i16) throws SocketTimeoutException {
        IConnection iConnection;
        synchronized (this.mConnectionLock) {
            long j3 = i3;
            if (!this.mAborted) {
                this.mGotResponse = false;
                this.mResponse = null;
                this.mProxy.connect(str, i3, i16);
                try {
                    long nanoTime = System.nanoTime();
                    long j16 = j3;
                    while (!this.mGotResponse && !this.mAborted && j16 > 0) {
                        this.mConnectionLock.wait(j16);
                        j16 = j3 - ((System.nanoTime() - nanoTime) / 1000000);
                    }
                    j3 = j16;
                } catch (InterruptedException e16) {
                    Log.w(TAG, "Connection wait interrupted.");
                    e16.printStackTrace();
                    throw new SocketTimeoutException();
                }
            }
            if (!this.mAborted) {
                iConnection = this.mResponse;
                if (iConnection == null) {
                    if (j3 <= 0) {
                        Log.w(TAG, "Connection timeout.");
                        throw new SocketTimeoutException();
                    }
                    Log.w(TAG, "Connection response is null.");
                    throw new SocketTimeoutException();
                }
            } else {
                Log.i(TAG, "Connection aborted.");
                throw new SocketTimeoutException();
            }
        }
        return iConnection;
    }

    @Override // com.immersion.touchsensesdk.IConnectionListener
    public void notifyConnection(IConnection iConnection) {
        synchronized (this.mConnectionLock) {
            this.mGotResponse = true;
            this.mResponse = iConnection;
            this.mConnectionLock.notify();
        }
    }
}
