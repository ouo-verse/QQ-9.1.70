package com.immersion.touchsensesdk;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface IConnection {
    void disconnect();

    int getContentLength();

    long getLastModified();

    int getResponseCode() throws IOException;

    byte[] readAllData() throws IOException;
}
