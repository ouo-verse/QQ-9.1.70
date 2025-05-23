package com.tencent.mobileqq.channel;

import com.tencent.mobileqq.fe.CmdWhiteListChangeCallback;
import com.tencent.mobileqq.fe.FEKit;
import com.tencent.mobileqq.fe.e;
import com.tencent.mobileqq.fe.h;
import com.tencent.mobileqq.fe.utils.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ChannelManager {
    static IPatchRedirector $redirector_;
    private static ChannelManager mInstance;
    private ChannelProxy mChannelProxy;

    ChannelManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static ChannelManager getInstance() {
        if (mInstance == null) {
            synchronized (ChannelManager.class) {
                if (mInstance == null) {
                    mInstance = new ChannelManager();
                }
            }
        }
        return mInstance;
    }

    private native void initReport();

    public native ArrayList<String> getCmdWhiteList();

    public void init(ChannelProxy channelProxy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) channelProxy);
            return;
        }
        this.mChannelProxy = channelProxy;
        setNativeChannel();
        a.a().c(new Runnable() { // from class: com.tencent.mobileqq.channel.ChannelManager.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChannelManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    ChannelManagerImpl.onChannelReady();
                }
            }
        }, 3000L);
    }

    public native void onChannelReady();

    public native void onMsfConnected();

    public native void onNativeReceive(String str, byte[] bArr, boolean z16, int i3, long j3);

    public void onReceive(String str, byte[] bArr, boolean z16, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, bArr, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3));
        } else if (e.b().e()) {
            a.a().b(new Runnable(j3, str, bArr, z16, i3) { // from class: com.tencent.mobileqq.channel.ChannelManager.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ long val$callbackId;
                final /* synthetic */ String val$cmd;
                final /* synthetic */ int val$code;
                final /* synthetic */ byte[] val$data;
                final /* synthetic */ boolean val$succ;

                {
                    this.val$callbackId = j3;
                    this.val$cmd = str;
                    this.val$data = bArr;
                    this.val$succ = z16;
                    this.val$code = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ChannelManager.this, Long.valueOf(j3), str, bArr, Boolean.valueOf(z16), Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (h.c(this.val$callbackId)) {
                        h.b(this.val$cmd, this.val$data, this.val$succ, this.val$code, this.val$callbackId);
                    } else {
                        ChannelManager.this.onNativeReceive(this.val$cmd, this.val$data, this.val$succ, this.val$code, this.val$callbackId);
                    }
                }
            });
        }
    }

    public void sendMessage(String str, byte[] bArr, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, bArr, Long.valueOf(j3));
        } else {
            this.mChannelProxy.sendMessage(str, bArr, j3);
        }
    }

    public native void sendMessageTest();

    public native void setChannelProxy(ChannelProxy channelProxy);

    public native void setCmdWhiteListChangeCallback(CmdWhiteListChangeCallback cmdWhiteListChangeCallback);

    public void setNativeChannel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (FEKit.getInstance().checkStatus()) {
            setChannelProxy(this.mChannelProxy);
            onChannelReady();
            initReport();
        }
    }

    public void onReceive(String str, byte[] bArr, boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            onReceive(str, bArr, z16, -1, j3);
        } else {
            iPatchRedirector.redirect((short) 6, this, str, bArr, Boolean.valueOf(z16), Long.valueOf(j3));
        }
    }
}
