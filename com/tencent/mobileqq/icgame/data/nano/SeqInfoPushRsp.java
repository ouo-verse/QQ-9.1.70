package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class SeqInfoPushRsp extends ExtendableMessageNano<SeqInfoPushRsp> {
    private static volatile SeqInfoPushRsp[] _emptyArray;

    public SeqInfoPushRsp() {
        clear();
    }

    public static SeqInfoPushRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SeqInfoPushRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SeqInfoPushRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SeqInfoPushRsp) MessageNano.mergeFrom(new SeqInfoPushRsp(), bArr);
    }

    public SeqInfoPushRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static SeqInfoPushRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SeqInfoPushRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SeqInfoPushRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
