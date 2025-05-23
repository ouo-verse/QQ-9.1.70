package com.tencent.mobileqq.icgame.data.mgr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.icgame.data.nano.SeqInfo;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class ConfirmSeatRsp extends ExtendableMessageNano<ConfirmSeatRsp> {
    private static volatile ConfirmSeatRsp[] _emptyArray;
    public SeqInfo roomStageSeqInfo;
    public SeqInfo waitingListSeqInfo;

    public ConfirmSeatRsp() {
        clear();
    }

    public static ConfirmSeatRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ConfirmSeatRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ConfirmSeatRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ConfirmSeatRsp) MessageNano.mergeFrom(new ConfirmSeatRsp(), bArr);
    }

    public ConfirmSeatRsp clear() {
        this.roomStageSeqInfo = null;
        this.waitingListSeqInfo = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        SeqInfo seqInfo = this.roomStageSeqInfo;
        if (seqInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, seqInfo);
        }
        SeqInfo seqInfo2 = this.waitingListSeqInfo;
        if (seqInfo2 != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, seqInfo2);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        SeqInfo seqInfo = this.roomStageSeqInfo;
        if (seqInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, seqInfo);
        }
        SeqInfo seqInfo2 = this.waitingListSeqInfo;
        if (seqInfo2 != null) {
            codedOutputByteBufferNano.writeMessage(2, seqInfo2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ConfirmSeatRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ConfirmSeatRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ConfirmSeatRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.roomStageSeqInfo == null) {
                    this.roomStageSeqInfo = new SeqInfo();
                }
                codedInputByteBufferNano.readMessage(this.roomStageSeqInfo);
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.waitingListSeqInfo == null) {
                    this.waitingListSeqInfo = new SeqInfo();
                }
                codedInputByteBufferNano.readMessage(this.waitingListSeqInfo);
            }
        }
    }
}
