package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class CreateTaskByPKInfoReq extends ExtendableMessageNano<CreateTaskByPKInfoReq> {
    private static volatile CreateTaskByPKInfoReq[] _emptyArray;
    public String actId;
    public PKInfo pkInfo;

    public CreateTaskByPKInfoReq() {
        clear();
    }

    public static CreateTaskByPKInfoReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CreateTaskByPKInfoReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static CreateTaskByPKInfoReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CreateTaskByPKInfoReq) MessageNano.mergeFrom(new CreateTaskByPKInfoReq(), bArr);
    }

    public CreateTaskByPKInfoReq clear() {
        this.actId = "";
        this.pkInfo = null;
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
        PKInfo pKInfo = this.pkInfo;
        if (pKInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, pKInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.actId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.actId);
        }
        PKInfo pKInfo = this.pkInfo;
        if (pKInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, pKInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static CreateTaskByPKInfoReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new CreateTaskByPKInfoReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public CreateTaskByPKInfoReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.actId = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.pkInfo == null) {
                    this.pkInfo = new PKInfo();
                }
                codedInputByteBufferNano.readMessage(this.pkInfo);
            }
        }
    }
}
