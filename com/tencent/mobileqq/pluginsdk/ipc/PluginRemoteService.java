package com.tencent.mobileqq.pluginsdk.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.tencent.mobileqq.pluginsdk.PluginConst;
import com.tencent.mobileqq.pluginsdk.PluginManageHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class PluginRemoteService {
    static IPatchRedirector $redirector_;

    /* loaded from: classes16.dex */
    public static class Sub1 extends Service {
        static IPatchRedirector $redirector_;

        public Sub1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.app.Service
        public IBinder onBind(Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (IBinder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            }
            int intExtra = intent.getIntExtra(PluginConst.KEY_BINDER_TYPE, -1);
            if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "PluginRemoteService$Sub1.onBind. " + intExtra + ", " + Binder.getCallingPid() + ", " + this);
            }
            return PluginCommunicationHandler.getInstance().getBinder();
        }

        @Override // android.app.Service
        public void onCreate() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("plugin_tag", 2, "PluginRemoteService$Sub1.onCreate " + this);
            }
            super.onCreate();
            MobileQQ.sMobileQQ.waitAppRuntime(null);
        }

        @Override // android.app.Service
        public void onDestroy() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            super.onDestroy();
            if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "PluginRemoteService$Sub1.onDestroy. " + this);
            }
        }

        @Override // android.app.Service
        public boolean onUnbind(Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent)).booleanValue();
            }
            if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "PluginRemoteService$Sub1.onUnbind. " + Binder.getCallingPid() + ", " + this);
            }
            return super.onUnbind(intent);
        }
    }

    /* loaded from: classes16.dex */
    public static class Sub2 extends Service {
        static IPatchRedirector $redirector_;

        public Sub2() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.app.Service
        public IBinder onBind(Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (IBinder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            }
            int intExtra = intent.getIntExtra(PluginConst.KEY_BINDER_TYPE, -1);
            if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "PluginRemoteService$Sub2.onBind. " + intExtra + ", " + Binder.getCallingPid() + ", " + this);
            }
            return PluginManageHandler.getInstance().getBinder();
        }

        @Override // android.app.Service
        public void onCreate() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("plugin_tag", 2, "PluginRemoteService$Sub2.onCreate " + this);
            }
            super.onCreate();
            MobileQQ.sMobileQQ.waitAppRuntime(null);
        }

        @Override // android.app.Service
        public void onDestroy() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            super.onDestroy();
            if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "PluginRemoteService$Sub2.onDestroy. " + this);
            }
        }

        @Override // android.app.Service
        public boolean onUnbind(Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent)).booleanValue();
            }
            if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "PluginRemoteService$Sub2.onUnbind. " + Binder.getCallingPid() + ", " + this);
            }
            return super.onUnbind(intent);
        }
    }

    public PluginRemoteService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
