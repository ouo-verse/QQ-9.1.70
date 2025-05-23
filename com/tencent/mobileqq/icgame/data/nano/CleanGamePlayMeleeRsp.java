package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class CleanGamePlayMeleeRsp extends ExtendableMessageNano<CleanGamePlayMeleeRsp> {
    private static volatile CleanGamePlayMeleeRsp[] _emptyArray;

    public CleanGamePlayMeleeRsp() {
        clear();
    }

    public static CleanGamePlayMeleeRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CleanGamePlayMeleeRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static CleanGamePlayMeleeRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CleanGamePlayMeleeRsp) MessageNano.mergeFrom(new CleanGamePlayMeleeRsp(), bArr);
    }

    public CleanGamePlayMeleeRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static CleanGamePlayMeleeRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new CleanGamePlayMeleeRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public CleanGamePlayMeleeRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
