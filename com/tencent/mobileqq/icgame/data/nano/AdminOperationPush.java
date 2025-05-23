package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class AdminOperationPush extends ExtendableMessageNano<AdminOperationPush> {
    private static volatile AdminOperationPush[] _emptyArray;
    public long adminUid;
    public String detail;
    public int opType;
    public int roomId;
    public long uid;

    public AdminOperationPush() {
        clear();
    }

    public static AdminOperationPush[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AdminOperationPush[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AdminOperationPush parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AdminOperationPush) MessageNano.mergeFrom(new AdminOperationPush(), bArr);
    }

    public AdminOperationPush clear() {
        this.roomId = 0;
        this.uid = 0L;
        this.adminUid = 0L;
        this.opType = 0;
        this.detail = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.roomId) + CodedOutputByteBufferNano.computeUInt64Size(2, this.uid) + CodedOutputByteBufferNano.computeUInt64Size(3, this.adminUid) + CodedOutputByteBufferNano.computeInt32Size(4, this.opType);
        if (!this.detail.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.detail);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.roomId);
        codedOutputByteBufferNano.writeUInt64(2, this.uid);
        codedOutputByteBufferNano.writeUInt64(3, this.adminUid);
        codedOutputByteBufferNano.writeInt32(4, this.opType);
        if (!this.detail.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.detail);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AdminOperationPush parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AdminOperationPush().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AdminOperationPush mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.adminUid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 32) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                switch (readInt32) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                        this.opType = readInt32;
                        break;
                }
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.detail = codedInputByteBufferNano.readString();
            }
        }
    }
}
