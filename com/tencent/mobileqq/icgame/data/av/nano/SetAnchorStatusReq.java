package com.tencent.mobileqq.icgame.data.av.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class SetAnchorStatusReq extends ExtendableMessageNano<SetAnchorStatusReq> {
    private static volatile SetAnchorStatusReq[] _emptyArray;
    public AnchorStatus status;

    public SetAnchorStatusReq() {
        clear();
    }

    public static SetAnchorStatusReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SetAnchorStatusReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SetAnchorStatusReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SetAnchorStatusReq) MessageNano.mergeFrom(new SetAnchorStatusReq(), bArr);
    }

    public SetAnchorStatusReq clear() {
        this.status = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        AnchorStatus anchorStatus = this.status;
        if (anchorStatus != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, anchorStatus);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        AnchorStatus anchorStatus = this.status;
        if (anchorStatus != null) {
            codedOutputByteBufferNano.writeMessage(1, anchorStatus);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SetAnchorStatusReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SetAnchorStatusReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SetAnchorStatusReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.status == null) {
                    this.status = new AnchorStatus();
                }
                codedInputByteBufferNano.readMessage(this.status);
            }
        }
    }
}
