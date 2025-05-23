package com.tencent.luggage.wxa.kr;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends IOException {
    public b(String str) {
        super(str);
    }

    public static b a() {
        return new b("Protocol message contained an invalid tag (zero).");
    }

    public static b b() {
        return new b("CodedInputStream encountered a malformed varint.");
    }

    public static b c() {
        return new b("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static b d() {
        return new b("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public static b e() {
        return new b("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }
}
