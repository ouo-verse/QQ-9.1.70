package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class CreateTaskRsp extends ExtendableMessageNano<CreateTaskRsp> {
    private static volatile CreateTaskRsp[] _emptyArray;

    public CreateTaskRsp() {
        clear();
    }

    public static CreateTaskRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CreateTaskRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static CreateTaskRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CreateTaskRsp) MessageNano.mergeFrom(new CreateTaskRsp(), bArr);
    }

    public CreateTaskRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static CreateTaskRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new CreateTaskRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public CreateTaskRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
