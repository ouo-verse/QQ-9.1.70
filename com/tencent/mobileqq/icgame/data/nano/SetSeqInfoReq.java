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
public final class SetSeqInfoReq extends ExtendableMessageNano<SetSeqInfoReq> {
    private static volatile SetSeqInfoReq[] _emptyArray;
    public SeqInfo seqInfo;

    public SetSeqInfoReq() {
        clear();
    }

    public static SetSeqInfoReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SetSeqInfoReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SetSeqInfoReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SetSeqInfoReq) MessageNano.mergeFrom(new SetSeqInfoReq(), bArr);
    }

    public SetSeqInfoReq clear() {
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

    public static SetSeqInfoReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SetSeqInfoReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SetSeqInfoReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
