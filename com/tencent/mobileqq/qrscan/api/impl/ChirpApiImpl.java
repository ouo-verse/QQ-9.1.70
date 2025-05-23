package com.tencent.mobileqq.qrscan.api.impl;

import android.util.Pair;
import com.tencent.chirp.ChirpWrapper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qrscan.api.IChirpApi;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ChirpApiImpl implements IChirpApi {
    static IPatchRedirector $redirector_;
    ChirpWrapper chirp;

    public ChirpApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IChirpApi
    public Pair<Integer, short[]> encode(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Pair) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        ChirpWrapper chirpWrapper = this.chirp;
        if (chirpWrapper != null) {
            return chirpWrapper.b(str);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qrscan.api.IChirpApi
    public synchronized int init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        if (this.chirp == null) {
            this.chirp = new ChirpWrapper();
        }
        return this.chirp.c();
    }

    @Override // com.tencent.mobileqq.qrscan.api.IChirpApi
    public boolean loadLibrary() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return ChirpWrapper.d();
    }

    @Override // com.tencent.mobileqq.qrscan.api.IChirpApi
    public synchronized void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        ChirpWrapper chirpWrapper = this.chirp;
        if (chirpWrapper != null) {
            chirpWrapper.e();
            this.chirp = null;
        }
    }
}
