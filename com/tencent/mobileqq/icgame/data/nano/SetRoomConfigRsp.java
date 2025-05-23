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
public final class SetRoomConfigRsp extends ExtendableMessageNano<SetRoomConfigRsp> {
    private static volatile SetRoomConfigRsp[] _emptyArray;
    public RoomConfig roomConfig;
    public int roomId;

    public SetRoomConfigRsp() {
        clear();
    }

    public static SetRoomConfigRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SetRoomConfigRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SetRoomConfigRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SetRoomConfigRsp) MessageNano.mergeFrom(new SetRoomConfigRsp(), bArr);
    }

    public SetRoomConfigRsp clear() {
        this.roomId = 0;
        this.roomConfig = null;
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
        RoomConfig roomConfig = this.roomConfig;
        if (roomConfig != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, roomConfig);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.roomId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        RoomConfig roomConfig = this.roomConfig;
        if (roomConfig != null) {
            codedOutputByteBufferNano.writeMessage(2, roomConfig);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SetRoomConfigRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SetRoomConfigRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SetRoomConfigRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
