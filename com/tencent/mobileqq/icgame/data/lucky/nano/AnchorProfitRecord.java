package com.tencent.mobileqq.icgame.data.lucky.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class AnchorProfitRecord extends ExtendableMessageNano<AnchorProfitRecord> {
    private static volatile AnchorProfitRecord[] _emptyArray;
    public AnchorProfit[] profits;

    public AnchorProfitRecord() {
        clear();
    }

    public static AnchorProfitRecord[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AnchorProfitRecord[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AnchorProfitRecord parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AnchorProfitRecord) MessageNano.mergeFrom(new AnchorProfitRecord(), bArr);
    }

    public AnchorProfitRecord clear() {
        this.profits = AnchorProfit.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        AnchorProfit[] anchorProfitArr = this.profits;
        if (anchorProfitArr != null && anchorProfitArr.length > 0) {
            int i3 = 0;
            while (true) {
                AnchorProfit[] anchorProfitArr2 = this.profits;
                if (i3 >= anchorProfitArr2.length) {
                    break;
                }
                AnchorProfit anchorProfit = anchorProfitArr2[i3];
                if (anchorProfit != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, anchorProfit);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        AnchorProfit[] anchorProfitArr = this.profits;
        if (anchorProfitArr != null && anchorProfitArr.length > 0) {
            int i3 = 0;
            while (true) {
                AnchorProfit[] anchorProfitArr2 = this.profits;
                if (i3 >= anchorProfitArr2.length) {
                    break;
                }
                AnchorProfit anchorProfit = anchorProfitArr2[i3];
                if (anchorProfit != null) {
                    codedOutputByteBufferNano.writeMessage(1, anchorProfit);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AnchorProfitRecord parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AnchorProfitRecord().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AnchorProfitRecord mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                AnchorProfit[] anchorProfitArr = this.profits;
                int length = anchorProfitArr == null ? 0 : anchorProfitArr.length;
                int i3 = repeatedFieldArrayLength + length;
                AnchorProfit[] anchorProfitArr2 = new AnchorProfit[i3];
                if (length != 0) {
                    System.arraycopy(anchorProfitArr, 0, anchorProfitArr2, 0, length);
                }
                while (length < i3 - 1) {
                    AnchorProfit anchorProfit = new AnchorProfit();
                    anchorProfitArr2[length] = anchorProfit;
                    codedInputByteBufferNano.readMessage(anchorProfit);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                AnchorProfit anchorProfit2 = new AnchorProfit();
                anchorProfitArr2[length] = anchorProfit2;
                codedInputByteBufferNano.readMessage(anchorProfit2);
                this.profits = anchorProfitArr2;
            }
        }
    }
}
