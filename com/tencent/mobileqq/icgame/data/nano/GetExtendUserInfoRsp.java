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
public final class GetExtendUserInfoRsp extends ExtendableMessageNano<GetExtendUserInfoRsp> {
    private static volatile GetExtendUserInfoRsp[] _emptyArray;
    public ExtendUserInfo[] extendInfo;

    public GetExtendUserInfoRsp() {
        clear();
    }

    public static GetExtendUserInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetExtendUserInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetExtendUserInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetExtendUserInfoRsp) MessageNano.mergeFrom(new GetExtendUserInfoRsp(), bArr);
    }

    public GetExtendUserInfoRsp clear() {
        this.extendInfo = ExtendUserInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        ExtendUserInfo[] extendUserInfoArr = this.extendInfo;
        if (extendUserInfoArr != null && extendUserInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                ExtendUserInfo[] extendUserInfoArr2 = this.extendInfo;
                if (i3 >= extendUserInfoArr2.length) {
                    break;
                }
                ExtendUserInfo extendUserInfo = extendUserInfoArr2[i3];
                if (extendUserInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, extendUserInfo);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        ExtendUserInfo[] extendUserInfoArr = this.extendInfo;
        if (extendUserInfoArr != null && extendUserInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                ExtendUserInfo[] extendUserInfoArr2 = this.extendInfo;
                if (i3 >= extendUserInfoArr2.length) {
                    break;
                }
                ExtendUserInfo extendUserInfo = extendUserInfoArr2[i3];
                if (extendUserInfo != null) {
                    codedOutputByteBufferNano.writeMessage(2, extendUserInfo);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetExtendUserInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetExtendUserInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetExtendUserInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                ExtendUserInfo[] extendUserInfoArr = this.extendInfo;
                int length = extendUserInfoArr == null ? 0 : extendUserInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                ExtendUserInfo[] extendUserInfoArr2 = new ExtendUserInfo[i3];
                if (length != 0) {
                    System.arraycopy(extendUserInfoArr, 0, extendUserInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    ExtendUserInfo extendUserInfo = new ExtendUserInfo();
                    extendUserInfoArr2[length] = extendUserInfo;
                    codedInputByteBufferNano.readMessage(extendUserInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                ExtendUserInfo extendUserInfo2 = new ExtendUserInfo();
                extendUserInfoArr2[length] = extendUserInfo2;
                codedInputByteBufferNano.readMessage(extendUserInfo2);
                this.extendInfo = extendUserInfoArr2;
            }
        }
    }
}
