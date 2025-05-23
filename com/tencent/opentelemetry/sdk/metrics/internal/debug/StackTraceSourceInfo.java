package com.tencent.opentelemetry.sdk.metrics.internal.debug;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
final class StackTraceSourceInfo implements SourceInfo {
    static IPatchRedirector $redirector_;
    private final StackTraceElement[] stackTraceElements;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StackTraceSourceInfo(StackTraceElement[] stackTraceElementArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) stackTraceElementArr);
        } else {
            this.stackTraceElements = stackTraceElementArr;
        }
    }

    private static boolean isInterestingStackTrace(StackTraceElement stackTraceElement) {
        if (!stackTraceElement.getClassName().startsWith("com.tencent.opentelemetry.sdk.metrics") && !stackTraceElement.getClassName().startsWith("java.lang")) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.debug.SourceInfo
    public String multiLineDebugString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.stackTraceElements.length > 0) {
            StringBuilder sb5 = new StringBuilder();
            for (StackTraceElement stackTraceElement : this.stackTraceElements) {
                if (isInterestingStackTrace(stackTraceElement)) {
                    sb5.append("\tat ");
                    sb5.append(stackTraceElement);
                    sb5.append("\n");
                }
            }
            return sb5.toString();
        }
        return "\tat unknown source";
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.debug.SourceInfo
    public String shortDebugString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StackTraceElement[] stackTraceElementArr = this.stackTraceElements;
        if (stackTraceElementArr.length > 0) {
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                if (isInterestingStackTrace(stackTraceElement)) {
                    return String.format("%s:%d", stackTraceElement.getFileName(), Integer.valueOf(stackTraceElement.getLineNumber()));
                }
            }
            return "unknown source";
        }
        return "unknown source";
    }
}
