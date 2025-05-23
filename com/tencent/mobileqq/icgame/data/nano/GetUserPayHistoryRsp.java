package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class GetUserPayHistoryRsp extends ExtendableMessageNano<GetUserPayHistoryRsp> {
    private static volatile GetUserPayHistoryRsp[] _emptyArray;
    public PayHistory[] infos;
    public int result;
    public int totalPrice;

    public GetUserPayHistoryRsp() {
        clear();
    }

    public static GetUserPayHistoryRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetUserPayHistoryRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetUserPayHistoryRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetUserPayHistoryRsp) MessageNano.mergeFrom(new GetUserPayHistoryRsp(), bArr);
    }

    public GetUserPayHistoryRsp clear() {
        this.result = 0;
        this.infos = PayHistory.emptyArray();
        this.totalPrice = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.result;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        PayHistory[] payHistoryArr = this.infos;
        if (payHistoryArr != null && payHistoryArr.length > 0) {
            int i16 = 0;
            while (true) {
                PayHistory[] payHistoryArr2 = this.infos;
                if (i16 >= payHistoryArr2.length) {
                    break;
                }
                PayHistory payHistory = payHistoryArr2[i16];
                if (payHistory != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, payHistory);
                }
                i16++;
            }
        }
        int i17 = this.totalPrice;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.result;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        PayHistory[] payHistoryArr = this.infos;
        if (payHistoryArr != null && payHistoryArr.length > 0) {
            int i16 = 0;
            while (true) {
                PayHistory[] payHistoryArr2 = this.infos;
                if (i16 >= payHistoryArr2.length) {
                    break;
                }
                PayHistory payHistory = payHistoryArr2[i16];
                if (payHistory != null) {
                    codedOutputByteBufferNano.writeMessage(2, payHistory);
                }
                i16++;
            }
        }
        int i17 = this.totalPrice;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetUserPayHistoryRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetUserPayHistoryRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetUserPayHistoryRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.result = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                PayHistory[] payHistoryArr = this.infos;
                int length = payHistoryArr == null ? 0 : payHistoryArr.length;
                int i3 = repeatedFieldArrayLength + length;
                PayHistory[] payHistoryArr2 = new PayHistory[i3];
                if (length != 0) {
                    System.arraycopy(payHistoryArr, 0, payHistoryArr2, 0, length);
                }
                while (length < i3 - 1) {
                    PayHistory payHistory = new PayHistory();
                    payHistoryArr2[length] = payHistory;
                    codedInputByteBufferNano.readMessage(payHistory);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                PayHistory payHistory2 = new PayHistory();
                payHistoryArr2[length] = payHistory2;
                codedInputByteBufferNano.readMessage(payHistory2);
                this.infos = payHistoryArr2;
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.totalPrice = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
