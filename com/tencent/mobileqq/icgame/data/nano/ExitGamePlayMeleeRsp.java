package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class ExitGamePlayMeleeRsp extends ExtendableMessageNano<ExitGamePlayMeleeRsp> {
    private static volatile ExitGamePlayMeleeRsp[] _emptyArray;

    public ExitGamePlayMeleeRsp() {
        clear();
    }

    public static ExitGamePlayMeleeRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ExitGamePlayMeleeRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ExitGamePlayMeleeRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ExitGamePlayMeleeRsp) MessageNano.mergeFrom(new ExitGamePlayMeleeRsp(), bArr);
    }

    public ExitGamePlayMeleeRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static ExitGamePlayMeleeRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ExitGamePlayMeleeRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ExitGamePlayMeleeRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
