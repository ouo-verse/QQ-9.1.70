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
public final class CheckVerifyCodeReq extends ExtendableMessageNano<CheckVerifyCodeReq> {
    private static volatile CheckVerifyCodeReq[] _emptyArray;
    public int code;
    public String phone;

    public CheckVerifyCodeReq() {
        clear();
    }

    public static CheckVerifyCodeReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CheckVerifyCodeReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static CheckVerifyCodeReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CheckVerifyCodeReq) MessageNano.mergeFrom(new CheckVerifyCodeReq(), bArr);
    }

    public CheckVerifyCodeReq clear() {
        this.phone = "";
        this.code = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.phone.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.phone);
        }
        int i3 = this.code;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.phone.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.phone);
        }
        int i3 = this.code;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static CheckVerifyCodeReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new CheckVerifyCodeReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public CheckVerifyCodeReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.phone = codedInputByteBufferNano.readString();
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.code = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
