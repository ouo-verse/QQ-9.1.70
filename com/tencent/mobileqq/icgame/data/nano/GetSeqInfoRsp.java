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
public final class GetSeqInfoRsp extends ExtendableMessageNano<GetSeqInfoRsp> {
    private static volatile GetSeqInfoRsp[] _emptyArray;
    public SeqInfo seqInfo;

    public GetSeqInfoRsp() {
        clear();
    }

    public static GetSeqInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetSeqInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetSeqInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetSeqInfoRsp) MessageNano.mergeFrom(new GetSeqInfoRsp(), bArr);
    }

    public GetSeqInfoRsp clear() {
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

    public static GetSeqInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetSeqInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetSeqInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
