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
public final class GetCommonUserInfoInnerRsp extends ExtendableMessageNano<GetCommonUserInfoInnerRsp> {
    private static volatile GetCommonUserInfoInnerRsp[] _emptyArray;
    public int idType;
    public CommonUserInfoInner[] infos;

    public GetCommonUserInfoInnerRsp() {
        clear();
    }

    public static GetCommonUserInfoInnerRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetCommonUserInfoInnerRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetCommonUserInfoInnerRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetCommonUserInfoInnerRsp) MessageNano.mergeFrom(new GetCommonUserInfoInnerRsp(), bArr);
    }

    public GetCommonUserInfoInnerRsp clear() {
        this.idType = 1;
        this.infos = CommonUserInfoInner.emptyArray();
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
        CommonUserInfoInner[] commonUserInfoInnerArr = this.infos;
        if (commonUserInfoInnerArr != null && commonUserInfoInnerArr.length > 0) {
            int i16 = 0;
            while (true) {
                CommonUserInfoInner[] commonUserInfoInnerArr2 = this.infos;
                if (i16 >= commonUserInfoInnerArr2.length) {
                    break;
                }
                CommonUserInfoInner commonUserInfoInner = commonUserInfoInnerArr2[i16];
                if (commonUserInfoInner != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, commonUserInfoInner);
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
        CommonUserInfoInner[] commonUserInfoInnerArr = this.infos;
        if (commonUserInfoInnerArr != null && commonUserInfoInnerArr.length > 0) {
            int i16 = 0;
            while (true) {
                CommonUserInfoInner[] commonUserInfoInnerArr2 = this.infos;
                if (i16 >= commonUserInfoInnerArr2.length) {
                    break;
                }
                CommonUserInfoInner commonUserInfoInner = commonUserInfoInnerArr2[i16];
                if (commonUserInfoInner != null) {
                    codedOutputByteBufferNano.writeMessage(2, commonUserInfoInner);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetCommonUserInfoInnerRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetCommonUserInfoInnerRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetCommonUserInfoInnerRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                CommonUserInfoInner[] commonUserInfoInnerArr = this.infos;
                int length = commonUserInfoInnerArr == null ? 0 : commonUserInfoInnerArr.length;
                int i3 = repeatedFieldArrayLength + length;
                CommonUserInfoInner[] commonUserInfoInnerArr2 = new CommonUserInfoInner[i3];
                if (length != 0) {
                    System.arraycopy(commonUserInfoInnerArr, 0, commonUserInfoInnerArr2, 0, length);
                }
                while (length < i3 - 1) {
                    CommonUserInfoInner commonUserInfoInner = new CommonUserInfoInner();
                    commonUserInfoInnerArr2[length] = commonUserInfoInner;
                    codedInputByteBufferNano.readMessage(commonUserInfoInner);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                CommonUserInfoInner commonUserInfoInner2 = new CommonUserInfoInner();
                commonUserInfoInnerArr2[length] = commonUserInfoInner2;
                codedInputByteBufferNano.readMessage(commonUserInfoInner2);
                this.infos = commonUserInfoInnerArr2;
            }
        }
    }
}
