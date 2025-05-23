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
public final class GetAnchorProfitRsp extends ExtendableMessageNano<GetAnchorProfitRsp> {
    private static volatile GetAnchorProfitRsp[] _emptyArray;
    public int isEnd;
    public int lastId;
    public AnchorProfit[] profits;

    public GetAnchorProfitRsp() {
        clear();
    }

    public static GetAnchorProfitRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetAnchorProfitRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetAnchorProfitRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetAnchorProfitRsp) MessageNano.mergeFrom(new GetAnchorProfitRsp(), bArr);
    }

    public GetAnchorProfitRsp clear() {
        this.profits = AnchorProfit.emptyArray();
        this.lastId = 0;
        this.isEnd = 0;
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
        int i16 = this.lastId;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        int i17 = this.isEnd;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i17);
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
        int i16 = this.lastId;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        int i17 = this.isEnd;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetAnchorProfitRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetAnchorProfitRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetAnchorProfitRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
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
            } else if (readTag == 16) {
                this.lastId = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.isEnd = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
