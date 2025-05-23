package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class GetAuthInfoReq extends ExtendableMessageNano<GetAuthInfoReq> {
    private static volatile GetAuthInfoReq[] _emptyArray;

    public GetAuthInfoReq() {
        clear();
    }

    public static GetAuthInfoReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetAuthInfoReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetAuthInfoReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetAuthInfoReq) MessageNano.mergeFrom(new GetAuthInfoReq(), bArr);
    }

    public GetAuthInfoReq clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static GetAuthInfoReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetAuthInfoReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetAuthInfoReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
