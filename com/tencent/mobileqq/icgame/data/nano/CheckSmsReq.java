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
public final class CheckSmsReq extends ExtendableMessageNano<CheckSmsReq> {
    private static volatile CheckSmsReq[] _emptyArray;
    public int checkType;
    public String smsCode;
    public String smsToken;

    public CheckSmsReq() {
        clear();
    }

    public static CheckSmsReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CheckSmsReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static CheckSmsReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CheckSmsReq) MessageNano.mergeFrom(new CheckSmsReq(), bArr);
    }

    public CheckSmsReq clear() {
        this.smsCode = "";
        this.smsToken = "";
        this.checkType = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.smsCode.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.smsCode);
        }
        if (!this.smsToken.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.smsToken);
        }
        int i3 = this.checkType;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.smsCode.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.smsCode);
        }
        if (!this.smsToken.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.smsToken);
        }
        int i3 = this.checkType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static CheckSmsReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new CheckSmsReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public CheckSmsReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.smsCode = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.smsToken = codedInputByteBufferNano.readString();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.checkType = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
