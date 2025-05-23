package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class PkPropProgress extends ExtendableMessageNano<PkPropProgress> {
    private static volatile PkPropProgress[] _emptyArray;
    public int percent;
    public int validCount;

    public PkPropProgress() {
        clear();
    }

    public static PkPropProgress[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PkPropProgress[0];
                }
            }
        }
        return _emptyArray;
    }

    public static PkPropProgress parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (PkPropProgress) MessageNano.mergeFrom(new PkPropProgress(), bArr);
    }

    public PkPropProgress clear() {
        this.validCount = 0;
        this.percent = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.validCount;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.percent;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.validCount;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.percent;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static PkPropProgress parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new PkPropProgress().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public PkPropProgress mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.validCount = codedInputByteBufferNano.readInt32();
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.percent = codedInputByteBufferNano.readInt32();
            }
        }
    }
}
