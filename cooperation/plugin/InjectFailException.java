package cooperation.plugin;

/* compiled from: P */
/* loaded from: classes28.dex */
public class InjectFailException extends Exception {
    private int errCode;

    public InjectFailException(int i3, Throwable th5) {
        super(th5);
        this.errCode = i3;
    }

    public int getErrCode() {
        return this.errCode;
    }
}
