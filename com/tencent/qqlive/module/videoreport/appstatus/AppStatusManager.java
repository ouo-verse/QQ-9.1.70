package com.tencent.qqlive.module.videoreport.appstatus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AppStatusManager {
    private final BroadcastReceiver mAppFirstLaunchReceiver;
    private final BroadcastReceiver mAppProcessStatusReceiver;
    private int mCurrentProcessAppStatus;
    private final ListenerMgr<IAppStatusListener> mListenerMgr;
    private int mOtherProcessAppStatus;
    private int mProcessAppInId;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        static final AppStatusManager INSTANCE = new AppStatusManager(null);

        InstanceHolder() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AppStatusManager.this.onReceiverProcessInBroadcast(intent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AppStatusManager.this.onReceiverAppStatusBroadcast(intent);
        }
    }

    /* synthetic */ AppStatusManager(a aVar) {
        this();
    }

    public static AppStatusManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private void initReceiver() {
        if (ReportUtils.getContext() == null) {
            return;
        }
        ReportUtils.getContext().registerReceiver(this.mAppProcessStatusReceiver, new IntentFilter(DTConstants.APPStatusConstant.ACTION_APP_PROCESS_IN_OUT));
        ReportUtils.getContext().registerReceiver(this.mAppFirstLaunchReceiver, new IntentFilter(DTConstants.APPStatusConstant.ACTION_APP_PROCESS_START));
        Intent intent = new Intent(DTConstants.APPStatusConstant.ACTION_APP_PROCESS_START);
        intent.putExtra(DTConstants.APPStatusConstant.APP_PROCESS_ID, Process.myPid());
        intent.setPackage(ReportUtils.getPackageName());
        ReportUtils.getContext().sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAppStatusChanged$0(IAppStatusListener iAppStatusListener) {
        int i3;
        if (isAppForground()) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        iAppStatusListener.onAppStatusChanged(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAppStatusChanged$1() {
        this.mListenerMgr.startNotify(new ListenerMgr.INotifyCallback() { // from class: com.tencent.qqlive.module.videoreport.appstatus.a
            @Override // com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback
            public final void onNotify(Object obj) {
                AppStatusManager.this.lambda$onAppStatusChanged$0((IAppStatusListener) obj);
            }
        });
    }

    private void onAppStatusChanged() {
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.appstatus.c
            @Override // java.lang.Runnable
            public final void run() {
                AppStatusManager.this.lambda$onAppStatusChanged$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onReceiverAppStatusBroadcast(Intent intent) {
        try {
            int intExtra = intent.getIntExtra(DTConstants.APPStatusConstant.APP_STATUS, 2);
            int intExtra2 = intent.getIntExtra(DTConstants.APPStatusConstant.APP_PROCESS_ID, -1);
            if (intExtra2 == Process.myPid()) {
                return;
            }
            if (this.mProcessAppInId == intExtra2) {
                this.mOtherProcessAppStatus = intExtra;
                onAppStatusChanged();
            } else if (intExtra == 1 && this.mOtherProcessAppStatus != intExtra) {
                this.mProcessAppInId = intExtra2;
                this.mOtherProcessAppStatus = intExtra;
                onAppStatusChanged();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onReceiverProcessInBroadcast(Intent intent) {
        if (intent == null || intent.getIntExtra(DTConstants.APPStatusConstant.APP_PROCESS_ID, -1) == Process.myPid()) {
            return;
        }
        ThreadUtils.runOnUiThreadDelay(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.appstatus.b
            @Override // java.lang.Runnable
            public final void run() {
                AppStatusManager.this.sendCurrentAppStatesBroadcast();
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCurrentAppStatesBroadcast() {
        final Intent intent = new Intent(DTConstants.APPStatusConstant.ACTION_APP_PROCESS_IN_OUT);
        intent.putExtra(DTConstants.APPStatusConstant.APP_STATUS, this.mCurrentProcessAppStatus);
        intent.setPackage(ReportUtils.getPackageName());
        intent.putExtra(DTConstants.APPStatusConstant.APP_PROCESS_ID, Process.myPid());
        ThreadUtils.execTask(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.appstatus.AppStatusManager.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ReportUtils.getContext() != null) {
                        ReportUtils.getContext().sendBroadcast(intent);
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        });
    }

    public boolean isAppForground() {
        if (this.mCurrentProcessAppStatus == 1 || this.mOtherProcessAppStatus == 1) {
            return true;
        }
        return false;
    }

    public boolean isProcessForground() {
        if (this.mCurrentProcessAppStatus == 1) {
            return true;
        }
        return false;
    }

    public void onAppIn() {
        this.mCurrentProcessAppStatus = 1;
        sendCurrentAppStatesBroadcast();
        onAppStatusChanged();
    }

    public void onAppOut() {
        this.mCurrentProcessAppStatus = 2;
        sendCurrentAppStatesBroadcast();
        onAppStatusChanged();
    }

    public void register(IAppStatusListener iAppStatusListener) {
        this.mListenerMgr.register(iAppStatusListener);
    }

    public void unregister(IAppStatusListener iAppStatusListener) {
        this.mListenerMgr.unregister(iAppStatusListener);
    }

    AppStatusManager() {
        this.mCurrentProcessAppStatus = 2;
        this.mOtherProcessAppStatus = 2;
        this.mProcessAppInId = -1;
        this.mListenerMgr = new ListenerMgr<>();
        this.mAppFirstLaunchReceiver = new a();
        this.mAppProcessStatusReceiver = new b();
        initReceiver();
    }
}
