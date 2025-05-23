package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class HeartBeatReq extends ExtendableMessageNano<HeartBeatReq> {
    private static volatile HeartBeatReq[] _emptyArray;

    public HeartBeatReq() {
        clear();
    }

    public static HeartBeatReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new HeartBeatReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static HeartBeatReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (HeartBeatReq) MessageNano.mergeFrom(new HeartBeatReq(), bArr);
    }

    public HeartBeatReq clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static HeartBeatReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new HeartBeatReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public HeartBeatReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
