package com.tencent.mobileqq.icgame.data.diff.nano;

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
    public String adminUidNick;
    public String detail;
    public int fromSeatOrder;
    public int opType;
    public int roomId;
    public int toSeatOrder;
    public long uid;
    public String uidNick;

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
        this.uidNick = "";
        this.adminUidNick = "";
        this.fromSeatOrder = 0;
        this.toSeatOrder = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.roomId) + CodedOutputByteBufferNano.computeUInt64Size(2, this.uid) + CodedOutputByteBufferNano.computeUInt64Size(3, this.adminUid) + CodedOutputByteBufferNano.computeInt32Size(4, this.opType);
        if (!this.detail.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.detail);
        }
        if (!this.uidNick.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.uidNick);
        }
        if (!this.adminUidNick.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.adminUidNick);
        }
        int i3 = this.fromSeatOrder;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i3);
        }
        int i16 = this.toSeatOrder;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(9, i16);
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
        if (!this.uidNick.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.uidNick);
        }
        if (!this.adminUidNick.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.adminUidNick);
        }
        int i3 = this.fromSeatOrder;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i3);
        }
        int i16 = this.toSeatOrder;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i16);
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
            } else if (readTag == 42) {
                this.detail = codedInputByteBufferNano.readString();
            } else if (readTag == 50) {
                this.uidNick = codedInputByteBufferNano.readString();
            } else if (readTag == 58) {
                this.adminUidNick = codedInputByteBufferNano.readString();
            } else if (readTag == 64) {
                this.fromSeatOrder = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 72) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.toSeatOrder = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
