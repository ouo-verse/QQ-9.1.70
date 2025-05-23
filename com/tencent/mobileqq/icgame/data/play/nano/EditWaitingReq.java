package com.tencent.mobileqq.icgame.data.play.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class EditWaitingReq extends ExtendableMessageNano<EditWaitingReq> {
    private static volatile EditWaitingReq[] _emptyArray;
    public int micStatus;
    public int roomId;
    public int seatType;
    public long uid;

    public EditWaitingReq() {
        clear();
    }

    public static EditWaitingReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new EditWaitingReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static EditWaitingReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (EditWaitingReq) MessageNano.mergeFrom(new EditWaitingReq(), bArr);
    }

    public EditWaitingReq clear() {
        this.roomId = 0;
        this.uid = 0L;
        this.micStatus = 0;
        this.seatType = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.roomId) + CodedOutputByteBufferNano.computeUInt64Size(2, this.uid);
        int i3 = this.micStatus;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        int i16 = this.seatType;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.roomId);
        codedOutputByteBufferNano.writeUInt64(2, this.uid);
        int i3 = this.micStatus;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        int i16 = this.seatType;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static EditWaitingReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new EditWaitingReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public EditWaitingReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                this.micStatus = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.seatType = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
