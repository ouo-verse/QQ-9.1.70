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
public final class GetRoomIdByGroupCodeRsp extends ExtendableMessageNano<GetRoomIdByGroupCodeRsp> {
    private static volatile GetRoomIdByGroupCodeRsp[] _emptyArray;
    public RoomBaseInfo roomBaseInfo;
    public int roomId;

    public GetRoomIdByGroupCodeRsp() {
        clear();
    }

    public static GetRoomIdByGroupCodeRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetRoomIdByGroupCodeRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetRoomIdByGroupCodeRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetRoomIdByGroupCodeRsp) MessageNano.mergeFrom(new GetRoomIdByGroupCodeRsp(), bArr);
    }

    public GetRoomIdByGroupCodeRsp clear() {
        this.roomId = 0;
        this.roomBaseInfo = null;
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
        RoomBaseInfo roomBaseInfo = this.roomBaseInfo;
        if (roomBaseInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, roomBaseInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.roomId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        RoomBaseInfo roomBaseInfo = this.roomBaseInfo;
        if (roomBaseInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, roomBaseInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetRoomIdByGroupCodeRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetRoomIdByGroupCodeRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetRoomIdByGroupCodeRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.roomBaseInfo == null) {
                    this.roomBaseInfo = new RoomBaseInfo();
                }
                codedInputByteBufferNano.readMessage(this.roomBaseInfo);
            }
        }
    }
}
