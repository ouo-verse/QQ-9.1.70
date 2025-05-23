package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class UpdateLinkMicStateRsp extends ExtendableMessageNano<UpdateLinkMicStateRsp> {
    private static volatile UpdateLinkMicStateRsp[] _emptyArray;

    public UpdateLinkMicStateRsp() {
        clear();
    }

    public static UpdateLinkMicStateRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UpdateLinkMicStateRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static UpdateLinkMicStateRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (UpdateLinkMicStateRsp) MessageNano.mergeFrom(new UpdateLinkMicStateRsp(), bArr);
    }

    public UpdateLinkMicStateRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static UpdateLinkMicStateRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new UpdateLinkMicStateRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public UpdateLinkMicStateRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
