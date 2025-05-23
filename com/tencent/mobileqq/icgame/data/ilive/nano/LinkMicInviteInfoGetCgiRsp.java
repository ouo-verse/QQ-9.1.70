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
public final class LinkMicInviteInfoGetCgiRsp extends ExtendableMessageNano<LinkMicInviteInfoGetCgiRsp> {
    private static volatile LinkMicInviteInfoGetCgiRsp[] _emptyArray;
    public LinkMicInviteInfoGetRsp result;
    public int retcode;

    public LinkMicInviteInfoGetCgiRsp() {
        clear();
    }

    public static LinkMicInviteInfoGetCgiRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LinkMicInviteInfoGetCgiRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LinkMicInviteInfoGetCgiRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LinkMicInviteInfoGetCgiRsp) MessageNano.mergeFrom(new LinkMicInviteInfoGetCgiRsp(), bArr);
    }

    public LinkMicInviteInfoGetCgiRsp clear() {
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
        LinkMicInviteInfoGetRsp linkMicInviteInfoGetRsp = this.result;
        if (linkMicInviteInfoGetRsp != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, linkMicInviteInfoGetRsp);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.retcode;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        LinkMicInviteInfoGetRsp linkMicInviteInfoGetRsp = this.result;
        if (linkMicInviteInfoGetRsp != null) {
            codedOutputByteBufferNano.writeMessage(2, linkMicInviteInfoGetRsp);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LinkMicInviteInfoGetCgiRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LinkMicInviteInfoGetCgiRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LinkMicInviteInfoGetCgiRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                    this.result = new LinkMicInviteInfoGetRsp();
                }
                codedInputByteBufferNano.readMessage(this.result);
            }
        }
    }
}
