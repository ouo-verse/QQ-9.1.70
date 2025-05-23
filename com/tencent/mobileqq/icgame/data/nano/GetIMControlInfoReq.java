package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class GetIMControlInfoReq extends ExtendableMessageNano<GetIMControlInfoReq> {
    private static volatile GetIMControlInfoReq[] _emptyArray;

    public GetIMControlInfoReq() {
        clear();
    }

    public static GetIMControlInfoReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetIMControlInfoReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetIMControlInfoReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetIMControlInfoReq) MessageNano.mergeFrom(new GetIMControlInfoReq(), bArr);
    }

    public GetIMControlInfoReq clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static GetIMControlInfoReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetIMControlInfoReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetIMControlInfoReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
