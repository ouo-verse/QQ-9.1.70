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
public final class GetFansRecordRsp extends ExtendableMessageNano<GetFansRecordRsp> {
    private static volatile GetFansRecordRsp[] _emptyArray;
    public int isEnd;
    public int lastId;
    public FansRecord[] records;

    public GetFansRecordRsp() {
        clear();
    }

    public static GetFansRecordRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetFansRecordRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetFansRecordRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetFansRecordRsp) MessageNano.mergeFrom(new GetFansRecordRsp(), bArr);
    }

    public GetFansRecordRsp clear() {
        this.records = FansRecord.emptyArray();
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
        FansRecord[] fansRecordArr = this.records;
        if (fansRecordArr != null && fansRecordArr.length > 0) {
            int i3 = 0;
            while (true) {
                FansRecord[] fansRecordArr2 = this.records;
                if (i3 >= fansRecordArr2.length) {
                    break;
                }
                FansRecord fansRecord = fansRecordArr2[i3];
                if (fansRecord != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, fansRecord);
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
        FansRecord[] fansRecordArr = this.records;
        if (fansRecordArr != null && fansRecordArr.length > 0) {
            int i3 = 0;
            while (true) {
                FansRecord[] fansRecordArr2 = this.records;
                if (i3 >= fansRecordArr2.length) {
                    break;
                }
                FansRecord fansRecord = fansRecordArr2[i3];
                if (fansRecord != null) {
                    codedOutputByteBufferNano.writeMessage(1, fansRecord);
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

    public static GetFansRecordRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetFansRecordRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetFansRecordRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                FansRecord[] fansRecordArr = this.records;
                int length = fansRecordArr == null ? 0 : fansRecordArr.length;
                int i3 = repeatedFieldArrayLength + length;
                FansRecord[] fansRecordArr2 = new FansRecord[i3];
                if (length != 0) {
                    System.arraycopy(fansRecordArr, 0, fansRecordArr2, 0, length);
                }
                while (length < i3 - 1) {
                    FansRecord fansRecord = new FansRecord();
                    fansRecordArr2[length] = fansRecord;
                    codedInputByteBufferNano.readMessage(fansRecord);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                FansRecord fansRecord2 = new FansRecord();
                fansRecordArr2[length] = fansRecord2;
                codedInputByteBufferNano.readMessage(fansRecord2);
                this.records = fansRecordArr2;
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
