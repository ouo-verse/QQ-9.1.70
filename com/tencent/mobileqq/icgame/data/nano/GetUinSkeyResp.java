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
public final class GetUinSkeyResp extends ExtendableMessageNano<GetUinSkeyResp> {
    private static volatile GetUinSkeyResp[] _emptyArray;
    public String skey;
    public long uin;

    public GetUinSkeyResp() {
        clear();
    }

    public static GetUinSkeyResp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetUinSkeyResp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetUinSkeyResp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetUinSkeyResp) MessageNano.mergeFrom(new GetUinSkeyResp(), bArr);
    }

    public GetUinSkeyResp clear() {
        this.uin = 0L;
        this.skey = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.uin;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.skey.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.skey);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uin;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.skey.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.skey);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetUinSkeyResp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetUinSkeyResp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetUinSkeyResp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uin = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.skey = codedInputByteBufferNano.readString();
            }
        }
    }
}
