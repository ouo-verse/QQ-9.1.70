package com.tencent.mobileqq.icgame.data.punish.nano;

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
public final class GetOperationRecordRsp extends ExtendableMessageNano<GetOperationRecordRsp> {
    private static volatile GetOperationRecordRsp[] _emptyArray;
    public OperationRecord[] records;
    public int roomId;
    public int total;

    public GetOperationRecordRsp() {
        clear();
    }

    public static GetOperationRecordRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetOperationRecordRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetOperationRecordRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetOperationRecordRsp) MessageNano.mergeFrom(new GetOperationRecordRsp(), bArr);
    }

    public GetOperationRecordRsp clear() {
        this.records = OperationRecord.emptyArray();
        this.roomId = 0;
        this.total = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        OperationRecord[] operationRecordArr = this.records;
        if (operationRecordArr != null && operationRecordArr.length > 0) {
            int i3 = 0;
            while (true) {
                OperationRecord[] operationRecordArr2 = this.records;
                if (i3 >= operationRecordArr2.length) {
                    break;
                }
                OperationRecord operationRecord = operationRecordArr2[i3];
                if (operationRecord != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, operationRecord);
                }
                i3++;
            }
        }
        int i16 = this.roomId;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        int i17 = this.total;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        OperationRecord[] operationRecordArr = this.records;
        if (operationRecordArr != null && operationRecordArr.length > 0) {
            int i3 = 0;
            while (true) {
                OperationRecord[] operationRecordArr2 = this.records;
                if (i3 >= operationRecordArr2.length) {
                    break;
                }
                OperationRecord operationRecord = operationRecordArr2[i3];
                if (operationRecord != null) {
                    codedOutputByteBufferNano.writeMessage(1, operationRecord);
                }
                i3++;
            }
        }
        int i16 = this.roomId;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        int i17 = this.total;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetOperationRecordRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetOperationRecordRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetOperationRecordRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                OperationRecord[] operationRecordArr = this.records;
                int length = operationRecordArr == null ? 0 : operationRecordArr.length;
                int i3 = repeatedFieldArrayLength + length;
                OperationRecord[] operationRecordArr2 = new OperationRecord[i3];
                if (length != 0) {
                    System.arraycopy(operationRecordArr, 0, operationRecordArr2, 0, length);
                }
                while (length < i3 - 1) {
                    OperationRecord operationRecord = new OperationRecord();
                    operationRecordArr2[length] = operationRecord;
                    codedInputByteBufferNano.readMessage(operationRecord);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                OperationRecord operationRecord2 = new OperationRecord();
                operationRecordArr2[length] = operationRecord2;
                codedInputByteBufferNano.readMessage(operationRecord2);
                this.records = operationRecordArr2;
            } else if (readTag == 16) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.total = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
