package mqq.manager;

import java.util.HashMap;
import mqq.observer.AccountObserver;

/* compiled from: P */
@Deprecated
/* loaded from: classes28.dex */
public interface AccountManager extends Manager {
    public static final int OP_DEL_LOGLEVEL = 3;
    public static final int OP_SET_LOGLEVEL_PERMANENT = 1;
    public static final int OP_SET_LOGLEVEL_TEMPORARY = 2;

    void changeToken(HashMap<String, Object> hashMap, AccountObserver accountObserver);

    void deleteAccount(String str, String str2, AccountObserver accountObserver);

    void getKey(AccountObserver accountObserver);

    void setManualLogLevel(int i3, int i16);

    void updateSTwxWeb(AccountObserver accountObserver);

    void verifyPasswd(String str, String str2, AccountObserver accountObserver);

    void verifyPasswdRefreshImage(String str, AccountObserver accountObserver);

    void verifyPasswdSubmitImage(String str, String str2, AccountObserver accountObserver);
}
