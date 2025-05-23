package com.tencent.qmethod.pandoraex.core.ext.netcap;

import java.io.IOException;

/* loaded from: classes22.dex */
public class PBInvalidProtocolBufferException extends IOException {
    private static final long serialVersionUID = -1616151763072450476L;

    public PBInvalidProtocolBufferException(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PBInvalidProtocolBufferException invalidTag() {
        return new PBInvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PBInvalidProtocolBufferException malformedVarint() {
        return new PBInvalidProtocolBufferException("CodedInputStream encountered a malformed varint.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PBInvalidProtocolBufferException negativeSize() {
        return new PBInvalidProtocolBufferException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PBInvalidProtocolBufferException parseFailure() {
        return new PBInvalidProtocolBufferException("Failed to parse the message.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PBInvalidProtocolBufferException truncatedMessage() {
        return new PBInvalidProtocolBufferException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
