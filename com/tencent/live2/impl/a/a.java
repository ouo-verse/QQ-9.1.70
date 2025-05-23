package com.tencent.live2.impl.a;

import android.os.Bundle;
import com.tencent.live2.V2TXLivePlayerObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class a extends V2TXLivePlayerObserver {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void onNetworkQuality(int i3);

    public abstract void onPlayEvent(int i3, Bundle bundle);

    public abstract void onPlayNetStatus(Bundle bundle);
}
