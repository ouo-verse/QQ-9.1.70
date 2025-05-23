package cooperation.qzone;

import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class CloseGuard {
    private Throwable allocationSite;
    private static final CloseGuard NOOP = new CloseGuard();
    private static volatile boolean ENABLED = true;
    private static volatile Reporter REPORTER = new DefaultReporter();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static final class DefaultReporter implements Reporter {
        DefaultReporter() {
        }

        @Override // cooperation.qzone.CloseGuard.Reporter
        public void report(String str, Throwable th5) {
            QZLog.e(QZLog.TO_DEVICE_TAG, str, th5);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface Reporter {
        void report(String str, Throwable th5);
    }

    CloseGuard() {
    }

    public static CloseGuard get() {
        if (!ENABLED) {
            return NOOP;
        }
        return new CloseGuard();
    }

    public static Reporter getReporter() {
        return REPORTER;
    }

    public static void setEnabled(boolean z16) {
        ENABLED = z16;
    }

    public static void setReporter(Reporter reporter) {
        if (reporter != null) {
            REPORTER = reporter;
            return;
        }
        throw new NullPointerException("reporter == null");
    }

    public void close() {
        this.allocationSite = null;
    }

    public void open(String str) {
        if (str != null) {
            if (this != NOOP && ENABLED) {
                this.allocationSite = new Throwable("Explicit termination method '" + str + "' not called");
                return;
            }
            return;
        }
        throw new NullPointerException("closer == null");
    }

    public void warnIfOpen() {
        if (this.allocationSite != null && ENABLED) {
            REPORTER.report("A resource was acquired at attached stack trace but never released. See java.io.Closeable for information on avoiding resource leaks.", this.allocationSite);
        }
    }
}
