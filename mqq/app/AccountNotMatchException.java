package mqq.app;

/* compiled from: P */
/* loaded from: classes28.dex */
public class AccountNotMatchException extends Exception {
    public AccountNotMatchException(String str, String str2) {
        super("The current account is " + str + " instead of " + str2);
    }
}
