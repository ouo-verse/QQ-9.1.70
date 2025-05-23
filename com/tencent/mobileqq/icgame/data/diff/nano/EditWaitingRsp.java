package com.tencent.mobileqq.icgame.data.diff.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class EditWaitingRsp extends ExtendableMessageNano<EditWaitingRsp> {
    private static volatile EditWaitingRsp[] _emptyArray;
    public WaitingInfo waitingInfo;

    public EditWaitingRsp() {
        clear();
    }

    public static EditWaitingRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new EditWaitingRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static EditWaitingRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (EditWaitingRsp) MessageNano.mergeFrom(new EditWaitingRsp(), bArr);
    }

    public EditWaitingRsp clear() {
        this.waitingInfo = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        WaitingInfo waitingInfo = this.waitingInfo;
        if (waitingInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, waitingInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        WaitingInfo waitingInfo = this.waitingInfo;
        if (waitingInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, waitingInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static EditWaitingRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new EditWaitingRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public EditWaitingRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.waitingInfo == null) {
                    this.waitingInfo = new WaitingInfo();
                }
                codedInputByteBufferNano.readMessage(this.waitingInfo);
            }
        }
    }
}
