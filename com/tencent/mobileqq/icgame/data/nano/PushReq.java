package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class PushReq extends ExtendableMessageNano<PushReq> {
    private static volatile PushReq[] _emptyArray;
    public long adminUid;
    public int opType;
    public int roomId;
    public SendGiftReq sendGiftReq;
    public long toUid;
    public long uid;

    public PushReq() {
        clear();
    }

    public static PushReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PushReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static PushReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (PushReq) MessageNano.mergeFrom(new PushReq(), bArr);
    }

    public PushReq clear() {
        this.roomId = 0;
        this.adminUid = 0L;
        this.uid = 0L;
        this.opType = 0;
        this.toUid = 0L;
        this.sendGiftReq = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.roomId;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        long j3 = this.adminUid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        long j16 = this.uid;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        int i16 = this.opType;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i16);
        }
        long j17 = this.toUid;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j17);
        }
        SendGiftReq sendGiftReq = this.sendGiftReq;
        if (sendGiftReq != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, sendGiftReq);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.roomId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        long j3 = this.adminUid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        long j16 = this.uid;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        int i16 = this.opType;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i16);
        }
        long j17 = this.toUid;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j17);
        }
        SendGiftReq sendGiftReq = this.sendGiftReq;
        if (sendGiftReq != null) {
            codedOutputByteBufferNano.writeMessage(6, sendGiftReq);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static PushReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new PushReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public PushReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.adminUid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.uid = codedInputByteBufferNano.readUInt64();
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
            } else if (readTag == 40) {
                this.toUid = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.sendGiftReq == null) {
                    this.sendGiftReq = new SendGiftReq();
                }
                codedInputByteBufferNano.readMessage(this.sendGiftReq);
            }
        }
    }
}
