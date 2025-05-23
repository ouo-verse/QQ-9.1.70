package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class SetRoomGamePlayStateRsp extends ExtendableMessageNano<SetRoomGamePlayStateRsp> {
    private static volatile SetRoomGamePlayStateRsp[] _emptyArray;
    public RoomGamePlayState gamePlayState;
    public int roomId;

    public SetRoomGamePlayStateRsp() {
        clear();
    }

    public static SetRoomGamePlayStateRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SetRoomGamePlayStateRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SetRoomGamePlayStateRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SetRoomGamePlayStateRsp) MessageNano.mergeFrom(new SetRoomGamePlayStateRsp(), bArr);
    }

    public SetRoomGamePlayStateRsp clear() {
        this.roomId = 0;
        this.gamePlayState = null;
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
        RoomGamePlayState roomGamePlayState = this.gamePlayState;
        if (roomGamePlayState != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, roomGamePlayState);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.roomId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        RoomGamePlayState roomGamePlayState = this.gamePlayState;
        if (roomGamePlayState != null) {
            codedOutputByteBufferNano.writeMessage(2, roomGamePlayState);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SetRoomGamePlayStateRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SetRoomGamePlayStateRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SetRoomGamePlayStateRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.gamePlayState == null) {
                    this.gamePlayState = new RoomGamePlayState();
                }
                codedInputByteBufferNano.readMessage(this.gamePlayState);
            }
        }
    }
}
