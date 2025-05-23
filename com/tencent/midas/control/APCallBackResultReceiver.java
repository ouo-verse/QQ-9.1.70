package com.tencent.midas.control;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.midas.comm.APLog;

/* loaded from: classes9.dex */
public class APCallBackResultReceiver extends ResultReceiver {
    private Receiver mReceiver;

    /* loaded from: classes9.dex */
    public interface Receiver {
        void onReceiveResult(int i3, Bundle bundle);
    }

    public APCallBackResultReceiver(Handler handler) {
        super(handler);
    }

    @Override // android.os.ResultReceiver
    protected void onReceiveResult(int i3, Bundle bundle) {
        APLog.i("APCallBackResultReceiver", "onReceiveResult resultCode:" + i3 + " mReceiver:" + this.mReceiver);
        Receiver receiver = this.mReceiver;
        if (receiver != null) {
            receiver.onReceiveResult(i3, bundle);
        }
    }

    public void setReceiver(Receiver receiver) {
        this.mReceiver = receiver;
    }
}
