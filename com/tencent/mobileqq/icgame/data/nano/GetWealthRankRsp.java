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
public final class GetWealthRankRsp extends ExtendableMessageNano<GetWealthRankRsp> {
    private static volatile GetWealthRankRsp[] _emptyArray;
    public UserWealth[] userWealths;

    public GetWealthRankRsp() {
        clear();
    }

    public static GetWealthRankRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetWealthRankRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetWealthRankRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetWealthRankRsp) MessageNano.mergeFrom(new GetWealthRankRsp(), bArr);
    }

    public GetWealthRankRsp clear() {
        this.userWealths = UserWealth.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        UserWealth[] userWealthArr = this.userWealths;
        if (userWealthArr != null && userWealthArr.length > 0) {
            int i3 = 0;
            while (true) {
                UserWealth[] userWealthArr2 = this.userWealths;
                if (i3 >= userWealthArr2.length) {
                    break;
                }
                UserWealth userWealth = userWealthArr2[i3];
                if (userWealth != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userWealth);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        UserWealth[] userWealthArr = this.userWealths;
        if (userWealthArr != null && userWealthArr.length > 0) {
            int i3 = 0;
            while (true) {
                UserWealth[] userWealthArr2 = this.userWealths;
                if (i3 >= userWealthArr2.length) {
                    break;
                }
                UserWealth userWealth = userWealthArr2[i3];
                if (userWealth != null) {
                    codedOutputByteBufferNano.writeMessage(1, userWealth);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetWealthRankRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetWealthRankRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetWealthRankRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                UserWealth[] userWealthArr = this.userWealths;
                int length = userWealthArr == null ? 0 : userWealthArr.length;
                int i3 = repeatedFieldArrayLength + length;
                UserWealth[] userWealthArr2 = new UserWealth[i3];
                if (length != 0) {
                    System.arraycopy(userWealthArr, 0, userWealthArr2, 0, length);
                }
                while (length < i3 - 1) {
                    UserWealth userWealth = new UserWealth();
                    userWealthArr2[length] = userWealth;
                    codedInputByteBufferNano.readMessage(userWealth);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                UserWealth userWealth2 = new UserWealth();
                userWealthArr2[length] = userWealth2;
                codedInputByteBufferNano.readMessage(userWealth2);
                this.userWealths = userWealthArr2;
            }
        }
    }
}
