package com.tencent.mobileqq.icgame.data.av.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class AvRoomStatusChgRsp extends ExtendableMessageNano<AvRoomStatusChgRsp> {
    private static volatile AvRoomStatusChgRsp[] _emptyArray;

    public AvRoomStatusChgRsp() {
        clear();
    }

    public static AvRoomStatusChgRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AvRoomStatusChgRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AvRoomStatusChgRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AvRoomStatusChgRsp) MessageNano.mergeFrom(new AvRoomStatusChgRsp(), bArr);
    }

    public AvRoomStatusChgRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static AvRoomStatusChgRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AvRoomStatusChgRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AvRoomStatusChgRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
