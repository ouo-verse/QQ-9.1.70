package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class GetAnchorLoveRoomListReq extends ExtendableMessageNano<GetAnchorLoveRoomListReq> {
    private static volatile GetAnchorLoveRoomListReq[] _emptyArray;

    public GetAnchorLoveRoomListReq() {
        clear();
    }

    public static GetAnchorLoveRoomListReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetAnchorLoveRoomListReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetAnchorLoveRoomListReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetAnchorLoveRoomListReq) MessageNano.mergeFrom(new GetAnchorLoveRoomListReq(), bArr);
    }

    public GetAnchorLoveRoomListReq clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static GetAnchorLoveRoomListReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetAnchorLoveRoomListReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetAnchorLoveRoomListReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
