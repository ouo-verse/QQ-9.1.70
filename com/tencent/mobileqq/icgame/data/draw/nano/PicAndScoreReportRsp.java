package com.tencent.mobileqq.icgame.data.draw.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class PicAndScoreReportRsp extends ExtendableMessageNano<PicAndScoreReportRsp> {
    private static volatile PicAndScoreReportRsp[] _emptyArray;
    public String errMsg;
    public int result;

    public PicAndScoreReportRsp() {
        clear();
    }

    public static PicAndScoreReportRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PicAndScoreReportRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static PicAndScoreReportRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (PicAndScoreReportRsp) MessageNano.mergeFrom(new PicAndScoreReportRsp(), bArr);
    }

    public PicAndScoreReportRsp clear() {
        this.result = 0;
        this.errMsg = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.result;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.errMsg.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.errMsg);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.result;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.errMsg.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.errMsg);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static PicAndScoreReportRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new PicAndScoreReportRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public PicAndScoreReportRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.result = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.errMsg = codedInputByteBufferNano.readString();
            }
        }
    }
}
