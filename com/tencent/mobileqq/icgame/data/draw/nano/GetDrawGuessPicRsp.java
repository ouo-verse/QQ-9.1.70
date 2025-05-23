package com.tencent.mobileqq.icgame.data.draw.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class GetDrawGuessPicRsp extends ExtendableMessageNano<GetDrawGuessPicRsp> {
    private static volatile GetDrawGuessPicRsp[] _emptyArray;
    public PicAndScoreInfo[] infoList;

    public GetDrawGuessPicRsp() {
        clear();
    }

    public static GetDrawGuessPicRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetDrawGuessPicRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetDrawGuessPicRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetDrawGuessPicRsp) MessageNano.mergeFrom(new GetDrawGuessPicRsp(), bArr);
    }

    public GetDrawGuessPicRsp clear() {
        this.infoList = PicAndScoreInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        PicAndScoreInfo[] picAndScoreInfoArr = this.infoList;
        if (picAndScoreInfoArr != null && picAndScoreInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                PicAndScoreInfo[] picAndScoreInfoArr2 = this.infoList;
                if (i3 >= picAndScoreInfoArr2.length) {
                    break;
                }
                PicAndScoreInfo picAndScoreInfo = picAndScoreInfoArr2[i3];
                if (picAndScoreInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, picAndScoreInfo);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        PicAndScoreInfo[] picAndScoreInfoArr = this.infoList;
        if (picAndScoreInfoArr != null && picAndScoreInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                PicAndScoreInfo[] picAndScoreInfoArr2 = this.infoList;
                if (i3 >= picAndScoreInfoArr2.length) {
                    break;
                }
                PicAndScoreInfo picAndScoreInfo = picAndScoreInfoArr2[i3];
                if (picAndScoreInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, picAndScoreInfo);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetDrawGuessPicRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetDrawGuessPicRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetDrawGuessPicRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                PicAndScoreInfo[] picAndScoreInfoArr = this.infoList;
                int length = picAndScoreInfoArr == null ? 0 : picAndScoreInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                PicAndScoreInfo[] picAndScoreInfoArr2 = new PicAndScoreInfo[i3];
                if (length != 0) {
                    System.arraycopy(picAndScoreInfoArr, 0, picAndScoreInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    PicAndScoreInfo picAndScoreInfo = new PicAndScoreInfo();
                    picAndScoreInfoArr2[length] = picAndScoreInfo;
                    codedInputByteBufferNano.readMessage(picAndScoreInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                PicAndScoreInfo picAndScoreInfo2 = new PicAndScoreInfo();
                picAndScoreInfoArr2[length] = picAndScoreInfo2;
                codedInputByteBufferNano.readMessage(picAndScoreInfo2);
                this.infoList = picAndScoreInfoArr2;
            }
        }
    }
}
