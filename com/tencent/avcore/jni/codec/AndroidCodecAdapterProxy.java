package com.tencent.avcore.jni.codec;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes3.dex */
public class AndroidCodecAdapterProxy implements IAndroidCodecAdapter {
    static IPatchRedirector $redirector_;
    private static AndroidCodecAdapterProxy sProxy;
    private IAndroidCodecAdapter mImpl;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14179);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            sProxy = null;
        }
    }

    AndroidCodecAdapterProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mImpl = null;
        }
    }

    public static AndroidCodecAdapterProxy getInstance() {
        if (sProxy == null) {
            synchronized (AndroidCodecAdapterProxy.class) {
                if (sProxy == null) {
                    sProxy = new AndroidCodecAdapterProxy();
                }
            }
        }
        return sProxy;
    }

    @Override // com.tencent.avcore.jni.codec.IAndroidCodecAdapter
    public AndroidCodecBase createDecCodec(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (AndroidCodecBase) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        IAndroidCodecAdapter iAndroidCodecAdapter = this.mImpl;
        if (iAndroidCodecAdapter != null) {
            return iAndroidCodecAdapter.createDecCodec(str);
        }
        return null;
    }

    @Override // com.tencent.avcore.jni.codec.IAndroidCodecAdapter
    public AndroidCodecBase createEncCodec(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (AndroidCodecBase) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        IAndroidCodecAdapter iAndroidCodecAdapter = this.mImpl;
        if (iAndroidCodecAdapter != null) {
            return iAndroidCodecAdapter.createEncCodec(str);
        }
        return null;
    }

    public void init(IAndroidCodecAdapter iAndroidCodecAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iAndroidCodecAdapter);
        } else {
            this.mImpl = iAndroidCodecAdapter;
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

    @Override // com.tencent.avcore.jni.codec.IAndroidCodecAdapter
    public boolean isSupportAsyncAPI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        IAndroidCodecAdapter iAndroidCodecAdapter = this.mImpl;
        if (iAndroidCodecAdapter != null) {
            return iAndroidCodecAdapter.isSupportAsyncAPI();
        }
        return false;
    }

    @Override // com.tencent.avcore.jni.codec.IAndroidCodecAdapter
    public boolean isSupportHWDecLowLatency() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        IAndroidCodecAdapter iAndroidCodecAdapter = this.mImpl;
        if (iAndroidCodecAdapter != null) {
            return iAndroidCodecAdapter.isSupportHWDecLowLatency();
        }
        return false;
    }

    @Override // com.tencent.avcore.jni.codec.IAndroidCodecAdapter
    public boolean isSupportHWEncCBR() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        IAndroidCodecAdapter iAndroidCodecAdapter = this.mImpl;
        if (iAndroidCodecAdapter != null) {
            return iAndroidCodecAdapter.isSupportHWEncCBR();
        }
        return false;
    }
}
