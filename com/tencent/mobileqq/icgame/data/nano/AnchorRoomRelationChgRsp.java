package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class AnchorRoomRelationChgRsp extends ExtendableMessageNano<AnchorRoomRelationChgRsp> {
    private static volatile AnchorRoomRelationChgRsp[] _emptyArray;

    public AnchorRoomRelationChgRsp() {
        clear();
    }

    public static AnchorRoomRelationChgRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AnchorRoomRelationChgRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AnchorRoomRelationChgRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AnchorRoomRelationChgRsp) MessageNano.mergeFrom(new AnchorRoomRelationChgRsp(), bArr);
    }

    public AnchorRoomRelationChgRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static AnchorRoomRelationChgRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AnchorRoomRelationChgRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AnchorRoomRelationChgRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
