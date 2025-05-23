package com.tencent.mobileqq.icgame.data.punish.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class ForbidRsp extends ExtendableMessageNano<ForbidRsp> {
    private static volatile ForbidRsp[] _emptyArray;

    public ForbidRsp() {
        clear();
    }

    public static ForbidRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ForbidRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ForbidRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ForbidRsp) MessageNano.mergeFrom(new ForbidRsp(), bArr);
    }

    public ForbidRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static ForbidRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ForbidRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ForbidRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
