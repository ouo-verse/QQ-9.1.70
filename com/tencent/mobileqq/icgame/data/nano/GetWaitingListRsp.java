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
public final class GetWaitingListRsp extends ExtendableMessageNano<GetWaitingListRsp> {
    private static volatile GetWaitingListRsp[] _emptyArray;
    public WaitingInfo waitingInfo;

    public GetWaitingListRsp() {
        clear();
    }

    public static GetWaitingListRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetWaitingListRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetWaitingListRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetWaitingListRsp) MessageNano.mergeFrom(new GetWaitingListRsp(), bArr);
    }

    public GetWaitingListRsp clear() {
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

    public static GetWaitingListRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetWaitingListRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetWaitingListRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
