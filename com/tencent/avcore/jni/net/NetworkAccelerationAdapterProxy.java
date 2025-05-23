package com.tencent.avcore.jni.net;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes3.dex */
public class NetworkAccelerationAdapterProxy implements INetworkAccelerationAdapter {
    static IPatchRedirector $redirector_;
    private static NetworkAccelerationAdapterProxy sProxy;
    private INetworkAccelerationAdapter mImpl;
    private Boolean mIsSupport;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16080);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            sProxy = null;
        }
    }

    NetworkAccelerationAdapterProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mImpl = null;
        }
    }

    public static NetworkAccelerationAdapterProxy getInstance() {
        if (sProxy == null) {
            synchronized (NetworkAccelerationAdapterProxy.class) {
                if (sProxy == null) {
                    sProxy = new NetworkAccelerationAdapterProxy();
                }
            }
        }
        return sProxy;
    }

    @Override // com.tencent.avcore.jni.net.INetworkAccelerationAdapter
    public void bindToNetInterface(SocketInfo socketInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) socketInfo);
        } else {
            if (!isSupport()) {
                return;
            }
            this.mImpl.bindToNetInterface(socketInfo);
        }
    }

    public void init(INetworkAccelerationAdapter iNetworkAccelerationAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iNetworkAccelerationAdapter);
        } else {
            this.mImpl = iNetworkAccelerationAdapter;
        }
    }

    public boolean isInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.mImpl != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.avcore.jni.net.INetworkAccelerationAdapter
    public boolean isSupport() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.mIsSupport == null) {
            INetworkAccelerationAdapter iNetworkAccelerationAdapter = this.mImpl;
            if (iNetworkAccelerationAdapter != null && iNetworkAccelerationAdapter.isSupport()) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mIsSupport = Boolean.valueOf(z16);
        }
        return this.mIsSupport.booleanValue();
    }

    @Override // com.tencent.avcore.jni.net.INetworkAccelerationAdapter
    public void startRoomAccelerate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            if (!isSupport()) {
                return;
            }
            this.mImpl.startRoomAccelerate();
        }
    }

    @Override // com.tencent.avcore.jni.net.INetworkAccelerationAdapter
    public void stopRoomAccelerate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            if (!isSupport()) {
                return;
            }
            this.mImpl.stopRoomAccelerate();
        }
    }

    @Override // com.tencent.avcore.jni.net.INetworkAccelerationAdapter
    public void unBindToNetInterface(SocketInfo socketInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) socketInfo);
        } else {
            if (!isSupport()) {
                return;
            }
            this.mImpl.unBindToNetInterface(socketInfo);
        }
    }
}
