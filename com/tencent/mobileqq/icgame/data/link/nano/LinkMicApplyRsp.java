package com.tencent.mobileqq.icgame.data.link.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class LinkMicApplyRsp extends ExtendableMessageNano<LinkMicApplyRsp> {
    private static volatile LinkMicApplyRsp[] _emptyArray;

    public LinkMicApplyRsp() {
        clear();
    }

    public static LinkMicApplyRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LinkMicApplyRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LinkMicApplyRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LinkMicApplyRsp) MessageNano.mergeFrom(new LinkMicApplyRsp(), bArr);
    }

    public LinkMicApplyRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static LinkMicApplyRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LinkMicApplyRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LinkMicApplyRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
