package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class GetRcmdInfoReq extends ExtendableMessageNano<GetRcmdInfoReq> {
    private static volatile GetRcmdInfoReq[] _emptyArray;

    public GetRcmdInfoReq() {
        clear();
    }

    public static GetRcmdInfoReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetRcmdInfoReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetRcmdInfoReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetRcmdInfoReq) MessageNano.mergeFrom(new GetRcmdInfoReq(), bArr);
    }

    public GetRcmdInfoReq clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static GetRcmdInfoReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetRcmdInfoReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetRcmdInfoReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
