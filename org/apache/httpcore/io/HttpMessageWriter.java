package org.apache.httpcore.io;

import java.io.IOException;
import org.apache.httpcore.HttpException;
import org.apache.httpcore.HttpMessage;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface HttpMessageWriter<T extends HttpMessage> {
    void write(T t16) throws IOException, HttpException;
}
