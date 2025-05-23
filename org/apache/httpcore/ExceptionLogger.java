package org.apache.httpcore;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface ExceptionLogger {
    public static final ExceptionLogger NO_OP = new ExceptionLogger() { // from class: org.apache.httpcore.ExceptionLogger.1
        @Override // org.apache.httpcore.ExceptionLogger
        public void log(Exception exc) {
        }
    };
    public static final ExceptionLogger STD_ERR = new ExceptionLogger() { // from class: org.apache.httpcore.ExceptionLogger.2
        @Override // org.apache.httpcore.ExceptionLogger
        public void log(Exception exc) {
            exc.printStackTrace();
        }
    };

    void log(Exception exc);
}
