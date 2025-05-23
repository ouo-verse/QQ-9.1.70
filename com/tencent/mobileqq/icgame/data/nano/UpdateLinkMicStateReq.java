package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class UpdateLinkMicStateReq extends ExtendableMessageNano<UpdateLinkMicStateReq> {
    private static volatile UpdateLinkMicStateReq[] _emptyArray;
    public LinkMicState state;

    public UpdateLinkMicStateReq() {
        clear();
    }

    public static UpdateLinkMicStateReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UpdateLinkMicStateReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static UpdateLinkMicStateReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (UpdateLinkMicStateReq) MessageNano.mergeFrom(new UpdateLinkMicStateReq(), bArr);
    }

    public UpdateLinkMicStateReq clear() {
        this.state = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        LinkMicState linkMicState = this.state;
        if (linkMicState != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, linkMicState);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        LinkMicState linkMicState = this.state;
        if (linkMicState != null) {
            codedOutputByteBufferNano.writeMessage(1, linkMicState);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static UpdateLinkMicStateReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new UpdateLinkMicStateReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public UpdateLinkMicStateReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 10) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.state == null) {
                    this.state = new LinkMicState();
                }
                codedInputByteBufferNano.readMessage(this.state);
            }
        }
    }
}
