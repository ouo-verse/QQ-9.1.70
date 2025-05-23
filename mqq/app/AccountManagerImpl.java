package mqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.HashMap;
import mqq.app.Constants;
import mqq.manager.AccountManager;
import mqq.manager.TicketManager;
import mqq.observer.AccountObserver;

/* compiled from: P */
/* loaded from: classes28.dex */
public class AccountManagerImpl implements AccountManager {
    private final AppRuntime app;

    public AccountManagerImpl(AppRuntime appRuntime) {
        this.app = appRuntime;
    }

    @Override // mqq.manager.AccountManager
    public void changeToken(HashMap<String, Object> hashMap, AccountObserver accountObserver) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), BuiltInServlet.class);
        newIntent.putExtra("action", 1032);
        newIntent.putExtra("mapSt", hashMap);
        newIntent.setObserver(accountObserver);
        this.app.startServlet(newIntent);
    }

    @Override // mqq.manager.AccountManager
    public void deleteAccount(String str, String str2, AccountObserver accountObserver) {
        MsfSdkUtils.delSimpleAccount(str);
        this.app.getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
        NewIntent newIntent = new NewIntent(this.app.getApplication(), BuiltInServlet.class);
        newIntent.putExtra("action", 1007);
        newIntent.putExtra("uin", str);
        newIntent.putExtra(NotificationActivity.KEY_ALIAS, str2);
        newIntent.setObserver(accountObserver);
        newIntent.runNow = true;
        newIntent.withouLogin = true;
        this.app.startServlet(newIntent);
        for (SimpleAccount simpleAccount : this.app.getApplication().sortAccountList) {
            if (simpleAccount.getUin().equals(str)) {
                this.app.getApplication().sortAccountList.remove(simpleAccount);
                return;
            }
        }
    }

    @Override // mqq.manager.AccountManager
    public void getKey(AccountObserver accountObserver) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), BuiltInServlet.class);
        newIntent.putExtra("action", 1030);
        newIntent.setObserver(accountObserver);
        this.app.startServlet(newIntent);
    }

    @Override // mqq.manager.AccountManager
    public void setManualLogLevel(int i3, int i16) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), BuiltInServlet.class);
        newIntent.putExtra("action", Constants.Action.ACTION_MANUAL_SET_LOG_LEVEL);
        newIntent.putExtra("opType", i3);
        newIntent.putExtra("manualLogLevel", i16);
        this.app.startServlet(newIntent);
    }

    @Override // mqq.manager.AccountManager
    public void updateSTwxWeb(AccountObserver accountObserver) {
        String str;
        TicketManager ticketManager;
        AppRuntime appRuntime = this.app;
        if (appRuntime != null && (ticketManager = (TicketManager) appRuntime.getManager(2)) != null && !TextUtils.isEmpty(this.app.getAccount())) {
            str = ticketManager.getStweb(this.app.getAccount());
        } else {
            str = null;
        }
        if (accountObserver != null) {
            accountObserver.onUpdateSTwxWeb(str);
        }
    }

    @Override // mqq.manager.AccountManager
    public void verifyPasswd(String str, String str2, AccountObserver accountObserver) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), BuiltInServlet.class);
        newIntent.putExtra("action", Constants.Action.ACTION_VERIFY_PASSWD);
        newIntent.putExtra("account", str);
        newIntent.putExtra(NotificationActivity.PASSWORD, str2);
        newIntent.withouLogin = true;
        newIntent.setObserver(accountObserver);
        this.app.startServlet(newIntent);
    }

    @Override // mqq.manager.AccountManager
    public void verifyPasswdRefreshImage(String str, AccountObserver accountObserver) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), BuiltInServlet.class);
        newIntent.putExtra("action", Constants.Action.ACTION_VERIFY_PASSWD_REFRESH_IMAGECODE);
        newIntent.putExtra("account", str);
        newIntent.withouLogin = true;
        newIntent.setObserver(accountObserver);
        this.app.startServlet(newIntent);
    }

    @Override // mqq.manager.AccountManager
    public void verifyPasswdSubmitImage(String str, String str2, AccountObserver accountObserver) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), BuiltInServlet.class);
        newIntent.putExtra("action", Constants.Action.ACTION_VERIFY_PASSWD_SUBMIT_IMAGECODE);
        newIntent.putExtra("account", str);
        newIntent.putExtra("verifyCode", str2);
        newIntent.withouLogin = true;
        newIntent.setObserver(accountObserver);
        this.app.startServlet(newIntent);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
    }
}
