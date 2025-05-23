package org.apache.httpcore.message;

import java.io.Serializable;
import org.apache.httpcore.ProtocolVersion;
import org.apache.httpcore.StatusLine;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.util.Args;
import org.apache.httpcore.util.CharArrayBuffer;

/* compiled from: P */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes29.dex */
public class BasicStatusLine implements StatusLine, Cloneable, Serializable {
    private static final long serialVersionUID = -2443303766890459269L;
    private final ProtocolVersion protoVersion;
    private final String reasonPhrase;
    private final int statusCode;

    public BasicStatusLine(ProtocolVersion protocolVersion, int i3, String str) {
        this.protoVersion = (ProtocolVersion) Args.notNull(protocolVersion, "Version");
        this.statusCode = Args.notNegative(i3, "Status code");
        this.reasonPhrase = str;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // org.apache.httpcore.StatusLine
    public ProtocolVersion getProtocolVersion() {
        return this.protoVersion;
    }

    @Override // org.apache.httpcore.StatusLine
    public String getReasonPhrase() {
        return this.reasonPhrase;
    }

    @Override // org.apache.httpcore.StatusLine
    public int getStatusCode() {
        return this.statusCode;
    }

    public String toString() {
        return BasicLineFormatter.INSTANCE.formatStatusLine((CharArrayBuffer) null, this).toString();
    }
}
