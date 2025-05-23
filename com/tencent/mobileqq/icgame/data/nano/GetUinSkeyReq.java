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
public final class GetUinSkeyReq extends ExtendableMessageNano<GetUinSkeyReq> {
    private static volatile GetUinSkeyReq[] _emptyArray;
    public int authAppId;
    public String authId;
    public String authKey;

    public GetUinSkeyReq() {
        clear();
    }

    public static GetUinSkeyReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetUinSkeyReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetUinSkeyReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetUinSkeyReq) MessageNano.mergeFrom(new GetUinSkeyReq(), bArr);
    }

    public GetUinSkeyReq clear() {
        this.authAppId = 0;
        this.authId = "";
        this.authKey = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.authAppId;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.authId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.authId);
        }
        if (!this.authKey.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.authKey);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.authAppId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.authId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.authId);
        }
        if (!this.authKey.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.authKey);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetUinSkeyReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetUinSkeyReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetUinSkeyReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.authAppId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.authId = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.authKey = codedInputByteBufferNano.readString();
            }
        }
    }
}
