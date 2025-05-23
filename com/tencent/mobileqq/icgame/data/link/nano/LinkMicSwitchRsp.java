package com.tencent.mobileqq.icgame.data.link.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class LinkMicSwitchRsp extends ExtendableMessageNano<LinkMicSwitchRsp> {
    private static volatile LinkMicSwitchRsp[] _emptyArray;

    public LinkMicSwitchRsp() {
        clear();
    }

    public static LinkMicSwitchRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LinkMicSwitchRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LinkMicSwitchRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LinkMicSwitchRsp) MessageNano.mergeFrom(new LinkMicSwitchRsp(), bArr);
    }

    public LinkMicSwitchRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static LinkMicSwitchRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LinkMicSwitchRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LinkMicSwitchRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
