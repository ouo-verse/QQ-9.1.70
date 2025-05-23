package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCModuleManager;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public final class PluginCommunicationHandler {
    static IPatchRedirector $redirector_;
    private static volatile PluginCommunicationHandler sInstance;
    private PluginCommunicationChannelImpl mChannel;
    private HashMap<String, RemoteCommand> mCmdMap;
    private AbstractPluginCommunicationChannel mCustomChannel;

    /* loaded from: classes16.dex */
    public class PluginCommunicationChannelImpl extends PluginCommunicationChannel.Stub {
        static IPatchRedirector $redirector_;

        /* loaded from: classes16.dex */
        private class TransferRunnable implements Runnable {
            static IPatchRedirector $redirector_;
            private RemoteCallback mCb;
            private String mCmd;
            private RemoteCommand.OnInvokeFinishLinstener mListener;
            private Bundle mParams;

            TransferRunnable(String str, Bundle bundle, RemoteCallback remoteCallback) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, PluginCommunicationChannelImpl.this, str, bundle, remoteCallback);
                    return;
                }
                this.mCmd = str;
                this.mCb = remoteCallback;
                this.mParams = bundle;
                if (bundle != null) {
                    bundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
                }
                if (this.mCb != null) {
                    this.mListener = new RemoteCommand.OnInvokeFinishLinstener(PluginCommunicationChannelImpl.this) { // from class: com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler.PluginCommunicationChannelImpl.TransferRunnable.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ PluginCommunicationChannelImpl val$this$1;

                        {
                            this.val$this$1 = r5;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TransferRunnable.this, (Object) r5);
                            }
                        }

                        @Override // com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener
                        public void onInvokeFinish(Bundle bundle2) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bundle2);
                                return;
                            }
                            if (bundle2 != null) {
                                try {
                                    bundle2.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
                                } catch (RemoteException e16) {
                                    if (QLog.isColorLevel()) {
                                        QLog.w("plugin_tag", 2, "tranferAsync ", e16);
                                        return;
                                    }
                                    return;
                                }
                            }
                            TransferRunnable.this.mCb.onRemoteCallback(bundle2);
                        }
                    };
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                RemoteCommand remoteCommand;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    synchronized (PluginCommunicationHandler.this.mCmdMap) {
                        remoteCommand = (RemoteCommand) PluginCommunicationHandler.this.mCmdMap.get(this.mCmd);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("plugin_tag", 2, "tranferAsync," + remoteCommand);
                    }
                    if (remoteCommand == null) {
                        if (QLog.isColorLevel()) {
                            QLog.i("plugin_tag", 2, "no cmd found to invoke, have you already register?");
                            return;
                        }
                        return;
                    } else {
                        if (remoteCommand.isSynchronized()) {
                            Bundle transferInner = PluginCommunicationChannelImpl.this.transferInner(this.mCmd, this.mParams);
                            if (transferInner != null) {
                                try {
                                    transferInner.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
                                } catch (RemoteException e16) {
                                    if (QLog.isColorLevel()) {
                                        QLog.w("plugin_tag", 2, "tranferAsync ", e16);
                                        return;
                                    }
                                    return;
                                }
                            }
                            this.mCb.onRemoteCallback(transferInner);
                            return;
                        }
                        remoteCommand.invoke(this.mParams, this.mListener);
                        return;
                    }
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        public PluginCommunicationChannelImpl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PluginCommunicationHandler.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Bundle transferInner(String str, Bundle bundle) {
            RemoteCommand remoteCommand;
            synchronized (PluginCommunicationHandler.this.mCmdMap) {
                remoteCommand = (RemoteCommand) PluginCommunicationHandler.this.mCmdMap.get(str);
            }
            if (bundle != null) {
                bundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
            }
            Bundle bundle2 = null;
            if (remoteCommand != null) {
                bundle2 = remoteCommand.invoke(bundle, null);
                if (bundle2 != null) {
                    bundle2.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
                }
            } else if (QLog.isColorLevel()) {
                QLog.i("plugin_tag", 2, "no cmd found to invoke, have you already register?");
            }
            return bundle2;
        }

        @Override // com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel
        public String getNickName() throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            if (PluginCommunicationHandler.this.mCustomChannel == null) {
                return null;
            }
            return PluginCommunicationHandler.this.mCustomChannel.getNickName();
        }

        @Override // com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel
        public String getSKey() throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            if (PluginCommunicationHandler.this.mCustomChannel == null) {
                return null;
            }
            return "getSKey";
        }

        @Override // com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel
        public String getSid() throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            if (PluginCommunicationHandler.this.mCustomChannel == null) {
                return null;
            }
            return PluginCommunicationHandler.this.mCustomChannel.getSid();
        }

        @Override // com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel
        public long getUin() throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            if (PluginCommunicationHandler.this.mCustomChannel == null) {
                return 0L;
            }
            return PluginCommunicationHandler.this.mCustomChannel.getUin();
        }

        @Override // com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel
        public Bundle transfer(String str, Bundle bundle) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Bundle) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) bundle);
            }
            return transferInner(str, bundle);
        }

        @Override // com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel
        public void transferAsync(String str, Bundle bundle, RemoteCallback remoteCallback) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, str, bundle, remoteCallback);
            } else {
                EIPCModuleManager.getAsyncHandler().post(new TransferRunnable(str, bundle, remoteCallback));
            }
        }
    }

    PluginCommunicationHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mCmdMap = new HashMap<>();
        }
    }

    public static final PluginCommunicationHandler getInstance() {
        if (sInstance == null) {
            synchronized (PluginCommunicationHandler.class) {
                if (sInstance == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("plugin_tag", 2, "PluginCommunicationHandler.init");
                    }
                    sInstance = new PluginCommunicationHandler();
                }
            }
        }
        return sInstance;
    }

    public boolean containsCmd(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).booleanValue();
        }
        return this.mCmdMap.containsKey(str);
    }

    public PluginCommunicationChannelImpl getBinder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (PluginCommunicationChannelImpl) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (this.mChannel == null) {
            this.mChannel = new PluginCommunicationChannelImpl();
        }
        return this.mChannel;
    }

    public void register(RemoteCommand remoteCommand) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) remoteCommand);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "register cmd, " + remoteCommand);
        }
        if (remoteCommand == null) {
            return;
        }
        synchronized (this.mCmdMap) {
            this.mCmdMap.put(remoteCommand.getCmd(), remoteCommand);
        }
    }

    public void setCommunicationChannel(AbstractPluginCommunicationChannel abstractPluginCommunicationChannel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) abstractPluginCommunicationChannel);
        } else {
            this.mCustomChannel = abstractPluginCommunicationChannel;
        }
    }

    public void unregister(RemoteCommand remoteCommand) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) remoteCommand);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "unregister cmd, " + remoteCommand);
        }
        if (remoteCommand == null) {
            return;
        }
        unregister(remoteCommand.getCmd());
    }

    public void unregister(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "unregister cmd, " + str);
        }
        if (str == null) {
            return;
        }
        synchronized (this.mCmdMap) {
            this.mCmdMap.remove(str);
        }
    }
}
