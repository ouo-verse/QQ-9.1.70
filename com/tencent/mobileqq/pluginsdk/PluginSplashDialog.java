package com.tencent.mobileqq.pluginsdk;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* loaded from: classes16.dex */
public class PluginSplashDialog extends ReportDialog {
    static IPatchRedirector $redirector_;
    private Handler mHandler;
    private String mPluginApk;
    private String mPluginName;
    private BroadcastReceiver mReceiver;
    private int mTimeOut;

    /* loaded from: classes16.dex */
    private static class InternalHandler extends Handler {
        static IPatchRedirector $redirector_;
        public static final int MSG_DISMISS = 0;
        private Dialog mDlg;

        public InternalHandler(Dialog dialog) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) dialog);
            } else {
                this.mDlg = dialog;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            if (message.what == 0) {
                try {
                    this.mDlg.dismiss();
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes16.dex */
    public static class LaunchCompletedIntent extends Intent {
        static IPatchRedirector $redirector_ = null;
        public static final String ACTION_LAUNCH_COMPLETED = "action_launch_completed";
        public static final String PARAM_PLUGIN_APK = "plugin_apk";
        public static final String PARAM_PLUGIN_NAME = "plugin_name";

        public LaunchCompletedIntent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* loaded from: classes16.dex */
    private class LaunchCompletedObserver extends BroadcastReceiver {
        static IPatchRedirector $redirector_;
        private String mPluginApk;
        private String mPluginName;

        public LaunchCompletedObserver(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PluginSplashDialog.this, str, str2);
            } else {
                this.mPluginName = str;
                this.mPluginApk = str2;
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            String stringExtra = intent.getStringExtra("plugin_apk");
            String stringExtra2 = intent.getStringExtra("plugin_name");
            if (this.mPluginApk.equalsIgnoreCase(stringExtra) && this.mPluginName.equalsIgnoreCase(stringExtra2)) {
                try {
                    PluginSplashDialog.this.dismiss();
                } catch (Exception unused) {
                }
            }
        }
    }

    public PluginSplashDialog(Context context, int i3, String str, String str2, int i16) {
        super(context, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), str, str2, Integer.valueOf(i16));
            return;
        }
        this.mHandler = new InternalHandler(this);
        this.mReceiver = null;
        this.mTimeOut = i16;
        this.mPluginName = str;
        this.mPluginApk = str2;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.mReceiver != null) {
            try {
                getContext().unregisterReceiver(this.mReceiver);
            } catch (IllegalArgumentException e16) {
                e16.printStackTrace();
            }
            this.mReceiver = null;
        }
        this.mHandler.removeMessages(0);
        super.dismiss();
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.mHandler.sendEmptyMessageDelayed(0, this.mTimeOut);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_launch_completed");
        this.mReceiver = new LaunchCompletedObserver(this.mPluginName, this.mPluginApk);
        try {
            getContext().registerReceiver(this.mReceiver, intentFilter);
            if (DebugHelper.sDebug) {
                DebugHelper.log("plugin_tag", "PluginSplashDialog RegisterReceiver");
            }
        } catch (Exception unused) {
        }
        super.show();
    }
}
