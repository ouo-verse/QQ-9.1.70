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
public final class WaitingListInfo extends ExtendableMessageNano<WaitingListInfo> {
    private static volatile WaitingListInfo[] _emptyArray;
    public long roomId;
    public long seq;
    public WaitingInfo[] waitingInfos;

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
        this.waitingInfos = WaitingInfo.emptyArray();
        this.roomId = 0L;
        this.seq = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        WaitingInfo[] waitingInfoArr = this.waitingInfos;
        if (waitingInfoArr != null && waitingInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                WaitingInfo[] waitingInfoArr2 = this.waitingInfos;
                if (i3 >= waitingInfoArr2.length) {
                    break;
                }
                WaitingInfo waitingInfo = waitingInfoArr2[i3];
                if (waitingInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, waitingInfo);
                }
                i3++;
            }
        }
        long j3 = this.roomId;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        long j16 = this.seq;
        if (j16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        WaitingInfo[] waitingInfoArr = this.waitingInfos;
        if (waitingInfoArr != null && waitingInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                WaitingInfo[] waitingInfoArr2 = this.waitingInfos;
                if (i3 >= waitingInfoArr2.length) {
                    break;
                }
                WaitingInfo waitingInfo = waitingInfoArr2[i3];
                if (waitingInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, waitingInfo);
                }
                i3++;
            }
        }
        long j3 = this.roomId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        long j16 = this.seq;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
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
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                WaitingInfo[] waitingInfoArr = this.waitingInfos;
                int length = waitingInfoArr == null ? 0 : waitingInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                WaitingInfo[] waitingInfoArr2 = new WaitingInfo[i3];
                if (length != 0) {
                    System.arraycopy(waitingInfoArr, 0, waitingInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    WaitingInfo waitingInfo = new WaitingInfo();
                    waitingInfoArr2[length] = waitingInfo;
                    codedInputByteBufferNano.readMessage(waitingInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                WaitingInfo waitingInfo2 = new WaitingInfo();
                waitingInfoArr2[length] = waitingInfo2;
                codedInputByteBufferNano.readMessage(waitingInfo2);
                this.waitingInfos = waitingInfoArr2;
            } else if (readTag == 16) {
                this.roomId = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.seq = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
