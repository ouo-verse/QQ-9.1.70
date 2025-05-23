package com.tencent.mobileqq.icgame.data.stage.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class WaitingListOffRsp extends ExtendableMessageNano<WaitingListOffRsp> {
    private static volatile WaitingListOffRsp[] _emptyArray;
    public WaitingListInfo waitingList;

    public WaitingListOffRsp() {
        clear();
    }

    public static WaitingListOffRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new WaitingListOffRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static WaitingListOffRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (WaitingListOffRsp) MessageNano.mergeFrom(new WaitingListOffRsp(), bArr);
    }

    public WaitingListOffRsp clear() {
        this.waitingList = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        WaitingListInfo waitingListInfo = this.waitingList;
        if (waitingListInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, waitingListInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        WaitingListInfo waitingListInfo = this.waitingList;
        if (waitingListInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, waitingListInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static WaitingListOffRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new WaitingListOffRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public WaitingListOffRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.waitingList == null) {
                    this.waitingList = new WaitingListInfo();
                }
                codedInputByteBufferNano.readMessage(this.waitingList);
            }
        }
    }
}
