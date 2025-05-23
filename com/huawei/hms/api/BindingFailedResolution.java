package com.huawei.hms.api;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.view.KeyEvent;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.api.FailedBinderCallBack;
import com.huawei.hms.common.internal.BindResolveClients;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.ui.AbstractDialog;
import com.huawei.hms.ui.AbstractPromptDialog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.UIUtil;
import com.huawei.hms.utils.Util;

/* compiled from: P */
/* loaded from: classes2.dex */
public class BindingFailedResolution implements IBridgeActivityDelegate, ServiceConnection {
    private static final Object LOCK_CONNECT_TIMEOUT_HANDLER = new Object();
    private static final int MSG_CONN_TIMEOUT = 2;
    private static final int MSG_SELF_DESTROY_TIMEOUT = 3;
    private static final int REQUEST_CODE = 2003;
    private static final String TAG = "BindingFailedResolution";
    private FailedBinderCallBack.BinderCallBack callBack;
    private Activity curActivity;
    private d promptdlg;
    private boolean isStarting = true;
    private Handler mConnectTimeoutHandler = null;
    private Handler selfDestroyHandler = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message != null && message.what == 3) {
                HMSLog.i(BindingFailedResolution.TAG, "selfDestroyHandle\uff1aMSG_SELF_DESTROY_TIMEOUT");
                BindingFailedResolution.this.noticeBindFailed();
                BindingFailedResolution.this.finishBridgeActivity(8);
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements Handler.Callback {
        b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message == null || message.what != 2) {
                return false;
            }
            HMSLog.e(BindingFailedResolution.TAG, "In connect, bind core try timeout");
            BindingFailedResolution.this.fireStartResult(false);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class c implements AbstractDialog.Callback {
        c() {
        }

        @Override // com.huawei.hms.ui.AbstractDialog.Callback
        public void onCancel(AbstractDialog abstractDialog) {
            BindingFailedResolution.this.promptdlg = null;
            BindResolveClients.getInstance().unRegisterAll();
            BindingFailedResolution.this.finishBridgeActivity(8);
        }

        @Override // com.huawei.hms.ui.AbstractDialog.Callback
        public void onDoWork(AbstractDialog abstractDialog) {
            BindingFailedResolution.this.promptdlg = null;
            BindResolveClients.getInstance().unRegisterAll();
            BindingFailedResolution.this.finishBridgeActivity(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class d extends AbstractPromptDialog {
        d() {
        }

        @Override // com.huawei.hms.ui.AbstractDialog
        public String onGetMessageString(Context context) {
            return ResourceLoaderUtil.getString("hms_bindfaildlg_message", Util.getAppName(context, null), Util.getAppName(context, HMSPackageManager.getInstance(context).getHMSPackageNameForMultiService()));
        }

        @Override // com.huawei.hms.ui.AbstractDialog
        public String onGetPositiveButtonString(Context context) {
            return ResourceLoaderUtil.getString("hms_confirm");
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    private void bindCoreService(boolean z16) {
        Activity activity = getActivity();
        if (activity == null) {
            HMSLog.e(TAG, "In connect, bind core try fail");
            fireStartResult(false);
            noticeBindResult(z16, 8);
            return;
        }
        Intent intent = new Intent(HMSPackageManager.getInstance(activity.getApplicationContext()).getServiceAction());
        try {
            intent.setPackage(HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageNameForMultiService());
            synchronized (LOCK_CONNECT_TIMEOUT_HANDLER) {
                if (activity.bindService(intent, this, 1)) {
                    postConnDelayHandle();
                    return;
                }
                HMSLog.e(TAG, "In connect, bind core try fail");
                fireStartResult(false);
                noticeBindResult(z16, 8);
            }
        } catch (IllegalArgumentException unused) {
            HMSLog.e(TAG, "IllegalArgumentException when bindCoreService intent.setPackage");
            fireStartResult(false);
            noticeBindResult(z16, 8);
        }
    }

    private void cancelConnDelayHandle() {
        synchronized (LOCK_CONNECT_TIMEOUT_HANDLER) {
            Handler handler = this.mConnectTimeoutHandler;
            if (handler != null) {
                handler.removeMessages(2);
                this.mConnectTimeoutHandler = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishBridgeActivity(int i3) {
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            HMSLog.i(TAG, "finishBridgeActivity\uff1a" + i3);
            Intent intent = new Intent();
            intent.putExtra(BridgeActivity.EXTRA_RESULT, i3);
            activity.setResult(-1, intent);
            Util.unBindServiceCatchException(activity, this);
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireStartResult(boolean z16) {
        if (this.isStarting) {
            this.isStarting = false;
            onStartResult(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void noticeBindFailed() {
        FailedBinderCallBack.BinderCallBack binderCallBack = this.callBack;
        if (binderCallBack != null) {
            binderCallBack.binderCallBack(8);
        }
    }

    private void noticeBindResult(boolean z16, int i3) {
        FailedBinderCallBack.BinderCallBack binderCallBack;
        if (z16 && (binderCallBack = this.callBack) != null) {
            binderCallBack.binderCallBack(i3);
        }
    }

    private void postConnDelayHandle() {
        Handler handler = this.mConnectTimeoutHandler;
        if (handler != null) {
            handler.removeMessages(2);
        } else {
            this.mConnectTimeoutHandler = new Handler(Looper.getMainLooper(), new b());
        }
        this.mConnectTimeoutHandler.sendEmptyMessageDelayed(2, 5000L);
    }

    private void selfDestroyHandle() {
        Handler handler = this.selfDestroyHandler;
        if (handler != null) {
            handler.removeMessages(3);
        } else {
            this.selfDestroyHandler = new Handler(Looper.getMainLooper(), new a());
        }
        this.selfDestroyHandler.sendEmptyMessageDelayed(3, 4000L);
    }

    private void showPromptdlg() {
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            d dVar = this.promptdlg;
            if (dVar == null) {
                this.promptdlg = new d(null);
            } else {
                dVar.dismiss();
            }
            HMSLog.i(TAG, "showPromptdlg to resolve conn error");
            this.promptdlg.show(activity, new c());
        }
    }

    private void tryStartHmsActivity(Activity activity) {
        Intent intent = new Intent();
        intent.putExtra("intent.extra.isfullscreen", UIUtil.isActivityFullscreen(activity));
        intent.setClassName(HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageNameForMultiService(), HuaweiApiAvailability.ACTIVITY_NAME);
        HMSLog.i(TAG, "onBridgeActivityCreate\uff1atry to start HMS");
        try {
            activity.startActivityForResult(intent, getRequestCode());
        } catch (Throwable th5) {
            HMSLog.e(TAG, "ActivityNotFoundException\uff1a" + th5.getMessage());
            Handler handler = this.selfDestroyHandler;
            if (handler != null) {
                handler.removeMessages(3);
                this.selfDestroyHandler = null;
            }
            bindCoreService(false);
        }
    }

    protected Activity getActivity() {
        return this.curActivity;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 2003;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent != null && intent.hasExtra("callId")) {
            long j3 = 0;
            try {
                j3 = intent.getLongExtra("callId", 0L);
            } catch (Exception e16) {
                HMSLog.e(TAG, "getExtras for callId exception:" + e16.getMessage());
            }
            this.callBack = FailedBinderCallBack.getInstance().getCallBack(Long.valueOf(j3));
        }
        this.curActivity = activity;
        BindingFailedResolveMgr.f36704b.a(activity);
        selfDestroyHandle();
        tryStartHmsActivity(activity);
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        cancelConnDelayHandle();
        BindingFailedResolveMgr.f36704b.b(this.curActivity);
        this.curActivity = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i3, int i16, Intent intent) {
        if (i3 != getRequestCode()) {
            return false;
        }
        HMSLog.i(TAG, "onBridgeActivityResult");
        Handler handler = this.selfDestroyHandler;
        if (handler != null) {
            handler.removeMessages(3);
            this.selfDestroyHandler = null;
        }
        bindCoreService(true);
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        if (this.promptdlg == null) {
            return;
        }
        HMSLog.i(TAG, "re show prompt dialog");
        showPromptdlg();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i3, KeyEvent keyEvent) {
        HMSLog.i(TAG, "On key up when resolve conn error");
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        cancelConnDelayHandle();
        fireStartResult(true);
        if (getActivity() == null) {
            return;
        }
        HMSLog.i(TAG, "test connect success, try to reConnect and reply message");
        BindResolveClients.getInstance().notifyClientReconnect();
    }

    protected void onStartResult(boolean z16) {
        if (getActivity() == null) {
            return;
        }
        if (z16) {
            finishBridgeActivity(0);
        } else {
            showPromptdlg();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
