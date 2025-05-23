package com.google.protobuf;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface au extends av {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface a extends av, Cloneable {
        au build();

        au buildPartial();

        a mergeFrom(au auVar);

        a mergeFrom(k kVar, t tVar) throws IOException;

        a mergeFrom(byte[] bArr) throws InvalidProtocolBufferException;
    }

    bg<? extends au> getParserForType();

    int getSerializedSize();

    a newBuilderForType();

    a toBuilder();

    byte[] toByteArray();

    ByteString toByteString();

    void writeTo(CodedOutputStream codedOutputStream) throws IOException;
}
