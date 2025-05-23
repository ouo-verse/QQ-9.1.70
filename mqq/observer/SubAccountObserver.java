package mqq.observer;

import android.os.Bundle;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Constants;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class SubAccountObserver implements BusinessObserver, Constants.Action {
    private static final String TAG = "SubAccountObserver";

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        if (i3 != 1035) {
            if (i3 != 1037) {
                if (i3 == 2216) {
                    try {
                        ToServiceMsg toServiceMsg = (ToServiceMsg) bundle.getParcelable("toServiceMsg");
                        if (toServiceMsg != null) {
                            onLoginStartNotify(toServiceMsg);
                            return;
                        }
                        return;
                    } catch (Exception e16) {
                        QLog.e(TAG, 1, "notifyLoginStartNotify", e16);
                        return;
                    }
                }
                return;
            }
            String string = bundle.getString("uin");
            bundle.getString("error");
            bundle.getInt("code");
            onGetKeyBack(bundle.getString("mainaccount"), string, bundle.getString("subaccountA2"));
            return;
        }
        int i16 = bundle.getInt("code");
        String string2 = bundle.getString(NotificationActivity.KEY_ALIAS);
        String string3 = bundle.getString("uin");
        String string4 = bundle.getString("submainaccount");
        QLog.d("mqq", 2, "SubAccountObserver onReceive ACTION_SUBACCOUNT_LOGIN  isSuccess = " + z16);
        if (z16) {
            onLoginSuccess(string4, string3, string2);
            return;
        }
        if (i16 != 1002 && i16 != 1013) {
            if (i16 == 2006) {
                onUserCancel(string4, string3, string2);
                return;
            } else {
                onLoginFailed(string4, string3, string2, bundle);
                return;
            }
        }
        onLoginTimeout(string4, string3, string2);
    }

    protected void onLoginStartNotify(ToServiceMsg toServiceMsg) {
    }

    protected void onGetKeyBack(String str, String str2, String str3) {
    }

    public void onLoginSuccess(String str, String str2, String str3) {
    }

    protected void onLoginTimeout(String str, String str2, String str3) {
    }

    protected void onUserCancel(String str, String str2, String str3) {
    }

    protected void onLoginFailed(String str, String str2, String str3, Bundle bundle) {
    }
}
