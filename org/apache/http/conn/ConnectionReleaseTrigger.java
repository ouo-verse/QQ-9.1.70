package org.apache.http.conn;

import java.io.IOException;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface ConnectionReleaseTrigger {
    void abortConnection() throws IOException;

    void releaseConnection() throws IOException;
}
