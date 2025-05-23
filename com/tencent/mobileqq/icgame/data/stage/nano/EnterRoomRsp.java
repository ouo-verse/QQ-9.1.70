package com.tencent.mobileqq.icgame.data.stage.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class EnterRoomRsp extends ExtendableMessageNano<EnterRoomRsp> {
    private static volatile EnterRoomRsp[] _emptyArray;

    public EnterRoomRsp() {
        clear();
    }

    public static EnterRoomRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new EnterRoomRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static EnterRoomRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (EnterRoomRsp) MessageNano.mergeFrom(new EnterRoomRsp(), bArr);
    }

    public EnterRoomRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static EnterRoomRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new EnterRoomRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public EnterRoomRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
