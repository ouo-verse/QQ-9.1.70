package com.tencent.mobileqq.icgame.data.play.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class PkSelfMgsRsp extends ExtendableMessageNano<PkSelfMgsRsp> {
    private static volatile PkSelfMgsRsp[] _emptyArray;

    public PkSelfMgsRsp() {
        clear();
    }

    public static PkSelfMgsRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PkSelfMgsRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static PkSelfMgsRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (PkSelfMgsRsp) MessageNano.mergeFrom(new PkSelfMgsRsp(), bArr);
    }

    public PkSelfMgsRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static PkSelfMgsRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new PkSelfMgsRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public PkSelfMgsRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
