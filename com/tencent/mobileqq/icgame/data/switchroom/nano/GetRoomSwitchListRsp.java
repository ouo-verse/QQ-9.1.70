package com.tencent.mobileqq.icgame.data.switchroom.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class GetRoomSwitchListRsp extends ExtendableMessageNano<GetRoomSwitchListRsp> {
    private static volatile GetRoomSwitchListRsp[] _emptyArray;
    public RoomInfo[] rooms;

    public GetRoomSwitchListRsp() {
        clear();
    }

    public static GetRoomSwitchListRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetRoomSwitchListRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetRoomSwitchListRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetRoomSwitchListRsp) MessageNano.mergeFrom(new GetRoomSwitchListRsp(), bArr);
    }

    public GetRoomSwitchListRsp clear() {
        this.rooms = RoomInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        RoomInfo[] roomInfoArr = this.rooms;
        if (roomInfoArr != null && roomInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                RoomInfo[] roomInfoArr2 = this.rooms;
                if (i3 >= roomInfoArr2.length) {
                    break;
                }
                RoomInfo roomInfo = roomInfoArr2[i3];
                if (roomInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, roomInfo);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        RoomInfo[] roomInfoArr = this.rooms;
        if (roomInfoArr != null && roomInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                RoomInfo[] roomInfoArr2 = this.rooms;
                if (i3 >= roomInfoArr2.length) {
                    break;
                }
                RoomInfo roomInfo = roomInfoArr2[i3];
                if (roomInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, roomInfo);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetRoomSwitchListRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetRoomSwitchListRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetRoomSwitchListRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                RoomInfo[] roomInfoArr = this.rooms;
                int length = roomInfoArr == null ? 0 : roomInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                RoomInfo[] roomInfoArr2 = new RoomInfo[i3];
                if (length != 0) {
                    System.arraycopy(roomInfoArr, 0, roomInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    RoomInfo roomInfo = new RoomInfo();
                    roomInfoArr2[length] = roomInfo;
                    codedInputByteBufferNano.readMessage(roomInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                RoomInfo roomInfo2 = new RoomInfo();
                roomInfoArr2[length] = roomInfo2;
                codedInputByteBufferNano.readMessage(roomInfo2);
                this.rooms = roomInfoArr2;
            }
        }
    }
}
