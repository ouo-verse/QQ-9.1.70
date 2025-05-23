package org.apache.httpcore.io;

import java.io.IOException;
import java.net.Socket;
import org.apache.httpcore.HttpException;
import org.apache.httpcore.HttpMessage;

/* loaded from: classes29.dex */
public interface HttpMessageParser<T extends HttpMessage> {
    T parse(Socket socket) throws IOException, HttpException;
}
