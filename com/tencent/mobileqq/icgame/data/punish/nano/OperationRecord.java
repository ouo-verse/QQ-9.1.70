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
public final class OperationRecord extends ExtendableMessageNano<OperationRecord> {
    private static volatile OperationRecord[] _emptyArray;
    public RecordUser handler;
    public String operateDesc;
    public int operateTime;
    public int operateType;
    public RecordUser user;

    public OperationRecord() {
        clear();
    }

    public static OperationRecord[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new OperationRecord[0];
                }
            }
        }
        return _emptyArray;
    }

    public static OperationRecord parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (OperationRecord) MessageNano.mergeFrom(new OperationRecord(), bArr);
    }

    public OperationRecord clear() {
        this.handler = null;
        this.user = null;
        this.operateType = 0;
        this.operateTime = 0;
        this.operateDesc = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        RecordUser recordUser = this.handler;
        if (recordUser != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, recordUser);
        }
        RecordUser recordUser2 = this.user;
        if (recordUser2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, recordUser2);
        }
        int i3 = this.operateType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        int i16 = this.operateTime;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        if (!this.operateDesc.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.operateDesc);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        RecordUser recordUser = this.handler;
        if (recordUser != null) {
            codedOutputByteBufferNano.writeMessage(1, recordUser);
        }
        RecordUser recordUser2 = this.user;
        if (recordUser2 != null) {
            codedOutputByteBufferNano.writeMessage(2, recordUser2);
        }
        int i3 = this.operateType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        int i16 = this.operateTime;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        if (!this.operateDesc.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.operateDesc);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static OperationRecord parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new OperationRecord().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public OperationRecord mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.handler == null) {
                    this.handler = new RecordUser();
                }
                codedInputByteBufferNano.readMessage(this.handler);
            } else if (readTag == 18) {
                if (this.user == null) {
                    this.user = new RecordUser();
                }
                codedInputByteBufferNano.readMessage(this.user);
            } else if (readTag == 24) {
                this.operateType = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.operateTime = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.operateDesc = codedInputByteBufferNano.readString();
            }
        }
    }
}
