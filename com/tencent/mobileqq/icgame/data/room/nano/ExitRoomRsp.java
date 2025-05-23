package com.tencent.mobileqq.icgame.data.room.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class ExitRoomRsp extends ExtendableMessageNano<ExitRoomRsp> {
    private static volatile ExitRoomRsp[] _emptyArray;

    public ExitRoomRsp() {
        clear();
    }

    public static ExitRoomRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ExitRoomRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ExitRoomRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ExitRoomRsp) MessageNano.mergeFrom(new ExitRoomRsp(), bArr);
    }

    public ExitRoomRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static ExitRoomRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ExitRoomRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ExitRoomRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
