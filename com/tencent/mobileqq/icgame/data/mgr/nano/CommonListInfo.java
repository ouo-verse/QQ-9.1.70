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
public final class CommonListInfo extends ExtendableMessageNano<CommonListInfo> {
    private static volatile CommonListInfo[] _emptyArray;
    public int listId;
    public WaitingUser[] waitingUsers;

    public CommonListInfo() {
        clear();
    }

    public static CommonListInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CommonListInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static CommonListInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CommonListInfo) MessageNano.mergeFrom(new CommonListInfo(), bArr);
    }

    public CommonListInfo clear() {
        this.listId = 0;
        this.waitingUsers = WaitingUser.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.listId);
        WaitingUser[] waitingUserArr = this.waitingUsers;
        if (waitingUserArr != null && waitingUserArr.length > 0) {
            int i3 = 0;
            while (true) {
                WaitingUser[] waitingUserArr2 = this.waitingUsers;
                if (i3 >= waitingUserArr2.length) {
                    break;
                }
                WaitingUser waitingUser = waitingUserArr2[i3];
                if (waitingUser != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, waitingUser);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.listId);
        WaitingUser[] waitingUserArr = this.waitingUsers;
        if (waitingUserArr != null && waitingUserArr.length > 0) {
            int i3 = 0;
            while (true) {
                WaitingUser[] waitingUserArr2 = this.waitingUsers;
                if (i3 >= waitingUserArr2.length) {
                    break;
                }
                WaitingUser waitingUser = waitingUserArr2[i3];
                if (waitingUser != null) {
                    codedOutputByteBufferNano.writeMessage(2, waitingUser);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static CommonListInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new CommonListInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public CommonListInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.listId = codedInputByteBufferNano.readUInt32();
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
