package com.tencent.mobileqq.pluginsdk;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class SplashDialogWrapper {
    static IPatchRedirector $redirector_;
    private Dialog mBase;
    private Context mContext;
    private Handler mHandler;
    private boolean mOnlyCheckID;
    private String mPluginApk;
    private String mPluginName;
    private BroadcastReceiver mReceiver;
    private int mTimeOut;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    private static class InternalHandler extends Handler {
        static IPatchRedirector $redirector_;
        public static final int MSG_DISMISS = 0;
        private SplashDialogWrapper mWrapper;

        public InternalHandler(SplashDialogWrapper splashDialogWrapper) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) splashDialogWrapper);
            } else {
                this.mWrapper = splashDialogWrapper;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            } else if (message.what == 0) {
                this.mWrapper.dismiss();
            }
        }
    }

    /* compiled from: P */
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

    /* compiled from: P */
    /* loaded from: classes16.dex */
    private class LaunchCompletedObserver extends BroadcastReceiver {
        static IPatchRedirector $redirector_;
        private String mPluginID;
        private String mPluginName;

        public LaunchCompletedObserver(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SplashDialogWrapper.this, str, str2);
            } else {
                this.mPluginName = str;
                this.mPluginID = str2;
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
            if (DebugHelper.sDebug) {
                DebugHelper.log("plugin_tag", "LaunchCompletedObserver.onReceive: " + stringExtra + ", " + stringExtra2 + ", " + SplashDialogWrapper.this.mOnlyCheckID);
            }
            if (this.mPluginID.equalsIgnoreCase(stringExtra)) {
                if (SplashDialogWrapper.this.mOnlyCheckID || stringExtra2 != null) {
                    SplashDialogWrapper.this.dismiss();
                }
            }
        }
    }

    public SplashDialogWrapper(Context context, Dialog dialog, String str, String str2, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, dialog, str, str2, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        this.mHandler = new InternalHandler(this);
        this.mReceiver = null;
        this.mContext = context;
        this.mBase = dialog;
        this.mPluginApk = str2;
        this.mPluginName = str;
        this.mOnlyCheckID = z16;
        this.mTimeOut = i3;
    }

    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        BroadcastReceiver broadcastReceiver = this.mReceiver;
        if (broadcastReceiver != null) {
            try {
                this.mContext.unregisterReceiver(broadcastReceiver);
                if (DebugHelper.sDebug) {
                    DebugHelper.log("plugin_tag", "SplashDialogWrapper.dismiss unregisterReceiver");
                }
            } catch (IllegalArgumentException e16) {
                e16.printStackTrace();
            }
            this.mReceiver = null;
        }
        this.mHandler.removeMessages(0);
        try {
            this.mBase.dismiss();
        } catch (Exception unused) {
        }
    }

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
        if (DebugHelper.sDebug) {
            DebugHelper.log("plugin_tag", "SplashDialogWrapper.show registerReceiver");
        }
        try {
            this.mContext.registerReceiver(this.mReceiver, intentFilter);
            this.mBase.show();
        } catch (Exception unused) {
        }
    }
}
