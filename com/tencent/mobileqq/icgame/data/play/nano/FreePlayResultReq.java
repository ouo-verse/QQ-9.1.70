package com.tencent.mobileqq.icgame.data.play.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class FreePlayResultReq extends ExtendableMessageNano<FreePlayResultReq> {
    private static volatile FreePlayResultReq[] _emptyArray;
    public int roomId;
    public long startSeq;

    public FreePlayResultReq() {
        clear();
    }

    public static FreePlayResultReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new FreePlayResultReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static FreePlayResultReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (FreePlayResultReq) MessageNano.mergeFrom(new FreePlayResultReq(), bArr);
    }

    public FreePlayResultReq clear() {
        this.roomId = 0;
        this.startSeq = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        return super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.roomId) + CodedOutputByteBufferNano.computeUInt64Size(2, this.startSeq);
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.roomId);
        codedOutputByteBufferNano.writeUInt64(2, this.startSeq);
        super.writeTo(codedOutputByteBufferNano);
    }

    public static FreePlayResultReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new FreePlayResultReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public FreePlayResultReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.startSeq = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
