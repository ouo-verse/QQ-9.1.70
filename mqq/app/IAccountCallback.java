package mqq.app;

import mqq.app.Constants;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface IAccountCallback {
    void onAccountChangeFailed(AppRuntime appRuntime);

    void onAccountChanged(AppRuntime appRuntime);

    void onLogout(Constants.LogoutReason logoutReason);
}
