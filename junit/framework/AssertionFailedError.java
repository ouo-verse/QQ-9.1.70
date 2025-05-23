package junit.framework;

/* compiled from: P */
/* loaded from: classes28.dex */
public class AssertionFailedError extends AssertionError {
    private static final long serialVersionUID = 1;

    public AssertionFailedError() {
    }

    private static String defaultString(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public AssertionFailedError(String str) {
        super(defaultString(str));
    }
}
