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
public final class WaitingListEditRsp extends ExtendableMessageNano<WaitingListEditRsp> {
    private static volatile WaitingListEditRsp[] _emptyArray;
    public WaitingListInfo waitingList;

    public WaitingListEditRsp() {
        clear();
    }

    public static WaitingListEditRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new WaitingListEditRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static WaitingListEditRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (WaitingListEditRsp) MessageNano.mergeFrom(new WaitingListEditRsp(), bArr);
    }

    public WaitingListEditRsp clear() {
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

    public static WaitingListEditRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new WaitingListEditRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public WaitingListEditRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
