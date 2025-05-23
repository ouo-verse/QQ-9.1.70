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
public final class EditWaitingListRsp extends ExtendableMessageNano<EditWaitingListRsp> {
    private static volatile EditWaitingListRsp[] _emptyArray;
    public SeqInfo roomStageSeqInfo;
    public SeqInfo waitingListSeqInfo;

    public EditWaitingListRsp() {
        clear();
    }

    public static EditWaitingListRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new EditWaitingListRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static EditWaitingListRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (EditWaitingListRsp) MessageNano.mergeFrom(new EditWaitingListRsp(), bArr);
    }

    public EditWaitingListRsp clear() {
        this.waitingListSeqInfo = null;
        this.roomStageSeqInfo = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        SeqInfo seqInfo = this.waitingListSeqInfo;
        if (seqInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, seqInfo);
        }
        SeqInfo seqInfo2 = this.roomStageSeqInfo;
        if (seqInfo2 != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, seqInfo2);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        SeqInfo seqInfo = this.waitingListSeqInfo;
        if (seqInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, seqInfo);
        }
        SeqInfo seqInfo2 = this.roomStageSeqInfo;
        if (seqInfo2 != null) {
            codedOutputByteBufferNano.writeMessage(2, seqInfo2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static EditWaitingListRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new EditWaitingListRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public EditWaitingListRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.waitingListSeqInfo == null) {
                    this.waitingListSeqInfo = new SeqInfo();
                }
                codedInputByteBufferNano.readMessage(this.waitingListSeqInfo);
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.roomStageSeqInfo == null) {
                    this.roomStageSeqInfo = new SeqInfo();
                }
                codedInputByteBufferNano.readMessage(this.roomStageSeqInfo);
            }
        }
    }
}
