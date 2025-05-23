package com.tencent.mobileqq.icgame.data.mgr.nano;

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
public final class WaitingListInfo extends ExtendableMessageNano<WaitingListInfo> {
    private static volatile WaitingListInfo[] _emptyArray;
    public CommonListInfo[] waitingLists;

    public WaitingListInfo() {
        clear();
    }

    public static WaitingListInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new WaitingListInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static WaitingListInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (WaitingListInfo) MessageNano.mergeFrom(new WaitingListInfo(), bArr);
    }

    public WaitingListInfo clear() {
        this.waitingLists = CommonListInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        CommonListInfo[] commonListInfoArr = this.waitingLists;
        if (commonListInfoArr != null && commonListInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                CommonListInfo[] commonListInfoArr2 = this.waitingLists;
                if (i3 >= commonListInfoArr2.length) {
                    break;
                }
                CommonListInfo commonListInfo = commonListInfoArr2[i3];
                if (commonListInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, commonListInfo);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        CommonListInfo[] commonListInfoArr = this.waitingLists;
        if (commonListInfoArr != null && commonListInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                CommonListInfo[] commonListInfoArr2 = this.waitingLists;
                if (i3 >= commonListInfoArr2.length) {
                    break;
                }
                CommonListInfo commonListInfo = commonListInfoArr2[i3];
                if (commonListInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, commonListInfo);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static WaitingListInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new WaitingListInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public WaitingListInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                CommonListInfo[] commonListInfoArr = this.waitingLists;
                int length = commonListInfoArr == null ? 0 : commonListInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                CommonListInfo[] commonListInfoArr2 = new CommonListInfo[i3];
                if (length != 0) {
                    System.arraycopy(commonListInfoArr, 0, commonListInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    CommonListInfo commonListInfo = new CommonListInfo();
                    commonListInfoArr2[length] = commonListInfo;
                    codedInputByteBufferNano.readMessage(commonListInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                CommonListInfo commonListInfo2 = new CommonListInfo();
                commonListInfoArr2[length] = commonListInfo2;
                codedInputByteBufferNano.readMessage(commonListInfo2);
                this.waitingLists = commonListInfoArr2;
            }
        }
    }
}
