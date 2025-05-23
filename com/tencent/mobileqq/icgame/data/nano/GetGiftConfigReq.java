package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class GetGiftConfigReq extends ExtendableMessageNano<GetGiftConfigReq> {
    private static volatile GetGiftConfigReq[] _emptyArray;

    public GetGiftConfigReq() {
        clear();
    }

    public static GetGiftConfigReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetGiftConfigReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetGiftConfigReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetGiftConfigReq) MessageNano.mergeFrom(new GetGiftConfigReq(), bArr);
    }

    public GetGiftConfigReq clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static GetGiftConfigReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetGiftConfigReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetGiftConfigReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
