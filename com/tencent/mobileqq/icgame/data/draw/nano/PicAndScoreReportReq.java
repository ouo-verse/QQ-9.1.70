package com.tencent.mobileqq.icgame.data.draw.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class PicAndScoreReportReq extends ExtendableMessageNano<PicAndScoreReportReq> {
    private static volatile PicAndScoreReportReq[] _emptyArray;
    public String answer;
    public int answeredNum;
    public int multiple;
    public String picUrl;
    public long roomId;
    public int score;
    public String startSeq;
    public long uid;

    public PicAndScoreReportReq() {
        clear();
    }

    public static PicAndScoreReportReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PicAndScoreReportReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static PicAndScoreReportReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (PicAndScoreReportReq) MessageNano.mergeFrom(new PicAndScoreReportReq(), bArr);
    }

    public PicAndScoreReportReq clear() {
        this.uid = 0L;
        this.roomId = 0L;
        this.startSeq = "";
        this.picUrl = "";
        this.answeredNum = 0;
        this.score = 0;
        this.multiple = 0;
        this.answer = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.uid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.roomId;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        if (!this.startSeq.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.startSeq);
        }
        if (!this.picUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.picUrl);
        }
        int i3 = this.answeredNum;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i3);
        }
        int i16 = this.score;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i16);
        }
        int i17 = this.multiple;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i17);
        }
        if (!this.answer.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(8, this.answer);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.roomId;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        if (!this.startSeq.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.startSeq);
        }
        if (!this.picUrl.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.picUrl);
        }
        int i3 = this.answeredNum;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i3);
        }
        int i16 = this.score;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i16);
        }
        int i17 = this.multiple;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i17);
        }
        if (!this.answer.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.answer);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static PicAndScoreReportReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new PicAndScoreReportReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public PicAndScoreReportReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.roomId = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 26) {
                this.startSeq = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.picUrl = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.answeredNum = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 48) {
                this.score = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 56) {
                this.multiple = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 66) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.answer = codedInputByteBufferNano.readString();
            }
        }
    }
}
