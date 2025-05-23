package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class SetLoveAnchorInfoRsp extends ExtendableMessageNano<SetLoveAnchorInfoRsp> {
    private static volatile SetLoveAnchorInfoRsp[] _emptyArray;

    public SetLoveAnchorInfoRsp() {
        clear();
    }

    public static SetLoveAnchorInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SetLoveAnchorInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SetLoveAnchorInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SetLoveAnchorInfoRsp) MessageNano.mergeFrom(new SetLoveAnchorInfoRsp(), bArr);
    }

    public SetLoveAnchorInfoRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static SetLoveAnchorInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SetLoveAnchorInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SetLoveAnchorInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
