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
public final class BatchGetUserIdentityInfoRsp extends ExtendableMessageNano<BatchGetUserIdentityInfoRsp> {
    private static volatile BatchGetUserIdentityInfoRsp[] _emptyArray;
    public UserIdentityInfo[] userIdentityInfoList;

    public BatchGetUserIdentityInfoRsp() {
        clear();
    }

    public static BatchGetUserIdentityInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new BatchGetUserIdentityInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static BatchGetUserIdentityInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (BatchGetUserIdentityInfoRsp) MessageNano.mergeFrom(new BatchGetUserIdentityInfoRsp(), bArr);
    }

    public BatchGetUserIdentityInfoRsp clear() {
        this.userIdentityInfoList = UserIdentityInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        UserIdentityInfo[] userIdentityInfoArr = this.userIdentityInfoList;
        if (userIdentityInfoArr != null && userIdentityInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                UserIdentityInfo[] userIdentityInfoArr2 = this.userIdentityInfoList;
                if (i3 >= userIdentityInfoArr2.length) {
                    break;
                }
                UserIdentityInfo userIdentityInfo = userIdentityInfoArr2[i3];
                if (userIdentityInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userIdentityInfo);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        UserIdentityInfo[] userIdentityInfoArr = this.userIdentityInfoList;
        if (userIdentityInfoArr != null && userIdentityInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                UserIdentityInfo[] userIdentityInfoArr2 = this.userIdentityInfoList;
                if (i3 >= userIdentityInfoArr2.length) {
                    break;
                }
                UserIdentityInfo userIdentityInfo = userIdentityInfoArr2[i3];
                if (userIdentityInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, userIdentityInfo);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static BatchGetUserIdentityInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new BatchGetUserIdentityInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public BatchGetUserIdentityInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                UserIdentityInfo[] userIdentityInfoArr = this.userIdentityInfoList;
                int length = userIdentityInfoArr == null ? 0 : userIdentityInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                UserIdentityInfo[] userIdentityInfoArr2 = new UserIdentityInfo[i3];
                if (length != 0) {
                    System.arraycopy(userIdentityInfoArr, 0, userIdentityInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    UserIdentityInfo userIdentityInfo = new UserIdentityInfo();
                    userIdentityInfoArr2[length] = userIdentityInfo;
                    codedInputByteBufferNano.readMessage(userIdentityInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                UserIdentityInfo userIdentityInfo2 = new UserIdentityInfo();
                userIdentityInfoArr2[length] = userIdentityInfo2;
                codedInputByteBufferNano.readMessage(userIdentityInfo2);
                this.userIdentityInfoList = userIdentityInfoArr2;
            }
        }
    }
}
