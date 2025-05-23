package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class SetRoomGamePlayStateReq extends ExtendableMessageNano<SetRoomGamePlayStateReq> {
    private static volatile SetRoomGamePlayStateReq[] _emptyArray;
    public int gameId;
    public int gameState;
    public int roomId;

    public SetRoomGamePlayStateReq() {
        clear();
    }

    public static SetRoomGamePlayStateReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SetRoomGamePlayStateReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SetRoomGamePlayStateReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SetRoomGamePlayStateReq) MessageNano.mergeFrom(new SetRoomGamePlayStateReq(), bArr);
    }

    public SetRoomGamePlayStateReq clear() {
        this.roomId = 0;
        this.gameId = 0;
        this.gameState = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        return super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.roomId) + CodedOutputByteBufferNano.computeUInt32Size(2, this.gameId) + CodedOutputByteBufferNano.computeUInt32Size(3, this.gameState);
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.roomId);
        codedOutputByteBufferNano.writeUInt32(2, this.gameId);
        codedOutputByteBufferNano.writeUInt32(3, this.gameState);
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SetRoomGamePlayStateReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SetRoomGamePlayStateReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SetRoomGamePlayStateReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.gameId = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.gameState = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
