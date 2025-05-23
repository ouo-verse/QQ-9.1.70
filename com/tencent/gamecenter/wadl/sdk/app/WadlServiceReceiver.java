package com.tencent.gamecenter.wadl.sdk.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.sdk.ipc.WadlRemoteHandler;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppProcHelper;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlServiceReceiver extends BroadcastReceiver {
    public static final String TAG = "Wadl_WadlServiceReceiver";
    protected static WadlServiceReceiver instance;
    private static byte[] lock = new byte[0];
    private boolean isRegister;

    WadlServiceReceiver() {
    }

    private void exitProcess(String str) {
        QLog.d(TAG, 2, "exitProcess action=" + str);
        try {
            MobileQQ.sMobileQQ.unregisterReceiver(this);
        } catch (Throwable th5) {
            QLog.e(TAG, 2, "exitProcess exception", th5);
        }
        this.isRegister = false;
        WadlRemoteHandler.getInstance().onDestroy();
        SystemMethodProxy.killProcess(Process.myPid());
    }

    public static WadlServiceReceiver getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new WadlServiceReceiver();
                }
            }
        }
        return instance;
    }

    private boolean isContainsProc(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return true;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            String str = MobileQQ.processName;
            if (str != null && str.equals(arrayList.get(i3)) && !WadlRemoteHandler.getInstance().isAnyTaskActive(false)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        if (!action.equals(NewIntent.ACTION_ACCOUNT_CHANGED) && !action.equals(NewIntent.ACTION_ACCOUNT_KICKED) && !action.equals(NewIntent.ACTION_ACCOUNT_EXPIRED) && !action.equals(NewIntent.ACTION_LOGOUT)) {
            if (action.equals("mqq.intent.action.EXIT_" + BaseApplication.getContext().getPackageName())) {
                exitProcess(action);
                return;
            }
            if (action.equals("com.tencent.process.exit")) {
                ArrayList<String> stringArrayList = intent.getExtras().getStringArrayList("procNameList");
                if (AppProcHelper.isLegalBroadcast(intent.getExtras().getString("verify"), stringArrayList) && isContainsProc(stringArrayList)) {
                    exitProcess(action);
                    return;
                }
                return;
            }
            return;
        }
        exitProcess(action);
    }

    public void registerReceiver() {
        if (this.isRegister) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.process.exit");
        intentFilter.addAction("mqq.intent.action.EXIT_" + BaseApplication.getContext().getPackageName());
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_EXPIRED);
        intentFilter.addAction(NewIntent.ACTION_LOGOUT);
        MobileQQ.sMobileQQ.registerReceiver(this, intentFilter);
        this.isRegister = true;
    }
}
