package com.tencent.mobileqq.icgame.data.play.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class ExitGamePlayFreePlayRsp extends ExtendableMessageNano<ExitGamePlayFreePlayRsp> {
    private static volatile ExitGamePlayFreePlayRsp[] _emptyArray;

    public ExitGamePlayFreePlayRsp() {
        clear();
    }

    public static ExitGamePlayFreePlayRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ExitGamePlayFreePlayRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ExitGamePlayFreePlayRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ExitGamePlayFreePlayRsp) MessageNano.mergeFrom(new ExitGamePlayFreePlayRsp(), bArr);
    }

    public ExitGamePlayFreePlayRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static ExitGamePlayFreePlayRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ExitGamePlayFreePlayRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ExitGamePlayFreePlayRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
