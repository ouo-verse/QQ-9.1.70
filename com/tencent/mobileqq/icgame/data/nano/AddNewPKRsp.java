package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class AddNewPKRsp extends ExtendableMessageNano<AddNewPKRsp> {
    private static volatile AddNewPKRsp[] _emptyArray;

    public AddNewPKRsp() {
        clear();
    }

    public static AddNewPKRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AddNewPKRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AddNewPKRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AddNewPKRsp) MessageNano.mergeFrom(new AddNewPKRsp(), bArr);
    }

    public AddNewPKRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static AddNewPKRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AddNewPKRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AddNewPKRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
