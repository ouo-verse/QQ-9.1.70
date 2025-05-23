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
public final class AddAwardBuffScoreReq extends ExtendableMessageNano<AddAwardBuffScoreReq> {
    private static volatile AddAwardBuffScoreReq[] _emptyArray;
    public String actId;
    public AddAwardScore addScore;
    public String taskId;

    public AddAwardBuffScoreReq() {
        clear();
    }

    public static AddAwardBuffScoreReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AddAwardBuffScoreReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AddAwardBuffScoreReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AddAwardBuffScoreReq) MessageNano.mergeFrom(new AddAwardBuffScoreReq(), bArr);
    }

    public AddAwardBuffScoreReq clear() {
        this.actId = "";
        this.taskId = "";
        this.addScore = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.actId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.actId);
        }
        if (!this.taskId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.taskId);
        }
        AddAwardScore addAwardScore = this.addScore;
        if (addAwardScore != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, addAwardScore);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.actId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.actId);
        }
        if (!this.taskId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.taskId);
        }
        AddAwardScore addAwardScore = this.addScore;
        if (addAwardScore != null) {
            codedOutputByteBufferNano.writeMessage(3, addAwardScore);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AddAwardBuffScoreReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AddAwardBuffScoreReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AddAwardBuffScoreReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.actId = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.taskId = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.addScore == null) {
                    this.addScore = new AddAwardScore();
                }
                codedInputByteBufferNano.readMessage(this.addScore);
            }
        }
    }
}
