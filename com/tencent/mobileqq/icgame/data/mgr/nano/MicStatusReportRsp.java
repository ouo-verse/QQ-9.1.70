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
public final class MicStatusReportRsp extends ExtendableMessageNano<MicStatusReportRsp> {
    private static volatile MicStatusReportRsp[] _emptyArray;
    public SeqInfo roomStageSeqInfo;

    public MicStatusReportRsp() {
        clear();
    }

    public static MicStatusReportRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new MicStatusReportRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static MicStatusReportRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (MicStatusReportRsp) MessageNano.mergeFrom(new MicStatusReportRsp(), bArr);
    }

    public MicStatusReportRsp clear() {
        this.roomStageSeqInfo = null;
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
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, seqInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        SeqInfo seqInfo = this.roomStageSeqInfo;
        if (seqInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, seqInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static MicStatusReportRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new MicStatusReportRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public MicStatusReportRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.roomStageSeqInfo == null) {
                    this.roomStageSeqInfo = new SeqInfo();
                }
                codedInputByteBufferNano.readMessage(this.roomStageSeqInfo);
            }
        }
    }
}
