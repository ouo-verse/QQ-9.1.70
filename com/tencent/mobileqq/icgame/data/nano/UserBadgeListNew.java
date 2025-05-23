package com.tencent.mobileqq.icgame.data.nano;

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
public final class UserBadgeListNew extends ExtendableMessageNano<UserBadgeListNew> {
    private static volatile UserBadgeListNew[] _emptyArray;
    public UserBadgeInfo[] infos;

    public UserBadgeListNew() {
        clear();
    }

    public static UserBadgeListNew[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UserBadgeListNew[0];
                }
            }
        }
        return _emptyArray;
    }

    public static UserBadgeListNew parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (UserBadgeListNew) MessageNano.mergeFrom(new UserBadgeListNew(), bArr);
    }

    public UserBadgeListNew clear() {
        this.infos = UserBadgeInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        UserBadgeInfo[] userBadgeInfoArr = this.infos;
        if (userBadgeInfoArr != null && userBadgeInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                UserBadgeInfo[] userBadgeInfoArr2 = this.infos;
                if (i3 >= userBadgeInfoArr2.length) {
                    break;
                }
                UserBadgeInfo userBadgeInfo = userBadgeInfoArr2[i3];
                if (userBadgeInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userBadgeInfo);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        UserBadgeInfo[] userBadgeInfoArr = this.infos;
        if (userBadgeInfoArr != null && userBadgeInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                UserBadgeInfo[] userBadgeInfoArr2 = this.infos;
                if (i3 >= userBadgeInfoArr2.length) {
                    break;
                }
                UserBadgeInfo userBadgeInfo = userBadgeInfoArr2[i3];
                if (userBadgeInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, userBadgeInfo);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static UserBadgeListNew parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new UserBadgeListNew().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public UserBadgeListNew mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                UserBadgeInfo[] userBadgeInfoArr = this.infos;
                int length = userBadgeInfoArr == null ? 0 : userBadgeInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                UserBadgeInfo[] userBadgeInfoArr2 = new UserBadgeInfo[i3];
                if (length != 0) {
                    System.arraycopy(userBadgeInfoArr, 0, userBadgeInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    UserBadgeInfo userBadgeInfo = new UserBadgeInfo();
                    userBadgeInfoArr2[length] = userBadgeInfo;
                    codedInputByteBufferNano.readMessage(userBadgeInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                UserBadgeInfo userBadgeInfo2 = new UserBadgeInfo();
                userBadgeInfoArr2[length] = userBadgeInfo2;
                codedInputByteBufferNano.readMessage(userBadgeInfo2);
                this.infos = userBadgeInfoArr2;
            }
        }
    }
}
