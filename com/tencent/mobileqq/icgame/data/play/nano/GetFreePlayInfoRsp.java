package com.tencent.mobileqq.icgame.data.play.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class GetFreePlayInfoRsp extends ExtendableMessageNano<GetFreePlayInfoRsp> {
    private static volatile GetFreePlayInfoRsp[] _emptyArray;
    public FreePlayBasicInfo basicInfo;
    public FreePlayScore score;

    public GetFreePlayInfoRsp() {
        clear();
    }

    public static GetFreePlayInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetFreePlayInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetFreePlayInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetFreePlayInfoRsp) MessageNano.mergeFrom(new GetFreePlayInfoRsp(), bArr);
    }

    public GetFreePlayInfoRsp clear() {
        this.basicInfo = null;
        this.score = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        FreePlayBasicInfo freePlayBasicInfo = this.basicInfo;
        if (freePlayBasicInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, freePlayBasicInfo);
        }
        FreePlayScore freePlayScore = this.score;
        if (freePlayScore != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, freePlayScore);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        FreePlayBasicInfo freePlayBasicInfo = this.basicInfo;
        if (freePlayBasicInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, freePlayBasicInfo);
        }
        FreePlayScore freePlayScore = this.score;
        if (freePlayScore != null) {
            codedOutputByteBufferNano.writeMessage(2, freePlayScore);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetFreePlayInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetFreePlayInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetFreePlayInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.basicInfo == null) {
                    this.basicInfo = new FreePlayBasicInfo();
                }
                codedInputByteBufferNano.readMessage(this.basicInfo);
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.score == null) {
                    this.score = new FreePlayScore();
                }
                codedInputByteBufferNano.readMessage(this.score);
            }
        }
    }
}
