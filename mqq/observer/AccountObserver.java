package mqq.observer;

import android.os.Bundle;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tenpay.sdk.util.UinConfigManager;
import cooperation.qzone.QzoneIPCModule;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.Constants;
import oicq.wlogin_sdk.tools.ErrMsg;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class AccountObserver implements BusinessObserver, Constants.Action {
    private static final List<Integer> REGISTER_ACTIONS = Arrays.asList(1040, 1002);
    private static final List<Integer> LOGIN_ACTIONS = Arrays.asList(1001, Integer.valueOf(Constants.Action.ACTION_VERIFY_PASSWD), Integer.valueOf(Constants.Action.ACTION_VERIFY_PASSWD_SUBMIT_IMAGECODE), Integer.valueOf(Constants.Action.ACTION_VERIFY_PASSWD_REFRESH_IMAGECODE));
    private static final List<Integer> OTHER_ACCOUNT_ACTIONS = Arrays.asList(Integer.valueOf(Constants.Action.ACTION_ONLINE_STATUS_PUSH), 1007, 1030, 1032);

    private void onReceiveLoginActions(int i3, boolean z16, Bundle bundle) {
        String str;
        if (i3 != 1001) {
            switch (i3) {
                case Constants.Action.ACTION_VERIFY_PASSWD /* 2205 */:
                    onVerifyPasswd(bundle.getString("uin"), z16, bundle.getString("errorMsg"), bundle.getInt(QzoneIPCModule.RESULT_CODE), bundle.getInt("ret"), bundle.getString(UinConfigManager.KEY_ADS), bundle.getByteArray("image"));
                    return;
                case Constants.Action.ACTION_VERIFY_PASSWD_SUBMIT_IMAGECODE /* 2206 */:
                    String string = bundle.getString("uin");
                    int i16 = bundle.getInt(QzoneIPCModule.RESULT_CODE);
                    String string2 = bundle.getString("userAccount");
                    onVerifyPasswdImage(string, z16, bundle.getString("errorMsg"), i16, string2, bundle.getByteArray("userInput"), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR), bundle.getByteArray("image"));
                    return;
                case Constants.Action.ACTION_VERIFY_PASSWD_REFRESH_IMAGECODE /* 2207 */:
                    onVerifyPasswdRefreshImage(bundle.getString("uin"), z16, bundle.getString("errorMsg"), bundle.getInt(QzoneIPCModule.RESULT_CODE), bundle.getString("userAccount"), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR), bundle.getByteArray("pictureData"));
                    return;
                default:
                    return;
            }
        }
        int i17 = bundle.getInt("code");
        String string3 = bundle.getString(NotificationActivity.KEY_ALIAS);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onRV  action login code = ");
        sb5.append(i17);
        sb5.append("; alias = ");
        if (string3 == null) {
            str = "is null";
        } else {
            str = string3;
        }
        sb5.append(str);
        QLog.d("AccountObserver", 1, sb5.toString());
        if (z16) {
            onLoginSuccess(bundle.getString("uin"), string3, bundle.getByteArray(BuiltInServlet.KEY_TLV_543_IN_TLV_119));
            return;
        }
        if (i17 != 1002 && i17 != 1013) {
            if (i17 == 2006) {
                onUserCancel(string3);
                return;
            }
            onLoginFailed(string3, bundle.getString("error"), bundle.getString("errorurl"), bundle.getInt("loginret"), bundle.getByteArray("lhsig"), bundle.getInt("errorver"), bundle.getByteArray("tlverror"), bundle.getString("title"));
            return;
        }
        onLoginTimeout(string3);
    }

    private void onReceiveLoginNotify(int i3, boolean z16, Bundle bundle) {
        try {
            ToServiceMsg toServiceMsg = (ToServiceMsg) bundle.getParcelable("toServiceMsg");
            if (toServiceMsg == null) {
                return;
            }
            onLoginStartNotify(toServiceMsg);
        } catch (Exception e16) {
            QLog.e("accountObserver", 1, "onReceiveLoginNotify Exception", e16);
        }
    }

    private void onReceiveLoginRegisterActions(int i3, boolean z16, Bundle bundle) {
        if (i3 != 1002) {
            if (i3 == 1040) {
                onRegisterCmdCallback(z16);
            }
        } else {
            onOnlineStatusChanged(z16, (AppRuntime.Status) bundle.getSerializable("onlineStatus"), bundle.getLong("extOnlineStatus", -1L), bundle.getBoolean("isUserSet", false), bundle.getBoolean("isChanged"), bundle.getLong(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY), bundle.getBoolean("isLargeChanged"));
        }
    }

    private void onReceiveOtherAccountActions(int i3, boolean z16, Bundle bundle) {
        if (i3 != 1007) {
            if (i3 != 1030) {
                if (i3 != 1032) {
                    if (i3 == 2211) {
                        onOnlineStatusPush((AppRuntime.Status) bundle.getSerializable("onlineStatus"), bundle.getLong("extOnlineStatus"));
                    } else {
                        return;
                    }
                } else {
                    onChangeToken(z16, (HashMap) bundle.getSerializable("map"));
                    return;
                }
            } else {
                onGetKeyResp(bundle.getString("key"));
                return;
            }
        }
        onDeleteAccount(z16);
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        if (REGISTER_ACTIONS.contains(Integer.valueOf(i3))) {
            onReceiveLoginRegisterActions(i3, z16, bundle);
            return;
        }
        if (LOGIN_ACTIONS.contains(Integer.valueOf(i3))) {
            onReceiveLoginActions(i3, z16, bundle);
        } else if (OTHER_ACCOUNT_ACTIONS.contains(Integer.valueOf(i3))) {
            onReceiveOtherAccountActions(i3, z16, bundle);
        } else if (i3 == 2216) {
            onReceiveLoginNotify(i3, z16, bundle);
        }
    }

    public void onDeleteAccount(boolean z16) {
    }

    public void onGetKeyResp(String str) {
    }

    public void onLoginStartNotify(ToServiceMsg toServiceMsg) {
    }

    protected void onLoginTimeout(String str) {
    }

    public void onRegisterCmdCallback(boolean z16) {
    }

    public void onUpdateSTwxWeb(String str) {
    }

    protected void onUserCancel(String str) {
    }

    public void onChangeToken(boolean z16, HashMap<String, Object> hashMap) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onOnlineStatusPush(AppRuntime.Status status, long j3) {
    }

    public void onExchangeUin(String str, String str2, String str3) {
    }

    public void onLoginSuccess(String str, String str2, byte[] bArr) {
    }

    public void onVerifyPasswdImage(String str, boolean z16, String str2, int i3, String str3, byte[] bArr, int i16, ErrMsg errMsg, byte[] bArr2) {
    }

    protected void onOnlineStatusChanged(boolean z16, AppRuntime.Status status, long j3, boolean z17, boolean z18, long j16, boolean z19) {
    }

    public void onVerifyPasswd(String str, boolean z16, String str2, int i3, int i16, String str3, byte[] bArr) {
    }

    protected void onLoginFailed(String str, String str2, String str3, int i3, byte[] bArr, int i16, byte[] bArr2, String str4) {
    }

    public void onVerifyPasswdRefreshImage(String str, boolean z16, String str2, int i3, String str3, int i16, ErrMsg errMsg, byte[] bArr) {
    }
}
