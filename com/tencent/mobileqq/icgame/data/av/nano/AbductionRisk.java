package com.tencent.mobileqq.icgame.data.av.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class AbductionRisk extends ExtendableMessageNano<AbductionRisk> {
    private static volatile AbductionRisk[] _emptyArray;
    public int level;
    public int type;

    public AbductionRisk() {
        clear();
    }

    public static AbductionRisk[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AbductionRisk[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AbductionRisk parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AbductionRisk) MessageNano.mergeFrom(new AbductionRisk(), bArr);
    }

    public AbductionRisk clear() {
        this.level = 0;
        this.type = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.level;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.type;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.level;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.type;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AbductionRisk parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AbductionRisk().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AbductionRisk mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.level = codedInputByteBufferNano.readInt32();
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.type = codedInputByteBufferNano.readInt32();
            }
        }
    }
}
