package org.apache.commons.io;

import java.io.IOException;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public class IOExceptionWithCause extends IOException {
    private static final long serialVersionUID = 1;

    public IOExceptionWithCause(String str, Throwable th5) {
        super(str, th5);
    }

    public IOExceptionWithCause(Throwable th5) {
        super(th5);
    }
}
