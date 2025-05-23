package mqq.observer;

import android.os.Bundle;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Constants;

/* compiled from: P */
/* loaded from: classes28.dex */
public class SSOAccountObserver implements BusinessObserver, Constants.Action {
    public static final String TAG = "SSOAccountObserver";

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        boolean z17;
        Object valueOf;
        int i16 = bundle.getInt("code");
        String string = bundle.getString("ssoAccount");
        int i17 = bundle.getInt("targetTicket", 4096);
        int i18 = bundle.getInt("ret");
        byte[] byteArray = bundle.getByteArray("wtTicket");
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("account:");
            sb5.append(string);
            sb5.append(" action:");
            sb5.append(i3);
            sb5.append(" code:");
            sb5.append(i16);
            sb5.append(" isSuccess:");
            sb5.append(z16);
            sb5.append(" ret:");
            sb5.append(i18);
            sb5.append(" wtTicketArr:");
            if (byteArray == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(byteArray.length);
            }
            sb5.append(valueOf);
            QLog.d(TAG, 2, sb5.toString());
        }
        boolean z18 = false;
        if (i18 == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (i3 != 2216) {
            switch (i3) {
                case 1100:
                case 1101:
                    if (byteArray != null && byteArray.length != 0) {
                        z18 = z17;
                    }
                    if (z18) {
                        if (i3 == 1100) {
                            onLoginSuccess(string, byteArray, i17, bundle);
                            return;
                        } else {
                            if (i3 == 1101) {
                                onGetTicketNoPasswd(string, byteArray, i17, bundle);
                                return;
                            }
                            return;
                        }
                    }
                    if (i16 == 2006) {
                        onUserCancel(string, i3, bundle);
                        return;
                    } else {
                        onFailed(string, i3, i18, bundle);
                        return;
                    }
                case 1102:
                    if (byteArray != null && byteArray.length != 0) {
                        z18 = z17;
                    }
                    if (z18) {
                        onGetA1WithA1(string, i18, byteArray, i17, bundle);
                        return;
                    } else if (i16 == 2006) {
                        onUserCancel(string, i3, bundle);
                        return;
                    } else {
                        onFailed(string, i3, i18, bundle);
                        return;
                    }
                default:
                    return;
            }
        }
        try {
            ToServiceMsg toServiceMsg = (ToServiceMsg) bundle.getParcelable("toServiceMsg");
            if (toServiceMsg != null) {
                onLoginStartNotify(toServiceMsg);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "notifyLoginStartNotify", e16);
        }
    }

    public void onLoginStartNotify(ToServiceMsg toServiceMsg) {
    }

    public void onUserCancel(String str, int i3, Bundle bundle) {
    }

    public void onFailed(String str, int i3, int i16, Bundle bundle) {
    }

    public void onGetTicketNoPasswd(String str, byte[] bArr, int i3, Bundle bundle) {
    }

    public void onLoginSuccess(String str, byte[] bArr, int i3, Bundle bundle) {
    }

    public void onGetA1WithA1(String str, int i3, byte[] bArr, int i16, Bundle bundle) {
    }
}
