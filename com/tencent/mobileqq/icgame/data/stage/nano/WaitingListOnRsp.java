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
public final class WaitingListOnRsp extends ExtendableMessageNano<WaitingListOnRsp> {
    private static volatile WaitingListOnRsp[] _emptyArray;
    public WaitingListInfo waitingList;

    public WaitingListOnRsp() {
        clear();
    }

    public static WaitingListOnRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new WaitingListOnRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static WaitingListOnRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (WaitingListOnRsp) MessageNano.mergeFrom(new WaitingListOnRsp(), bArr);
    }

    public WaitingListOnRsp clear() {
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

    public static WaitingListOnRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new WaitingListOnRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public WaitingListOnRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
