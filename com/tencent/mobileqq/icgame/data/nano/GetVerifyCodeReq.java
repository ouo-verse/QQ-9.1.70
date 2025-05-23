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
public final class GetVerifyCodeReq extends ExtendableMessageNano<GetVerifyCodeReq> {
    private static volatile GetVerifyCodeReq[] _emptyArray;
    public String phone;

    public GetVerifyCodeReq() {
        clear();
    }

    public static GetVerifyCodeReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetVerifyCodeReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetVerifyCodeReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetVerifyCodeReq) MessageNano.mergeFrom(new GetVerifyCodeReq(), bArr);
    }

    public GetVerifyCodeReq clear() {
        this.phone = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.phone.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.phone);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.phone.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.phone);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetVerifyCodeReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetVerifyCodeReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetVerifyCodeReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                this.phone = codedInputByteBufferNano.readString();
            }
        }
    }
}
