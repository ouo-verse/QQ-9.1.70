package com.tencent.mobileqq.icgame.data.lucky.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class SetAutoDrawRsp extends ExtendableMessageNano<SetAutoDrawRsp> {
    private static volatile SetAutoDrawRsp[] _emptyArray;

    public SetAutoDrawRsp() {
        clear();
    }

    public static SetAutoDrawRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SetAutoDrawRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SetAutoDrawRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SetAutoDrawRsp) MessageNano.mergeFrom(new SetAutoDrawRsp(), bArr);
    }

    public SetAutoDrawRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static SetAutoDrawRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SetAutoDrawRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SetAutoDrawRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
