package com.google.protobuf.nano;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class MessageNano {
    protected volatile int cachedSize = -1;

    public static final <T extends MessageNano> T mergeFrom(T t16, byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (T) mergeFrom(t16, bArr, 0, bArr.length);
    }

    public static final boolean messageNanoEquals(MessageNano messageNano, MessageNano messageNano2) {
        int serializedSize;
        if (messageNano == messageNano2) {
            return true;
        }
        if (messageNano == null || messageNano2 == null || messageNano.getClass() != messageNano2.getClass() || messageNano2.getSerializedSize() != (serializedSize = messageNano.getSerializedSize())) {
            return false;
        }
        byte[] bArr = new byte[serializedSize];
        byte[] bArr2 = new byte[serializedSize];
        toByteArray(messageNano, bArr, 0, serializedSize);
        toByteArray(messageNano2, bArr2, 0, serializedSize);
        return Arrays.equals(bArr, bArr2);
    }

    public static final byte[] toByteArray(MessageNano messageNano) {
        int serializedSize = messageNano.getSerializedSize();
        byte[] bArr = new byte[serializedSize];
        toByteArray(messageNano, bArr, 0, serializedSize);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int computeSerializedSize() {
        return 0;
    }

    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getSerializedSize() {
        int computeSerializedSize = computeSerializedSize();
        this.cachedSize = computeSerializedSize;
        return computeSerializedSize;
    }

    public abstract MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException;

    public String toString() {
        return MessageNanoPrinter.print(this);
    }

    public static final <T extends MessageNano> T mergeFrom(T t16, byte[] bArr, int i3, int i16) throws InvalidProtocolBufferNanoException {
        try {
            CodedInputByteBufferNano newInstance = CodedInputByteBufferNano.newInstance(bArr, i3, i16);
            t16.mergeFrom(newInstance);
            newInstance.checkLastTagWas(0);
            return t16;
        } catch (InvalidProtocolBufferNanoException e16) {
            throw e16;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public MessageNano mo66clone() throws CloneNotSupportedException {
        return (MessageNano) super.clone();
    }

    public static final void toByteArray(MessageNano messageNano, byte[] bArr, int i3, int i16) {
        try {
            CodedOutputByteBufferNano newInstance = CodedOutputByteBufferNano.newInstance(bArr, i3, i16);
            messageNano.writeTo(newInstance);
            newInstance.checkNoSpaceLeft();
        } catch (IOException e16) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e16);
        }
    }

    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
    }
}
