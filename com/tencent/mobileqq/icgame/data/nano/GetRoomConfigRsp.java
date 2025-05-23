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
public final class GetRoomConfigRsp extends ExtendableMessageNano<GetRoomConfigRsp> {
    private static volatile GetRoomConfigRsp[] _emptyArray;
    public RoomConfig roomConfig;

    public GetRoomConfigRsp() {
        clear();
    }

    public static GetRoomConfigRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetRoomConfigRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetRoomConfigRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetRoomConfigRsp) MessageNano.mergeFrom(new GetRoomConfigRsp(), bArr);
    }

    public GetRoomConfigRsp clear() {
        this.roomConfig = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        RoomConfig roomConfig = this.roomConfig;
        if (roomConfig != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, roomConfig);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        RoomConfig roomConfig = this.roomConfig;
        if (roomConfig != null) {
            codedOutputByteBufferNano.writeMessage(1, roomConfig);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetRoomConfigRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetRoomConfigRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetRoomConfigRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 10) {
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
