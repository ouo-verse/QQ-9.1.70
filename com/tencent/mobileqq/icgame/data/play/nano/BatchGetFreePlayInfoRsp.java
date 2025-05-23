package com.tencent.mobileqq.icgame.data.play.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class BatchGetFreePlayInfoRsp extends ExtendableMessageNano<BatchGetFreePlayInfoRsp> {
    private static volatile BatchGetFreePlayInfoRsp[] _emptyArray;
    public FreePlayBasicInfo[] basicInfo;

    public BatchGetFreePlayInfoRsp() {
        clear();
    }

    public static BatchGetFreePlayInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new BatchGetFreePlayInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static BatchGetFreePlayInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (BatchGetFreePlayInfoRsp) MessageNano.mergeFrom(new BatchGetFreePlayInfoRsp(), bArr);
    }

    public BatchGetFreePlayInfoRsp clear() {
        this.basicInfo = FreePlayBasicInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        FreePlayBasicInfo[] freePlayBasicInfoArr = this.basicInfo;
        if (freePlayBasicInfoArr != null && freePlayBasicInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                FreePlayBasicInfo[] freePlayBasicInfoArr2 = this.basicInfo;
                if (i3 >= freePlayBasicInfoArr2.length) {
                    break;
                }
                FreePlayBasicInfo freePlayBasicInfo = freePlayBasicInfoArr2[i3];
                if (freePlayBasicInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, freePlayBasicInfo);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        FreePlayBasicInfo[] freePlayBasicInfoArr = this.basicInfo;
        if (freePlayBasicInfoArr != null && freePlayBasicInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                FreePlayBasicInfo[] freePlayBasicInfoArr2 = this.basicInfo;
                if (i3 >= freePlayBasicInfoArr2.length) {
                    break;
                }
                FreePlayBasicInfo freePlayBasicInfo = freePlayBasicInfoArr2[i3];
                if (freePlayBasicInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, freePlayBasicInfo);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static BatchGetFreePlayInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new BatchGetFreePlayInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public BatchGetFreePlayInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                FreePlayBasicInfo[] freePlayBasicInfoArr = this.basicInfo;
                int length = freePlayBasicInfoArr == null ? 0 : freePlayBasicInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                FreePlayBasicInfo[] freePlayBasicInfoArr2 = new FreePlayBasicInfo[i3];
                if (length != 0) {
                    System.arraycopy(freePlayBasicInfoArr, 0, freePlayBasicInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    FreePlayBasicInfo freePlayBasicInfo = new FreePlayBasicInfo();
                    freePlayBasicInfoArr2[length] = freePlayBasicInfo;
                    codedInputByteBufferNano.readMessage(freePlayBasicInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                FreePlayBasicInfo freePlayBasicInfo2 = new FreePlayBasicInfo();
                freePlayBasicInfoArr2[length] = freePlayBasicInfo2;
                codedInputByteBufferNano.readMessage(freePlayBasicInfo2);
                this.basicInfo = freePlayBasicInfoArr2;
            }
        }
    }
}
