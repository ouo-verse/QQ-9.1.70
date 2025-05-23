package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class GetMaxRoomIdReq extends ExtendableMessageNano<GetMaxRoomIdReq> {
    private static volatile GetMaxRoomIdReq[] _emptyArray;

    public GetMaxRoomIdReq() {
        clear();
    }

    public static GetMaxRoomIdReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetMaxRoomIdReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetMaxRoomIdReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetMaxRoomIdReq) MessageNano.mergeFrom(new GetMaxRoomIdReq(), bArr);
    }

    public GetMaxRoomIdReq clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static GetMaxRoomIdReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetMaxRoomIdReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetMaxRoomIdReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
