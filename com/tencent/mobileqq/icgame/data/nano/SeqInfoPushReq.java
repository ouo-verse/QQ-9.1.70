package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class SeqInfoPushReq extends ExtendableMessageNano<SeqInfoPushReq> {
    private static volatile SeqInfoPushReq[] _emptyArray;
    public SeqInfo seqInfo;

    public SeqInfoPushReq() {
        clear();
    }

    public static SeqInfoPushReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SeqInfoPushReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SeqInfoPushReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SeqInfoPushReq) MessageNano.mergeFrom(new SeqInfoPushReq(), bArr);
    }

    public SeqInfoPushReq clear() {
        this.seqInfo = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        SeqInfo seqInfo = this.seqInfo;
        if (seqInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, seqInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        SeqInfo seqInfo = this.seqInfo;
        if (seqInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, seqInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SeqInfoPushReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SeqInfoPushReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SeqInfoPushReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 10) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.seqInfo == null) {
                    this.seqInfo = new SeqInfo();
                }
                codedInputByteBufferNano.readMessage(this.seqInfo);
            }
        }
    }
}
