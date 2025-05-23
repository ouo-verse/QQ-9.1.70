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
public final class GetActAnimInfoRsp extends ExtendableMessageNano<GetActAnimInfoRsp> {
    private static volatile GetActAnimInfoRsp[] _emptyArray;
    public AnimInfo[] animInfos;

    public GetActAnimInfoRsp() {
        clear();
    }

    public static GetActAnimInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetActAnimInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetActAnimInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetActAnimInfoRsp) MessageNano.mergeFrom(new GetActAnimInfoRsp(), bArr);
    }

    public GetActAnimInfoRsp clear() {
        this.animInfos = AnimInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        AnimInfo[] animInfoArr = this.animInfos;
        if (animInfoArr != null && animInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                AnimInfo[] animInfoArr2 = this.animInfos;
                if (i3 >= animInfoArr2.length) {
                    break;
                }
                AnimInfo animInfo = animInfoArr2[i3];
                if (animInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, animInfo);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        AnimInfo[] animInfoArr = this.animInfos;
        if (animInfoArr != null && animInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                AnimInfo[] animInfoArr2 = this.animInfos;
                if (i3 >= animInfoArr2.length) {
                    break;
                }
                AnimInfo animInfo = animInfoArr2[i3];
                if (animInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, animInfo);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetActAnimInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetActAnimInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetActAnimInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                AnimInfo[] animInfoArr = this.animInfos;
                int length = animInfoArr == null ? 0 : animInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                AnimInfo[] animInfoArr2 = new AnimInfo[i3];
                if (length != 0) {
                    System.arraycopy(animInfoArr, 0, animInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    AnimInfo animInfo = new AnimInfo();
                    animInfoArr2[length] = animInfo;
                    codedInputByteBufferNano.readMessage(animInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                AnimInfo animInfo2 = new AnimInfo();
                animInfoArr2[length] = animInfo2;
                codedInputByteBufferNano.readMessage(animInfo2);
                this.animInfos = animInfoArr2;
            }
        }
    }
}
