package com.tencent.live2.impl.a;

import android.os.Bundle;
import com.tencent.live2.V2TXLivePusherObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class b extends V2TXLivePusherObserver {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void onEnterRoom(long j3);

    public abstract void onExitRoom(int i3);

    public abstract void onNetworkQuality(int i3);

    public abstract void onPushEvent(int i3, Bundle bundle);

    public abstract void onPushNetStatus(Bundle bundle);

    public abstract void onRemoteUserEnter(String str);

    public abstract void onRemoteUserExit(String str, int i3);

    public abstract void onUserAudioAvailable(String str, boolean z16);

    public abstract void onUserVideoAvailable(String str, int i3, boolean z16);
}
