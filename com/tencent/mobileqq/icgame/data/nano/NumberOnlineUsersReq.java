package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class NumberOnlineUsersReq extends ExtendableMessageNano<NumberOnlineUsersReq> {
    private static volatile NumberOnlineUsersReq[] _emptyArray;

    public NumberOnlineUsersReq() {
        clear();
    }

    public static NumberOnlineUsersReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new NumberOnlineUsersReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static NumberOnlineUsersReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (NumberOnlineUsersReq) MessageNano.mergeFrom(new NumberOnlineUsersReq(), bArr);
    }

    public NumberOnlineUsersReq clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static NumberOnlineUsersReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new NumberOnlineUsersReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public NumberOnlineUsersReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
