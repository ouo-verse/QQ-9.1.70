package com.tencent.mobileqq.icgame.data.lucky.nano;

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
public final class GetUserRecordRsp extends ExtendableMessageNano<GetUserRecordRsp> {
    private static volatile GetUserRecordRsp[] _emptyArray;
    public int isEnd;
    public int lastId;
    public GiftRecord[] records;

    public GetUserRecordRsp() {
        clear();
    }

    public static GetUserRecordRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetUserRecordRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetUserRecordRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetUserRecordRsp) MessageNano.mergeFrom(new GetUserRecordRsp(), bArr);
    }

    public GetUserRecordRsp clear() {
        this.records = GiftRecord.emptyArray();
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
        GiftRecord[] giftRecordArr = this.records;
        if (giftRecordArr != null && giftRecordArr.length > 0) {
            int i3 = 0;
            while (true) {
                GiftRecord[] giftRecordArr2 = this.records;
                if (i3 >= giftRecordArr2.length) {
                    break;
                }
                GiftRecord giftRecord = giftRecordArr2[i3];
                if (giftRecord != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, giftRecord);
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
        GiftRecord[] giftRecordArr = this.records;
        if (giftRecordArr != null && giftRecordArr.length > 0) {
            int i3 = 0;
            while (true) {
                GiftRecord[] giftRecordArr2 = this.records;
                if (i3 >= giftRecordArr2.length) {
                    break;
                }
                GiftRecord giftRecord = giftRecordArr2[i3];
                if (giftRecord != null) {
                    codedOutputByteBufferNano.writeMessage(1, giftRecord);
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

    public static GetUserRecordRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetUserRecordRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetUserRecordRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                GiftRecord[] giftRecordArr = this.records;
                int length = giftRecordArr == null ? 0 : giftRecordArr.length;
                int i3 = repeatedFieldArrayLength + length;
                GiftRecord[] giftRecordArr2 = new GiftRecord[i3];
                if (length != 0) {
                    System.arraycopy(giftRecordArr, 0, giftRecordArr2, 0, length);
                }
                while (length < i3 - 1) {
                    GiftRecord giftRecord = new GiftRecord();
                    giftRecordArr2[length] = giftRecord;
                    codedInputByteBufferNano.readMessage(giftRecord);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                GiftRecord giftRecord2 = new GiftRecord();
                giftRecordArr2[length] = giftRecord2;
                codedInputByteBufferNano.readMessage(giftRecord2);
                this.records = giftRecordArr2;
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
