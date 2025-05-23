package com.tencent.mobileqq.ptt.pttspeed;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes16.dex */
public class Sonic {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    long f261290a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36780);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            System.loadLibrary("sonic");
        }
    }

    public Sonic(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f261290a = 0L;
        b();
        this.f261290a = initNative(i3, i16);
    }

    private native int availableBytesNative(long j3);

    private native void closeNative(long j3);

    private native void flushNative(long j3);

    private native boolean getChordPitchNative(long j3);

    private native int getNumChannelsNative(long j3);

    private native float getPitchNative(long j3);

    private native float getRateNative(long j3);

    private native int getSampleRateNative(long j3);

    private native float getSpeedNative(long j3);

    private native float getVolumeNative(long j3);

    private native long initNative(int i3, int i16);

    private native boolean putBytesNative(long j3, byte[] bArr, int i3);

    private native int receiveBytesNative(long j3, byte[] bArr, int i3);

    private native void setChordPitchNative(long j3, boolean z16);

    private native void setNumChannelsNative(long j3, int i3);

    private native void setPitchNative(long j3, float f16);

    private native void setRateNative(long j3, float f16);

    private native void setSampleRateNative(long j3, int i3);

    private native void setSpeedNative(long j3, float f16);

    private native void setVolumeNative(long j3, float f16);

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return availableBytesNative(this.f261290a);
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        long j3 = this.f261290a;
        if (j3 != 0) {
            closeNative(j3);
            this.f261290a = 0L;
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            flushNative(this.f261290a);
        }
    }

    public boolean d(byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) bArr, i3)).booleanValue();
        }
        return putBytesNative(this.f261290a, bArr, i3);
    }

    public int e(byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this, (Object) bArr, i3)).intValue();
        }
        return receiveBytesNative(this.f261290a, bArr, i3);
    }

    public void f(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
        } else {
            setSpeedNative(this.f261290a, f16);
        }
    }

    protected void finalize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            b();
        }
    }
}
