package com.tencent.mobileqq.icgame.data.punish.nano;

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
public final class GetUserForbidInfoRsp extends ExtendableMessageNano<GetUserForbidInfoRsp> {
    private static volatile GetUserForbidInfoRsp[] _emptyArray;
    public ForbidInfo[] forbidInfoList;

    public GetUserForbidInfoRsp() {
        clear();
    }

    public static GetUserForbidInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetUserForbidInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetUserForbidInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetUserForbidInfoRsp) MessageNano.mergeFrom(new GetUserForbidInfoRsp(), bArr);
    }

    public GetUserForbidInfoRsp clear() {
        this.forbidInfoList = ForbidInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        ForbidInfo[] forbidInfoArr = this.forbidInfoList;
        if (forbidInfoArr != null && forbidInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                ForbidInfo[] forbidInfoArr2 = this.forbidInfoList;
                if (i3 >= forbidInfoArr2.length) {
                    break;
                }
                ForbidInfo forbidInfo = forbidInfoArr2[i3];
                if (forbidInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, forbidInfo);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        ForbidInfo[] forbidInfoArr = this.forbidInfoList;
        if (forbidInfoArr != null && forbidInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                ForbidInfo[] forbidInfoArr2 = this.forbidInfoList;
                if (i3 >= forbidInfoArr2.length) {
                    break;
                }
                ForbidInfo forbidInfo = forbidInfoArr2[i3];
                if (forbidInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, forbidInfo);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetUserForbidInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetUserForbidInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetUserForbidInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                ForbidInfo[] forbidInfoArr = this.forbidInfoList;
                int length = forbidInfoArr == null ? 0 : forbidInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                ForbidInfo[] forbidInfoArr2 = new ForbidInfo[i3];
                if (length != 0) {
                    System.arraycopy(forbidInfoArr, 0, forbidInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    ForbidInfo forbidInfo = new ForbidInfo();
                    forbidInfoArr2[length] = forbidInfo;
                    codedInputByteBufferNano.readMessage(forbidInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                ForbidInfo forbidInfo2 = new ForbidInfo();
                forbidInfoArr2[length] = forbidInfo2;
                codedInputByteBufferNano.readMessage(forbidInfo2);
                this.forbidInfoList = forbidInfoArr2;
            }
        }
    }
}
