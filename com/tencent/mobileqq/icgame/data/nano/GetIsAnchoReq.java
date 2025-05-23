package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class GetIsAnchoReq extends ExtendableMessageNano<GetIsAnchoReq> {
    private static volatile GetIsAnchoReq[] _emptyArray;

    public GetIsAnchoReq() {
        clear();
    }

    public static GetIsAnchoReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetIsAnchoReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetIsAnchoReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetIsAnchoReq) MessageNano.mergeFrom(new GetIsAnchoReq(), bArr);
    }

    public GetIsAnchoReq clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static GetIsAnchoReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetIsAnchoReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetIsAnchoReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
