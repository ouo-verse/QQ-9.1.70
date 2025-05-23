package com.tencent.mobileqq.icgame.data.ilive.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class LinkMicForbiddenCgiRsp extends ExtendableMessageNano<LinkMicForbiddenCgiRsp> {
    private static volatile LinkMicForbiddenCgiRsp[] _emptyArray;
    public LinkMicForbiddenRsp result;
    public int retcode;

    public LinkMicForbiddenCgiRsp() {
        clear();
    }

    public static LinkMicForbiddenCgiRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LinkMicForbiddenCgiRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LinkMicForbiddenCgiRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LinkMicForbiddenCgiRsp) MessageNano.mergeFrom(new LinkMicForbiddenCgiRsp(), bArr);
    }

    public LinkMicForbiddenCgiRsp clear() {
        this.retcode = 0;
        this.result = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.retcode;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        LinkMicForbiddenRsp linkMicForbiddenRsp = this.result;
        if (linkMicForbiddenRsp != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, linkMicForbiddenRsp);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.retcode;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        LinkMicForbiddenRsp linkMicForbiddenRsp = this.result;
        if (linkMicForbiddenRsp != null) {
            codedOutputByteBufferNano.writeMessage(2, linkMicForbiddenRsp);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LinkMicForbiddenCgiRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LinkMicForbiddenCgiRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LinkMicForbiddenCgiRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.retcode = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.result == null) {
                    this.result = new LinkMicForbiddenRsp();
                }
                codedInputByteBufferNano.readMessage(this.result);
            }
        }
    }
}
