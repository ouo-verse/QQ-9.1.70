package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class GetPushConfigReq extends ExtendableMessageNano<GetPushConfigReq> {
    private static volatile GetPushConfigReq[] _emptyArray;

    public GetPushConfigReq() {
        clear();
    }

    public static GetPushConfigReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetPushConfigReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetPushConfigReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetPushConfigReq) MessageNano.mergeFrom(new GetPushConfigReq(), bArr);
    }

    public GetPushConfigReq clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static GetPushConfigReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetPushConfigReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetPushConfigReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
