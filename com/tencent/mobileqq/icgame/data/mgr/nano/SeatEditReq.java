package com.tencent.mobileqq.icgame.data.mgr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class SeatEditReq extends ExtendableMessageNano<SeatEditReq> {
    private static volatile SeatEditReq[] _emptyArray;
    public int isAssignSeat;
    public int landscapeType;
    public int listId;
    public int roomId;
    public int seatNo;
    public int type;
    public long uid;

    public SeatEditReq() {
        clear();
    }

    public static SeatEditReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SeatEditReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SeatEditReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SeatEditReq) MessageNano.mergeFrom(new SeatEditReq(), bArr);
    }

    public SeatEditReq clear() {
        this.roomId = 0;
        this.isAssignSeat = 0;
        this.seatNo = 0;
        this.uid = 0L;
        this.landscapeType = 0;
        this.listId = 0;
        this.type = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.roomId) + CodedOutputByteBufferNano.computeUInt32Size(2, this.isAssignSeat);
        int i3 = this.seatNo;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        int computeUInt64Size = computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, this.uid);
        int i16 = this.landscapeType;
        if (i16 != 0) {
            computeUInt64Size += CodedOutputByteBufferNano.computeUInt32Size(5, i16);
        }
        int i17 = this.listId;
        if (i17 != 0) {
            computeUInt64Size += CodedOutputByteBufferNano.computeUInt32Size(6, i17);
        }
        int i18 = this.type;
        if (i18 != 0) {
            return computeUInt64Size + CodedOutputByteBufferNano.computeUInt32Size(7, i18);
        }
        return computeUInt64Size;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.roomId);
        codedOutputByteBufferNano.writeUInt32(2, this.isAssignSeat);
        int i3 = this.seatNo;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        codedOutputByteBufferNano.writeUInt64(4, this.uid);
        int i16 = this.landscapeType;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i16);
        }
        int i17 = this.listId;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i17);
        }
        int i18 = this.type;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SeatEditReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SeatEditReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SeatEditReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.isAssignSeat = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.seatNo = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 40) {
                this.landscapeType = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 48) {
                this.listId = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 56) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.type = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
