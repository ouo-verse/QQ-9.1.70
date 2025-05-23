package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class SpecialNumber extends ExtendableMessageNano<SpecialNumber> {
    private static volatile SpecialNumber[] _emptyArray;
    public byte[] specialName;
    public int specialNumber;

    public SpecialNumber() {
        clear();
    }

    public static SpecialNumber[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SpecialNumber[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SpecialNumber parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SpecialNumber) MessageNano.mergeFrom(new SpecialNumber(), bArr);
    }

    public SpecialNumber clear() {
        this.specialNumber = 0;
        this.specialName = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        return super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.specialNumber) + CodedOutputByteBufferNano.computeBytesSize(2, this.specialName);
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.specialNumber);
        codedOutputByteBufferNano.writeBytes(2, this.specialName);
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SpecialNumber parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SpecialNumber().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SpecialNumber mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.specialNumber = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.specialName = codedInputByteBufferNano.readBytes();
            }
        }
    }
}
