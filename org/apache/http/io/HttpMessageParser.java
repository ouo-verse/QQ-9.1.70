package org.apache.http.io;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;

@Deprecated
/* loaded from: classes29.dex */
public interface HttpMessageParser {
    HttpMessage parse() throws IOException, HttpException;
}
