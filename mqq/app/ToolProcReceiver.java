package mqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* loaded from: classes28.dex */
public class ToolProcReceiver extends BroadcastReceiver {
    AppRuntime mRt;
    boolean registered;

    public String[] getModularReceiveActions() {
        return new String[]{NewIntent.ACTION_ACCOUNT_KICKED, "mqq.intent.action.EXIT_" + BaseApplication.getContext().getPackageName(), NewIntent.ACTION_ACCOUNT_CHANGED, NewIntent.ACTION_ACCOUNT_EXPIRED, NewIntent.ACTION_LOGOUT, "com.tencent.process.exit"};
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            boolean z16 = true;
            boolean z17 = false;
            if ("com.tencent.process.exit".equals(action)) {
                Bundle extras = intent.getExtras();
                if (extras == null) {
                    return;
                }
                ArrayList<String> stringArrayList = extras.getStringArrayList("procNameList");
                if (AppProcHelper.isLegalBroadcast(extras.getString("verify"), stringArrayList) && AppProcHelper.isContainsProc(context, stringArrayList)) {
                    for (AppRuntime appRuntime : this.mRt.subRuntimeMap.values()) {
                        if ((appRuntime instanceof IToolProcEventListener) && ((IToolProcEventListener) appRuntime).onReceiveLegalExitProcAction(intent)) {
                            if (QLog.isColorLevel()) {
                                QLog.d("mqq", 2, "notKillBy(LegalExit) " + appRuntime.getModuleId());
                            }
                            z17 = true;
                        }
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("mqq", 2, "ToolProcReceiver " + action + "." + z16);
                }
                if (z16) {
                    for (Object obj : this.mRt.subRuntimeMap.values()) {
                        if (obj instanceof IToolProcEventListener) {
                            ((IToolProcEventListener) obj).onBeforeExitProc();
                        }
                    }
                    this.mRt.exitToolProc();
                    return;
                }
                return;
            }
            for (AppRuntime appRuntime2 : this.mRt.subRuntimeMap.values()) {
                if ((appRuntime2 instanceof IToolProcEventListener) && ((IToolProcEventListener) appRuntime2).onReceiveAccountAction(action, intent)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("mqq", 2, "notKillBy(Account) " + appRuntime2.getModuleId());
                    }
                    z17 = true;
                }
            }
            z16 = z17;
            if (QLog.isColorLevel()) {
            }
            if (z16) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void register() {
        if (this.registered) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            for (String str : getModularReceiveActions()) {
                intentFilter.addAction(str);
            }
            BaseApplication.getContext().registerReceiver(this, intentFilter);
            this.registered = true;
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                th5.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unRegister() {
        try {
            if (this.registered) {
                BaseApplication.getContext().unregisterReceiver(this);
            }
            this.registered = false;
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                th5.printStackTrace();
            }
        }
    }
}
