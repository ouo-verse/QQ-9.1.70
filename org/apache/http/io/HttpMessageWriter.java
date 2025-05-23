package org.apache.http.io;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface HttpMessageWriter {
    void write(HttpMessage httpMessage) throws IOException, HttpException;
}
