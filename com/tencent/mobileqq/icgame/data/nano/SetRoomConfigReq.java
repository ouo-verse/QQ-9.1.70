package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class SetRoomConfigReq extends ExtendableMessageNano<SetRoomConfigReq> {
    private static volatile SetRoomConfigReq[] _emptyArray;
    public RoomConfig roomConfig;
    public int roomId;

    public SetRoomConfigReq() {
        clear();
    }

    public static SetRoomConfigReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SetRoomConfigReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SetRoomConfigReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SetRoomConfigReq) MessageNano.mergeFrom(new SetRoomConfigReq(), bArr);
    }

    public SetRoomConfigReq clear() {
        this.roomId = 0;
        this.roomConfig = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.roomId);
        RoomConfig roomConfig = this.roomConfig;
        if (roomConfig != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, roomConfig);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.roomId);
        RoomConfig roomConfig = this.roomConfig;
        if (roomConfig != null) {
            codedOutputByteBufferNano.writeMessage(2, roomConfig);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SetRoomConfigReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SetRoomConfigReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SetRoomConfigReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.roomConfig == null) {
                    this.roomConfig = new RoomConfig();
                }
                codedInputByteBufferNano.readMessage(this.roomConfig);
            }
        }
    }
}
