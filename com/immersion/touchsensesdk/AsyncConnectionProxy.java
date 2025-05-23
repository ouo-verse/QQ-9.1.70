package com.immersion.touchsensesdk;

/* loaded from: classes2.dex */
public abstract class AsyncConnectionProxy {
    private IConnectionListener mListener;

    public abstract void connect(String str, int i3, int i16);

    public IConnectionProxy getConnectionProxy() {
        return new ConnectionProxy(this);
    }

    public void setConnection(IConnection iConnection) {
        IConnectionListener iConnectionListener = this.mListener;
        if (iConnectionListener != null) {
            iConnectionListener.notifyConnection(iConnection);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setConnectionListener(IConnectionListener iConnectionListener) {
        this.mListener = iConnectionListener;
    }
}
