package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class CreateTaskByPKInfoRsp extends ExtendableMessageNano<CreateTaskByPKInfoRsp> {
    private static volatile CreateTaskByPKInfoRsp[] _emptyArray;

    public CreateTaskByPKInfoRsp() {
        clear();
    }

    public static CreateTaskByPKInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CreateTaskByPKInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static CreateTaskByPKInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CreateTaskByPKInfoRsp) MessageNano.mergeFrom(new CreateTaskByPKInfoRsp(), bArr);
    }

    public CreateTaskByPKInfoRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static CreateTaskByPKInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new CreateTaskByPKInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public CreateTaskByPKInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int readTag;
        do {
            readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            }
        } while (storeUnknownField(codedInputByteBufferNano, readTag));
        return this;
    }
}
