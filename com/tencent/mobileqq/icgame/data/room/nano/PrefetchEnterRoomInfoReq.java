package com.tencent.mobileqq.icgame.data.room.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class PrefetchEnterRoomInfoReq extends ExtendableMessageNano<PrefetchEnterRoomInfoReq> {
    private static volatile PrefetchEnterRoomInfoReq[] _emptyArray;
    public long groupCode;
    public int roomCode;

    public PrefetchEnterRoomInfoReq() {
        clear();
    }

    public static PrefetchEnterRoomInfoReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PrefetchEnterRoomInfoReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static PrefetchEnterRoomInfoReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (PrefetchEnterRoomInfoReq) MessageNano.mergeFrom(new PrefetchEnterRoomInfoReq(), bArr);
    }

    public PrefetchEnterRoomInfoReq clear() {
        this.roomCode = 0;
        this.groupCode = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.roomCode;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        long j3 = this.groupCode;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.roomCode;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        long j3 = this.groupCode;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static PrefetchEnterRoomInfoReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new PrefetchEnterRoomInfoReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public PrefetchEnterRoomInfoReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomCode = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.groupCode = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
