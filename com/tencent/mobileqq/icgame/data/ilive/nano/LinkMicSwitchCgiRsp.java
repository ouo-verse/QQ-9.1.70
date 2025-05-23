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
public final class LinkMicSwitchCgiRsp extends ExtendableMessageNano<LinkMicSwitchCgiRsp> {
    private static volatile LinkMicSwitchCgiRsp[] _emptyArray;
    public LinkMicSwitchRsp result;
    public int retcode;

    public LinkMicSwitchCgiRsp() {
        clear();
    }

    public static LinkMicSwitchCgiRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LinkMicSwitchCgiRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LinkMicSwitchCgiRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LinkMicSwitchCgiRsp) MessageNano.mergeFrom(new LinkMicSwitchCgiRsp(), bArr);
    }

    public LinkMicSwitchCgiRsp clear() {
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
        LinkMicSwitchRsp linkMicSwitchRsp = this.result;
        if (linkMicSwitchRsp != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, linkMicSwitchRsp);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.retcode;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        LinkMicSwitchRsp linkMicSwitchRsp = this.result;
        if (linkMicSwitchRsp != null) {
            codedOutputByteBufferNano.writeMessage(2, linkMicSwitchRsp);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LinkMicSwitchCgiRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LinkMicSwitchCgiRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LinkMicSwitchCgiRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                    this.result = new LinkMicSwitchRsp();
                }
                codedInputByteBufferNano.readMessage(this.result);
            }
        }
    }
}
