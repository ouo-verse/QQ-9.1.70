package com.tencent.mobileqq.icgame.data.pic.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class CheckRsp extends ExtendableMessageNano<CheckRsp> {
    private static volatile CheckRsp[] _emptyArray;

    public CheckRsp() {
        clear();
    }

    public static CheckRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CheckRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static CheckRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CheckRsp) MessageNano.mergeFrom(new CheckRsp(), bArr);
    }

    public CheckRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static CheckRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new CheckRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public CheckRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
