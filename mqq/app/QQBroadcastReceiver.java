package mqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QQBroadcastReceiver extends BroadcastReceiver {
    public String getModuleId() {
        return null;
    }

    public void onReceive(AppRuntime appRuntime, Context context, Intent intent) {
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00aa  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onReceive(Context context, Intent intent) {
        AppRuntime waitAppRuntime;
        String str;
        AppRuntime appRuntime;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        Pair<Long, String> create = Pair.create(Long.valueOf(System.currentTimeMillis()), intent == null ? "" : intent.toString());
        Queue<Pair<Long, String>> queue = mobileQQ.broadcastInfoQueue;
        if (queue != null) {
            if (queue.size() >= 5) {
                mobileQQ.broadcastInfoQueue.poll();
            }
            mobileQQ.broadcastInfoQueue.offer(create);
        }
        mobileQQ.onActivityCreate(this, intent);
        if ("Success".equals(MobileQQ.sInjectResult) && (waitAppRuntime = mobileQQ.waitAppRuntime()) != null) {
            String moduleId = getModuleId();
            if (!TextUtils.isEmpty(moduleId) && (appRuntime = waitAppRuntime.getAppRuntime(moduleId)) != null) {
                waitAppRuntime = appRuntime;
            }
            if (intent != null) {
                int i3 = -1;
                try {
                    str = intent.getStringExtra("k_pcactive_uin");
                    try {
                        i3 = intent.getIntExtra("k_pcactive_retryIndex", -1);
                    } catch (Exception e16) {
                        e = e16;
                        e.printStackTrace();
                        if (!TextUtils.isEmpty(str)) {
                            QLog.d("QQBroadcastReceiver", 1, "PCActive:active qq process");
                            mobileQQ.isPCActive = true;
                            mobileQQ.reportPCActive(str, i3);
                            if (!SettingCloneUtil.readValue((Context) mobileQQ, waitAppRuntime.getAccount(), (String) null, AppConstants.PCACTIVE_HAS_NOTICE_KEY, false)) {
                            }
                            if (!waitAppRuntime.isLogin()) {
                            }
                        }
                        onReceive(waitAppRuntime, context, intent);
                    }
                } catch (Exception e17) {
                    e = e17;
                    str = null;
                }
                if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
                    QLog.d("QQBroadcastReceiver", 1, "PCActive:active qq process");
                    mobileQQ.isPCActive = true;
                    mobileQQ.reportPCActive(str, i3);
                    if (!SettingCloneUtil.readValue((Context) mobileQQ, waitAppRuntime.getAccount(), (String) null, AppConstants.PCACTIVE_HAS_NOTICE_KEY, false)) {
                        SettingCloneUtil.writeValue((Context) mobileQQ, waitAppRuntime.getAccount(), (String) null, AppConstants.PCACTIVE_NOTICE_KEY, true);
                    }
                    if (!waitAppRuntime.isLogin()) {
                        QLog.d("QQBroadcastReceiver", 1, "PCActive:Account is not login");
                        List<SimpleAccount> allAccounts = waitAppRuntime.getApplication().getAllAccounts();
                        SimpleAccount simpleAccount = allAccounts != null ? allAccounts.get(0) : null;
                        if (simpleAccount != null && str.equals(simpleAccount.getUin()) && simpleAccount.isLogined()) {
                            QLog.d("QQBroadcastReceiver", 1, "PCActive:Show Notification");
                            waitAppRuntime.login(simpleAccount);
                            Intent intent2 = new Intent("com.tencent.mobileqq.closeNotification");
                            intent2.putExtra("uin", str);
                            context.sendBroadcast(intent2);
                        }
                    }
                }
            }
            onReceive(waitAppRuntime, context, intent);
        }
    }
}
