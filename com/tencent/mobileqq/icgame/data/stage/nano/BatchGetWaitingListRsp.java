package com.tencent.mobileqq.icgame.data.stage.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class BatchGetWaitingListRsp extends ExtendableMessageNano<BatchGetWaitingListRsp> {
    private static volatile BatchGetWaitingListRsp[] _emptyArray;
    public WaitingListInfo[] waitingLists;

    public BatchGetWaitingListRsp() {
        clear();
    }

    public static BatchGetWaitingListRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new BatchGetWaitingListRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static BatchGetWaitingListRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (BatchGetWaitingListRsp) MessageNano.mergeFrom(new BatchGetWaitingListRsp(), bArr);
    }

    public BatchGetWaitingListRsp clear() {
        this.waitingLists = WaitingListInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        WaitingListInfo[] waitingListInfoArr = this.waitingLists;
        if (waitingListInfoArr != null && waitingListInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                WaitingListInfo[] waitingListInfoArr2 = this.waitingLists;
                if (i3 >= waitingListInfoArr2.length) {
                    break;
                }
                WaitingListInfo waitingListInfo = waitingListInfoArr2[i3];
                if (waitingListInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, waitingListInfo);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        WaitingListInfo[] waitingListInfoArr = this.waitingLists;
        if (waitingListInfoArr != null && waitingListInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                WaitingListInfo[] waitingListInfoArr2 = this.waitingLists;
                if (i3 >= waitingListInfoArr2.length) {
                    break;
                }
                WaitingListInfo waitingListInfo = waitingListInfoArr2[i3];
                if (waitingListInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, waitingListInfo);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static BatchGetWaitingListRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new BatchGetWaitingListRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public BatchGetWaitingListRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                WaitingListInfo[] waitingListInfoArr = this.waitingLists;
                int length = waitingListInfoArr == null ? 0 : waitingListInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                WaitingListInfo[] waitingListInfoArr2 = new WaitingListInfo[i3];
                if (length != 0) {
                    System.arraycopy(waitingListInfoArr, 0, waitingListInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    WaitingListInfo waitingListInfo = new WaitingListInfo();
                    waitingListInfoArr2[length] = waitingListInfo;
                    codedInputByteBufferNano.readMessage(waitingListInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                WaitingListInfo waitingListInfo2 = new WaitingListInfo();
                waitingListInfoArr2[length] = waitingListInfo2;
                codedInputByteBufferNano.readMessage(waitingListInfo2);
                this.waitingLists = waitingListInfoArr2;
            }
        }
    }
}
