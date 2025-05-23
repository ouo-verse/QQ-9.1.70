package org.apache.httpcore.message;

import org.apache.httpcore.Header;
import org.apache.httpcore.ProtocolVersion;
import org.apache.httpcore.RequestLine;
import org.apache.httpcore.StatusLine;
import org.apache.httpcore.util.CharArrayBuffer;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface LineFormatter {
    CharArrayBuffer appendProtocolVersion(CharArrayBuffer charArrayBuffer, ProtocolVersion protocolVersion);

    CharArrayBuffer formatHeader(CharArrayBuffer charArrayBuffer, Header header);

    CharArrayBuffer formatRequestLine(CharArrayBuffer charArrayBuffer, RequestLine requestLine);

    CharArrayBuffer formatStatusLine(CharArrayBuffer charArrayBuffer, StatusLine statusLine);
}
