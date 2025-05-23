package com.tencent.mobileqq.icgame.data.play.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class CleanGamePlayFreePlayRsp extends ExtendableMessageNano<CleanGamePlayFreePlayRsp> {
    private static volatile CleanGamePlayFreePlayRsp[] _emptyArray;

    public CleanGamePlayFreePlayRsp() {
        clear();
    }

    public static CleanGamePlayFreePlayRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CleanGamePlayFreePlayRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static CleanGamePlayFreePlayRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CleanGamePlayFreePlayRsp) MessageNano.mergeFrom(new CleanGamePlayFreePlayRsp(), bArr);
    }

    public CleanGamePlayFreePlayRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static CleanGamePlayFreePlayRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new CleanGamePlayFreePlayRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public CleanGamePlayFreePlayRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
