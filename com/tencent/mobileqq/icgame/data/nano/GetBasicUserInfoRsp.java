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
public final class GetBasicUserInfoRsp extends ExtendableMessageNano<GetBasicUserInfoRsp> {
    private static volatile GetBasicUserInfoRsp[] _emptyArray;
    public BasicUserInfo[] basicUserinfo;

    public GetBasicUserInfoRsp() {
        clear();
    }

    public static GetBasicUserInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetBasicUserInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetBasicUserInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetBasicUserInfoRsp) MessageNano.mergeFrom(new GetBasicUserInfoRsp(), bArr);
    }

    public GetBasicUserInfoRsp clear() {
        this.basicUserinfo = BasicUserInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        BasicUserInfo[] basicUserInfoArr = this.basicUserinfo;
        if (basicUserInfoArr != null && basicUserInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                BasicUserInfo[] basicUserInfoArr2 = this.basicUserinfo;
                if (i3 >= basicUserInfoArr2.length) {
                    break;
                }
                BasicUserInfo basicUserInfo = basicUserInfoArr2[i3];
                if (basicUserInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, basicUserInfo);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        BasicUserInfo[] basicUserInfoArr = this.basicUserinfo;
        if (basicUserInfoArr != null && basicUserInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                BasicUserInfo[] basicUserInfoArr2 = this.basicUserinfo;
                if (i3 >= basicUserInfoArr2.length) {
                    break;
                }
                BasicUserInfo basicUserInfo = basicUserInfoArr2[i3];
                if (basicUserInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, basicUserInfo);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetBasicUserInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetBasicUserInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetBasicUserInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                BasicUserInfo[] basicUserInfoArr = this.basicUserinfo;
                int length = basicUserInfoArr == null ? 0 : basicUserInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                BasicUserInfo[] basicUserInfoArr2 = new BasicUserInfo[i3];
                if (length != 0) {
                    System.arraycopy(basicUserInfoArr, 0, basicUserInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    BasicUserInfo basicUserInfo = new BasicUserInfo();
                    basicUserInfoArr2[length] = basicUserInfo;
                    codedInputByteBufferNano.readMessage(basicUserInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                BasicUserInfo basicUserInfo2 = new BasicUserInfo();
                basicUserInfoArr2[length] = basicUserInfo2;
                codedInputByteBufferNano.readMessage(basicUserInfo2);
                this.basicUserinfo = basicUserInfoArr2;
            }
        }
    }
}
