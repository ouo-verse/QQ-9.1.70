package com.google.protobuf;

import com.google.protobuf.au;
import com.google.protobuf.b;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class c<MessageType extends au> implements bg<MessageType> {

    /* renamed from: a, reason: collision with root package name */
    private static final t f35788a = t.b();

    private MessageType n(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype != null && !messagetype.isInitialized()) {
            throw o(messagetype).asInvalidProtocolBufferException().setUnfinishedMessage(messagetype);
        }
        return messagetype;
    }

    private UninitializedMessageException o(MessageType messagetype) {
        if (messagetype instanceof b) {
            return ((b) messagetype).newUninitializedMessageException();
        }
        return new UninitializedMessageException(messagetype);
    }

    public MessageType A(byte[] bArr, int i3, int i16, t tVar) throws InvalidProtocolBufferException {
        return n(F(bArr, i3, i16, tVar));
    }

    @Override // com.google.protobuf.bg
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public MessageType i(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
        return A(bArr, 0, bArr.length, tVar);
    }

    public MessageType C(InputStream inputStream, t tVar) throws InvalidProtocolBufferException {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            return E(new b.a.C0253a(inputStream, k.C(read, inputStream)), tVar);
        } catch (IOException e16) {
            throw new InvalidProtocolBufferException(e16);
        }
    }

    public MessageType D(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
        try {
            k newCodedInput = byteString.newCodedInput();
            MessageType messagetype = (MessageType) g(newCodedInput, tVar);
            try {
                newCodedInput.a(0);
                return messagetype;
            } catch (InvalidProtocolBufferException e16) {
                throw e16.setUnfinishedMessage(messagetype);
            }
        } catch (InvalidProtocolBufferException e17) {
            throw e17;
        }
    }

    public MessageType E(InputStream inputStream, t tVar) throws InvalidProtocolBufferException {
        k g16 = k.g(inputStream);
        MessageType messagetype = (MessageType) g(g16, tVar);
        try {
            g16.a(0);
            return messagetype;
        } catch (InvalidProtocolBufferException e16) {
            throw e16.setUnfinishedMessage(messagetype);
        }
    }

    public MessageType F(byte[] bArr, int i3, int i16, t tVar) throws InvalidProtocolBufferException {
        try {
            k l3 = k.l(bArr, i3, i16);
            MessageType messagetype = (MessageType) g(l3, tVar);
            try {
                l3.a(0);
                return messagetype;
            } catch (InvalidProtocolBufferException e16) {
                throw e16.setUnfinishedMessage(messagetype);
            }
        } catch (InvalidProtocolBufferException e17) {
            throw e17;
        }
    }

    @Override // com.google.protobuf.bg
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public MessageType h(InputStream inputStream) throws InvalidProtocolBufferException {
        return k(inputStream, f35788a);
    }

    @Override // com.google.protobuf.bg
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public MessageType k(InputStream inputStream, t tVar) throws InvalidProtocolBufferException {
        return n(C(inputStream, tVar));
    }

    @Override // com.google.protobuf.bg
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public MessageType b(ByteString byteString) throws InvalidProtocolBufferException {
        return a(byteString, f35788a);
    }

    @Override // com.google.protobuf.bg
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public MessageType a(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
        return n(D(byteString, tVar));
    }

    @Override // com.google.protobuf.bg
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public MessageType c(k kVar) throws InvalidProtocolBufferException {
        return e(kVar, f35788a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.bg
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public MessageType e(k kVar, t tVar) throws InvalidProtocolBufferException {
        return (MessageType) n((au) g(kVar, tVar));
    }

    @Override // com.google.protobuf.bg
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public MessageType f(InputStream inputStream) throws InvalidProtocolBufferException {
        return l(inputStream, f35788a);
    }

    @Override // com.google.protobuf.bg
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public MessageType l(InputStream inputStream, t tVar) throws InvalidProtocolBufferException {
        return n(E(inputStream, tVar));
    }

    @Override // com.google.protobuf.bg
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public MessageType d(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return m(byteBuffer, f35788a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.bg
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public MessageType m(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
        try {
            k i3 = k.i(byteBuffer);
            au auVar = (au) g(i3, tVar);
            try {
                i3.a(0);
                return (MessageType) n(auVar);
            } catch (InvalidProtocolBufferException e16) {
                throw e16.setUnfinishedMessage(auVar);
            }
        } catch (InvalidProtocolBufferException e17) {
            throw e17;
        }
    }

    @Override // com.google.protobuf.bg
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public MessageType j(byte[] bArr) throws InvalidProtocolBufferException {
        return i(bArr, f35788a);
    }
}
