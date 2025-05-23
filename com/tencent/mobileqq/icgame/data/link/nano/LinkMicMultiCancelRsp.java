package com.tencent.mobileqq.icgame.data.link.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class LinkMicMultiCancelRsp extends ExtendableMessageNano<LinkMicMultiCancelRsp> {
    private static volatile LinkMicMultiCancelRsp[] _emptyArray;

    public LinkMicMultiCancelRsp() {
        clear();
    }

    public static LinkMicMultiCancelRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LinkMicMultiCancelRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LinkMicMultiCancelRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LinkMicMultiCancelRsp) MessageNano.mergeFrom(new LinkMicMultiCancelRsp(), bArr);
    }

    public LinkMicMultiCancelRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static LinkMicMultiCancelRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LinkMicMultiCancelRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LinkMicMultiCancelRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
