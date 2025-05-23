package com.tencent.mobileqq.icgame.data.stage.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class RestoreAvRightRsp extends ExtendableMessageNano<RestoreAvRightRsp> {
    private static volatile RestoreAvRightRsp[] _emptyArray;

    public RestoreAvRightRsp() {
        clear();
    }

    public static RestoreAvRightRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new RestoreAvRightRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static RestoreAvRightRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (RestoreAvRightRsp) MessageNano.mergeFrom(new RestoreAvRightRsp(), bArr);
    }

    public RestoreAvRightRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static RestoreAvRightRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new RestoreAvRightRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public RestoreAvRightRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
