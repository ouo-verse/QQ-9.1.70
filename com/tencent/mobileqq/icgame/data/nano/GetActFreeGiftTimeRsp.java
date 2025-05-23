package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class GetActFreeGiftTimeRsp extends ExtendableMessageNano<GetActFreeGiftTimeRsp> {
    private static volatile GetActFreeGiftTimeRsp[] _emptyArray;
    public long acceptCircleTime;
    public long accumulateTime;
    public long startTime;

    public GetActFreeGiftTimeRsp() {
        clear();
    }

    public static GetActFreeGiftTimeRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetActFreeGiftTimeRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetActFreeGiftTimeRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetActFreeGiftTimeRsp) MessageNano.mergeFrom(new GetActFreeGiftTimeRsp(), bArr);
    }

    public GetActFreeGiftTimeRsp clear() {
        this.startTime = 0L;
        this.accumulateTime = 0L;
        this.acceptCircleTime = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.startTime;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.accumulateTime;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        long j17 = this.acceptCircleTime;
        if (j17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.startTime;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.accumulateTime;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        long j17 = this.acceptCircleTime;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetActFreeGiftTimeRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetActFreeGiftTimeRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetActFreeGiftTimeRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.startTime = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.accumulateTime = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.acceptCircleTime = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
