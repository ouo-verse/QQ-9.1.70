package org.apache.httpcore.message;

import java.io.Serializable;
import org.apache.httpcore.ProtocolVersion;
import org.apache.httpcore.RequestLine;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.util.Args;
import org.apache.httpcore.util.CharArrayBuffer;

/* compiled from: P */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes29.dex */
public class BasicRequestLine implements RequestLine, Cloneable, Serializable {
    private static final long serialVersionUID = 2810581718468737193L;
    private final String method;
    private final ProtocolVersion protoversion;
    private final String uri;

    public BasicRequestLine(String str, String str2, ProtocolVersion protocolVersion) {
        this.method = (String) Args.notNull(str, "Method");
        this.uri = (String) Args.notNull(str2, "URI");
        this.protoversion = (ProtocolVersion) Args.notNull(protocolVersion, "Version");
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // org.apache.httpcore.RequestLine
    public String getMethod() {
        return this.method;
    }

    @Override // org.apache.httpcore.RequestLine
    public ProtocolVersion getProtocolVersion() {
        return this.protoversion;
    }

    @Override // org.apache.httpcore.RequestLine
    public String getUri() {
        return this.uri;
    }

    public String toString() {
        return BasicLineFormatter.INSTANCE.formatRequestLine((CharArrayBuffer) null, this).toString();
    }
}
