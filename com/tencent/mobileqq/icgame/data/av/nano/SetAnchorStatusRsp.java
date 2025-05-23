package com.tencent.mobileqq.icgame.data.av.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class SetAnchorStatusRsp extends ExtendableMessageNano<SetAnchorStatusRsp> {
    private static volatile SetAnchorStatusRsp[] _emptyArray;

    public SetAnchorStatusRsp() {
        clear();
    }

    public static SetAnchorStatusRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SetAnchorStatusRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SetAnchorStatusRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SetAnchorStatusRsp) MessageNano.mergeFrom(new SetAnchorStatusRsp(), bArr);
    }

    public SetAnchorStatusRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static SetAnchorStatusRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SetAnchorStatusRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SetAnchorStatusRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
