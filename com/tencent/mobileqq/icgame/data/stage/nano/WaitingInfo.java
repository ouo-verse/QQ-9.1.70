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
public final class WaitingInfo extends ExtendableMessageNano<WaitingInfo> {
    private static volatile WaitingInfo[] _emptyArray;
    public int seatType;
    public WaitingUser[] waitingUsers;

    public WaitingInfo() {
        clear();
    }

    public static WaitingInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new WaitingInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static WaitingInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (WaitingInfo) MessageNano.mergeFrom(new WaitingInfo(), bArr);
    }

    public WaitingInfo clear() {
        this.seatType = 0;
        this.waitingUsers = WaitingUser.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.seatType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        WaitingUser[] waitingUserArr = this.waitingUsers;
        if (waitingUserArr != null && waitingUserArr.length > 0) {
            int i16 = 0;
            while (true) {
                WaitingUser[] waitingUserArr2 = this.waitingUsers;
                if (i16 >= waitingUserArr2.length) {
                    break;
                }
                WaitingUser waitingUser = waitingUserArr2[i16];
                if (waitingUser != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, waitingUser);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.seatType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        WaitingUser[] waitingUserArr = this.waitingUsers;
        if (waitingUserArr != null && waitingUserArr.length > 0) {
            int i16 = 0;
            while (true) {
                WaitingUser[] waitingUserArr2 = this.waitingUsers;
                if (i16 >= waitingUserArr2.length) {
                    break;
                }
                WaitingUser waitingUser = waitingUserArr2[i16];
                if (waitingUser != null) {
                    codedOutputByteBufferNano.writeMessage(2, waitingUser);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static WaitingInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new WaitingInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public WaitingInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.seatType = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                WaitingUser[] waitingUserArr = this.waitingUsers;
                int length = waitingUserArr == null ? 0 : waitingUserArr.length;
                int i3 = repeatedFieldArrayLength + length;
                WaitingUser[] waitingUserArr2 = new WaitingUser[i3];
                if (length != 0) {
                    System.arraycopy(waitingUserArr, 0, waitingUserArr2, 0, length);
                }
                while (length < i3 - 1) {
                    WaitingUser waitingUser = new WaitingUser();
                    waitingUserArr2[length] = waitingUser;
                    codedInputByteBufferNano.readMessage(waitingUser);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                WaitingUser waitingUser2 = new WaitingUser();
                waitingUserArr2[length] = waitingUser2;
                codedInputByteBufferNano.readMessage(waitingUser2);
                this.waitingUsers = waitingUserArr2;
            }
        }
    }
}
