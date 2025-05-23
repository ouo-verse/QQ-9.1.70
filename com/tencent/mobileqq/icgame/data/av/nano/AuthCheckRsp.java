package com.tencent.mobileqq.icgame.data.av.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class AuthCheckRsp extends ExtendableMessageNano<AuthCheckRsp> {
    private static volatile AuthCheckRsp[] _emptyArray;
    public int result;

    public AuthCheckRsp() {
        clear();
    }

    public static AuthCheckRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AuthCheckRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AuthCheckRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AuthCheckRsp) MessageNano.mergeFrom(new AuthCheckRsp(), bArr);
    }

    public AuthCheckRsp clear() {
        this.result = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        return super.computeSerializedSize() + CodedOutputByteBufferNano.computeInt32Size(1, this.result);
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeInt32(1, this.result);
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AuthCheckRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AuthCheckRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AuthCheckRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 8) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.result = codedInputByteBufferNano.readInt32();
            }
        }
    }
}
