package com.tencent.mobileqq.icgame.data.link.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class LinkMicCancelRsp extends ExtendableMessageNano<LinkMicCancelRsp> {
    private static volatile LinkMicCancelRsp[] _emptyArray;

    public LinkMicCancelRsp() {
        clear();
    }

    public static LinkMicCancelRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LinkMicCancelRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LinkMicCancelRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LinkMicCancelRsp) MessageNano.mergeFrom(new LinkMicCancelRsp(), bArr);
    }

    public LinkMicCancelRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static LinkMicCancelRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LinkMicCancelRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LinkMicCancelRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
