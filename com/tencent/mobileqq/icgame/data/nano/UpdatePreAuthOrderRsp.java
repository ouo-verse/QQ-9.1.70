package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class UpdatePreAuthOrderRsp extends ExtendableMessageNano<UpdatePreAuthOrderRsp> {
    private static volatile UpdatePreAuthOrderRsp[] _emptyArray;

    public UpdatePreAuthOrderRsp() {
        clear();
    }

    public static UpdatePreAuthOrderRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UpdatePreAuthOrderRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static UpdatePreAuthOrderRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (UpdatePreAuthOrderRsp) MessageNano.mergeFrom(new UpdatePreAuthOrderRsp(), bArr);
    }

    public UpdatePreAuthOrderRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static UpdatePreAuthOrderRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new UpdatePreAuthOrderRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public UpdatePreAuthOrderRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
