package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class SettleTaskRsp extends ExtendableMessageNano<SettleTaskRsp> {
    private static volatile SettleTaskRsp[] _emptyArray;

    public SettleTaskRsp() {
        clear();
    }

    public static SettleTaskRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SettleTaskRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SettleTaskRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SettleTaskRsp) MessageNano.mergeFrom(new SettleTaskRsp(), bArr);
    }

    public SettleTaskRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static SettleTaskRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SettleTaskRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SettleTaskRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
