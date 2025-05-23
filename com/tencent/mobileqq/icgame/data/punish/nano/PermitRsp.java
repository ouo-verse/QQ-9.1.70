package com.tencent.mobileqq.icgame.data.punish.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class PermitRsp extends ExtendableMessageNano<PermitRsp> {
    private static volatile PermitRsp[] _emptyArray;

    public PermitRsp() {
        clear();
    }

    public static PermitRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PermitRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static PermitRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (PermitRsp) MessageNano.mergeFrom(new PermitRsp(), bArr);
    }

    public PermitRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static PermitRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new PermitRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public PermitRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
