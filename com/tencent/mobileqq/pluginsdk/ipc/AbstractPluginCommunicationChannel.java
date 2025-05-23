package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public abstract class AbstractPluginCommunicationChannel extends PluginCommunicationChannel.Stub {
    static IPatchRedirector $redirector_;

    public AbstractPluginCommunicationChannel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel
    public Bundle transfer(String str, Bundle bundle) throws RemoteException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bundle) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) bundle);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel
    public void transferAsync(String str, Bundle bundle, RemoteCallback remoteCallback) throws RemoteException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, bundle, remoteCallback);
        }
    }
}
