package com.tencent.mobileqq.icgame.data.ilive.feed.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class GetHotFeedsListReq extends ExtendableMessageNano<GetHotFeedsListReq> {
    private static volatile GetHotFeedsListReq[] _emptyArray;

    public GetHotFeedsListReq() {
        clear();
    }

    public static GetHotFeedsListReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetHotFeedsListReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetHotFeedsListReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetHotFeedsListReq) MessageNano.mergeFrom(new GetHotFeedsListReq(), bArr);
    }

    public GetHotFeedsListReq clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static GetHotFeedsListReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetHotFeedsListReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetHotFeedsListReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
