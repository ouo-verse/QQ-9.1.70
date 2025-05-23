package org.jf.dexlib2.analysis;

import org.jf.util.ExceptionWithContext;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AnalysisException extends ExceptionWithContext {
    public int codeAddress;

    public AnalysisException(Throwable th5) {
        super(th5);
    }

    public AnalysisException(Throwable th5, String str, Object... objArr) {
        super(th5, str, objArr);
    }

    public AnalysisException(String str, Object... objArr) {
        super(str, objArr);
    }
}
