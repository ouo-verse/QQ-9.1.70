package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class GetStickerListReq extends ExtendableMessageNano<GetStickerListReq> {
    private static volatile GetStickerListReq[] _emptyArray;

    public GetStickerListReq() {
        clear();
    }

    public static GetStickerListReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetStickerListReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetStickerListReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetStickerListReq) MessageNano.mergeFrom(new GetStickerListReq(), bArr);
    }

    public GetStickerListReq clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static GetStickerListReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetStickerListReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetStickerListReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
