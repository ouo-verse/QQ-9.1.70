package com.tencent.mobileqq.icgame.data.punish.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class WriteOperationRecordReq extends ExtendableMessageNano<WriteOperationRecordReq> {
    private static volatile WriteOperationRecordReq[] _emptyArray;
    public OperationRecord record;
    public int recordType;
    public int roomId;

    public WriteOperationRecordReq() {
        clear();
    }

    public static WriteOperationRecordReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new WriteOperationRecordReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static WriteOperationRecordReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (WriteOperationRecordReq) MessageNano.mergeFrom(new WriteOperationRecordReq(), bArr);
    }

    public WriteOperationRecordReq clear() {
        this.recordType = 0;
        this.roomId = 0;
        this.record = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.recordType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.roomId;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        OperationRecord operationRecord = this.record;
        if (operationRecord != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, operationRecord);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.recordType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.roomId;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        OperationRecord operationRecord = this.record;
        if (operationRecord != null) {
            codedOutputByteBufferNano.writeMessage(3, operationRecord);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static WriteOperationRecordReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new WriteOperationRecordReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public WriteOperationRecordReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.recordType = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.record == null) {
                    this.record = new OperationRecord();
                }
                codedInputByteBufferNano.readMessage(this.record);
            }
        }
    }
}
