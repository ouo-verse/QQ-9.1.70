package com.tencent.mobileqq.channel;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* loaded from: classes11.dex */
public abstract class ChannelProxy {
    static IPatchRedirector $redirector_;
    private Handler mReceiveHandler;
    private HandlerThread mReceiveThread;

    public ChannelProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void onReceive(String str, byte[] bArr, boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, bArr, Boolean.valueOf(z16), Long.valueOf(j3));
            return;
        }
        if (this.mReceiveThread == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("FEKit_Receive_0");
            this.mReceiveThread = baseHandlerThread;
            baseHandlerThread.start();
            this.mReceiveHandler = new Handler(this.mReceiveThread.getLooper());
        }
        this.mReceiveHandler.post(new Runnable(str, bArr, z16, j3) { // from class: com.tencent.mobileqq.channel.ChannelProxy.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ long val$callbackId;
            final /* synthetic */ String val$cmd;
            final /* synthetic */ byte[] val$data;
            final /* synthetic */ boolean val$succ;

            {
                this.val$cmd = str;
                this.val$data = bArr;
                this.val$succ = z16;
                this.val$callbackId = j3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, ChannelProxy.this, str, bArr, Boolean.valueOf(z16), Long.valueOf(j3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    ChannelManager.getInstance().onReceive(this.val$cmd, this.val$data, this.val$succ, this.val$callbackId);
                }
            }
        });
    }

    public abstract void sendMessage(String str, byte[] bArr, long j3);
}
