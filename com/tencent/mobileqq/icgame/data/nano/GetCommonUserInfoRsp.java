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
public final class GetCommonUserInfoRsp extends ExtendableMessageNano<GetCommonUserInfoRsp> {
    private static volatile GetCommonUserInfoRsp[] _emptyArray;
    public int idType;
    public CommonUserInfo[] infos;

    public GetCommonUserInfoRsp() {
        clear();
    }

    public static GetCommonUserInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetCommonUserInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetCommonUserInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetCommonUserInfoRsp) MessageNano.mergeFrom(new GetCommonUserInfoRsp(), bArr);
    }

    public GetCommonUserInfoRsp clear() {
        this.idType = 1;
        this.infos = CommonUserInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.idType;
        if (i3 != 1) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        CommonUserInfo[] commonUserInfoArr = this.infos;
        if (commonUserInfoArr != null && commonUserInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                CommonUserInfo[] commonUserInfoArr2 = this.infos;
                if (i16 >= commonUserInfoArr2.length) {
                    break;
                }
                CommonUserInfo commonUserInfo = commonUserInfoArr2[i16];
                if (commonUserInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, commonUserInfo);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.idType;
        if (i3 != 1) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        CommonUserInfo[] commonUserInfoArr = this.infos;
        if (commonUserInfoArr != null && commonUserInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                CommonUserInfo[] commonUserInfoArr2 = this.infos;
                if (i16 >= commonUserInfoArr2.length) {
                    break;
                }
                CommonUserInfo commonUserInfo = commonUserInfoArr2[i16];
                if (commonUserInfo != null) {
                    codedOutputByteBufferNano.writeMessage(2, commonUserInfo);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetCommonUserInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetCommonUserInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetCommonUserInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 1 || readInt32 == 2) {
                    this.idType = readInt32;
                }
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                CommonUserInfo[] commonUserInfoArr = this.infos;
                int length = commonUserInfoArr == null ? 0 : commonUserInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                CommonUserInfo[] commonUserInfoArr2 = new CommonUserInfo[i3];
                if (length != 0) {
                    System.arraycopy(commonUserInfoArr, 0, commonUserInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    CommonUserInfo commonUserInfo = new CommonUserInfo();
                    commonUserInfoArr2[length] = commonUserInfo;
                    codedInputByteBufferNano.readMessage(commonUserInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                CommonUserInfo commonUserInfo2 = new CommonUserInfo();
                commonUserInfoArr2[length] = commonUserInfo2;
                codedInputByteBufferNano.readMessage(commonUserInfo2);
                this.infos = commonUserInfoArr2;
            }
        }
    }
}
